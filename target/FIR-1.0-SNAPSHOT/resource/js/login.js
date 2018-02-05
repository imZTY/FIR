window.onload = function () {


    var register = document.getElementById('register')
    var login = document.getElementById('login')
    var form_login = document.getElementById('form_login')
    var form_register = document.getElementById('form_register')

register.onclick=function(){

    this.className = 'register active'
    login.className="login"
    form_login.style.display="none"
    form_register.style.display='block'
}
    login.onclick = function () {
        this.className ='login active'
        register.className="register"
        form_login.style.display="block"
        form_register.style.display='none'
    }



}