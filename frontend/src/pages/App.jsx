import { BrowserRouter, Routes, Route } from "react-router-dom";
//import LoginPage from "../pages/LoginPage";
import LoginPage from "./LoginPage.jsx";
import HomePage from "./HomePage.jsx";
//import HomePage from "../pages/HomePage";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<HomePage />} />
                <Route path="/login" element={<LoginPage />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;