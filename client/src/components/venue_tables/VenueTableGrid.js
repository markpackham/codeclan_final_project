import React from 'react'
import VenueTable from './VenueTable';
import '../../styles/VenueTableGrid.css'

const VenueTableGrid = (props) => {
    const venueTableNodes = props.venueTables.map((venueTable, index) => {
        return <VenueTable key={index} venueTable={venueTable} availableTables={props.availableTables} />
    });

    return (
        <div className="venue-table-grid">
            {venueTableNodes}
        </div>
    );
}

export default VenueTableGrid;