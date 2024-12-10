var currentTab = 0;
showTab(currentTab);

function showTab(n) {
    var tabs = document.getElementsByClassName("curso");

    for (var i = 0; i < tabs.length; i++) {
        tabs[i].style.display = "none";
    }

    for (var i = n; i < n + 3 && i < tabs.length; i++) {
        tabs[i].style.display = "flex";
    }

    if (n === 0) {
        document.getElementById("voltar").disabled = true;
    } else {
        document.getElementById("voltar").disabled = false;
    } 

    if (n + 3 < tabs.length) {
        document.getElementById("proximo").disabled = false;
    } else {
        document.getElementById("proximo").disabled = true;
    } 

}

document.getElementById("proximo").onclick = function() { onclickProximo(currentTab); };
document.getElementById("voltar").onclick = function() { onclickVoltar(currentTab); };

function onclickProximo(n) {
    var tabs = document.getElementsByClassName("tab");

    if (n === (tabs.length - 1)) {
        return;
    }

    currentTab+=3;
    showTab(currentTab);
}

function onclickVoltar(n) {
    if (n === 0) {
        return;
    }

    currentTab-=3;
    showTab(currentTab);
}
