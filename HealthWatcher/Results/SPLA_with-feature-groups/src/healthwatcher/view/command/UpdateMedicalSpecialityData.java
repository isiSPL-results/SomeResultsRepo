
//#if 1204113931 
// Compilation Unit of /UpdateMedicalSpecialityData.java 
 
package healthwatcher.view.command;

//#if -166902652 
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif 


//#if -1257633083 
import healthwatcher.view.IFacade;
//#endif 


//#if 1793070661 
import java.io.PrintWriter;
//#endif 


//#if 513175422 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if 45287822 
import lib.util.HTMLCode;
//#endif 

public class UpdateMedicalSpecialityData extends Command
  { 
public UpdateMedicalSpecialityData(IFacade f)
    { 
super(f);
} 


//#if -773426394 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
try //1
{ 
MedicalSpeciality speciality;
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException();
} 

speciality = (MedicalSpeciality) request.get(UpdateMedicalSpecialitySearch.SPECIALITY);
String descricao = request.getInput("descricao");
speciality.setDescricao(descricao);
out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Medical Speciality updated"));
} 
catch(Exception e) //1
{ 
out.println(HTMLCode.errorPage("Communication error, please try again later."));
e.printStackTrace(out);
} 


} 

//#endif 


//#if -475817508 
public void execute()
    { 
PrintWriter out= null;
try //1
{ 
out = response.getWriter();
MedicalSpeciality speciality;
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException();
} 

speciality = (MedicalSpeciality) request.get(UpdateMedicalSpecialitySearch.SPECIALITY);
String descricao = request.getInput("descricao");
speciality.setDescricao(descricao);
out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Medical Speciality updated"));
} 
catch(Exception e) //1
{ 
out.println(HTMLCode.errorPage("Communication error, please try again later."));
e.printStackTrace(out);
} 

finally { 
out.close();
} 

} 

//#endif 

 } 


//#endif 

