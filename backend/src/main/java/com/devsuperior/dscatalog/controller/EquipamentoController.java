package com.devsuperior.dscatalog.controller;

import com.devsuperior.dscatalog.dto.EquipamentoDTO;
import com.devsuperior.dscatalog.services.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/equipamentos")
public class EquipamentoController {

    @Autowired
    EquipamentoService service;
    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<EquipamentoDTO>> findAll() {
        List<EquipamentoDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @CrossOrigin
    @PostMapping
    public ResponseEntity<EquipamentoDTO> insert(@Valid @RequestBody EquipamentoDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EquipamentoDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin
    @PutMapping(value = "/{id}")
    public ResponseEntity<EquipamentoDTO> update(@PathVariable Long id, @RequestBody EquipamentoDTO dto){
        dto = service.update(id,dto);
        return ResponseEntity.ok().body(dto);
    }
}
