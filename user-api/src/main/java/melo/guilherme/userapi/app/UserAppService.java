package melo.guilherme.userapi.app;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import melo.guilherme.userapi.domain.User;
import melo.guilherme.userapi.dto.UserDTO;
import melo.guilherme.userapi.repository.UserRepository;

@Service
public class UserAppService {

    private final UserRepository userRepository;

    public UserAppService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAll() {
        return userRepository.findAll()
            .stream()
            .map(UserDTO::from)
            .collect(Collectors.toList());
    }

    public UserDTO findById(long userId) {
        return userRepository.findById(userId).map(UserDTO::from).orElseThrow(User.UserNotFoundException::new);
    }

    public Long save(UserDTO userDTO) {

        User user = User.builder()
            .nome(userDTO.getNome())
            .cpf(userDTO.getCpf())
            .endereco(userDTO.getEndereco())
            .email(userDTO.getEmail())
            .telefone(userDTO.getTelefone())
            .dataCadastro(userDTO.getDataCadastro())
            .build();

        userRepository.save(user);

        return user.getId();
    }

    public void delete(long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        userRepository.delete(user);
    }

    public UserDTO findByCpf(String cpf, String key) {
        return Optional.ofNullable(userRepository.findByCpfAndKey(cpf, key)).map(UserDTO::from)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public List<UserDTO> queryByName(String name) {
        return userRepository.findByNomeLike(name)
            .stream()
            .map(UserDTO::from)
            .collect(Collectors.toList());
    }
}
