import React, { Component } from "react";
import Calendar from "react-calendar";
import "../../styles/CalendarComponent.css";
import "react-calendar/dist/Calendar.css";

class CalendarComponent extends Component {
  onChange = (date) => this.props.onDaySelect(date);

  render() {
    return (
      <div className="calendar">
        <Calendar onChange={this.onChange} />
      </div>
    );
  }
}

export default CalendarComponent;
