import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App.css';
import reportWebVitals from './reportWebVitals';
import {RecoilRoot} from "recoil";
import ListAddress from "./components/ListAddress";
import {BrowserRouter} from "react-router-dom";
import {Route, Routes} from "react-router";
import CreateAddress from "./components/CreateAddress";
import EditAddress from "./components/EditAddress";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <RecoilRoot>
            <BrowserRouter>
                <Routes>
                    <Route path={""} element={<ListAddress/>}/>
                    <Route path={"/create"} element={<CreateAddress/>}/>
                    <Route path={"/edit/:id"} element={<EditAddress/>}/>
                </Routes>
            </BrowserRouter>
        </RecoilRoot>
    </React.StrictMode>
);
reportWebVitals();
