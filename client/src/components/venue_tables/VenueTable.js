import React from "react";
import "../../styles/VenueTable.css";

const VenueTable = ({ venueTable, availableTables }) => {
  const checkAvailable = () => {
    if (availableTables.includes(venueTable)) {
      return "";
    }
    return " unavailable";
  };

  return (
    <div className={"venue-table" + checkAvailable()}>
      <p id="table-number">{`Table ${venueTable.id}`}</p>
      <p id="covers">{`Seats ${venueTable.covers}`}</p>
    </div>
  );
};

export default VenueTable;
