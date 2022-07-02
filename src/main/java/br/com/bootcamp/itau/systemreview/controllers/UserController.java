package br.com.bootcamp.itau.systemreview.controllers;

import br.com.bootcamp.itau.systemreview.dtos.UserDTO;
import br.com.bootcamp.itau.systemreview.dtos.UserInsertDTO;
import br.com.bootcamp.itau.systemreview.services.UserService;
import br.com.bootcamp.itau.systemreview.services.exceptions.CpfException;
import br.com.bootcamp.itau.systemreview.services.validations.CpfValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable) {

        Page<UserDTO> list = userService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserInsertDTO dto) {

        CpfValid cpfValid = new CpfValid(dto.getCpf());

        if (cpfValid.validation()) {
            System.out.println("CPF is valid");
        } else {
            throw new CpfException("Please type a valid CPF");
        }

        UserDTO newDto = userService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
