function showToast() {
    document.getElementById("toast").style.display = "block";

    setTimeout(function () {
        document.getElementById("toast").style.display = "none";
    }, 2000);

}