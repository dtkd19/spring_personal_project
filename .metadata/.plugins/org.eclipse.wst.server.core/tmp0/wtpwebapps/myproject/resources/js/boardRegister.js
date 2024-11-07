console.log("boardRegister.js.in");

document.getElementById('trigger').addEventListener('click', () => {
    document.getElementById('file').click();
})

// 실행파일에 대한 정규표현식 작성 / 파일 최대 사이즈 20MB
const regExp = new RegExp("\.(exe|jar|msi|dll|sh|bat)$");
const maxSize = 1024*1024*20;

function fileValidation(fileName, fileSize){
    if(regExp.test(fileName)){
        return 0;
    } else if (fileSize > maxSize){
        return 0;
    } else {
        return 1;
    }
}

document.addEventListener('change', (e) => {
    console.log(e.target);
    if(e.target.id == 'file'){ // 파일창에 변화가 생겼다면..
        // type="file" element에 저장된 file 정보를 가져오는 property files
        const fileObj = document.getElementById('file').files;
        console.log(fileObj);

        // 한번 disabled 되면 혼자 false가 될 수 없기때문에 버튼을 원상복구.
        document.getElementById('regBtn').disabled = false;

        // 내가 등록한 파일 정보를 파일 목록으로 추가
        // 등록한 파일이 fileValidation 에 맞지 않으면 register 버튼을 비활성화
        // 파일 목록에 업로드 불가능이라고 추가 빨간색 폰트추가
        let div = document.getElementById('fileZone');
        div.innerHTML = ""; // 새로 추가되는 목록이 있다면 삭제하고 처리

       // 여러개의 첨부파일이 모두 검증을 통과해야만 register 버튼을 활성화
       // isOk = 1 * 리턴이 0이 하나라도 있으면 => 0  (1부터 시작하는 누적 곱) 
       let isOk = 1;
       let ul = ` <ul class="list-group list-group-flush">`
        // 개별 파일에 대한 검증 / 결과 표시
        for(let file of fileObj){
            // 개별 파일에 대한 검증 결과 리턴 변수
            let validResult = fileValidation(file.name, file.size)
            isOk *=  validResult;
            ul +=  `<li class="list-group-item">`;
            ul += `<div class="ms-2 me-auto">`;
            ul += `${validResult ? `<div class="fw-bold text-success-emphasis"></div>` : `<div class="fw-bold text-danger-emphasis">업로드 불가능</div>`}`;
            ul += `${file.name}</div>`;
            ul += `<span class="badge text-bg-${validResult ? 'success' : 'danger'} rounded-pill">${file.size}Bytes</span>`
            ul += `</li>`;
        }
       ul += `</ul>`
       div.innerHTML += ul;
        if(isOk == 0){
            // 하나라도 검증을 통과하지 못한 파일이 있다면... 버튼 비활성화
            document.getElementById('regBtn').disabled = true;
        }

       
    }
})