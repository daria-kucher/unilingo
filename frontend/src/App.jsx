import { useEffect } from "react";
import API from "./api/api";

function App() {

  useEffect(() => {
    API.get("/api/progress/1")
        .then(res => console.log(res.data))
        .catch(err => console.error(err));
  }, []);

  return <h1>UniLingo 🚀</h1>;
}

export default App;
