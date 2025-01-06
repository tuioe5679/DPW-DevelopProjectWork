# DPW-DevelopProjectWork

개발 기간: **2022년 12월 2일 ~ 2022년 12월 16일** 

> 안녕하세요 DPW를 개발한 Tuioe입니다 <br>
> 이번 프로젝트는 대학생때 사이드 프로젝트 & 과제로 제작되었습니다

DPW는 IT 개발 프로젝트를 개발자들이 쉽게 관리할수 있는 웹 사이트 개발 프로젝트입니다 <br>
프로젝트를 생성하여 관리하고 개발일지를 작성하여 💎보상을 얻을수 있습니다 

- [개발환경](#개발환경)

- [사용기술](#사용기술)

  - [Back-End](#back-end)
  - [Front-End](#front-end)
  - [Build tool](#build-tool)
  - [Database](#database)

- [E-R 다이어그램](#e-r-다이어그램)
  
- [API 설계](#api-설계)

- [핵심기능](#핵심기능)

- [개선 및 추가 기능](#개선-및-추가-기능)

## 개발환경

- IntelliJ
- Postman
- GitHub
- GitHub Desktop
- MySQL Workbench
- Visual Studio Code

## 사용기술

### Back-End

- Java 11 OpenJDK
- Spring Boot 2.7.6
- Spring Boot Security
- Spring Data JPA
- MySQL
- Lombok

### Front-End

- JavaScript
- CSS
- Node JS v14.20.0
- React 18.2.0
- Axios 1.2.0
- dayjs 1.11.7
- http-proxy-middleware 2.0.6
- react-github-login-button
- react-datepicker

### Build tool

- Gradle

### Database

- MySQL

## E-R 다이어그램

<img src="https://file.notion.so/f/f/45c14be7-601a-42dd-96b6-66b6c1157be3/8b63058b-42b0-41df-b7a3-36d3aaf4258e/DPJ_(1).png?table=block&id=f04e6a4d-66e8-4e19-8375-df4834d7c3b5&spaceId=45c14be7-601a-42dd-96b6-66b6c1157be3&expirationTimestamp=1736186400000&signature=zQtyRs_iyKOjWB0mQRuUjoUV-Y52FVMiK7B2cRHCB9E&downloadName=DPJ+%281%29.png">

## API 설계
<img src="https://file.notion.so/f/f/45c14be7-601a-42dd-96b6-66b6c1157be3/d941d719-36f2-469f-824c-7f2f38189628/image.png?table=block&id=173ab8ba-1d15-8053-945e-eb0bc0723791&spaceId=45c14be7-601a-42dd-96b6-66b6c1157be3&expirationTimestamp=1736186400000&signature=nQr5IfoeFLAfpj9i88M9TBQQBCyQPb5Taah1zIMfkJk&downloadName=image.png">

## 핵심기능

### 로그인

1. 소셜 로그인
<img src="https://file.notion.so/f/f/45c14be7-601a-42dd-96b6-66b6c1157be3/227a288b-d535-487f-85a9-b8c8a348a7c4/Screenshot_2022-12-14_at_23.51.02.png?table=block&id=2faba1b4-5c7f-49c9-8663-6e53e4117377&spaceId=45c14be7-601a-42dd-96b6-66b6c1157be3&expirationTimestamp=1736186400000&signature=MbrSE-XMO88ajnzBt7nbB6AlJYmIbPiA1Rwg6CqCF40&downloadName=Screenshot+2022-12-14+at+23.51.02.png">

Spring Secrity와 OAuth2 인증 방식을 사용하여 GitHub 로그인을 통해서 유저 이름과 프로필을 요청하여 User,프로필 정보로 사용됩니다 <br>
소셜 로그인은 개발자들이 주로 사용하기 때문에 GitHub 로그인을 채택하였습니다

<img src="https://file.notion.so/f/f/45c14be7-601a-42dd-96b6-66b6c1157be3/ff4de5d5-9b0a-489b-a42f-52cab9f97c3f/Screenshot_2022-12-14_at_23.56.14.png?table=block&id=f5b95b6f-6f94-4723-bc86-e744ffcff737&spaceId=45c14be7-601a-42dd-96b6-66b6c1157be3&expirationTimestamp=1736186400000&signature=cb3nEOv2sATZBxTE8KmpZlQey4NnBMBls4UCb6dM-yE&downloadName=Screenshot+2022-12-14+at+23.56.14.png">

현재 프론트 엔드를 클라이언트 랜더링(CSR)방식인 React를 사용하여 로그인을 요청 하고 서버에서 <br> 
다시 React 주소로 리다이렉트 하는 방식을 사용하고 있습니다 여기서 문제점이 있는데요 

서버에서 로그인 유저정보를 httpSession에 저장하고 불러와서 사용하지만 React로 리다이렉트 하는 과정에서 httpSession의 정보가 사라지는 현상이 발생하여 임시로 `SessionUser` 객체를 만들어 로그인 즉시 정보를 저장하여 사용하도록 구현하였습니다 추후 JWT 토큰 방식을 채택해야 할것 같습니다 

### 기본적인 프로젝트 및 개발일지 CRUD

사용자가 프로젝트를 관리할수 있도록 기본적인 CRUD 기능을 구현 

1. 프로젝트 생성 

<img src="https://file.notion.so/f/f/45c14be7-601a-42dd-96b6-66b6c1157be3/1eae8a28-12f3-45d1-990e-d0e6054bae86/Screenshot_2022-12-14_at_23.47.38.jpg?table=block&id=1a70266b-bd14-4b23-bcf5-e31068d5033d&spaceId=45c14be7-601a-42dd-96b6-66b6c1157be3&expirationTimestamp=1736186400000&signature=EubJBROIQCnkXTXWRpHuc4timeMphiagPjp6NzZQ6M4&downloadName=Screenshot+2022-12-14+at+23.47.38.JPG.jpg">

프로젝트 생성 페이지에서 새로운 프로젝트의 내용을 작성하여 게시물을 등록할수 있습니다

- 프로젝트 기간 달력 형태 선택 기능

<img src="https://file.notion.so/f/f/45c14be7-601a-42dd-96b6-66b6c1157be3/b48ae2d0-48ff-48ed-8247-07ad9f873afd/Screenshot_2022-12-15_at_00.12.32.png?table=block&id=8f1e503f-be4e-4bd8-9206-74b0d81792ce&spaceId=45c14be7-601a-42dd-96b6-66b6c1157be3&expirationTimestamp=1736186400000&signature=dGQapWCRlnUtflBlC5ln2sUbmvA9jY7Rc44zPloi2KI&downloadName=Screenshot+2022-12-15+at+00.12.32.png">

프로젝트 기간을 설정할때 React의  datepicker 라이브러리를 활용하여 달력 형태로 구현
시작일은 현재 날짜 이상만 선택 가능하도록 제한하였습니다

선택한 날짜는 dayjs 라이브러리로 포맷을 지정하여 (YYYY-MM-DD) 형태로 서버에 전송됩니다

2. 프로젝트 관리 

<img src="https://file.notion.so/f/f/45c14be7-601a-42dd-96b6-66b6c1157be3/21a6cb65-72ea-4a2d-97e9-c84476959307/Screenshot_2022-12-15_at_00.23.48.png?table=block&id=c8367228-050c-4e06-835b-fd416ba893a9&spaceId=45c14be7-601a-42dd-96b6-66b6c1157be3&expirationTimestamp=1736186400000&signature=BfnUofnd0CF8LNC20BY9RSUlWj19YszvSyi4fGuis6s&downloadName=Screenshot+2022-12-15+at+00.23.48.png">

프로젝트 상세 페이지에서 프로젝트 수정 및 삭제와 개발일지 작성,조회를 할수 있습니다 
이미지 업로드,태그 작성 기능은 아직 미구현 입니다 

- 개발 일지 작성

<img src="https://file.notion.so/f/f/45c14be7-601a-42dd-96b6-66b6c1157be3/832a2236-5579-4b2a-9902-e29bb917856c/Screenshot_2022-12-15_at_00.31.42.png?table=block&id=b53abd98-bb45-4e86-964e-77efd8d03477&spaceId=45c14be7-601a-42dd-96b6-66b6c1157be3&expirationTimestamp=1736186400000&signature=aMt9x3kyyYHFElJGSKFrfD5zSD1vDiIZPE14NxCm7UY&downloadName=Screenshot+2022-12-15+at+00.31.42.png">

프로젝트의 개발일지를 작성할수 있습니다 작성날짜는 현재 날짜로 지정됩니다 
작성된 개발일지는 목록 또는 단건으로 조회가 가능합니다 

<img src="https://file.notion.so/f/f/45c14be7-601a-42dd-96b6-66b6c1157be3/2f7335df-39e8-4886-84cc-80632de90ecf/%EB%B3%B4%EC%84%9D.png?table=block&id=8bd45896-f967-406c-876e-cebc9520e5fc&spaceId=45c14be7-601a-42dd-96b6-66b6c1157be3&expirationTimestamp=1736186400000&signature=XbZBGjds3ASwsTD3WENg17vC9aOzedUoegKF6NnFUX8&downloadName=%EB%B3%B4%EC%84%9D.PNG.png">

개발 일지를 한번 작성할때마다 25포인트가 보상으로 지급됩니다 

- 개발 일지 조회

<img src="https://file.notion.so/f/f/45c14be7-601a-42dd-96b6-66b6c1157be3/ed215afd-f47d-4a0c-912a-82fee32cc829/Screenshot_2022-12-16_at_02.01.25.png?table=block&id=aa5e9a53-54e8-4367-aa55-2aca14b0ccf1&spaceId=45c14be7-601a-42dd-96b6-66b6c1157be3&expirationTimestamp=1736186400000&signature=7qg49LRwcx_z-QEQo2EW61c0ToCo-kK6qbYHdOWkOKk&downloadName=Screenshot+2022-12-16+at+02.01.25.png">

리스트 형태로 작성한 개발일지를 볼수 있습니다

<img src="https://file.notion.so/f/f/45c14be7-601a-42dd-96b6-66b6c1157be3/646ebaec-5520-4547-a32f-b875100164e8/Screenshot_2022-12-16_at_00.06.58.png?table=block&id=2a9c8deb-a9ec-4006-90d6-be6e301f683e&spaceId=45c14be7-601a-42dd-96b6-66b6c1157be3&expirationTimestamp=1736186400000&signature=vC07tkr2glrbhaHsg7olyFudRhBVy26LDLBC8DQ1Ecc&downloadName=Screenshot+2022-12-16+at+00.06.58.png">

단건 조회로 개발일지의 상세 정보를 볼수 있습니다 
수정과 삭제 기능도 구현했습니다 

3. 깃허브 로그인
<img src="https://file.notion.so/f/f/45c14be7-601a-42dd-96b6-66b6c1157be3/50462a51-1a6e-423a-bf07-b29f4dcd2ad0/Screenshot_2022-12-16_at_01.28.11.png?table=block&id=26bfdba7-0739-4273-a3bc-e0f9c51a53dc&spaceId=45c14be7-601a-42dd-96b6-66b6c1157be3&expirationTimestamp=1736186400000&signature=jMu7KdYUFEJd1UEYNS2KPi8aBLafDVIVGLBfQ2T2jK4&downloadName=Screenshot+2022-12-16+at+01.28.11.png">

Spring boot의 OAuth2 인증 방식을 통해서 로그인 기능을 구현 프론트를 리액트 사용으로 포트 번호가 달라 로그인 버튼 클릭시
서버에서 로그인을 처리후 3000번 포트로 URL를 변경 하는 방식을 사용했습니다 <br> 

로그인 기능은 원할하게 가능하지만 로그아웃 기능은 아직 구현하지 못했습니다 

## 개선 및 추가 기능

프로젝트 생성시 이미지 업로드,태그 작성 기능 해당 프로젝트에 댓글 달기, 좋아요  
로그인&로그아웃 기능 향상 및 수정 프로젝트 내용 작성을 마크 다운을 지원하는 토스트 에디터 적용 (React) 

추후 Springboot,React 배포 ([AWS](https://aws.amazon.com/ko/),[Vercel](https://vercel.com/))

### react 사용 라이브러리 

axios: npm install axios

react-github-login-button: npm install --save react-github-login-button <br>
(https://www.npmjs.com/package/react-github-login-button) 

dayjs: npm install dayjs

react-datepicker: npm install react-datepicker --save

react-router-dom: npm install react-router-dom
