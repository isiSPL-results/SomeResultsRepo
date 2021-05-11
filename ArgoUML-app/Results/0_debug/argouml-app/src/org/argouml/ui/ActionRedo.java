
//#if 2067336307 
// Compilation Unit of /ActionRedo.java 
 

//#if -1482752537 
package org.argouml.ui;
//#endif 


//#if 69156703 
import java.awt.event.ActionEvent;
//#endif 


//#if 2119543123 
import javax.swing.AbstractAction;
//#endif 


//#if 523807218 
import javax.swing.Icon;
//#endif 


//#if -1788468530 
import org.argouml.kernel.Project;
//#endif 


//#if 1162849371 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1494999328 
public class ActionRedo extends 
//#if -544960362 
AbstractAction
//#endif 

  { 

//#if -1711221215 
private static final long serialVersionUID = 3921952827170089931L;
//#endif 


//#if -194784593 
public void actionPerformed(ActionEvent e)
    { 

//#if 468104408 
final Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1724834024 
p.getUndoManager().redo();
//#endif 

} 

//#endif 


//#if -1768911776 
public ActionRedo(String name)
    { 

//#if 287812839 
super(name);
//#endif 

} 

//#endif 


//#if -1832203052 
public ActionRedo(String name, Icon icon)
    { 

//#if 1769561693 
super(name, icon);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

