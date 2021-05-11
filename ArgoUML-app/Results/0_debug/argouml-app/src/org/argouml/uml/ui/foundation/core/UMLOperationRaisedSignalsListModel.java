
//#if 1765812867 
// Compilation Unit of /UMLOperationRaisedSignalsListModel.java 
 

//#if -1683336637 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -908384173 
import java.util.Collection;
//#endif 


//#if 1232284350 
import org.argouml.model.Model;
//#endif 


//#if 762942502 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1052720363 
public class UMLOperationRaisedSignalsListModel extends 
//#if 573265258 
UMLModelElementListModel2
//#endif 

  { 

//#if 42058508 
protected boolean isValidElement(Object element)
    { 

//#if -522494805 
Collection signals = null;
//#endif 


//#if -228852889 
Object target = getTarget();
//#endif 


//#if -1036608836 
if(Model.getFacade().isAOperation(target))//1
{ 

//#if 1336375465 
signals = Model.getFacade().getRaisedSignals(target);
//#endif 

} 

//#endif 


//#if -1064974814 
return (signals != null) && signals.contains(element);
//#endif 

} 

//#endif 


//#if -1636744167 
public UMLOperationRaisedSignalsListModel()
    { 

//#if -1058320875 
super("signal");
//#endif 

} 

//#endif 


//#if -1910928680 
protected void buildModelList()
    { 

//#if -358600842 
if(getTarget() != null)//1
{ 

//#if 2033538938 
Collection signals = null;
//#endif 


//#if -601719178 
Object target = getTarget();
//#endif 


//#if 261357643 
if(Model.getFacade().isAOperation(target))//1
{ 

//#if 960528476 
signals = Model.getFacade().getRaisedSignals(target);
//#endif 

} 

//#endif 


//#if 1118723029 
setAllElements(signals);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

