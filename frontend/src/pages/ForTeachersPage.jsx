import { Header } from "../components/Header";
import { Footer } from "../components/Footer";

import toolsImg from "../assets/images/for-teachers/tools.svg"
import analyticsImg from "../assets/images/for-teachers/analytics.svg"
import integrationImg from "../assets/images/for-teachers/integration.svg"

import "../styles/ForTeachersPage.css"
import useFadeInOnScroll from "../hooks/useFadeInScroll.js";

export default function ForTeachersPage() {
    useFadeInOnScroll();
    return (
        <div className="page-bg">
            <Header />

            {/* HERO */}
            <section className="hero-section text-center py-5">
                <div className="container">
                    <h1 className="fw-bold mb-3">Teach Smarter with UniLingo</h1>
                    <p className="lead">
                        Empower your students with modern tools and interactive learning.
                    </p>
                </div>
            </section>

            {/* LONGREAD (CHESS STYLE) */}
            <section className="py-5">
                <div className="container">

                    {/* ITEM 1 */}
                    <div className="row align-items-center mb-5 fade-in">
                        <div className="col-md-6">
                            <img src={toolsImg} alt="teaching" className="longread-img"/>
                        </div>
                        <div className="col-md-6">
                            <h3 className="fw-bold">Interactive Learning Tools</h3>
                            <p>
                                UniLingo provides teachers with a wide range of digital tools that make lessons more engaging and effective.
                                From interactive exercises to real-time feedback systems, educators can easily adapt materials to fit different learning styles.
                            </p>
                            <p>
                                Students stay motivated thanks to gamification elements, while teachers gain deeper insights into progress and performance.
                            </p>
                        </div>
                    </div>

                    {/* ITEM 2 */}
                    <div className="row align-items-center mb-5 flex-md-row-reverse fade-in">
                        <div className="col-md-6">
                            <img src={analyticsImg} alt="analytics" className="longread-img"/>
                        </div>
                        <div className="col-md-6">
                            <h3 className="fw-bold">Powerful Analytics</h3>
                            <p>
                                Track student progress with detailed analytics dashboards. Identify strengths, weaknesses, and tailor your lessons accordingly.
                            </p>
                            <p>
                                With real-time data, you can make smarter teaching decisions and ensure that every student gets the support they need.
                            </p>
                        </div>
                    </div>

                    {/* ITEM 3 */}
                    <div className="row align-items-center mb-5 fade-in">
                        <div className="col-md-6">
                            <img src={integrationImg} alt="flexibility" className="longread-img"/>
                        </div>
                        <div className="col-md-6">
                            <h3 className="fw-bold">Flexible Integration</h3>
                            <p>
                                UniLingo seamlessly integrates into your existing curriculum. Whether you're teaching in a classroom or online,
                                our platform adapts to your teaching style.
                            </p>
                            <p>
                                Save time on preparation and focus more on what truly matters — teaching and inspiring your students.
                            </p>
                        </div>
                    </div>

                </div>
            </section>

            {/* INSTRUCTIONS */}
            <section className="instruction-section py-5 fade-in">
                <div className="container">
                    <h2 className="fw-bold text-center mb-4">How to Integrate UniLingo</h2>

                    <ol className="instruction-list">
                        <li>Create a teacher account and set up your classroom.</li>
                        <li>Invite students via link or email.</li>
                        <li>Select or customize learning materials.</li>
                        <li>Track progress and provide feedback.</li>
                        <li>Adjust lessons based on analytics.</li>
                    </ol>
                </div>
            </section>

            {/* CTA */}
            <section className="cta-section text-center py-5">
                <div className="container">
                    <h2 className="fw-bold mb-3">Join UniLingo for Teachers</h2>
                    <button className="btn btn-light text-primary custom-btn px-4 py-2">
                        Get Started
                    </button>
                </div>
            </section>

            {/* SMOOTH TRANSITION */}
            <section className="footer-transition"></section>

            <Footer />
        </div>
    );
}