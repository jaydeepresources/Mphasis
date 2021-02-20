
function validateForm() {
    var email = document.forms.userForm.email.value;
    var password = document.forms.userForm.password.value;

    if (email == "") {
        alert("Enter email");
        return false;
    }
    if (password == "") {
        alert("Enter password");
        return false;
    }
    return true;
}