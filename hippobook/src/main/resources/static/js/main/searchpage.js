// showTitleWait()
let $bookSearchInput = document.querySelector('.search_input > input');

let inter = null;

{
    recommendReq(showRecommend);

    $bookSearchInput.addEventListener('keyup', function (e) {
        if(e.keyCode === 8){
            console.log('백스페이스 눌림')
            return;
        }
        console.log('keyup stop')
        clearTimeout(inter);
        inter = setTimeout(function () {
            reqApi($bookSearchInput.value, 'input', showSearchTitle);
        }, 2000);
    });

    $bookSearchInput.addEventListener("keyup", function (e){
        // console.log('e.keyCode : ', e.keyCode)
        if(e.keyCode === 13){
            clearTimeout(inter);
            console.log('e.keyCode : ', e.keyCode);
            reqApi($bookSearchInput.value, 'result', showBookReq)
        }
    });

    $bookSearchInput.addEventListener('focus', function (){
        clearTimeout(inter);
        reqApi($bookSearchInput.value, 'input', showSearchTitle);
    });
}

// {
//     //책 누를시 책 정보 페이지 이동 이벤트
//     let $bookResultBox = document.querySelector('.main__book-result-link-content-box');
//     $bookResultBox.addEventListener('click', function (e) {
//         console.log(`e.target : ${e.target}`)
//
//     })
//
// }

{
    //추천 키워드 클릭시 검색 이벤트
    let $recommendBox = document.querySelector('.main__search-recommend-box');
    $recommendBox.addEventListener('click', function (e) {
        if(e.target.classList.contains('recommend-word')){
            console.log(`e.target : ${e.target}`)
            $bookSearchInput.value = e.target.innerText;
            $bookSearchInput.dispatchEvent(new KeyboardEvent('keyup', {keyCode: 13}));
        }
    })

}

function recommendReq(callback){
    fetch("/v1/search/recommends", {method : "GET"})
        .then(resp => resp.json())
        .then(json => {
            console.log(`recommendReq : ${json}`)
            callback(json)
        })
}

function showRecommend(jsonList){
    console.log(`showRecommend ${jsonList}`)
    let tags = '';
    let $recommendBox = document.querySelector('.main__search-recommend-box');

    for (let i = 0; i < jsonList.length; i++) {
        tags += `
                <li class="recommend-word">
                    <span class="recommend-word">${jsonList[i].keyword}</span>
                </li>
        `
    }

    $recommendBox.innerHTML = tags;
}

function showBookReq(jsonList){
    console.log('jsonList : ', jsonList)
    let $bookSearchResultContainer = document.querySelector('.main__book-search-result-container');
    let $bookSearchContentBox = document.querySelector('.main__book-result-link-content-box');
    let $bookSearchWordBox = document.querySelector('.main__book-search-word-container');
    let tags = ''



    for (let i = 0; i < jsonList.length; i++) {
        let beforeCover =  jsonList[i].cover
        console.log(`beforeCover : ${beforeCover}`)
        let afterCover = jsonList[i].cover.replace("sum", "")
        console.log(`afterCover : ${afterCover}`)

        tags += `
                        <li>
                            <a href="/book/info?bookId=${jsonList[i].bookId}">
                                <img class="book-result-thumbnail" src="${jsonList[i].cover}" alt="">
                                <div class="book-result-title-writer-box">
                                    <p class="book-result-title">${jsonList[i].bookName}</p>
                                    <p class="book-result-writer">${jsonList[i].bookWriter}</p>
                                </div>
                            </a>
                        </li>
        `
    }

    $bookSearchContentBox.innerHTML = tags;
    $bookSearchWordBox.classList.remove('active-search-focus-block');
    $bookSearchResultContainer.classList.add('active-search-enter-block')
    $bookSearchInput.blur()
}



function showSearchTitle(jsonList){
    console.log(`showSearchTitle() : ${jsonList}`)
    let $bookSearchWordBox = document.querySelector('.main__book-search-word-container');
    let $searchBox = $bookSearchWordBox.querySelector('ul');
    let tags = '';
    let endIdx = jsonList.length < 10 ? jsonList.length : 10;

    for (let i = 0; i < endIdx; i++) {
        tags += `<li>
                    <span class="search-content-title">
                        ${jsonList[i].bookName}
                    </span>
                </li>`
    }

    $searchBox.innerHTML = tags;
    $bookSearchWordBox.classList.add('active-search-focus-block');
}

function reqApi(keyword, reqType, callback){
    console.log(`reqApi() : ${keyword}`);

    let encKeyword = encodeURIComponent(keyword)

    fetch(`/v1/search/book?keyword=${encKeyword}&reqtype=${reqType}`,
        {method : "GET"})
        .then(resp => resp.json())
        .then(json => {
            console.log('json', json)
            if(callback) { callback(json); }
        });
}


{   // 디스플레이된 타이틀 클릭시 발생되는 이벤트
    let $searchBox = document.querySelector('.main__book-search-word-container > ul');
    $searchBox.addEventListener('click', function (e){
        console.log(e.target)
        if(e.target.classList.contains('search-content-title')){
            console.log('e.target : ', e.target)
            $bookSearchInput.value = e.target.innerText;
            $bookSearchInput.dispatchEvent(new KeyboardEvent('keyup', {keyCode: 13}));
        }
    })
}




