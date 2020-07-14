import React, { Component } from 'react'
import Reservation from "./Reservation";

class ReservationList extends Component {
  
    render() {
        const reservationNodes = this.props.reservations.map((reservation, index) => {
            return (
                <Reservation
                    key={index}
                    reservation={reservation}
                   
                >
                    
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
