package cn.xatu.domain;

public class Student {
    private String sno;
    private String name;
    private String sex;
    private int age;
    private String dept;
    private String password;
    private int score;
    private String cn;//课程名
    private String cno;//课程编号
    public Student() {
    }

    public Student( int score,String sno, String cno) {
        this.score = score;
        this.sno = sno;
        this.cno = cno;
    }

    public Student(int score) {
        this.score = score;
    }

    public Student(String cno, String sno, String cn, int score) {
        this.cno = cno;
        this.sno = sno;
        this.cn = cn;
        this.score = score;


    }

    public Student(String sno, String cn, int score){
        this.sno = sno;
        this.cn = cn;
        this.score = score;
    }
    public Student(String cn,int score){
        this.cn = cn;
        this.score = score;
    }

    public Student(String sno, String name, String sex, int age, String dept, String password) {
        this.sno = sno;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.dept = dept;
        this.password = password;
    }

    public Student(String sno, String name, String sex, int age, String dept, int score) {
        this.sno = sno;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.dept = dept;
        this.score = score;
    }

    public Student(String sno, String name, String sex, int age, String dept) {
        this.sno = sno;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.dept = dept;

    }

    public Student(String name, String sex, int age, String dept) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.dept = dept;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", dept='" + dept + '\'' +
                ", score=" + score +
                ", cn='" + cn + '\'' +
                '}';
    }

}
