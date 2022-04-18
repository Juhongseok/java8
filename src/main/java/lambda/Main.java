package lambda;

import lambda.behavior.UserPredicate;
import lambda.behavior_impl.UserAgePredicateImpl;
import lambda.behavior_impl.UserNamePredicateImpl;
import lambda.behavior_impl.UserRolePredicateImpl;
import lambda.domain.Role;
import lambda.domain.User;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    private static List<User> users;

    static {
        users = Arrays.asList(
                new User("userA", 10, Role.USER),
                new User("userB", 10, Role.USER),
                new User("userC", 15, Role.ADMIN),
                new User("userB", 20, Role.ADMIN),
                new User("userD", 20, Role.ADMIN),
                new User("userB", 25, Role.USER),
                new User("userE", 13, Role.USER)
        );
    }

    public static void main(String[] args) {
//        original();
//        behaviorParameter();
//        anonymousClass();
//        useLambda();
//        usePredicate();
        methodReference();
    }

    private static void methodReference() {
        users.sort((user1, user2) -> user1.getAge() - user2.getAge());
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getAge() - user2.getAge();
            }
        });
        System.out.println("users = " + users);
        users.sort(Comparator.comparing(User::getAge).reversed());
        System.out.println("users = " + users);
    }

    private static void original() {
        System.out.println("--> " + filterByName());
        System.out.println("--> " + filterByAge());
        System.out.println("--> " + filterByRole());
        System.out.println("--> " + filterByNameAndAge());
    }

    private static void behaviorParameter() {
        System.out.println("============change to Behavior Parameter============");
        System.out.println("--> " + filterUser(new UserNamePredicateImpl()));
        System.out.println("--> " + filterUser(new UserAgePredicateImpl()));
        System.out.println("--> " + filterUser(new UserRolePredicateImpl()));
    }

    private static void anonymousClass() {
        System.out.println("============change to Anonymous Class============");
        System.out.println("-->" + filterUser(new UserPredicate() {
            @Override
            public boolean test(User user) {
                return user.getName().equals("userB");
            }
        }));
    }

    private static void useLambda() {
        System.out.println("============change to Lambda============");
        System.out.println("--> " + filterUser(user -> user.getName().equals("userB")));
    }

    private static void usePredicate() {
        System.out.println("============use Predicate java Provide============");
        System.out.println("--> " + filterUserBySpecificPredicate(user -> user.getName().equals("userB")));
        System.out.println("============use Predicate java Provide with Generic============");
        System.out.println("--> filter user" + filterByPredicateUseGeneric(users, user -> user.getName().equals("userB")));
        System.out.println("--> filter number" + filterByPredicateUseGeneric(Arrays.asList(1, 2, 3, 4, 5), i -> i % 2 == 0));
    }

    private static List<User> filterByName() {
        System.out.println("Main.filterByName");
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getName().equals("userB")) {
                result.add(user);
            }
        }
        return result;
    }

    private static List<User> filterByAge() {
        System.out.println("Main.filterByAge");
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getAge() >= 15) {
                result.add(user);
            }
        }
        return result;
    }

    private static List<User> filterByRole() {
        System.out.println("Main.filterByRole");
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getRole().equals(Role.USER)) {
                result.add(user);
            }
        }
        return result;
    }

    private static List<User> filterByNameAndAge() {
        System.out.println("Main.filterByNameAndAge");
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getAge() >= 15 && user.getName().equals("userB")) {
                result.add(user);
            }
        }
        return result;
    }

    private static List<User> filterUser(UserPredicate predicate) {
        System.out.println("Main.filterUser, UserPredicate : " + predicate.getClass().getSimpleName());
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (predicate.test(user)) {
                result.add(user);
            }
        }
        return result;
    }

    private static List<User> filterUserBySpecificPredicate(Predicate<User> predicate) {
        System.out.println("Main.filterUserByPredicate");
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (predicate.test(user)) {
                result.add(user);
            }
        }
        return result;
    }

    private static <T> List<T> filterByPredicateUseGeneric(List<T> list, Predicate<T> predicate) {
        System.out.println("Main.filterUserByPredicateUseGeneric");
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return result;
    }
}