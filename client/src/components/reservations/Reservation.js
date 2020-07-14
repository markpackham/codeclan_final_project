import React, { Component } from 'react';

class Reservation extends Component {
    render() {
        return (
            <ul className="res-list">
                <li>{this.props.reservation.customer.firstName}</li>
                <li> Table No: {this.props.reservation.venueTable.id}</li>
                <li>{this.props.reservation.start}</li>
                <li> Party Size:{this.props.reservation.partySize}</li>
            </ul>
           
        )
    }
}

export default Reservation;
