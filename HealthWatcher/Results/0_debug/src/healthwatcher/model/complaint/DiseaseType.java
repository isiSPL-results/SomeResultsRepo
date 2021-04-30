
//#if 1850534641 
// Compilation Unit of /DiseaseType.java 
 

//#if -1087451990 
package healthwatcher.model.complaint;
//#endif 


//#if 570200648 
import java.util.ArrayList;
//#endif 


//#if -2034215143 
import java.util.List;
//#endif 


//#if -829801722 
public class DiseaseType implements 
//#if 2054453931 
java.io.Serializable
//#endif 

  { 

//#if 1743466578 
private int code;
//#endif 


//#if 667262380 
private String name;
//#endif 


//#if -977416797 
private String description;
//#endif 


//#if 1088658361 
private String manifestation;
//#endif 


//#if -1022198333 
private String duration;
//#endif 


//#if -1628443648 
private List symptoms;
//#endif 


//#if 930097560 
public String getName()
    { 

//#if 605604853 
return name;
//#endif 

} 

//#endif 


//#if 1872698289 
public String getDescription()
    { 

//#if -725425447 
return description;
//#endif 

} 

//#endif 


//#if 222500961 
public String getDuration()
    { 

//#if -785002743 
return duration;
//#endif 

} 

//#endif 


//#if 361566983 
public void setCode(int codigo)
    { 

//#if 690002064 
this.code = codigo;
//#endif 

} 

//#endif 


//#if 1586614856 
public void setDuration(String duracao)
    { 

//#if -456944190 
this.duration = duracao;
//#endif 

} 

//#endif 


//#if 822842690 
public void setManifestation(String manifestacao)
    { 

//#if 1090990236 
this.manifestation = manifestacao;
//#endif 

} 

//#endif 


//#if -1483120930 
public DiseaseType()
    { 

//#if -124995322 
symptoms = new ArrayList();
//#endif 

} 

//#endif 


//#if -101947399 
public void delete()
    {
}
//#endif 


//#if -1313364214 
public List getSymptoms()
    { 

//#if 160127282 
return symptoms;
//#endif 

} 

//#endif 


//#if 2028278286 
public int getCode()
    { 

//#if 213998565 
return code;
//#endif 

} 

//#endif 


//#if -97831722 
public void setSymptoms(List sintomas)
    { 

//#if 1747710107 
this.symptoms = sintomas;
//#endif 

} 

//#endif 


//#if 2101455451 
public String getManifestation()
    { 

//#if -1309859614 
return manifestation;
//#endif 

} 

//#endif 


//#if 1863235698 
public void setDescription(String descricao)
    { 

//#if -936281900 
this.description = descricao;
//#endif 

} 

//#endif 


//#if 1453747223 
public DiseaseType(String name, String description, String manifestation, String duration,
                       List symptoms)
    { 

//#if -1170447871 
this.name = name;
//#endif 


//#if -1197239421 
this.description = description;
//#endif 


//#if 68935023 
this.manifestation = manifestation;
//#endif 


//#if 1270223329 
this.duration = duration;
//#endif 


//#if -1078626015 
this.symptoms = symptoms;
//#endif 

} 

//#endif 


//#if 1501035991 
public void setName(String nome)
    { 

//#if 415893252 
this.name = nome;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

