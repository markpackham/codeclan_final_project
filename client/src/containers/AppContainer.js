import React, { Component } from 'react';
import MainFooter from '../components/sitewide/MainFooter';
import MainHeader from '../components/sitewide/MainHeader';
import CustomerList from '../components/customers/CustomerList';
import VenueTableGrid from '../components/venue_tables/VenueTableGrid';
import NavBar from "../components/sitewide/NavBar";
import Home from "../components/miscellaneous/Home";
import About from "../components/miscellaneous/About";
import ErrorPage from "../components/miscellaneous/ErrorPage";

import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

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
                <Router>
                <React.Fragment>
                <MainHeader />
                <NavBar />
                <Switch>
                <Route exact path="/" component={Home} />
                <Route path="/about" component={About} />
                <CustomerList customers={this.state.customers} />
                <VenueTableGrid venueTables={this.state.venueTables} />
                <MainFooter />
                <Route component={ErrorPage}/>
                </Switch>
                </React.Fragment>
                </Router>
            </div>
        );
    }
}

export default AppContainer;