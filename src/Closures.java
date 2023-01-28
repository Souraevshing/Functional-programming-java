public class Closures {

    public static void main(String[] args) {
        NoArgFunction<NoArgFunction<String>> greet = () -> {
            String name = "Admin";
            return () -> "Hi, " + name;
        };

        //although greet() is locally scoped, still we can access returned value
        NoArgFunction<String> greetMe = greet.apply();
        System.out.println(greetMe.apply());
    }
}
