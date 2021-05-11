// Compilation Unit of /DiseaseType.java

package healthwatcher.model.complaint;
import java.util.ArrayList;
import java.util.List;
public class DiseaseType implements java.io.Serializable
{
    private int code;
    private String name;
    private String description;
    private String manifestation;
    private String duration;
    private List symptoms;
    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public String getDuration()
    {
        return duration;
    }

    public void setCode(int codigo)
    {
        this.code = codigo;
    }

    public void setDuration(String duracao)
    {
        this.duration = duracao;
    }

    public void setManifestation(String manifestacao)
    {
        this.manifestation = manifestacao;
    }

    public DiseaseType()
    {
        symptoms = new ArrayList();
    }

    public void delete()
    {
    }
    public List getSymptoms()
    {
        return symptoms;
    }

    public int getCode()
    {
        return code;
    }

    public void setSymptoms(List sintomas)
    {
        this.symptoms = sintomas;
    }

    public String getManifestation()
    {
        return manifestation;
    }

    public void setDescription(String descricao)
    {
        this.description = descricao;
    }

    public DiseaseType(String name, String description, String manifestation, String duration,
                       List symptoms)
    {
        this.name = name;
        this.description = description;
        this.manifestation = manifestation;
        this.duration = duration;
        this.symptoms = symptoms;
    }

    public void setName(String nome)
    {
        this.name = nome;
    }

}


