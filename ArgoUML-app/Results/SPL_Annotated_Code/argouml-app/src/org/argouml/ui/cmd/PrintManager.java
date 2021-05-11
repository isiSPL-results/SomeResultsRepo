// Compilation Unit of /PrintManager.java 
 
package org.argouml.ui.cmd;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramUtils;
import org.tigris.gef.base.PrintAction;
public class PrintManager  { 
private final PrintAction printCmd = new PrintAction();
private static final PrintManager INSTANCE = new PrintManager();
public void print()
    { 
Object target = DiagramUtils.getActiveDiagram();
if(target instanceof ArgoDiagram)//1
{ 
printCmd.actionPerformed(null);
} 

} 

public static PrintManager getInstance()
    { 
return INSTANCE;
} 

public void showPageSetupDialog()
    { 
printCmd.doPageSetup();
} 

private PrintManager()
    { 
} 

 } 


