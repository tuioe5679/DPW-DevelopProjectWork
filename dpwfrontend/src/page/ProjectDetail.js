import React from "react";
import Header from "./component/Header";
import '../css/projectDetail.css'
import { useNavigate } from 'react-router-dom';

function ProjectDetail() {

    const navigate = useNavigate();

    return (
        <div>
            <Header></Header>
            <div class="project_container">
                <div class="project_box">
                    <div class="project_image">
                        <img class="img" src="img/NackHacker.jpg" alt="" />
                    </div>
                    <div class="project_header">
                        <div class="project_tags">
                            <div class="tag">Java</div>
                            <div class="tag">Java</div>
                        </div>
                        <div class="devlopDiary">
                            <h3>개발일지</h3>
                            <button onClick={() => navigate('/developDiary')}>작성</button>
                            <div class="developDiary_List">
                                <a href="/asd"><div class="develop_data">개발일지1</div></a>
                                <a href="/asd"><div class="develop_data">개발일지1</div></a>
                                <a href="/asd"><div class="develop_data">개발일지1</div></a>
                                <a href="/asd"><div class="develop_data">더보기</div></a>
                            </div>
                        </div>
                        <div class="medal">🥇🥇🥇🥇🥇🥇🥇</div>
                        <div class="project_title">
                            <h3>제목</h3>
                            <div class="title_text">프로젝트</div>
                        </div>
                        <div class="Date">
                            <h3>프로젝트 기간</h3>
                            <div class="date_text">2022-12-07 ~ 2022-12-24</div>
                        </div>
                        <div class="develop">
                            <h3>개발자</h3>
                            <div class="develop_name">tuioe</div>
                        </div>
                    </div>
                    <div class="project_content">
                        <h3>내용</h3>
                        <div class="content_text"></div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default ProjectDetail;