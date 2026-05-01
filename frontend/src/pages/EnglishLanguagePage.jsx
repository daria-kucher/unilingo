import worldImg from "../assets/images/languages-english/english-in-world.png";
import globalImg from "../assets/images/languages-english/global-language.png";
import vocabularyImg from "../assets/images/languages-english/vocabulary.png";
import mediaImg from "../assets/images/languages-english/media.png";
import communicationImg from "../assets/images/languages-english/communication.png"
import careerImg from "../assets/images/languages-english/career-growth.png"
import knowledgeImg from "../assets/images/languages-english/knowledge.png"
import "../styles/EnglishLanguagePage.css"
import useFadeInOnScroll from "../hooks/useFadeInScroll.js";
import { Header } from "../components/Header";
import { Footer } from "../components/Footer";
import {Link} from "react-router-dom";

export default function EnglishLanguagePage() {
    useFadeInOnScroll();
    return (
        <div className="page-bg">
            <Header isAuthenticated={false}/>

            {/* HERO */}
            <section className="hero-section text-center py-5">
                <div className="container">
                    <h1 className="fw-bold mb-3">Why English Matters</h1>
                    <p className="lead">
                        English is more than a language — it's a global tool for connection, growth, and opportunity.
                    </p>
                </div>
            </section>

            {/* LONGREAD */}
            <section className="py-5">
                <div className="container">

                    {/* 1 */}
                    <div className="row align-items-center fade-in mb-5">
                        <div className="col-md-6">
                            <h2 className="fw-bold mb-3">A Global Language</h2>
                            <p>
                                English is spoken by over 1.5 billion people worldwide, making it the most widely used
                                language for international communication. It is the primary language of global business,
                                science, aviation, and diplomacy.

                                <br/><br/>

                                Whether you're collaborating with international teams, studying abroad, or exploring
                                new cultures, English allows you to connect without barriers and access opportunities
                                that would otherwise remain out of reach.
                            </p>
                        </div>
                        <div className="col-md-6 text-center">
                            <img src={globalImg} className="longread-img" alt="world"/>
                        </div>
                    </div>

                    {/* 2 (reverse) */}
                    <div className="row align-items-center mb-5 fade-in flex-md-row-reverse">
                        <div className="col-md-6">
                            <h2 className="fw-bold mb-3">Career Opportunities</h2>
                            <p>
                                English is one of the most important skills in the modern job market. Many international
                                companies use English as their working language, and even local businesses often require
                                employees to have at least a basic understanding of it.

                                <br /><br />

                                Being fluent in English can significantly increase your chances of getting hired,
                                promoted, or working with global teams. It also opens doors to remote work opportunities
                                and international careers.

                                <br /><br />

                                Whether you are in IT, marketing, science, or business, English gives you a competitive
                                advantage and helps you grow professionally.
                            </p>
                        </div>
                        <div className="col-md-6 text-center">
                            <img src={careerImg} className="longread-img" alt="career"/>
                        </div>
                    </div>

                    {/* 3 */}
                    <div className="row align-items-center fade-in mb-5">
                        <div className="col-md-6">
                            <h2 className="fw-bold mb-3">Access to Knowledge</h2>
                            <p>
                                A large portion of the world’s educational content is created in English. From online
                                courses and university lectures to research papers and books, English dominates the
                                world of knowledge.

                                <br /><br />

                                By understanding English, you gain direct access to high-quality learning materials
                                without relying on translations. This allows you to stay updated with the latest trends,
                                technologies, and discoveries.

                                <br /><br />

                                Learning English is not just about communication — it is about unlocking unlimited
                                opportunities to learn and grow.
                            </p>
                        </div>
                        <div className="col-md-6 text-center">
                            <img src={knowledgeImg} className="longread-img" alt="knowledge"/>
                        </div>
                    </div>

                    {/* 4 (reverse) */}
                    <div className="row align-items-center mb-5 fade-in flex-md-row-reverse">
                        <div className="col-md-6">
                            <h2 className="fw-bold mb-3">Travel and Communication</h2>
                            <p>
                                Traveling becomes much easier when you speak English. It is widely understood in airports,
                                hotels, restaurants, and tourist destinations all over the world.

                                <br /><br />

                                English allows you to communicate with locals, ask for directions, make reservations,
                                and fully enjoy your travel experience without stress or confusion.

                                <br /><br />

                                Beyond practical use, it also helps you connect with people from different cultures,
                                make new friends, and create unforgettable experiences during your journeys.
                            </p>
                        </div>
                        <div className="col-md-6 text-center">
                            <img src={communicationImg} className="longread-img" alt="travel"/>
                        </div>
                    </div>

                </div>
            </section>

            {/* FACTS */}
            <section className="py-5 text-center facts-section fade-in">
                <div className="container">
                    <h2 className="fw-bold mb-4">Fun Facts About English</h2>

                    <div className="row">
                        <div className="col-md-4 mb-4">
                            <div className="fact-card p-4 shadow rounded h-100">
                                <img src={worldImg} className="fact-img mb-3" alt="fact"/>
                                <h5 className="fw-bold">🌍 Global Reach</h5>
                                <p>
                                    English is an official language in over 50 countries.
                                </p>
                            </div>
                        </div>

                        <div className="col-md-4 mb-4">
                            <div className="fact-card p-4 shadow rounded h-100">
                                <img src={vocabularyImg} className="fact-img mb-3" alt="fact"/>
                                <h5 className="fw-bold">📚 Huge Vocabulary</h5>
                                <p>
                                    English has over 170,000 words in active use — one of the richest vocabularies in
                                    the world.
                                </p>
                            </div>
                        </div>

                        <div className="col-md-4 mb-4">
                            <div className="fact-card p-4 shadow rounded h-100">
                                <img src={mediaImg} className="fact-img mb-3" alt="fact"/>
                                <h5 className="fw-bold">🎬 Language of Media</h5>
                                <p>
                                    Most movies, music, and online content are produced in English.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            {/* CTA */}
            <section className="cta-section smooth-transition text-center py-5">
                <div className="container">
                    <h2 className="fw-bold mb-3">Start Learning English Today</h2>
                    <p className="mb-4">
                        Take the first step toward new opportunities and global communication.
                    </p>
                    <Link to="/register" className="btn btn-light text-primary custom-btn px-4 py-2">
                        Join UniLingo
                    </Link>
                </div>
            </section>

            <Footer/>
        </div>
    );
}