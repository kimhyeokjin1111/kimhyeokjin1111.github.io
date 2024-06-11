{
  // 신고내용 뷰 열고 닫기 이벤트
  let $declarationList = document.querySelectorAll(".declaration-content-text");
  let $declarationBox = document.querySelector(
    ".main__declaration-content-view-box"
  );

  let $resultBox = document.querySelector('.main__result-list-container');

  $resultBox.addEventListener('click', function (e){
    console.log('e.target : ', e.target)
    console.log('this : ', this)
    console.log('e : ', e)

    let classList = e.target.classList;
    let typeId, cate;

    if(classList.contains('decl-content-box')){

      typeId = e.target.dataset.typeid;
      cate = e.target.dataset.cate;

      let declUlDataset = e.target.closest('ul').dataset;
      let $declIdStore = document.querySelector('.decl-id-store');
      $declIdStore.value = declUlDataset.declid;

      postReq(typeId, cate);

      console.log('declUlDataset : ' ,declUlDataset)
      let $declWriter = document.querySelector('.decl-writer')
      let $declDate = document.querySelector('.decl-write-date')
      let $declContent = document.querySelector('.decl-write-content')

      $declWriter.innerText = declUlDataset.loginid;
      $declDate.innerText = declUlDataset.decldate;
      $declContent.innerText = declUlDataset.content;

    } else if(classList.contains('declaration-content-text')){
      // $declarationBox.classList.add("declaration-view-flex");
      let $target = e.target.closest('.decl-content-box');
      typeId = $target.dataset.typeid;
      cate = $target.dataset.cate;

      let declUlDataset = e.target.closest('ul').dataset;
      let $declIdStore = document.querySelector('.decl-id-store');
      $declIdStore.value = declUlDataset.declid;

      postReq(typeId, cate);

      console.log('declUlDataset : ' ,declUlDataset)
      let $declWriter = document.querySelector('.decl-writer')
      let $declDate = document.querySelector('.decl-write-date')
      let $declContent = document.querySelector('.decl-write-content')

      $declWriter.innerText = declUlDataset.loginid;
      $declDate.innerText = declUlDataset.decldate;
      $declContent.innerText = declUlDataset.content;
    }

    function postReq(typeId, cate){
        let nowDeclType = document.querySelector('.main__declaration-select').value;
      fetch(`/v1/${nowDeclType}/${typeId}?cate=${cate}`, {method : "GET"})
          .then(board => {
              console.log('board.status : ', board.status)
              if(board.status === 500){
                  removeDeclaration()
                  // $declarationBox.classList.remove("declaration-view-flex");
                  alert("해당 신고대상이 존재하지 않습니다.")
                  return;
              }
              $declarationBox.classList.add("declaration-view-flex");
              return board.json();
          })
          .then(b => {

              console.log(b)
            let $declTargetTab = document.querySelector('.declaration-to-content-table');
            let cate = b.cate;
            let nickname = b.nickname;
            let postContent = b.postContent;
            let postDate = b.postDate;

            console.log(cate);
            console.log(nickname);
            console.log(postContent);
            console.log(postDate);

            let tags = `
                          <tr>
                            <th>신고타입</th>
                            <td>${cate}</td>
                          </tr>
                          <tr>
                            <th>작성자</th>
                            <td>${nickname}</td>
                          </tr>
                          <tr>
                            <th>작성일</th>
                            <td>${postDate}</td>
                          </tr>
                          <tr>
                            <th>내용</th>
                            <td>${postContent}</td>
                          </tr>
            `;

            $declTargetTab.innerHTML = tags;

              let $processBtn = document.querySelector('#declaration-to-content-delete-btn')

              $processBtn.dataset.target = b.postId;
              $processBtn.dataset.cate = b.cate;

          });
    }


  })

  // $declarationList.forEach((ele) => {
  //   ele.addEventListener("click", function () {
  //     // console.log(ele);
  //     $declarationBox.classList.add("declaration-view-flex");
  //   });
  // });

  let $declarationCloseBtn = document.querySelectorAll(
    ".main__declaration-close_btn"
  );

  // console.log($declarationCloseBtn);
  $declarationCloseBtn.forEach((ele) => {
    ele.addEventListener("click", function () {
      console.log(ele);
      $declarationBox.classList.remove("declaration-view-flex");
    });
  });
}

