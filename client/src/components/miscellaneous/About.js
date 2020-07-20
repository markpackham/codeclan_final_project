import React from "react";
import "../../styles/Miscellaneous.css";

const About = () => (
  <div className="about">
    <h1>Welcome to the Capybara Cafe booking app!</h1>
    <ul className="user-instructions">
      <h2>User Instructions:</h2>
      <li>
        To add a new customer navigate to the New Reservation page where you can
        fill in their details.
      </li>
      <li>
        To add a new reservation fill in the required details on the New
        Reservation page.{" "}
      </li>
      <li>To view all customers navigate to the All Customers page.</li>
      <li>
        On the New Reservation Page the circles represent tables and the number
        shows how many customers they can seat.
      </li>
      <li>
        On the left hand side of the page there is a calendar to help you keep a
        track of the days.
      </li>
    </ul>
    <div className="opening-block">
      <ul className="opening-times">
        <h2>Opening Times:</h2>
        <li>Monday: 10:00 - 00:00</li>
        <li>Tuesday: 10:00 - 00:00</li>
        <li>Wednesday:10:00 - 00:00</li>
        <li>Thursday: 10:00 - 00:00</li>
        <li>Friday: 10:00 - 01:00</li>
        <li>Saturday: 10:00 - 01:00</li>
        <li>Sunday: 10:00 - 00:00</li>
      </ul>

      <ul className="serving-times">
        <h2>Serving Times:</h2>
        <li>Monday: 10:00 - 22:00</li>
        <li>Tuesday: 10:00 - 22:00</li>
        <li>Wednesday:10:00 - 22:00</li>
        <li>Thursday: 10:00 - 22:00</li>
        <li>Friday: 10:00 - 23:00</li>
        <li>Saturday: 10:00 - 23:00</li>
        <li>Sunday: 10:00 - 22:00</li>
      </ul>
    </div>
    <ul className="venue-info">
      <h2>Venue Info:</h2>
      <li>General Manager: Jean Luke Picard</li>
      <li>Phone Number: 0131 123456</li>
      <li>Email: capybaraCafe.castleTerrace@Capybara.com</li>
      <li>Address: 37.5 Castle Terrace Edinburgh EH1 2EL</li>
    </ul>
  </div>
);

export default About;
