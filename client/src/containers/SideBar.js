import React from 'react';
import CalendarComponent from '../components/sitewide/CalendarComponent';
import ReservationList from '../components/reservations/ReservationList';
import moment from 'moment';
import '../styles/SideBar.css';

class SideBar extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            selectedDay: moment().format().slice(0, 10),
            filteredReservations: []
        }

        this.handleDaySelect = this.handleDaySelect.bind(this);
    }

    handleDaySelect(day) {
        const selectedDay = moment(day).format().slice(0, 10);
        const allReservations = [...this.props.reservations];
        const filteredReservations = allReservations.filter(reservation => {
            const reservationDay = moment(reservation.start).format().slice(0, 10);
            return reservationDay === selectedDay;
        });
        this.setState({selectedDay: selectedDay, filteredReservations: filteredReservations})
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