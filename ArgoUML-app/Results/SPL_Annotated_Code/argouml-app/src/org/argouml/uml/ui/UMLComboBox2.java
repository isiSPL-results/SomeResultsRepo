// Compilation Unit of /UMLComboBox2.java 
 
package org.argouml.uml.ui;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JComboBox;
import org.apache.log4j.Logger;
import org.argouml.ui.LookAndFeelMgr;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetListener;
import org.argouml.ui.targetmanager.TargettableModelView;
public class UMLComboBox2 extends JComboBox
 implements TargettableModelView
, TargetListener
  { 
public void actionPerformed(ActionEvent arg0)
    { 
int i = getSelectedIndex();
if(i >= 0)//1
{ 
doIt(arg0);
} 

} 

protected void doIt(ActionEvent event) { 
} 

public UMLComboBox2(UMLComboBoxModel2 arg0, Action action)
    { 
this(arg0, action, true);
} 

public void targetRemoved(TargetEvent e)
    { 
removeActionListener(this);
} 

@Deprecated
    protected UMLComboBox2(UMLComboBoxModel2 model)
    { 
super(model);
setFont(LookAndFeelMgr.getInstance().getStandardFont());
addActionListener(this);
addPopupMenuListener(model);
} 

public void targetAdded(TargetEvent e)
    { 
if(e.getNewTarget() != getTarget())//1
{ 
removeActionListener(this);
} 

} 

public void targetSet(TargetEvent e)
    { 
addActionListener(this);
} 

public UMLComboBox2(UMLComboBoxModel2 model, Action action,
                        boolean showIcon)
    { 
super(model);
setFont(LookAndFeelMgr.getInstance().getStandardFont());
addActionListener(action);
setRenderer(new UMLListCellRenderer2(showIcon));
addPopupMenuListener(model);
} 

public TargetListener getTargettableModel()
    { 
return (TargetListener) getModel();
} 

public Object getTarget()
    { 
return ((UMLComboBoxModel2) getModel()).getTarget();
} 

 } 


