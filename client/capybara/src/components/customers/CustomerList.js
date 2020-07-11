import React, { Component } from "react";
import Customer from "./Customer";

class CustomerList extends Component {
  render() {
    const customerNodes = this.props.customers.map(customer => {
      return (
        <Customer author={customer.author} key={customer.id}>
          {customer.text}
        </Customer>
      );
    });

    return (
      <ul className="customer-list">
        {customerNodes}
      </ul>
    );
  }
}

export default CustomerList;
