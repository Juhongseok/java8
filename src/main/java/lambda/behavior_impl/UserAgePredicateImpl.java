package lambda.behavior_impl;

import lambda.behavior.UserPredicate;
import lambda.domain.User;

public class UserAgePredicateImpl implements UserPredicate {
    @Override
    public boolean test(User user) {
        return user.getAge() >= 15;
    }
}
