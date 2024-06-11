export function modify(formData,callback){
    fetch(`/v1/users/profiles`, {
        method: 'PATCH',
        body : formData
    }).then(resp => {
        if(resp.status === 200){
            callback();
        }
    });
}