package ra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.model.entity.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Integer> {
    Optional<Users> findByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
}
