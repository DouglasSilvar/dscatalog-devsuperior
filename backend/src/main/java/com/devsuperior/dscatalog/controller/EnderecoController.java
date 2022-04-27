package com.devsuperior.dscatalog.controller;


import com.devsuperior.dscatalog.dto.EnderecoDTO;
import com.devsuperior.dscatalog.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {

    @Autowired
    EnderecoService service;
    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> findAll() {
        List<EnderecoDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @CrossOrigin
    @PostMapping
    public ResponseEntity<EnderecoDTO> insert(@Valid @RequestBody EnderecoDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EnderecoDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin
    @PutMapping(value = "/{id}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable Long id,@RequestBody EnderecoDTO dto){
        dto = service.update(id,dto);
        return ResponseEntity.ok().body(dto);
    }
}
