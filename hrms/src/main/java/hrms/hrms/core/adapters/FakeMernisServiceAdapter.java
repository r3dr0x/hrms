package hrms.hrms.core.adapters;

import java.time.LocalDate;

import org.springframework.stereotype.Service;


@Service
public class FakeMernisServiceAdapter implements UserCheckService {
    @Override
    public Boolean checkIfRealPerson(String nationalityId, String firstName, String lastName, LocalDate dateOfBirthYear) {
        return true;
    }
}
