package hrms.hrms.business.concrete.checkHelper;

import hrms.hrms.business.constants.Messages;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;
import java.lang.Object;


import java.util.List;

public class UserCheckHelper {
    public static Result checkLogicResults(List<Result> logicResults){
    	
        StringBuilder message = new StringBuilder();

        int errorCounter = 0;

        for (var result : logicResults){
            if (result != null){
                message.append(result.getMessage()).append(" ");
                errorCounter++;
            }
        }

        if (errorCounter > 0){
            return new ErrorResult(message.toString());
        }

        return new SuccessResult(Messages.validationSuccess);
    }
}
