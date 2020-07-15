import React from "react";
import '../../styles/Miscellaneous.css';
import CapybaraImage from './capybaraimage.png';

const ErrorPage = ()=> (
  <div className="error-page">
  <h1>404 - CAPYBARA NOT FOUND</h1>
  <img src={CapybaraImage} width="35%" height="35%" alt="Capybara!" class="center"/>
  </div>
)

export default ErrorPage