package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateDao extends UserDao<Candidate> {
    boolean existsByIdentityNumber(String identityNumber);
}
