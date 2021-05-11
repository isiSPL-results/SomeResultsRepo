
//#if -49666286 
// Compilation Unit of /ActionUndo.java 
 

//#if -1328581008 
package org.argouml.ui;
//#endif 


//#if -1065007306 
import java.awt.event.ActionEvent;
//#endif 


//#if 985379114 
import javax.swing.AbstractAction;
//#endif 


//#if 1008157321 
import javax.swing.Icon;
//#endif 


//#if 1372334757 
import org.argouml.kernel.Project;
//#endif 


//#if 1350595748 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1361523293 
public class ActionUndo extends 
//#if 459650123 
AbstractAction
//#endif 

  { 

//#if 1509063453 
private static final long serialVersionUID = 6544646406482242086L;
//#endif 


//#if 749196442 
public void actionPerformed(ActionEvent e)
    { 

//#if 211147355 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1940998021 
p.getUndoManager().undo();
//#endif 

} 

//#endif 


//#if 1443576409 
public ActionUndo(String name, Icon icon)
    { 

//#if 226668860 
super(name, icon);
//#endif 

} 

//#endif 


//#if 1237771579 
public ActionUndo(String name)
    { 

//#if 2129741051 
super(name);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

