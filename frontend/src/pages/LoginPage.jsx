import { useState } from "react";
import { login } from "../services/authService";

function LoginPage() {

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
            const res = await login(form);
            console.log(res.data);

            alert("Login success!");
        } catch (err) {
            console.error(err);
            alert("Login failed");
        }
    };

    return (
        <div>
            <h2>Login</h2>

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

                <button type="submit">Login</button>
            </form>
        </div>
    );
}

export default LoginPage;