

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

{
    // book 모달 창
    let $book_OpenBtn = document.querySelector(".post_bookBtn");
    let $book_getModal = document.querySelector(".book_modal");
    let $book_XBtn = document.querySelector(".Xbtn-box");


    $book_OpenBtn.addEventListener("click", function (){
        $book_getModal.style.display = "block";
    });

    $book_XBtn.addEventListener("click", function (){
        $book_getModal.style.display = "none";
    });


}

{
    let $bookBtn = document.querySelector(".book_btn");
    $bookBtn.forEach(ele =>{
        ele.addEventListener("click", function (){

            let userdata = this.dataset.keyword;

            fetch('/v1/search',
                {
                    method: "POST",
                    headers: {'Content-Type': 'application/json'},
                    body: JSON,
                }).then(() => {

            });
        });
    });
}



