package webddapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webddapp.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
