package Optional_Container;

import java.util.Optional;

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
public class Main {
    public static void main(String[] args) {
        User user1 = new User("Rishav");
        User user2 = new User(null);

        User user4 = new User("rishav@example.com");
        User user5 = new User(null);
        User user6 = new User("invalidEmail.com");

        String val=Optional.ofNullable(user1).map(User::getName).map(String::toUpperCase)
                .orElse("Default");
        System.out.println(val);

        String ans1 = Optional.ofNullable(user1).map(User::getName).orElse("No Name");
        String ans2= Optional.ofNullable(user2).map(User::getName).orElseGet(()->"No Name");

        System.out.println(ans1);
        System.out.println(ans2);

        Optional.ofNullable(user4).map(User::getName).filter(email->email.contains("@example.com"))
                .ifPresent(System.out::println);
        Optional.ofNullable(user4).map(User::getName).filter(email->email.contains("@")).
                map(email->email.substring(email.indexOf("@")+1)).ifPresent(System.out::println);

    }
}
