
//#if 185139426 
// Compilation Unit of /UMLAssociationConnectionListModel.java 
 

//#if 813563981 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 192764120 
import java.util.ArrayList;
//#endif 


//#if -1274648695 
import java.util.Collection;
//#endif 


//#if -1118969159 
import java.util.Iterator;
//#endif 


//#if 1969337993 
import java.util.List;
//#endif 


//#if -937158712 
import org.argouml.model.Model;
//#endif 


//#if 872539231 
import org.argouml.uml.ui.UMLModelElementOrderedListModel2;
//#endif 


//#if 1662352992 
public class UMLAssociationConnectionListModel extends 
//#if 1547154672 
UMLModelElementOrderedListModel2
//#endif 

  { 

//#if 271170682 
private Collection others;
//#endif 


//#if -2007195718 
protected boolean isValidElement(Object o)
    { 

//#if -14703581 
return Model.getFacade().isAAssociationEnd(o)
               && Model.getFacade().getConnections(getTarget()).contains(o);
//#endif 

} 

//#endif 


//#if 1287914736 
protected void moveDown(int index)
    { 

//#if 849718641 
Object assoc = getTarget();
//#endif 


//#if 1928651410 
List c = (List) Model.getFacade().getConnections(assoc);
//#endif 


//#if 2107268343 
if(index < c.size() - 1)//1
{ 

//#if -301710667 
Object mem = c.get(index);
//#endif 


//#if 1149708068 
Model.getCoreHelper().removeConnection(assoc, mem);
//#endif 


//#if -978481127 
Model.getCoreHelper().addConnection(assoc, index + 1, mem);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -966214273 
protected void addOtherModelEventListeners(Object newTarget)
    { 

//#if 1502780924 
super.addOtherModelEventListeners(newTarget);
//#endif 


//#if -1929704337 
others = new ArrayList(Model.getFacade().getConnections(newTarget));
//#endif 


//#if 567418638 
Iterator i = others.iterator();
//#endif 


//#if 982650671 
while (i.hasNext()) //1
{ 

//#if -441391283 
Object end = i.next();
//#endif 


//#if 813191740 
Model.getPump().addModelEventListener(this, end, "name");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 747022519 
protected void removeOtherModelEventListeners(Object oldTarget)
    { 

//#if 2137782742 
super.removeOtherModelEventListeners(oldTarget);
//#endif 


//#if 1003011394 
Iterator i = others.iterator();
//#endif 


//#if 1955742587 
while (i.hasNext()) //1
{ 

//#if -1154548038 
Object end = i.next();
//#endif 


//#if 820988514 
Model.getPump().removeModelEventListener(this, end, "name");
//#endif 

} 

//#endif 


//#if -574987239 
others.clear();
//#endif 

} 

//#endif 


//#if 1855931790 
@Override
    protected void moveToTop(int index)
    { 

//#if -102855475 
Object assoc = getTarget();
//#endif 


//#if 653221870 
List c = (List) Model.getFacade().getConnections(assoc);
//#endif 


//#if -1292400972 
if(index > 0)//1
{ 

//#if 1887023538 
Object mem1 = c.get(index);
//#endif 


//#if 2132346543 
Model.getCoreHelper().removeConnection(assoc, mem1);
//#endif 


//#if -1469353946 
Model.getCoreHelper().addConnection(assoc, 0, mem1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 452510286 
@Override
    protected void moveToBottom(int index)
    { 

//#if -694559900 
Object assoc = getTarget();
//#endif 


//#if -1561758203 
List c = (List) Model.getFacade().getConnections(assoc);
//#endif 


//#if -297851740 
if(index < c.size() - 1)//1
{ 

//#if -431466520 
Object mem1 = c.get(index);
//#endif 


//#if 795487929 
Model.getCoreHelper().removeConnection(assoc, mem1);
//#endif 


//#if 2070465463 
Model.getCoreHelper().addConnection(assoc, c.size() - 1, mem1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1920348405 
public UMLAssociationConnectionListModel()
    { 

//#if 252087787 
super("connection");
//#endif 

} 

//#endif 


//#if 541631641 
protected void buildModelList()
    { 

//#if 786680995 
if(getTarget() != null)//1
{ 

//#if -200821775 
setAllElements(Model.getFacade().getConnections(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

