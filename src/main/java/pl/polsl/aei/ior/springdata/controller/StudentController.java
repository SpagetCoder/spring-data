package pl.polsl.aei.ior.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.aei.ior.springdata.model.Institute;
import pl.polsl.aei.ior.springdata.model.Major;
import pl.polsl.aei.ior.springdata.model.Student;
import pl.polsl.aei.ior.springdata.repository.StudentRepository;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController
{
    @Autowired
    StudentRepository sr;

    @GetMapping
    Page<Student> getStudents(Pageable page)
    {
        return sr.findAll(page);
    }

    @GetMapping("/searchByTwoAttributes")
    List<Student> getStudentsByGenderAndMajor(@RequestParam String gender,@RequestParam Major majorId)
    {
        return sr.findStudentsByGenderAndMajor(gender,majorId);
    }

    @GetMapping("/likeAndIgnore")
    List<Student> getStudentsByMajorsInstituteName(@RequestParam String name)
    {
        return sr.findStudentsByMajor_MajorName(name);
    }

    @GetMapping("/orClause")
    List<Student> getStudentsWhereStudentIdIsBiggerThanOrMajorIdIsBiggerThan(@RequestParam int studentId, @RequestParam Major majorId)
    {
        return sr.findAllByStudentIdOrMajor(studentId, majorId);
    }

    @GetMapping("/query")
    List<Student> getStudentsByInstituteId(@RequestParam int id){
        return sr.findByQuery(id);
    }


    @GetMapping("/delete")
    void deleteRow(@RequestParam int id)
    {
        sr.deleteById(id);
        System.out.println("Removing:  " + id);
    }
}

