package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageDao extends JpaRepository<Language, Integer> {

}
