
//#if -30871667 
// Compilation Unit of /ActionImportFromSources.java 
 

//#if -1257345127 
package org.argouml.uml.ui;
//#endif 


//#if -179293165 
import java.awt.event.ActionEvent;
//#endif 


//#if 1396966537 
import javax.swing.Action;
//#endif 


//#if -23754987 
import org.apache.log4j.Logger;
//#endif 


//#if -1318718719 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1930835650 
import org.argouml.i18n.Translator;
//#endif 


//#if -1365474835 
import org.argouml.ui.ExceptionDialog;
//#endif 


//#if -1433462546 
import org.argouml.uml.reveng.Import;
//#endif 


//#if -353609048 
import org.argouml.uml.reveng.ImporterManager;
//#endif 


//#if -1595977534 
import org.argouml.util.ArgoFrame;
//#endif 


//#if 1784461225 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -136956493 
public class ActionImportFromSources extends 
//#if -1721718225 
UndoableAction
//#endif 

  { 

//#if -670986600 
private static final Logger LOG =
        Logger.getLogger(ActionImportFromSources.class);
//#endif 


//#if 42115842 
private static final ActionImportFromSources SINGLETON =
        new ActionImportFromSources();
//#endif 


//#if -619100949 
public static ActionImportFromSources getInstance()
    { 

//#if 349468646 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 348107489 
protected ActionImportFromSources()
    { 

//#if 847779919 
super(Translator.localize("action.import-sources"),
              ResourceLoaderWrapper.lookupIcon("action.import-sources"));
//#endif 


//#if 430539117 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.import-sources"));
//#endif 

} 

//#endif 


//#if 360408125 
public void actionPerformed(ActionEvent event)
    { 

//#if -359811102 
super.actionPerformed(event);
//#endif 


//#if -1200787017 
if(ImporterManager.getInstance().hasImporters())//1
{ 

//#if -1375965101 
new Import(ArgoFrame.getInstance());
//#endif 

} 
else
{ 

//#if 950459789 
LOG.info("Import sources dialog not shown: no importers!");
//#endif 


//#if -241212243 
ExceptionDialog ed = new ExceptionDialog(ArgoFrame.getInstance(),
                    Translator.localize("dialog.title.problem"),
                    Translator.localize("dialog.import.no-importers.intro"),
                    Translator.localize("dialog.import.no-importers.message"));
//#endif 


//#if 1785016193 
ed.setModal(true);
//#endif 


//#if 1339383964 
ed.setVisible(true);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

