package Functional_interface_type;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class main {
    public static void main(String args[])
    {
        Function<String,Integer>function=str->str.length();
        System.out.println(function.apply("Hello world"));

        Function<String,String>f1=str->str.trim();
        Function<String,String>f2=str->str.toUpperCase();

        Function<String,String>f3=f1.andThen(f2);
        System.out.println("Combine function : "+f3.apply("Hello World"));

/// //////////////////////////////////////
        Predicate<String>st=str->str.length()>5;
        System.out.println("Predicate answer"+st.test("Helloworld"));


        Predicate<String>st1= str->str.contains("ghhg");
        Predicate<String>st2=str->str.toUpperCase().equals(str);

        Predicate<String>st3=st1.and(st2);
        System.out.println("Predicate answer combine"+st3.test("Anaconda"));
/// ////////////////////////////
        Consumer<String>st5=str-> System.out.println(str.toUpperCase());
        st5.accept("substring");

        Consumer<String>st6=str-> System.out.println("data saved"+str);
        List<String>li=List.of("Hello","world");
        li.add("ghgh");
        li.forEach(st6);
        st6.accept("vdghvhe");
/// ////////////////////////////
        Supplier<String> nameSupplier = () -> "Rishav";
        System.out.println(nameSupplier.get());

        Optional<String>op=Optional.of("Rohit");
        String str=op.orElse("Invalid name");
        System.out.println(str);
    }
}
/*
Function<T, R>
Purpose: Represents a function that takes one argument and returns a result.
Type Parameters:
T – the type of the input to the function
R – the type of the result of the function



2. Predicate<T>
Purpose: Evaluate a condition (returns true/false).
Example: Check if email is from Gmail.
Predicate<String> isGmail = email -> email.contains("@gmail.com");
System.out.println(isGmail.test("abc@gmail.com"));  // true
🧠 Real-Life Use Case:
Validate input fields (isEmpty, startsWith, etc.).
Check if a user is admin: user -> user.getRole().equals("ADMIN").


3.Consumer<T>
Purpose: Perform an action with input but don’t return anything.
Example: Print a message.
Consumer<String> printer = msg -> System.out.println(msg);
printer.accept("Hello");  // Output: Hello
🧠 Real-Life Use Case:
Send notifications, log data, save to DB.

4. Supplier<T>
Purpose: Supply data or object without taking any input.
Example: Return a static value.
Supplier<String> supplier = () -> "Rishav";
System.out.println(supplier.get());  // Output: Rishav
🧠 Real-Life Use Case:
Generate OTP, timestamps, UUIDs.
Supply a default config or fallback object.
 */
