import React, { Component } from 'react';
import MainFooter from '../components/sitewide/MainFooter';
import CustomerList from '../components/customers/CustomerList';
import VenueTableGrid from '../components/venue_tables/VenueTableGrid';

class AppContainer extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            customers: [],
            venueTables: []
         };
    }

    componentDidMount() {
        const customersUrl = 'http://localhost:8080/customers';
    
        fetch(customersUrl)
          .then(res => res.json())
          .then(data => this.setState({ customers: data }))
          .catch(err => console.error(err));

        const venueTablesUrl = 'http://localhost:8080/venue-tables';

        fetch(venueTablesUrl)
          .then(res => res.json())
          .then(data => this.setState({ venueTables: data }))
          .catch(err => console.error(err));
    }

    render() {
        return (
            <div className="app-container">
                <CustomerList customers={this.state.customers}/>
                <VenueTableGrid />
                <MainFooter />
            </div>
        );
    }
}

export default AppContainer;