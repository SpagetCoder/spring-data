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
import pl.polsl.aei.ior.springdata.repository.InstituteRepository;
import pl.polsl.aei.ior.springdata.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/institutes")
public class InstituteController
{
    @Autowired
    InstituteRepository ir;

    @GetMapping
    Page<Institute> getInstitutes(Pageable page)
    {
        return ir.findAll(page);
    }

    @GetMapping("/searchByTwoAttributes")
    List<Institute> getInstitutesByIdOrName(@RequestParam int id, @RequestParam String name)
    {
        return ir.findInstitutesByInstituteIdOrInstituteName(id,name);
    }

    @GetMapping("/likeAndIgnore")
    Institute getInstitutesByName(@RequestParam String name)
    {
        return ir.findInstituteByInstituteNameLikeIgnoreCase(name);
    }

    @GetMapping("/andClause")
    List<Institute> getInstitutesBiggerThanAndSmallerThan(@RequestParam int number1, @RequestParam int number2)
    {
        return ir.findInstitutesByInstituteIdIsGreaterThanAndInstituteIdIsLessThan(number1, number2);
    }

    @GetMapping("/query")
    List<Institute> getInstituteById(@RequestParam int id){
        return ir.findByQuery(id);
    }


    @GetMapping("/delete")
    void deleteRow(@RequestParam int id)
    {
        ir.deleteById(id);
        System.out.println("Removing:  " + id);
    }

}
