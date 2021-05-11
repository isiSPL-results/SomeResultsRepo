
//#if 1843007469 
// Compilation Unit of /ProjectMemberTodoList.java 
 

//#if 1313659256 
package org.argouml.uml.cognitive;
//#endif 


//#if 1759579218 
import java.util.List;
//#endif 


//#if -1051413372 
import java.util.Set;
//#endif 


//#if -1105623283 
import java.util.Vector;
//#endif 


//#if 175328916 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1202690067 
import org.argouml.cognitive.ResolvedCritic;
//#endif 


//#if -1344656730 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -972144941 
import org.argouml.kernel.AbstractProjectMember;
//#endif 


//#if 1641454219 
import org.argouml.kernel.Project;
//#endif 


//#if -1171381799 
import org.argouml.persistence.ResolvedCriticXMLHelper;
//#endif 


//#if 1101128934 
import org.argouml.persistence.ToDoItemXMLHelper;
//#endif 


//#if -111031410 
public class ProjectMemberTodoList extends 
//#if 2126880200 
AbstractProjectMember
//#endif 

  { 

//#if -1580421098 
private static final String TO_DO_EXT = ".todo";
//#endif 


//#if 2117187054 
public String getType()
    { 

//#if -686640234 
return "todo";
//#endif 

} 

//#endif 


//#if 749893436 
public Vector<ResolvedCriticXMLHelper> getResolvedCriticsList()
    { 

//#if -1859427030 
Vector<ResolvedCriticXMLHelper> out =
            new Vector<ResolvedCriticXMLHelper>();
//#endif 


//#if 1125662001 
Set<ResolvedCritic> resolvedSet =
            Designer.theDesigner().getToDoList().getResolvedItems();
//#endif 


//#if 910561081 
synchronized (resolvedSet) //1
{ 

//#if 694116438 
for (ResolvedCritic rci : resolvedSet) //1
{ 

//#if 1231726938 
if(rci != null)//1
{ 

//#if -403043361 
out.addElement(new ResolvedCriticXMLHelper(rci));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1818241512 
return out;
//#endif 

} 

//#endif 


//#if 1028379237 
public ProjectMemberTodoList(String name, Project p)
    { 

//#if -1766558978 
super(name, p);
//#endif 

} 

//#endif 


//#if 1698614588 
@Override
    public String getZipFileExtension()
    { 

//#if 197922386 
return TO_DO_EXT;
//#endif 

} 

//#endif 


//#if 1679258737 
public String repair()
    { 

//#if 615537393 
return "";
//#endif 

} 

//#endif 


//#if 759549730 
public Vector<ToDoItemXMLHelper> getToDoList()
    { 

//#if -2055647983 
Vector<ToDoItemXMLHelper> out = new Vector<ToDoItemXMLHelper>();
//#endif 


//#if 1570784779 
List<ToDoItem> tdiList =
            Designer.theDesigner().getToDoList().getToDoItemList();
//#endif 


//#if 354145319 
synchronized (tdiList) //1
{ 

//#if 1018979977 
for (ToDoItem tdi : tdiList) //1
{ 

//#if -103564697 
if(tdi != null && tdi.getPoster() instanceof Designer)//1
{ 

//#if 1216338276 
out.addElement(new ToDoItemXMLHelper(tdi));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1175427289 
return out;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

