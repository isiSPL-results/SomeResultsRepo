
//#if 1986637289 
// Compilation Unit of /UMLComboBox2.java 
 

//#if 990607017 
package org.argouml.uml.ui;
//#endif 


//#if -822076669 
import java.awt.event.ActionEvent;
//#endif 


//#if 84007801 
import javax.swing.Action;
//#endif 


//#if 2000773632 
import javax.swing.JComboBox;
//#endif 


//#if -1583839707 
import org.apache.log4j.Logger;
//#endif 


//#if -310504600 
import org.argouml.ui.LookAndFeelMgr;
//#endif 


//#if -1634766211 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -1935308053 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if 1495971071 
import org.argouml.ui.targetmanager.TargettableModelView;
//#endif 


//#if 1259384177 
public class UMLComboBox2 extends 
//#if 497380576 
JComboBox
//#endif 

 implements 
//#if -1771724168 
TargettableModelView
//#endif 

, 
//#if 1551621132 
TargetListener
//#endif 

  { 

//#if -521443283 
public void actionPerformed(ActionEvent arg0)
    { 

//#if 1211810285 
int i = getSelectedIndex();
//#endif 


//#if -631477340 
if(i >= 0)//1
{ 

//#if 1629542755 
doIt(arg0);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1845029564 
protected void doIt(ActionEvent event) { 
} 

//#endif 


//#if -1393164370 
public UMLComboBox2(UMLComboBoxModel2 arg0, Action action)
    { 

//#if -1627631034 
this(arg0, action, true);
//#endif 

} 

//#endif 


//#if 882579888 
public void targetRemoved(TargetEvent e)
    { 

//#if 88624821 
removeActionListener(this);
//#endif 

} 

//#endif 


//#if -1805720171 
@Deprecated
    protected UMLComboBox2(UMLComboBoxModel2 model)
    { 

//#if -915272955 
super(model);
//#endif 


//#if -2135516705 
setFont(LookAndFeelMgr.getInstance().getStandardFont());
//#endif 


//#if 1199812118 
addActionListener(this);
//#endif 


//#if 184517594 
addPopupMenuListener(model);
//#endif 

} 

//#endif 


//#if 1589381392 
public void targetAdded(TargetEvent e)
    { 

//#if -963566573 
if(e.getNewTarget() != getTarget())//1
{ 

//#if 600414939 
removeActionListener(this);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1481031602 
public void targetSet(TargetEvent e)
    { 

//#if -161232572 
addActionListener(this);
//#endif 

} 

//#endif 


//#if 2117782469 
public UMLComboBox2(UMLComboBoxModel2 model, Action action,
                        boolean showIcon)
    { 

//#if -1803382589 
super(model);
//#endif 


//#if -371512991 
setFont(LookAndFeelMgr.getInstance().getStandardFont());
//#endif 


//#if 1421819184 
addActionListener(action);
//#endif 


//#if 1082066474 
setRenderer(new UMLListCellRenderer2(showIcon));
//#endif 


//#if -260634020 
addPopupMenuListener(model);
//#endif 

} 

//#endif 


//#if 1946123758 
public TargetListener getTargettableModel()
    { 

//#if 89906345 
return (TargetListener) getModel();
//#endif 

} 

//#endif 


//#if 570564889 
public Object getTarget()
    { 

//#if -208540651 
return ((UMLComboBoxModel2) getModel()).getTarget();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

