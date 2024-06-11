{
  let $optionSpanBtn = document.querySelectorAll('.option-span');
  let $postUl = document.querySelector('.post');
  let $etcUl = document.querySelector('.etc');

  console.log($postUl);
  console.log($etcUl);

  $optionSpanBtn.forEach((ele) => {
    // console.log(ele);
    ele.addEventListener('click', function () {
      console.log('this : ', this);
      if (this.dataset.search_type == 'post') {
        if ($postUl.classList.contains('search-option-ul-block')) {
          $postUl.classList.remove('search-option-ul-block');
          return;
        }
          console.log('post 클릭', this)
        $postUl.classList.add('search-option-ul-block');
          $etcUl.classList.remove('search-option-ul-block');
      } else {
        if ($etcUl.classList.contains('search-option-ul-block')) {
          $etcUl.classList.remove('search-option-ul-block');
          return;
        }
        $etcUl.classList.add('search-option-ul-block');
          $postUl.classList.remove('search-option-ul-block');
      }
    });
  });

    let $postSearchBtn = document.querySelector('.search-contnet-input');

    $postSearchBtn.addEventListener('click', function (){
        $postUl.classList.remove('search-option-ul-block');
        $etcUl.classList.remove('search-option-ul-block');
    })
}

{
  //게시판 타입 메뉴 클릭 이벤트

  let $postMenu = document.querySelectorAll('.post-menu-li');

  console.log($postMenu);

  let postReqList = {
    postType : $postMenu[0].querySelector('div').dataset.type,
    type : null,
    keyword : null,
    orderType : 'recent',
    page : 1,
  }

  postShow(postReqList);

  $postMenu.forEach((menu) => {
    menu.addEventListener('click', function () {
      let $postNow = document.querySelector('.post-menu-active-info');
      let postNow = $postNow.dataset.postnow;
      let $postTitle = document.querySelector('.main__title-box > span');

      let clickedPost = this.dataset.postnow;
      console.log(clickedPost);

      let postReqList = {
        postType : this.querySelector('div').dataset.type,
          type : null,
          keyword : null,
          orderType : 'recent',
          page : 1,
      }

      postShow(postReqList);

      if (postNow != clickedPost) {
        $postNow.dataset.postnow = clickedPost;

        $postMenu[postNow - 1].classList.remove('post-menu-select-li');
        $postMenu[clickedPost - 1].classList.add('post-menu-select-li');

        $postMenu[postNow - 1]
          .querySelector('span')
          .classList.remove('post-menu-select-span');
        $postMenu[clickedPost - 1]
          .querySelector('span')
          .classList.add('post-menu-select-span');

        $postTitle.innerText =
          $postMenu[clickedPost - 1].querySelector('div').innerText + '게시판';

      }
    });
  });
}

{
    let $typeRealBox = document.querySelector('.option-span');
    let $typeOpts = document.querySelectorAll('.post > li')
    let $typeText = $typeRealBox.querySelector('span');
    console.log('$typeOpts : ', $typeOpts);
    console.log('$typeText : ', $typeText)

    $typeOpts.forEach(li => {
        li.addEventListener('click', function (){
            $typeRealBox.dataset.type = this.dataset.type;
            $typeText.innerText = this.innerText;
        })
    })

    let $etcRealBox = document.querySelector('.option-span:nth-child(2)');
    let $etcOpts = document.querySelectorAll('.etc > li')
    let $etcText = $etcRealBox.querySelector('span');
    // console.log('$typeOpts : ', $typeOpts);
    // console.log('$typeText : ', $typeText)

    $etcOpts.forEach(li => {
        li.addEventListener('click', function (){
            $etcRealBox.dataset.type = this.dataset.type;
            $etcText.innerText = this.innerText;
        })
    })
}

