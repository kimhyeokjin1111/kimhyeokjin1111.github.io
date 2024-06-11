
$(document).ready(function ($){
    $(".category").click(function (event){
        console.log(".category");
        event.preventDefault();
        $('html,body').animate({scrollTop:$(this.hash).offset().top},
            1);
    })
})
$(document).ready(function ($){
    $(".keyword").click(function (event){
        console.log(".keyword");
        event.preventDefault();
        $('html,body').animate({scrollTop:$(this.hash).offset().top},
            1);
    })
})
$(document).ready(function ($){
    $(".editor").click(function (event){
        console.log(".editor");
        event.preventDefault();
        $('html,body').animate({scrollTop:$(this.hash).offset().top},
            1);
    })
})
