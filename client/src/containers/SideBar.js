import React from "react";
import CalendarComponent from "../components/sitewide/CalendarComponent";
import ReservationList from "../components/reservations/ReservationList";
import moment from "moment";
import "../styles/SideBar.css";

class SideBar extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      selectedDay: moment().format().slice(0, 10),
      filteredReservations: [],
    };

    this.handleDaySelect = this.handleDaySelect.bind(this);
    this.sortByStartTime = this.sortByStartTime.bind(this);
  }

  handleDaySelect(day) {
    const selectedDay = moment(day).format().slice(0, 10);
    const allReservations = [...this.props.reservations];
    const filteredReservations = allReservations.filter((reservation) => {
      const reservationDay = moment(reservation.start).format().slice(0, 10);
      return reservationDay === selectedDay;
    });
    const sortedReservations = this.sortByStartTime(filteredReservations);
    this.setState({
      selectedDay: selectedDay,
      filteredReservations: sortedReservations,
    });
  }

  sortByStartTime(reservations) {
    return reservations.sort((a, b) => {
      const momentA = moment(a.start);
      const momentB = moment(b.start);
      if (moment(momentA).isBefore(momentB)) {
        return -1;
      }
      if (moment(momentB).isBefore(momentA)) {
        return 1;
      }
      return 0;
    });
  }

  render() {
    return (
      <div className="sidebar">
        <CalendarComponent
          className="sidebar-calendar"
          onDaySelect={this.handleDaySelect}
        />
        <ReservationList
          className="sidebar-res-list"
          reservations={this.state.filteredReservations}
        />
      </div>
    );
  }
}

export default SideBar;
