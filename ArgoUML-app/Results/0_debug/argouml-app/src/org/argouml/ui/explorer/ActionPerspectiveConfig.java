
//#if 1865100827 
// Compilation Unit of /ActionPerspectiveConfig.java 
 

//#if 1664239603 
package org.argouml.ui.explorer;
//#endif 


//#if -1831831600 
import java.awt.event.ActionEvent;
//#endif 


//#if 218554820 
import javax.swing.AbstractAction;
//#endif 


//#if 26105158 
import javax.swing.Action;
//#endif 


//#if 589709604 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -2053215579 
import org.argouml.i18n.Translator;
//#endif 


//#if 2109964907 
public class ActionPerspectiveConfig extends 
//#if 140381641 
AbstractAction
//#endif 

  { 

//#if 2059783388 
private static final long serialVersionUID = -708783262437452872L;
//#endif 


//#if -201060595 
public void actionPerformed(ActionEvent ae)
    { 

//#if 967575952 
PerspectiveConfigurator ncd = new PerspectiveConfigurator();
//#endif 


//#if 1157655443 
ncd.setVisible(true);
//#endif 

} 

//#endif 


//#if -375162609 
public ActionPerspectiveConfig()
    { 

//#if 192716314 
super(Translator.localize("action.configure-perspectives"),
              ResourceLoaderWrapper
              .lookupIcon("action.configure-perspectives"));
//#endif 


//#if -1863212214 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.configure-perspectives"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

