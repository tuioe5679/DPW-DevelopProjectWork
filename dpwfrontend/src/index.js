import { render } from "react-dom";
import { BrowserRouter, Routes, Route, } from "react-router-dom"
import ProjectWrite from "./page/ProjectWrite"
import Main from "./page/Main";

const rootElement = document.getElementById("root");
render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Main />} />
      <Route path="write" element={<ProjectWrite />} />
    </Routes>
  </BrowserRouter>,
  rootElement
);