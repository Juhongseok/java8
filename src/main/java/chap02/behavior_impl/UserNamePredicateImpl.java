package chap02.behavior_impl;

import chap02.behavior.UserPredicate;
import chap02.domain.User;

public class UserNamePredicateImpl implements UserPredicate {
    @Override
    public boolean test(User user) {
        return user.getName().equals("userB");
    }
}
