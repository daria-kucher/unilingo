import { Header } from "../components/Header";
import { Footer } from "../components/Footer";
import { useState } from "react";
import "../styles/FAQPage.css"

const faqData = [
    {
        question: "How can I start learning?",
        answer: "Simply register an account and choose a course that matches your level."
    },
    {
        question: "Is UniLingo free?",
        answer: "We offer both free and premium content depending on your needs."
    },
    {
        question: "How long does it take to see progress?",
        answer: "Most learners notice improvement within a few weeks of consistent practice."
    },
    {
        question: "Can I learn at my own pace?",
        answer: "Yes, all courses are self-paced and adapt to your progress."
    },
    {
        question: "Do you provide certificates?",
        answer: "Yes, you can earn certificates after completing courses."
    },
    {
        question: "Is there a mobile version?",
        answer: "Yes, UniLingo works perfectly on mobile devices."
    }
];

export default function FAQPage() {
    const [activeIndex, setActiveIndex] = useState(null);

    const toggle = (index) => {
        setActiveIndex(activeIndex === index ? null : index);
    };

    return (
        <div className="page-bg">
            <Header isAuthenticated={false} />

            <section className="faq-section py-5">
                <div className="container" style={{ maxWidth: "800px" }}>
                    <h1 className="fw-bold text-center mb-5">FAQ</h1>

                    {faqData.map((item, index) => (
                        <div key={index} className="faq-item mb-3">
                            <button
                                className="faq-question w-100 d-flex justify-content-between align-items-center"
                                onClick={() => toggle(index)}
                            >
                                <span className="fw-bold">{item.question}</span>
                                <span
                                    className={`faq-icon ${
                                        activeIndex === index ? "open" : ""
                                    }`}
                                >
                                    +
                                </span>
                            </button>

                            <div
                                className={`faq-answer ${
                                    activeIndex === index ? "show" : ""
                                }`}
                            >
                                <p>{item.answer}</p>
                            </div>
                        </div>
                    ))}
                </div>
            </section>

            <Footer />
        </div>
    );
}