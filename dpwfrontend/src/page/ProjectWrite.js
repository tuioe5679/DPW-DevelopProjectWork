import { React, useState } from "react"
import Header from "./component/Header";
import DatePicker from 'react-datepicker'
import dayjs from "dayjs";
import { ko } from 'date-fns/esm/locale';
import '../css/projectWirte.css'
import "react-datepicker/dist/react-datepicker.css";



function ProjectWrite() {

    const [startDate, setStartDate] = useState(new Date());
    const [endDate, setendDate] = useState(new Date());

    console.log(dayjs(startDate).format("YYYY-MM-DD"));
    return (
        <div>
            <Header></Header>
            <div class="write_container">
                <div class="project_write">
                    <div class="project_title">
                        <h3>제목</h3>
                        <div class="input"><input class="title_input" type='text' placeholder='제목 입력' name='title'></input></div>
                    </div>
                    <div class="project_content">
                        <h3>프로젝트 내용</h3>
                        <div class="input"><textarea></textarea></div>
                    </div>
                    <div class="proejct_startDate">
                        <h3>프로젝트 시작일</h3>
                        <DatePicker
                            locale={ko}
                            dateFormat="yyyy년 MM월 dd일"
                            minDate={new Date()}
                            selected={startDate}
                            onChange={date => setStartDate(date)} />
                    </div>
                    <div class="proejct_endDate">
                        <h3>프로젝트 종료일</h3>
                        <DatePicker
                            locale={ko}
                            dateFormat="yyyy년 MM월 dd일"
                            selected={endDate}
                            onChange={date => setendDate(date)} />
                    </div>
                </div>
            </div>
        </div>
    )
}

export default ProjectWrite;