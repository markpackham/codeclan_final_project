import React from 'react';
import CalendarComponent from '../components/sitewide/CalendarComponent';
import ReservationList from '../components/reservations/ReservationList';
import moment from 'moment';
import '../styles/SideBar.css';

class SideBar extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            date: new Date(),
            selectedDay: '',
            filteredReservations: []
        }

        this.handleDaySelect = this.handleDaySelect.bind(this);
    }
    
    handleDaySelect(date) {
        const selectedDay = moment(date).format().slice(0, 10);
        const allReservations = [...this.props.reservations];
        const filteredReservations = allReservations.filter(reservation => {
            const reservationDay = moment(reservation.start).format().slice(0, 10);
            return reservationDay === selectedDay;
        });
        this.setState({selectedDay: date, filteredReservations: filteredReservations})
    }

    render() {
        return (
            <div className="sidebar">
                <CalendarComponent className="sidebar-calendar"  onDaySelect={this.handleDaySelect} />
                <ReservationList className="sidebar-res-list" reservations={this.state.filteredReservations} />
            </div>
        )
    }
}

export default SideBar;