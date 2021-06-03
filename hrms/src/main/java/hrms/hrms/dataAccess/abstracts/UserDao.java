package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao<T extends User> extends JpaRepository<T, Integer> {
    boolean existsByEmail(String email);
}