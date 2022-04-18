package lambda.behavior;

import lambda.domain.User;

public interface UserPredicate {
    boolean test(User user);
}
