document.addEventListener('DOMContentLoaded', () => {
    const sections = document.querySelectorAll('.formulario > form > div'); // Todas as seções do formulário
    const nextButton = document.querySelector('.proximo'); // Botão "Próximo"
    const backButton = document.querySelector('.voltar'); // Botão "Voltar"
    let currentSectionClass = 'formulario-principal'; // Classe da seção atual (inicia com "formulario-principal")

    // Função que atualiza a visibilidade das seções
    const updateSections = () => {
        console.log('Atualizando seções, classe atual:', currentSectionClass); // Para debugar

        sections.forEach((section) => {
            if (section.classList.contains(currentSectionClass)) {
                section.style.display = 'flex'; // Exibe a seção atual
                section.style.flexDirection = 'column'; // Garante que os filhos fiquem empilhados
            } else {
                section.style.display = 'none'; // Esconde as seções que não são a atual
            }
        });

        // Mostrar/ocultar os botões dependendo da classe atual
        backButton.style.display = currentSectionClass === 'formulario-principal' ? 'none' : 'flex'; // Não mostra o botão "Voltar" na primeira seção
        nextButton.style.display = currentSectionClass === 'formulario-terciario' ? 'none' : 'flex'; // Não mostra o botão "Próximo" na última seção
    };

    // Ação do botão "Próximo"
    nextButton.addEventListener('click', () => {
        if (currentSectionClass === 'formulario-principal') {
            currentSectionClass = 'formulario-secundario'; // Move para a próxima seção
        } else if (currentSectionClass === 'formulario-secundario') {
            currentSectionClass = 'formulario-terciario'; // Move para a próxima seção
        }
        updateSections(); // Atualiza a visibilidade das seções
    });

    // Ação do botão "Voltar"
    backButton.addEventListener('click', () => {
        if (currentSectionClass === 'formulario-secundario') {
            currentSectionClass = 'formulario-principal'; // Volta para a seção anterior
        } else if (currentSectionClass === 'formulario-terciario') {
            currentSectionClass = 'formulario-secundario'; // Volta para a seção anterior
        }
        updateSections(); // Atualiza a visibilidade das seções
    });

    // Inicializa a visualização das seções
    updateSections();
});