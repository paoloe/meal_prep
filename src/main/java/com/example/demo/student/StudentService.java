package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired //loosely coupling again here... nice
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll(); //return list
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.
                findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("Student email already exists");
        }
        studentRepository.save(student);
    }

    //delete student
    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        //lets first check if it exists
        if (!exists){
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    //PUT - update an existing record
    @Transactional // this annotation puts the entity into a managed state
    public void updateStudent(Long studentId,
                              String name,
                              String email) {
        Student student = studentRepository.findById(studentId).
                orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exist"));

        // validate name is not blank, length is > 0 and name values are not the same
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository
                    .findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("Student email already exists");
            }
            // set the email after all the validation
            student.setEmail(email);
        }
    }
}
