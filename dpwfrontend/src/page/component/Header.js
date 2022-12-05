import { React, useState } from "react";
import '../../css/header.css'
import Modal from "../Modal";

function Header() {
    // useState를 사용하여 open상태를 변경한다. (open일때 true로 만들어 열리는 방식)
    const [modalOpen, setModalOpen] = useState(false);

    const openModal = () => {
        setModalOpen(true);
    };
    const closeModal = () => {
        setModalOpen(false);
    };

    return (
        <div class="DPW">
            <div class="blog-nav">
                <div class="title">
                    <a href="/">Develop Project Work</a>
                </div>
                <ul class="menu">
                    <button>프로젝트 생성</button>
                    <button onClick={openModal}>로그인</button>
                </ul>
                <Modal open={modalOpen} close={closeModal} header="Modal heading">
                </Modal>
            </div>
        </div>
    )
}

export default Header;