{
  // 사이드바 열고 닫기 이벤트
  let $sidebarCloseBtn = document.querySelector(".main__sidebar--close-btn");
  let $sidebarDetail = document.querySelector(".main__sidebar-conten-detail");

  // console.log($sidebarCloseBtn);
  // console.log($sidebarDetail);
  $sidebarCloseBtn.addEventListener("click", function () {
    if ($sidebarDetail.classList.contains("sidebar-none")) {
      $sidebarDetail.classList.remove("sidebar-none");
      this.src = "/imgs/administrator/fragment/left_arrow.png";
    } else {
      $sidebarDetail.classList.add("sidebar-none");
      this.src = "/imgs/administrator/fragment/right_arrow.png";
    }
  });
}

{
  let $declTypeSelect = document.querySelector('.main__declaration-select');
  let $declType = document.querySelector('.decl-type');
  let $typeBook = document.querySelector('.type-book');
  let $declTypeTd = document.querySelectorAll('.main__declaration-type-td');

  $declTypeSelect.addEventListener('change', function (){
    if($declTypeSelect.value === 'feed'){
      $declType.classList.add('feed-can-not-see');
      $declTypeTd.dataset.type = '';
    }else{
      $declType.classList.remove('feed-can-not-see');
    }

    if($declTypeSelect.value === 'comment'){
      $typeBook.classList.remove('book-can-see');
    }else {$typeBook.classList.add('book-can-see');}

  })
}

{
  let $declTypes = document.querySelectorAll('.decl-opt-type');
  let $declPrypes = document.querySelectorAll('.decl-opt-p-type');

  $declTypes.forEach(ele => {
    ele.addEventListener('click', function (){
      ele.closest('.main__declaration-type-td').dataset.type = ele.value;
    })
  })

  $declPrypes.forEach(ele => {
    ele.addEventListener('click', function (){
      ele.closest('.main__process-type-td').dataset.ptype = ele.value;
    })
  })
}

{
  let $nowrowBox = document.querySelector('.main__rownum-select');

  $nowrowBox.addEventListener('change', function (){
    console.log($nowrowBox.value)
  })

}


{
  let $declContent = document.querySelector('.main__declarationDate-input');
  let $declStDecl = document.querySelector('.startDeclDate');
  let $declEdDecl = document.querySelector('.endDeclDate');
  let $declStPDecl = document.querySelector('.startPDate');
  let $declEdPDecl = document.querySelector('.endPDate');
  let $declType = document.querySelector('.main__declaration-type-td');
  let $declPType = document.querySelector('.main__process-type-td');
  let $declSearchBtn = document.querySelector('.decl-search-btn');

  $declSearchBtn.addEventListener('click', function (){
    let searchDeclInfo = {
      declarationContent : $declContent.value,
      startDeclarationDate : $declStDecl.value,
      endDeclarationDate : $declEdDecl.value,
      startPocecssDate : $declStPDecl.value,
      endPocecssDate : $declEdPDecl.value,
      declarationType : $declType.dataset.type || '',
      processType : $declPType.dataset.ptype
    };
    let $nowrowBox = document.querySelector('.main__rownum-select');
    let nowDeclType = document.querySelector('.main__declaration-select').value;

    declReq(searchDeclInfo, $nowrowBox.value, 0 ,nowDeclType)
  })
}

