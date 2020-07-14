import React, { Component } from 'react';

class Reservation extends Component {
    render() {
        return (
            <ul>
                {this.props.customer.firstName}
                {this.props.venueTable}
                {this.props.start}
                {this.props.end}
                {this.props.partySize}
                
            </ul>
        )
    }
}

export default Reservation;
