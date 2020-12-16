const URL=${JAVA_URL}

function validaLogin() {
    let evidencia=localStorage.getItem("userlogged");
    if(!evidencia) {
        window.location="index.html"
    }

    let user=JSON.parse(evidencia);

    document.getElementById("dadosUser").innerHTML = `<b>${user.name}</b> (${user.email})`;

    //buscarUsuarios();
    buscarAgentes();

}

function logout() {
    localStorage.removeItem("userlogged")
    window.location="index.html"
}

function buscarAnuncios() {
    let user=document.getElementById("selUser");
    let id=user[user.selectedIndex].value;
    fetch(URL+"/user/id/"+id)
        .then( res => trataResposta(res));
}

function trataResposta(res) {
    if(res.status==200) {
        res.json().then(res => exibirAnuncios(res));
    } else {
        document.getElementById("listaAnuncios").innerHTML="<BR>Usuário não encontrado"
    }
}

function exibirAnuncios(dados) {
    let item=dados.anuncios;
    let tabela="<br><table align=center border=1 width=50%><tr><th>ID</th><th>Descrição</th><th>Valor (R$)</th></tr>";

    if(item.length == 0) {
        document.getElementById("listaAnuncios").innerHTML="<BR>Sem anúncios para esse usuário";
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
    fetch(URL+"/user/all")
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

function buscarAgentes() {
    fetch(URL+"/agente/listaPorVol")
    .then( res => res.json() )
    .then( res => exibirAgentes(res) );
}
function exibirAgentes(lista){

    let opcoes='';
        for(let i=0; i < lista.length; i++) {
            opcoes=opcoes+` <option value=${lista[i].id_agente}>${lista[i].volume_transacional} - ${lista[i].nome_agente}</option>`;
        }

    document.getElementById("selUser").innerHTML=opcoes;
}


