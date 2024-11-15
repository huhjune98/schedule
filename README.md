# 일정 관리 앱

## API 명세서


#### 1. 일정 CRUD

##### 일정 생성
- **URL**: `/api/schedules`
- **Method**: `POST`
- **상태코드**: '200: 정상 등록, 400: 등록 실패'
- **요청**



  |이름|타입|설명|필수|
  |:----:|:----:|:-------:|:--:|
  |username|String|사용자 이름|O|
  |title|String|일정 제목|O|
  |contents|String|일정 내용|X|

  ```json
  {
    "username": "허준",
    "title": "운동가기",
    "contents": "일어나서 운동가기"
  }
- **응답**

  
  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |eventId|integer|일정 고유 아이디 생성|
  |userName|String| 이름 확인|
  |title|String|제목 확인|
  |contents|String|내용 확인|
  |createDate|LocalDateTime|일정 생성 날짜 저장|
  |upadteDate|LocalDate|일정 수정 날짜 저장|
  
  ```json
  {
    "eventId": "1234",
    "userName": "허준",
    "title": "운동가기",
    "contents": "일어나서 운동가기",
    "createDate": "2024-10-31",
    "updateDate": "2024-11-01"
  }

##### 전체 일정 조회
- **URL**: `/api/schedules`
- **Method**: `GET`
- **상태코드**: '200: 정상 조회, 400: 조회 실패'

- **응답**

  
  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |eventId|integer|일정 고유 아이디 확인|
  |title|String|제목 확인|
  |contents|String|내용 확인|
  |createDate|LocalDate|일정 생성 날짜 확인|
  |upadteDate|LocalDate|일정 수정 날짜 확인|
  ```json
  {
    "eventId": "1234", 
    "title": "운동가기",
    "contents": "일어나서 운동가기",
    "createDate": "2024-10-31",
    "updateDate": "2024-11-01"
  }


##### 선택 일정 조회
- **URL**: `/api/schedules/{scheduleId}`
- **Method**: `GET`
- **상태코드**: '200: 정상 조회, 400: 조회 실패'
- **요청**

  
  |이름|타입|설명|필수|
  |:----:|:----:|:-------:|:--:|
  |eventId|Integer|일정 아이디 확인|O|
  ```json
  {
    "eventId": "허준"
  }
- **응답**

  
  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |eventId|integer|일정 고유 아이디 확인|
  |title|String|제목 확인|
  |contents|String|내용 확인|
  |createDate|LocalDate|일정 생성 날짜 확인|
  |upadteDate|LocalDate|일정 수정 날짜 확인|
  ```json
  {
    "eventId": "1234", 
    "title": "운동가기",
    "contents": "일어나서 운동가기",
    "createDate": "2024-10-31",
    "updateDate": "2024-11-01"
  }


##### 선택 일정 수정
- **URL**: `/api/schedules/{scheduleId}`
- **Method**: `PUT`
- **상태코드**: '200: 정상 수정, 400: 수정 실패'
- **요청**

  
  |이름|타입|설명|필수|
  |:----:|:----:|:-------:|:--:|
  |title|String|수정 할 제목|X|
  |username|String|수정 할 이름|X|
  ```json
  {
    "title": "운동가기",
    "username": "허준"
  }
- **응답**

  
  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |message|String|수정 완료시 알림|
  |title|String|제목 수정|
  |contents|String|내용 수정|
  |createDate|LocalDate|일정 생성 날짜 확인|
  |upadteDate|LocalDate|일정 수정 날짜 갱신|
  ```json
  {
    "title": "밥먹기",
    "contents": "일어나서 밥먹기",
    "createDate": "2024-10-31",
    "updateDate": "2024-11-02"
  }

  
##### 선택 일정 삭제
- **URL**: `/api/schedules/{scheduleId}`
- **Method**: `DELETE`
- **상태코드**: '404 Not Found: 해당 ID가 존재하지 않을 때'

#### 2. 유저 CRUD

##### 유저 등록
- **URL**: `/api/users/signup`
- **Method**: `POST`
- **상태코드**: '200: 정상 등록, 400: 등록 실패'
- **요청**



  |이름|타입|설명|필수|
  |:----:|:----:|:-------:|:--:|
  |username|String|사용자 이름|O|
  |email|String|이메일 주소|O|

  ```json
  {
    "username": "허준",
    "email": "huhjune1215@gamil.com"
  }
- **응답**

  
  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |userId|integer|일정 고유 아이디 생성|
  |userName|String| 이름 확인|
  |title|String|제목 확인|
  |contents|String|내용 확인|
  |createDate|LocalDateTime|일정 생성 날짜 저장|
  |upadteDate|LocalDate|일정 수정 날짜 저장|
  
  ```json
  {
    "userId": "1234",
    "userName": "허준",
    "email": "huhjune1215@gamil.com",
    "createDate": "2024-10-31",
    "updateDate": "2024-11-01"
  }



##### 유저 조회
- **URL**: `/api/users/signup/{userid}`
- **Method**: `GET`
- **상태코드**: '200: 정상 조회, 400: 조회 실패'

- **응답**

  
  |이름|타입|설명|
  |:----:|:----:|:-------:|
  |userId|integer|유저 아이디|
  |userName|String| 이름 확인|
  |email|String|이메일 확인|
  |createDate|LocalDateTime|일정 생성 날짜 저장|
  |upadteDate|LocalDate|일정 수정 날짜 저장|
  
  ```json
  {
    "userId": "1234",
    "userName": "허준",
    "email": "huhjune1215@gamil.com",
    "createDate": "2024-10-31",
    "updateDate": "2024-11-01"
  }


##### 유저 삭제
- **URL**: `/api/users/{userId}`
- **Method**: `DELETE`
- **상태코드**: '404: No Content'


#### 3. 로그인

##### 유저 등록
- **URL**: `/api/users/login`
- **Method**: `POST`
- **상태코드**: '200: 정상 등록, 400: 등록 실패'
- **요청**



  |이름|타입|설명|필수|
  |:----:|:----:|:-------:|:--:|
  |email|String|이메일 주소|O|
  |password|String|비밀번호|O|

  ```json
  {
    "email": "huhjune1215@gamil.com",
    "password": "비밀번호"
  }


## ERD

<img width="466" alt="스크린샷 2024-11-14 오후 7 31 53" src="https://github.com/user-attachments/assets/054786f7-b31f-4af1-ab75-f3ff09e9be8e">

