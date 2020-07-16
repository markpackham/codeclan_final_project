import React, { Component } from "react";

class Customer extends Component {
  render() {
    return (
      <li className="customer">
        <h4>{this.props.children}</h4>
        <p>Name: {this.props.firstName} {this.props.lastName}</p>
        <p>Phone: {this.props.phone}</p>
        <p>Email: {this.props.email}</p>
        <p>Total Reservations: {this.props.reservations}</p>
      </li>
    );
  }
}

export default Customer;
