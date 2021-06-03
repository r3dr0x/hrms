package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerDao extends UserDao<Employer> {

}
