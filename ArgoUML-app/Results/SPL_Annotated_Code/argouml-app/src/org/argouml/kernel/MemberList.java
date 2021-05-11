// Compilation Unit of /MemberList.java 
 
package org.argouml.kernel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.argouml.uml.ProjectMemberModel;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.ProjectMemberDiagram;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.ProjectMemberTodoList;
//#endif 

class MemberList implements List<ProjectMember>
  { 
private AbstractProjectMember model;
private List<ProjectMemberDiagram> diagramMembers =
        new ArrayList<ProjectMemberDiagram>(10);
private AbstractProjectMember profileConfiguration;

//#if LOGGING 
private static final Logger LOG = Logger.getLogger(MemberList.class);
//#endif 


//#if COGNITIVE 
private AbstractProjectMember todoList;
//#endif 

public ProjectMember set(int arg0, ProjectMember arg1)
    { 
throw new UnsupportedOperationException();
} 

public int indexOf(Object arg0)
    { 
throw new UnsupportedOperationException();
} 

public synchronized ProjectMember[] toArray()
    { 
ProjectMember[] temp = new ProjectMember[size()];
int pos = 0;
if(model != null)//1
{ 
temp[pos++] = model;
} 

for (ProjectMemberDiagram d : diagramMembers) //1
{ 
temp[pos++] = d;
} 


//#if COGNITIVE 
if(todoList != null)//1
{ 
temp[pos++] = todoList;
} 

//#endif 

if(profileConfiguration != null)//1
{ 
temp[pos++] = profileConfiguration;
} 

return temp;
} 

public synchronized ProjectMember get(int i)
    { 
if(model != null)//1
{ 
if(i == 0)//1
{ 
return model;
} 

--i;
} 

if(i == diagramMembers.size())//1
{ 

//#if (CLASS || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  ACTIVITY )) && ! COGNITIVE  
return profileConfiguration;
//#endif 


//#if COGNITIVE 
if(todoList != null)//1
{ 
return todoList;
} 
else
{ 
return profileConfiguration;
} 

//#endif 

} 

if(i == (diagramMembers.size() + 1))//1
{ 
return profileConfiguration;
} 

return diagramMembers.get(i);
} 

public boolean containsAll(Collection< ? > arg0)
    { 
throw new UnsupportedOperationException();
} 

public MemberList()
    { 

//#if LOGGING 
LOG.info("Creating a member list");
//#endif 

} 

private boolean removeDiagram(ArgoDiagram d)
    { 
for (ProjectMemberDiagram pmd : diagramMembers) //1
{ 
if(pmd.getDiagram() == d)//1
{ 
pmd.remove();
diagramMembers.remove(pmd);
return true;
} 

} 


//#if LOGGING 
LOG.debug("Failed to remove diagram " + d);
//#endif 

return false;
} 


//#if COGNITIVE 
private void setTodoList(AbstractProjectMember member)
    { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.info("Setting todoList to " + member);
//#endif 

todoList = member;
} 

//#endif 

public synchronized boolean contains(Object member)
    { 

//#if COGNITIVE 
if(todoList == member)//1
{ 
return true;
} 

//#endif 

if(model == member)//1
{ 
return true;
} 

if(profileConfiguration == member)//1
{ 
return true;
} 

return diagramMembers.contains(member);
} 

public <T> T[] toArray(T[] a)
    { 
throw new UnsupportedOperationException();
} 

public synchronized boolean remove(Object member)
    { 

//#if LOGGING 
LOG.info("Removing a member");
//#endif 

if(member instanceof ArgoDiagram)//1
{ 
return removeDiagram((ArgoDiagram) member);
} 

((AbstractProjectMember) member).remove();
if(model == member)//1
{ 
model = null;
return true;
} 
else

//#if (CLASS || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  ACTIVITY )) && ! COGNITIVE  
if(profileConfiguration == member)//1
{ 

//#if ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  ACTIVITY ) && ! COGNITIVE  
LOG.info("Removing profile configuration");
//#endif 

profileConfiguration = null;
return true;
} 
else
{ 
final boolean removed = diagramMembers.remove(member);

//#if ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  ACTIVITY ) && ! COGNITIVE  
if(!removed)//1
{ 
LOG.warn("Failed to remove diagram member " + member);
} 

//#endif 

return removed;
} 

//#endif 


//#if COGNITIVE 
if(todoList == member)//1
{ 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.info("Removing todo list");
//#endif 

setTodoList(null);
return true;
} 
else

//#if COGNITIVE 
if(profileConfiguration == member)//1
{ 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.info("Removing profile configuration");
//#endif 

profileConfiguration = null;
return true;
} 
else
{ 
final boolean removed = diagramMembers.remove(member);

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
if(!removed)//1
{ 
LOG.warn("Failed to remove diagram member " + member);
} 

//#endif 

return removed;
} 

//#endif 


//#endif 


} 

public boolean addAll(int arg0, Collection< ? extends ProjectMember> arg1)
    { 
throw new UnsupportedOperationException();
} 

public synchronized int size()
    { 
int size = diagramMembers.size();
if(model != null)//1
{ 
++size;
} 


//#if COGNITIVE 
if(todoList != null)//1
{ 
++size;
} 

//#endif 

if(profileConfiguration != null)//1
{ 
++size;
} 

return size;
} 

public boolean addAll(Collection< ? extends ProjectMember> arg0)
    { 
throw new UnsupportedOperationException();
} 

public synchronized void clear()
    { 

//#if LOGGING 
LOG.info("Clearing members");
//#endif 

if(model != null)//1
{ 
model.remove();
} 


//#if COGNITIVE 
if(todoList != null)//1
{ 
todoList.remove();
} 

//#endif 

if(profileConfiguration != null)//1
{ 
profileConfiguration.remove();
} 

Iterator membersIt = diagramMembers.iterator();
while (membersIt.hasNext()) //1
{ 
((AbstractProjectMember) membersIt.next()).remove();
} 

diagramMembers.clear();
} 

public synchronized boolean add(ProjectMember member)
    { 
if(member instanceof ProjectMemberModel)//1
{ 
model = (AbstractProjectMember) member;
return true;
} 
else

//#if (CLASS || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  ACTIVITY )) && ! COGNITIVE  
if(member instanceof ProfileConfiguration)//1
{ 
profileConfiguration = (AbstractProjectMember) member;
return true;
} 
else

//#if (CLASS || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  ACTIVITY )) && ! COGNITIVE  
if(member instanceof ProjectMemberDiagram)//1
{ 
return diagramMembers.add((ProjectMemberDiagram) member);
} 

//#endif 


//#endif 


//#if COGNITIVE 
if(member instanceof ProjectMemberTodoList)//1
{ 
setTodoList((AbstractProjectMember) member);
return true;
} 
else

//#if COGNITIVE 
if(member instanceof ProfileConfiguration)//1
{ 
profileConfiguration = (AbstractProjectMember) member;
return true;
} 
else

//#if COGNITIVE 
if(member instanceof ProjectMemberDiagram)//1
{ 
return diagramMembers.add((ProjectMemberDiagram) member);
} 

//#endif 


//#endif 


//#endif 


return false;
} 

public ProjectMember remove(int arg0)
    { 
throw new UnsupportedOperationException();
} 

public void add(int arg0, ProjectMember arg1)
    { 
throw new UnsupportedOperationException();
} 

public synchronized boolean isEmpty()
    { 
return size() == 0;
} 

public synchronized ListIterator<ProjectMember> listIterator()
    { 
return buildOrderedMemberList().listIterator();
} 

public boolean retainAll(Collection< ? > arg0)
    { 
throw new UnsupportedOperationException();
} 

public synchronized Iterator<ProjectMember> iterator()
    { 
return buildOrderedMemberList().iterator();
} 

public List<ProjectMember> subList(int arg0, int arg1)
    { 
throw new UnsupportedOperationException();
} 

private List<ProjectMember> buildOrderedMemberList()
    { 
List<ProjectMember> temp =
            new ArrayList<ProjectMember>(size());
if(profileConfiguration != null)//1
{ 
temp.add(profileConfiguration);
} 

if(model != null)//1
{ 
temp.add(model);
} 

temp.addAll(diagramMembers);

//#if COGNITIVE 
if(todoList != null)//1
{ 
temp.add(todoList);
} 

//#endif 

return temp;
} 

public synchronized ListIterator<ProjectMember> listIterator(int arg0)
    { 
return buildOrderedMemberList().listIterator(arg0);
} 

public boolean removeAll(Collection< ? > arg0)
    { 
throw new UnsupportedOperationException();
} 

public int lastIndexOf(Object arg0)
    { 
throw new UnsupportedOperationException();
} 

 } 


