package chap02.behavior_impl;

import chap02.behavior.UserPredicate;
import chap02.domain.User;

public class UserAgePredicateImpl implements UserPredicate {
    @Override
    public boolean test(User user) {
        return user.getAge() >= 15;
    }
}
