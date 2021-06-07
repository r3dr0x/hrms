package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {

}