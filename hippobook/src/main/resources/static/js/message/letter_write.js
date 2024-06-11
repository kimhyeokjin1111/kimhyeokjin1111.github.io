import * as module from '../message/module/messageModule.js'

{
  let $nickNameDuplicateBtn = document.querySelector("#letter-id-button");
  let $nickNameValue = document.querySelector("#letter-id-text");


    $nickNameDuplicateBtn.addEventListener("click",function (){
        $nickNameValue.value;
        console.log($nickNameValue.value)
        module.select($nickNameValue.value)
    });



}