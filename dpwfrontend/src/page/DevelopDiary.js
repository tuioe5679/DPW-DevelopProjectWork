import React from "react"
import Header from "./component/Header"
import "../css/developDiary.css"

function DevelopDiary() {
    return (
        <div>
            <Header></Header>
            <div class="diary_container">
                <div class="diary_write">
                    <h3 class="page_title">개발일지 (2022-12-09)</h3>
                    <div class="project_data">
                        <h3>프로젝트</h3>
                        <img class="img" src="img/NackHacker.jpg" alt="" />
                        <div class="project_title">Spring React 개발일지 시스템</div>
                        <div class="project_Develop">tuioe</div>
                    </div>
                    <div class="diary_title">
                        <h3>제목</h3>
                        <div class="input">
                            <input class="title_input" type='text' placeholder='제목 입력' name='title'></input>
                        </div>
                    </div>
                    <div class="diary_content">
                        <h3>개발일지 내용</h3>
                        <div class="input">
                            <textarea type='text' placeholder='개발일지를 작성하세요'></textarea>
                        </div>
                    </div>
                    <div class="diary_button">
                        <button class="submit_btn">작성완료</button>
                        <button class="cancel_btn">취소하기</button>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default DevelopDiary;