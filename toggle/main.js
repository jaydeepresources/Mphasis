var paraFlag = true;

function toggle() {
    paraFlag = !paraFlag; 

    if (!paraFlag) {
        document.getElementById("paraId").style.display = "none";
        document.getElementById("caption").innerText = "show";
    }
    else {
        document.getElementById("paraId").style.display = "block";
        document.getElementById("caption").innerText = "hide";
    }
}