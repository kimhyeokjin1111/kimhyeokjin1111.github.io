{

  // 모달 띄우는
  let $categoryOpenBtn = document.querySelector(".category_openBtn");
  let $getmodal = document.querySelector(".category_popup");
  let $categoryCloseBtn = document.querySelector(".main_content");


  $categoryOpenBtn.addEventListener("click", function(){
    $getmodal.style.display = "block";
  });


  $categoryCloseBtn.addEventListener("click", function (){
    $getmodal.style.display = "none";
  })

  // window.onclick = function (categoryEvent) {
  //   if (categoryEvent.target === $getmodal) {
  //     $getmodal.style.display = "none";
  //   }
  // };

  let $slidesBanner = document.querySelector(".slides_banner");
  let $slidesContent = document.querySelectorAll(".slides_content");
  let $btnWrapLeft = document.querySelector(".btn_wrap_left");
  let $btnWrapRight = document.querySelector(".btn_wrap_right");

  let slideWidth = 1017;
  let currentIdx = 0;
  let slideCnt = $slidesContent.length;

  function checkEnd() {
    $btnWrapLeft.classList.toggle(
      "none",
      currentIdx <= 0 || currentIdx == slideCnt - 1
    );
    $btnWrapRight.classList.toggle(
      "none",
      currentIdx >= slideCnt - 2 && currentIdx != slideCnt - 1
    );
  }

  /**
   * 슬라이딩 배너 인터벌 리셋 함수 (기존 인터벌 삭제 후 새로운 인터벌 적용)
   *
   * @return {void}
   */
  function resetInterval() {
    clearInterval(interval);
    interval = setInterval(bannerInterval, 3000);
  }

  /**
   * 슬라이딩 배너 이동 함수
   *
   * @param {number} index - 이동할 배너의 인덱스
   * @param {boolean} [isReset=false] - 리셋 여부
   * @param {boolean} [isNext=true] - 다음 이동 여부(이전 버튼 클릭시 false 넣어야함)
   */
  function moveSlide(index, isReset = false, isNext = true) {
    if (isReset) {
      $slidesBanner.style.transition = "none";
    } else {
      $slidesBanner.style.transition = "";
    }

    currentIdx = index;
    $slidesBanner.style.left = `${-currentIdx * slideWidth}px`;

    if (currentIdx === 0 && isNext) {
      setTimeout(() => {
        $slidesBanner.style.transition = "";
        moveSlide(currentIdx + 1);
        resetInterval();
      }, 0);
      return;
    }
    checkEnd();
  }

  /**
   * 다음 슬라이드로 이동하는 함수
   * 만약 슬라이드가 마지막인 경우 첫번째 배너로 이동 및 인터벌 재설정
   * 그렇지 않으면 다음 슬라이드로 이동
   *
   * @return {void}
   */
  function bannerInterval() {
    if (currentIdx === slideCnt - 1) {
      currentIdx = 0;
      moveSlide(currentIdx, true);
    } else {
      moveSlide(currentIdx + 1);
    }
    resetInterval();
  }

  $btnWrapRight.addEventListener("click", () => {
    if (currentIdx === slideCnt - 1) {
      currentIdx = 0;
      moveSlide(currentIdx, true);
    } else {
      moveSlide(currentIdx + 1);
    }
    resetInterval();
  });

  $btnWrapLeft.addEventListener("click", () => {
    moveSlide(currentIdx - 1, false, false);
    resetInterval();
  });

  let interval = setInterval(bannerInterval, 3000);
  checkEnd();
}


// BestSeller
{
  fetch(`/rank`, {
    method: 'GET'
  }).then(resp => resp.json())
      .then(result => {
        displayBookList(result);
      });

  function displayBookList(obj) {
    // console.log(obj)
    let bookList = obj.item;
    console.log(bookList)
    let tags = '';

    let idx = 0;

    for(let i=0; i<3; i++){
      tags += '<div class="ranking_border_box_wrap">';

      for(let j=0; j<3; j++){
        tags += `
        <a href="/categorie/Categoriepage">
        <div class="ranking_content">
            <div class="rank_num${idx + 1}"></div>
            <div class="thumbnail">
                <div class="book_picture">
                    <picture>
                        <img src="${bookList[idx].cover}" alt="">
                    </picture>
                </div>
            </div>
            <div class="thumbnail_title">
                <a href="" class="book_data">
                    <div class="book_content">
                        <p class="rank_book_title">${bookList[idx].title}</p>
                    </div>
                </a>
            </div>
        </div>
        </a>
        `;
        idx++;
      }

      tags += `</div>`;
    }


    let $box = document.querySelector('.hipppo_ranking-box');
    $box.innerHTML = tags;
    // let $box = document.querySelector('.hipppo_ranking_layout');
    // $box.insertAdjacentHTML('beforeend', tags);
  }
}

