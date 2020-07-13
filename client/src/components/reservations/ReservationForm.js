import React, { Component } from 'react'
import '../../styles/ReservationForm.css'
import CustomerForm from '../customers/CustomerForm';


class ReservationForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            customer: null,
            venueTable: null,
            start: null,
            end: null,
            partySize: 1
        };

        this.handleStartChange = this.handleStartChange.bind(this);
        this.handleEndChange = this.handleEndChange.bind(this);
        this.handlePartySizeChange = this.handlePartySizeChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleStartChange(event) {
        this.setState({
            start: event.target.value
        });
    }

    handleEndChange(event) {
        this.setState({
            end: event.target.value
        });
    }

    handlePartySizeChange(event) {
        this.setState({
            partySize: event.target.value
        });
    }

    addReservation(reservation) {
        const url = 'http://localhost:8080/reservations';
        return fetch(url, {
            method: 'POST',
            body: JSON.stringify(reservation),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(res => res.json())
        .then(json => this.props.onReservationSubmit(json));
    }


    handleSubmit(event) {
        event.preventDefault();
        this.addReservation(this.state);
        this.setState({
            customer: null,
            venueTable: null,
            start: null,
            end: null,
            partySize: 1
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

        const venueTableOptions = this.props.venueTables.map(venueTable => {
            return (
                <option key={venueTable.id} value={venueTable.id}>
                    {`Table ${venueTable.id}: Seats ${venueTable.covers}`}
                </option>
            );
        });

        return (
            <div>
                <h1>Reservations</h1>
                
                    <form className="reservation-form" onSubmit={this.handleSubmit}>
                        
                        <input 
                            value={this.state.start}
                            type="datetime-local" 
                            onChange={this.handleStartChange}
                            required
                        />
           

                        <input 
                            value={this.state.end}
                            type="datetime-local" 
                            onChange={this.handleEndChange}
                            required
                        />  

                        <input
                            value={this.state.partySize}
                            type="number"
                            onChange={this.handlePartySizeChange}
                            required
                            />

                             <select>
                               {customerOptions}
                            </select>
                            
                            <CustomerForm onCustomerSubmit={this.props.onCustomerSubmit} />

                            <select>
                                {venueTableOptions}
                            </select>

                            <input type="submit" value="Create Reservation"/>
                    </form>

            </div>
        );
    }
}

export default ReservationForm;
