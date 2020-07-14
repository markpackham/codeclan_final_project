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
            availableTables: []
        };

        this.handleStartChange = this.handleStartChange.bind(this);
        this.handleDurationChange = this.handleDurationChange.bind(this);
        this.handlePartySizeChange = this.handlePartySizeChange.bind(this);
        this.handleCustomerSelect = this.handleCustomerSelect.bind(this);
        this.handleVenueTableSelect = this.handleVenueTableSelect.bind(this);
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
            partySize: this.state.partySize
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
            partySize: 1
        });
    }

    updateEnd() {
        const startMoment = moment(this.state.start);
        const endMoment = startMoment.add(this.state.duration, 'hours');
        const newEnd = endMoment.format().slice(0, 16);
        this.setState({
            end: newEnd
        });
    }

    updateAvailableTables() {
        const availableTables = [...this.props.venueTables];
        const newAvailableTables = availableTables.filter(table => table.covers >= this.state.partySize);
        this.setState({
            availableTables: newAvailableTables
        });
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
                    <input
                        type="datetime-local" 
                        value={this.state.start}
                        onChange={this.handleStartChange}
                        required
                    />

                    <input
                        type="number"
                        value={this.state.duration}
                        onChange={this.handleDurationChange}
                        required
                    />  

                    <input
                        type="number"
                        value={this.state.partySize}
                        onChange={this.handlePartySizeChange}
                        required
                    />

                    <select
                        value={this.state.customer}
                        onChange={this.handleCustomerSelect}
                    >{customerOptions}</select>

                    <select
                        value={this.state.venueTable}
                        onChange={this.handleVenueTableSelect}
                    >{venueTableOptions}</select>
                    
                    <input type="submit" value="Create Reservation"/>
                </form>
            </div>
        );
    }
}

export default ReservationForm;