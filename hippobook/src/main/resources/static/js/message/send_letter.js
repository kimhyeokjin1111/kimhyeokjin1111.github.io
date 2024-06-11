import * as module from '../message/module/messageModule.js'

{
  let $optionSpanBtn = document.querySelectorAll(".option-span");
  let $postUl = document.querySelector(".post");
  let $etcUl = document.querySelector(".etc");
  let $deleteMsgBtn = document.querySelector(".delete-submit-btn");

  console.log($postUl);
  console.log($etcUl);

  $optionSpanBtn.forEach((ele) => {
    // console.log(ele);
    ele.addEventListener("click", function () {
      // console.log(this.dataset.search_type);
      if (this.dataset.search_type === "post") {
        if ($postUl.classList.contains("search-option-ul-block")) {
          $postUl.classList.remove("search-option-ul-block");
          return;
        }
        $postUl.classList.add("search-option-ul-block");
      } else {
        if ($etcUl.classList.contains("search-option-ul-block")) {
          $etcUl.classList.remove("search-option-ul-block");
          return;
        }
        $etcUl.classList.add("search-option-ul-block");
      }
    });
  });

  $deleteMsgBtn.addEventListener("click", function(){
    let $checkList = document.querySelectorAll('.message-check:checked');
    let idList = [];
    $checkList.forEach(check => {
      idList.push(check.dataset.id)
    })
    console.log(idList)
    module.remove2(idList, function (){
      location.reload();
    });

  });
}
