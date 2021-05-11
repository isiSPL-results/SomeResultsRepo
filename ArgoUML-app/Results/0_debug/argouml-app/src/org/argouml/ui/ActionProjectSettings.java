
//#if 1217526788 
// Compilation Unit of /ActionProjectSettings.java 
 

//#if 691091113 
package org.argouml.ui;
//#endif 


//#if -468100771 
import java.awt.event.ActionEvent;
//#endif 


//#if 1582285649 
import javax.swing.AbstractAction;
//#endif 


//#if -473689133 
import javax.swing.Action;
//#endif 


//#if -1619406985 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1567734456 
import org.argouml.i18n.Translator;
//#endif 


//#if 1019478076 
public class ActionProjectSettings extends 
//#if -1650314375 
AbstractAction
//#endif 

  { 

//#if 1051935743 
private static ProjectSettingsDialog dialog;
//#endif 


//#if -1959451348 
public void actionPerformed(ActionEvent e)
    { 

//#if 810772138 
if(dialog == null)//1
{ 

//#if -202958300 
dialog = new ProjectSettingsDialog();
//#endif 

} 

//#endif 


//#if 1927658983 
dialog.showDialog();
//#endif 

} 

//#endif 


//#if -97454179 
public ActionProjectSettings()
    { 

//#if -989343192 
super(Translator.localize("action.properties"),
              ResourceLoaderWrapper.lookupIcon("action.properties"));
//#endif 


//#if 1890281507 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.properties"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

