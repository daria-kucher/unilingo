import "bootstrap/dist/css/bootstrap.min.css";

import "../styles/HomePage.css"

import {Header} from "../components/Header.jsx";
import {Footer} from "../components/Footer.jsx";

import learningGif from "../assets/gifs/individual.gif";
import practiceGif from "../assets/gifs/online.gif";
import progressGif from "../assets/gifs/progress.gif";
import bannerImg from "../assets/images/banner.png";
import learnersImg from "../assets/images/learners.png";
import user1 from "../assets/images/user1.jpg";
import user2 from "../assets/images/user2.jpg";
import user3 from "../assets/images/user3.jpg";
import award1 from "../assets/images/award1.webp";
import award2 from "../assets/images/award2.webp";
import award3 from "../assets/images/award3.png";


export default function HomePage() {
    return (
        <div className="page-bg">
            <Header isAuthenticated={false} />

            {/* Hero Section */}
            <section className="bg-primary text-light text-center py-5">
                <div className="container">
                    <img
                        src={bannerImg}
                        alt="banner"
                        className="hero-banner mb-4"
                    />
                    <h1 className="fw-bold mb-3">Learn Languages the Smart Way</h1>
                    <p className="lead mb-4">Interactive lessons, real progress, real results</p>
                    <button className="btn btn-light text-primary px-4 py-2 custom-btn">
                        Start Learning
                    </button>
                </div>
            </section>

            {/* Features Section */}
            <section className="py-5">
                <div className="container">
                    <div className="row text-center">
                        <div className="col-md-4 mb-4">
                            <img src={learningGif} alt="learning" className="feature-gif mb-3"/>
                            <h5 className="fw-bold">Personalized Learning</h5>
                            <p>Create your own path and learn at your own pace.</p>
                        </div>
                        <div className="col-md-4 mb-4">
                            <img src={practiceGif} alt="practice" className="feature-gif mb-3"/>
                            <h5 className="fw-bold">Real Practice</h5>
                            <p>Speak, write, and understand with real-life tasks.</p>
                        </div>
                        <div className="col-md-4 mb-4">
                            <img src={progressGif} alt="progress" className="feature-gif mb-3"/>
                            <h5 className="fw-bold">Track Progress</h5>
                            <p>See your improvement with detailed analytics.</p>
                        </div>
                    </div>
                </div>
            </section>

            {/* Highlight Section */}
            <section className="bg-light py-5">
                <div className="container">
                    <div className="row align-items-center">
                        <div className="col-md-6 mb-4">
                            <h2 className="fw-bold">Built for Modern Learners</h2>
                            <p>
                                UniLingo combines technology and proven methods to give you the
                                best learning experience.
                            </p>
                            <button className="btn btn-primary custom-btn">Explore Courses</button>
                        </div>
                        <div className="col-md-6">
                            <img
                                src={learnersImg}
                                alt="learning"
                                className="highlight-img"
                            />
                        </div>
                    </div>
                </div>
            </section>

            {/* Testimonials */}
            <section className="py-5 text-center">
                <div className="container">
                    <h2 className="fw-bold mb-4">What our students say</h2>
                    <div className="row">
                        <div className="col-md-4 mb-3 d-flex">
                            <div
                                className="testimonial-card p-4 shadow rounded w-100 d-flex flex-column align-items-center text-center">

                                <img
                                    src={user1}
                                    alt="Anna"
                                    className="testimonial-img mb-3"
                                />

                                <p className="flex-grow-1 mb-3">
                                    "Amazing platform! I improved my English in 3 months."
                                </p>

                                <small>- Anna</small>

                            </div>
                        </div>
                        <div className="col-md-4 mb-3 d-flex">
                            <div
                                className="testimonial-card p-4 shadow rounded w-100 d-flex flex-column align-items-center text-center">

                                <img
                                    src={user2}
                                    alt="Oleh"
                                    className="testimonial-img mb-3"
                                />

                                <p className="flex-grow-1 mb-3">
                                    "Very interactive and easy to use."
                                </p>

                                <small>- Oleh</small>

                            </div>
                        </div>
                        <div className="col-md-4 mb-3 d-flex">
                            <div
                                className="testimonial-card p-4 shadow rounded w-100 d-flex flex-column align-items-center text-center">

                                <img
                                    src={user3}
                                    alt="Maria"
                                    className="testimonial-img mb-3"
                                />

                                <p className="flex-grow-1 mb-3">
                                    "Best learning app I’ve tried so far."
                                </p>

                                <small>- Maria</small>
                            </div>
                        </div>

                    </div>
                </div>
            </section>

            {/* CTA Section */}
            <section className="bg-primary text-light text-center py-5">
                <div className="container">
                    <h2 className="fw-bold mb-3">Start your journey today</h2>
                    <button className="btn btn-light text-primary custom-btn px-4 py-2">
                        Join UniLingo
                    </button>
                </div>
            </section>
            {/* Awards Section */}
            <section className="awards-section text-center py-4">
                <div className="container">
                    <div className="row justify-content-center align-items-center">

                        <div className="col-4 col-md-2 mb-3">
                            <img src={award1} alt="award" className="award-img" />
                        </div>

                        <div className="col-4 col-md-2 mb-3">
                            <img src={award2} alt="award" className="award-img" />
                        </div>

                        <div className="col-4 col-md-2 mb-3">
                            <img src={award3} alt="award" className="award-img" />
                        </div>

                    </div>
                </div>
            </section>
            <Footer />
        </div>
    );
}
