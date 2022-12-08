import { render } from "react-dom";
import { BrowserRouter, Routes, Route, } from "react-router-dom"
import ProjectWrite from "./page/ProjectWrite"
import ProjectDetail from "./page/ProjectDetail";
import DevelopDiary from "./page/DevelopDiary";
import Main from "./page/Main";


const rootElement = document.getElementById("root");
render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Main />} />
      <Route path="write" element={<ProjectWrite />} />
      <Route path="project" element={<ProjectDetail />} />
      <Route path="developDiary" element={<DevelopDiary/>} />
    </Routes>
  </BrowserRouter>,
  rootElement
);