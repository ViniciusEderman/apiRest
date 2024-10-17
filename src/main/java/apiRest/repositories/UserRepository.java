package apiRest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import apiRest.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
