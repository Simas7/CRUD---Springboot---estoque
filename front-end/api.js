function dados() {
    fetch('http://localhost:5051/main') 
      .then(response => response.json()) 
      .then(cautelas => {
        console.log(cautelas)
      })
      .catch(error => console.error('Erro ao buscar dados:', error));
  } 

  console.log(dados())   