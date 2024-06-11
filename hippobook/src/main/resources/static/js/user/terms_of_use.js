{
    function is_checked() {

        const checkbox =
            document.getElementById('check');

        const is_checked = checkbox.checked;

        document.getElementById('result').innerText =
            is_checked;
    }

    function checkAll(checkAll) {
        const checkboxes
        = document.querySelectorAll('input[type="checkbox"]');

        checkboxes.forEach((checkbox) => {
            checkbox.checked = checkAll.checked
        })
    }
}