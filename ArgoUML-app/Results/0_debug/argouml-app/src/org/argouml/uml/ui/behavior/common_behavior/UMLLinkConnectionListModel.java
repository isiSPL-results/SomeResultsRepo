
//#if -2142042275 
// Compilation Unit of /UMLLinkConnectionListModel.java 
 

//#if 630788200 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 1987339957 
import java.util.ArrayList;
//#endif 


//#if 1446091575 
import java.util.Collections;
//#endif 


//#if 591835788 
import java.util.List;
//#endif 


//#if -1560875227 
import org.argouml.model.Model;
//#endif 


//#if -1698546116 
import org.argouml.uml.ui.UMLModelElementOrderedListModel2;
//#endif 


//#if 2132790626 
public class UMLLinkConnectionListModel extends 
//#if -1585191913 
UMLModelElementOrderedListModel2
//#endif 

  { 

//#if 1089159124 
private static final long serialVersionUID = 4459749162218567926L;
//#endif 


//#if 845967093 
@Override
    protected void moveToBottom(int index)
    { 

//#if -1965851145 
Object link = getTarget();
//#endif 


//#if -345368173 
List c = new ArrayList(Model.getFacade().getConnections(link));
//#endif 


//#if 756641390 
if(index < c.size() - 1)//1
{ 

//#if 1662900642 
Object mem = c.get(index);
//#endif 


//#if -1586273524 
c.remove(mem);
//#endif 


//#if -138890185 
c.add(mem);
//#endif 


//#if -365755989 
Model.getCoreHelper().setConnections(link, c);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2024441101 
public UMLLinkConnectionListModel()
    { 

//#if -629192325 
super("linkEnd");
//#endif 

} 

//#endif 


//#if 866918098 
protected void buildModelList()
    { 

//#if 131129591 
if(getTarget() != null)//1
{ 

//#if -959805894 
setAllElements(Model.getFacade().getConnections(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 298332743 
@Override
    protected void moveToTop(int index)
    { 

//#if 1981737018 
Object link = getTarget();
//#endif 


//#if -273359274 
List c = new ArrayList(Model.getFacade().getConnections(link));
//#endif 


//#if 1216802654 
if(index > 0)//1
{ 

//#if 1517171553 
Object mem = c.get(index);
//#endif 


//#if -846838163 
c.remove(mem);
//#endif 


//#if 1285217338 
c.add(0, mem);
//#endif 


//#if 516682282 
Model.getCoreHelper().setConnections(link, c);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1804524794 
protected boolean isValidElement(Object element)
    { 

//#if -1219032409 
return Model.getFacade().getConnections(getTarget()).contains(element);
//#endif 

} 

//#endif 


//#if 355587305 
protected void moveDown(int index)
    { 

//#if -809208726 
Object link = getTarget();
//#endif 


//#if -1845751162 
List c = new ArrayList(Model.getFacade().getConnections(link));
//#endif 


//#if 1913283809 
if(index < c.size() - 1)//1
{ 

//#if 133541859 
Collections.swap(c, index, index + 1);
//#endif 


//#if -1530606767 
Model.getCoreHelper().setConnections(link, c);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

