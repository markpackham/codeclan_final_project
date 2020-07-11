import React, { Component } from 'react';
import MainFooter from '../components/sitewide/MainFooter';
import CustomerList from '../components/customers/CustomerList'


class AppContainer extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            customers: []
         };
    }
    render() {
        return (
            <React.Fragment>
            <MainFooter />
            <CustomerList customers={this.state.customers}/>
            </React.Fragment>
        );
    }
}

export default AppContainer;