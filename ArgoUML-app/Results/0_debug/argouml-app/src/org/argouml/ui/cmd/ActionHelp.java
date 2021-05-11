
//#if -1303874350 
// Compilation Unit of /ActionHelp.java 
 

//#if -1899131997 
package org.argouml.ui.cmd;
//#endif 


//#if 1908421079 
import java.awt.event.ActionEvent;
//#endif 


//#if -336159797 
import javax.swing.AbstractAction;
//#endif 


//#if 224114432 
import javax.swing.JFrame;
//#endif 


//#if -605455683 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -2069499522 
import org.argouml.i18n.Translator;
//#endif 


//#if -1471675202 
import org.argouml.ui.HelpBox;
//#endif 


//#if 1584807131 
public class ActionHelp extends 
//#if -1028940056 
AbstractAction
//#endif 

  { 

//#if -1207784097 
private static final long serialVersionUID = 0L;
//#endif 


//#if 1681478833 
public ActionHelp()
    { 

//#if 17680696 
super(Translator.localize("action.help"),
              ResourceLoaderWrapper.lookupIcon("action.help"));
//#endif 

} 

//#endif 


//#if 325019500 
public void actionPerformed(ActionEvent ae)
    { 

//#if 184896900 
HelpBox box = new HelpBox( Translator.localize("action.help"));
//#endif 


//#if -572020690 
box.setVisible(true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

