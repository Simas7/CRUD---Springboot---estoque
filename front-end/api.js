fetch('http://localhost:5051/main')
    .then(response => response.json())
    .then(data => {
        console.log('Lista de Estoques:', data);
    })
    .catch(error => console.error('Erro na requisição:', error));

    function enviarRequisicao(url, metodo, dados) {
      return fetch(url, {
          method: metodo,
          headers: {
              'Content-Type': 'application/json',
          },
          body: JSON.stringify(dados),
      })
      .then(response => response.json());
  }  