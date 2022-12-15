import { render } from "react-dom";
import { BrowserRouter, Routes, Route, } from "react-router-dom"
import ProjectWrite from "./page/Project/ProjectWrite"
import ProjectDetail from "./page/Project/ProjectDetail";
import ProjectUpdate from "./page/Project/ProjectUpdate";
import DevelopDiaryWrite from "./page/Develop/DevelopDiaryWrite";
import DevelopDiaryList from "./page/Develop/DevelopDiaryList";
import DevelopDiaryUpdate from "./page/Develop/DevelopDiaryUpdate";
import Main from "./page/Main";
import DevelopDiaryDetail from "./page/Develop/DevelopDiaryDetail";

const rootElement = document.getElementById("root");
render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Main />} />
      <Route path="write" element={<ProjectWrite />} />
      <Route path="project/:id" element={<ProjectDetail />} />
      <Route path="developDiaryWrite/:id" element={<DevelopDiaryWrite />} />
      <Route path="developDiaryList/:id" element={<DevelopDiaryList />} />
      <Route path="developDiaryUpdate/:id" element={<DevelopDiaryUpdate />} />
      <Route path="developDiaryDeatil/:id" element={<DevelopDiaryDetail />} />
      <Route path="projectUpdate/:id" element={<ProjectUpdate />} />
    </Routes>
  </BrowserRouter>,
  rootElement
);