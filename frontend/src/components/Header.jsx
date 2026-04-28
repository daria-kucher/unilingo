import "bootstrap/dist/css/bootstrap.min.css";
import logoImg from "../assets/images/logo.jpg";
import { Link } from "react-router-dom";

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

            <style>{`
        .navbar .nav-link {
          transition: all 0.3s ease;
        }
        .navbar .nav-link:hover {
          color: #cfe2ff !important;
        }

        /* Dropdown styling */
        .custom-dropdown {
          border-radius: 12px;
          padding: 6px;
          min-width: 180px;
          box-shadow: 0 6px 16px rgba(0,0,0,0.15);
          animation: fadeIn 0.2s ease;
        }

        .dropdown-item {
          font-size: 0.9rem; /* smaller than nav text */
          padding: 8px 12px;
          border-radius: 8px;
          transition: all 0.2s ease;
        }

        .dropdown-item:hover {
          background-color: #e7f1ff;
          transform: translateX(3px);
        }

        /* Buttons */
        .custom-btn {
          border-radius: 20px;
          transition: all 0.3s ease;
        }

        .custom-btn:hover {
          transform: translateY(-1px);
          box-shadow: 0 3px 8px rgba(0,0,0,0.2);
        }

        .custom-btn:active {
          transform: scale(0.97);
        }
        
        .logo-img {
          height: 60px;
          width: auto;
          object-fit: contain;
          border-radius: 10px;
          margin-right: 12px;
          transition: transform 0.3s ease;
        }

        .logo-img:hover {
          transform: scale(1.05);
        }

        /* Animation */
        @keyframes fadeIn {
          from {
            opacity: 0;
            transform: translateY(5px);
          }
          to {
            opacity: 1;
            transform: translateY(0);
          }
        }
      `}</style>
        </nav>
    );
}
