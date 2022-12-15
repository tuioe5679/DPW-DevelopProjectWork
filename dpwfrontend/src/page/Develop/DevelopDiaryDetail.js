import React, { useEffect, useState } from "react";
import Header from "../../page/component/Header";
import '../../css/developDiaryDetail.css'
import Axios from 'axios';
import dayjs from "dayjs";
import { Link, useNavigate, useParams } from 'react-router-dom';

function DevelopDiaryDetail() {

    const navigate = useNavigate();

    const { id } = useParams();

    const [developDiaryContent, setdevelopDiaryContent] = useState([]);

    useEffect(() => {
        Axios.get('/api/developdiary/' + id).then((response) => {
            setdevelopDiaryContent(response.data);
        }).catch(err => console.log(err));

    }, []);
    const developDiaryDelete = () => {
        Axios.delete('/api/developdiary/' + id).then((response) => {
            alert("삭제 완료");
        })
        navigate("/");
    }

    return (
        <div>
            <Header></Header>
            <div class="diaryDetail_container">
                <div class="diary_box">
                    <div class="diary_title">
                        <h2>{developDiaryContent.title}</h2>
                    </div>
                    <div class="diary_data">
                        <div class="diary_date">{dayjs(developDiaryContent.createDate).format("YYYY-MM-DD")}</div>
                    </div>
                    <div class="diary_button">
                        <button class="submit_btn" onClick={() => navigate('/developDiaryUpdate/' + id, { state: developDiaryContent })}>수정</button>
                        <button class="cancel_btn" onClick={developDiaryDelete}>삭제</button>
                    </div>
                    <div class="diary_content">
                        <div class="content_text">{developDiaryContent.content}</div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default DevelopDiaryDetail;