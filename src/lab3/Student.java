package lab3;

public class Student {
    private String name;
    private String surname;
    private int age;
    private double averageMark;

    public Student(String name, String Surname, int age, double averageMark){
        this.name = name;
        this.surname = Surname;
        this.age = age;
        this.averageMark = averageMark;
    }

    public double getAverageMark() {
        return averageMark;
    }
    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public int getAge() {
        return age;
    }
}
