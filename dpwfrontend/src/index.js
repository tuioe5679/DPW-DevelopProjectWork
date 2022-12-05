import { render } from "react-dom";
import { BrowserRouter, Routes, Route, } from "react-router-dom"
import Main from "./page/Main";

const rootElement = document.getElementById("root");
render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Main />} />
    </Routes>
  </BrowserRouter>,
  rootElement
);