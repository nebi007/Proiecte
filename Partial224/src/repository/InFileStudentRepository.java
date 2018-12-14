//package com.company.repository;
//
//import com.company.domain.Student;
//import com.company.validator.Validator;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class InFileStudentRepository extends AbstractFileRepository<String, Student> {
//
//    public InFileStudentRepository(String fileName) {
//        super(fileName);
//    }
//
//    @Override
//    protected Student createEntity(String line) {
//        List<String> attrs = Arrays.asList(line.split("\\|"));
//        String id = attrs.get(0).split("=")[1];
//        String name = attrs.get(1).split("=")[1];
//        String group = attrs.get(2).split("=")[1];
//        String email = attrs.get(3).split("=")[1];
//        String teacher = attrs.get(4).split("=")[1];
//
//        return new Student(id, name, Integer.parseInt(group), email, teacher);
//    }
//}
