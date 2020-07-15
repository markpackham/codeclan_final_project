import React from "react";
import { Link } from "react-router-dom";
import '../../styles/NavBar.css'

const NavBar = () => (
  <div className="nav-bar">
    <ul>
      <li><Link to="/">New Reservation</Link></li>
      <li><Link to="/customers">All Customers</Link></li>
      <li><Link to="/about">About</Link></li>
    </ul>
  </div>
);

export default NavBar;