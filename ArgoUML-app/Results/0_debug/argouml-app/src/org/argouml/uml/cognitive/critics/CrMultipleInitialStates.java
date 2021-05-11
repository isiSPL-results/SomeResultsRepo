
//#if -1461959129 
// Compilation Unit of /CrMultipleInitialStates.java 
 

//#if -1654924089 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -54266030 
import java.util.Collection;
//#endif 


//#if -1543878542 
import java.util.HashSet;
//#endif 


//#if -588441660 
import java.util.Set;
//#endif 


//#if 1032084460 
import org.apache.log4j.Logger;
//#endif 


//#if 549835604 
import org.argouml.cognitive.Designer;
//#endif 


//#if 894108851 
import org.argouml.cognitive.ListSet;
//#endif 


//#if -970150042 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1415346337 
import org.argouml.model.Model;
//#endif 


//#if 1234607265 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 1018835844 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if 1694482398 
public class CrMultipleInitialStates extends 
//#if 58747553 
CrUML
//#endif 

  { 

//#if 139661909 
private static final Logger LOG =
        Logger.getLogger(CrMultipleInitialStates.class);
//#endif 


//#if 1824057477 
private static final long serialVersionUID = 4151051235876065649L;
//#endif 


//#if 690197435 
public CrMultipleInitialStates()
    { 

//#if -678941545 
setupHeadAndDesc();
//#endif 


//#if -129917583 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if 858558817 
addTrigger("parent");
//#endif 


//#if 1960669175 
addTrigger("kind");
//#endif 

} 

//#endif 


//#if -310222131 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1573275960 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -261938096 
ret.add(Model.getMetaTypes().getPseudostate());
//#endif 


//#if 129871680 
return ret;
//#endif 

} 

//#endif 


//#if 1385218955 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if 1848887952 
if(!isActive())//1
{ 

//#if -339015225 
return false;
//#endif 

} 

//#endif 


//#if -641735109 
ListSet offs = i.getOffenders();
//#endif 


//#if 168009754 
Object dm = offs.get(0);
//#endif 


//#if -2030811260 
ListSet newOffs = computeOffenders(dm);
//#endif 


//#if 1785857907 
boolean res = offs.equals(newOffs);
//#endif 


//#if -1759502036 
return res;
//#endif 

} 

//#endif 


//#if -1246144836 
protected ListSet computeOffenders(Object ps)
    { 

//#if -1254661097 
ListSet offs = new ListSet(ps);
//#endif 


//#if 1620508335 
Object cs = Model.getFacade().getContainer(ps);
//#endif 


//#if -783026531 
if(cs == null)//1
{ 

//#if -1345980330 
LOG.debug("null parent in still valid");
//#endif 


//#if 1796981752 
return offs;
//#endif 

} 

//#endif 


//#if -649174930 
Collection peers = Model.getFacade().getSubvertices(cs);
//#endif 


//#if 385709933 
for (Object sv : peers) //1
{ 

//#if 938206748 
if(Model.getFacade().isAPseudostate(sv)
                    && Model.getFacade().equalsPseudostateKind(
                        Model.getFacade().getKind(sv),
                        Model.getPseudostateKind().getInitial()))//1
{ 

//#if 894097203 
offs.add(sv);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 909597434 
return offs;
//#endif 

} 

//#endif 


//#if 348569605 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 856139131 
ListSet offs = computeOffenders(dm);
//#endif 


//#if 1269177281 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if 303965366 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1597278325 
if(!(Model.getFacade().isAPseudostate(dm)))//1
{ 

//#if -1179271339 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -860708562 
Object k = Model.getFacade().getKind(dm);
//#endif 


//#if 1632488518 
if(!Model.getFacade().equalsPseudostateKind(
                    k,
                    Model.getPseudostateKind().getInitial()))//1
{ 

//#if 1963640059 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -211365142 
Object cs = Model.getFacade().getContainer(dm);
//#endif 


//#if -1633961144 
if(cs == null)//1
{ 

//#if 2085091639 
LOG.debug("null parent state");
//#endif 


//#if -1593389366 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 2111547475 
int initialStateCount = 0;
//#endif 


//#if 2051558617 
Collection peers = Model.getFacade().getSubvertices(cs);
//#endif 


//#if -442880926 
for (Object sv : peers) //1
{ 

//#if 748977240 
if(Model.getFacade().isAPseudostate(sv)
                    && Model.getFacade().
                    equalsPseudostateKind(
                        Model.getFacade().getKind(sv),
                        Model.getPseudostateKind().getInitial()))//1
{ 

//#if 186478047 
initialStateCount++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1284225108 
if(initialStateCount > 1)//1
{ 

//#if 1027162197 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -1970114264 
return NO_PROBLEM;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

