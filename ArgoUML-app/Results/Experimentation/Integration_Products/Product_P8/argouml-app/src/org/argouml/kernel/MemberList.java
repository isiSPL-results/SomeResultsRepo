package org.argouml.kernel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.argouml.uml.ProjectMemberModel;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.ProjectMemberDiagram;
import org.apache.log4j.Logger;
import org.argouml.uml.cognitive.ProjectMemberTodoList;
class MemberList implements List<ProjectMember>
  { 
private AbstractProjectMember model;
private List<ProjectMemberDiagram> diagramMembers =
        new ArrayList<ProjectMemberDiagram>(10);
private AbstractProjectMember profileConfiguration;
private static final Logger LOG = Logger.getLogger(MemberList.class);
private AbstractProjectMember todoList;
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
if(todoList != null)//1
{ 
temp[pos++] = todoList;
} 
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
if(todoList != null)//1
{ 
return todoList;
} 
else
{ 
return profileConfiguration;
} 
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
LOG.info("Creating a member list");
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
LOG.debug("Failed to remove diagram " + d);
return false;
} 
private void setTodoList(AbstractProjectMember member)
    { 
LOG.info("Setting todoList to " + member);
todoList = member;
} 
public synchronized boolean contains(Object member)
    { 
if(todoList == member)//1
{ 
return true;
} 
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
LOG.info("Removing a member");
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
if(todoList == member)//1
{ 
LOG.info("Removing todo list");
setTodoList(null);
return true;
} 
else
if(profileConfiguration == member)//1
{ 
LOG.info("Removing profile configuration");
profileConfiguration = null;
return true;
} 
else
{ 
final boolean removed = diagramMembers.remove(member);
if(!removed)//1
{ 
LOG.warn("Failed to remove diagram member " + member);
} 
return removed;
} 
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
if(todoList != null)//1
{ 
++size;
} 
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
LOG.info("Clearing members");
if(model != null)//1
{ 
model.remove();
} 
if(todoList != null)//1
{ 
todoList.remove();
} 
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
if(member instanceof ProjectMemberTodoList)//1
{ 
setTodoList((AbstractProjectMember) member);
return true;
} 
else
if(member instanceof ProfileConfiguration)//1
{ 
profileConfiguration = (AbstractProjectMember) member;
return true;
} 
else
if(member instanceof ProjectMemberDiagram)//1
{ 
return diagramMembers.add((ProjectMemberDiagram) member);
} 
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
if(todoList != null)//1
{ 
temp.add(todoList);
} 
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
