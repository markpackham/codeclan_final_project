import React, { Component } from "react";

class Customer extends Component {
  constructor(props) {
    super(props);
    this.deleteCustomer = this.deleteCustomer.bind();
  }

  deleteCustomer(id) {
    const customerDeleteUrl = "http://localhost:8080/customers/";
    return fetch(customerDeleteUrl + id, {
      method: "delete",
    })
      .then((response) => response.json())
      .then(window.location.reload(false));
  }

  render() {
    return (
      <li className="customer">
        <h4>{this.props.children}</h4>
        <p>
          Name: {this.props.firstName} {this.props.lastName}
        </p>
        <p>Phone: {this.props.phone}</p>
        <p>Email: {this.props.email}</p>
        <p>Total Reservations: {this.props.reservations}</p>
        <button
          onClick={() => this.deleteCustomer(this.props.id)}
          className="btn-delete"
        >
          Delete
        </button>
      </li>
    );
  }
}

export default Customer;
