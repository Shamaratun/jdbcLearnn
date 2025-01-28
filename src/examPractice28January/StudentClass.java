package examPractice28January;

public class StudentClass {
    int id;
   String name;
   int sClass;
    int age;



    String classTeacher;
       int mark;

    public StudentClass(int id, String name, int sClass, int age, String classTeacher) {
        this.id = id;
        this.name = name;
        this.sClass = sClass;
        this.age = age;
        this.classTeacher = classTeacher;
    }

    public StudentClass(int id, String name, int aClass, int age, String classTeacher, int mark) {
        this.id = id;
        this.name = name;
        this.sClass = sClass;
        this.age = age;
        this.classTeacher = classTeacher;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getsClass() {
        return sClass;
    }

    public void setsClass(int sClass) {
        sClass = sClass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sClass=" + sClass +
                ", age=" + age +
                ", classTeacher='" + classTeacher + '\'' +
                ", mark=" + mark +
                '}';
    }
}
