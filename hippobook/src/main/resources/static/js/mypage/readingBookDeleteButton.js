{
  let $readingBookContents = document.querySelectorAll(".mybook-second");
  let $deleteButton = document.querySelector("#reading-book-delete-button");
  let $deleteIcon = document.querySelector(".reading-book-delete-icon");

  $deleteIcon.addEventListener("click", function () {
    $deleteButton.style.display = "flex";
  });

  $deleteButton.addEventListener("click", function () {
    $deleteButton.style.display = "none";
  });

  for (let i = 0; i < $readingBookContents.length; i++) {
    $readingBookContents[i].addEventListener("click", function () {
      let $activeBox = document.querySelector(".mybook-second.active");

      if ($activeBox) {
        $activeBox.classList.remove("active");
      }
      this.classList.add("active");
    });
  }
}
