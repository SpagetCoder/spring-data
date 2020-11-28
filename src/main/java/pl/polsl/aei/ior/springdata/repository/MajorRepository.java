package pl.polsl.aei.ior.springdata.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import pl.polsl.aei.ior.springdata.model.Institute;
import pl.polsl.aei.ior.springdata.model.Major;

import java.util.List;

public interface MajorRepository extends JpaRepository<Major, Integer>
{
    List<Major> findMajorsByMajorNameContainingOrInstitute_InstituteName(@RequestParam String majorName, @RequestParam String instituteName);
    Major findMajorByMajorNameLikeIgnoreCase(@RequestParam String majorName);
    List<Major> findMajorByMajorIdGreaterThanAndMajorIdLessThan(@RequestParam int number1, @RequestParam int number2);


    @Query("select m from Major m where m.majorId= ?1")
    List<Major>findByQuery(int id);

}
