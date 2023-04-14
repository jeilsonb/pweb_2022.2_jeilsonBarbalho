package br.com.jeilsonbarbalho.biritashop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.jeilsonbarbalho.biritashop.model.Cliente;
import br.com.jeilsonbarbalho.biritashop.model.Pedido;
import br.com.jeilsonbarbalho.biritashop.repository.ClienteRepository;
import br.com.jeilsonbarbalho.biritashop.repository.PedidoRepository;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
    
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/listar")
    public ModelAndView listarPedidos(@RequestParam(value = "clienteId", required = false) Long clienteId) {
        List<Cliente> clientes = this.clienteRepository.findAll();
        List<Pedido> pedidos = this.pedidoRepository.findByCliente_Id(clienteId);
        ModelAndView mav = new ModelAndView("/pedido/listarPedidos");
        mav.addObject("clientes", clientes);
        mav.addObject("clienteId", clienteId);
        mav.addObject("pedidos", pedidos);
        return mav;
    }

    @GetMapping("/adicionar")
    public ModelAndView formAdicionarPedido() {
        List<Cliente> clientes = this.clienteRepository.findAll();
        ModelAndView mav = new ModelAndView("/pedido/adicionarPedido");
        mav.addObject("clientes", clientes);
        mav.addObject(new Pedido());
        return mav;
    }

    @PostMapping("/adicionar")
    public String adicionarPedido(Pedido pedido) {
        this.pedidoRepository.save(pedido);
        return "redirect:/pedido/listar";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView formEditarpedido(@PathVariable("id") Long id) {
        Pedido pedido = this.pedidoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID Inválido " + id));
        List<Cliente> clientes = this.clienteRepository.findAll();
        ModelAndView mav = new ModelAndView("/pedido/editarPedido");
        mav.addObject("clientes", clientes);
        mav.addObject(pedido);
        return mav;
    }

    @PostMapping("/editar/{id}")
    public String editarPedido(@PathVariable("id") Long id, Pedido pedido) {
        this.pedidoRepository.save(pedido);
        return "redirect:/pedido/listar";
    }

    @GetMapping("/remover/{id}")
    public ModelAndView removerPedido(@PathVariable("id") Long id) {
        Pedido pedido = this.pedidoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID Inválido " + id));
        this.pedidoRepository.delete(pedido);
        return new ModelAndView("redirect:/pedido/listar");
    }
}
