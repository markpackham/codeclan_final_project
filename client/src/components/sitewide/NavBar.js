import React from "react";
import { Link } from "react-router-dom";
import "../../styles/NavBar.css";
import capybara from "../../styles/assets/capybara.png";

const NavBar = () => (
  <div className="nav-bar">
    <ul>
      <li>
        <Link to="/">New Reservation</Link>
      </li>
      <li>
        <Link to="/customers">All Customers</Link>
      </li>
      <li>
        <Link to="/about">About</Link>
      </li>
    </ul>
    <img id="capybara-img" alt="capybara" src={capybara} />
  </div>
);

export default NavBar;
