import React, { Component } from "react";
import MainFooter from "../components/sitewide/MainFooter";
import MainContainer from "./MainContainer";
import SideBar from "./SideBar";
import "../styles/AppContainer.css";

class AppContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      customers: [],
      venueTables: [],
      reservations: [],
    };

    this.fetchData = this.fetchData.bind(this);
  }

  fetchData() {
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

  componentDidMount() {
    this.fetchData();
  }

  render() {
    return (
      <div className="app-container">
        <div className="screen">
          <SideBar reservations={this.state.reservations} />
          <MainContainer
            customers={this.state.customers}
            venueTables={this.state.venueTables}
            onCustomerSubmit={this.fetchData}
            onReservationSubmit={this.fetchData}
          />
        </div>
        <MainFooter />
      </div>
    );
  }
}

export default AppContainer;
