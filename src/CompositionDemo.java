import java.util.function.Function;

public class CompositionDemo {
    public static class Employee {
        private String name;
        private Integer age;
        private Float sal;
        private String jobTitle;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Float getSal() {
            return sal;
        }

        public void setSal(Float sal) {
            this.sal = sal;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public static void main(String[] args) {
            Function<Integer,Integer> timesTwo = (x) -> x * 2;
            Function<Integer,Integer> minusOne = (x) -> x - 1;

            //combining 2 functions using andThen() and produces result multiplying by 2 and subtracting 1 from the result
            Function<Integer,Integer> combine = timesTwo.andThen(minusOne);
            Function<Integer,Integer> combine2 = timesTwo.compose(minusOne);

            System.out.println(combine.apply(5));
            System.out.println(combine2.apply(5));

            CombineFunction.Employee[] empArr = {
                    new CombineFunction.Employee("admin",23,100000f,"SDE1"),
                    new CombineFunction.Employee("admin",23,750000f,"FSD"),
            };
        }
    }
}