function postShow(postReqList){
  fetch(`/v1/board/${postReqList.postType}/posts?type=${postReqList.type}&keyword=${postReqList.keyword}&page=${postReqList.page}&orderType=${postReqList.orderType}`,
      {method : "GET"})
      .then(resp => resp.json())
      .then(post => {
        console.log(post)

        let tags = ``;

        for (let i = 0; i < post.post.length; i++) {
          let postId = post.post[i].postId;
          let postTitle = post.post[i].postTitle;
          let userNickname = post.post[i].userNickname;
          let likeCount = post.post[i].likeCount;
          let postDate = post.post[i].postDate;
          let postView = post.post[i].postView;

          tags += `
               <li class="main__post-result-li">
                  <p class="main__post-titie-info-box">
                    <a class="post-area" href="/board/post/view?postId=${postId}&postType=${postReqList.postType}">${postTitle}</a>
                    <img src="" alt="" />
                  </p>
                  <div class="main__post-detail-info-box">
                    <span>${userNickname}</span>
                    <ul>
                      <li>${likeCount}</li>
                      <li>${postDate}</li>
                      <li>${postView}</li>
                    </ul>
                  </div>
                </li>
                  `
        }

        let $postBox = document.querySelector('.main__post-search-result-box > ul');

        $postBox.innerHTML = tags;

        let tags2 = ``;
        console.log('post.postPage.prev : ', post.postPage.prev)
        console.log('post.postPage.startPage : ', post.postPage.startPage)
        console.log('post.postPage.endPage : ', post.postPage.endPage)

        if(post.postPage.prev){
          tags2 += `
            <span
              ><a class="page-btn" href="" data-posttype="${postReqList.postType}" data-type="${postReqList.type}" data-keyword="${postReqList.keyword}" data-page="${post.postPage.startPage -1}" data-order="recent"><img src="/imgs/administrator/fragment/left_sh.png" alt="" /></a
            ></span>`
        }

        for (let i = post.postPage.startPage; i < post.postPage.endPage + 1; i++) {


          tags2 +=
              `
            <a class="page-btn" href="" data-posttype="${postReqList.postType}" data-type="${postReqList.type}" data-keyword="${postReqList.keyword}" data-page="${i}" data-order="recent">${i}</a>
              `
        }
        if(post.postPage.next) {
          tags2 += `
            <span
              ><a class="page-btn" href="" data-posttype="${postReqList.postType}" data-type="${postReqList.type}" data-keyword="${postReqList.keyword}" data-page="${post.postPage.endPage + 1}" data-order="recent"><img src="/imgs/administrator/fragment/right-sh.png" alt="" /></a
            ></span>
            `
        }


        let $pageBox = document.querySelector('.main__post-page-btn-box')
        console.log('pageBox : ', $pageBox)
        console.log('tags2 : ', tags2)
        $pageBox.innerHTML = tags2;

        let $orderBtnBox = document.querySelector('.main__post-order-type-box')
        let tags3 = '';

        tags3 += `
              <ul>
                <li class="resent-order"><a href="" class="order-btn" data-posttype="${postReqList.postType}" data-type="${postReqList.type}" data-keyword="${postReqList.keyword}" data-order="recent">최신순</a></li>
                <li class="resent-order"><a href="" class="order-btn" data-posttype="${postReqList.postType}" data-type="${postReqList.type}" data-keyword="${postReqList.keyword}" data-order="like">좋아요순</a></li>
              </ul>
        `

        $orderBtnBox.innerHTML = tags3;

          let $resentOrder = document.querySelectorAll('.resent-order');
          $resentOrder.forEach(ele => {
              ele.addEventListener('click', (e) => {
                  e.preventDefault();
              })})

        let $pageBtn = document.querySelectorAll('.page-btn');
          $pageBtn.forEach(ele => {
            ele.addEventListener('click', (e) => {
            e.preventDefault();
        })})

      })
}

{
    let $postSearchBtn = document.querySelector('.search-contnet-input');
    let $typeRealBox = document.querySelector('.option-span');
    let $etcRealBox = document.querySelector('.option-span:nth-child(2)');
    console.log('$typeRealBox : ', $typeRealBox)
    console.log('$etcRealBox : ', $etcRealBox)

    $postSearchBtn.addEventListener("keyup", function (e){
        // console.log('e.keyCode : ', e.keyCode)
        if(e.keyCode === 13){
            let postReqList = {
                postType : $typeRealBox.dataset.type,
                type : $etcRealBox.dataset.etc,
                keyword : $postSearchBtn.value,
                orderType : 'recent',
                page : 1,
            }

            // console.log(postReqList)
            postShow(postReqList);
            // $postSearchBtn.value = '';
            $postSearchBtn.blur()
        }
    })
}

{
    let $orderBtnBox = document.querySelector('.main__post-order-type-box')

    $orderBtnBox.addEventListener('click' , function (e){
        console.log('e.target : ', e.target)
        if(e.target.classList.contains('order-btn')) {
            let postReqList = {
                postType: e.target.dataset.posttype,
                type: e.target.dataset.type,
                keyword: e.target.dataset.keyword,
                orderType: e.target.dataset.order,
                page: 1,
            }

            postShow(postReqList);
        }
    })
}

{
    let $pageBtnBox = document.querySelector('.main__post-page-btn-box');

    $pageBtnBox.addEventListener('click', function (e) {

        if(e.target.classList.contains('page-btn')){
            console.log(e.target)

            let postReqList = {
                postType: e.target.dataset.posttype,
                type: e.target.dataset.type,
                keyword: e.target.dataset.keyword,
                orderType: e.target.dataset.order,
                page: e.target.dataset.page,
            }

            postShow(postReqList);
        }
    })
}

{
    //게시글 뷰 진입 이벤트
    let $postBox = document.querySelector('.main__post-search-result-box > ul');

    $postBox.addEventListener('click', function (e){
        if(e.target.classList.contains('post-area')){
            console.log('e.target : ', e.target)

            window.location = "/board/post/view";
        }
    })
}
