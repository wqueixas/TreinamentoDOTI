function validaLogin() {
    let evidencia=localStorage.getItem("userlogged");
    if(!evidencia) {
        window.location="index.html"
    }

    let user=JSON.parse(evidencia);

    document.getElementById("dadosUser").innerHTML = `<b>${user.name}</b> (${user.email})`;

    buscarUsuarios();

}

function logout() {
    localStorage.removeItem("userlogged")
    window.location="index.html"
}

function buscarAnuncios() {
    let user=document.getElementById("selUser");
    let id=user[user.selectedIndex].value;
    fetch("http://localhost:8080/user/id/"+id)
        .then( res => trataResposta(res));
}

function trataResposta(res) {
    if(res.status==200) {
        res.json().then(res => exibirAnuncios(res));
    } else {
        document.getElementById("listaAnuncios").innerHTML="<HR>Usuário não encontrado"
    }
}

function exibirAnuncios(dados) {
    let item=dados.anuncios;
    let tabela="<br><table width=100% border=thin><tr><th>ID</th><th>Descrição</th><th>Valor (R$)</th></tr>";

    if(item.length == 0) {
        document.getElementById("listaAnuncios").innerHTML="<HR>Sem anúncios para esse usuário";
    } else {
        for(let i=0; i < item.length; i++) {
            tabela=tabela+`
            <tr>
                <td align=middle>${item[i].id}</td>
                <td>${item[i].descricao}</td>
                <td align=right>${item[i].valor}</td>
            </tr>`
        }

        tabela=tabela+"</table>";
        document.getElementById("listaAnuncios").innerHTML=tabela;
    }
    
}

function buscarUsuarios(){
    fetch("http://localhost:8080/user/all")
    .then( res => res.json()
    .then( res => exibirUsuarios(res)));
}

function exibirUsuarios(lista){

    let opcoes='';
        for(let i=0; i < lista.length; i++) {
            opcoes=opcoes+` <option value=${lista[i].id}>${lista[i].name}</option>`;
        }

    document.getElementById("selUser").innerHTML=opcoes;
}
