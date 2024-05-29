package dw.firstapp.controller;

import dw.firstapp.model.Student;
import dw.firstapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired // 밑에 빌려온 변수를 사용하겠다는 의미 // BEAN을 관리하는 곳에서 빌려온다.
    StudentService studentService;

    //하나의 객체 보내주기
    @GetMapping("/student")
    public Student getStudent() {
        return new Student("Tom", "Smith");
    }

    //여러개의 객체 보내주기
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Tom", "Smith"));
        students.add(new Student("John", "Long"));
        students.add(new Student("Steve", "White"));
        students.add(new Student("Leon", "Red"));
        students.add(new Student("Mike", "Tyson"));
        return students;
    }

    //값을 주소에 입력시켜서 보내는 방법 - PathVariable 을 이용한 방법
    @GetMapping("/student/{firstName}/{lastName}") // {firstName}/{lastName}은 변수역활, 그 위치에 값을 대입
    public Student studentPathvariable(@PathVariable String firstName,
                                       @PathVariable String lastName) {
        return new Student(firstName, lastName);
    }

    //값을 주소에 입력시켜서 보내는 방법 - RequestParam 을 이용한 방법
    @GetMapping("/student/query")
    // 사용방법 - 뛰어쓰기 없이 ? 와 =, & 기호를 사용해 주소를 만든다.
    // localhost:8080/student/query?firstname=Tom&lastName=Smith
    public Student studentRequestParam(
            @RequestParam String firstName,
            @RequestParam String lastName) {
        return new Student(firstName, lastName);
    }
    //body 에는 숨겨야 할 내용 혹은 긴 내용을 담는다.
    // @RequestBody = body에 있는 객체를 가져와서 사용
    // 프론트 쪽에서 정보를 제이슨 형태로 전달 받아야 한다. 미스매치 주의.
    @PostMapping("/student/post")
    public Student studentPost(@RequestBody Student student) {
        System.out.println(student.getFirstName() + " " + student.getLastName());
        return new Student(student.getFirstName(),student.getLastName());
    }
    @GetMapping("/student/score/{firstName}/{lastName}")
    public int getStudentScore(@PathVariable String firstName,
                               @PathVariable String lastName){
        Student student = new Student(firstName, lastName);
        // StudentService는 Bean이므로 인스턴스화하지 않는다.
        // StudentService studentService = new StudentService();
        return studentService.getStudentScore(student);
    }
}