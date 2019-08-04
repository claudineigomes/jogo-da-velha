var letra;
var idServer;
letra = "X";

function joga(celula) {
    console.log(celula)
    console.log(idServer)
    console.log(letra)
    var res = celula.split("cel")[1];
    var x = res.charAt(0);
    var y = res.charAt(1);
    console.log(x, y);

    var person = {
        id: idServer,
        player: letra,
        position: {
            x: x,
            y: y
        }
    }

    console.log(JSON.stringify(person))

    $.ajax({
        url: '/game/' + idServer + '/movement',
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            console.log(data)
        },
        data: JSON.stringify(person)
    });

    var celulaclicada = document.getElementById(celula).innerHTML;
    if (celulaclicada == "X" || celulaclicada == "O") {
        alert("Opa, este quadrado já foi escolhido!");
    } else {
        document.getElementById(celula).innerHTML = letra;
        if (letra == "X") {
            letra = "Y";
        } else {
            letra = "X";
        }
    }
}

function verif() {
    var c11 = document.getElementById('cel00').innerHTML;
    var c12 = document.getElementById('cel01').innerHTML;
    var c13 = document.getElementById('cel02').innerHTML;
    var c21 = document.getElementById('cel10').innerHTML;
    var c22 = document.getElementById('cel11').innerHTML;
    var c23 = document.getElementById('cel12').innerHTML;
    var c31 = document.getElementById('cel20').innerHTML;
    var c32 = document.getElementById('cel21').innerHTML;
    var c33 = document.getElementById('cel22').innerHTML;
    if (((c11 != '') && (c12 != '') && (c13 != '') && (c11 == c12) && (c12 == c13)) || ((c11 != '') && (c22 != '') && (c33 != '') && (c11 == c22) && (c22 == c33)) || ((c11 != '') && (c21 != '') && (c31 != '') && (c11 == c21) && (c21 == c31)) || ((c21 != '') && (c22 != '') && (c23 != '') && (c21 == c22) && (c22 == c23)) || ((c31 != '') && (c32 != '') && (c33 != '') && (c31 == c32) && (c32 == c33)) || ((c12 != '') && (c22 != '') && (c32 != '') && (c12 == c22) && (c22 == c32)) || ((c13 != '') && (c23 != '') && (c33 != '') && (c13 == c23) && (c23 == c33)) || ((c31 != '') && (c22 != '') && (c13 != '') && (c31 == c22) && (c22 == c13))) {
        alert('Você ganhou! Parabéns campeão!');
    }
}

function novo() {
    for (i=0; i<3; i++){
        for (j=0; j<3; j++){
            nomecelula = 'cel' + i + j
            console.log(nomecelula)
            document.getElementById(nomecelula).innerHTML = '';

        }
    }
    $.ajax({
        url: '/game',
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            // console.log(data)
            idServer = data.id;
            letra = data.firstPlayer;
        }
    });
}

document.addEventListener('DOMContentLoaded', function() {
    novo();
}, false);
