function enviarFormulario() {
    // Obter valores do formulário
    const codigo = document.getElementById('codigo').value;
    const nome = document.getElementById('nome').value;
    const preco = document.getElementById('preco').value;
    const quantidade = document.getElementById('quantidade').value;

    // Criar objeto com os dados do estoque
    const estoqueData = {
        codigo: parseInt(codigo),
        nome: nome,
        preço: parseFloat(preco),
        quantidade: parseInt(quantidade),
    };

    // Enviar requisição POST usando a função definida em api.js
    enviarRequisicao('http://localhost:5051/main', 'POST', estoqueData)
        .then(data => {
            console.log('Estoque adicionado:', data);
            // Realizar ações após adicionar o estoque, se necessário
        })
        .catch(error => console.error('Erro na requisição:', error));

        // function redirecionar(){
        //     window.location.href = './Lista.html'
        // }
    }
    