function declReq(searchDeclInfo, amount, page, type){
  console.log(searchDeclInfo)
  let params = new URLSearchParams(searchDeclInfo);

  console.log('type :', type)

  fetch(`/v1/declarations/${type}?${params.toString()}&amount=${amount}`, {
    method : 'GET',
  }).then(resp => resp.json())
      .then(list => {
        console.log('list', list);
        console.log(list.declList)
        let declListTags = ``;
        let declPageTags = ``;
        let $declResultBox = document.querySelector('.main__result-list-container');
        let $declPageBox = document.querySelector('.main__searched-result-page-btn > ul');

        for (let i = 0; i < list.declList.length; i++) {
          let declarationDate = list.declList[i].declarationDate;
          let declarationContent = list.declList[i].declarationContent;
          let userId = list.declList[i].userId;
          let declProcessDate = list.declList[i].declProcessDate;
          let declarationCheck = list.declList[i].declarationCheck;
          let typeId = list.declList[i].typeId;
          let cate = list.declList[i].cate;
          let declId = list.declList[i].declarationId;

          declListTags += `
                    <ul data-declId=${declId} data-declDate=${declarationDate}
                    data-content="${declarationContent}" data-loginid="${list.declList[i].nickname}">
                      <li>${declarationDate}</li>
                      <li class="decl-content-box" data-typeid="${typeId}" data-cate="${cate}">
                        <div class="declaration-content-text">
                          ${declarationContent}
                        </div>
                      </li>
                      <li>${list.declList[i].nickname}</li>
                      <li>${declProcessDate}</li>
                      <li>${declarationCheck}</li>
                    </ul>
        `
        }

        $declResultBox.innerHTML = declListTags;
        let $totalDeclNum = document.querySelector('.main__list-rownum-box > p > span');
        let $nowrowBox = document.querySelector('.main__rownum-select');
        let nowDeclType = document.querySelector('.main__declaration-select').value;
        console.log('nowDeclType : ' , nowDeclType)

        $totalDeclNum.innerText = list.declPage.total;

        if(list.declPage.prev){
          declPageTags += `<span class="lf-arrow decl-page-btn"><a  href="${params}" data-page="${list.declPage.startPage -1}">&lt;</a></span>`
        }
        for (let i = list.declPage.startPage; i < list.declPage.endPage + 1; i++) {
          let prev = list.declPage.prev;

          declPageTags += `   
                      <li class="decl-page-btn"><a href="${params}" data-page="${i}""><strong>${i}</strong></a></li>    
            `
        }
        if(list.declPage.next) {
          declPageTags += `<span class="rt-arrow decl-page-btn"><a  href="${params}" data-page="${list.declPage.endPage +1}">&gt;</a></span>`;
        }

        $declPageBox.innerHTML = declPageTags
      });
}

function declReqA(searchDeclInfo, amount, page, type){
  console.log(searchDeclInfo)

  // console.log(params.toString())
  let params = searchDeclInfo;

  fetch(`/v1/declarations/${type}?${params.toString()}&amount=${amount}&page=${page}`, {
    method : 'GET',
  }).then(resp => resp.json())
      .then(list => {
        console.log('list', list);
        console.log(list.declList)
        let declListTags = ``;
        let declPageTags = ``;
        let $declResultBox = document.querySelector('.main__result-list-container');
        let $declPageBox = document.querySelector('.main__searched-result-page-btn > ul');

        for (let i = 0; i < list.declList.length; i++) {
          let declarationDate = list.declList[i].declarationDate;
          let declarationContent = list.declList[i].declarationContent;
          let userId = list.declList[i].userId;
          let declProcessDate = list.declList[i].declProcessDate;
          let declarationCheck = list.declList[i].declarationCheck;
          let typeId = list.declList[i].typeId;
          let cate = list.declList[i].cate;
          let declId = list.declList[i].declarationId;

          declListTags += `
                    <ul data-declId=${declId} data-declDate=${declarationDate}
                    data-content="${declarationContent}" data-loginid="${userId}">
                      <li>${declarationDate}</li>
                      <li class="decl-content-box" data-typeid="${typeId}" data-cate="${cate}">
                        <div class="declaration-content-text">
                          ${declarationContent}
                        </div>
                      </li>
                      <li>${userId}</li>
                      <li>${declProcessDate}</li>
                      <li>${declarationCheck}</li>
                    </ul>
        `
        }

        $declResultBox.innerHTML = declListTags;
        let $totalDeclNum = document.querySelector('.main__list-rownum-box > p > span');
        let $nowrowBox = document.querySelector('.main__rownum-select');

        $totalDeclNum.innerText = list.declPage.total;

        if(list.declPage.prev){
          declPageTags += `<span class="lf-arrow decl-page-btn"><a  href="${params}" data-page="${list.declPage.startPage -1}">&lt;</a></span>`
        }
        for (let i = list.declPage.startPage; i < list.declPage.endPage + 1; i++) {
          let prev = list.declPage.prev;

          declPageTags += `   
                      <li class="decl-page-btn"><a href="${params}" data-page="${i}""><strong>${i}</strong></a></li>    
            `
        }
        if(list.declPage.next) {
          declPageTags += `<span class="rt-arrow decl-page-btn"><a  href="${params}" data-page="${list.declPage.startPage -1}">&gt;</a></span>`;
        }

        $declPageBox.innerHTML = declPageTags
      });
}

