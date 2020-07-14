import React, { Component } from 'react'
import '../../styles/ReservationForm.css'
import CustomerForm from '../customers/CustomerForm';
import moment from 'moment';


class ReservationForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            customer: "",
            venueTable: "",
            start: "",
            end: "",
            partySize: 1,
            duration: 2,
            reservationNotes: "",
            availableTables: []
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
            customer: id
        });
    }

    addReservation() {
        const url = 'http://localhost:8080/reservations';
        const newReservation = {
            customer: {id: this.state.customer},
            venueTable: {id: this.state.venueTable},
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
        .then(json => this.props.onReservationSubmit(json));
    }

    handleSubmit(event) {
        event.preventDefault();
        this.addReservation();
        this.setState({
            customer: "",
            venueTable: "",
            start: "",
            end: "",
            partySize: 1,
            reservationNotes: ""
        });
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
        const availableTables = [...this.props.venueTables];
        const newAvailableTables = availableTables.filter(table => {
            return (table.covers >= this.state.partySize) && this.checkTableAvailable(table)
        });
        this.setState({
            availableTables: newAvailableTables
        });
    }

    checkTimeAvailable(reservation) {
        const startMoment = moment(this.state.start);
        const endMoment = moment(this.state.end);
        const reservationStart = moment(reservation.start);
        const reservationEnd = moment(reservation.end);
        if (reservationStart.isBetween(startMoment, endMoment)) {
            return false;
        }
        if (reservationEnd.isBetween(startMoment, endMoment)) {
            return false;
        }
        return true;
    }

    checkTableAvailable(venueTable) {
        const reservations = venueTable.reservations;
        if (reservations.length === 0) {
            return true;
        }
        for (const reservation of reservations) {
            if (this.checkTimeAvailable(reservation)) {
                return true;
            }
        }
        return false;
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
            <div>
                <h1>New Customer</h1>
                <CustomerForm onCustomerSubmit={this.props.onCustomerSubmit} selectCustomerById={this.selectCustomerById} />
                <h1>New Reservation</h1>
                <form className="reservation-form" onSubmit={this.handleSubmit}>
                    <label htmlFor="Reservation Date">Reservation Date:</label>
                    <input
                        name="Reservation Date"
                        type="datetime-local" 
                        value={this.state.start}
                        onChange={this.handleStartChange}
                        required
                    />

                    <label htmlFor="Duration">Duration:</label>
                    <input
                        name="Duration"
                        type="number"
                        value={this.state.duration}
                        onChange={this.handleDurationChange}
                        required
                        min="1"
                    />  

                    <label htmlFor="Party Size">Party Size:</label>
                    <input
                        name="Party Size"
                        type="number"
                        value={this.state.partySize}
                        onChange={this.handlePartySizeChange}
                        required
                        min="1"
                    />

                    <label htmlFor="Customer">Customer:</label>
                    <select
                        name="Customer"
                        value={this.state.customer}
                        onChange={this.handleCustomerSelect}
                    >{customerOptions}</select>

                    <label htmlFor="Venue Table">Table:</label>
                    <select
                        name="Venue Table"
                        value={this.state.venueTable}
                        onChange={this.handleVenueTableSelect}
                    >{venueTableOptions}</select>

                    <label htmlFor="Reservation Notes">Reservation Notes:</label>
                    <input
                        name="Reservation Notes"
                        type="text"
                        value={this.state.reservationNotes}
                        onChange={this.handleReservationNotesChange}
                    />
                    
                    <input type="submit" value="Create Reservation"/>
                </form>
            </div>
        );
    }
}

export default ReservationForm;