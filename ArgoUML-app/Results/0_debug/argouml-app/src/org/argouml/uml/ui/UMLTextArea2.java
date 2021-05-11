
//#if 2036419758 
// Compilation Unit of /UMLTextArea2.java 
 

//#if 1778365257 
package org.argouml.uml.ui;
//#endif 


//#if 1238083929 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1624872591 
import java.beans.PropertyChangeListener;
//#endif 


//#if -436089789 
import javax.swing.JTextArea;
//#endif 


//#if -2100537154 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if -1538848760 
import org.argouml.ui.LookAndFeelMgr;
//#endif 


//#if 265676683 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if -2054481505 
import org.argouml.ui.targetmanager.TargettableModelView;
//#endif 


//#if -2120250764 

//#if -1839946497 
@UmlModelMutator
//#endif 

public class UMLTextArea2 extends 
//#if -375482542 
JTextArea
//#endif 

 implements 
//#if -1260646645 
PropertyChangeListener
//#endif 

, 
//#if -691439901 
TargettableModelView
//#endif 

  { 

//#if 1742145835 
private static final long serialVersionUID = -9172093001792636086L;
//#endif 


//#if 1913591319 
public UMLTextArea2(UMLDocument doc)
    { 

//#if 1246988388 
super(doc);
//#endif 


//#if 1312832335 
setFont(LookAndFeelMgr.getInstance().getStandardFont());
//#endif 


//#if 1262802836 
addCaretListener(ActionCopy.getInstance());
//#endif 


//#if -523624605 
addCaretListener(ActionCut.getInstance());
//#endif 


//#if 1379015028 
addCaretListener(ActionPaste.getInstance());
//#endif 


//#if -165068727 
addFocusListener(ActionPaste.getInstance());
//#endif 

} 

//#endif 


//#if 1475160675 
public TargetListener getTargettableModel()
    { 

//#if 1820033311 
return ((UMLDocument) getDocument());
//#endif 

} 

//#endif 


//#if 1929736679 
public void propertyChange(PropertyChangeEvent evt)
    { 

//#if -1502198780 
((UMLDocument) getDocument()).propertyChange(evt);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

