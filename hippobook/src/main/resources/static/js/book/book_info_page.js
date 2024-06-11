{
  // 줄거리 펼치는 코드
  let $bookShort = document.querySelector(
    '.main__book-short-content-box > div > p'
  );
  let $shortMore = document.querySelector('.book-more-btn > button');

  console.log($bookShort);
  console.log($shortMore);

  $shortMore?.addEventListener('click', function () {
    if ($shortMore.textContent == '펼치기') {
      $bookShort.style.display = 'block';
      $shortMore.textContent = '접기';
    } else {
      $bookShort.style.display = '-webkit-box';
      $shortMore.textContent = '펼치기';
    }
  });
}

{
  let $listBtn = document.querySelector('.book-list-btn');
  let $authorBtn = document.querySelector('.book-author-btn');
  let $publiBtn = document.querySelector('.book-publi-btn');
  let $listTarget = document.querySelector('.book-list-target');
  let $authorTarget = document.querySelector('.book-author-target');
  let $publiTarget = document.querySelector('.book-publi-target');

  $listBtn?.addEventListener('click', function () {
    console.log($listTarget);
    if ($listTarget.style.display == 'none') {
      $listTarget.style.display = 'block';
      let $listShift = $listBtn.closest('li').querySelector('button > img');
      // console.log($listShift);
      // console.log($listShift.src);
      $listShift.src = '../img/up_sh.png';
    } else {
      $listTarget.style.display = 'none';
      let $listShift = $listBtn.closest('li').querySelector('button > img');
      // console.log($listShift);
      // console.log($listShift.src);
      $listShift.src = '../img/down_sh.png';
    }
  });

  $publiBtn?.addEventListener('click', function () {
    if ($publiTarget.style.display == 'none') {
      $publiTarget.style.display = 'block';
      let $publiShift = $publiBtn.closest('li').querySelector('button > img');

      $publiShift.src = '../img/up_sh.png';
    } else {
      $publiTarget.style.display = 'none';
      let $publiShift = $publiBtn.closest('li').querySelector('button > img');

      $publiShift.src = '../img/down_sh.png';
    }
  });

  $authorBtn?.addEventListener('click', function () {
    console.log($authorTarget.style.display);
    if ($authorTarget.style.display == 'none') {
      $authorTarget.style.display = 'block';
      let $authorShift = $authorBtn.closest('li').querySelector('button > img');

      $authorShift.src = '../img/up_sh.png';
    } else {
      console.log('hi');
      $authorTarget.style.display = 'none';
      let $authorShift = $authorBtn.closest('li').querySelector('button > img');

      $authorShift.src = '../img/down_sh.png';
    }
  });
}

// {
//   let $bookLikeBtn = document.querySelector('.book-comment-like-box> button');
// }

let $declRadios = document.querySelectorAll(
  '.modal-decl-opt-content-box > label > input'
);

let $declOther = document.querySelector('.decl-reason-other-box-outer');

