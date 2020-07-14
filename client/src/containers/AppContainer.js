import React, { Component } from 'react';
import MainFooter from '../components/sitewide/MainFooter';
import MainHeader from '../components/sitewide/MainHeader';
import MainContainer from './MainContainer';
import SideBar from './SideBar';
import '../styles/AppContainer.css';

class AppContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      customers: [],
      venueTables: [],
      reservations: []
    };

    this.handleCustomerSubmit = this.handleCustomerSubmit.bind(this);
    this.handleReservationSubmit = this.handleReservationSubmit.bind(this);
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

    const reservationsUrl = "http://localhost:8080/reservations";
      fetch(reservationsUrl)
      .then((res) => res.json())
      .then((data) => this.setState({ reservations: data }))
      .catch((err) => console.error(err));
  }

  handleCustomerSubmit(newCustomer) {
    const updatedCustomers = [...this.state.customers, newCustomer];
    this.setState({
        customers: updatedCustomers
  });
}

  handleReservationSubmit(newReservation) {
    const updatedReservations = [...this.state.reservations, newReservation];
    this.setState({
      reservations: updatedReservations
  });
}

  render() {
    return (
      <div className="app-container">
            <MainHeader />
              <div className="screen">
                <SideBar reservations={this.state.reservations} />
                <MainContainer
                  customers={this.state.customers}
                  venueTables={this.state.venueTables} 
                  onCustomerSubmit={this.handleCustomerSubmit}
                  onReservationSubmit={this.handleReservationSubmit}
                />
              </div>
            <MainFooter />
      </div>
    );
  }
}

export default AppContainer;