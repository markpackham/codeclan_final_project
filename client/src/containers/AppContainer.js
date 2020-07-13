import React, { Component } from "react";
import MainFooter from "../components/sitewide/MainFooter";
import MainHeader from "../components/sitewide/MainHeader";
import CustomerList from "../components/customers/CustomerList";
import VenueTableGrid from "../components/venue_tables/VenueTableGrid";
import NavBar from "../components/sitewide/NavBar";
import Home from "../components/miscellaneous/Home";
import About from "../components/miscellaneous/About";
import ErrorPage from "../components/miscellaneous/ErrorPage";
import CustomerForm from "../components/customers/CustomerForm";
import ReservationForm from "../components/reservations/ReservationForm";
import SideBar from './SideBar';

import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

class AppContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      customers: [],
      venueTables: [],
    };

    this.handleCustomerSubmit = this.handleCustomerSubmit.bind(this);
  }

  componentDidMount() {
    const customersUrl = "http://localhost:8080/customers";

    fetch(customersUrl)
      .then((res) => res.json())
      .then((data) => this.setState({ customers: data }))
      .catch((err) => console.error(err));

    const venueTablesUrl = "http://localhost:8080/venue-tables";

    fetch(venueTablesUrl)
      .then((res) => res.json())
      .then((data) => this.setState({ venueTables: data }))
      .catch((err) => console.error(err));
  }

  handleCustomerSubmit(newCustomer) {
    const updatedCustomers = [...this.state.customers, newCustomer];
    this.setState({
        customers: updatedCustomers
    });
}

  render() {
    return (
      <div className="app-container">
        <Router>
          <React.Fragment>
            <MainHeader />
            <NavBar />
            <SideBar />
            <Switch>
              <Route exact path="/" render={() => <VenueTableGrid venueTables={this.state.venueTables} />} />
              <Route exact path="/new-reservation" component={ReservationForm} />
              <Route exact path="/customers" render={() => <CustomerList customers={this.state.customers} />} />
              <Route exact path="/about" component={About} />
              <Route component={ErrorPage} />
            </Switch>
            
            <MainFooter />
          </React.Fragment>
        </Router>
      </div>
    );
  }
}

export default AppContainer;
