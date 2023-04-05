package br.com.jeilsonbarbalho.cadpessoas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jeilsonbarbalho.cadpessoas.model.Pessoa;
import br.com.jeilsonbarbalho.cadpessoas.repositories.PessoaRepository;

@Controller
@RequestMapping("/")
public class PessoaController {
    
    @Autowired
    PessoaRepository pessoaRepo;
    public PessoaController(PessoaRepository pessoaRepo) {
        this.pessoaRepo = pessoaRepo;
    }

    //raiz do site localhost:8080/
    @GetMapping
    public String index(){
        return "index.html";
    }

    @GetMapping("/listarPessoa")
    public ModelAndView listarPessoa(){
        List<Pessoa> todasAsPessoas = pessoaRepo.findAll();
        ModelAndView modelAndView = new ModelAndView("listarPessoa");
        modelAndView.addObject("todasAsPessoas", todasAsPessoas);
        return modelAndView;
    }

    @GetMapping("/adicionarPessoa")
    public ModelAndView formularioAdicionarPessoa(){
        ModelAndView modelAndView = new ModelAndView("adicionarPessoa");
        modelAndView.addObject(new Pessoa());
        return modelAndView;
    }

    @PostMapping("/adicionarPessoa")
    public String adicionarPessoa(Pessoa p){
        this.pessoaRepo.save(p);
        return "redirect:/listarPessoa";
    }

    @GetMapping("/remover/{id}")
    public ModelAndView removerPessoa(@PathVariable("id") long id){
        Pessoa aRemover = pessoaRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido" + id));
        pessoaRepo.delete(aRemover);
        return new ModelAndView("redirect:/listarPessoa");
    }

    @GetMapping("/editar/{id}")
    public ModelAndView formularioEditarPessoa(@PathVariable("id") long id){
        Pessoa aEditar = pessoaRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido" + id));
        ModelAndView modelAndView = new ModelAndView("editarPessoa");
        modelAndView.addObject(aEditar);
        return modelAndView;
    }

    @PostMapping("/editar/{id}")
    public String editarPessoa(@PathVariable("id") long id, Pessoa p){
        this.pessoaRepo.save(p);
        return "redirect:/listarPessoa";
    }


}
