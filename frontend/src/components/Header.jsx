import "bootstrap/dist/css/bootstrap.min.css";
import logoImg from "../assets/images/logo.jpg";
import { Link } from "react-router-dom";
import "../styles/Header.css"

export function Header({isAuthenticated = false, onLogout}) {
    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-primary shadow-sm px-3">
            <a className="navbar-brand d-flex align-items-center" href="#">
                <img
                    src={logoImg}
                    alt="UniLingo"
                    className="logo-img"

                />
                <span className="fw-bold">UniLingo</span>
            </a>

            <button
                className="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarNav"
            >
                <span className="navbar-toggler-icon"></span>
            </button>

            <div className="collapse navbar-collapse" id="navbarNav">
                <ul className="navbar-nav me-auto">
                    <li className="nav-item dropdown">
                        <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">
                            Language
                        </a>
                        <ul className="dropdown-menu custom-dropdown">
                            <li><a className="dropdown-item" href="#">English</a></li>
                        </ul>
                    </li>

                    <li className="nav-item dropdown">
                        <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">
                            Courses
                        </a>
                        <ul className="dropdown-menu custom-dropdown">
                            <li><a className="dropdown-item" href="#">General</a></li>
                        </ul>
                    </li>

                    <li className="nav-item">
                        <a className="nav-link" href="#">For Teachers</a>
                    </li>

                    <li className="nav-item dropdown">
                        <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">
                            Why UniLingo
                        </a>
                        <ul className="dropdown-menu custom-dropdown">
                            <li><a className="dropdown-item" href="#">Who are we</a></li>
                            <li><a className="dropdown-item" href="#">Benefits</a></li>
                            <li><a className="dropdown-item" href="#">Educational principles</a></li>
                        </ul>
                    </li>

                    <li className="nav-item dropdown">
                        <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">
                            Resources
                        </a>
                        <ul className="dropdown-menu custom-dropdown">
                            <li><a className="dropdown-item" href="#">English proficiency test</a></li>
                        </ul>
                    </li>
                </ul>

                <div className="d-flex gap-2">
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
