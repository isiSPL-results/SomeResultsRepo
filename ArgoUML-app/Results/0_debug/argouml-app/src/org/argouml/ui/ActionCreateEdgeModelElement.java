
//#if 48162414 
// Compilation Unit of /ActionCreateEdgeModelElement.java 
 

//#if -1358140270 
package org.argouml.ui;
//#endif 


//#if 2135590868 
import java.awt.event.ActionEvent;
//#endif 


//#if 888630661 
import java.text.MessageFormat;
//#endif 


//#if -108990008 
import javax.swing.AbstractAction;
//#endif 


//#if -1035147706 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1875528322 
import org.argouml.model.IllegalModelElementConnectionException;
//#endif 


//#if -615784857 
import org.argouml.model.Model;
//#endif 


//#if -230474701 
import org.argouml.ui.explorer.ExplorerPopup;
//#endif 


//#if 1831645940 
import org.apache.log4j.Logger;
//#endif 


//#if -938138013 
public class ActionCreateEdgeModelElement extends 
//#if 88104677 
AbstractAction
//#endif 

  { 

//#if 681901533 
private final Object metaType;
//#endif 


//#if -1027866527 
private final Object source;
//#endif 


//#if -1516896518 
private final Object dest;
//#endif 


//#if 284133924 
private static final Logger LOG =
        Logger.getLogger(ExplorerPopup.class);
//#endif 


//#if -1711510720 
public void actionPerformed(ActionEvent e)
    { 

//#if 1855080831 
Object rootModel =
            ProjectManager.getManager().getCurrentProject().getModel();
//#endif 


//#if 1305040182 
try //1
{ 

//#if 136037706 
Model.getUmlFactory().buildConnection(
                metaType,
                source,
                null,
                dest,
                null,
                null,
                rootModel);
//#endif 

} 

//#if -578267345 
catch (IllegalModelElementConnectionException e1) //1
{ 

//#if -1822750721 
LOG.error("Exception", e1);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -54611975 
public ActionCreateEdgeModelElement(
        final Object theMetaType,
        final Object theSource,
        final Object theDestination,
        final String relationshipDescr)
    { 

//#if 368037304 
super(MessageFormat.format(
                  relationshipDescr,
                  new Object[] {
                      DisplayTextTree.getModelElementDisplayName(theSource),
                      DisplayTextTree.getModelElementDisplayName(
                          theDestination)
                  }));
//#endif 


//#if 2058017605 
this.metaType = theMetaType;
//#endif 


//#if 11780109 
this.source = theSource;
//#endif 


//#if -1770990841 
this.dest = theDestination;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

