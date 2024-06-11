{
    let $tabList = document.querySelectorAll('.tab_menu .list li');
    let $btnBox = document.querySelector('.btn_box')

    for (let i = 0; i < $tabList.length; i++) {
        $tabList[i].querySelector('.alarm_btn')
            .addEventListener('click', function (e) {
                e.preventDefault() // 새로 고침 x
                for (let j = 0; j < $tabList.length; j++) {
                    $tabList[j].classList.remove('btn_box');
                }
                // this.classList.add('$btnBox');
                this.parentNode.classList.add('btn_box');

            })
    }

    // // 회원 알람
    // function fetchAlarmsForMember(userId) {
    //     fetch(`/${userId}`)
    //         .then(response => response.json())
    //         .then(data => {
    //             const alarmList = document.getElementById('alarm-list');
    //             if (data.length === 0) {
    //                 alarmList.innerHTML = "<p>알림 없음</p>";
    //             } else {
    //                 alarmList.innerHTML = ""; // 기존 알람 내용 초기화
    //                 data.forEach(alarm => {
    //                     const alarmItem = document.createElement('div');
    //                     alarmItem.innerHTML = `<p>${alarm.content}</p>`;
    //                     alarmList.appendChild(alarmItem);
    //                 });
    //             }
    //         })
    //         // .catch(error => console.error('알람을 불러오는 중 오류 발생:', error));
    // }
    //
    // // 페이지 로드 시 회원 ID를 기반으로 알람을 가져와 표시
    // window.onload = function() {
    //     const userId = 1; // 예시 회원 ID
    //     fetchAlarmsForMember(userId);
    // };
    //
    //


}