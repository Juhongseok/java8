package chap02.behavior_impl;

import chap02.behavior.UserPredicate;
import chap02.domain.Role;
import chap02.domain.User;

public class UserRolePredicateImpl implements UserPredicate {
    @Override
    public boolean test(User user) {
        return user.getRole().equals(Role.USER);
    }
}
