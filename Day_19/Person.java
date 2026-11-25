package Day_19;

public class Person {
    String name;
    int age;
    double salary;

    public static void main(String[] args) {
        Person p = new Person();
        p.name = "Rahul";
        p.age = 21;
        p.salary = 25000;

        System.out.println(p.name + " " + p.age + " " + p.salary);
    }
}