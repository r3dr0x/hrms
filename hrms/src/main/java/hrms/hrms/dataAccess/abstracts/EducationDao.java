package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationDao extends JpaRepository<Education, Integer> {

}
