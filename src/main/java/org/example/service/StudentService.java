package org.example.service;

import org.example.entity.Students;
import org.example.exceptions.InvalidUsernamePasswordException;
import org.example.exceptions.UserNotFoundException;
import org.example.repository.StudentRepository;
import org.example.securiy.SecurityUtils;

public class StudentService {
    StudentRepository studentRepository = new StudentRepository();

    public void register(Students students){
        studentRepository.create(students);
    }
    public void loginUser(String username, String password) throws UserNotFoundException, InvalidUsernamePasswordException {
        Students students = studentRepository.getStudents(username);
        if (students == null)
            throw new UserNotFoundException("user with given username :-- " + username + " -- not found.");

        if (students.getPassWord().equals(password)) {
            SecurityUtils.setStudents(students);
        } else{
            throw new InvalidUsernamePasswordException("password is wrong.");
        }
    }
    public Students findById(Long id){
        return studentRepository.findById(id);
    }
}
