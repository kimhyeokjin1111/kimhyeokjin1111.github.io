{
    let $myRivewView = document.querySelector(".review-content-btn")
    let $myPostView = document.querySelector(".post-content-btn")
    let $myReviewContent = document.querySelector(".review-content-box-wrap")
    let $myPostContent = document.querySelector(".review-content-box-wrap2")
    let $reviewCnt = document.querySelector(".review-count")
    let $postCnt = document.querySelector(".post-count")



    $myPostView.addEventListener("click", function () {
        $myRivewView.style.color = "gray";
        $myRivewView.style.backgroundColor = "white";
        $myPostView.style.color = "white";
        $myPostView.style.backgroundColor ="#2bc1bf";
        $myPostContent.style.display = "flex";
        $myReviewContent.style.display = "none";
        $reviewCnt.style.display = "none";
        $postCnt.style.display = "flex";
      });

    $myRivewView.addEventListener("click",function(){
      $myRivewView.style.color = "white";
        $myRivewView.style.backgroundColor = "#2bc1bf";
        $myPostView.style.color = "gray";
        $myPostView.style.backgroundColor ="white";

        $myPostContent.style.display = "none";
        $myReviewContent.style.display = "flex";

        $reviewCnt.style.display = "flex";
        $postCnt.style.display = "none";

    })
    
      
}