let $otherReason = document.querySelector('.decl-other-content-box > input');
{
  // 신고하기 모달 박스 이벤트(열기, 닫기)
  let $declModal = document.querySelector('.modal-decl-req-back');
  let $declClose = document.querySelector('.decl-close-btn');
  let $declProcess = document.querySelector('.decl-process-btn');
  let $bookCommentBox = document.querySelector('.main__book-comment-content-box > ul')
  $bookCommentBox.addEventListener('click', function (e){
    if(e.target.classList.contains('decl-btn')){
      console.log('e.target : ', e.target)
      console.log($declModal.style.display);
      if ($declModal.style.display == '') {
        $declModal.style.display = 'flex';
        console.log('this.dataset.cid : ', e.target.dataset.cid)
        $declProcess.dataset.targetid = e.target.dataset.cid;
      }
    }
  })

  let $declReason = document.querySelector(
    '.modal-decl-opt-content-box > input'
  );
  let $alertReason = document.querySelector('.modal-decl-req-box > p');

  $declClose.addEventListener('click', function () {
    $declModal.style.display = '';
    declModalExit();
  });

  $declProcess.addEventListener('click', function () {
    let $declRadios = document.querySelectorAll(
      '.modal-decl-opt-content-box > label > input'
    );
    if ($declReason.dataset.reasonnow == -1) {
      $alertReason.style.display = 'block';
    } else {
      if ($declReason.dataset.reasonnow == 5 && $otherReason.value == '') {
        $alertReason.style.display = 'block';
      } else {
        $declModal.style.display = '';
        declModalExit();
      }
    }
  });

  function declModalExit() {

    if($declReason.dataset.reasonnow === "-1"){
      $alertReason.style.display = '';
      return;
    }
    $declRadios[$declReason.dataset.reasonnow - 1]
      .closest('label')
      .querySelector('.modal-decl-reason-box > p').style.color = '#8b8b8b';

    $declRadios[$declReason.dataset.reasonnow - 1]
      .closest('label')
      .querySelector('.modal-decl-reason-box > span').style.border =
      '2px solid rgb(233, 229, 229)';

    $alertReason.style.display = '';

    console.log(
      $declRadios[$declReason.dataset.reasonnow - 1].dataset.reasonnow
    );

    $declRadios[$declReason.dataset.reasonnow - 1].checked = false;

    if ($declRadios[$declReason.dataset.reasonnow - 1].dataset.reasonnow == 5) {
      $declOther.style.display = 'none';
    }
    // 지울 코드
    // $declReason.dataset.reasonnow = -1;
    // $otherReason.value = '';
  }
}

{
  // 복사할 신고 코드
  //신고처리 이벤트
  let $declProcess = document.querySelector('.decl-process-btn');
  let $bookInfoHidden = document.querySelector('.book-info-hidden');
  let $declReason = document.querySelector(
      '.modal-decl-opt-content-box > input'
  );

  $declProcess.addEventListener('click', function (){
    console.log('$declReason.dataset.reasonnow : ', $declReason.dataset.reasonnow)
    if($declReason.dataset.reasonnow == 5){
      console.log('$declRadios[4].value 확인ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ : ', $declRadios[4].value)
      $declProcess.dataset.value = $declRadios[4].value;
    }
    console.log('$declProcess.dataset.value : ', $declProcess.dataset.value)

    console.log($declProcess.dataset.value);
    if($declProcess.dataset.value){
      console.log('신고 사유가 존재함~!!')
      let declInfo = {
        // private String declContent;
        // private String declCate;
        // private Long targetId;
        // private Long userId;
        declContent : $declProcess.dataset.value,
        declCate : 'book',
        targetId : $declProcess.dataset.targetid,
        userId : $bookInfoHidden.dataset.uid
      }

      console.log('declInfo : ',declInfo)

      fetch(`/v1/comment/decl`,
          {
            method : "POST",
            headers : {'Content-Type' : 'application/json'},
            body : JSON.stringify(declInfo)
          }).then();
      $declReason.dataset.reasonnow = -1;
      $otherReason.value = '';
      $declProcess.dataset.value = ''
      $declRadios[4].value = '';
    }
  })
}

