import React, { Component } from 'react'
import Reservation from "./Reservation";

class ReservationList extends Component {
  
    render() {
        const reservationNodes = this.props.reservations.map((reservation, index) => {
            return (
                <Reservation
                    key={index}
                    customer={reservation.customer}
                    // table={reservation.venueTable}
                    start={reservation.start}
                    // end={reservation.end}
                    partySize={reservation.partySize}>
                    
                    </Reservation>
              
            )
        })
        return (
            <ul>
                {reservationNodes}
               <p>Reservation List</p>
            </ul>
        );
    }
}

export default ReservationList;
