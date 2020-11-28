package pl.polsl.aei.ior.springdata.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "MAJORS")
public class Major
{
    @Id
    @Column(name = "MAJOR_ID")
    private int majorId;

    @Column(name = "MAJOR_NAME")
    private String majorName;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "INSTITUTE_ID")
    private Institute institute;

    public Major() { }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }
}
