{
  let $readingBookPlus = document.querySelector(".reading-book-plus");
  let $modalBox = document.querySelector(".reading-book-plus-modal-bg");
  let $xBox = document.querySelector(".x-box");
  let $readingBookPlusImgs = document.querySelectorAll(
    ".reading-book-img-check"
  );
  let $modalBox2 = document.querySelector(".book-container-modal-bg2");
  let $bookStatusSet = document.querySelector(".book-status-set");


  console.log($readingBookPlus);

  $readingBookPlus.addEventListener("click", function () {
    $modalBox.style.display = "flex";
  });

  $xBox.addEventListener("click", function () {
    $modalBox.style.display = "none";
  });



  let $title = $modalBox.querySelector("h1");
  console.log($title);

  for (let i = 0; i < $readingBookPlusImgs.length; i++) {
    $readingBookPlusImgs[i].addEventListener("click", function () {
      let $activeBox = document.querySelector(".reading-book-img-check.active");

      if ($activeBox) {
        $activeBox.classList.remove("active");
      }
      this.classList.add("active");
    });
  }

  $title.addEventListener("mouseout", function () {
    this.style.color = "black";
  });

  $title.addEventListener("click", function () {
    console.log(this);
    console.log(this.closest(".modal-bg"));
    this.closest(".modal-bg").style.display = "none";
  });
}
