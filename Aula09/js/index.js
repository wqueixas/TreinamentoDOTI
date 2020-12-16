const URL=${JAVA_URL}
function enviar(event) {
    event.preventDefault();
    let user=document.getElementById("inputUser").value;
    let password=document.getElementById("inputPassword").value;

    console.log(user + ": "+password);
    alert("Olá! "+user )
    //document.getElementById("resultado").innerHTML=senha;

    let loginMsg = {
        email: user,
        cpf: user,
        password: password
    }

    let msg = {
        method: 'POST',
        body:JSON.stringify(loginMsg),
        headers:{'Content-type':'application/json'}
    }

    fetch(URL+"/user/login", msg)
        .then( res => mostraRetorno(res))
}

function mostraRetorno(retorno) {
    if(retorno.status == 200) {
        document.getElementById("resultado").innerHTML="<h5 class=\"valido\"> Login OK </h5>";
        retorno.json().then( res => avanca(res) );
    } else {
        document.getElementById("resultado").innerHTML="<h5 class=\"invalido\"> Login Invalido </h5>";
    }
}

function avanca(user) {
    console.log(user);
    localStorage.setItem("userlogged", JSON.stringify(user));
    window.location="interna.html"

}
