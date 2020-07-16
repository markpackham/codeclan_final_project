import React, { Component } from "react";
import Customer from "./Customer";
import '../../styles/CustomerList.css'

class CustomerList extends Component {
  render() {
    let customerNodesSort = this.props.customers.sort(this.props.customers.reservations);

    const customerNodes = customerNodesSort.map((customer, index) => {
      return (
        <Customer
          key={index}
          firstName={customer.firstName}
          lastName={customer.lastName}
          phone={customer.phone}
          email={customer.email}
          reservations={customer.reservations.length}>
        </Customer>
      );
    });
 

    return (
      <ul className="customer-list">
        <h2>Amount of customers that have provided their details: {this.props.customers.length}</h2>
        <h2>Our Top Customers:</h2>
        {customerNodes}
      </ul>
    );
  }
}

export default CustomerList;