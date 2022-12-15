import { React, useState } from "react"
import { useNavigate } from "react-router-dom";
import { ko } from 'date-fns/esm/locale';
import Header from "../../page/component/Header";
import DatePicker from 'react-datepicker'
import dayjs from "dayjs";
import Axios from "axios";
import '../../css/projectWirte.css'
import "react-datepicker/dist/react-datepicker.css";

function ProjectWrite() {

    const navigate = useNavigate();

    const [startDate, setStartDate] = useState(new Date());
    const [endDate, setendDate] = useState(new Date());

    const [project, setProject] = useState({
        title: '',
        giturl: '',
        content: ''
    })

    const getValue = e => {
        const { name, value } = e.target;
        setProject({
            ...project,
            [name]: value
        })
    };

    const submitPosting = () => {
        Axios.post('/api/project', {
            title: project.title,
            giturl: project.giturl,
            content: project.content,
            startDate: dayjs(startDate).format("YYYY-MM-DD"),
            endDate: dayjs(endDate).format("YYYY-MM-DD")
        }).then(() => {
            alert('등록 완료');
        })
        navigate('/');
    }

    return (
        <div>
            <Header></Header>
            <div class="write_container">
                <div class="project_write">
                    <h3 class="page_title">프로젝트 생성</h3>
                    <div class="project_title">
                        <h3>제목</h3>
                        <div class="input">
                            <input class="title_input" type='text' placeholder='제목 입력' onChange={getValue} name='title'></input>
                        </div>
                    </div>
                    <div class="github">
                        <h3>깃허브 URL</h3>
                        <input class="github_input" type='text' placeholder='깃허브 URL 입력' onChange={getValue} name='giturl'></input>
                    </div>
                    <div class="project_content">
                        <h3>프로젝트 내용</h3>
                        <div class="input"><textarea type='text' onChange={getValue} placeholder='프로젝트의 전반적인 내용을 작성하세요' name='content'></textarea></div>
                    </div>
                    <div class="Date">
                        <h3>프로젝트 기간</h3>
                        <div class="proejct_Date">
                            <div class="proejct_startDate">
                                <h5>프로젝트 시작일</h5>
                                <DatePicker
                                    locale={ko}
                                    dateFormat="yyyy년 MM월 dd일"
                                    minDate={new Date()}
                                    selected={startDate}
                                    onChange={date => setStartDate(date)} />
                            </div>
                            <div class="proejct_endDate">
                                <h5>프로젝트 종료일</h5>
                                <DatePicker
                                    locale={ko}
                                    dateFormat="yyyy년 MM월 dd일"
                                    selected={endDate}
                                    onChange={date => setendDate(date)} />
                            </div>
                        </div>
                    </div>
                    <div class="tag">
                        <h3>태그</h3>
                        <div class="tags">
                            <input class="tag_Input"></input>
                            <input class="tag_Input"></input>
                            <input class="tag_Input"></input>
                            <input class="tag_Input"></input>
                            <input class="tag_Input"></input>
                        </div>
                    </div>
                    <div class="project_button">
                        <button class="submit_btn" onClick={submitPosting}>작성완료</button>
                        <button class="cancel_btn" onClick={() => navigate('/')}>취소하기</button>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default ProjectWrite;