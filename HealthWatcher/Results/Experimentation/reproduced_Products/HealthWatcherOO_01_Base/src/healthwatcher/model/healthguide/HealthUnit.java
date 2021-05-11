package healthwatcher.model.healthguide;
import java.util.Iterator;
import java.util.List;
public class HealthUnit implements java.io.Serializable
{
    private int code;
    private String description;
    private List specialities;
    public boolean hasSpeciality(int code)
    {
        for(Iterator i = specialities.iterator(); i.hasNext();) { //1
            MedicalSpeciality m = (MedicalSpeciality) i.next();
            if(m.getCodigo() == code) { //1
                return true;
            }
        }
        return false;
    }
    public void setDescription(String descricao)
    {
        this.description = descricao;
    }
    public String getDescription()
    {
        return this.description;
    }
    public int getCode()
    {
        return this.code;
    }
    public void setCode(int cod)
    {
        this.code = cod;
    }
    public String toString()
    {
        return description;
    }
    public List getSpecialities()
    {
        return this.specialities;
    }
    public HealthUnit(String description, List specialities)
    {
        this.description = description;
        this.specialities = specialities;
    }
    public HealthUnit()
    {
    }
}
