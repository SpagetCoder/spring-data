package pl.polsl.aei.ior.springdata.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import pl.polsl.aei.ior.springdata.model.Institute;
import pl.polsl.aei.ior.springdata.model.Major;
import pl.polsl.aei.ior.springdata.model.Student;

import java.awt.print.Pageable;
import java.util.List;

public interface StudentRepository extends JpaRepository <Student, Integer>
{
    List<Student>findStudentsByGenderAndMajor(@RequestParam String gender,@RequestParam Major majorId);
    List<Student>findStudentsByMajor_MajorName(@RequestParam String name);
    List<Student>findAllByStudentIdOrMajor(@RequestParam int studentId, @RequestParam Major majorId);

    @Query("select s from Student s where s.major.institute.instituteId = ?1")
    List<Student>findByQuery(int id);

}
