
//#if -1242811208 
// Compilation Unit of /ActionShowXMLDump.java 
 

//#if 205842598 
package org.argouml.ui.cmd;
//#endif 


//#if -439902788 
import java.awt.Insets;
//#endif 


//#if 895073140 
import java.awt.event.ActionEvent;
//#endif 


//#if -1349507736 
import javax.swing.AbstractAction;
//#endif 


//#if -1570101084 
import javax.swing.JDialog;
//#endif 


//#if 354756407 
import javax.swing.JScrollPane;
//#endif 


//#if 555242642 
import javax.swing.JTextArea;
//#endif 


//#if 876452737 
import org.argouml.i18n.Translator;
//#endif 


//#if -962552093 
import org.argouml.kernel.Project;
//#endif 


//#if -1240834394 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1771327506 
import org.argouml.persistence.PersistenceManager;
//#endif 


//#if -521611229 
import org.argouml.util.ArgoFrame;
//#endif 


//#if -1536629318 
import org.argouml.util.UIUtils;
//#endif 


//#if -1081964969 
public class ActionShowXMLDump extends 
//#if -886005886 
AbstractAction
//#endif 

  { 

//#if 804093463 
private static final long serialVersionUID = -7942597779499060380L;
//#endif 


//#if -1787089701 
private static final int INSET_PX = 3;
//#endif 


//#if -1389016570 
public ActionShowXMLDump()
    { 

//#if -1905938604 
super(Translator.localize("action.show-saved"));
//#endif 

} 

//#endif 


//#if 2072866715 
private void init(JDialog pw)
    { 

//#if -676174974 
UIUtils.loadCommonKeyMap(pw);
//#endif 

} 

//#endif 


//#if -652466877 
public void actionPerformed(ActionEvent e)
    { 

//#if -1765054979 
Project project = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -97969261 
String data =
            PersistenceManager.getInstance().getQuickViewDump(project);
//#endif 


//#if -444534828 
JDialog pw = new JDialog(ArgoFrame.getInstance(),
                                 Translator.localize("action.show-saved"),
                                 false);
//#endif 


//#if 377827933 
JTextArea a = new JTextArea(data, 50, 80);
//#endif 


//#if -190001082 
a.setEditable(false);
//#endif 


//#if 997870901 
a.setLineWrap(true);
//#endif 


//#if 337579020 
a.setWrapStyleWord(true);
//#endif 


//#if -1530089402 
a.setMargin(new Insets(INSET_PX, INSET_PX, INSET_PX, INSET_PX));
//#endif 


//#if -1960255183 
a.setCaretPosition(0);
//#endif 


//#if -1446453215 
pw.getContentPane().add(new JScrollPane(a));
//#endif 


//#if -335401757 
pw.setSize(400, 500);
//#endif 


//#if -2030100493 
pw.setLocationRelativeTo(ArgoFrame.getInstance());
//#endif 


//#if 125319313 
init(pw);
//#endif 


//#if -810298479 
pw.setVisible(true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

