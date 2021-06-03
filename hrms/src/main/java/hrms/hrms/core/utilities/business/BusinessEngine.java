package hrms.hrms.core.utilities.business;

import hrms.hrms.core.utilities.results.Result;

public class BusinessEngine {
    public static Result run(Result ...logics){
        for (Result logic : logics){
            if (!logic.isSuccess()){
                return logic;
            }
        }

        return null;
    }
}
