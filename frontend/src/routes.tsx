import {createBrowserRouter} from "react-router-dom";
import HomePage from "./pages/HomePage"
import LoginPage from "./pages/LoginPage"
import RegisterPage from "./pages/RegisterPage"
import EnglishLanguagePage from "./pages/EnglishLanguagePage"
import GeneralCoursePage from "./pages/GeneralCoursePage"
import ForTeachersPage from "./pages/ForTeachersPage"
import WhoWeArePage from "./pages/WhoWeArePage"
import BenefitsPage from "./pages/BenefitsPage"
// @ts-ignore
import EducationalPrinciples from "./pages/EducationalPrinciples"
// @ts-ignore
import ProficiencyTestPage from "./pages/ProficiencyTestPage"
import ContactUsPage from "./pages/ContactUsPage"
import FAQPage from "./pages/FAQPage"




const router = createBrowserRouter([
    {path: '/', element: <HomePage/>},
    {path: '/login', element: <LoginPage/>},
    {path: '/register', element: <RegisterPage/>},
    {path: '/languages-english', element: <EnglishLanguagePage/>},
    {path: '/course-general', element: <GeneralCoursePage/>},
    {path: '/for-teachers', element: <ForTeachersPage/>},
    {path: '/who-we-are', element: <WhoWeArePage/>},
    {path: '/benefits', element: <BenefitsPage/>},
    {path: '/educational-principles', element: <EducationalPrinciples />},
    {path: '/proficiency-test', element: <ProficiencyTestPage/>},
    {path: '/contact-us', element: <ContactUsPage/>},
    {path: '/faq', element: <FAQPage/>},
    ]);

export default router;