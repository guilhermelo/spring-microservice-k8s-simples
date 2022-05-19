package melo.guilherme.userapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import melo.guilherme.userapi.app.UserAppService;
import melo.guilherme.userapi.dto.UserDTO;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserAppService service;

    public UserController(final UserAppService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    UserDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/cpf/{cpf}")
    public UserDTO getUsersFiltro(@PathVariable String cpf, @RequestParam(name = "key", required = true) String key) {
        return service.findByCpf(cpf, key);
    }

    @PostMapping
    UserDTO inserir(@RequestBody UserDTO userDTO) {

        service.save(userDTO);

        return userDTO;
    }

    @DeleteMapping("/{id}")
    public boolean remover(@PathVariable Long id) {
        service.delete(id);
        return true;
    }

    @GetMapping("/user/search")
    public List<UserDTO> queryByName(@RequestParam(name="nome", required = true) String nome) {
        return service.queryByName(nome);
    }

}

