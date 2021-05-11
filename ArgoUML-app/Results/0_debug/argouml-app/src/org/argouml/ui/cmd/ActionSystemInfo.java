
//#if -1434217614 
// Compilation Unit of /ActionSystemInfo.java 
 

//#if 473757930 
package org.argouml.ui.cmd;
//#endif 


//#if 280798650 
import java.awt.Dimension;
//#endif 


//#if 1761580720 
import java.awt.event.ActionEvent;
//#endif 


//#if -483000156 
import javax.swing.AbstractAction;
//#endif 


//#if -1866836954 
import javax.swing.Action;
//#endif 


//#if 993395929 
import javax.swing.JFrame;
//#endif 


//#if 492492356 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1968383941 
import org.argouml.i18n.Translator;
//#endif 


//#if 1143102736 
import org.argouml.ui.SystemInfoDialog;
//#endif 


//#if 344896351 
import org.argouml.util.ArgoFrame;
//#endif 


//#if -150329040 
public class ActionSystemInfo extends 
//#if -1186601463 
AbstractAction
//#endif 

  { 

//#if 2089949005 
public void actionPerformed(ActionEvent ae)
    { 

//#if 1749934249 
JFrame jFrame = ArgoFrame.getInstance();
//#endif 


//#if -694243271 
SystemInfoDialog sysInfoDialog = new SystemInfoDialog(true);
//#endif 


//#if 44821992 
Dimension siDim = sysInfoDialog.getSize();
//#endif 


//#if 1901086840 
Dimension pbDim = jFrame.getSize();
//#endif 


//#if 983538705 
if(siDim.width > pbDim.width / 2)//1
{ 

//#if 2135516152 
sysInfoDialog.setSize(pbDim.width / 2, siDim.height + 45);
//#endif 

} 
else
{ 

//#if -1184365770 
sysInfoDialog.setSize(siDim.width, siDim.height + 45);
//#endif 

} 

//#endif 


//#if 1574245441 
sysInfoDialog.setLocationRelativeTo(jFrame);
//#endif 


//#if 314937270 
sysInfoDialog.setVisible(true);
//#endif 

} 

//#endif 


//#if -1753934706 
public ActionSystemInfo()
    { 

//#if 521127545 
super(Translator.localize("action.system-information"),
              ResourceLoaderWrapper.lookupIcon("action.system-information"));
//#endif 


//#if -645493607 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.system-information"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

