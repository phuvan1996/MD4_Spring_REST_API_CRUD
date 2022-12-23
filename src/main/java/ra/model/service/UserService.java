package ra.model.service;

import ra.model.entity.Users;

import java.util.Optional;

public interface UserService {
    Optional<Users> findByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
    Users saveOrUpdate(Users user);
}
