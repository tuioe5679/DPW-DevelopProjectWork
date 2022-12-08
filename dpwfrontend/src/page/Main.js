import React, { useEffect, useState } from 'react';
import '../css/main.css'
import Axios from 'axios';
import Header from './component/Header';

function Main() {

    return (
        <div>
            <Header></Header>
            <div class="container">
                <div class="box">
                    <a href="/project">
                        <div class="main">
                            <img class="img" src="img/NackHacker.jpg" alt="" />
                            <div class="board_box">
                                <div class="title_box">
                                    <h1 class="heading">2차 프로젝트</h1>
                                    <div class="tag">Java</div>
                                </div>
                                <div class="data">
                                    <span class="date">2022-12-05</span>
                                    <div class="logo">
                                        <svg role="img" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                                            <title>GitHub</title>
                                            <path d="M12 .297c-6.63 0-12 5.373-12 12 0 5.303 3.438 9.8 8.205 11.385.6.113.82-.258.82-.577 0-.285-.01-1.04-.015-2.04-3.338.724-4.042-1.61-4.042-1.61C4.422 18.07 3.633 17.7 3.633 17.7c-1.087-.744.084-.729.084-.729 1.205.084 1.838 1.236 1.838 1.236 1.07 1.835 2.809 1.305 3.495.998.108-.776.417-1.305.76-1.605-2.665-.3-5.466-1.332-5.466-5.93 0-1.31.465-2.38 1.235-3.22-.135-.303-.54-1.523.105-3.176 0 0 1.005-.322 3.3 1.23.96-.267 1.98-.399 3-.405 1.02.006 2.04.138 3 .405 2.28-1.552 3.285-1.23 3.285-1.23.645 1.653.24 2.873.12 3.176.765.84 1.23 1.91 1.23 3.22 0 4.61-2.805 5.625-5.475 5.92.42.36.81 1.096.81 2.22 0 1.606-.015 2.896-.015 3.286 0 .315.21.69.825.57C20.565 22.092 24 17.592 24 12.297c0-6.627-5.373-12-12-12">
                                            </path>
                                        </svg>
                                        <span class="user-id">tuioe</span>
                                    </div>
                                </div>
                                <p class="texts">박스 테두리를 주지 않고 기본적으로 박스 쉐도우를 안주며 박스의 형태를 명확하게 구분할 수 있게 하고 싶었고 가장 중요한 점은 마우스 오버 시 박스 전체를 위로 올려주어 약간 들어올려지는 듯한 느낌의 트랜지션을 적용하였습니다. 또한 cubic-bezier를 이용하여 ease-in-out으로 자연스럽게 흘러가게 해주었고 오버시에만 박스쉐도우를 적용하여 들어올려지는 느낌을 강조하였습니다.</p>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    )
}

export default Main;
