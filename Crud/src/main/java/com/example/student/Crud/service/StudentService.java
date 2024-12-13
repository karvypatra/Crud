package com.example.student.Crud.service;

import com.example.student.Crud.entity.Student;
import com.example.student.Crud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found!"));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = getStudentById(id);
        student.setName(studentDetails.getName());
        student.setRegdNo(studentDetails.getRegdNo());
        student.setSection(studentDetails.getSection());
        student.setEmailId(studentDetails.getEmailId());
        student.setMobileNo(studentDetails.getMobileNo());
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
