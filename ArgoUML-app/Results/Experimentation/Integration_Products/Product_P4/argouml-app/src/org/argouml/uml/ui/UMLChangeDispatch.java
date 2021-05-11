package org.argouml.uml.ui;
import java.awt.Component;
import java.awt.Container;
public class UMLChangeDispatch implements Runnable
,UMLUserInterfaceComponent
  { 
private int eventType;
private Container container;
private Object target;
public static final int TARGET_CHANGED_ADD = -1;
public static final int TARGET_CHANGED = 0;
public static final int TARGET_REASSERTED = 7;
private void synchronizedDispatch(Container cont)
    { 
if(target == null)//1
{ 
throw new IllegalStateException("Target may not be null in "
                                            + "synchronized dispatch");
} 
synchronized (target) //1
{ 
dispatch(cont);
} 
} 
public void run()
    { 
if(target != null)//1
{ 
synchronizedDispatch(container);
} 
else
{ 
dispatch(container);
} 
} 
public void targetReasserted()
    { 
eventType = 7;
} 
private void dispatch(Container theAWTContainer)
    { 
int count = theAWTContainer.getComponentCount();
Component component;
for (int i = 0; i < count; i++) //1
{ 
component = theAWTContainer.getComponent(i);
if(component instanceof Container)//1
{ 
dispatch((Container) component);
} 
if(component instanceof UMLUserInterfaceComponent
                    && component.isVisible())//1
{ 
switch(eventType) //1
{ 
case TARGET_CHANGED_ADD://1

case TARGET_CHANGED://1

((UMLUserInterfaceComponent) component).targetChanged();
break;


case TARGET_REASSERTED://1

((UMLUserInterfaceComponent) component).targetReasserted();
break;


} 
} 
} 
} 
public void targetChanged()
    { 
eventType = 0;
} 
public UMLChangeDispatch(Container uic, int et)
    { 
synchronized (uic) //1
{ 
container = uic;
eventType = et;
if(uic instanceof PropPanel)//1
{ 
target = ((PropPanel) uic).getTarget();
} 
} 
} 

 } 
