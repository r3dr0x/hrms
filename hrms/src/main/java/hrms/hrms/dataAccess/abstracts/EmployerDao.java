package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.hrms.entities.concretes.Employer;

@Repository
public interface EmployerDao extends JpaRepository<Employer ,Integer>{
		List<Employer> findByEmailIs(String email);
}
