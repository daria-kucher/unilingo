import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import { BrowserRouter } from "react-router-dom";
import App from './App.jsx'
import LoginPage from "./pages/LoginPage.jsx";
import RegisterPage from "./pages/RegisterPage.jsx";
import {Header} from "./components/Header.jsx";
import "bootstrap/dist/js/bootstrap.bundle.min.js";
import {Footer} from "./components/Footer.jsx";
import HomePage from "./pages/HomePage.jsx";

createRoot(document.getElementById('root')).render(
  <StrictMode>
      <BrowserRouter>
          <HomePage />
      </BrowserRouter>
  </StrictMode>,
)
