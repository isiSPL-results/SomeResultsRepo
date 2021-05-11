package healthwatcher.model.healthguide;
public class MedicalSpeciality implements java.io.Serializable
{
    private int codigo;
    private String descricao;
    public void setCodigo(int cod)
    {
        this.codigo = cod;
    }
    public String getDescricao()
    {
        return this.descricao;
    }
    public MedicalSpeciality(String descricao)
    {
        this.descricao = descricao;
    }
    public String toString()
    {
        return descricao;
    }
    public int getCodigo()
    {
        return this.codigo;
    }
    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

}
