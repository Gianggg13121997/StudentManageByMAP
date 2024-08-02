import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static StudentManage studentManage = new StudentManage();
    private static Scanner IntInput = new Scanner(System.in);
    private static Scanner StringInput = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("QUAN LI SINH VIEN :");
            System.out.println("1.Them moi sinh vien :\n2.Xoa sinh vien : \n3.Sua sinh vien :\n4.Tim kiem sinh vien theo ID:\n5.Hien thi ds theo ten gan dung :\n6.HS co diem trungbinh lon nhat :\n7.Hien thi tat ca:\n0.Exit :");
            System.out.println("Nhap lua chon :");
            choice = IntInput.nextInt();
            switch (choice) {
                case 1:
                    showMenuAdd();
                    break;
                case 7:
                    showALl();
                    break;
                case 2:
                    remove();
                    break;
                case 5:
                    searchStudentByName();
                    break;
                case 4:
                    searchStudentById();
                    break;
                case 6:
                    findStudentWithHighestAverage();
                    break;
                case 3:
                    showMenuEdit();
                    break;


            }

        } while (choice != 0);

    }

    public static void showMenuAdd() {
        System.out.println("Nhap ID sinh vien :");
        int id = IntInput.nextInt();
        System.out.println("Nhap ten sinh vien :");
        String name = StringInput.nextLine();
        System.out.println("Nhap gioi tinh :");
        String sex = StringInput.nextLine();
        System.out.println("Nhap diem toan :");
        int MathScore = IntInput.nextInt();
        System.out.println("Nhap diem van :");
        int literatureScore = IntInput.nextInt();
        System.out.println("Nhap diem anh :");
        int EnglishScore = IntInput.nextInt();
        double averageScore = (MathScore + literatureScore + EnglishScore) / 3;
        Student student = new Student(id, name, sex, averageScore);
        studentManage.addStudent(student);
        System.out.println("them thanh cong ");


    }

    public static void showALl() {
        System.out.println("====danh sach sinh vien :========");
        studentManage.showStudentList();

    }

    public static void remove() {
        System.out.println("Nhap id can xoa :");
        int id = IntInput.nextInt();
        studentManage.removeStudent(id);

    }

    public static void searchStudentByName() {
        System.out.println("NHap ten can tim :");
        String name = StringInput.nextLine();
        Map<Integer, Student> students = studentManage.searchStudentByName(name);
        if (students.isEmpty()) {
            System.out.println("khong tim thay sinh vien !");
        } else {
            for (Student student : students.values()) {
                System.out.println(student);
            }
        }
    }

    public static void searchStudentById() {
        System.out.println("Nhap id can tim  :");
        int id = IntInput.nextInt();
        Student student = studentManage.findById(id);
        if (student == null) {
            System.out.println("khong tim thay sinh vien !");
        } else {
            System.out.println(student);
        }
    }

    public static void findStudentWithHighestAverage() {
        Student topStudent = studentManage.findStudentWithHighestAverage();

        if (topStudent == null) {
            System.out.println("Danh sách sinh viên trống.");
        } else {
            System.out.println("Sinh viên có điểm trung bình cao nhất:");
            System.out.println(topStudent);
        }
    }

    public static void showMenuEdit() {
        System.out.println("Nhap ID sinh vien :");
        int id = IntInput.nextInt();
        System.out.println("Nhap ten sinh vien :");
        String name = StringInput.nextLine();
        System.out.println("Nhap gioi tinh :");
        String sex = StringInput.nextLine();
        System.out.println("Nhap diem toan :");
        int MathScore = IntInput.nextInt();
        System.out.println("Nhap diem van :");
        int literatureScore = IntInput.nextInt();
        System.out.println("Nhap diem anh :");
        int EnglishScore = IntInput.nextInt();
        double averageScore = (MathScore + literatureScore + EnglishScore) / 3;
        Student student = new Student(id, name, sex, averageScore);
        studentManage.addStudent(student);
        System.out.println("Sua thanh cong! ");
    }


}

