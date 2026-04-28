import { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { Header } from "../components/Header";
import { Footer } from "../components/Footer";

export default function LoginPage() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");

    const isValidEmail = (email) => {
        return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        if (!isValidEmail(email)) {
            setError("Invalid email format");
            return;
        }

        if (password.length < 6) {
            setError("Password must be at least 6 characters");
            return;
        }

        if (email !== "test@example.com" || password !== "123456") {
            setError("Incorrect email or password");
            return;
        }

        setError("");
        alert("Login successful!");
    };

    const isFormValid = email && password;

    return (
        <div className="page-bg d-flex flex-column min-vh-100">

            <Header isAuthenticated={false} />

            <div className="flex-grow-1 d-flex justify-content-center align-items-center">
                <div className="card shadow p-4" style={{ width: "350px", borderRadius: "15px" }}>
                    <h3 className="text-center mb-4">Login</h3>

                    {error && (
                        <div className="alert alert-danger py-2">{error}</div>
                    )}

                    <form onSubmit={handleSubmit}>
                        <div className="mb-3">
                            <label className="form-label">Email</label>
                            <input
                                type="email"
                                className="form-control"
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                                placeholder="Enter email"
                            />
                        </div>

                        <div className="mb-3">
                            <label className="form-label">Password</label>
                            <input
                                type="password"
                                className="form-control"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                                placeholder="Enter password"
                            />
                        </div>

                        <button
                            type="submit"
                            className="btn btn-primary w-100"
                            disabled={!isFormValid}
                        >
                            Sign In
                        </button>
                    </form>
                </div>
            </div>

            <Footer />

            <style>{`
        .page-bg {
          background-color: #f7fcfc;
        }
      `}</style>
        </div>
    );
}
