package melo.guilherme.userapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import melo.guilherme.userapi.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByCpfAndKey(String cpf, String key);

    List<User> findByNomeLike(String name);
}
