import React, { Component } from "react";
import MainFooter from "../components/sitewide/MainFooter";
import MainHeader from "../components/sitewide/MainHeader";
import CustomerList from "../components/customers/CustomerList";
import VenueTableGrid from "../components/venue_tables/VenueTableGrid";
import NavBar from "../components/sitewide/NavBar";
import Home from "../components/miscellaneous/Home";
import About from "../components/miscellaneous/About";
import ErrorPage from "../components/miscellaneous/ErrorPage";
import CustomerForm from "../components/customers/CustomerForm"

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
            <Switch>
              <Route exact path="/" component={Home} />
              <Route exact path="/about" component={About} />
              <Route component={ErrorPage} />
            </Switch>
            <h3>Create Customer</h3>
            <CustomerForm title="Create Customer" onCustomerSubmit={this.handleCustomerSubmit}/>
            <CustomerList customers={this.state.customers} />
            <VenueTableGrid venueTables={this.state.venueTables} />
            <MainFooter />
          </React.Fragment>
        </Router>
      </div>
    );
  }
}

export default AppContainer;
