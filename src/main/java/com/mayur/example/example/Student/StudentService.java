package com.mayur.example.example.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student s) {
        Optional<Student> existingStudent = studentRepository.findStudentByEmail(s.getEmail());
        if(existingStudent.isPresent()) {
            throw new IllegalStateException("Student with this email already exists.");
        }
        studentRepository.save(s);
        System.out.println("Student " + s.getFirstName() + " " + s.getLastName() +" saved successfully.");
    }

    public void deleteStudentById(Long targetId) {
        boolean studentExists = studentRepository.existsById(targetId);
        if(!studentExists) {
            throw new IllegalStateException("No student found with ID " + targetId.toString() + ".");
        }
        studentRepository.deleteById(targetId);
        System.out.println("Student with ID " + targetId.toString() + " deleted successfully.");
    }
}
