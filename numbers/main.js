function add() {
    document.getElementById('num').innerText++
    setColor()
    disableButtons()
}

function sub() {
    document.getElementById('num').innerText--
    setColor()
    disableButtons()
}

function setColor() {
    var num = document.getElementById('num').innerText
    var numColor = 'lead mx-2 text-'

    numColor += (num == 0) ? 'primary' : (num > 0) ? 'success' : 'danger'
    document.getElementById('num').className = numColor
}

function disableButtons() {
    var num = document.getElementById('num').innerText
    if (num == -5)
        document.getElementById('subBtn').disabled = true

    if (num != -5)
        document.getElementById('subBtn').disabled = false

    if (num == 5)
        document.getElementById('plusBtn').disabled = true

    if (num != 5)
        document.getElementById('plusBtn').disabled = false
}

// innerHTML = there's a tag inside a tag !
// innerText = there's a value inside a tag !