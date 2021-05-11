
//#if 1073917646 
// Compilation Unit of /UMLChangeDispatch.java 
 

//#if -1953680866 
package org.argouml.uml.ui;
//#endif 


//#if 720695873 
import java.awt.Component;
//#endif 


//#if 1313387325 
import java.awt.Container;
//#endif 


//#if -235276029 
public class UMLChangeDispatch implements 
//#if -1375763958 
Runnable
//#endif 

, 
//#if 2083222 
UMLUserInterfaceComponent
//#endif 

  { 

//#if -892672608 
private int eventType;
//#endif 


//#if 1308551717 
private Container container;
//#endif 


//#if -1745969355 
private Object target;
//#endif 


//#if 571258303 
public static final int TARGET_CHANGED_ADD = -1;
//#endif 


//#if -1371923483 
public static final int TARGET_CHANGED = 0;
//#endif 


//#if -1535861320 
public static final int TARGET_REASSERTED = 7;
//#endif 


//#if 315734598 
private void synchronizedDispatch(Container cont)
    { 

//#if -170686644 
if(target == null)//1
{ 

//#if 829296337 
throw new IllegalStateException("Target may not be null in "
                                            + "synchronized dispatch");
//#endif 

} 

//#endif 


//#if 1156653518 
synchronized (target) //1
{ 

//#if -828698625 
dispatch(cont);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -279172094 
public void run()
    { 

//#if 763264522 
if(target != null)//1
{ 

//#if -91411901 
synchronizedDispatch(container);
//#endif 

} 
else
{ 

//#if 700187593 
dispatch(container);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1557162324 
public void targetReasserted()
    { 

//#if -1820105678 
eventType = 7;
//#endif 

} 

//#endif 


//#if 1906761938 
private void dispatch(Container theAWTContainer)
    { 

//#if 755309031 
int count = theAWTContainer.getComponentCount();
//#endif 


//#if 1204096217 
Component component;
//#endif 


//#if 1899156453 
for (int i = 0; i < count; i++) //1
{ 

//#if 1257960630 
component = theAWTContainer.getComponent(i);
//#endif 


//#if 898218665 
if(component instanceof Container)//1
{ 

//#if -1036220270 
dispatch((Container) component);
//#endif 

} 

//#endif 


//#if -813482915 
if(component instanceof UMLUserInterfaceComponent
                    && component.isVisible())//1
{ 

//#if -1512867674 
switch(eventType) //1
{ 
case TARGET_CHANGED_ADD://1

case TARGET_CHANGED://1


//#if 1505394976 
((UMLUserInterfaceComponent) component).targetChanged();
//#endif 


//#if -156786353 
break;

//#endif 


case TARGET_REASSERTED://1


//#if 1688568690 
((UMLUserInterfaceComponent) component).targetReasserted();
//#endif 


//#if 545346105 
break;

//#endif 


} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -149535782 
public void targetChanged()
    { 

//#if 1097574457 
eventType = 0;
//#endif 

} 

//#endif 


//#if -581656215 
public UMLChangeDispatch(Container uic, int et)
    { 

//#if 502928726 
synchronized (uic) //1
{ 

//#if -867838236 
container = uic;
//#endif 


//#if -1670590393 
eventType = et;
//#endif 


//#if -1097358691 
if(uic instanceof PropPanel)//1
{ 

//#if 1470593596 
target = ((PropPanel) uic).getTarget();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

