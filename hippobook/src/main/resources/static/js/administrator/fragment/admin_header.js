let postIds = [1];
let commentIds = [1];
let feedIds = [1];
let stickerIds = [1];

{
  let $headerIcon = document.querySelectorAll(".header__admin-icon");
  let $adminInfo = document.querySelector(".header__admin-info");
  let $noticeInfo = document.querySelector(".header__notice-info");

  console.log($adminInfo)
  console.log($noticeInfo)

  $headerIcon.forEach((ele) => {
    ele.addEventListener("click", function () {
      console.log(this.dataset.name);

      $headerIcon.forEach((e) => {
        e.style.borderBottom = "0";
      });

      if (this.dataset.name == "admin") {
        $noticeInfo.classList.remove("header-flex");
        $adminInfo.classList.add("header-flex");
        this.style.borderBottom = "3px solid #212121";

        if (this.dataset.clicked == "T") {
          $adminInfo.classList.remove("header-flex");
          this.style.borderBottom = "0";
          this.dataset.clicked = "F";
        } else {
          $headerIcon.forEach((e) => {
            e.dataset.clicked = "F";
          });
          this.dataset.clicked = "T";
        }
      } else {
        $adminInfo.classList.remove("header-flex");
        $noticeInfo.classList.add("header-flex");
        this.style.borderBottom = "3px solid #212121";

        if (this.dataset.clicked == "T") {
          $noticeInfo.classList.remove("header-flex");
          this.style.borderBottom = "0";
          this.dataset.clicked = "F";
        } else {
          $headerIcon.forEach((e) => {
            e.dataset.clicked = "F";
          });
          this.dataset.clicked = "T";
          console.log("신고창 띄움~~~~~~~~~~~~~~~~~~22222222222222222222222")

          noticeShow('A');
        }
      }
    });
  });
}

function noticeShow(type){
  fetch(`/v1/admin/header/notice/${type}`, {method : "GET"})
      .then(list => list.json())
      .then(l => {
        // console.log(l)

        let $noticeCnt = document.querySelector('.header__notice-count-box > h4 > span')
        $noticeCnt.innerText = l.length;

        let $noticeBox = document.querySelector('.header__notice-content-box');
        let tags = '';

        postIds.splice(0, postIds.length);
        commentIds.splice(0, commentIds.length);
        feedIds.splice(0, feedIds.length);
        stickerIds.splice(0, stickerIds.length);

        for (let i = 0; i < l.length; i++) {
          let type = l[i].noticeType;
          let date = l[i].noticeDate;
          let user = l[i].noticeUser;
          let content = '';

          switch (type) {
            case "feed":
              content = '피드에서 신고가 들어왔습니다.'
              feedIds.push(l[i].noticeId)
              break;
            case "post":
              content = '게시글에서 신고가 들어왔습니다.'
              postIds.push(l[i].noticeId)
              break;
            case "comment":
              content = '코멘트에서 신고가 들어왔습니다.'
              commentIds.push(l[i].noticeId)
              break;
            case "sticker":
              content = '스티커 신청이 들어왔습니다.'
              stickerIds.push(l[i].noticeId)
              break;
          }

          tags += `
                    <article>
                      <div class="notice-preview-head">
                        <strong>${type}</strong>
                        <span>${date}</span>
                      </div>
                      <hr />
                      <span>${user}</span>
                      <div>
                        ${content}
                      </div>
                    </article>
                  `
        }

        console.log('postIds : ', postIds)
        console.log('commentIds : ', commentIds)
        console.log('feedIds : ', feedIds)
        console.log('stickerIds : ',stickerIds)
        $noticeBox.innerHTML = tags;
      })
}

{
  let $noticeBtn = document.querySelectorAll('.notice-btn');
  let $readBtn = document.querySelector('#notice-all-checked');
  console.log($readBtn)

  $noticeBtn.forEach(btn => {
    btn.addEventListener('click', function (){
      $readBtn.dataset.type = btn.dataset.type;

      if(btn.dataset.type === 'decl'){
        noticeShow('decl')
      }else if(btn.dataset.type === 'sticker'){
        noticeShow('sticker')
      }else{
        noticeShow('A');
      }
    })
  })
}

{
  let $readBtn = document.querySelector('#notice-all-checked');

  $readBtn.addEventListener('click', function (){
    let type = this.dataset.type;

    if(this.dataset.type === 'decl'){
      readModify('feed')
      readModify('post')
      readModify('comment')
    }else if(this.dataset.type === 'sticker'){
      readModify('sticker')
    }else{
      readModify('feed')
      readModify('post')
      readModify('comment')
      readModify('sticker')
    }
  })
}

function readModify(type){
  let arr = [1];

  switch (type) {
    case "feed":
      arr = feedIds;
      break;
    case "post":
      arr = postIds;
      break;
    case "comment":
      arr = commentIds;
      break;
    case "sticker":
      arr = stickerIds;
      break;
  }

  fetch(`/v1/admin/header/notice/${type}`, {
    method : "PATCH",
    headers : {'Content-Type' : 'application/json;'},
    body : JSON.stringify(arr)
  }).then();
}

{
  let $logoutBtn = document.querySelector('.header__admin-logout')

  $logoutBtn.addEventListener('click', function (){
    //TODO
    //로그아웃 컨트롤러에 요청하기
  })
}
