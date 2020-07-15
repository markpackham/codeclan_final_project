import React, { Component } from 'react';
import '../../styles/ReservationDetail.css';

class Reservation extends Component {
    render() {
        return (

            <div className="reservation-container">
                <ul className="res-list">
                    <li>{this.props.reservation.customer.firstName} {this.props.reservation.customer.lastName}</li>
                    <li> Table No: {this.props.reservation.venueTable.id}</li>
                    <li>{this.props.reservation.start}</li>
                    <li> Party Size: {this.props.reservation.partySize}</li>
                </ul>
            </div>
           
        )
    }
}

export default Reservation;
