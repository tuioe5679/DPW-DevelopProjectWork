import React, { useEffect, useState } from "react";
import Header from "./component/Header";
import '../css/projectDetail.css'
import Axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';

function ProjectDetail() {

    const navigate = useNavigate();

    const { id } = useParams();

    const [projectContent, setprojectContent] = useState([]);

    useEffect(() => {
        Axios.get('/api/project/' + id).then((response) => {
            setprojectContent(response.data);
        }).catch(err => console.log(err));
    }, []);

    console.log(projectContent);

    return (
        <div>
            <Header></Header>
            <div class="project_container">
                <div class="project_box">
                    <div class="project_image">
                        <img class="img" src="/img/NackHacker.jpg" alt="asd" />
                    </div>
                    <div class="project_header">
                        <div class="project_tags">
                            <div class="tag">Java</div>
                            <div class="tag">Java</div>
                        </div>
                        <div class="devlopDiary">
                            <h3>개발일지</h3>
                            <button onClick={() => navigate('/DevelopDiaryWrite/' + id)}>작성</button>
                            <div class="developDiary_List">
                                <a href="/developDiaryList"><div class="develop_data">더보기</div></a>
                            </div>
                        </div>
                        <div class="project_title">
                            <h3>제목</h3>
                            <div class="title_text">{projectContent.title}</div>
                        </div>
                        <div class="Date">
                            <h3>프로젝트 기간</h3>
                            <div class="date_text">{projectContent.startDate} ~ {projectContent.endDate}</div>
                        </div>
                        <div class="git">
                            <h3>Github URl</h3>
                            <a href={projectContent.giturl}>
                                <div class="github_url">{projectContent.giturl}</div>
                            </a>
                        </div>
                        <div class="develop">
                            <h3>개발자</h3>
                            <div class="develop_name">{projectContent.username}</div>
                        </div>
                    </div>
                    <div class="project_content">
                        <h3>내용</h3>
                        <div class="content_text">{projectContent.content}</div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default ProjectDetail;