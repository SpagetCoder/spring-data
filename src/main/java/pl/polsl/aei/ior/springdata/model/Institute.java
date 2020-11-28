package pl.polsl.aei.ior.springdata.model;

import javax.persistence.*;


@Entity
@Table(name = "INSTITUTES")
public class Institute
{
    @Id
    @Column(name = "INSTITUTE_ID")
    private int instituteId;

    @Column(name = "INSTITUTE_NAME")
    private String instituteName;

    public Institute() { }

    public int getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(int instituteId) {
        this.instituteId = instituteId;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }
}