{
  // 신고 모달 라디오 선택 이벤트

  console.log($declRadios);
  let $declProcess = document.querySelector('.decl-process-btn');

  $declRadios.forEach((rad) => {
    rad.addEventListener('click', function () {
      let $reason = this.closest('label').querySelector(
        '.modal-decl-reason-box > p'
      );

      let $declSpan = this.closest('label').querySelector(
        '.modal-decl-reason-box > span'
      );
      let $declReason = document.querySelector(
        '.modal-decl-opt-content-box > input'
      );

      console.log($declReason);
      // console.log($declReason.dataset.reasonnow);
      if ($declReason.dataset.reasonnow != -1) {
        // console.log($declReason.dataset.reasonnow);
        // console.log(
        //   '현재 끄려는 라벨' +
        //     $declRadios[$declReason.dataset.reasonnow - 1].dataset.reasonnow
        // );

        $declRadios[$declReason.dataset.reasonnow - 1]
          .closest('label')
          .querySelector('.modal-decl-reason-box > p').style.color = '#8b8b8b';

        $declRadios[$declReason.dataset.reasonnow - 1]
          .closest('label')
          .querySelector('.modal-decl-reason-box > span').style.border =
          '2px solid rgb(233, 229, 229)';

        if (this.dataset.reasonnow != 5) {
          $declOther.style.display = 'none';
          $otherReason.value = '';
        }
      }

      if (this.checked == true) {
        $reason.style.color = '#3a3636';
        $declSpan.style.border = '7px solid rgb(119, 111, 111)';
        $declReason.dataset.reasonnow = this.dataset.reasonnow;
        console.log($declReason.dataset.reasonnow);
        if(this.dataset.reasonnow == 5){ // 복사할 신고 코드
          $declProcess.dataset.value = '';
        }else{
          $declProcess.dataset.value = this.value
        }
        console.log($declReason.dataset.reasonnow);

        if (this.dataset.reasonnow == 5) {
          $declOther.style.display = 'block';
        }
      }
    });
  });
}

{
  // 기타 신고 사유 취소 버튼 이벤트

  let $declCancel = document.querySelector('.decl-other-text-delete > button');
  console.log($declCancel);

  $declCancel.addEventListener('click', function () {
    $otherReason.value = '';
  });
}

{
  //기타 신고 사유 value 업데이트 이벤트
  $otherReason.addEventListener('change', function () {
    console.log($otherReason.value);
    $declRadios[4].value = this.value;
  });
}

{
  // 책장에 책 담기 이벤트

  let $addBookBtn = document.querySelector('.book-reference-data-box > div:last-child > p')
  let $bookInfoHidden = document.querySelector('.book-info-hidden');
  console.log($bookInfoHidden.dataset.bookid);
  console.log('$addBookBtn : ', $addBookBtn)

  $addBookBtn?.addEventListener('click', function (){
    let bookHasInfo = {
      bookcaseId : 1, //변경할 내용
      bookId : $bookInfoHidden.dataset.bookid,
      userId : $bookInfoHidden.dataset.uid
    }

    console.log('bookHasInfo : ', bookHasInfo)

    fetch(`v1/book/info`, {
      method : "POST",
      headers : {"Content-Type" : "application/json"},
      body : JSON.stringify(bookHasInfo)
    }).then(() => {
      this.closest('div').style.display = 'none'
    });
  })
}

let page = 1;

{
// 책 한줄 리뷰 불러오는 이벤트
  let $bookInfoHidden = document.querySelector('.book-info-hidden');

  console.log($bookInfoHidden.dataset.bookid);
  bookCommentReq($bookInfoHidden.dataset.bookid, showBookComment)
}

{
  // 책 한줄 리뷰 쓰기 이벤트
  let $commentInput = document.querySelector('#book-comment-input');
  let $commentBtn = document.querySelector('#book-comment-btn');
  let $bookInfoHidden = document.querySelector('.book-info-hidden');
  // console.log('$commentInput : ', $commentInput)
  // console.log('$commentBtn : ', $commentBtn)

  $commentBtn.addEventListener('click', function (){
    let bookCommentInfo = {
      bookCommentContent : $commentInput.value,
      bookId : $bookInfoHidden.dataset.bookid,
      userId : $bookInfoHidden.dataset.uid
    }

    console.log('bookCommentInfo : ', bookCommentInfo)

    fetch(`/v1/book/info/comment`, {
      method : "POST",
      headers : {"Content-Type" : "application/json"},
      body : JSON.stringify(bookCommentInfo)
    }).then(() => {
      $commentInput.value = '';
      bookCommentReq($bookInfoHidden.dataset.bookid, showBookComment);
    });
  })
}

