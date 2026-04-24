import API from "../api/api";

export const register = (data) => {
    return API.post("/api/users/register", data);
};

export const login = (data) => {
    return API.post("/api/users/login", data);
};