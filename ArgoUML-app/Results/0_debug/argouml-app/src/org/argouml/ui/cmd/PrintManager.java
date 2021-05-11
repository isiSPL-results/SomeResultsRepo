
//#if -344711561 
// Compilation Unit of /PrintManager.java 
 

//#if 817771991 
package org.argouml.ui.cmd;
//#endif 


//#if -1224455881 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 1369265063 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if 531558329 
import org.tigris.gef.base.PrintAction;
//#endif 


//#if 902410192 
public class PrintManager  { 

//#if 1117740933 
private final PrintAction printCmd = new PrintAction();
//#endif 


//#if -786642197 
private static final PrintManager INSTANCE = new PrintManager();
//#endif 


//#if -603663361 
public void print()
    { 

//#if 475387195 
Object target = DiagramUtils.getActiveDiagram();
//#endif 


//#if -1163217985 
if(target instanceof ArgoDiagram)//1
{ 

//#if 1179721909 
printCmd.actionPerformed(null);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 165492835 
public static PrintManager getInstance()
    { 

//#if 939874060 
return INSTANCE;
//#endif 

} 

//#endif 


//#if -1013485589 
public void showPageSetupDialog()
    { 

//#if 128142167 
printCmd.doPageSetup();
//#endif 

} 

//#endif 


//#if -1858095022 
private PrintManager()
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

