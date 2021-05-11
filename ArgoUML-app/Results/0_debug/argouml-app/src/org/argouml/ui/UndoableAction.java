
//#if 401328249 
// Compilation Unit of /UndoableAction.java 
 

//#if 814021399 
package org.argouml.ui;
//#endif 


//#if 1809327151 
import java.awt.event.ActionEvent;
//#endif 


//#if -435253725 
import javax.swing.AbstractAction;
//#endif 


//#if -1290644798 
import javax.swing.Icon;
//#endif 


//#if -48298082 
import org.argouml.kernel.Project;
//#endif 


//#if 830651787 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -701631666 
public abstract class UndoableAction extends 
//#if 78647077 
AbstractAction
//#endif 

  { 

//#if 1816143983 
public UndoableAction(String name)
    { 

//#if 1478275405 
super(name);
//#endif 

} 

//#endif 


//#if -672915029 
public UndoableAction()
    { 

//#if -1226497755 
super();
//#endif 

} 

//#endif 


//#if -1019719259 
public UndoableAction(String name, Icon icon)
    { 

//#if -1754704917 
super(name, icon);
//#endif 

} 

//#endif 


//#if 1692893952 
public void actionPerformed(ActionEvent e)
    { 

//#if -1703380806 
final Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -650236239 
p.getUndoManager().startInteraction((String) getValue(AbstractAction.NAME));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

