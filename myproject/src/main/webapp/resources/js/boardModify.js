console.log("boardModfiy.js in !!")
document.addEventListener('click', (e) => {
    if(e.target.classList.contains('file-x')){
        let button = e.target.closest('button');
        let uuid = button.dataset.uuid;
        let li = e.target.closest('li');
        console.log(button);
        console.log(uuid);
        console.log(li);

        removeFileToServer(uuid).then(result => {
            if(result == '1'){
                li.remove();
                alert("파일 삭제 성공");
            } else{
                alert("파일 삭제 실패");
            }
        })
        

    }
})

async function removeFileToServer(uuid) {
    try {
        const url = ("/board/file/"+ uuid)
        const config = {
            method : 'delete'
        }
        const resp = await fetch(url, config); 
        const result = await resp.text();
        return result;

    } catch (error) {
        console.log(error);
    }
}