console.log("boardDetailComment.js in");


document.getElementById('cmtBtn').addEventListener('click' , () =>{
    const cmtText = document.getElementById('cmtText');
    const cmtWriter = document.getElementById('cmtWriter');

    if(cmtText.value == null || cmtText.value == ''){
        alert('댓글을 입력해주세요.');
        cmtText.focus();
        return false;
    }
    let cmtData ={
        bno : bnoVal,
        writer : cmtWriter.innerText,
        content : cmtText.value
    }
    console.log(cmtData);

    postCommentToServer(cmtData).then(result => {
        if(result == '1'){
            alert("댓글 등록 성공");
            cmtText.value = "";
            spreadCommentList(bnoVal);
        }    
    })

})


function spreadCommentList(bno, page = 1){
    getCommentListFromServer(bno,page).then(result => {
        console.log(result);
        // 댓글 뿌리기
        const ul = document.getElementById('cmtListArea');
        if( result.cmtList.length > 0 ){
            if( page == 1 ){
                ul.innerHTML = ""; 
            }
            for(let cvo of result.cmtList){
                let li = `<li class="list-group-item" data-cno=${cvo.cno}>`;
                li += `<div class="ms-2 me-auto">`;
                li += `<div class="fw-bold">${cvo.writer}</div>`;
                li += `${cvo.content}`;
                li += `</div>`;
                li += `<span class="badge text-bg-primary rounded-pill">${cvo.regDate}</span>`;
                // 버튼 
                if(authNick == cvo.writer || admin == `true`){
                    li += `<div class="d-grid gap-2 d-md-flex justify-content-md-end">`;
                    li += `<button type="button" data-cno=${cvo.cno} class="btn btn-outline-warning btn-sm mod" data-bs-toggle="modal" data-bs-target="#myModal">%</button>`;
                    li += `<button type="button" data-cno=${cvo.cno} class="btn btn-outline-danger btn-sm del">X</button>`;
                    li += `</div>`;
                }
                li += `</li>`;
                ul.innerHTML += li;           
            } 
             // 더보기 버튼 숨김여부 체크 코드
             let moreBtn = document.getElementById('moreBtn');
             // 더보기 버튼이 표시되는 조건
             // result = ph > pgvo > pageNo = 1 / realEndPage = 2 
             // 현재 페이지가 전체 페이지보다 작으면 표시 
             if(result.pgvo.pageNo < result.realEndPage){
                 // style.visibility = "hidden" : 숨김 / "visible" : 표시
                 moreBtn.style.visibility = 'visible'; // 버튼표시
                 moreBtn.dataset.page = page + 1 ; // 1페이지 증가
             } else{
                 moreBtn.style.visibility = 'hidden';
             }
        } else{
            ul.innerHTML = `<li class="list-group-item">Comment List Empty</li>`;
        }

    })

}

document.addEventListener('click', (e) => {
    // console.log(e.target);
    // 내가 클릭한 버튼의 객체를 모달창으로 전달
    if(e.target.classList.contains('mod')){
        // 내가 클릭한 버튼의 li를 가져오기
        // closest : 가장 가까운 (나를포함한) 태그 (부모태그)
        let li = e.target.closest('li');
        let cmtText = li.querySelector('.fw-bold').nextSibling;
        console.log(cmtText);
        document.getElementById('cmtTextMod').value = cmtText.nodeValue;
        
        let cno = li.dataset.cno;


        let cmtWriter = li.querySelector('.fw-bold').innerText;
        console.log(cmtWriter);
        document.getElementById('cmtWriterMod').innerHTML = `<b style="color: black"> ${cmtWriter} </b> `;

        // cmtModBtn => cno 값을 dataset으로 달기
        document.getElementById('cmtModBtn').setAttribute("data-cno", cno);


    }
    if(e.target.id == 'cmtModBtn'){
        let cmtData = {
            cno: e.target.dataset.cno,  
            content: document.getElementById('cmtTextMod').value
        }
        console.log(cmtData);
        updateCommentToServer(cmtData).then(result => {
            if(result == '1'){
                alert("댓글 수정 성공");
            } else{
                alert("댓글 수정 실패");
            }    
            // 모달창 닫기
            document.querySelector('.btn-close').click();
            // 댓글 뿌리기
            spreadCommentList(bnoVal);
        })
    }

    if(e.target.classList.contains('del')){

        let li = e.target.closest('li');

        let cno = li.dataset.cno;

        removeCommentToServer(cno).then(result => {
            if(result == '1'){
                alert("댓글 삭제 성공");
            } else{
                alert("댓글 삭제 실패");
            }
            spreadCommentList(bnoVal);
        })
    }
    if(e.target.id == "moreBtn"){
        let page = parseInt(e.target.dataset.page);
        spreadCommentList(bnoVal, page);
    }

})


async function postCommentToServer(cmtData) {
    try {
        const url = "/comment/post"
        const config = {
            method: 'post',
			headers: {
				'Content-Type': 'application/json; charset=utf-8'
			},
			body: JSON.stringify(cmtData)
        };
        const resp = await fetch(url, config);
        console.log(resp);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

async function getCommentListFromServer(bno, page) {
    try {
        const resp = await fetch("/comment/"+ bno + "/" + page)
        const result = await resp.json();
        return result;
    } catch (error) {
        console.log(error);
    }
}

async function updateCommentToServer(cmtData) {
    try {
        const url = "/comment/modify";
        const config ={
            method : "put",
            headers : {
                'Content-Type' : 'application/json; charset=utf-8'
            },
            body : JSON.stringify(cmtData)
        };
        const resp = await fetch(url,config);
        const result = await resp.text();

       return result; 

    } catch (error) {
        console.log(error);
    }
}

async function removeCommentToServer(cno) {
    try {
        const url = ("/comment/"+ cno)
        const config = {
            method : 'delete'
        }
        const resp = await fetch(url, config); 
        // const resp = await fetch("/commet/" + cno , {method: 'delete'})
        const result = await resp.text();

        return result;

    } catch (error) {
        console.log(error);
    }
}