function bookCommentReq(bookId, callback){
  fetch(`/v1/book/post/comments?postId=${bookId}&page=${page}&amount=5`, {method : "GET"})
      .then(resp => resp.json())
      .then(json => callback(json))
}

function showBookComment(commentList){
  let $bookInfoHidden = document.querySelector('.book-info-hidden');
  let $moreBtn = document.querySelector('.more-comment-btn');
  console.log('commentList : ', commentList)

  let $bookCommentBox = document.querySelector('.main__book-comment-content-box > ul')
  let tags = '';

  for (let i = 0; i < commentList.contentList.length; i++) {
    tags += `
            <li>
              <div class="book__decl-box">
                <p>${commentList.contentList[i].userNickname}</p>
                <img class="decl-btn" data-cid="${commentList.contentList[i].commentId}" src="/imgs/administrator/fragment/decl.png" alt="" />
              </div>
              <span>${commentList.contentList[i].commentDate}</span>
              <p class="book-comment-content">${commentList.contentList[i].commentContent}</p>        
            </li>
    `
  }

  $bookCommentBox.innerHTML = tags;
  console.log(commentList.hasNext)
  if(commentList.hasNext){
    page += 1
    $moreBtn.style.display = 'flex'
  }else {
    page = 1;
    $moreBtn.style.display = 'none'
  }

  bookCommentTotal($bookInfoHidden.dataset.bookid);
}

function bookCommentTotal(bookId){
  fetch(`/v1/book/info/comment/count?bookId=${bookId}`, {method : "GET"})
      .then(resp => resp.text())
      .then(text => {
        console.log(`bookCommentTotal() : ${text}`)
        let $bookCommentCnt = document.querySelector('.book-reference-data-box > div:nth-child(2) > strong > span')
        let $bookCommentCnt2 = document.querySelector('.main__book-comment-content-box > h3 > span > span');
        $bookCommentCnt.innerText = text;
        $bookCommentCnt2.innerText = text
      })
}

// {
//   //세션에 userId가 없으면 책 담기 버튼 안보이게 하는 이벤트
//   let userId  = window.sessionStorage.getItem('userId');
//   let $addBookBtn = document.querySelector('.book-reference-data-box > div:last-child > p')
//   let $addCommentBox = document.querySelector('.main__book-comment-write-container');
//   console.log('userId : ', userId)
//
//   if(userId == null){
//     $addBookBtn.closest('div').style.display = 'none'
//     $addCommentBox.style.display = 'none';
//   }
// }

function showBookComment2(commentList){
  let $moreBtn = document.querySelector('.more-comment-btn');
  console.log('commentList : ', commentList)

  let $bookCommentBox = document.querySelector('.main__book-comment-content-box > ul')
  let tags = '';

  for (let i = 0; i < commentList.contentList.length; i++) {
    tags += `
            <li>
              <div class="book__decl-box">
                <p>${commentList.contentList[i].userNickname}</p>
                <img class="decl-btn" data-bid="${commentList.contentList[i].commentId}" src="/imgs/administrator/fragment/decl.png" alt="" />
              </div>
              <span>${commentList.contentList[i].commentDate}</span>
              <p class="book-comment-content">${commentList.contentList[i].commentContent}</p>        
            </li>
    `
  }
  $bookCommentBox.insertAdjacentHTML('beforeend', tags);
  if(commentList.hasNext){
    page += 1
  }else{
    page = 1;
    $moreBtn.style.display = 'none'
  }
}

{
  //한 줄 리뷰 더보기 이벤트
  let $moreBtn = document.querySelector('.more-comment-btn > span');
  let $bookInfoHidden = document.querySelector('.book-info-hidden');
  $moreBtn.addEventListener('click', function (){
    bookCommentReq($bookInfoHidden.dataset.bookid, showBookComment2)
  })
}
