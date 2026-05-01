import "bootstrap/dist/css/bootstrap.min.css";
import logoImg from "../assets/images/logo.jpg";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import "../styles/Header.css"

export function Header({isAuthenticated = false, onLogout}) {
    const [darkMode, setDarkMode] = useState(false);

    useEffect(() => {
        const savedTheme = localStorage.getItem("theme");

        if (savedTheme) {
            const isDark = savedTheme === "dark";
            setDarkMode(isDark);
            document.documentElement.setAttribute(
                "data-theme",
                isDark ? "dark" : "light"
            );
        } else {
            const prefersDark = window.matchMedia("(prefers-color-scheme: dark)").matches;
            setDarkMode(prefersDark);
            document.documentElement.setAttribute(
                "data-theme",
                prefersDark ? "dark" : "light"
            );
        }
    }, []);

    const toggleTheme = () => {
        const newTheme = !darkMode;
        setDarkMode(newTheme);

        document.documentElement.setAttribute(
            "data-theme",
            newTheme ? "dark" : "light"
        );

        localStorage.setItem("theme", newTheme ? "dark" : "light");
    };

    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-primary shadow-sm px-3">

            {/* LOGO */}
            <Link to="/" className="navbar-brand d-flex align-items-center">
                <img src={logoImg} alt="UniLingo" className="logo-img" />
                <span className="fw-bold">UniLingo</span>
            </Link>

            <button
                className="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarNav"
            >
                <span className="navbar-toggler-icon"></span>
            </button>

            <div className="collapse navbar-collapse" id="navbarNav">

                {/* NAV */}
                <ul className="navbar-nav me-auto">

                    {/* Language */}
                    <li className="nav-item dropdown">
                        <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">
                            Language
                        </a>
                        <ul className="dropdown-menu custom-dropdown">
                            <li>
                                <Link className="dropdown-item" to="/languages-english">English</Link>
                            </li>
                        </ul>
                    </li>

                    {/* Courses */}
                    <li className="nav-item dropdown">
                        <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">
                            Courses
                        </a>
                        <ul className="dropdown-menu custom-dropdown">
                            <li>
                                <Link className="dropdown-item" to="/course-general">General</Link>
                            </li>
                        </ul>
                    </li>

                    {/* For Teachers */}
                    <li className="nav-item">
                        <Link className="nav-link" to="/for-teachers">For Teachers</Link>
                    </li>

                    {/* Why UniLingo */}
                    <li className="nav-item dropdown">
                        <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">
                            Why UniLingo
                        </a>
                        <ul className="dropdown-menu custom-dropdown">
                            <li><Link className="dropdown-item" to="/who-we-are">Who are we</Link></li>
                            <li><Link className="dropdown-item" to="/benefits">Benefits</Link></li>
                            <li><Link className="dropdown-item" to="/educational-principles">Educational principles</Link></li>
                        </ul>
                    </li>

                    {/* Resources */}
                    <li className="nav-item dropdown">
                        <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">
                            Resources
                        </a>
                        <ul className="dropdown-menu custom-dropdown">
                            <li>
                                <Link className="dropdown-item" to="/proficiency-test">
                                    English proficiency test
                                </Link>
                            </li>
                        </ul>
                    </li>
                </ul>

                {/* RIGHT SIDE */}
                <div className="d-flex gap-2">

                    {/* THEME SWITCH */}
                    <div className="theme-switch">
                        <input
                            type="checkbox"
                            id="theme-toggle"
                            checked={darkMode}
                            onChange={toggleTheme}
                        />
                        <label htmlFor="theme-toggle" className="switch-label">
                            <span className="icon sun">☀️</span>
                            <span className="icon moon">🌙</span>
                            <span className="ball"></span>
                        </label>
                    </div>

                    {!isAuthenticated ? (
                        <>
                            <Link to="/register" className="btn btn-outline-light custom-btn">
                                Register
                            </Link>
                            <Link to="/login" className="btn btn-light text-primary custom-btn">
                                Log in
                            </Link>
                        </>
                    ) : (
                        <button className="btn btn-danger custom-btn" onClick={onLogout}>
                            Log out
                        </button>
                    )}
                </div>
            </div>
        </nav>
    );
}
