import { React, useState } from "react"
import { useNavigate } from "react-router-dom";
import { useLocation, useParams } from "react-router";
import Header from "../../page/component/Header";
import Axios from "axios";
import '../../css/projectWirte.css'
import "react-datepicker/dist/react-datepicker.css";

function ProjectUpdate() {

    const navigate = useNavigate();
    const { id } = useParams();
    const { state } = useLocation();

    const [project, setProject] = useState(state)

    const getValue = e => {
        const { name, value } = e.target;
        setProject({
            ...project,
            [name]: value
        })
    };

    const submitPosting = () => {
        Axios.put('/api/project/' + id, {
            title: project.title,
            giturl: project.giturl,
            content: project.content
        }).then(() => {
            alert('수정 완료');
        })
        navigate('/');
    }

    return (
        <div>
            <Header></Header>
            <div class="write_container">
                <div class="project_write">
                    <h3 class="page_title">프로젝트 수정</h3>
                    <div class="project_title">
                        <h3>제목</h3>
                        <div class="input">
                            <input class="title_input" type='text' value={project.title} placeholder='제목 입력' onChange={getValue} name='title'></input>
                        </div>
                    </div>
                    <div class="github">
                        <h3>깃허브 URL</h3>
                        <input class="github_input" type='text' value={project.giturl} placeholder='깃허브 URL 입력' onChange={getValue} name='giturl'></input>
                    </div>
                    <div class="project_content">
                        <h3>프로젝트 내용</h3>
                        <div class="input"><textarea type='text' value={project.content} onChange={getValue} placeholder='프로젝트의 전반적인 내용을 작성하세요' name='content'></textarea></div>
                    </div>
                    날짜와 태그는 수정할 수 없습니다
                    <div class="project_button">
                        <button class="submit_btn" onClick={submitPosting}>수정완료</button>
                        <button class="cancel_btn" onClick={() => navigate('/')}>취소하기</button>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default ProjectUpdate;