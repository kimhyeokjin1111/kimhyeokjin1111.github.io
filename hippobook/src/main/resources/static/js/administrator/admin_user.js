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
  //검색 결과 전체 선택
  //전체 취소 이벤트
  let $checkAllBtn = document.querySelector('.main__result-checkall');
  let $checkonebtnList = document.querySelectorAll('.main__result-checkone');

  console.log($checkAllBtn);
  console.log($checkonebtnList);

  $checkAllBtn.addEventListener('click', function () {
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

  //회원 탈퇴 버튼 이벤트

  let $userDeleteBtn = document.querySelector('.main__user-delete-btn');

  $userDeleteBtn.addEventListener('click', function (){
    let userIdList = '';

    $checkonebtnList.forEach(ele => {
      if(ele.checked === true){
        userIdList += `userIdList=${ele.dataset.id}&`
      }
    })
    console.log(userIdList.length)

    userIdList = userIdList.substring(0, userIdList.length - 1)
    console.log(userIdList)

    // window.location = '/admin/user/remove?'+userIdList;

    let $adminUserform = document.querySelector(".admin-user-form");
    fetch(`/v1/users?${userIdList}` , {method : "DELETE"})
        .then(ele => {
          $adminUserform.submit();
        })
  })
}

{
  //셀렉트 수동 체크
  let $rownumSelect = document.querySelector('.main__rownum-select');
  let $adminUserform = document.querySelector(".admin-user-form");
  console.log($adminUserform);

  $rownumSelect.addEventListener('change', function (){
    console.log('hi~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~')
    $adminUserform.submit();
  })

}

{
  //검색 쌍 안맞는 문제 조건

  let $startJDate = document.querySelector('.startJDate');
  let $endJDate = document.querySelector('.endJDate');

  let $startUserAge = document.querySelector('.startUserAge');
  let $endUserAge = document.querySelector('.endUserAge');

  let $startVDate = document.querySelector('.startVDate');
  let $endVDate = document.querySelector('.endVDate');

  let $submitBtn = document.querySelector('.main__user-search-btn-div > button');

  let $pairOptions = document.querySelectorAll('.pair-options');

  $pairOptions.forEach(ele => ele.addEventListener('change', function (){
    console.log('hi222222222222222222222222222222')
    console.log($startJDate.value + "------------" + $endJDate.value);
    if(($startJDate.value == '' && $endJDate.value == '') || ($startJDate.value != '' && $endJDate.value != '')) {
      $submitBtn.setAttribute("type", "submit");
    }else{
      $submitBtn.setAttribute("type", "button");
    }

    if(($startUserAge.value == '' && $endUserAge.value == '') || ($startUserAge.value != '' && $endUserAge.value != '')) {
      if(!($submitBtn.getAttribute("type") == 'button')) {
        $submitBtn.setAttribute("type", "submit");
      }
    }else{
      $submitBtn.setAttribute("type", "button");
    }

    if(($startVDate.value == '' && $endVDate.value == '') || ($startVDate.value != '' && $endVDate.value != '')) {
      if(!($submitBtn.getAttribute("type") == 'button')){
        $submitBtn.setAttribute("type", "submit");
      }
    }else{
      $submitBtn.setAttribute("type", "button");
    }
  }))

  $submitBtn.addEventListener('click', function (){
    if($submitBtn.getAttribute("type") == 'button'){
      alert("검색 조건이 부정확합니다.")
    }
  })

}



