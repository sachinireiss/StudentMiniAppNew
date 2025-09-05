package Model;

public class Student {
    private int index;
    private String name;
    private String year; // renamed from batch to year
    private Double GPA;

    // Default constructor
    public Student() {
    }

    // Constructor for inserting a new student
    public Student(String name, String year, Double GPA) {
        this.name = name;
        this.year = year; // assign correctly
        this.GPA = GPA;
    }

    // Constructor with index (for updates or retrievals)
    public Student(int index, String name, String year, Double GPA) {
        this.index = index;
        this.name = name;
        this.year = year; // assign correctly
        this.GPA = GPA;
    }

    // Getters and Setters
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) { // fixed setter name
        this.year = year;
    }

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", GPA=" + GPA +
                '}';
    }
}
