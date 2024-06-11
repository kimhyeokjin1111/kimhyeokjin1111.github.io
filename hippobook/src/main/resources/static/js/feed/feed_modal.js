
// 글쓰기 모달
{
  let $open = document.querySelector(".feed_writer");
  let $modal = document.querySelector(".modal");
  let $close = document.querySelector(".feed_contentbox ");
  
  console.log($open);
  console.log($modal);
  
  $open.addEventListener("click", function(){
      $modal.style.display = "flex";
  });

  $close.addEventListener("click", function(){
    $modal.style.display = "none";
  });


       // 카테고리 모달 띄우는
  let $categoryOpenBtn = document.querySelector(".main_top_category");
  let $getmodal = document.querySelector(".category_popup");

    $categoryOpenBtn.addEventListener("click", function(){
    $getmodal.style.display = "block";
    });

  
    // 모달 닫는
    $getmodal.addEventListener("click", function(){
      $getmodal.style.display = "none";
    })


//   팔로우 btn 처리
  let followList = document.querySelectorAll(".feed_follow_btn");
  followList.forEach(ele => {
    ele.addEventListener("click", function () {

      let userId = this.dataset.id;

      fetch('/v1/follows',
          {
            method: "POST",
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({"followTo": userId}),
          }).then(() => {
        location.reload();
      });


    });
  });

//   언팔로우 btn 처리
  let unfollowList = document.querySelectorAll(".feed_unfollow_btn");
  unfollowList.forEach(ele => {
    ele.addEventListener("click" , function (){
      let userId = this.dataset.id;
      fetch('v1/unfollows/' + userId,
          {
            method: "DELETE",
          }).then(() => {
        location.reload();
      });
    });
  });

 

}
