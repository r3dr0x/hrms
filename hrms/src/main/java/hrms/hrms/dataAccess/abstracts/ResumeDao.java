package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeDao extends JpaRepository<Resume, Integer> {

}
