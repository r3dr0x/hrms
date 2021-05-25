package hrms.hrms.business.concrete.checkHelper;

import hrms.hrms.entities.concretes.Employer;

public class EmployerCheckHelper {
	public static boolean allFieldsAreRequired(Employer employer){
        
		if(employer.getEmail().strip().isEmpty()
				|| employer.getPassword().strip().isEmpty()
				|| employer.getCompanyName().strip().isEmpty()
				|| employer.getPhoneNumber().strip().isEmpty()
				|| employer.getWebAddress().strip().isEmpty())
        {
            return false;
        }
        return true;
    }
}
