{
  let $replyBtn = document.querySelector(".letter-reply");
  let $backBtn = document.querySelector(".letter-back");

  $replyBtn.addEventListener("click", function () {
    window.location.href = "/letterHtml/letter";
  });

  $backBtn?.addEventListener("click", function (){
    window.history.back();
  });
}
