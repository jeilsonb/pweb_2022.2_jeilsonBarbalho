package br.com.jeilsonbarbalho.biritashop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jeilsonbarbalho.biritashop.model.Cliente;
import br.com.jeilsonbarbalho.biritashop.repository.ClienteRepository;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/listar")
    public ModelAndView listarClientes() {
        List<Cliente> clientes = this.clienteRepository.findAll();
        ModelAndView mav = new ModelAndView("/cliente/listarClientes");
        mav.addObject("clientes", clientes);
        return mav;
    }

    @GetMapping("/adicionar")
    public ModelAndView formAdicionarCliente() {
        ModelAndView mav = new ModelAndView("/cliente/adicionarCliente");
        mav.addObject(new Cliente());
        return mav;
    }

    @PostMapping("/adicionar")
    public String adicionarCliente(Cliente cliente) {
        this.clienteRepository.save(cliente);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView formEditarCliente(@PathVariable("id") Long id) {
        Cliente cliente = this.clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID Inválido " + id));
        ModelAndView mav = new ModelAndView("/cliente/editarCliente");
        mav.addObject(cliente);
        return mav;
    }

    @PostMapping("/editar/{id}")
    public String editarCliente(@PathVariable("id") Long id, Cliente cliente) {
        this.clienteRepository.save(cliente);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/remover/{id}")
    public ModelAndView removerCliente(@PathVariable("id") Long id) {
        Cliente cliente = this.clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID Inválido " + id));
        this.clienteRepository.delete(cliente);
        return new ModelAndView("redirect:/cliente/listar");
    }
}