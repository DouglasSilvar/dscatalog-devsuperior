package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.ClienteDTO;
import com.devsuperior.dscatalog.dto.EnderecoDTO;
import com.devsuperior.dscatalog.entities.Cliente;
import com.devsuperior.dscatalog.entities.Endereco;
import com.devsuperior.dscatalog.repositories.ClienteRepository;
import com.devsuperior.dscatalog.repositories.EnderecoRepository;
import com.devsuperior.dscatalog.services.exceptions.DataBaseException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public List<EnderecoDTO> findAll() {
        List<Endereco> list = repository.findAll(Sort.by("id"));
        return list.stream().map( x -> new EnderecoDTO(x)).collect(Collectors.toList());

    }

    @Transactional
    public EnderecoDTO insert(EnderecoDTO dto) {
        Endereco entity = new Endereco();
        entity.setId(dto.getId());
        entity.setCep(dto.getCep());
        entity.setLogradouro(dto.getLogradouro());
        entity.setLocalidade(dto.getLocalidade());
        entity.setNumero(dto.getNumero());
        entity.setBairro(dto.getBairro());
        entity.setUf(dto.getUf());

        entity = repository.save(entity);
        return new EnderecoDTO(entity);
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
}
