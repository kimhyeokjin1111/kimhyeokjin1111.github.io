export function remove(idList,callback){
    let param = '?';
    idList.forEach(id => param += 'id='+id + '&');
    param = param.slice(0, -1);

    fetch(`/v1/messages${param}`, {
        method: 'DELETE',
    }).then(resp => {
        if(resp.status === 200){
            callback();
        }
    });
}

export function remove2(idList,callback){
    let param = '?';
    idList.forEach(id => param += 'id='+id + '&');
    param = param.slice(0, -1);

    fetch(`/v2/messages${param}`, {
        method: 'DELETE',
    }).then(resp => {
        if(resp.status === 200){
            callback();
        }
    });
}

export function select(userNickname){
    fetch(`/v1/nickname/${userNickname}`, {
        method: 'GET'
    }).then(resp => {
        return resp.json();
    }).then(data =>{
        if (data === false){
            alert("존재하지 않는 아이디입니다.");
        }else{
            alert("쪽지가 가능한 아이디입니다.")
        }

    });
}

