package lambda.behavior_impl;

import lambda.behavior.UserPredicate;
import lambda.domain.Role;
import lambda.domain.User;

public class UserRolePredicateImpl implements UserPredicate {
    @Override
    public boolean test(User user) {
        return user.getRole().equals(Role.USER);
    }
}
