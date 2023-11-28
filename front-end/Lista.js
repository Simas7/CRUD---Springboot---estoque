// Função para fazer uma requisição GET para o backend e preencher a tabela
function carregarTabelaEstoques() {
    fetch('http://localhost:5051/main')
        .then(response => response.json())
        .then(data => {
            const tabela = document.getElementById('tabelaEstoques');
            const tbody = tabela.getElementsByTagName('tbody')[0];

            // Limpar o corpo da tabela antes de adicionar os novos itens
            tbody.innerHTML = "";

            // Adicionar cada item da lista como uma linha na tabela
            data.forEach(estoque => {
                const row = tbody.insertRow();
                row.insertCell(0).textContent = estoque.nome;
                row.insertCell(1).textContent = estoque.codigo;
                row.insertCell(2).textContent = estoque.preço;
                row.insertCell(3).textContent = estoque.quantidade;

                // Adicionar botão de editar
                const editCell = row.insertCell(4);
                const editButton = document.createElement('button');
                editButton.className = 'edit-button';
                editButton.textContent = 'Editar';
                editButton.onclick = () => editarQuantidade(estoque);
                editCell.appendChild(editButton);
            });
        })
        .catch(error => console.error('Erro na requisição:', error));
}

// Função para editar a quantidade
function editarQuantidade(estoque) {
    const novaQuantidade = prompt('Informe a nova quantidade:');
    if (novaQuantidade !== null && !isNaN(novaQuantidade)) {
        const novoEstoque = { ...estoque, quantidade: parseInt(novaQuantidade) };
        salvarAlteracoes(novoEstoque);
    } else {
        alert('Quantidade inválida. Alteração cancelada.');
    }
}

// Função para fazer uma requisição PUT para salvar as alterações
function salvarAlteracoes(estoque) {
    fetch(`http://localhost:5051/main`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(estoque),
    })
    .then(response => response.json())
    .then(data => {
        console.log('Alterações salvas:', data);
        if (data.quantidade === 0) {
            excluirProduto(data.id);
        } else {
            carregarTabelaEstoques(); // Recarregar a tabela após a alteração
        }
    })
    .catch(error => console.error('Erro ao salvar as alterações:', error));
}

// Função para excluir um produto do banco de dados
function excluirProduto(id) {
fetch(`http://localhost:5051/main/${id}`, {
    method: 'DELETE',
})
.then(response => {
    if (!response.ok) {
        throw new Error(`Erro ao excluir o produto: ${response.status} - ${response.statusText}`);
    }
    return response.text(); // Retornar o texto da resposta
})
.then(data => {
    console.log('Produto excluído:', data);
    carregarTabelaEstoques(); // Recarregar a tabela após a exclusão
})
.catch(error => console.error(error));
}


// Chamar a função para carregar a tabela quando a página carregar
window.onload = carregarTabelaEstoques;