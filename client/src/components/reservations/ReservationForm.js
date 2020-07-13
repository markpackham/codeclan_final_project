import React, { Component } from 'react'
import '../../styles/ReservationForm.css'
import CustomerForm from '../customers/CustomerForm';


class ReservationForm extends Component {
    constructor(props) {
        super(props);
        this.state = {  };
    }
    render() {
        return (
            <div className="reservationForm">
                <h1>Reservations</h1>
                
                    <div className="dateTime">
                        <p>Arrival</p>
                        <p>Saturday 01 Aug 2020</p>
                        <input
                            type="time"
                            id="time"
                            name="time"
                            min="18:00"
                            max="23:00"
                            />
                        <p>Guests</p>
                        <input
                            type="number"
                            id="number"
                            min="1"
                            max="10"
                            />
                    
                        <p>Duration</p>
                        <input
                            type="number"
                            id="duration"
                            min="1"
                            max="3"
                            step="0.5"
                            />
                    </div>
                
                

                <div className="tables">
                    <p>Tables</p>
                    <div className="tableButtons">
                        <div>Table 1</div>
                        <div>Table 2</div>
                        <div>Table 3</div>
                        <div>Table 4</div>
                        <div>Table 5</div>
                        <div>Table 6</div>
                        <div>Table 7</div>
                        <div>Table 8</div>
                        <div>Table 9</div>
                        <div>Table 10</div>
                    </div>
                    <p className="freeTables">Show all Free Tables</p>
                </div>

                <CustomerForm />

                {/* <div className="newOrOldCutomerField">
                    <div className="exisitng customer">
                        <label
                            for="customers">Search existing customers:
                        </label>
                        <select name="customers" id="customers">
                        <option value="Blogs">Bloggs</option>
                        <option value="Smith">Smith</option>
                        </select>
                    </div>
                    <div className="NewButton">
                        <div>New</div>
                    </div>
                </div>


                <div className="personalDetails">
                    <div className="name">
                        <p>Name:</p>
                        <input type="text" placeholder="Joe Bloggs"/>
                    </div>
                    <div className="telNo">
                        <p>Phone No:</p>
                        <input type="tel" placeholder="0131 34343 545"/>
                    </div>
                    <div className="email">
                        <p>Email:</p>
                        <input type="email" placeholder="joe.bloggs@gmail.com"/>
                    </div>
                </div> */}

                <div className="buttonField">
                    <div className="buttonGroupOne">
                        <div className="save">Save</div>
                        <div className="cancel">Cancel Changes</div>
                    </div>
                    <div className="buttonGroupTwo">
                        <div className="arrived">Arrived</div>
                        <div className="delete">Delete</div>
                    </div>
                </div>
                

            </div>
        );
    }
}

export default ReservationForm;
