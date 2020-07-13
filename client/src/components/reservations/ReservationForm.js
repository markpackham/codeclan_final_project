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
{/*                     
                        <p>Duration</p>
                        <input
                            type="number"
                            id="duration"
                            min="1"
                            max="3"
                            step="0.5"
                            /> */}
                            <input type="submit" value="Create Reservation"/>
                    </form>
                
                

                <div className="tables">
                    <p>Tables</p>
                    <div className="tableButtons">
                        <div>Table 1</div>
                        <div>Table 2</div>
                        <div>Table 3</div>
                        <div>Table 4</div>
                        <div>Table 5</div>
                        <div>Table 6</div>
                        <div>Table 7</div>
                        <div>Table 8</div>
                        <div>Table 9</div>
                        <div>Table 10</div>
                    </div>
                    <p className="freeTables">Show all Free Tables</p>
                </div>

                <div className="newOrOldCutomerField">
                    <div className="exisitng customer">
                        <label
                            htmlFor="customers">Search existing customers:
                        </label>
                        <select name="customers" id="customers">
                        <option value="Blogs">Bloggs</option>
                        <option value="Smith">Smith</option>
                        </select>
                    </div>
                    <div className="NewButton">
                        <div>New</div>
                    </div>
                </div>

                <CustomerForm onCustomerSubmit={this.props.onCustomerSubmit} />

                <div className="buttonField">
                    <div className="buttonGroupOne">
                        <div className="save">Save</div>
                        <div className="cancel">Cancel Changes</div>
                    </div>
                    <div className="buttonGroupTwo">
                        <div className="arrived">Arrived</div>
                        <div className="delete">Delete</div>
                    </div>
                </div>
                

            </div>
        );
    }
}

export default ReservationForm;
