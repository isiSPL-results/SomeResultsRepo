
//#if 1098836653 
// Compilation Unit of /Situation.java 
 

//#if -905738382 
package healthwatcher.model.complaint;
//#endif 


//#if 794768324 
import java.io.Serializable;
//#endif 


//#if -949008794 
public class Situation implements 
//#if -423817878 
Serializable
//#endif 

  { 

//#if 721010615 
private int code;
//#endif 


//#if 224404168 
private String description;
//#endif 


//#if -1275614709 
public static int QUEIXA_ABERTA = 1;
//#endif 


//#if 2015879823 
public static int QUEIXA_SUSPENSA = 2;
//#endif 


//#if 1278844972 
public static int QUEIXA_FECHADA = 3;
//#endif 


//#if -1821280148 
public String getDescription()
    { 

//#if 1451372473 
return description;
//#endif 

} 

//#endif 


//#if 1950747785 
public int getCode()
    { 

//#if 1975964832 
return code;
//#endif 

} 

//#endif 


//#if 2126119507 
public Situation(int codigo, String descricao)
    { 

//#if -1338061611 
this.code = codigo;
//#endif 


//#if -1708026922 
this.description = descricao;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

