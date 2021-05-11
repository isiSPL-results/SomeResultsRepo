// Compilation Unit of /ActionCreateEdgeModelElement.java 
 
package org.argouml.ui;
import java.awt.event.ActionEvent;
import java.text.MessageFormat;
import javax.swing.AbstractAction;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.IllegalModelElementConnectionException;
import org.argouml.model.Model;
import org.argouml.ui.explorer.ExplorerPopup;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public class ActionCreateEdgeModelElement extends AbstractAction
  { 
private final Object metaType;
private final Object source;
private final Object dest;

//#if LOGGING 
private static final Logger LOG =
        Logger.getLogger(ExplorerPopup.class);
//#endif 

public void actionPerformed(ActionEvent e)
    { 
Object rootModel =
            ProjectManager.getManager().getCurrentProject().getModel();
try //1
{ 
Model.getUmlFactory().buildConnection(
                metaType,
                source,
                null,
                dest,
                null,
                null,
                rootModel);
} 
catch (IllegalModelElementConnectionException e1) //1
{ 

//#if LOGGING 
LOG.error("Exception", e1);
//#endif 

} 


} 

public ActionCreateEdgeModelElement(
        final Object theMetaType,
        final Object theSource,
        final Object theDestination,
        final String relationshipDescr)
    { 
super(MessageFormat.format(
                  relationshipDescr,
                  new Object[] {
                      DisplayTextTree.getModelElementDisplayName(theSource),
                      DisplayTextTree.getModelElementDisplayName(
                          theDestination)
                  }));
this.metaType = theMetaType;
this.source = theSource;
this.dest = theDestination;
} 

 } 


