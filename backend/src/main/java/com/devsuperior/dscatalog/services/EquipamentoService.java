package com.devsuperior.dscatalog.services;


import com.devsuperior.dscatalog.dto.EquipamentoDTO;
import com.devsuperior.dscatalog.entities.Equipamento;
import com.devsuperior.dscatalog.repositories.EquipamentoRepository;
import com.devsuperior.dscatalog.services.exceptions.DataBaseException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipamentoService {


    @Autowired
    private EquipamentoRepository repository;

    public List<EquipamentoDTO> findAll() {
        List<Equipamento> list = repository.findAll(Sort.by("nome"));
        return list.stream().map( x -> new EquipamentoDTO(x)).collect(Collectors.toList());

    }

    @Transactional
    public EquipamentoDTO insert(EquipamentoDTO dto) {
        Equipamento entity = new Equipamento();
        entity.setNome(dto.getNome());
        entity.setValorDaCompra(dto.getValorDaCompra());
        entity.setValorAluguelDia(dto.getValorAluguelDia());
        entity.setValorAluguelQuinzena(dto.getValorAluguelQuinzena());
        entity.setValorAluguelMes(dto.getValorAluguelMes());
        entity = repository.save(entity);
        return new EquipamentoDTO(entity);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id not found " + id);
        }catch(DataIntegrityViolationException e){
            throw new DataBaseException("Integrity violation");
        }
    }
    public EquipamentoDTO update(Long id, EquipamentoDTO dto) {
        try {
            Equipamento entity = repository.getOne(id);
            entity.setNome(dto.getNome());
            entity.setValorAluguelDia(dto.getValorAluguelDia());
            entity.setValorAluguelQuinzena(dto.getValorAluguelQuinzena());
            entity.setValorAluguelMes(dto.getValorAluguelMes());
            entity.setValorDaCompra(dto.getValorDaCompra());
            entity = repository.save(entity);
            return new EquipamentoDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found "+ id);
        }

    }
}
