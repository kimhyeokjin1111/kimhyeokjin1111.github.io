{   // 프로필 사진 미리보기 처리
    let $fileInput = document.querySelector('#file-input');
    let $imgBox = document.querySelector('.image-box');

    $fileInput.addEventListener('change', function () {
        // console.dir(this);
        // console.log(this.files)
        // console.log(this.files[0])
        let file = this.files[0];

        let fileUrl = URL.createObjectURL(file);
        console.dir($imgBox);

        $imgBox.style.backgroundImage = `url(${fileUrl})`;
    });
}