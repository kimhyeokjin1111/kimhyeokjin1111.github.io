{



    // 모달 띄우는
    let $categoryOpenBtn = document.querySelector(".main_top_category");
    let $getmodal = document.querySelector(".category_popup");
    let $categoryXBtn = document.querySelector(".category_popup_inner");
    // console.log($categoryXBtn);

    $categoryOpenBtn.addEventListener("click", function(){
        $getmodal.style.display = "block";
    });


    // 모달 닫는
    $categoryXBtn.addEventListener("click", function(){
        $getmodal.style.display = "none";
    })


}