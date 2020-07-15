import React, { Component } from "react";
import Customer from "./Customer";
import '../../styles/CustomerList.css'

class CustomerList extends Component {
  render() {
    let customerNodesReverse = this.props.customers.reverse();
    const customerNodes = customerNodesReverse.map((customer, index) => {
      return (
        <Customer
          key={index}
          firstName={customer.firstName}
          lastName={customer.lastName}
          phone={customer.phone}
          email={customer.email}
            id={customer.id}>
        </Customer>
      );
    });

    const sortedCustomers = [].concat(this.props.CustomerList)
    .sort((a, b) => a.index > b.index ? 1 : -1)
    

    return (
      <ul className="customer-list">
        <h2>Amount of customers that have provided their details: {this.props.customers.length}</h2>
        {customerNodes}
      </ul>
    );
  }
}

export default CustomerList;