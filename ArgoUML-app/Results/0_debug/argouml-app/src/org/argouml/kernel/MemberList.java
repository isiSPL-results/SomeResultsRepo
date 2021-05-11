
//#if 137356886 
// Compilation Unit of /MemberList.java 
 

//#if -827246734 
package org.argouml.kernel;
//#endif 


//#if 1474283488 
import java.util.ArrayList;
//#endif 


//#if -202253951 
import java.util.Collection;
//#endif 


//#if 584938161 
import java.util.Iterator;
//#endif 


//#if 526910081 
import java.util.List;
//#endif 


//#if 1265861043 
import java.util.ListIterator;
//#endif 


//#if -101835982 
import org.argouml.uml.ProjectMemberModel;
//#endif 


//#if -1947980657 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -1111218451 
import org.argouml.uml.diagram.ProjectMemberDiagram;
//#endif 


//#if -1039624355 
import org.apache.log4j.Logger;
//#endif 


//#if -884813557 
import org.argouml.uml.cognitive.ProjectMemberTodoList;
//#endif 


//#if -450717735 
class MemberList implements 
//#if -1292714613 
List<ProjectMember>
//#endif 

  { 

//#if -1660108642 
private AbstractProjectMember model;
//#endif 


//#if -167164530 
private List<ProjectMemberDiagram> diagramMembers =
        new ArrayList<ProjectMemberDiagram>(10);
//#endif 


//#if -1518901214 
private AbstractProjectMember profileConfiguration;
//#endif 


//#if 1578487944 
private static final Logger LOG = Logger.getLogger(MemberList.class);
//#endif 


//#if 742803659 
private AbstractProjectMember todoList;
//#endif 


//#if 693785392 
public ProjectMember set(int arg0, ProjectMember arg1)
    { 

//#if -1073265373 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 884024041 
public int indexOf(Object arg0)
    { 

//#if -999475502 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 18491845 
public synchronized ProjectMember[] toArray()
    { 

//#if 1375284807 
ProjectMember[] temp = new ProjectMember[size()];
//#endif 


//#if -2072060042 
int pos = 0;
//#endif 


//#if -448172938 
if(model != null)//1
{ 

//#if 1371977529 
temp[pos++] = model;
//#endif 

} 

//#endif 


//#if -1343144304 
for (ProjectMemberDiagram d : diagramMembers) //1
{ 

//#if -1813704454 
temp[pos++] = d;
//#endif 

} 

//#endif 


//#if -1026786099 
if(todoList != null)//1
{ 

//#if 747401666 
temp[pos++] = todoList;
//#endif 

} 

//#endif 


//#if 489874518 
if(profileConfiguration != null)//1
{ 

//#if 1710074944 
temp[pos++] = profileConfiguration;
//#endif 

} 

//#endif 


//#if -1502974582 
return temp;
//#endif 

} 

//#endif 


//#if 862777221 
public synchronized ProjectMember get(int i)
    { 

//#if -1009434109 
if(model != null)//1
{ 

//#if 1922364035 
if(i == 0)//1
{ 

//#if -850173503 
return model;
//#endif 

} 

//#endif 


//#if -640169623 
--i;
//#endif 

} 

//#endif 


//#if -1518625830 
if(i == diagramMembers.size())//1
{ 

//#if 1109868119 
return profileConfiguration;
//#endif 


//#if -1492976909 
if(todoList != null)//1
{ 

//#if -1624319203 
return todoList;
//#endif 

} 
else
{ 

//#if -1179845659 
return profileConfiguration;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 359146993 
if(i == (diagramMembers.size() + 1))//1
{ 

//#if 896935239 
return profileConfiguration;
//#endif 

} 

//#endif 


//#if 2069960299 
return diagramMembers.get(i);
//#endif 

} 

//#endif 


//#if -709782087 
public boolean containsAll(Collection< ? > arg0)
    { 

//#if 65314952 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if -1210156288 
public MemberList()
    { 

//#if 1213725439 
LOG.info("Creating a member list");
//#endif 

} 

//#endif 


//#if 1018254051 
private boolean removeDiagram(ArgoDiagram d)
    { 

//#if -342651471 
for (ProjectMemberDiagram pmd : diagramMembers) //1
{ 

//#if -1082444389 
if(pmd.getDiagram() == d)//1
{ 

//#if -250631524 
pmd.remove();
//#endif 


//#if -1596622166 
diagramMembers.remove(pmd);
//#endif 


//#if 262525418 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1964089800 
LOG.debug("Failed to remove diagram " + d);
//#endif 


//#if 1187094233 
return false;
//#endif 

} 

//#endif 


//#if 1561162969 
private void setTodoList(AbstractProjectMember member)
    { 

//#if 146129478 
LOG.info("Setting todoList to " + member);
//#endif 


//#if 1306702164 
todoList = member;
//#endif 

} 

//#endif 


//#if 600101556 
public synchronized boolean contains(Object member)
    { 

//#if -1402342567 
if(todoList == member)//1
{ 

//#if -1288636432 
return true;
//#endif 

} 

//#endif 


//#if -717638472 
if(model == member)//1
{ 

//#if -933172560 
return true;
//#endif 

} 

//#endif 


//#if 69608738 
if(profileConfiguration == member)//1
{ 

//#if 2124430173 
return true;
//#endif 

} 

//#endif 


//#if 320768469 
return diagramMembers.contains(member);
//#endif 

} 

//#endif 


//#if -229612195 
public <T> T[] toArray(T[] a)
    { 

//#if -1282641780 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 1007826841 
public synchronized boolean remove(Object member)
    { 

//#if 1307296573 
LOG.info("Removing a member");
//#endif 


//#if 518251778 
if(member instanceof ArgoDiagram)//1
{ 

//#if 358472623 
return removeDiagram((ArgoDiagram) member);
//#endif 

} 

//#endif 


//#if 1192001422 
((AbstractProjectMember) member).remove();
//#endif 


//#if -504230447 
if(model == member)//1
{ 

//#if 1546382147 
model = null;
//#endif 


//#if 225765024 
return true;
//#endif 

} 
else

//#if 363130182 
if(profileConfiguration == member)//1
{ 

//#if -906472472 
LOG.info("Removing profile configuration");
//#endif 


//#if 479618032 
profileConfiguration = null;
//#endif 


//#if 2132828241 
return true;
//#endif 

} 
else
{ 

//#if -1531667983 
final boolean removed = diagramMembers.remove(member);
//#endif 


//#if 204706168 
if(!removed)//1
{ 

//#if 875058249 
LOG.warn("Failed to remove diagram member " + member);
//#endif 

} 

//#endif 


//#if -1206103003 
return removed;
//#endif 

} 

//#endif 


//#if -925314691 
if(todoList == member)//1
{ 

//#if -808505158 
LOG.info("Removing todo list");
//#endif 


//#if -339423426 
setTodoList(null);
//#endif 


//#if 70538042 
return true;
//#endif 

} 
else

//#if 1628951603 
if(profileConfiguration == member)//1
{ 

//#if -304888409 
LOG.info("Removing profile configuration");
//#endif 


//#if 496208913 
profileConfiguration = null;
//#endif 


//#if 757471824 
return true;
//#endif 

} 
else
{ 

//#if -362461502 
final boolean removed = diagramMembers.remove(member);
//#endif 


//#if 842562119 
if(!removed)//1
{ 

//#if -105223764 
LOG.warn("Failed to remove diagram member " + member);
//#endif 

} 

//#endif 


//#if 1585419638 
return removed;
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 176592821 
public boolean addAll(int arg0, Collection< ? extends ProjectMember> arg1)
    { 

//#if -994233521 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if -1828829898 
public synchronized int size()
    { 

//#if -1393975495 
int size = diagramMembers.size();
//#endif 


//#if 2010321092 
if(model != null)//1
{ 

//#if -1474554687 
++size;
//#endif 

} 

//#endif 


//#if -2108437057 
if(todoList != null)//1
{ 

//#if -1854780290 
++size;
//#endif 

} 

//#endif 


//#if 874404424 
if(profileConfiguration != null)//1
{ 

//#if -187267946 
++size;
//#endif 

} 

//#endif 


//#if -1493774737 
return size;
//#endif 

} 

//#endif 


//#if 169988243 
public boolean addAll(Collection< ? extends ProjectMember> arg0)
    { 

//#if 2094184866 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if -2045267329 
public synchronized void clear()
    { 

//#if 703660790 
LOG.info("Clearing members");
//#endif 


//#if -251544451 
if(model != null)//1
{ 

//#if 499759528 
model.remove();
//#endif 

} 

//#endif 


//#if -1602921626 
if(todoList != null)//1
{ 

//#if 329463285 
todoList.remove();
//#endif 

} 

//#endif 


//#if -355621521 
if(profileConfiguration != null)//1
{ 

//#if 669046165 
profileConfiguration.remove();
//#endif 

} 

//#endif 


//#if 1625582015 
Iterator membersIt = diagramMembers.iterator();
//#endif 


//#if 808839265 
while (membersIt.hasNext()) //1
{ 

//#if 1478514345 
((AbstractProjectMember) membersIt.next()).remove();
//#endif 

} 

//#endif 


//#if -1358866495 
diagramMembers.clear();
//#endif 

} 

//#endif 


//#if -701776176 
public synchronized boolean add(ProjectMember member)
    { 

//#if -1032057615 
if(member instanceof ProjectMemberModel)//1
{ 

//#if 1325574897 
model = (AbstractProjectMember) member;
//#endif 


//#if -1427889055 
return true;
//#endif 

} 
else

//#if 2141419795 
if(member instanceof ProfileConfiguration)//1
{ 

//#if -118687847 
profileConfiguration = (AbstractProjectMember) member;
//#endif 


//#if 797354597 
return true;
//#endif 

} 
else

//#if -617925562 
if(member instanceof ProjectMemberDiagram)//1
{ 

//#if 1688394970 
return diagramMembers.add((ProjectMemberDiagram) member);
//#endif 

} 

//#endif 


//#endif 


//#if -2135598143 
if(member instanceof ProjectMemberTodoList)//1
{ 

//#if 1689732095 
setTodoList((AbstractProjectMember) member);
//#endif 


//#if 2101819922 
return true;
//#endif 

} 
else

//#if 347871164 
if(member instanceof ProfileConfiguration)//1
{ 

//#if -1760511489 
profileConfiguration = (AbstractProjectMember) member;
//#endif 


//#if -2064037173 
return true;
//#endif 

} 
else

//#if 215523622 
if(member instanceof ProjectMemberDiagram)//1
{ 

//#if -1151904667 
return diagramMembers.add((ProjectMemberDiagram) member);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if -936437722 
return false;
//#endif 

} 

//#endif 


//#if -238848872 
public ProjectMember remove(int arg0)
    { 

//#if -670778151 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 955530016 
public void add(int arg0, ProjectMember arg1)
    { 

//#if 1975934018 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 707586039 
public synchronized boolean isEmpty()
    { 

//#if -687892050 
return size() == 0;
//#endif 

} 

//#endif 


//#if 195621837 
public synchronized ListIterator<ProjectMember> listIterator()
    { 

//#if -412954839 
return buildOrderedMemberList().listIterator();
//#endif 

} 

//#endif 


//#if 1811147871 
public boolean retainAll(Collection< ? > arg0)
    { 

//#if 1285209000 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 1047946253 
public synchronized Iterator<ProjectMember> iterator()
    { 

//#if -1060493683 
return buildOrderedMemberList().iterator();
//#endif 

} 

//#endif 


//#if -1480583282 
public List<ProjectMember> subList(int arg0, int arg1)
    { 

//#if 551528848 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if -591114308 
private List<ProjectMember> buildOrderedMemberList()
    { 

//#if -200048792 
List<ProjectMember> temp =
            new ArrayList<ProjectMember>(size());
//#endif 


//#if -1596365465 
if(profileConfiguration != null)//1
{ 

//#if -1692069151 
temp.add(profileConfiguration);
//#endif 

} 

//#endif 


//#if -1583543419 
if(model != null)//1
{ 

//#if -477788834 
temp.add(model);
//#endif 

} 

//#endif 


//#if -1278292446 
temp.addAll(diagramMembers);
//#endif 


//#if -1981329570 
if(todoList != null)//1
{ 

//#if -478564164 
temp.add(todoList);
//#endif 

} 

//#endif 


//#if -1442901669 
return temp;
//#endif 

} 

//#endif 


//#if 1928836124 
public synchronized ListIterator<ProjectMember> listIterator(int arg0)
    { 

//#if -1258518392 
return buildOrderedMemberList().listIterator(arg0);
//#endif 

} 

//#endif 


//#if -906184034 
public boolean removeAll(Collection< ? > arg0)
    { 

//#if -1885382195 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if -1188448141 
public int lastIndexOf(Object arg0)
    { 

//#if -1454382405 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

