package lab3;

public class Student {
    private String name;
    private String gender;
    private double averageMark;

    public Student(String name, String gender, double averageMark){
        this.name = name;
        this.gender = gender;
        this.averageMark = averageMark;
    }

    public double getAverageMark() {
        return averageMark;
    }
    public String getName(){
        return name;
    }

    public String getGender(){
        return gender;
    }
}
