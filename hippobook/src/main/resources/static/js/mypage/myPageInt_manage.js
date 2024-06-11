import * as module from '../mypage/module/profilePhotoModule.js'

{
    let $ProfilePhotoChange = document.querySelector("#file-input")


    $ProfilePhotoChange.addEventListener("change", function(){

        console.log(this.dataset.id)
        let $fileInput = document.querySelector('#file-input');
        console.dir($fileInput)
        console.log($fileInput.files[0])

        let formData = new FormData();
        formData.append("profile", $fileInput.files[0])

        module.modify(formData, function (){

            location.reload();
        });

    });
}