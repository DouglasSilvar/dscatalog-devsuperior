package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.AluguelDTO;
import com.devsuperior.dscatalog.dto.EnderecoDTO;
import com.devsuperior.dscatalog.entities.Aluguel;
import com.devsuperior.dscatalog.entities.Endereco;
import com.devsuperior.dscatalog.repositories.AluguelRepository;
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
public class AluguelService {

    @Autowired
    private AluguelRepository repository;

    public List<AluguelDTO> findAll() {
        List<Aluguel> list = repository.findAll(Sort.by("id"));
        return list.stream().map( x -> new AluguelDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public AluguelDTO insert(AluguelDTO dto) {
        Aluguel entity = new Aluguel();
        entity.setCliente(dto.getCliente());
        entity.setDataInicio(dto.getDataInicio());
        entity.setDataTermino(dto.getDataTermino());
        entity.setValorDoContrato(dto.getValorDoContrato());
        entity.setEquipamento(dto.getEquipamento());
        entity.setEndereco(dto.getEndereco());
        entity = repository.save(entity);
        return new AluguelDTO(entity);
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

    public AluguelDTO update(Long id, AluguelDTO dto) {
        try {
            Aluguel entity = repository.getOne(id);
            entity.setEquipamento(dto.getEquipamento());
            entity.setEndereco(dto.getEndereco());
            entity.setCliente(dto.getCliente());
            entity.setDataInicio(dto.getDataInicio());
            entity.setDataTermino(dto.getDataTermino());
            entity.setValorDoContrato(dto.getValorDoContrato());
            entity = repository.save(entity);
            return new AluguelDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found "+ id);
        }
    }
}
