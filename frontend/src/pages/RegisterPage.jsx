import { useState } from "react";
import { register } from "../services/authService";

function RegisterPage() {

    const [form, setForm] = useState({
        username: "",
        password: ""
    });

    const handleChange = (e) => {
        setForm({
            ...form,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            await register(form);
            alert("User created!");
        } catch (err) {
            console.error(err);
            alert("Error");
        }
    };

    return (
        <div>
            <h2>Register</h2>

            <form onSubmit={handleSubmit}>
                <input
                    name="username"
                    placeholder="Username"
                    onChange={handleChange}
                />

                <input
                    name="password"
                    type="password"
                    placeholder="Password"
                    onChange={handleChange}
                />

                <button type="submit">Register</button>
            </form>
        </div>
    );
}

export default RegisterPage;