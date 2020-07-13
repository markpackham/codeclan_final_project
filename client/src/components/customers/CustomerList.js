import React, { Component } from "react";
import Customer from "./Customer";

class CustomerList extends Component {
  render() {
    const customerNodes = this.props.customers.map((customer, index) => {
      return (
        <Customer
          key={index}
          firstName={customer.firstName}
          lastName={customer.lastName}
          phone={customer.phone}
          email={customer.email}>
        </Customer>
      );
    });

    return (
      <ul className="customer-list">
        {customerNodes}
        I am a Customer List
      </ul>
    );
  }
}

export default CustomerList;