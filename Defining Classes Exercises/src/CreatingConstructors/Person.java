package CreatingConstructors;

public class Person {

    private String name;
    private int age;
    public static final String INVALID_NAME = "No name";
    public static final int INVALID_AGE = 1;

    public Person() {
        this.age = INVALID_AGE;
        this.name = INVALID_NAME;
    }

    public Person(int num) {
        this.name = INVALID_NAME;
        this.age = num;
    }

    public Person(String name, int age) {
        this(age);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
