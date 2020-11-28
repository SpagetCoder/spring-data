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
import pl.polsl.aei.ior.springdata.repository.MajorRepository;

import java.util.List;

@RestController
@RequestMapping("/majors")
public class MajorController
{
    @Autowired
    MajorRepository mr;

    @GetMapping
    Page<Major> getMajors(Pageable page)
    {
        return mr.findAll(page);
    }

    @GetMapping("/searchByTwoAttributes")
    List<Major> getMajorsByMajorNameOrInstituteName(@RequestParam String majorName, @RequestParam String InstituteName)
    {
        return mr.findMajorsByMajorNameContainingOrInstitute_InstituteName(majorName,InstituteName);
    }

    @GetMapping("/likeAndIgnore")
    Major getNajorsByName(@RequestParam String name)
    {
        return mr.findMajorByMajorNameLikeIgnoreCase(name);
    }

    @GetMapping("/andClause")
    List<Major> getMajorsThanAndSmallerThan(@RequestParam int number1, @RequestParam int number2)
    {
        return mr.findMajorByMajorIdGreaterThanAndMajorIdLessThan(number1, number2);
    }

    @GetMapping("/query")
    List<Major> getMajorById(@RequestParam int id){
        return mr.findByQuery(id);
    }


    @GetMapping("/delete")
    void deleteRow(@RequestParam int id)
    {
        mr.deleteById(id);
        System.out.println("Removing:  " + id);
    }


}
