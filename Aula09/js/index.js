function enviar(event) {
    event.preventDefault();
    let user=document.getElementById("inputUser").value;
    let password=document.getElementById("inputPassword").value;

    console.log(user + ": "+password);
    //alert("Olá! "+login )
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

    fetch("http://localhost:8080/user/login", msg)
        .then( res => mostraRetorno(res))
}

function mostraRetorno(retorno) {
    if(retorno.status == 200) {
        document.getElementById("resultado").innerHTML="Login ok";
        retorno.json().then( res => avanca(res) );
    } else {
        document.getElementById("resultado").innerHTML="Falha no login";
    }
}

function avanca(user) {
    console.log(user);
    localStorage.setItem("userlogged", JSON.stringify(user));
    window.location="interna.html"

}
