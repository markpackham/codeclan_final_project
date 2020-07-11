import React, { Component } from 'react';
import MainFooter from '../components/sitewide/MainFooter';
import CustomerList from '../components/customers/CustomerList'
import CustomerForm from '../components/customers/CustomerForm';



class AppContainer extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            customers: [
            ]
         };

         this.handleCustomerSubmit = this.handleCustomerSubmit.bind(this);
    }

    handleCustomerSubmit(newCustomer) {
        const updatedCustomers = [...this.state.customers, newCustomer];
        this.setState({
            customers: updatedCustomers
        });
    }

    componentDidMount() {
        const customerUrl = 'http://localhost:8080/customers';
    
        fetch(customerUrl)
          .then(res => res.json())
          .then(customers => this.setState({ customers: customers }))
          .catch(err => console.error);
      }


    render() {
        return (
            <React.Fragment>
            <MainFooter />
            <h3>Create Customer</h3>
            <CustomerForm title="Create Customer" onCustomerSubmit={this.handleCustomerSubmit}/>
            <CustomerList customers={this.state.customers}/>
            </React.Fragment>
        );
    }
}

export default AppContainer;