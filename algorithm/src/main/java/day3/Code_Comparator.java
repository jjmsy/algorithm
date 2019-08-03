package day3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 比较器
 */

public class Code_Comparator {
    public static class Student{
        private String name;
        private int id;
        private int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", age=" + age +
                    '}';
        }
    }
    public static class IdAsCendingConmparator implements Comparator<Student> {
        /**
         * 如果o1 < o2 return -1
         * 如果o1 > o2 return 1
         * 如果o1 = o2 return 0
         *
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }
    public static class IdDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }

    }

    public static class AgeAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }

    }

    public static class AgeDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }

    }
    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
        System.out.println("===========================");
    }

    public static void main(String[] args) {
        Student student1 = new Student("A",1,23);
        Student student2 = new Student("B",2,21);
        Student student3 = new Student("C",3,22);
//        Student[] students = new Student[]{student3,student2,student1};
//        printStudents(students);
//        Arrays.sort(students,new IdAsCendingConmparator());
//        printStudents(students);
//        Arrays.sort(students,new IdDescendingComparator());
//        printStudents(students);
//        Arrays.sort(students,new AgeAscendingComparator());
//        printStudents(students);
//        Arrays.sort(students,new AgeDescendingComparator());
//        printStudents(students);

        PriorityQueue<Student> heap = new PriorityQueue <Student>(new IdAsCendingConmparator());//优先级队列解决堆排序问题
        heap.add(student1);
        heap.add(student2);
        heap.add(student3);
        while(!heap.isEmpty()){
            Student student = heap.poll();//一次弹出堆顶的数据，堆的大小减一
            System.out.println(student);
        }
    }


}
