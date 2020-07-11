import React from 'react';
import '../../styles/VenueTable.css'

const VenueTable = (props) => {
    return (
        <div className="venue-table">
            <h1>{props.venueTable.covers}</h1>
        </div>
    );
}

export default VenueTable;