import React, { Component } from 'react'

class CustomerForm extends Component {

    constructor(props) {
        super(props);
        this.state= {
            firstName: '',
            lastName: '',
            phone: '',
            email: ''
        }

        this.handleFirstNameChange = this.handleFirstNameChange.bind(this);
        this.handleLastNameChange = this.handleLastNameChange.bind(this);
        this.handlePhoneChange = this.handlePhoneChange.bind(this);
        this.handleEmailChange = this.handleEmailChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }


    handleSubmit(event) {
        event.preventDefault();
        const firstName = this.state.firstName.trim();
        const lastName = this.state.lastName.trim();
        const phone = this.state.phone.trim();
        const email = this.state.email;
        if (!firstName || !lastName || !phone || !email) {
            return
        }

        this.props.onCustomerSubmit({
            firstName: firstName,
            lastName: lastName,
            phone: phone,
            email: email
            });

            this.setState({
                firstName: '',
                lastName: '',
                phone: '',
                email: ''
            });
    }

    handleFirstNameChange(event) {
        this.setState({
            firstName: event.target.value
        });
    }

    handleLastNameChange(event) {
        this.setState({
            lastName: event.target.value
        });
    }

    handlePhoneChange(event) {
        this.setState({
            phone: event.target.value
        });
    }

    handleEmailChange(event) {
        this.setState({
            email: event.target.value
        });
    }

    render() {
        return (
            <form className="customer-form" onSubmit={this.handleSubmit}>
                <input
                    type="text"
                    placeholder="First Name"
                    value={this.state.firstName}
                    onChange={this.handleFirstNameChange}
                /> 
                <input
                    type="text"
                    placeholder="Surname"
                    value={this.state.lastName}
                    onChange={this.handleLastNameChange}
                /> 
                <input
                    type="text"
                    placeholder="Phone number"
                    value={this.state.phone}
                    onChange={this.handlePhoneChange}
                /> 
                <input
                    type="text"
                    placeholder="E-mail"
                    value={this.state.email}
                    onChange={this.handleEmailChange}
                />  
                <input type="submit" value="Create"/>
            </form>
        )
    }
}

export default CustomerForm;