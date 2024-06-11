let chatMsg = "";

{
    let userId = document.querySelector('.chatbot-container')?.dataset.userid;
    console.log('userId : ', userId);
}

{
    console.log("chatbot jssssssssssssssss");

    let chatInput = document.querySelector("#chat-input");
    let chatBtn = document.querySelector('#chat-btn');
    let chatViewBox = document.querySelector('.chatbot-viewer-box');

    console.log('chatInput : ', chatInput)
    console.log('chatBtn : ', chatBtn)
    console.log('chatViewBox : ',chatViewBox)
    chatBtn?.addEventListener('click', function (){
        console.log('chat btn click !!')

        let chatValue = chatInput.value;
        let tags =
            `
            <div class="user-chat-box"><div class="chat-div">${chatValue}</div></div>
            `

        chatViewBox.insertAdjacentHTML("beforeend", tags);

        chatInput.value = '';

        let message = {
            content : chatValue
        }
        sendQuestion(message, appendResp);

    })
}

{
    let $chatbotShowIcon = document.querySelector('.chatbot-icon-box');
    let $chatbot = document.querySelector('.chatbot-container');
    $chatbotShowIcon?.addEventListener("click", function (e){
        if(e.target.classList.contains('chatbot-icon-box')){
            $chatbot.classList.toggle('display-chatbot');
        }
    })

    let $chatbotCloseIcon = document.querySelector('.close-Icon');

    $chatbotCloseIcon?.addEventListener("click", function (e){
        $chatbot.classList.toggle('display-chatbot');
        let chatViewBox = document.querySelector('.chatbot-viewer-box');

        console.log('chatViewBox.innerHTML.length : ', chatViewBox.innerHTML.length)
        if(chatViewBox.innerHTML.length !== 14){
            fetch('/v1/ai', {method : "DELETE"})
                .then();

            chatViewBox.innerHTML = "";
        }

    })
}

function appendResp(message) {
    let chatViewBox = document.querySelector('.chatbot-viewer-box');

    let tags =
        `
        <div class="chatbot-chat-box"><div class="chat-div chatbot-back-color">${message}</div></div>
        `
    chatViewBox.insertAdjacentHTML("beforeend", tags);
}

function sendQuestion(message, callback) {
    fetch(`/v1/ai/reply`,
        {
            method : "POST",
            headers : {'Content-Type' : 'application/json'},
            body : JSON.stringify(message)
        })
        .then(resp => resp.json())
        .then(json => {
            callback(json.choices[0].message.content)
            chatMsg = json.choices[0].message.content;
        });
}