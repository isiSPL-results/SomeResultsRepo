package healthwatcher.model.complaint;
public class Symptom implements java.io.Serializable
{
    private int code;
    private String description;
    public Symptom(String descricao)
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
    public void setCode(int codigo)
    {
        this.code = codigo;
    }

}
