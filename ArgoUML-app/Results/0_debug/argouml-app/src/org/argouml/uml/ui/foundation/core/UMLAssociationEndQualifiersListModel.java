
//#if 1330016188 
// Compilation Unit of /UMLAssociationEndQualifiersListModel.java 
 

//#if 51314265 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 21006589 
import java.util.List;
//#endif 


//#if -1508325420 
import org.argouml.model.Model;
//#endif 


//#if 952978027 
import org.argouml.uml.ui.UMLModelElementOrderedListModel2;
//#endif 


//#if 313704296 
public class UMLAssociationEndQualifiersListModel extends 
//#if -1806254250 
UMLModelElementOrderedListModel2
//#endif 

  { 

//#if 487003594 
protected void moveDown(int index)
    { 

//#if -1628363076 
Object assocEnd = getTarget();
//#endif 


//#if -711848630 
List c = Model.getFacade().getQualifiers(assocEnd);
//#endif 


//#if -103363265 
if(index < c.size() - 1)//1
{ 

//#if 1739712383 
Object mem = c.get(index);
//#endif 


//#if -152135085 
Model.getCoreHelper().removeQualifier(assocEnd, mem);
//#endif 


//#if 519098076 
Model.getCoreHelper().addQualifier(assocEnd, index + 1, mem);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 31207751 
public UMLAssociationEndQualifiersListModel()
    { 

//#if -1230038377 
super("qualifier");
//#endif 

} 

//#endif 


//#if 487493096 
@Override
    protected void moveToTop(int index)
    { 

//#if -2105407575 
Object clss = getTarget();
//#endif 


//#if 841019517 
List c = Model.getFacade().getQualifiers(clss);
//#endif 


//#if 745525760 
if(index > 0)//1
{ 

//#if 880481203 
Object mem = c.get(index);
//#endif 


//#if 1190944610 
Model.getCoreHelper().removeQualifier(clss, mem);
//#endif 


//#if -175231285 
Model.getCoreHelper().addQualifier(clss, 0, mem);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1124950964 
@Override
    protected void moveToBottom(int index)
    { 

//#if -739626001 
Object assocEnd = getTarget();
//#endif 


//#if 1029131767 
List c = Model.getFacade().getQualifiers(assocEnd);
//#endif 


//#if 1223977970 
if(index < c.size() - 1)//1
{ 

//#if 74962208 
Object mem = c.get(index);
//#endif 


//#if 868465746 
Model.getCoreHelper().removeQualifier(assocEnd, mem);
//#endif 


//#if 1054245826 
Model.getCoreHelper().addQualifier(assocEnd, c.size() - 1, mem);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1139680243 
protected void buildModelList()
    { 

//#if 211876756 
if(getTarget() != null)//1
{ 

//#if 1663341458 
setAllElements(Model.getFacade().getQualifiers(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -287951212 
protected boolean isValidElement(Object o)
    { 

//#if 295842967 
return Model.getFacade().isAAttribute(o)
               && Model.getFacade().getQualifiers(getTarget()).contains(o);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

