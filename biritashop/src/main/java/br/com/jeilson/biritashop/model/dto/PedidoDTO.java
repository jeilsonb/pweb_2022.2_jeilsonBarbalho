package br.com.jeilson.biritashop.model.dto;

import java.util.List;

import br.com.jeilson.biritashop.model.Cliente;
import br.com.jeilson.biritashop.model.enums.FormaPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PedidoDTO {
    
    private Cliente cliente;
    private List<ItemPedidoDTO> itens;
    private FormaPagamento formaPagamento;
}