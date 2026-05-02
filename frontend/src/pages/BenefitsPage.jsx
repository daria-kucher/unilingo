import "../styles/BenefitsPage.css"
import { Header } from "../components/Header";
import { Footer } from "../components/Footer";
import { useRef } from "react";
import { Link } from "react-router-dom";
import useFadeInOnScroll from "../hooks/useFadeInScroll.js";
import pathImg from "../assets/images/benefits/path.svg"
import communicationImg from "../assets/images/benefits/communication.svg"
import trackingImg from "../assets/images/benefits/tracking.svg"
import checkIcon from "../assets/images/benefits/check-mark.png";
import crossIcon from "../assets/images/benefits/cross-mark.png";
import leftArrow from "../assets/images/benefits/left-arrow.png"
import rightArrow from "../assets/images/benefits/right-arrow.png"
import studentOneImg from "../assets/images/benefits/student1.jpg"
import studentTwoImg from "../assets/images/benefits/student2.jpg"
import studentThreeImg from "../assets/images/benefits/student3.jpg"
import studentFourImg from "../assets/images/benefits/student4.jpg"
import studentFiveImg from "../assets/images/benefits/student5.jpg"
import studentSixImg from "../assets/images/benefits/student6.jpg"
import studentSevenImg from "../assets/images/benefits/student7.jpg"






