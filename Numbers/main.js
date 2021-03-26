var num = 0

function increase() {
    document.getElementById('numSpan').innerText = ++num
    setColor()
}

function decrease() {
    document.getElementById('numSpan').innerText = --num
    setColor()
}

function setColor() {
    var colName = "lead mx-2 "
    colName += (num > 0) ? 'text-success' : (num < 0) ? 'text-danger' : 'text-primary'
    document.getElementById('numSpan').className = colName
}