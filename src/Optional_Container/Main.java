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
        Optional<String>user7= Optional.of("Hello World").filter(name->name.toLowerCase().contains("Hello"));
        System.out.println(user7);
        /*
        .filter(...) returns an Optional<String> ✅
        .orElse("no name") does not return an Optional, it returns a String ❌
         */
         String str=" hello world";
         Optional<String>opt=Optional.ofNullable(null);
        System.out.println(opt.isPresent());
        boolean x=Optional.ofNullable(str).map(String::length).filter(val1->val1>5).isPresent();
        boolean x1=Optional.ofNullable(str).map(String::trim).filter(val2->val2.contains("k")).isPresent();
        System.out.println(x+"  "+x1);




    }
}

/*
Use ofNullable() when a value might be null.
Use map() when you want to transform the value inside Optional.
Use filter() when you want to apply a condition on the value.

| Method              | Purpose                               | Input                   | Output                  | Return Type   |
| ------------------- | ------------------------------------- | ----------------------- | ----------------------- | ------------- |
| `ofNullable(value)` | Wraps value into Optional (null-safe) | Any value (can be null) | Optional.empty if null  | `Optional<T>` |
| `map(Function)`     | Transform value inside Optional       | Function: T → U         | Applies only if present | `Optional<U>` |
| `filter(Predicate)` | Keep value only if condition true     | Predicate: T → boolean  | Empty if false          | `Optional<T>` |

 */
