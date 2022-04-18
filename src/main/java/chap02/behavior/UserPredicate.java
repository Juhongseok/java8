package chap02.behavior;

import chap02.domain.User;

public interface UserPredicate {
    boolean test(User user);
}
