import { React, useState, useEffect } from "react";
import { useNavigate } from 'react-router-dom';
import '../../css/header.css'
import Modal from "./Modal";
import Axios from 'axios';

function Header() {
    // useState를 사용하여 open상태를 변경한다. (open일때 true로 만들어 열리는 방식)
    const [modalOpen, setModalOpen] = useState(false);

    const navigate = useNavigate();

    const openModal = () => {
        setModalOpen(true);
    };
    const closeModal = () => {
        setModalOpen(false);
    };

    const [loginUser, setLoginuser] = useState();
    const [loginText, setLoginText] = useState();

    const login = () => {
        Axios.get("/api/login").then((response) => {
            setLoginuser(response.data);
            if (response.data != "") {
                setLoginText("로그아웃");
            }
        }).catch(err => console.log(err))
        setLoginText("로그인");
    }

    const loginbtn = () => {
        if (loginText === "로그인") {
            openModal();
        }
        else {
            Axios.post("/api/logout").then((response) => {
            }).catch(err => console.log(err))
        }
    }

    useEffect(() => {
        login();
    }, [])

    return (
        <div class="DPW">
            <div class="blog-nav">
                <div class="title">
                    <a href="/">Develop Project Work</a>
                </div>
                <ul class="menu">
                    <button onClick={() => navigate('/write')}>프로젝트 생성</button>
                    <button onClick={loginbtn}>{loginText}</button>
                    {loginUser &&
                        <div class="user">
                            <a href="/user">
                                <span class="profile"><img src={loginUser.picture} alt="" /></span>
                                <span class="username">{loginUser.name}</span>
                                <spna class="jewel">💎{loginUser.jewel}</spna>
                            </a>
                        </div>
                    }
                </ul>
                <Modal open={modalOpen} close={closeModal} header="Modal heading">
                </Modal>
            </div>
        </div>
    )
}

export default Header;