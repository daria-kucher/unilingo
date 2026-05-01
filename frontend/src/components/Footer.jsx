import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-icons/font/bootstrap-icons.css";
import "../styles/Footer.css"
import { Link } from "react-router-dom";


export function Footer() {
    return (
        <footer className="footer mt-5 pt-4 pb-3">
            <div className="container">
                <div className="row text-start">

                    {/* Column 1 */}
                    <div className="col-md-4 mb-3">
                        <h6 className="fw-bold">For students</h6>
                        <ul className="list-unstyled">
                            <li><Link to="/course-general" className="footer-link">My courses</Link></li>
                            <li><Link to="/languages-english" className="footer-link">Practice exercises</Link></li>
                            <li><Link to="/course-general" className="footer-link">Progress tracking</Link></li>
                        </ul>
                    </div>

                    {/* Column 2 */}
                    <div className="col-md-4 mb-3">
                        <h6 className="fw-bold">About us</h6>
                        <ul className="list-unstyled">
                            <li><Link to="/who-we-are" className="footer-link">Who we are</Link></li>
                            <li><Link to="/contact-us" className="footer-link">Contact Us</Link></li>
                            <li><Link to="/faq" className="footer-link">FAQ</Link></li>
                            <li><Link to="/" className="footer-link">Site Map</Link></li>
                            <li><Link to="/educational-principles" className="footer-link">Educational Council</Link>
                            </li>
                        </ul>
                    </div>

                    <div className="col-md-4 mb-3">
                        <h6 className="fw-bold">Social</h6>
                        <ul className="list-unstyled">
                            <li className="footer-link d-flex align-items-center gap-2">
                                <i className="bi bi-instagram"></i> Instagram
                            </li>
                            <li className="footer-link d-flex align-items-center gap-2">
                                <i className="bi bi-facebook"></i> Facebook
                            </li>
                            <li className="footer-link d-flex align-items-center gap-2">
                                <i className="bi bi-tiktok"></i> TikTok
                            </li>
                            <li className="footer-link d-flex align-items-center gap-2">
                                <i className="bi bi-youtube"></i> YouTube
                            </li>
                        </ul>
                    </div>

                </div>

                <div className="text-center mt-3 small opacity-75">
                    © 2026 UniLingo. All rights reserved.
                </div>
            </div>
        </footer>
    );
}

