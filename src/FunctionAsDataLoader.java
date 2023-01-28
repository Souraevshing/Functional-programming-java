public class FunctionAsDataLoader {
    protected static class Person {
        private String name;
        private Integer age;

        public  Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    protected static class DataLoader {
        public final NoArgFunction<Person> loadPerson;
        

        public DataLoader(Boolean isDevelopmentMode) {
            this.loadPerson = isDevelopmentMode
                    ? this::loadPersonFake
                    : this::loadPersonReal;
        }
        
        private Person loadPersonReal() {
            System.out.println("Loading...");
            return new Person("Admin", 23);
        }

        private Person loadPersonFake() {
            System.out.println("Loading fake data...");
            return new Person("FakeUser", 50);
        }
    }

    public static void main(String[] args) {
        final Boolean IS_DEVELOPMENT_MODE = false;

        DataLoader dataLoader = new DataLoader(IS_DEVELOPMENT_MODE);
        System.out.println(dataLoader.loadPerson.apply());
    }
}
