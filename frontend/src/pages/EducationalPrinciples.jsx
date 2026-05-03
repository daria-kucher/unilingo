import { Header } from "../components/Header";
import { Footer } from "../components/Footer";
import useFadeInOnScroll from "../hooks/useFadeInScroll.js";

import adaptiveLearningImg from "../assets/images/educational-principles/adaptiveLearning.jpg"
import bktImg from "../assets/images/educational-principles/bkt.webp"
import learnImg from "../assets/images/educational-principles/learn.svg"

export default function EducationalPrinciplesPage() {
    useFadeInOnScroll();

    return (
        <div className="page-bg">
            <Header />

            {/* HERO */}
            <section className="hero-section text-center py-5">
                <div className="container">
                    <h1 className="fw-bold mb-3">Educational Principles</h1>
                    <p className="lead">
                        How UniLingo turns learning into a smart, adaptive experience
                    </p>
                </div>
            </section>

            {/* LONGREAD */}
            <section className="py-5">
                <div className="container">

                    {/* BLOCK 1 — ADAPTIVE LEARNING */}
                    <div className="row align-items-center mb-5 fade-in">
                        <div className="col-md-6">
                            <img src={adaptiveLearningImg} alt="adaptive learning" className="longread-img"/>
                        </div>
                        <div className="col-md-6">
                            <h3 className="fw-bold">Adaptive Learning</h3>
                            <p>
                                At the core of UniLingo lies adaptive learning — a method that
                                adjusts the learning process to each individual student.
                            </p>
                            <p>
                                Instead of following a fixed curriculum, the platform analyzes
                                your performance in real time and continuously adapts the content
                                to your level, pace, and needs.
                            </p>
                            <p>
                                This means you don’t waste time on what you already know and
                                receive more practice where you actually need it.
                            </p>
                        </div>
                    </div>

                    {/* BLOCK 2 — BAYESIAN KNOWLEDGE TRACING */}
                    <div className="row align-items-center mb-5 flex-md-row-reverse fade-in">
                        <div className="col-md-6">
                            <img src={bktImg} alt="bayesian model" className="longread-img"/>
                        </div>
                        <div className="col-md-6">
                            <h3 className="fw-bold">Bayesian Knowledge Tracing</h3>
                            <p>
                                UniLingo uses a powerful model called Bayesian Knowledge Tracing
                                (BKT) to estimate your knowledge level.
                            </p>
                            <p>
                                This method tracks how likely it is that you have mastered a
                                specific skill based on your answers — correct or incorrect.
                            </p>
                            <p>
                                With each interaction, the system updates your knowledge state
                                and predicts what you are ready to learn next.
                            </p>
                            <p>
                                This allows UniLingo to create a truly personalized learning
                                path that evolves with you.
                            </p>
                        </div>
                    </div>

                    {/* BLOCK 3 — MAIN LEARNING PRINCIPLE */}
                    <div className="row align-items-center mb-5 fade-in">
                        <div className="col-md-6">
                            <img src={learnImg} alt="learning flow" className="longread-img"/>
                        </div>
                        <div className="col-md-6">
                            <h3 className="fw-bold">How Learning Works in UniLingo</h3>
                            <p>
                                Learning in UniLingo is built around a simple but powerful idea:
                                practice → feedback → adaptation.
                            </p>
                            <p>
                                You complete real-life tasks such as speaking, writing, and
                                listening exercises. After each step, the system evaluates your
                                performance and provides immediate feedback.
                            </p>
                            <p>
                                Based on this feedback, the platform adjusts future tasks —
                                making them more challenging or reinforcing weak areas.
                            </p>
                            <p>
                                This continuous loop ensures steady progress and builds real
                                communication skills, not just theoretical knowledge.
                            </p>
                        </div>
                    </div>

                </div>
            </section>

            {/* CTA */}
            <section className="cta-section text-center py-5">
                <div className="container">
                    <h2 className="cta-title mb-4">
                        Experience learning that adapts to you
                    </h2>

                    <button className="btn cta-btn px-5 py-3">
                        Start Learning
                    </button>
                </div>
            </section>

            {/* TRANSITION */}
            <div className="footer-transition"></div>

            <Footer />
        </div>
    );
}