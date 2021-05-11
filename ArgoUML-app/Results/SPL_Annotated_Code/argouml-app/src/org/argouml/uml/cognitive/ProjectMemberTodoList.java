// Compilation Unit of /ProjectMemberTodoList.java 
 

//#if COGNITIVE 
package org.argouml.uml.cognitive;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if COGNITIVE 
import java.util.Set;
//#endif 


//#if COGNITIVE 
import java.util.Vector;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Designer;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ResolvedCritic;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.kernel.AbstractProjectMember;
//#endif 


//#if COGNITIVE 
import org.argouml.kernel.Project;
//#endif 


//#if COGNITIVE 
import org.argouml.persistence.ResolvedCriticXMLHelper;
//#endif 


//#if COGNITIVE 
import org.argouml.persistence.ToDoItemXMLHelper;
//#endif 


//#if COGNITIVE 
public class ProjectMemberTodoList extends AbstractProjectMember
  { 
private static final String TO_DO_EXT = ".todo";
public String getType()
    { 
return "todo";
} 

public Vector<ResolvedCriticXMLHelper> getResolvedCriticsList()
    { 
Vector<ResolvedCriticXMLHelper> out =
            new Vector<ResolvedCriticXMLHelper>();
Set<ResolvedCritic> resolvedSet =
            Designer.theDesigner().getToDoList().getResolvedItems();
synchronized (resolvedSet) //1
{ 
for (ResolvedCritic rci : resolvedSet) //1
{ 
if(rci != null)//1
{ 
out.addElement(new ResolvedCriticXMLHelper(rci));
} 

} 

} 

return out;
} 

public ProjectMemberTodoList(String name, Project p)
    { 
super(name, p);
} 

@Override
    public String getZipFileExtension()
    { 
return TO_DO_EXT;
} 

public String repair()
    { 
return "";
} 

public Vector<ToDoItemXMLHelper> getToDoList()
    { 
Vector<ToDoItemXMLHelper> out = new Vector<ToDoItemXMLHelper>();
List<ToDoItem> tdiList =
            Designer.theDesigner().getToDoList().getToDoItemList();
synchronized (tdiList) //1
{ 
for (ToDoItem tdi : tdiList) //1
{ 
if(tdi != null && tdi.getPoster() instanceof Designer)//1
{ 
out.addElement(new ToDoItemXMLHelper(tdi));
} 

} 

} 

return out;
} 

 } 

//#endif 


