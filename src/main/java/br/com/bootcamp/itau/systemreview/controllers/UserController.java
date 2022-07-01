package br.com.bootcamp.itau.systemreview.controllers;

import br.com.bootcamp.itau.systemreview.dtos.UserDTO;
import br.com.bootcamp.itau.systemreview.dtos.UserInsertDTO;
import br.com.bootcamp.itau.systemreview.services.UserService;
import br.com.bootcamp.itau.systemreview.services.exceptions.CpfException;
import br.com.bootcamp.itau.systemreview.services.validations.CpfValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

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
}