{
  let $pageBox = document.querySelector('.main__searched-result-page-btn');

  $pageBox.addEventListener('click', function (e){
    console.log(e.target)

    if(e.target.classList.contains('decl-page-btn')){
      let nowDeclType = document.querySelector('.main__declaration-select').value;
      let $pageLink = e.target.querySelector('a');
      console.log('pageLink', $pageLink)
      let $nowrowBox = document.querySelector('.main__rownum-select');
      console.log('$pageLink.getAttribute(\'href\') : ' , $pageLink.getAttribute('href'))

      declReqA($pageLink.getAttribute('href'), $nowrowBox.value, $pageLink.dataset.page , nowDeclType);
    }

  })

}

{
    let $declIgnore = document.querySelector('#declaration-ignore-btn');
    let $declarationBox = document.querySelector(
        ".main__declaration-content-view-box"
    );

    $declIgnore.addEventListener('click', function (){
      removeDeclaration();
      $declarationBox.classList.remove("declaration-view-flex");
    })
}

function removeDeclaration(){
  let $declIdStore = document.querySelector('.decl-id-store');
  let declId = $declIdStore.value;
  let nowDeclType = document.querySelector('.main__declaration-select').value;
  console.log('declId : ', declId)

  fetch(`/v1/declaration/${nowDeclType}/${declId}`, {method : "DELETE"})
      .then(() => {
          // let $pageLink = e.target.querySelector('a');
        let firstPage = document.querySelector('.decl-page-btn:nth-child(1) > a');
          console.log('firstPage : ', firstPage)
        let $nowrowBox = document.querySelector('.main__rownum-select');
        let nowDeclType = document.querySelector('.main__declaration-select').value;
        // console.log('firstPage : ', firstPage)
        declReqA(firstPage.getAttribute('href'), $nowrowBox.value, firstPage.dataset.page , nowDeclType)
      });
}

{
  //검색 쌍 안맞는 문제 조건

  let $startDeclDate = document.querySelector('.startDeclDate');
  let $endDeclDate = document.querySelector('.endDeclDate');

  let $startPDate = document.querySelector('.startPDate');
  let $endPDate = document.querySelector('.endPDate');

  let $searchBtn = document.querySelector('.decl-search-btn');

  let $pairOptions = document.querySelectorAll('.pair-options');

  $pairOptions.forEach(ele => ele.addEventListener('change', function (){
    console.log('hi222222222222222222222222222222')
    console.log($startDeclDate.value + "------------" + $endDeclDate.value);
    if(($startDeclDate.value == '' && $endDeclDate.value == '') || ($startDeclDate.value != '' && $endDeclDate.value != '')) {
      $searchBtn.dataset.pair = "pair";
    }else{
      $searchBtn.dataset.pair = "notpair";
    }

    if(($startPDate.value == '' && $endPDate.value == '') || ($startPDate.value != '' && $endPDate.value != '')) {
      if(!($searchBtn.dataset.pair === "notpair")){
        $searchBtn.dataset.pair = "pair";
      }
    }else{
      $searchBtn.dataset.pair = "notpair";
    }
  }))

  $searchBtn.addEventListener('click', function (){
    if($searchBtn.dataset.pair === "notpair"){
      alert("검색 조건이 부정확합니다.")
    }
  })

}

{
    // 포스트 신고 대상 삭제

    let $processBtn = document.querySelector('#declaration-to-content-delete-btn')
    let $declarationBox = document.querySelector(
    ".main__declaration-content-view-box");
    console.log('$declarationBox : ', $declarationBox)

    $processBtn.addEventListener('click', function (){
        let nowDeclType = document.querySelector('.main__declaration-select').value;
        console.log('nowDeclType : ', nowDeclType)
        if(nowDeclType === 'post'){
            postDeleteReq(this.dataset.target, this.dataset.cate);
        }else if(nowDeclType === 'comment'){
            commentDeleteReq(this.dataset.target, this.dataset.cate);
        }

        $declarationBox.classList.remove("declaration-view-flex");
    })

}

function postDeleteReq(postId, postType){
    fetch(`/v1/admin/post?postId=${postId}&postType=${postType}`, {
        method : "DELETE"
    }).then()
}

function commentDeleteReq(commentId, commentType){
    fetch(`/v1/admin/comment?commentId=${commentId}&commentType=${commentType}`, {
        method : "DELETE"
    }).then()
}


