import React, { Component } from "react";

class Customer extends Component {
  render() {
    return (
      <li className="customer">
        <h4>{this.props.children}</h4>
        <p>{this.props.firstName}</p>
        <p>{this.props.lastName}</p>
        <p>{this.props.phone}</p>
        <p>{this.props.email}</p>
      </li>
    );
  }
}

export default Customer;
