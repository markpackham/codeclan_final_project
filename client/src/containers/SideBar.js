import React from 'react';
import CalendarComponent from '../components/sitewide/CalendarComponent';

class SideBar extends React.Component {
    constructor(props) {
        super(props);
        this.state = {}
    }

    render() {
        return (
            <div className="sidebar">
                <CalendarComponent />
            </div>
        )
    }
}

export default SideBar;