package dataStructure.A_linear_data_structure;

public class Student {
    public String name;
    public int grade;

    public Student(String name, int grade){
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return this.name + ", " + Integer.toString(this.grade);
    }
}
