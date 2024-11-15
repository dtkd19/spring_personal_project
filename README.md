## 스프링 게시판 프로젝트
- Spring을 사용해서 기본적인 커뮤니티 게시판을 구현한 프로젝트입니다.

## ❓ 프로젝트 소개
Spring과 DB를 사용하여 MVC 패턴의 이해도를 높히고 데이터의 저장 / 조회 / 수정 등의 작업을 익힐 수 있도록  
게시판을 만들어보았습니다.

## ⚙ 개발환경
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)


## 🕰 개발기간
- 24.11.06(수) ~ 24.11.11(월)
## 🛠 프로젝트 기능 설명

### 게시판기능

<details>
<summary>모든 게시글 목록확인 및 페이징</summary>

● 모든 게시글을 가져와 한 페이지에 10개의 게시글이 보이도록 페이징 처리를 구현하였습니다.

● 한번에 10페이지까지 나오며 다음버튼을 누르면 10페이지 다음페이지 목록으로 넘어갑니다. (ex 11페이지, 21페이지)  이전버튼을 누르면 전 페이지목록으로 이동합니다 (ex 10페이지, 20페이지 ... ) 

● 첨부파일이있는 게시글에는 첨부파일 표시가 나타나고 제목옆에 댓글 총수를 나타낼 수 있도록 합니다. 

<img src="https://github.com/user-attachments/assets/1631381e-a7f2-4e88-9623-188897239422" alt="image" />
<img src="https://github.com/user-attachments/assets/3328300c-cb9b-4ef1-a93c-39dd6a1f64f2" alt="Image description">

</details>

<details>
● 게시판의 제목을 클릭하면 안의 상세페이지로 들어와 내용을 확인 할 수 있습니다.
<summary>게시글 내용조회</summary>
<img src="https://github.com/user-attachments/assets/ee6ab348-5f2d-4464-99ff-3b8d7dd8fb2a" alt="Image description">

</details>

<details>
● 원하는 항목을 선택해서 검색을 할 수 있도록 분류카테고리와 검색창을 구현하였으며, 검색버튼의 총 검색결과 수를 표현하였습니다.
<summary>분류 선택 후 분류별 검색기능</summary>
<img src="https://github.com/user-attachments/assets/20e96d58-3afc-421c-a22a-161521d568f7" alt="Image description">
<img src="https://github.com/user-attachments/assets/3d173747-af8d-47a2-a719-741f2308e3a1" alt="Image description">

</details>

<details>
● 댓글과 조회수 높은순으로 10개의 게시글을 정렬해서 표시할 수 있는 버튼을 구현하였습니다.
<summary>댓글 / 조회순 TOP10 표시</summary>
<img src="https://github.com/user-attachments/assets/a8416a56-4cc5-4b4c-9723-f2fe277231f7" alt="image">
<img src="https://github.com/user-attachments/assets/e7b6ef00-03b2-4c77-979c-395432e8a75b" alt="image">

</details>

<details>
<summary>게시글 작성</summary>

● 로그인한 회원만이 작성이 가능하며 로그인을 하지않을 시 로그인창으로 이동합니다.

● 제목과 내용을 입력하고 등록버튼을 누르면 게시판에 글이 추가됩니다.

● 파일첨부가 가능하도록 구현하였습니다.

<img src="https://github.com/user-attachments/assets/c1e37e04-84af-4796-9270-f806b9414fb7" alt="Image description">
<img src="https://github.com/user-attachments/assets/f970e699-7081-45f0-8b8a-0fbef7b8ceef" alt="Image description">
<img src="https://github.com/user-attachments/assets/93287a14-b384-4bcd-9203-1ca8fb1939b0" alt="Image description">

</details>

<details>
<summary>게시글 수정</summary>
● 상세페이지안의 수정버튼을 누르면 수정페이지로 넘어와 제목과 내용, 첨부파일을 수정할 수 있도록 구현하였습니다.
<img src="https://github.com/user-attachments/assets/4dc0c495-38f9-46fc-8a0d-83572d7bd987" alt="Image description">

</details>

