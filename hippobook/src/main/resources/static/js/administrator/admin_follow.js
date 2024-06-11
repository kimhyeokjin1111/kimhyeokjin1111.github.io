{
  //검색 결과 전체 선택
  //전체 취소 이벤트
  let $checkAllBtn = document.querySelector('.main__result-checkall');

  console.log($checkAllBtn);

  $checkAllBtn.addEventListener('click', function () {
      let $checkonebtnList = document.querySelectorAll('.main__result-checkone');
    console.log('hi');
    console.log($checkAllBtn.checked);
    if ($checkAllBtn.checked) {
      $checkonebtnList.forEach((ele) => {
        ele.checked = true;
      });
    } else {
      $checkonebtnList.forEach((ele) => {
        ele.checked = false;
      });
    }
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
  let $followCheck = document.querySelector('.main__followgoal-td');
  let $permission = document.querySelectorAll('.permission');

  $permission.forEach(p => {
    p.addEventListener('click', function (){
      $followCheck.dataset.check = p.value;
    })
  })
}

{
  let stickerPageUl = document.querySelector('.main__searched-result-page-btn > ul')

  stickerPageUl.addEventListener('click', function (e){
    let params = e.target.getAttribute("href");
    let page = e.target.dataset.page;

    if(e.target.classList.contains('sticker-page-btn')){
      fetch(`/v1/admin/follow?${params}?page=${page}`)
          .then(list => list.json())
          .then(l => {
            let tags = '';
            let resultSticker = document.querySelector('.main__result-list-container');

            for (let i = 0; i < l.followList.length; i++) {
              console.log(l.followList[i])
              let name = l.followList[i].userName;
              let loginId = l.followList[i].userNickname;
              let gender = l.followList[i].userGender;
              let age = l.followList[i].userAge;
              let followCnt = l.followList[i].followCnt;
              let skickerDate = l.followList[i].skickerDate;
              let userId = l.followList[i].userId

              console.log(name)
              console.log(loginId)
              console.log(gender)
              console.log(age)
              console.log(followCnt)
              console.log(skickerDate)

              tags += `<ul data-uid="${userId}">
                      <li>
                        <label>
                          <input
                            type="checkbox"
                            name="checkOne"
                            class="main__result-checkone"
                          />
                        </label>
                      </li>
                      <li>${name}</li>
                      <li>${loginId}</li>
                      
                      <li>${gender}</li>
                      <li>${age}</li>
                      <li>${followCnt}</li>
                      <li>${skickerDate}</li>
                    </ul>
                    `
            }

            resultSticker.innerHTML = tags;
            console.log('l.stickerPage : ', l.stickerPage )

            let tags2 = ``;
            let stickerPageUl = document.querySelector('.main__searched-result-page-btn > ul')

            if(l.stickerPage.prev) {
              tags2 += `<span class="lf-arrow sticker-page-btn"><a href="/v1/admin/follow?${params}" data-page="${l.stickerPage.startPage -1}">&lt;</a></span>`;
            }

            for (let i = l.stickerPage.startPage; i < l.stickerPage.endPage + 1; i++) {
              tags2 += `   
                      <li class="sticker-page-btn"><a href="/v1/admin/follow?${params}" data-page="${i}"><strong>${i}</strong></a></li>    
            `
            }

            if(l.stickerPage.next) {
              tags2 += `<span class="rt-arrow sticker-page-btn"><a href="/v1/admin/follow?${params}" data-page="${l.stickerPage.endPage +1}">&gt;</a></span>`;
            }

            stickerPageUl.innerHTML = tags2;
          })
    }
  })
}

{
  let $searchBtn = document.querySelector('.main__user-search-btn');
  let $followUserName = document.querySelector('.main__userInfo-input');
  let $fStartDate = document.querySelector('.startDate');
  let $fEndDate = document.querySelector('.endDate');
  let $followCheck = document.querySelector('.main__followgoal-td');
  let $rownum = document.querySelector('.main__rownum-select');

  $searchBtn.addEventListener('click', function (){
    let followStikerInfo = {
        userName : $followUserName.value,
        startFollowDate : $fStartDate.value,
        endFollowDate : $fEndDate.value,
        fPermission : $followCheck.dataset.check || ""
    }

    let params = new URLSearchParams(followStikerInfo);
    let rowValue = document.querySelector('.main__rownum-select').value;
    console.log(rowValue)
    console.log(params.toString())
    fetch(`/v1/admin/follow?${params.toString()}&amount=${rowValue}`, {method : "GET"})
        .then(list => list.json())
        .then(l => {
          let tags = '';
          let resultSticker = document.querySelector('.main__result-list-container');

          for (let i = 0; i < l.followList.length; i++) {
            console.log(l.followList[i])
            let name = l.followList[i].userName;
            let loginId = l.followList[i].userNickname;
            let gender = l.followList[i].userGender;
            let age = l.followList[i].userAge;
            let followCnt = l.followList[i].followCnt;
            let skickerDate = l.followList[i].skickerDate;
            let userId = l.followList[i].userId

            console.log(name)
            console.log(loginId)
            console.log(gender)
            console.log(age)
            console.log(followCnt)
            console.log(skickerDate)

            tags += `<ul data-uid="${userId}">
                      <li>
                        <label>
                          <input
                            type="checkbox"
                            name="checkOne"
                            class="main__result-checkone"
                          />
                        </label>
                      </li>
                      <li>${name}</li>
                      <li>${loginId}</li>
                      
                      <li>${gender}</li>
                      <li>${age}</li>
                      <li>${followCnt}</li>
                      <li>${skickerDate}</li>
                    </ul>
                    `
          }

          resultSticker.innerHTML = tags;
          console.log('l.stickerPage : ', l.stickerPage )
          
          let tags2 = ``;
          let stickerPageUl = document.querySelector('.main__searched-result-page-btn > ul')

          if(l.stickerPage.prev) {
            tags2 += `<span class="lf-arrow sticker-page-btn"><a href="/v1/admin/follow?${params}&amount=${rowValue}" data-page="${l.stickerPage.startPage -1}">&lt;</a></span>`;
          }

          for (let i = l.stickerPage.startPage; i < l.stickerPage.endPage + 1; i++) {
            tags2 += `   
                      <li class="sticker-page-btn"><a href="/v1/admin/follow?${params}&amount=${rowValue}" data-page="${i}"><strong>${i}</strong></a></li>    
            `
          }

          if(l.stickerPage.next) {
            tags2 += `<span class="rt-arrow sticker-page-btn"><a href="/v1/admin/follow?${params}&amount=${rowValue}" data-page="${l.stickerPage.endPage +1}">&gt;</a></span>`;
          }

          stickerPageUl.innerHTML = tags2;
        })
  })

}

{
    let $permissionBtn = document.querySelector('.main__user-delete-btn');
    console.log('$permissionBtn : ', $permissionBtn);

    $permissionBtn.addEventListener("click", function (){
        let $checkonebtnList = document.querySelectorAll('.main__result-checkone');
        console.log('$checkonebtnList', $checkonebtnList)
        console.log('click1111111111111111')
        let idList = [1]
        idList.splice(0, idList.length);
        for (let i = 0; i < $checkonebtnList.length; i++) {
            console.log($checkonebtnList[i].checked)
            if($checkonebtnList[i].checked === true){
                console.log($checkonebtnList[i].closest("ul"))
                let uid = $checkonebtnList[i].closest("ul").dataset.uid;
                console.log(uid);
                idList.push(Number(uid));
            }
        }
        console.log(idList)

        fetch(`/v1/admin/sticker`,
            {
            method : "PATCH",
            headers : {'Content-Type' : 'application/json;'},
            body : JSON.stringify(idList)
            }
        )
    })
}

