
//#if 1204113931 
// Compilation Unit of /UpdateMedicalSpecialityData.java 
 

//#if 1234832686 
package healthwatcher.view.command;
//#endif 


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


//#if -353660191 
public class UpdateMedicalSpecialityData extends 
//#if -725052114 
Command
//#endif 

  { 

//#if -219606017 
public UpdateMedicalSpecialityData(IFacade f)
    { 

//#if -1327717820 
super(f);
//#endif 

} 

//#endif 


//#if -773426394 
public void execute() throws Exception
    { 

//#if 1206024587 
PrintWriter out = response.getWriter();
//#endif 


//#if 1972646418 
try //1
{ 

//#if -1236265125 
MedicalSpeciality speciality;
//#endif 


//#if 1357171518 
if(! request.isAuthorized())//1
{ 

//#if -1198073733 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if 2136551135 
speciality = (MedicalSpeciality) request.get(UpdateMedicalSpecialitySearch.SPECIALITY);
//#endif 


//#if -343311368 
String descricao = request.getInput("descricao");
//#endif 


//#if 1657292664 
speciality.setDescricao(descricao);
//#endif 


//#if -1765848677 
out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Medical Speciality updated"));
//#endif 

} 

//#if 1878451601 
catch(Exception e) //1
{ 

//#if -772439647 
out.println(HTMLCode.errorPage("Communication error, please try again later."));
//#endif 


//#if 345984234 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -475817508 
public void execute()
    { 

//#if -912909684 
PrintWriter out= null;
//#endif 


//#if -447957859 
try //1
{ 

//#if -1054810 
out = response.getWriter();
//#endif 


//#if -508392279 
MedicalSpeciality speciality;
//#endif 


//#if 763307276 
if(! request.isAuthorized())//1
{ 

//#if 1643601165 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if 938697261 
speciality = (MedicalSpeciality) request.get(UpdateMedicalSpecialitySearch.SPECIALITY);
//#endif 


//#if 1258453446 
String descricao = request.getInput("descricao");
//#endif 


//#if -1790714262 
speciality.setDescricao(descricao);
//#endif 


//#if -464498967 
out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Medical Speciality updated"));
//#endif 

} 

//#if -1073014666 
catch(Exception e) //1
{ 

//#if -6215188 
out.println(HTMLCode.errorPage("Communication error, please try again later."));
//#endif 


//#if -162155339 
e.printStackTrace(out);
//#endif 

} 

//#endif 

finally { 

//#if 126477451 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

