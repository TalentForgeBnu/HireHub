function alternarDropdown() {
    const menuDropdown = document.getElementById('menu-dropdown');
    if (menuDropdown.style.display === 'block') {
        menuDropdown.style.display = 'none';
    } else {
        menuDropdown.style.display = 'block';
    }
}

// Fecha o dropdown ao clicar fora dele
document.addEventListener('click', function (evento) {
    const menuDropdown = document.getElementById('menu-dropdown');
    const perfilIcon = document.getElementById('perfil-icon');

    // Verifica se o clique foi fora do ícone de perfil e do menu
    if (!perfilIcon.contains(evento.target) && !menuDropdown.contains(evento.target)) {
        menuDropdown.style.display = 'none';
    }
});