<details>
<summary>게시글 삭제</summary>
● 게시글안의 삭제버튼을 누르면 게시글이 삭제될 수 있도록 구현하였습니다.
<img src="https://github.com/user-attachments/assets/e55ceb99-b7df-40d2-ab12-f938c3647245" alt="Image description">
<img src="https://github.com/user-attachments/assets/a310cc8d-0b4f-446d-a902-740b2e9799bd" alt="Image description">
<img src="https://github.com/user-attachments/assets/12baf52a-f9d1-473d-a837-bfa43bbfac6f" alt="Image description">


</details>

### 유저기능
<details>
<summary>회원가입</summary>
● 본인이 사용할 별명, 이메일, 비밀번호를 입력해서 회원가입을 할 수 있도록하고 회원가입이 되면 기본적인 권한(글쓰기 내정보보기 등) 을 줄 수 있도록 구현하였습니다.
<img src="https://github.com/user-attachments/assets/469abbdb-ed1a-40f7-b1dc-b9a1b78f7bb4" alt="Image description">
<img src="https://github.com/user-attachments/assets/06e585cf-3357-4f58-a0e6-d1d15cf312bb" alt="Image description">

</details>

<details>

●  회원가입한 아이디와 비밀번호를 사용해서 로그인이 가능하도록하고 로그인이되면 기본적으로 받은 권한으로 글쓰기와 내정보메뉴를 메뉴바에 나타내도록합니다.

● 메인화면에 본인이 설정한 닉네임이 나타나며 인사문구를 출력합니다.
<summary>로그인</summary>
<img src="https://github.com/user-attachments/assets/c4abd745-abb1-4728-9dd0-12270ed7d842" alt="Image description">
<img src="https://github.com/user-attachments/assets/50d86660-2ab4-4e24-aae5-dbb63bd4d5d2" alt="Image description">

</details>

<details>
<summary>로그아웃</summary>
● 로그아웃 버튼을 누르면 비회원으로 돌아가 권한이 사라져 메뉴가 다시 원래대로 바뀌며 메인화면에 별명이 출력되는것이 사라집니다.
<img src="https://github.com/user-attachments/assets/f80505ed-818a-4df9-8681-ee6c75fe0e1c" alt="Image description">

</details>

<details>
<summary>내정보 수정</summary>
● 내정보 페이지로 넘어가면 나의정보가 출력되도록 카드형식으로 만들어놓았으며,
별명과 비밀번호를 바꿀 수 있도록 해두었고 수정버튼을 누르면 정상적으로 수정되도록 구현하였습니다.
<img src="https://github.com/user-attachments/assets/51c8e625-74fd-474d-9f1f-ca68b2b25674" alt="Image description">

</details>

<details>
<summary>회원탈퇴</summary>
● 내정보페이지에서 회원탈퇴버튼을 누르면 회원탈퇴 완료를 알려주며 로그아웃된 메인페이지로 돌아오도록 구현하였습니다.
<br>
<img src="https://github.com/user-attachments/assets/d4c8be21-cf7f-4af4-8ff4-2ee2e6884283" alt="Image description">
<img src="https://github.com/user-attachments/assets/f80505ed-818a-4df9-8681-ee6c75fe0e1c" alt="Image description">

</details>

<details>

● 회원은 게시글마다 좋아요를 하나씩 누를 수 있으며 좋아요를 누르면 성공알림이 나오며 하트가 채워지고, 좋아요 수가 하나 올라갑니다.

● 다시한번 눌렀을 때 취소 성공알림이 나오며 채워진 하트가 빈 하트로 바뀌고 좋아요 수가 하나 내려가도록 구현하였습니다.
<summary>좋아요기능</summary>
<img src="https://github.com/user-attachments/assets/d4fdf49b-f930-4777-9617-c0d4524ab1ce" alt="Image description">
<img src="https://github.com/user-attachments/assets/315058c0-2b9f-42ba-b8ff-5733244a3404" alt="Image description">
<img src="https://github.com/user-attachments/assets/9bf680ba-669b-40aa-b0de-2b541f7acdca" alt="Image description">
<img src="https://github.com/user-attachments/assets/72c43e9b-535e-4265-8690-0a5530bfc7cb" alt="Image description">
<img src="https://github.com/user-attachments/assets/f41f150d-7022-492a-800b-c8a52dbff8be" alt="Image description">



</details>

### 댓글기능

