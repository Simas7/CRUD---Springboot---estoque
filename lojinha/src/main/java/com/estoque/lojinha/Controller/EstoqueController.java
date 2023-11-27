package com.estoque.lojinha.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estoque.lojinha.Model.Estoque;
import com.estoque.lojinha.Repository.EstoqueRepository;

@CrossOrigin("http://127.0.0.1:5500")
@RestController
@RequestMapping("/main")
public class EstoqueController {
    @Autowired
    private EstoqueRepository repositorio;

    @GetMapping
    public List<Estoque> listar() {
        return repositorio.findAll();
    }

    @PostMapping
    public Estoque adicionar(@RequestBody Estoque estoque){
        return repositorio.save(estoque);
    }

    @PutMapping
    public Estoque editar(@RequestBody Estoque estoque){
        if(estoque.getId()>0)
            return repositorio.save(estoque);
        return null;
    }

  @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id){
        repositorio.deleteById(id);
        return "removido com sucesso";
    }
}
