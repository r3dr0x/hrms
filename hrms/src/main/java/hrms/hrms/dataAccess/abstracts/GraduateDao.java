package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.Graduate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraduateDao extends JpaRepository<Graduate, Integer> {
    boolean existsByDescription(String description);
}