<details>
<summary>댓글 작성</summary>
● 유저의 별명과 함께 댓글창이 나와있으며 내용을입력하고 등록하면 댓글이 등록되도록 구현하였습니다.
    
● 댓글 삭제/수정 버튼은 어드민권한을 가진 유저를 제외하면 본인댓글은 본인만 볼 수 있도록 구현하였습니다.
<img src="https://github.com/user-attachments/assets/b2bea2f5-29e5-4021-869f-5b6050005aba" alt="Image description">
<img src="https://github.com/user-attachments/assets/015bc21b-7f76-441d-a3d4-aaedcbb7da9f" alt="Image description">

</details>

<details>
<summary>댓글 수정</summary>

●  수정버튼을 누르면 작성자와 내용이 적혀있는 모달창이나와서 수정이 가능하도록 구현하였습니다.

● 내용을 수정하고 수정버튼을 누르면 정상적으로 댓글내용이 변경됩니다.
<img src="https://github.com/user-attachments/assets/8c108cc9-975e-4897-bc55-ec9cc61353b2" alt="Image description">
<img src="https://github.com/user-attachments/assets/8de6e955-3779-482c-8542-af30ccbd87fe" alt="Image description">
<img src="https://github.com/user-attachments/assets/01b37a86-a3c1-4409-bda3-877cb05b5d03" alt="Image description">

</details>

<details>
<summary>댓글 삭제</summary>
● 삭제버튼을 누르면 성공알림이 나오면서 댓글에서 삭제되도록 구현하였습니다.
<img src="https://github.com/user-attachments/assets/66177971-3ded-453a-8f43-377e9846e2f9" alt="Image description">
<img src="https://github.com/user-attachments/assets/581f61fa-3c6c-4b1f-b1e3-d76a5fbf6343" alt="Image description">


</details>

### 권한기능
<details>
<summary>모든 댓글 삭제가능</summary>
● 권한이 ADMIN인 계정으로 로그인하면 댓글 삭제 / 수정 버튼이 본인 댓글이 아니더라도 모두 보이도록 구현하였습니다.
<img src="https://github.com/user-attachments/assets/78c09989-9c22-4820-8e74-c963ce0ed14c" alt="Image description">

</details>

<details>
<summary>유저리스트</summary>
● 권한이 ADMIN인 계정으로 로그인하면 사용자 목록을 볼 수 있는 메뉴가 나타나도록 구현하였습니다.

● 사용자 목록을 누르면 회원가입된 유저들의 리스트가 카드형식으로 표현될 수 있도록 구현하였습니다.
<img src="https://github.com/user-attachments/assets/8324b777-882f-426f-bdc9-d7a73aeec911" alt="Image description">
<img src="https://github.com/user-attachments/assets/9751aad0-3548-404f-8094-99f7a592dcc3" alt="Image description">

</details>




## 📑 DB설계

<img src="https://github.com/user-attachments/assets/9d1e5a53-aa0f-4e81-b280-1f856f76bd52" alt="Image description">

## 프로젝트를 마치며

- 이번 프로젝트를 통해 Spring Framework와 데이터베이스 연동에 대한 깊은 이해를 얻을 수 있었습니다.

- session이나 댓글에서 사용한 ajax 비동기 방식의 통신 등 HTTP 통신에 대한 이해도 높아졌습니다.

- Spring의 다양한 기능을 활용하여 게시판을 구축하는 과정에서 MVC 패턴의 전체적인 흐름을 익힐 수 있었고, 실무에서의 적용 가능성도 느낄 수 있었습니다. 

- Spring과 DB의 유기적인 연동을 통해 효율적인 웹 애플리케이션을 구현할 수 있다는 자신감을 얻었으며, 앞으로도 더 복잡한 시스템을 다룰 때 이 경험을 바탕으로 더 나은 개발을 할 수 있을 것입니다.

- 다만 본인이 작성한 코드임에도 완벽하게 타인에게 설명할 수 있을지는 아직 어려움을 느끼기에 부족한 부분을 더 공부해 남에게 설명할 수 있을 수준으로 이해도를 올려야겠다고 생각했습니다.

- 따라서 앞으로 다른 프로젝트나, 개인공부를 통해 백엔드 실력을 향상시키도록 노력하겠습니다. 

    <strong> 읽어주셔서 감사합니다. </strong>

