import React, { Component } from 'react';
import '../../styles/ReservationDetail.css';
import moment from 'moment';

class Reservation extends Component {
    render() {
        const start = moment(this.props.reservation.start).format("HH:mm");
        const end = moment(this.props.reservation.end).format("HH:mm");

        return (
            <div className="reservation-container">
                <ul className="res-list">
                    <li>{start} - {end}</li>
                    <li>{this.props.reservation.customer.firstName} {this.props.reservation.customer.lastName}</li>
                    <li>{this.props.reservation.partySize} Guest(s) / Table {this.props.reservation.venueTable.id}</li>
                    {this.props.reservation.reservationNotes && <li className="italics">Notes: {this.props.reservation.reservationNotes}</li>}
                </ul>
            </div>
        )
    }
}

export default Reservation;