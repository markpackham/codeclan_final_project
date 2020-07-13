import React from 'react';
import CustomerList from '../components/customers/CustomerList';
import VenueTableGrid from '../components/venue_tables/VenueTableGrid';
import About from '../components/miscellaneous/About';
import ErrorPage from '../components/miscellaneous/ErrorPage';
import ReservationForm from '../components/reservations/ReservationForm';
import NavBar from '../components/sitewide/NavBar';

import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

const Main = (props) => {
    return (
        <div className="app-container">
            <Router>
                <React.Fragment>
                    <NavBar />
                    <Switch>
                        <Route exact path="/" render={() => <VenueTableGrid venueTables={props.venueTables} />} />
                        <Route exact path="/new-reservation" render={() => <ReservationForm onCustomerSubmit={props.onCustomerSubmit} />} />
                        <Route exact path="/customers" render={() => <CustomerList customers={props.customers} />} />
                        <Route exact path="/about" component={About} />
                        <Route component={ErrorPage} />
                    </Switch>
                </React.Fragment>
            </Router>
        </div>
    );
}

export default Main;