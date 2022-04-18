package chap02.domain;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private Role role;
}
