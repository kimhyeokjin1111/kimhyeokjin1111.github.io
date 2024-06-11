let $postHidden = document.querySelector('.post-hidden')
let $declRadios = document.querySelectorAll(
  '.modal-decl-opt-content-box > label > input'
);

console.log("연결완료!!")

let $declOther = document.querySelector('.decl-reason-other-box-outer');

let $otherReason = document.querySelector('.decl-other-content-box > input');
{
  // 신고하기 모달 박스 이벤트(열기, 닫기)

  let $declIcons = document.querySelectorAll(
    '.main__post-info-decl-box > div > span > img'
  );
  let $declModal = document.querySelector('.modal-decl-req-back');
  let $declClose = document.querySelector('.decl-close-btn');
  let $declProcess = document.querySelector('.decl-process-btn');

  console.log($declIcons);
  console.log($declModal);

  $declIcons.forEach((declI) => {
    declI.addEventListener('click', function () {
      console.log('this : ', this);
      console.log($declModal.style.display);
      if ($declModal.style.display == '') {
        $declModal.style.display = 'flex';
        $declProcess.dataset.type = this.dataset.type;
        $declProcess.dataset.targetid = $postHidden.dataset.id;
      }
    });
  });

  let $declIcons2 = document.querySelector(
    '.main__post-comment-result-box'
  );

  $declIcons2.addEventListener('click', function (e) {
      console.log('e.target : ', e.target);
      // console.log(e.target.style.display);

      if(e.target.classList.contains('comment-decl-btn')){
        if ($declModal.style.display == '') {
          $declModal.style.display = 'flex';
          $declProcess.dataset.type = e.target.dataset.type;
          $declProcess.dataset.targetid = e.target.dataset.rid;
        }
      }
  });


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

    // console.log('$declReason.dataset : ', $declReason.dataset)
    // console.log('$declRadios[$declReason.dataset.reasonnow - 1] : ', $declRadios[$declReason.dataset.reasonnow - 1] )

    if($declReason.dataset.reasonnow === "-1"){ //복사할 코드
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
    console.log("나기기 함수 돌기 !!!!!!!!!!!!!!!!!!!!!!")

    console.log(
      $declRadios[$declReason.dataset.reasonnow - 1].dataset.reasonnow
    );

    $declRadios[$declReason.dataset.reasonnow - 1].checked = false;

    if ($declRadios[$declReason.dataset.reasonnow - 1].dataset.reasonnow == 5) {
      $declOther.style.display = 'none';
    }

    // $declReason.dataset.reasonnow = -1;
    // $otherReason.value = '';
  }
}

