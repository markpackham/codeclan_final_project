import React from "react";
import { Link } from "react-router-dom";
import '../../styles/NavBar.css'

const NavBar = () => (
  <ul>
    <li>
      <Link to="/">Home</Link>
    </li>
    <li>
      <Link to="/new-reservation">NEW RESERVATION</Link>
    </li>
    <li>
      <Link to="/customers">Customers</Link>
    </li>
    <li>
      <Link to="/about">About</Link>
    </li>
  </ul>
);

export default NavBar;