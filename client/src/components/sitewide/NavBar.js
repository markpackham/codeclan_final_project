import React from "react";
import { Link } from "react-router-dom";
import '../../styles/NavBar.css'

const NavBar = () => (
  <ul>
    <li>
      <Link to="/">Home</Link>
    </li>
    <li>
      <Link to="/about">About</Link>
    </li>
    <li>
      <Link to="/ReservationForm">NEW RESERVATION</Link>
    </li>
  </ul>
);

export default NavBar;