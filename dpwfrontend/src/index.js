import { render } from "react-dom";
import { BrowserRouter, Routes, Route, } from "react-router-dom"
import ProjectWrite from "./page/Project/ProjectWrite"
import ProjectDetail from "./page/Project/ProjectDetail";
import ProjectUpdate from "./page/Project/ProjectUpdate";
import DevelopDiaryWrite from "./page/Develop/DevelopDiaryWrite";
import DevelopDiaryList from "./page/Develop/DevelopDiaryList";
import Main from "./page/Main";

const rootElement = document.getElementById("root");
render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Main />} />
      <Route path="write" element={<ProjectWrite />} />
      <Route path="project/:id" element={<ProjectDetail />} />
      <Route path="DevelopDiaryWrite/:id" element={<DevelopDiaryWrite />} />
      <Route path="developDiaryList/:id" element={<DevelopDiaryList />} />
      <Route path="projectUpdate/:id" element={<ProjectUpdate />} />
    </Routes>
  </BrowserRouter>,
  rootElement
);