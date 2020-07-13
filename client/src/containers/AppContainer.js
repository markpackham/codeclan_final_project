import React, { Component } from 'react';
import MainFooter from '../components/sitewide/MainFooter';
import MainHeader from '../components/sitewide/MainHeader';
import Main from './Main';
import SideBar from './SideBar';

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
            <MainHeader />
            <SideBar />
            <Main
              customers={this.state.customers}
              venueTables={this.state.venueTables} 
              onCustomerSubmit={this.handleCustomerSubmit}
            />
            <MainFooter />
      </div>
    );
  }
}

export default AppContainer;
