import React from 'react';
import Calendar from '../components/sitewide/Calendar';

class SideBar extends React.Component {
    constructor(props) {
        super(props);
        this.state = {}
    }

    render() {
        return <Calendar />;
    }
}

export default SideBar;