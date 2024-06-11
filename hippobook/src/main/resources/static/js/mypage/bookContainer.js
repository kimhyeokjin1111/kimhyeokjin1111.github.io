import * as module from '../mypage/module/bookContainerModule.js'

{
    let $bookContainerSet = document.querySelectorAll(".my-book-get-list-image");
    let $modalBox = document.querySelector(".book-container-modal-bg");
    let $modalBox2 = document.querySelector(".book-container-modal-bg2")
    let $xBox = document.querySelector(".x-box");
    let $xBox2 = document.querySelector(".x-box2");
    let $bestBook = document.querySelector(".best-book")
    let $bookInfoDetail = document.querySelector(".book-info-detail")
    let $bookListDelete = document.querySelector(".book-list-delete")
    let $bookReadingStatus = document.querySelector(".book-status-set")
    let $bookContainerSort = document.querySelector(".book-Container-cate-list-setting")
    let $bookContainerSortImage = document.querySelector("#list-setting-image")


    let $readingFinishBtn = document.querySelector(".book-reading-finish-btn")
    let $readingBtn = document.querySelector(".book-reading-btn")
    let $noReadingBtn = document.querySelector(".book-no-reading-btn")
    console.log($bookContainerSet);
  
    if ($bookContainerSet.length > 0) {
        $bookContainerSet.forEach(function(bookImage) {
          bookImage.addEventListener("click", function () {
            $modalBox.style.display = "flex";
              let id = this.dataset.id;
              let bookId = this.dataset.bookid;
            $modalBox.querySelector('.book-list-delete').dataset.id = id;
            $modalBox.querySelector('.best-book').dataset.id = id;
            $modalBox.querySelector('.book-info-detail').dataset.bookid = bookId;
              $readingFinishBtn.dataset.id = id;
              $readingBtn.dataset.id=id;
              $noReadingBtn.dataset.id=id;
          });
        });
      }
  
    $xBox.addEventListener("click", function () {
      $modalBox.style.display = "none";
    });

    $xBox2.addEventListener("click", function () {
        $modalBox2.style.display = "none";
    });




    $bestBook.addEventListener("click", function(){

        console.log(this.dataset.id)
        module.modify(this.dataset.id, function (){

            location.reload();
        });
        
        $modalBox.style.display = "none";
    });
  
    $bookInfoDetail.addEventListener("click", function(){

        console.log(this.dataset.bookid)
        window.location = "/book/info?bookId="+(this.dataset.bookid);
        $modalBox.style.display = "none";
    });

    $bookReadingStatus.addEventListener("click", function (){
        $modalBox.style.display = "none";
        $modalBox2.style.display = "flex";
    });

    $bookListDelete.addEventListener("click", function(){
        module.remove(this.dataset.id, function (){
            location.reload();
        });

        $modalBox.style.display = "none";
    });



    // 책상태 선택 모달창 버튼
    $readingFinishBtn.addEventListener("click", function(){
        console.log(this.dataset.status)
        module.modify2(this.dataset.id, this.dataset.status, function (){

            location.reload();
        });

        $modalBox2.style.display = "none";
    });

    $readingBtn.addEventListener("click", function(){
        console.log(this.dataset.status)
        module.modify2(this.dataset.id, this.dataset.status, function (){

            location.reload();
        });
        $modalBox2.style.display = "none";
    });

    $noReadingBtn.addEventListener("click", function(){
        console.log(this.dataset.status)
        module.modify2(this.dataset.id, this.dataset.status, function (){

            location.reload();
        });

        $modalBox2.style.display = "none";
    });


    let sortStatus = false;

    $bookContainerSort.addEventListener("click", function(){
      if(sortStatus){
        $bookContainerSortImage.style.transform = "scaleY(1)";
      }else{
        $bookContainerSortImage.style.transform = "scaleY(-1)";
      }

      sortStatus = !sortStatus;
      
    });
  
    

  }
  