package br.com.zup.esportcenter.controllers;

import br.com.zup.esportcenter.dtos.CompraDTO;
import br.com.zup.esportcenter.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {
    @Autowired
    private CompraService compraService;

    // Método para cadastrar compras
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompraDTO cadastrarCompras(@RequestBody CompraDTO compraDTO) {
        return compraService.cadastrarCompras(compraDTO);
    }
    // Método para listar compras
    @GetMapping
    public List<CompraDTO> buscarComprasCadastrados() {
        return compraService.mostrarCompras();
    }
}
