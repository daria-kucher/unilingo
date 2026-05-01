import { Header } from "../components/Header";
import { Footer } from "../components/Footer";
import studentImg from "../assets/images/general-course/girl-studying.svg"
import "../styles/GeneralCoursePage.css"
import { Link } from "react-router-dom";

export default function GeneralCoursePage() {
    return (
        <div className="page-bg">
            <Header isAuthenticated={false} />

            <section className="course-section py-5">
                <div className="container">
                    <div className="row align-items-center">

                        {/* IMAGE LEFT */}
                        <div className="col-md-6 text-center mb-4">
                            <img
                                src={studentImg}
                                alt="General Course"
                                className="course-img"
                            />
                        </div>

                        {/* TEXT RIGHT */}
                        <div className="col-md-6">
                            <h1 className="fw-bold mb-3">General English Course</h1>

                            <p>
                                This course is designed to help you build a strong foundation in English.
                                It covers all essential skills including speaking, listening, reading,
                                and writing.
                            </p>

                            <p>
                                You will learn how to communicate in everyday situations, understand
                                native speakers, and express your thoughts clearly and confidently.
                            </p>

                            <p>
                                Whether you're a beginner or looking to improve your level, this course
                                adapts to your needs and helps you progress step by step.
                            </p>

                            <Link
                                to="/login"
                                className="btn btn-primary custom-btn px-4 py-2 mt-3"
                            >
                                Start Learning
                            </Link>
                        </div>

                    </div>
                </div>
            </section>

            <Footer />
        </div>
    );
}