
//#if -1777587446 
// Compilation Unit of /GotoDialog.java 
 

//#if -42298247 
package org.argouml.ui;
//#endif 


//#if -696862909 
import java.awt.BorderLayout;
//#endif 


//#if 1770157463 
import java.awt.Dimension;
//#endif 


//#if -2120599155 
import java.awt.event.ActionEvent;
//#endif 


//#if -1541241089 
import javax.swing.JPanel;
//#endif 


//#if 1879892104 
import org.argouml.i18n.Translator;
//#endif 


//#if 316742908 
import org.argouml.kernel.Project;
//#endif 


//#if 450724461 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -19328027 
import org.argouml.util.ArgoDialog;
//#endif 


//#if -1581415547 
public class GotoDialog extends 
//#if -1979797877 
ArgoDialog
//#endif 

  { 

//#if -1547009356 
private final TabResults allDiagrams = new TabResults(false);
//#endif 


//#if 649300447 
protected void nameButtons()
    { 

//#if -1455810505 
super.nameButtons();
//#endif 


//#if -1016576863 
nameButton(getOkButton(), "button.go-to-selection");
//#endif 


//#if -1440166102 
nameButton(getCancelButton(), "button.close");
//#endif 

} 

//#endif 


//#if -1508923201 
public GotoDialog()
    { 

//#if 209169064 
super(Translator.localize("dialog.gotodiagram.title"),
              ArgoDialog.OK_CANCEL_OPTION, false);
//#endif 


//#if -1379231704 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1741259563 
allDiagrams.setResults(p.getDiagramList(), p.getDiagramList());
//#endif 


//#if -1218861582 
allDiagrams.setPreferredSize(new Dimension(
                                         allDiagrams.getPreferredSize().width,
                                         allDiagrams.getPreferredSize().height / 2));
//#endif 


//#if 748125790 
allDiagrams.selectResult(0);
//#endif 


//#if -102843983 
JPanel mainPanel = new JPanel(new BorderLayout());
//#endif 


//#if 1297993132 
mainPanel.add(allDiagrams, BorderLayout.CENTER);
//#endif 


//#if 562433450 
setContent(mainPanel);
//#endif 

} 

//#endif 


//#if 645912003 
public void actionPerformed(ActionEvent e)
    { 

//#if -1616563968 
if(e.getSource() == getOkButton())//1
{ 

//#if 373363844 
allDiagrams.doDoubleClick();
//#endif 

} 
else
{ 

//#if -1147433194 
super.actionPerformed(e);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