{
  // 복사할 신고 코드
  //신고처리 이벤트
  let $declProcess = document.querySelector('.decl-process-btn');
  let $declReason = document.querySelector(
      '.modal-decl-opt-content-box > input'
  );

  $declProcess.addEventListener('click', function (){
    if($declReason.dataset.reasonnow == 5){
      $declProcess.dataset.value = $declRadios[4].value;
    }
    console.log('$declProcess.dataset.value : ', $declProcess.dataset.value)

    console.log($declProcess.dataset.value);
    if($declProcess.dataset.value){
      console.log('신고 사유가 존재함~!!')
      let declInfo = {
        declContent : $declProcess.dataset.value,
        declCate : $postHidden.dataset.type,
        targetId : $declProcess.dataset.targetid,
        userId : 1
      }

      fetch(`/v1/${$declProcess.dataset.type}/decl`,
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
        console.log('this.value : ', this.value)
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

/*----------------------------------------------------------------*/

let nowPage = 1;
//코멘트 이벤트 부분

let commentFindInst = {
  postType : $postHidden.dataset.type,
  postId : $postHidden.dataset.id,
}

{
  // 초기 페이지 진입 시 코멘트 출력 이벤트

  console.log('commentFindInst : ', commentFindInst);
  showPostLike();
  findComment(commentFindInst, showComment)
}

{
  // 코멘트 작성 및 갱신 이벤트
  let $commentWriteBtn = document.querySelector('.main__post_comment-btn-box > button')

  $commentWriteBtn.addEventListener('click', function (){
    // console.log('this.closest(\'.main__post-comment-write-box\') : ', this.closest('.main__post-comment-write-box'))
    let $commentTextarea = this.closest('.main__post-comment-write-box').querySelector('textarea')
    // console.log($commentTextarea)
    let putCommentInfo = {
      commentContent : $commentTextarea.value,
      postId : $postHidden.dataset.id,
      userId : 1
    }

    console.log('putCommentInfo : ', putCommentInfo)
    nowPage = 1;
    addComment(putCommentInfo, $postHidden.dataset.type, () => {
      findComment(commentFindInst, showComment)
    })
    $commentTextarea.value = '';

  })
}

function showComment(commentList){
  nowPage = 1;
  console.log(commentList)
  let tags = '';

  let $commentBox = document.querySelector('.main__post-comment-result-box')

  for (let i = 0; i < commentList.contentList.length; i++) {
    let commentWriter = commentList.contentList[i].userNickname
    let commentDate = commentList.contentList[i].commentDate
    let commmentContent = commentList.contentList[i].commentContent

    tags += `
                 <li>
                    <div>
                        <p>
                  <span>
                    <a href="#">${commentWriter}</a>
                    <span>${commentDate}</span>
                  </span>
                            <img data-rid="${commentList.contentList[i].commentId}" data-type="comment" class="comment-decl-btn" src="/imgs/administrator/fragment/decl.png" alt="">
                        </p>
                        <div>${commmentContent}</div>
                    </div>
                </li>
    `


    // $commentBox.insertAdjacentHTML("beforeend", tags)
  }
  let pageBtn = document.querySelector('.main__post-comment-page-box');

  $commentBox.innerHTML = tags;
  commentTotalReq();
  if(commentList.hasNext){
    nowPage += 1;
    pageBtn.style.display = 'flex';
  }else{
    pageBtn.style.display = 'none';
  }
}

function showComment2(commentList){
  console.log(commentList)
  let tags = '';

  let $commentBox = document.querySelector('.main__post-comment-result-box')

  for (let i = 0; i < commentList.contentList.length; i++) {
    let commentWriter = commentList.contentList[i].userNickname
    let commentDate = commentList.contentList[i].commentDate
    let commmentContent = commentList.contentList[i].commentContent

    tags += `
                 <li>
                    <div>
                        <p>
                  <span>
                    <a href="#">${commentWriter}</a>
                    <span>${commentDate}</span>
                  </span>
                            <img class="comment-decl-btn" src="/imgs/administrator/fragment/decl.png" alt="">
                        </p>
                        <div>${commmentContent}</div>
                    </div>
                </li>
    `


  }
  $commentBox.insertAdjacentHTML("beforeend", tags)
  commentTotalReq();
  if(commentList.hasNext) {
    nowPage += 1;
  }else{
    let pageBtn = document.querySelector('.main__post-comment-page-box');
    pageBtn.style.display = 'none';
  }
}

{
  let pageBtn = document.querySelector('.main__post-comment-page-box');

  pageBtn.addEventListener('click', function (){
    console.log('pageBtn : ', pageBtn);
    findComment(commentFindInst, showComment2);
  })
}

function findComment(commentFindInst, callBack){
 fetch(`/v1/${commentFindInst.postType}/post/comments?postId=${commentFindInst.postId}&amount=5&page=${nowPage}`, {method : "GET"})
     .then(dto => dto.json())
     .then(json => callBack(json))
}

function addComment(putCommentInfo, postType, callBack){
  // console.log('putCommentInfo : ', putCommentInfo)
  // console.log('postType : ', postType)
  fetch(`/v1/${postType}/post`, {
    method : "POST",
    headers : {'Content-Type' : 'application/json;'},
    body : JSON.stringify(putCommentInfo)
  }).then(() => callBack());
}

{
  let $likeBtn = document.querySelector('.main__post-like-btn-box > span');
  let $postHidden = document.querySelector('.post-hidden')
  $likeBtn.addEventListener('click', function (){
    console.log('$postHidden : ', $postHidden)
    console.log('$postHidden.dataset.postId : ', $postHidden.dataset.postId);
    console.log('$postHidden.dataset.postType : ', $postHidden.dataset.postType)

    let likeInfo = {
      postId : $postHidden.dataset.id,
      userId : 1 // $postHidden.dataset.id 로 교체 해야함
    }

    fetch(`/v1/${$postHidden.dataset.type}/post/like`,
        {
          method : "POST",
          headers : {'Content-Type' : 'application/json'},
          body : JSON.stringify(likeInfo)
        })
        .then(() => showPostLike())
  })
}

function showPostLike(){
  let $postHidden = document.querySelector('.post-hidden');
  let $likeCount = document.querySelector('.main__post-like-btn-box > div > span')

  fetch(`/v1/${$postHidden.dataset.type}/post/like?postId=${$postHidden.dataset.id}`,
      {method : "GET"})
      .then(resp =>
        resp.text()
      ).then(text => {
    console.log(text)
    $likeCount.innerText = text;
  });
}

{
  //이전 페이지 정보 저장 및 목록 이벤트
  let before = document.referrer;
  console.log('before : ', before)

  let $listBtn = document.querySelector('.main__post-type-modify-back-btn-box > div > span:nth-child(2) > button ')
  console.log('$listBtn : ', $listBtn)

  $listBtn.addEventListener('click', function (){
    window.location = before;
  })
}

function commentTotalReq(){
  fetch(`/v1/${commentFindInst.postType}/post/comment/count?postId=${commentFindInst.postId}`, {method : "GET"})
      .then(dto => dto.text())
      .then(text => {
        let $commentCnt = document.querySelector('.main__post-comment-count-box > span')
        $commentCnt.innerText = text}
      )
}
