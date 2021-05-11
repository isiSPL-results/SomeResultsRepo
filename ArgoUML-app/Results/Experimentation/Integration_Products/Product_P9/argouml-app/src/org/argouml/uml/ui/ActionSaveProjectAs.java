package org.argouml.uml.ui;
import java.awt.event.ActionEvent;
import org.apache.log4j.Logger;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.ui.ProjectBrowser;
public class ActionSaveProjectAs extends ActionSaveProject
  { 
private static final Logger LOG =
        Logger.getLogger(ActionSaveProjectAs.class);
private static final long serialVersionUID = -1209396991311217989L;
public ActionSaveProjectAs()
    { 
super(Translator.localize("action.save-project-as"),
              ResourceLoaderWrapper.lookupIcon("action.save-project-as"));
} 
public void actionPerformed(ActionEvent e)
    { 
LOG.info("Performing saveas action");
ProjectBrowser.getInstance().trySave(false, true);
} 

 } 
