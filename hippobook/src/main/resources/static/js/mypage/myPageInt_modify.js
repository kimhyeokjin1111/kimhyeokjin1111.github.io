{
  let $myInfoModifyInput = document.querySelectorAll(
    '.myInfo-modify-content > input'
  );

  $myInfoModifyInput.forEach((input) => {
    // console.log(input);
    input.addEventListener('focus', function () {
      console.log('focus');
      this.closest('.main__myInfo-modify-label').style.borderColor =
        'rgb(19, 19, 19)';
    });

    input.addEventListener('blur', function () {
      console.log('blur');
      this.closest('.main__myInfo-modify-label').style.borderColor =
        'rgb(203, 195, 195)';
    });
  });
}
