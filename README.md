## 프로필

- 이름: 김혁진
- 1999.11.11 출생
- phone: 010-9406-3580
- Email: r3rumasi2@gmail.com
- GitHub: [github.com/kimhyeokjin1111](https://github.com/kimhyeokjin1111)


> 한경대학교 졸업(2018.03-2024.02)  
> 경동고등학교 졸업(2015.03-2018.02)

##  지향
```
여러 방법을 적용할 수 있는 유연한 사고를 가진 개발자를 목표로 하고 있습니다.
```


## 스택

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/springboot-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white)
<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white">
<img src="https://img.shields.io/badge/CSS-1572B6?style=for-the-badge&logo=CSS3&logoColor=white">
<img src="https://img.shields.io/badge/JPA-007396?style=for-the-badge&logo=Java&logoColor=white">



## 툴

<img src="https://img.shields.io/badge/eclipseide-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white">
<img src="https://img.shields.io/badge/intellijidea-000000?style=for-the-badge&logo=intellijidea&logoColor=white">
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
<img src="https://img.shields.io/badge/visual studio code-007ACC?style=for-the-badge&logo=visualstudiocode&logoColor=white">



## 프로젝트
- 1\. [ hippoBook](#hippobook) (2024.4.21~2024.5.30)
- 2\. [ pika](#pika) (2025.12.15~2025.1.9)

## HippoBook
>개인 책장 서비스 및 커뮤니티 사이트 (팀 프로젝트)  
>개발 기간: 2024.4.21 ~ 2024.5.30 
>  
>기술 스택:  
>Java 17 / Spring Boot / JSP / html / Javascript / Oracle / MyBatis


## 1. 제작 기간 & 참여 인원
- 2024년 4월 27일 ~ 5월 30일
- 팀 프로젝트


## 2. 사용 기술
#### `Back-end`
  - Java 17
  - Spring Boot 3.0
  - Gradle
  - Oracle 11.2.0


## 3. ERD 설계
  ![ddl](https://github.com/kimhyeokjin1111/myGitHub/assets/159498606/2aadb451-ce7d-41f3-9d20-cfaa95442b8e)

## 4. 핵심 기능

### 4.1. (OpenAi API)
해당 사이트에 대해 답변해줄 수 있는 챗봇입니다. 
OpenAi API를 활용하여 Client의 요청(질문)에 대해 응답해줍니다.

### 4.1.1. 전체 흐름
<p align="center">
  <img src="https://github.com/kimhyeokjin1111/myGitHub/assets/159498606/78f131bf-120d-4d00-aa66-f7e50a39f6b0">
</p>
<p align="center">
  <img src="https://github.com/kimhyeokjin1111/myGitHub/assets/159498606/d00a303b-f3d8-4cf9-be7a-c74474197e2d" width=300 margin-right=10>
  <img src="https://github.com/kimhyeokjin1111/myGitHub/assets/159498606/6f2142c8-9ef8-4878-9e2c-f50a77a1bf7b" width=300 margin-right=10>
  <img src="https://github.com/kimhyeokjin1111/myGitHub/assets/159498606/7efccc75-3aea-499b-82a9-9c3c6dd9f881" width=300>
</p>

### 4.1.2. 사용자 요청

- **Session userId 체크** 
  - 화면단에서 th:if를 이용해 session.userId이 null인지 확인합니다.
  - null이라면 모달버튼을 생성하지 않습니다.
    
[chatbot.html 코드 확인](https://github.com/kimhyeokjin1111/kimhyeokjin1111.github.io/blob/47767365200b5dac7c990af4edc13e14d2054972/hippobook/src/main/resources/templates/chatbot/chatbot.html
)

- **Fetch 비동기 요청** 
  - 사용자의 채팅를 POST방식으로 비동기 요청을 날립니다.
  - (요청 보냈을 때 채팅이 url상에 노출되는 점과 채팅에 특수문자가 있는 경우 데이터가 손상되는 점  
    REST단에서 채팅에 대한 OpenAi의 답변을 받고 이를 데이터베이스에 INSERT처리를 하는 점을 고려해 POST방식으로 명시해주었습니다.)
    
[chatbot.js 코드 확인](https://github.com/kimhyeokjin1111/kimhyeokjin1111.github.io/blob/47767365200b5dac7c990af4edc13e14d2054972/hippobook/src/main/resources/static/js/chatbot/chatbot.js)
 
### 4.1.3. RestController

- **요청 처리** 
  - RestController에서는 화면단에서 넘어온 요청(채팅)을 받고, Service 계층에서 로직 처리를 넘깁니다.

- **결과 응답** 
  - Service 계층에서 넘어온 로직 처리 결과(OpenAi의 답변)를 화면단에 응답해줍니다.
 
[ChatbotApi.java 코드 확인](https://github.com/kimhyeokjin1111/kimhyeokjin1111.github.io/blob/47767365200b5dac7c990af4edc13e14d2054972/hippobook/src/main/java/com/example/hippobookproject/api/chatbot/ChatbotApi.java)

### 4.1.4. Service

- **과거 채팅 내역 불러오기** 
  - 데이터베이스단에서 채팅 내역을 받아옵니다.
  - OpenApi API 요청body의 message에 과거 채팅 내역을 추가해줍니다.

- **OpenAi API endpoint로 웹 통신** 
  - WebClient 만들어진 body를 endpoint에 요청해줍니다.
  - 공식사이트에 명시된대로 POST방식을 사용해주고 response 1개의 값을 리턴받기 위해 bodyToMono로 사용하였습니다.

- **채팅 내역 저장하기** 
  - 사용자 채팅과 api통신의 response의 컨텐츠에 접근하여 답변을 데이터베이스단에 전달합니다.  

[ChatbotService.java 코드 확인](https://github.com/kimhyeokjin1111/kimhyeokjin1111.github.io/blob/47767365200b5dac7c990af4edc13e14d2054972/hippobook/src/main/java/com/example/hippobookproject/service/chatbot/ChatbotService.java)

### 4.1.5. Database

- **채팅 내역 검색 및 저장**
  - session.userId와 일치하는 사용자 채팅 내역을 읽어 service단으로 넘깁니다.
  - service단에서 넘어온 채팅 내역을 데이터베이스에 저장합니다.

## 5. 담당 파트 

- **관리자 페이지**
  - 사용자 검색 페이지
  ![Honeycam 2024-06-05 12-00-54](https://github.com/kimhyeokjin1111/myGitHub/assets/159498606/c3528db8-5362-481c-a04b-0791cd5dde28)
  - 사이트 방문수 차트 페이지
  ![Honeycam 2024-06-05 12-10-05](https://github.com/kimhyeokjin1111/myGitHub/assets/159498606/1d11899c-38ec-4010-b640-373a32759504)
  - 신고 컨텐츠 처리 페이지
  ![GIF 2024-06-07 오후 12-28-22](https://github.com/kimhyeokjin1111/myGitHub/assets/159498606/36d0c89d-f1d2-4543-92c5-8bdd44a4e33a)
  - 팔로우 수 달성 스티커 승인 페이지
  ![GIF 2024-06-11 오전 2-24-27](https://github.com/kimhyeokjin1111/myGitHub/assets/159498606/65e2b991-9cbe-4c4a-82b3-322c5368cffe)
 
- **도서 페이지**
  - 도서 검색 페이지
  ![GIF 2024-06-10 오전 8-51-17](https://github.com/kimhyeokjin1111/myGitHub/assets/159498606/a42c8ef9-cadc-4129-8a92-60f9f20eee19)
  - 도서 정보 페이지
  ![GIF 2024-06-10 오전 8-56-55](https://github.com/kimhyeokjin1111/myGitHub/assets/159498606/619c538c-ab4f-4c1a-828c-ae3e64b450e6)
  

- **게시판 페이지**
  - 게시글 메인 페이지
![GIF 2024-06-10 오전 9-01-17](https://github.com/kimhyeokjin1111/myGitHub/assets/159498606/1b51b26d-e476-4608-a7ce-8933c243c687)
  - 게시글 뷰 페이지
![GIF 2024-06-10 오전 9-05-30](https://github.com/kimhyeokjin1111/myGitHub/assets/159498606/6f59afff-5bc2-4987-83e3-b458559216f2)

## 배포
![KakaoTalk_20240618_095748382](https://github.com/kimhyeokjin1111/kimhyeokjin1111.github.io/assets/159498606/add39290-8517-4511-b700-b9dbf444b611)
### **서버**
- 오라클 클라우드
- AWS(EC2)

### 서버 연결 
TNS 방식으로 오라클 DB 서버에 연결합니다.  
EC2 서버에 .pem 파일을 통해 연결 후 원격 저장소를 클론하여 빌드를 진행하였습니다. 

### 문제 수정 사항
- 컨틀롤러 응답경로에서 /를 포함한 경우 서버 진입 실패
- html 파일 typeleaf scr경로, fragment경로 문법 오류

## Pika
>서브컬처 중고거래 사이트 (팀 프로젝트)  
>개발 기간: 2025.12.15 ~ 2026.1.9 
>  
>기술 스택:  
>Java 17 / Spring Boot / JPA / html / Javascript / CSS / Oracle


## 1. 제작 기간 & 참여 인원
- 2025년 12월 15일 ~ 2026년 1월 9일
- 팀 프로젝트


## 2. 사용 기술
#### `Back-end`
  - Java 17
  - Spring Boot 3.0
  - Gradle
  - Oracle 11.2.0
  - Websocket protocol

#### `Front-end`
  - HTML
  - CSS
  - JavaScript
  - Typmeleaf

## 3. ERD 설계
  ![ddl](https://github.com/user-attachments/assets/3201cb59-e770-4bb5-8118-c26cbeeea204)

## 4. 핵심 기능

### 4.1. (PortOne api)
복잡한 결제 프로세스를 표준화된 인터페이스로 추상화하기 위해 portOne(구 I'mport) API를 도입하여 결제 시스템의 유연성을 확보하였습니다. 
PG사와의 연동을 단일 규격으로 통합 관리하여 개발 생산성을 높였으며, 
결제 사전/사후 검증 로직을 철저히 구현하여 금전 거래 시 발생할 수 있는 데이터 위변조를 방지하고 트랜잭션의 신뢰성을 보장하였습니다.

### 4.1.1. 전체 흐름
<p align="center">
  <img src="https://github.com/user-attachments/assets/85cabdcd-9971-41e8-bce2-cd35906fa82e">
</p>
<p align="center">
  <img src="https://github.com/user-attachments/assets/2c84e4c2-4b9f-4cfa-b156-5dca0ba9463a">
</p>
<p align="center">
  <img width="300" height="450" alt="Image" src="https://github.com/user-attachments/assets/1a788e5d-2cb3-467b-8231-b31bffc37146" />
  <img width="300" height="450" alt="Image" src="https://github.com/user-attachments/assets/bfd74671-593f-4fdf-8edb-70f65d687ec6" />
  <img width="300" height="450" alt="Image" src="https://github.com/user-attachments/assets/91153ab5-02aa-4169-bf74-8e14d737988c" />
</p>


### 4.1.2. 구매자 요청

- **구매자 요청** 
  - 화면단에서 포트원 api를 통해 결제요청을 합니다.
  - 포트원에서 결제 요청 후 결제 성공 시 url(/api/payment/validation)로 응답을 보냅니다. 
    
[preview.html 코드 확인](https://github.com/kimhyeokjin1111/kimhyeokjin1111.github.io/blob/ea06787cdbdfaf39f0c7d6989a22e7c35c34b787/pika/src/main/resources/templates/payment/preview.html)

### 4.1.3. RestController

- **서버 데이터 검증** 
  - 결제 응답 데이터를는 검증과 동시에 결제 내역을 저장하는 service 처리를 하기 떄문에 PostMapping 방식으로 요청을 받았습니다.
    
- **요청 처리** 
  - RestController에서는 화면단에서 넘어온 검증 데이터를 받고, Service 계층에서 가격 검증로직을 수행합니다.

- **결과 응답** 
  - Service 계층에서 넘어온 저장된 결제 데이터 및 결제 성공 여부를 화면단에 응답해줍니다.
 
[PaymentApiController.java 코드 확인](https://github.com/kimhyeokjin1111/kimhyeokjin1111.github.io/blob/ea06787cdbdfaf39f0c7d6989a22e7c35c34b787/pika/src/main/java/com/numlock/pika/controller/payment/PaymentApiController.java)

### 4.1.4. Service

- **포트원 결제 데이터 요청** 
  - apiKey와 secretKey 정보를 생성자 주입한 iamportClient 객체를 통해 결제 정보를 전달받습니다. 

- **데이터 위변조 검증** 
  - 포트원 결제정보와 프론트단에서 전달 받은 검증 데이터의 가격을 서로 대조합니다.
    - 성공시
      결제 정보를 payments엔티티로 builder하여 저장합니다.
      성공 여부를 RestController에 응답합니다.
    - 실패시 
      실패 여부를 RestController에 응답합니다. 

[PaymentApiService.java 코드 확인](https://github.com/kimhyeokjin1111/kimhyeokjin1111.github.io/tree/ea06787cdbdfaf39f0c7d6989a22e7c35c34b787/pika/src/main/java/com/numlock/pika/service/payment)

### 4.1.5. Database

- **결제 데이터 저장**
  - Payments - 도메인 클래스 정의 (Product, Buyer, Seller 정보 포함)
  - 가격 검증을 마친 결제 데이터를 paymentRepository에 넘겨 save 처리합니다.

[Payments.java 코드 확인](https://github.com/kimhyeokjin1111/kimhyeokjin1111.github.io/blob/ea06787cdbdfaf39f0c7d6989a22e7c35c34b787/pika/src/main/java/com/numlock/pika/domain/Payments.java)  
[PaymentRepository.java 코드 확인](https://github.com/kimhyeokjin1111/kimhyeokjin1111.github.io/blob/ea06787cdbdfaf39f0c7d6989a22e7c35c34b787/pika/src/main/java/com/numlock/pika/repository/PaymentRepository.java)

## 5. 담당 파트 

- **알람**
  - 헤더 내 알람 기능
 <img width="1266" height="577" alt="Image" src="https://github.com/user-attachments/assets/fc5c8700-3a4e-47f0-9f91-529c105cf54f" />

- **상품 페이지**
  - 상품 판매 페이지
    <img width="1000" height="712" alt="Image" src="https://github.com/user-attachments/assets/82954e31-ae56-4e59-a840-c90e13db760b" />

  - 상품 상세 페이지
    <img width="1000" height="712" alt="Image" src="https://github.com/user-attachments/assets/efabe948-a0c2-42f2-8d78-22d63797f85a" />

  - 상품 결제 페이지
    <p align="center">
      <img width="564" height="712" alt="Image" src="https://github.com/user-attachments/assets/c4bb5884-58d3-41ab-a54f-fa6ff7807c98" />
    </p>

- **내역 페이지**
  <img width="1000" height="712" alt="Image" src="https://github.com/user-attachments/assets/39e8e2dd-0a2c-4b18-8f40-311318a1ecee" />
  
## [프로필](#프로필)
