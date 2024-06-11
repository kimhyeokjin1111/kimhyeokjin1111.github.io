{
  let $introduceBtn = document.querySelector(".introduce-save-btn");
  let $introduceText = document.querySelector(".introduce-text-content");
  // let $readingBookImgCheck = document.querySelectorAll(".reading-book-img-check")
  let $readingBookImgCheck =  document.querySelectorAll('.my-book-get-list-image')
  let $introduceContent = document.querySelector("#introduce-content");

  $introduceText.addEventListener("click",function (){
    $introduceBtn.style.display = "flex";
  });

  $introduceBtn.addEventListener("click",function (){
    $introduceBtn.style.display = "none";

  });

  $introduceContent.addEventListener("click",function (e){
    let target = e.target;

    if(target.classList.contains('introduce-text-content')) return;

    $introduceBtn.style.display = "none";
  });




  $readingBookImgCheck.forEach(ele => {
    ele.addEventListener('click', function (){
      $readingBookImgCheck.forEach(ele => ele.style.border ='solid lightgrey' );
        ele.style.border = "solid #2bc1bf";
      console.log(ele)
    });

  });


}
