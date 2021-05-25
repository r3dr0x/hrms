package hrms.hrms.business.concrete.checkHelper;

import hrms.hrms.entities.concretes.Candidate;

public class CandidateCheckHelper {
    public static boolean allFieldsAreRequired(Candidate candidate){
    	if (candidate.getEmail().strip().isEmpty()
                || candidate.getPassword().strip().isEmpty()
                || candidate.getFirstName().strip().isEmpty()
                || candidate.getLastName().strip().isEmpty()
                || candidate.getIdentityNumber().strip().isEmpty()
                || candidate.getDateOfBirth().toString().strip().isEmpty())
        {
            return false;
        }
        return true;
    }
}
