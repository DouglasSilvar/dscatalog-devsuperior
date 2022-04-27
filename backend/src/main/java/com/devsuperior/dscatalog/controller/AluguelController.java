package com.devsuperior.dscatalog.controller;


import com.devsuperior.dscatalog.dto.AluguelDTO;
import com.devsuperior.dscatalog.services.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/alugueis")
public class AluguelController {

    @Autowired
    AluguelService service;
    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<AluguelDTO>> findAll() {
        var list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @CrossOrigin
    @PostMapping
    public ResponseEntity<AluguelDTO> insert(@Valid @RequestBody AluguelDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AluguelDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin
    @PutMapping(value = "/{id}")
    public ResponseEntity<AluguelDTO> update(@PathVariable Long id, @RequestBody AluguelDTO dto){
        dto = service.update(id,dto);
        return ResponseEntity.ok().body(dto);
    }
}
