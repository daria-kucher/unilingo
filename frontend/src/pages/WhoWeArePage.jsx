import { Header } from "../components/Header";
import { Footer } from "../components/Footer";
import useFadeInOnScroll from "../hooks/useFadeInScroll.js"

import tiredStudentImg from "../assets/images/who-we-are/tiredStudent.svg"
import brokenImg from "../assets/images/who-we-are/broken.svg"
import buildImg from "../assets/images/who-we-are/build.svg"
import missionImg from "../assets/images/who-we-are/mission.svg"

export default function WhoWeArePage() {
    useFadeInOnScroll();

    return (
        <div className="page-bg">
            <Header />

            {/* HERO */}
            <section className="hero-section text-center py-5">
                <div className="container">
                    <h1 className="fw-bold mb-3">Who We Are</h1>
                    <p className="lead">
                        A team of learners who turned frustration into innovation
                    </p>
                </div>
            </section>

            {/* LONGREAD */}
            <section className="py-5">
                <div className="container">

                    {/* BLOCK 1 */}
                    <div className="row align-items-center mb-5 fade-in">
                        <div className="col-md-6">
                            <img src={tiredStudentImg} alt="team" className="longread-img"/>
                        </div>
                        <div className="col-md-6">
                            <h3 className="fw-bold">Built by Learners, for Learners</h3>
                            <p>
                                UniLingo was not created by corporations or large institutions.
                                It was built by a group of passionate learners who personally
                                struggled with mastering a new language.
                            </p>
                            <p>
                                We experienced the same frustration — endless memorization,
                                lack of real communication, and slow progress despite spending
                                hours learning.
                            </p>
                        </div>
                    </div>

                    {/* BLOCK 2 */}
                    <div className="row align-items-center mb-5 flex-md-row-reverse fade-in">
                        <div className="col-md-6">
                            <img src={brokenImg} alt="problem" className="longread-img"/>
                        </div>
                        <div className="col-md-6">
                            <h3 className="fw-bold">We Saw What Was Broken</h3>
                            <p>
                                Traditional learning platforms often focus on repetition instead
                                of understanding. They prioritize gamification over real-world
                                skills and fail to prepare learners for actual conversations.
                            </p>
                            <p>
                                We noticed gaps in how languages are taught — lack of speaking
                                practice, poor personalization, and minimal feedback.
                            </p>
                        </div>
                    </div>

                    {/* BLOCK 3 */}
                    <div className="row align-items-center mb-5 fade-in">
                        <div className="col-md-6">
                            <img src={buildImg} alt="solution" className="longread-img"/>
                        </div>
                        <div className="col-md-6">
                            <h3 className="fw-bold">We Built a Better Way</h3>
                            <p>
                                Instead of accepting the limitations, we studied the most
                                effective learning methods — from immersive practice to
                                spaced repetition and real-life simulations.
                            </p>
                            <p>
                                Then we combined them into one platform designed to help
                                people actually speak, understand, and use a language
                                confidently.
                            </p>
                        </div>
                    </div>

                    {/* BLOCK 4 */}
                    <div className="row align-items-center mb-5 flex-md-row-reverse fade-in">
                        <div className="col-md-6">
                            <img src={missionImg} alt="mission" className="longread-img"/>
                        </div>
                        <div className="col-md-6">
                            <h3 className="fw-bold">Our Mission</h3>
                            <p>
                                We believe language learning should be practical, engaging,
                                and effective. Our goal is to eliminate fear and help people
                                communicate freely in any situation.
                            </p>
                            <p>
                                UniLingo is more than just an app — it's a learning experience
                                built from real struggles and real solutions.
                            </p>
                        </div>
                    </div>

                </div>
            </section>

            {/* CTA */}
            <section className="cta-section text-center py-5">
                <div className="container">
                    <h2 className="cta-title mb-4">
                        Join a platform built by people who truly understand your journey
                    </h2>

                    <button className="btn cta-btn px-5 py-3">
                        Try UniLingo
                    </button>
                </div>
            </section>

            {/* TRANSITION */}
            <div className="footer-transition"></div>

            <Footer />
        </div>
    );
}