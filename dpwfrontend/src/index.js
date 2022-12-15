import { render } from "react-dom";
import { BrowserRouter, Routes, Route, } from "react-router-dom"
import ProjectWrite from "./page/ProjectWrite"
import ProjectDetail from "./page/ProjectDetail";
import DevelopDiaryWrite from "./page/DevelopDiaryWrite";
import DevelopDiaryList from "./page/DevelopDiaryList";
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
    </Routes>
  </BrowserRouter>,
  rootElement
);