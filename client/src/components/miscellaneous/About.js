import React from "react";
import '../../styles/Miscellaneous.css';

const About = () => (
    <div className="about">
      <h1>Welcome to the Capybara Cafe booking app!</h1>
      <h2>User Instructions:</h2>
      <ul>
      <li>To add a new customer navigate to the New Reservation page where you can fill in their details.</li>
      <li>To add a new reservation fill in the required details on the New Reservation page. </li>
      <li>To view all customers navigate to the All Customers page.</li>
      <li>On the New Reservation Page the circles represent tables and the number shows how many customers they can seat.</li>
      <li>On the left hand side of the page there is a calendar to help you keep a track of the days.</li>
      </ul>
    </div>
  );
  
  export default About;