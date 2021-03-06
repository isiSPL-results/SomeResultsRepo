// Compilation Unit of /Situation.java

package healthwatcher.model.complaint;
import java.io.Serializable;
public class Situation implements Serializable
{
    private int code;
    private String description;
    public static int QUEIXA_ABERTA = 1;
    public static int QUEIXA_SUSPENSA = 2;
    public static int QUEIXA_FECHADA = 3;
    public String getDescription()
    {
        return description;
    }

    public int getCode()
    {
        return code;
    }

    public Situation(int codigo, String descricao)
    {
        this.code = codigo;
        this.description = descricao;
    }

}


