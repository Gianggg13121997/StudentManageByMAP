import java.util.HashMap;
import java.util.Map;

public class StudentManage {
    private HashMap<Integer, Student> studentList = new HashMap<>();

    public void addStudent(Student student) {
        studentList.put(student.getId(), student);
    }

    public void removeStudent(int id) {
       if(studentList.containsKey(id)) {
           studentList.remove(id);
           System.out.println("Da xoa sinh vien : "+id );
       }else {
           System.out.println("Khong tim thay sinh vien !");
       }
    }
    public Student findById(int id) {
        return studentList.get(id);
    }
    public Map<Integer,Student> getStudentList() {
        return studentList;
    }

    public Map<Integer,Student> searchStudentByName(String name) {
        Map<Integer,Student> studentMap = new HashMap<>();
        for(Student student : studentList.values()) {
            if(student.getName().contains(name)) {
                studentMap.put(student.getId(), student);
            }
        }return studentMap;

    }
    public void showStudentList() {
        for (Map.Entry<Integer, Student> entry : studentList.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }
    public Student findStudentWithHighestAverage() {
        if (studentList.isEmpty()) {
            return null; // Không có sinh viên
        }

        Student topStudent = null;
        double highestAverage = -1;

        for (Student student : studentList.values()) {
            if (student.getAverageScore() > highestAverage) {
                highestAverage = student.getAverageScore();
                topStudent = student;
            }
        }

        return topStudent;
    }


}
