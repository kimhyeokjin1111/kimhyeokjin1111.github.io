{
    function checkLoginId() {
        const id = $('#userLoginId').val();
        $.ajax({
            url: '/user/register',
            type: 'POST',
            data: {userLoginId: id},
            function (cnt) {
                if (cnt === 0) {
                    $('.id_ok').css("display", "inline-block");
                    $('.id_already').css("display", "none");
                } else {
                    $('.id_already').css("display", "inline-block");
                    $('.id_ok').css("display", "none");
                    alert("아이디를 다시 입력해주세요");
                    $('#id').val('');
                }
            },
            error: function () {
                alert("에러입니다");
            }
        });
    }
}