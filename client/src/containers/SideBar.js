import React from 'react';
import CalendarComponent from '../components/sitewide/CalendarComponent';
import ReservationList from '../components/reservations/ReservationList';


class SideBar extends React.Component {
    constructor(props) {
        super(props);
        this.state = {}
    }

    render() {
        return (
            <div className="sidebar">
                <CalendarComponent />
                <ReservationList reservations={this.props.reservations} />
            </div>
        )
    }
}

export default SideBar;