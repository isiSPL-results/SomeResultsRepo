
//#if 1214534725 
// Compilation Unit of /UMLEnumerationLiteralsListModel.java 
 

//#if -775478906 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 577643440 
import java.util.List;
//#endif 


//#if -2064480639 
import org.argouml.model.Model;
//#endif 


//#if -21269608 
import org.argouml.uml.ui.UMLModelElementOrderedListModel2;
//#endif 


//#if 1391771469 
public class UMLEnumerationLiteralsListModel extends 
//#if -497678003 
UMLModelElementOrderedListModel2
//#endif 

  { 

//#if 1077489649 
private static final long serialVersionUID = 4111214628991094451L;
//#endif 


//#if 529215731 
protected void moveDown(int index)
    { 

//#if 1032928583 
Object clss = getTarget();
//#endif 


//#if 1716828851 
List c = Model.getFacade().getEnumerationLiterals(clss);
//#endif 


//#if 1088618989 
if(index < c.size() - 1)//1
{ 

//#if 722050529 
Object mem = c.get(index);
//#endif 


//#if -1101161393 
Model.getCoreHelper().removeLiteral(clss, mem);
//#endif 


//#if 2130536604 
Model.getCoreHelper().addLiteral(clss, index + 1, mem);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1275593132 
public UMLEnumerationLiteralsListModel()
    { 

//#if -948335495 
super("literal");
//#endif 

} 

//#endif 


//#if 2011231580 
protected void buildModelList()
    { 

//#if 207511485 
if(Model.getFacade().isAEnumeration(getTarget()))//1
{ 

//#if -14017735 
setAllElements(
                Model.getFacade().getEnumerationLiterals(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1039300143 
@Override
    protected void moveToTop(int index)
    { 

//#if 40789595 
Object clss = getTarget();
//#endif 


//#if -189544249 
List c = Model.getFacade().getEnumerationLiterals(clss);
//#endif 


//#if 751223566 
if(index > 0)//1
{ 

//#if 183848563 
Object mem = c.get(index);
//#endif 


//#if -248551555 
Model.getCoreHelper().removeLiteral(clss, mem);
//#endif 


//#if 2143440614 
Model.getCoreHelper().addLiteral(clss, 0, mem);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 131232555 
@Override
    protected void moveToBottom(int index)
    { 

//#if -44736921 
Object clss = getTarget();
//#endif 


//#if -704502829 
List c = Model.getFacade().getEnumerationLiterals(clss);
//#endif 


//#if 10953485 
if(index < c.size() - 1)//1
{ 

//#if 279603380 
Object mem = c.get(index);
//#endif 


//#if 1958892572 
Model.getCoreHelper().removeLiteral(clss, mem);
//#endif 


//#if 1405980524 
Model.getCoreHelper().addLiteral(clss, c.size(), mem);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1808508304 
protected boolean isValidElement(Object element)
    { 

//#if 7299078 
if(Model.getFacade().isAEnumeration(getTarget()))//1
{ 

//#if 1070038380 
List literals =
                Model.getFacade().getEnumerationLiterals(getTarget());
//#endif 


//#if -155756569 
return literals.contains(element);
//#endif 

} 

//#endif 


//#if 1281371034 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

