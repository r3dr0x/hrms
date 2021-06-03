package hrms.hrms.business.abstracts;

import java.util.List;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.User;
import hrms.hrms.core.utilities.results.DataResult;

public interface UserService<T extends User> {
    DataResult<List<T>> getAll();
    Result add(T user);
}