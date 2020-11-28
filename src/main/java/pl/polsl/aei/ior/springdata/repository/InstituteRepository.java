package pl.polsl.aei.ior.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import pl.polsl.aei.ior.springdata.model.Institute;

import java.util.List;


public interface InstituteRepository extends JpaRepository<Institute, Integer>
{
    List<Institute>findInstitutesByInstituteIdOrInstituteName(@RequestParam int id, @RequestParam String name);
    Institute findInstituteByInstituteNameLikeIgnoreCase(@RequestParam String instituteName);
    List<Institute> findInstitutesByInstituteIdIsGreaterThanAndInstituteIdIsLessThan(@RequestParam int number1,@RequestParam int number2);

    @Query("select i from Institute i where i.instituteId= ?1")
    List<Institute>findByQuery(int id);

}
