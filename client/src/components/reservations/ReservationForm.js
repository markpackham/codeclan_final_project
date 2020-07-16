import React, { Component } from 'react'
import '../../styles/ReservationForm.css'
import CustomerForm from '../customers/CustomerForm';
import VenueTableGrid from '../venue_tables/VenueTableGrid';
import moment from 'moment';
import ReactModal from 'react-modal';

ReactModal.setAppElement('#root');

class ReservationForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            customer: "",
            venueTable: "",
            start: moment().format().slice(0, 16),
            end: "",
            partySize: "",
            duration: "",
            reservationNotes: "",
            availableTables: [],
            showModal: false
        };

        this.handleStartChange = this.handleStartChange.bind(this);
        this.handleDurationChange = this.handleDurationChange.bind(this);
        this.handlePartySizeChange = this.handlePartySizeChange.bind(this);
        this.handleCustomerSelect = this.handleCustomerSelect.bind(this);
        this.handleVenueTableSelect = this.handleVenueTableSelect.bind(this);
        this.handleReservationNotesChange = this.handleReservationNotesChange.bind(this);
        this.selectCustomerById = this.selectCustomerById.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.updateEnd = this.updateEnd.bind(this);
        this.handleOpenModal = this.handleOpenModal.bind(this);
        this.handleCloseModal = this.handleCloseModal.bind(this);
    }

    componentDidMount() {
        this.updateEnd();
    }

    handleStartChange(event) {     
        this.setState({
            start: event.target.value
        }, () => this.updateEnd());
    }

    handleDurationChange(event) {
        this.setState({
            duration: event.target.value
        }, () => this.updateEnd());
    }

    handlePartySizeChange(event) {
        this.setState({
            partySize: event.target.value,
        }, () => this.updateAvailableTables());
    }
    
    handleCustomerSelect(event) {
        this.setState({
            customer: event.target.value
        });
    }

    handleVenueTableSelect(event) {
        this.setState({
            venueTable: event.target.value
        });
    }

    handleReservationNotesChange(event) {
        this.setState({
            reservationNotes: event.target.value
        });
    }

    selectCustomerById(id) {
        this.setState({
            customer: `${id}`
        });
    }

    getCustomerById(id) {
        return this.props.customers.find(customer => customer.id === id);
    }

    getVenueTableById(id) {
        return this.props.venueTables.find(venueTable => venueTable.id === id);
    }

    addReservation() {
        const url = 'http://localhost:8080/reservations';
        const selectedCustomer = this.getCustomerById(parseInt(this.state.customer));
        const selectedVenueTable = this.getVenueTableById(parseInt(this.state.venueTable));
        const newReservation = {
            customer: selectedCustomer,
            venueTable: selectedVenueTable,
            start: this.state.start,
            end: this.state.end,
            partySize: this.state.partySize,
            reservationNotes: this.state.reservationNotes
        };
        
        return fetch(url, {
            method: 'POST',
            body: JSON.stringify(newReservation),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(res => res.json())
        .then(() => this.props.onReservationSubmit());
    }

    handleSubmit(event) {
        event.preventDefault();
        this.addReservation();
        this.setState({
            customer: "",
            venueTable: "",
            start: moment().format().slice(0, 16),
            end: "",
            partySize: "",
            duration: "",
            reservationNotes: "",
            availableTables: [],
            showModal: false
        }, () => this.updateEnd());
    }

    updateEnd() {
        const startMoment = moment(this.state.start);
        const endMoment = startMoment.add(this.state.duration, 'hours');
        const newEnd = endMoment.format().slice(0, 16);
        this.setState({
            end: newEnd
        }, () => this.updateAvailableTables());
        
    }

    updateAvailableTables() {
        const allTables = [...this.props.venueTables];
        const availableTables = allTables.filter(table => {
            return (table.covers >= this.state.partySize) && this.checkTableAvailable(table)
        });
        this.setState({
            availableTables: availableTables,
            venueTable: ""
        });
    }

    checkTimeAvailable(reservation) {
        const startMoment = moment(this.state.start);
        const endMoment = moment(this.state.end);
        const reservationStart = moment(reservation.start);
        const reservationEnd = moment(reservation.end);
        if (startMoment.isBetween(reservationStart, reservationEnd, undefined, '[)')) {
            return false;
        }
        if (endMoment.isBetween(reservationStart, reservationEnd, undefined, '(]')) {
            return false;
        }
        return true;
    }

    checkTableAvailable(venueTable) {
        const reservations = venueTable.reservations;
        return reservations.every(reservation => this.checkTimeAvailable(reservation));
    }

    handleOpenModal() {
        this.setState({showModal: true});
    }

    handleCloseModal() {
        this.setState({showModal: false});
    }

    render() {
        const customerOptions = this.props.customers.map(customer => {
            return (
                <option key={customer.id} value={customer.id}>
                    {customer.firstName + " " + customer.lastName}
                </option>
            );
        });

        const venueTableOptions = this.state.availableTables.map(venueTable => {
            return (
                <option key={venueTable.id} value={venueTable.id}>
                    {`Table ${venueTable.id}: Seats ${venueTable.covers}`}
                </option>
            );
        });

        return (
            <>
            <div className="reservation-form">
                <div className="new-reservation">
                    <h2>New Reservation</h2>
                    <form className="reservation-form" onSubmit={this.handleSubmit}>
                        <table>
                            <tbody>
                                <tr>
                                    <th><label htmlFor="datetime">Date & Time</label></th>
                                    <td><input
                                        name="datetime"
                                        type="datetime-local" 
                                        value={this.state.start}
                                        onChange={this.handleStartChange}
                                        required
                                    /></td>
                                </tr>

                                <tr>
                                    <th><label htmlFor="duration">Duration</label></th>
                                    <td><input
                                        name="duration"
                                        type="number"
                                        value={this.state.duration}
                                        onChange={this.handleDurationChange}
                                        required
                                        min="1"
                                    /> hour(s)</td>
                                </tr>

                                <tr>
                                    <th><label htmlFor="party-size">Party Size</label></th>
                                    <td><input
                                        name="party-size"
                                        type="number"
                                        value={this.state.partySize}
                                        onChange={this.handlePartySizeChange}
                                        required
                                        min="1"
                                    /></td>
                                </tr>

                                <tr>
                                    <th><label htmlFor="customer">Customer</label></th>
                                    <td><select
                                        name="customer"
                                        value={this.state.customer}
                                        onChange={this.handleCustomerSelect}
                                        required
                                    >
                                        <option value="" disabled>Please Select</option>
                                        {customerOptions}
                                    </select>
                                    <button onClick={this.handleOpenModal}>New</button>
                                    </td>
                                </tr>

                                <tr>
                                    <th><label htmlFor="venue-table">Table</label></th>
                                    <td><select
                                        name="venue-table"
                                        value={this.state.venueTable}
                                        onChange={this.handleVenueTableSelect}
                                        required
                                    >   
                                        <option value="" disabled>Please Select</option>
                                        {venueTableOptions}
                                    </select></td>
                                </tr>

                                <tr>
                                    <th><label htmlFor="Reservation Notes">Reservation Notes</label></th>
                                    <td><input
                                        name="Reservation Notes"
                                        type="text"
                                        value={this.state.reservationNotes}
                                        onChange={this.handleReservationNotesChange}
                                    /></td>
                                </tr>
                                <tr><td colSpan="2"><input type="submit" value="Create Reservation"/></td></tr>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
            <VenueTableGrid venueTables={this.props.venueTables} availableTables={this.state.availableTables} />

            <ReactModal isOpen={this.state.showModal} contentLabel="Customer Form" className="modal">
                <CustomerForm
                    onCustomerSubmit={this.props.onCustomerSubmit}
                    selectCustomerById={this.selectCustomerById}
                    closeModal={this.handleCloseModal}
                />
            </ReactModal>

            </>
        );
    }
}

export default ReservationForm;