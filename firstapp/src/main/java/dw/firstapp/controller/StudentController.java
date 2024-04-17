package dw.firstapp.controller;

import dw.firstapp.model.Student;
import dw.firstapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/student")
    public Student getStudent() {
        return new Student("Tom", "Smith");


    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Tom", "Smith"));
        students.add(new Student("John", "Long"));
        students.add(new Student("Steve", "White"));
        students.add(new Student("Leon", "Red"));
        students.add(new Student("Mike", "Tyson"));
        return students;
    }
    @GetMapping("/student/{firstName}/{lastName}")  //{firstName} 변수를 표기하기위해(Tomcat한테 알려줌) 중괄호를 표시
    public Student studentPathVariable(@PathVariable String firstName, // @PathVariable: String firstName 호출
                                       @PathVariable String lastName) { // @PathVariable: String lastName 호출
        return new Student(firstName, lastName);

    }


    @GetMapping("/student/query")
    // localhost:8080/student/query?firstName=Tom&lastName=Smith
    public Student studentRequestParam(
            @RequestParam String firstName,   // @RequestParam 보안에 취약하고 공개해도 될 내용을 쓸때 사용
            @RequestParam String lastName) {
        return new Student(firstName, lastName);
    }

    @PostMapping("/student/post")
    public Student studentPost(@RequestBody Student student) { // body에 있는 내용을 가져와서 student에 캐스팅
        System.out.println(student.getFirstName() + " " + student.getLastName());
        return new Student(student.getFirstName(), student.getLastName());
    }
    @GetMapping("/student/score/{firstName}/{lastName}")
    public int getStudentScore(@PathVariable String firstName,
                               @PathVariable String lastName){
        Student student = new Student(firstName, lastName); // model에 있는것만 객체를 만들어서 new 씀
        // StudentService = been이므로 인스턴스화 하지 않는다.
        // StudentService studentService = new StudentService();
        return studentService.getStudentScore(student);
    }
}

