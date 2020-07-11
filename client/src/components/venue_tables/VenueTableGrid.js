import React from 'react'
import VenueTable from './VenueTable';

const VenueTableGrid = (props) => {
    const venueTableNodes = props.venueTables.map((venueTable, index) => {
        return <VenueTable key={index} venueTable={venueTable} />
    });

    return (
        <div className="venue-table-grid">
            <h2>All Tables</h2>
            {venueTableNodes}
        </div>
    );
}

export default VenueTableGrid;