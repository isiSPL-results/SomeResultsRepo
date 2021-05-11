
//#if -1624241464 
// Compilation Unit of /ActionSettings.java 
 

//#if 169042939 
package org.argouml.ui;
//#endif 


//#if -1292892981 
import java.awt.event.ActionEvent;
//#endif 


//#if 757493439 
import javax.swing.AbstractAction;
//#endif 


//#if 1419865929 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1768979722 
import org.argouml.i18n.Translator;
//#endif 


//#if -130240409 
import org.argouml.util.ArgoDialog;
//#endif 


//#if -2095066191 
public class ActionSettings extends 
//#if 890917240 
AbstractAction
//#endif 

  { 

//#if -669074833 
private ArgoDialog dialog;
//#endif 


//#if 2122509767 
private static final long serialVersionUID = -3646595772633674514L;
//#endif 


//#if 1845150755 
public ActionSettings()
    { 

//#if 854008513 
super(Translator.localize("action.settings"),
              ResourceLoaderWrapper.lookupIcon("action.settings"));
//#endif 

} 

//#endif 


//#if 1877691384 
public void actionPerformed(ActionEvent event)
    { 

//#if 1243414559 
if(dialog == null)//1
{ 

//#if 1968701578 
dialog = new SettingsDialog();
//#endif 

} 

//#endif 


//#if 1027150773 
dialog.setVisible(true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

