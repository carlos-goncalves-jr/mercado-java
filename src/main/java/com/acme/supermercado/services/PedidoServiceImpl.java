package com.acme.supermercado.services;

import com.acme.supermercado.dtos.PedidoDTO;
import com.acme.supermercado.dtos.TotalDTO;
import com.acme.supermercado.entities.Carrinho;
import com.acme.supermercado.entities.Produto;
import com.acme.supermercado.exceptions.IdNotFoundException;
import com.acme.supermercado.repositories.CarrinhoRepository;
import com.acme.supermercado.repositories.ProdutoRepository;
import com.acme.supermercado.services.interfaces.PedidoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PedidoServiceImpl implements PedidoInterface {

    @Autowired
    private final CarrinhoRepository carrinhoRepository;

    @Autowired
    private final ProdutoRepository produtoRepository;

    @Autowired
    public PedidoServiceImpl(CarrinhoRepository carrinhoRepository, ProdutoRepository produtoRepository) {
        this.carrinhoRepository = carrinhoRepository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public TotalDTO resumoPedido(Long idCarrinho) {
        Carrinho carrinho = carrinhoRepository.findById(idCarrinho).
                orElseThrow(() -> new IdNotFoundException("ID NAO ENCONTRADO : " + idCarrinho));
        List<PedidoDTO> listaPedidos = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : carrinho.getMapDeProdutos().entrySet()) {
            Produto produto = produtoRepository.findByNome(entry.getKey()).get();
            Integer quantidade = entry.getValue();
            listaPedidos.add(new PedidoDTO(produto, quantidade, produto.getValor() * quantidade));
        }
        Integer valorTotal = 0;
        for(PedidoDTO pedidos : listaPedidos) {
            valorTotal += pedidos.valor();
        }

        return new TotalDTO(listaPedidos, valorTotal);
    }

    @Override
    public Double encerrarPedido(Long idCarrinho) {
        return null;
    }
}
