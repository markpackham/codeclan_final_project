import React, { Component } from 'react';
import MainFooter from '../components/sitewide/MainFooter';

class AppContainer extends Component {
    constructor(props) {
        super(props);
        this.state = {  };
    }
    render() {
        return (
            <React.Fragment>
            <MainFooter />
            </React.Fragment>
        );
    }
}

export default AppContainer;