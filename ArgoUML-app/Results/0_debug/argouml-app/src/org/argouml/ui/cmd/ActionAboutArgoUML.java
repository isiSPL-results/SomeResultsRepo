
//#if 981354613 
// Compilation Unit of /ActionAboutArgoUML.java 
 

//#if -1032671824 
package org.argouml.ui.cmd;
//#endif 


//#if -119531734 
import java.awt.event.ActionEvent;
//#endif 


//#if 1930854686 
import javax.swing.AbstractAction;
//#endif 


//#if -994861229 
import javax.swing.JFrame;
//#endif 


//#if -389555830 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -511527285 
import org.argouml.i18n.Translator;
//#endif 


//#if 2115521565 
import org.argouml.ui.AboutBox;
//#endif 


//#if -1536216103 
import org.argouml.util.ArgoFrame;
//#endif 


//#if 2101912411 
public class ActionAboutArgoUML extends 
//#if 1228586770 
AbstractAction
//#endif 

  { 

//#if 1465481187 
private static final long serialVersionUID = 7988731727182091682L;
//#endif 


//#if 2107820360 
public ActionAboutArgoUML()
    { 

//#if -675062049 
super(Translator.localize("action.about-argouml"),
              ResourceLoaderWrapper.lookupIcon("action.about-argouml"));
//#endif 

} 

//#endif 


//#if -23902442 
public void actionPerformed(ActionEvent ae)
    { 

//#if 1072014354 
JFrame jframe = ArgoFrame.getInstance();
//#endif 


//#if 1807755937 
AboutBox box = new AboutBox(jframe, true);
//#endif 


//#if -479933008 
box.setLocationRelativeTo(jframe);
//#endif 


//#if -857191929 
box.setVisible(true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

