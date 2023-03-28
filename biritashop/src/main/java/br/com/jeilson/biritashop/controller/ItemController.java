package br.com.jeilson.biritashop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jeilson.biritashop.model.ItemPedido;
import br.com.jeilson.biritashop.model.Produto;
import br.com.jeilson.biritashop.repository.ItemRepository;
import br.com.jeilson.biritashop.repository.ProdutoRepository;

@Controller
@RequestMapping("/item")
public class ItemController {
    
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProdutoRepository produtoRepository;
    
    @GetMapping("/adicionar/{pedidoId}")
    public ModelAndView formAdicionarItem(@PathVariable("pedidoId") Long pedidoId) {
        List<Produto> produtos = this.produtoRepository.findAll();
        ModelAndView mav = new ModelAndView("/item/adicionarItem");
        mav.addObject("produtos", produtos);
        mav.addObject(new ItemPedido());
        return mav;
    }

    @PostMapping("/adicionar")
    public String adicionarItem(ItemPedido itemPedido) {
        this.itemRepository.save(itemPedido);
        return "redirect:/item/adicionar/" + itemPedido.getPedido().getId();
    }
}