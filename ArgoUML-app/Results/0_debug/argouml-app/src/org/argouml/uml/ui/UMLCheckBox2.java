
//#if -439637391 
// Compilation Unit of /UMLCheckBox2.java 
 

//#if -11297880 
package org.argouml.uml.ui;
//#endif 


//#if 191045530 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -643568466 
import java.beans.PropertyChangeListener;
//#endif 


//#if 1991350938 
import javax.swing.Action;
//#endif 


//#if -852055623 
import javax.swing.JCheckBox;
//#endif 


//#if 2035760919 
import org.argouml.model.Model;
//#endif 


//#if 1891059111 
import org.argouml.ui.LookAndFeelMgr;
//#endif 


//#if -1531268386 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if 1876845290 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if 345797134 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 597423722 
public abstract class UMLCheckBox2 extends 
//#if -1379609928 
JCheckBox
//#endif 

 implements 
//#if 194233274 
TargetListener
//#endif 

, 
//#if 752878350 
PropertyChangeListener
//#endif 

  { 

//#if 425739834 
private Object checkBoxTarget;
//#endif 


//#if 1196654946 
private String propertySetName;
//#endif 


//#if 71249220 
public void targetSet(TargetEvent e)
    { 

//#if -1976864893 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 748580418 
public void targetRemoved(TargetEvent e)
    { 

//#if -860478472 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -288362768 
public abstract void buildModel();
//#endif 


//#if -296789470 
public void targetAdded(TargetEvent e)
    { 

//#if 1845812589 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -1405092851 
public UMLCheckBox2(String text, Action a, String name)
    { 

//#if 284173638 
super(text);
//#endif 


//#if -2072146768 
setFont(LookAndFeelMgr.getInstance().getStandardFont());
//#endif 


//#if 2035817169 
propertySetName = name;
//#endif 


//#if -907341796 
addActionListener(a);
//#endif 


//#if -575399466 
setActionCommand((String) a.getValue(Action.ACTION_COMMAND_KEY));
//#endif 

} 

//#endif 


//#if -876020437 
public Object getTarget()
    { 

//#if -1528160373 
return checkBoxTarget;
//#endif 

} 

//#endif 


//#if 221485098 
public void propertyChange(PropertyChangeEvent evt)
    { 

//#if -177759643 
buildModel();
//#endif 

} 

//#endif 


//#if -2083544014 
public void setTarget(Object target)
    { 

//#if 955022897 
target = target instanceof Fig ? ((Fig) target).getOwner() : target;
//#endif 


//#if 1674515171 
if(Model.getFacade().isAUMLElement(checkBoxTarget))//1
{ 

//#if -301200806 
Model.getPump().removeModelEventListener(
                this, checkBoxTarget, propertySetName);
//#endif 

} 

//#endif 


//#if -1039447930 
if(Model.getFacade().isAUMLElement(target))//1
{ 

//#if -142461714 
checkBoxTarget = target;
//#endif 


//#if -1692690435 
Model.getPump().addModelEventListener(
                this, checkBoxTarget, propertySetName);
//#endif 


//#if 37819794 
buildModel();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

