package melo.guilherme.userapi.dto.converter;

import melo.guilherme.userapi.domain.User;
import melo.guilherme.userapi.dto.UserDTO;

public class DTOConverter {
    public static UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setNome(user.getNome());
        userDTO.setEndereco(user.getEndereco());
        userDTO.setCpf(user.getCpf());
        return userDTO;
    }
}
