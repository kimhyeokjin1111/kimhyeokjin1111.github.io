document.getElementById("sendSMSButton").addEventListener("click", function(event) {
    let phoneNumber = document.getElementById("sendSMSButton").value;

    console.log(event.target);

    let data = {
        phoneNumber: phoneNumber
    };

    fetch('/registerPhoneCode', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('ERROR');
            }
            return response.json();
        })
        .then(data => {
            console.log('인증번호가 발송되었습니다.:', data);
        })
        .catch(error => {
            console.error('인증번호가 발송되지 않았습니다.:', error);
        });
});

function verifySms(phoneNumber, code) {
    fetch('/registerPhoneCodeSend=' + phoneNumber + '&code=' + code), {
        method: 'POST'
    }
        .then(response => {
            if (!response.ok){
                throw new error('ERROR');
            }
            return response.text();
        })
        .then(data => {
            console.log(data);
        })
        .catch(error => {
            console.error('인증번호가 일치하지 않습니다.', error);
        });
}

document.getElementById('phone-code-check-button').addEventListener('submit', function(event) {
    event.preventDefault();

    const phoneNumber = document.getElementById('phoneNumber').value;
    const code = document.getElementById('phone-code-check-button').value;

    phoneNumber(phoneNumber);
    verifySms(phoneNumber, code);
})
