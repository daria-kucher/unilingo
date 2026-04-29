import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-icons/font/bootstrap-icons.css";
import "../styles/Footer.css"

export function Footer() {
    return (
        <footer className="bg-primary text-light mt-5 pt-4 pb-3">
            <div className="container">
                <div className="row text-start">

                    {/* Column 1 */}
                    <div className="col-md-4 mb-3">
                        <h6 className="fw-bold">For students</h6>
                        <ul className="list-unstyled">
                            <li><a href="#" className="footer-link">My courses</a></li>
                            <li><a href="#" className="footer-link">Practice exercises</a></li>
                            <li><a href="#" className="footer-link">Progress tracking</a></li>
                        </ul>
                    </div>

                    {/* Column 2 */}
                    <div className="col-md-4 mb-3">
                        <h6 className="fw-bold">About us</h6>
                        <ul className="list-unstyled">
                            <li><a href="#" className="footer-link">Who we are</a></li>
                            <li><a href="#" className="footer-link">Contact Us</a></li>
                            <li><a href="#" className="footer-link">FAQ</a></li>
                            <li><a href="#" className="footer-link">Site Map</a></li>
                            <li><a href="#" className="footer-link">Educational Council</a></li>
                        </ul>
                    </div>

                    {/* Column 3 */}
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