export default function BenefitsPage() {
    useFadeInOnScroll();
    const carouselRef = useRef(null);

    const scroll = (direction) => {
        const container = carouselRef.current;
        if (!container) return;

        const scrollAmount = 300; // ширина однієї карточки

        container.scrollBy({
            left: direction === 1 ? scrollAmount : -scrollAmount,
            behavior: "smooth"
        });
    };
    return (
        <div className="page-bg">
            <Header/>

            {/* LONGREAD FEATURES */}
            <section className="py-5">
                <div className="container">

                    {/* ITEM 1 */}
                    <div className="row align-items-center mb-5 fade-in">
                        <div className="col-md-6">
                            <img src={pathImg} alt="feature" className="longread-img"/>
                        </div>
                        <div className="col-md-6">
                            <h3 className="fw-bold">Personalized Learning Paths</h3>
                            <p>
                                UniLingo adapts to your level and goals, creating a learning experience
                                tailored specifically for you. Instead of following a rigid structure,
                                you progress at your own pace.
                            </p>
                            <p>
                                This approach ensures better retention and keeps you motivated throughout
                                your journey.
                            </p>
                        </div>
                    </div>

                    {/* ITEM 2 */}
                    <div className="row align-items-center mb-5 flex-md-row-reverse fade-in">
                        <div className="col-md-6">
                            <img src={communicationImg} alt="feature" className="longread-img"/>
                        </div>
                        <div className="col-md-6">
                            <h3 className="fw-bold">Real-Life Communication</h3>
                            <p>
                                Learn how to speak confidently in real-world situations. UniLingo focuses
                                on practical usage instead of memorization.
                            </p>
                            <p>
                                Practice conversations, listening, and writing in realistic scenarios
                                that prepare you for everyday communication.
                            </p>
                        </div>
                    </div>

                    {/* ITEM 3 */}
                    <div className="row align-items-center mb-5 fade-in">
                        <div className="col-md-6">
                            <img src={trackingImg} alt="feature" className="longread-img"/>
                        </div>
                        <div className="col-md-6">
                            <h3 className="fw-bold">Smart Progress Tracking</h3>
                            <p>
                                Track your improvement with detailed analytics and insights. See what
                                you’ve mastered and where you need more practice.
                            </p>
                            <p>
                                This allows you to focus your efforts efficiently and achieve faster results.
                            </p>
                        </div>
                    </div>

                </div>
            </section>

            {/* COMPARISON TABLE */}
            <section className="comparison-section py-5">
                <div className="container">
                    <h2 className="fw-bold text-center mb-5">
                        UniLingo vs Other Apps
                    </h2>

                    <div className="table-responsive">
                        <table className="table custom-table text-center align-middle">
                            <thead>
                            <tr>
                                <th>Features</th>
                                <th>UniLingo</th>
                                <th>Duolingo</th>
                                <th>Promova</th>
                                <th>Babbel</th>
                            </tr>
                            </thead>

                            <tbody>
                            {[
                                ["Personalized learning", true, false, true, true],
                                ["Real-life conversations", true, false, true, true],
                                ["AI-based recommendations", true, false, false, false],
                                ["Progress analytics", true, true, true, false],
                                ["Grammar explanations", true, false, true, true],
                                ["Offline mode", true, true, false, true],
                                ["Interactive exercises", true, true, true, true],
                                ["Speaking practice", true, false, true, true],
                                ["Gamification", true, true, false, false],
                                ["Flexible schedule", true, true, true, true],
                            ].map((row, i) => (
                                <tr key={i}>
                                    <td className="feature-name">{row[0]}</td>

                                    {row.slice(1).map((value, index) => (
                                        <td key={index}>
                                            <img
                                                src={value ? checkIcon : crossIcon}
                                                alt={value ? "yes" : "no"}
                                                className="table-icon"
                                            />
                                        </td>
                                    ))}
                                </tr>
                            ))}
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>

            {/* CTA */}
            <section className="cta-section text-center py-5">
                <div className="container">
                    <h2 className="cta-title mb-4">
                        Learn smarter. Speak confidently. <br/>
                        Start your journey with UniLingo today 🚀
                    </h2>

                    <button className="btn cta-btn px-5 py-3">
                        Try UniLingo
                    </button>
                </div>
            </section>

            {/* VS SECTION */}
            <section className="vs-section py-5 text-center">
                <div className="container">
                    <h2 className="fw-bold mb-5 vs-title">
                        UniLingo vs Duolingo
                    </h2>

                    <div className="row justify-content-center g-4">

                        {/* UniLingo */}
                        <div className="col-md-5">
                            <div className="vs-card vs-card-good p-4 h-100">
                                <h4 className="fw-bold mb-4">UniLingo ✅</h4>

                                <ul className="list-unstyled vs-list">
                                    {[
                                        "Personalized learning paths",
                                        "Real-life communication focus",
                                        "AI-powered recommendations",
                                        "Detailed progress tracking",
                                        "Speaking & pronunciation training",
                                        "Flexible schedule",
                                        "Deep grammar explanations",
                                        "Interactive real-world tasks"
                                    ].map((item, i) => (
                                        <li key={i}>
                                            <img src={checkIcon} alt="+"/>
                                            {item}
                                        </li>
                                    ))}
                                </ul>
                            </div>
                        </div>

                        {/* Duolingo */}
                        <div className="col-md-5">
                            <div className="vs-card vs-card-bad p-4 h-100">
                                <h4 className="fw-bold mb-4">Duolingo ❌</h4>

                                <ul className="list-unstyled vs-list">
                                    {[
                                        "Limited personalization",
                                        "Focus on gamification over depth",
                                        "Weak speaking practice",
                                        "Basic progress tracking",
                                        "Repetitive exercises",
                                        "Limited real-life usage",
                                        "Minimal grammar explanations",
                                        "Less structured learning path"
                                    ].map((item, i) => (
                                        <li key={i}>
                                            <img src={crossIcon} alt="-"/>
                                            {item}
                                        </li>
                                    ))}
                                </ul>
                            </div>
                        </div>

                    </div>
                </div>
            </section>

            {/* TESTIMONIAL CAROUSEL */}
            <section className="testimonial-section py-5 text-center">
                <div className="container">
                    <h2 className="fw-bold testimonial-title">
                        What our students say
                    </h2>

                    <div className="carousel-wrapper">

                        {/* CARDS */}
                        <div className="testimonial-carousel" ref={carouselRef}>
                            {[
                                {
                                    name: "Anna",
                                    time: "3 months",
                                    text: "UniLingo completely changed the way I learn. I finally feel confident speaking English.",
                                    img: studentOneImg
                                },
                                {
                                    name: "Oleh",
                                    time: "2 months",
                                    text: "The lessons are practical and engaging. I use English daily now without fear.",
                                    img: studentTwoImg
                                },
                                {
                                    name: "Maria",
                                    time: "4 months",
                                    text: "Best platform I’ve ever tried. Clear explanations and real-life practice.",
                                    img: studentThreeImg
                                },
                                {
                                    name: "Dmytro",
                                    time: "5 months",
                                    text: "I improved my speaking skills dramatically thanks to UniLingo.",
                                    img: studentFourImg
                                },
                                {
                                    name: "Iryna",
                                    time: "1.5 months",
                                    text: "Very intuitive and easy to follow. Perfect for busy people.",
                                    img: studentFiveImg
                                },
                                {
                                    name: "Taras",
                                    time: "3 months",
                                    text: "The progress tracking really motivates me to keep going.",
                                    img: studentSixImg
                                },
                                {
                                    name: "Sofia",
                                    time: "2.5 months",
                                    text: "Finally a platform that focuses on real communication.",
                                    img: studentSevenImg
                                }
                            ].map((item, i) => (
                                <div key={i} className="testimonial-card-new">
                                    <img src={item.img} alt="student" className="student-img"/>

                                    <h6 className="fw-bold mt-3">{item.name}</h6>
                                    <small className="text-muted">Learning: {item.time}</small>

                                    <p className="mt-3">"{item.text}"</p>
                                </div>
                            ))}
                        </div>

                        {/* CONTROLS */}
                        <div className="carousel-controls">
                            <button className="carousel-btn" onClick={() => scroll(-1)}>
                                <img src={leftArrow} alt="left"/>
                            </button>

                            <button className="carousel-btn" onClick={() => scroll(1)}>
                                <img src={rightArrow} alt="right"/>
                            </button>
                        </div>

                    </div>
                </div>
            </section>

            <Footer/>
        </div>
    );
}