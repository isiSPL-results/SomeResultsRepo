
//#if 1364718461 
// Compilation Unit of /ActionSaveProjectAs.java 
 

//#if 1636337435 
package org.argouml.uml.ui;
//#endif 


//#if 653723217 
import java.awt.event.ActionEvent;
//#endif 


//#if 693374359 
import org.apache.log4j.Logger;
//#endif 


//#if 1923852803 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1984539716 
import org.argouml.i18n.Translator;
//#endif 


//#if 1363499749 
import org.argouml.ui.ProjectBrowser;
//#endif 


//#if 1105918362 
public class ActionSaveProjectAs extends 
//#if 2138809010 
ActionSaveProject
//#endif 

  { 

//#if 1941605302 
private static final Logger LOG =
        Logger.getLogger(ActionSaveProjectAs.class);
//#endif 


//#if 1937313256 
private static final long serialVersionUID = -1209396991311217989L;
//#endif 


//#if 595827388 
public ActionSaveProjectAs()
    { 

//#if 206200267 
super(Translator.localize("action.save-project-as"),
              ResourceLoaderWrapper.lookupIcon("action.save-project-as"));
//#endif 

} 

//#endif 


//#if 173567865 
public void actionPerformed(ActionEvent e)
    { 

//#if 1600891618 
LOG.info("Performing saveas action");
//#endif 


//#if -440451040 
ProjectBrowser.getInstance().trySave(false, true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

