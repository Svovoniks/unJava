package lab3;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Reanu", "Keeves", 18, 5.0);
        int student1Number = 1243;

        Student student2 = new Student("Lex", "Luther", 21, 4.0);
        int student2Number = 12343;

        HashTable<Integer, Student> table = new HashTable<>();
        table.put(student1Number, student1);
        table.put(student2Number, student2);

        System.out.println(table.size());

        System.out.println(table.get(student1Number).getName());
        System.out.println(table.get(student2Number).getName());

        table.remove(student1Number);

        System.out.println(table.size());

        System.out.println(table.get(student1Number));
    }
}
