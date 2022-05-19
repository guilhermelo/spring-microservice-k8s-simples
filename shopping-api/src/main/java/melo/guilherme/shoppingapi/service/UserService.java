package melo.guilherme.shoppingapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import melo.guilherme.shoppingapi.dto.converter.UserDTO;

@Service
public class UserService {

    @Value("${USER_API_URL:http://localhost:8081/product/}")
    private String urlUser;

    public UserDTO getUserByCpf(String cpf, String key) {
        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlUser + cpf);
        builder.queryParam("key", key);

        ResponseEntity<UserDTO> response = restTemplate.getForEntity(builder.toUriString(), UserDTO.class);
        return response.getBody();
    }
}

