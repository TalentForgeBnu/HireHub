var currentTab = 0;
showTab(currentTab);

function showTab(n) {
    var tabs = document.getElementsByClassName("tab");

    for (var i = 0; i < tabs.length; i++) {
        tabs[i].style.display = "none";
    }
    tabs[n].style.display = "flex";

    if (n === 0) {
        document.getElementById("voltar").style.visibility = "hidden";
    } else {
        document.getElementById("voltar").style.visibility = "visible";
    }

    if (n === (tabs.length - 1)) {
        document.getElementById("proximo").type = "submit";
        document.getElementById("proximo").innerHTML = "Enviar";
    } else {
        document.getElementById("proximo").type = "button";
        document.getElementById("proximo").innerHTML = "Próximo";
    }
}

document.getElementById("proximo").onclick = function() { onclickProximo(currentTab); };
document.getElementById("voltar").onclick = function() { onclickVoltar(currentTab); };

function onclickProximo(n) {
    var tabs = document.getElementsByClassName("tab");

    if (n === (tabs.length - 1)) {
        return;
    }

    currentTab++;
    showTab(currentTab);
}

function onclickVoltar(n) {
    if (n === 0) {
        return;
    }

    currentTab--;
    showTab(currentTab);
}