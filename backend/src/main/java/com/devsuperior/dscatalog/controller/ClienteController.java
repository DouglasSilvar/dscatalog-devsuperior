package com.devsuperior.dscatalog.controller;

import com.devsuperior.dscatalog.dto.ClienteDTO;
import com.devsuperior.dscatalog.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    ClienteService service;
    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<ClienteDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @CrossOrigin
    @PostMapping
    public ResponseEntity<ClienteDTO> insert(@Valid @RequestBody ClienteDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin
    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteDTO dto){
        dto = service.update(id,dto);
        return ResponseEntity.ok().body(dto);
    }
}
