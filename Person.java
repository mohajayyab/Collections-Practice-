package new;

public class Person implements Comparable{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.age, ((Person)o).getAge());
    }

    @Override
    public String toString(){
        return "Name: "+name;
    }
}
