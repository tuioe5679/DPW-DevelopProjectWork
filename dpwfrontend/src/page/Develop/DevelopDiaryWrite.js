import { React, useEffect, useState } from "react"
import Header from "../../page/component/Header"
import "../../css/developDiary.css"
import { useNavigate, useParams } from "react-router-dom"
import Axios from "axios"
import dayjs from "dayjs";

function DevelopDiary() {

    const { id } = useParams();
    const navigate = useNavigate();

    const [startDate, setStartDate] = useState(new Date());
    const nowdate = dayjs(startDate).format("YYYY-MM-DD");

    const [diary, setdiary] = useState({
        title: '',
        content: '',
        id: ''
    })

    const [project, setproject] = useState({
        title: '',
        username: ''
    })

    const getValue = e => {
        const { name, value } = e.target;
        setdiary({
            ...diary,
            [name]: value
        })
    };

    const submitPosting = () => {
        Axios.post('/api/developdiary', {
            title: diary.title,
            content: diary.content,
            id: id
        }).then(() => {
            alert('등록 완료');
        })
        navigate('/');
    }

    useEffect(() => {
        Axios.get('/api/project/' + id).then((response) => {
            setproject(response.data);
        }).catch(err => console.log(err));
    }, [])

    return (
        <div>
            <Header></Header>
            <div class="diary_container">
                <div class="diary_write">
                    <h3 class="page_title">개발일지 {nowdate}</h3>
                    <div class="project_data">
                        <h3>프로젝트</h3>
                        <img class="img" src="/img/1.png" alt="" />
                        <div class="project_title">{project.title}</div>
                        <div class="project_Develop">{project.username}</div>
                    </div>
                    <div class="input_diary_title">
                        <h3>제목</h3>
                        <div class="input">
                            <input class="title_input" type='text' placeholder='제목 입력' onChange={getValue} name='title'></input>
                        </div>
                    </div>
                    <div class="input_diary_content">
                        <h3>개발일지 내용</h3>
                        <div class="input">
                            <textarea type='text' onChange={getValue} placeholder='개발일지를 작성하세요' name="content"></textarea>
                        </div>
                    </div>
                    <div class="input_diary_button">
                        <button class="submit_btn" onClick={submitPosting}>작성완료</button>
                        <button class="cancel_btn" onClick={() => navigate('/')}>취소하기</button>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default DevelopDiary;