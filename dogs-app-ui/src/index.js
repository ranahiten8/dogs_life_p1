import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

import Einstein from "./images/1.jpeg";
import Kaya from "./images/2.jpeg";
import Lassie from "./images/3.jpeg";
import { BrowserRouter } from 'react-router-dom';

const images = {
  Einstein,
  Kaya,
  Lassie
}
export default images;

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
