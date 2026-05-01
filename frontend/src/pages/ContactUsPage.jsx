import { Header } from "../components/Header";
import { Footer } from "../components/Footer";
import { useState } from "react";
import "../styles/ContactUsPage.css"

export default function ContactUsPage() {
    const [email, setEmail] = useState("");
    const [topic, setTopic] = useState("");
    const [message, setMessage] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        alert("Message sent!");
        setEmail("");
        setTopic("");
        setMessage("");
    };

    return (
        <div className="page-bg">
            <Header isAuthenticated={false} />

            <section className="contact-section py-5">
                <div className="container">

                    <h1 className="fw-bold text-center mb-5">Contact Us</h1>

                    {/* INFO BLOCK */}
                    <div className="row mb-5">
                        <div className="col-md-6 mb-4">
                            <h5 className="fw-bold">Support Team</h5>
                            <p>support@unilingo.com</p>

                            <h5 className="fw-bold mt-4">Media Inquiries</h5>
                            <p>media@unilingo.com</p>
                        </div>

                        <div className="col-md-6">
                            <h5 className="fw-bold">Follow Us</h5>

                            <ul className="list-unstyled mt-3">
                                <li className="social-item">
                                    <i className="bi bi-instagram"></i> Instagram
                                </li>
                                <li className="social-item">
                                    <i className="bi bi-facebook"></i> Facebook
                                </li>
                                <li className="social-item">
                                    <i className="bi bi-tiktok"></i> TikTok
                                </li>
                                <li className="social-item">
                                    <i className="bi bi-youtube"></i> YouTube
                                </li>
                            </ul>
                        </div>
                    </div>

                    {/* FORM */}
                    <div className="contact-form-wrapper p-4 shadow rounded">
                        <h4 className="fw-bold mb-3">Have something to share?</h4>
                        <p className="mb-4">
                            Bounce us a message, don't be shy!
                        </p>

                        <form onSubmit={handleSubmit}>
                            {/* EMAIL */}
                            <div className="mb-3">
                                <label className="form-label">Your email</label>
                                <input
                                    type="email"
                                    className="form-control"
                                    value={email}
                                    onChange={(e) => setEmail(e.target.value)}
                                    required
                                />
                            </div>

                            {/* TOPIC */}
                            <div className="mb-3">
                                <label className="form-label">Choose a topic</label>
                                <select
                                    className="form-select"
                                    value={topic}
                                    onChange={(e) => setTopic(e.target.value)}
                                    required
                                >
                                    <option value="">Select...</option>
                                    <option value="support">Support</option>
                                    <option value="feedback">Feedback</option>
                                    <option value="partnership">Partnership</option>
                                </select>
                            </div>

                            {/* MESSAGE */}
                            <div className="mb-3">
                                <label className="form-label">Your message</label>
                                <textarea
                                    className="form-control"
                                    rows="4"
                                    value={message}
                                    onChange={(e) => setMessage(e.target.value)}
                                    required
                                />
                            </div>

                            <button className="btn btn-primary custom-btn px-4 py-2">
                                Send
                            </button>
                        </form>
                    </div>

                </div>
            </section>

            <Footer />
        </div>
    );
}