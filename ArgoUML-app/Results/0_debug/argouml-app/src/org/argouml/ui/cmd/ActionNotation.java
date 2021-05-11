
//#if 1053784936 
// Compilation Unit of /ActionNotation.java 
 

//#if 306064510 
package org.argouml.ui.cmd;
//#endif 


//#if -906169188 
import java.awt.event.ActionEvent;
//#endif 


//#if -625320430 
import javax.swing.Action;
//#endif 


//#if 1232302657 
import javax.swing.ButtonGroup;
//#endif 


//#if 2017846661 
import javax.swing.JMenu;
//#endif 


//#if 1133726451 
import javax.swing.JRadioButtonMenuItem;
//#endif 


//#if 1903308871 
import javax.swing.event.MenuEvent;
//#endif 


//#if -1932951327 
import javax.swing.event.MenuListener;
//#endif 


//#if 872515417 
import org.argouml.i18n.Translator;
//#endif 


//#if 1531172875 
import org.argouml.kernel.Project;
//#endif 


//#if -1842083714 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 939745621 
import org.argouml.notation.Notation;
//#endif 


//#if -615372022 
import org.argouml.notation.NotationName;
//#endif 


//#if 2129190706 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1842363295 
public class ActionNotation extends 
//#if 1173246436 
UndoableAction
//#endif 

 implements 
//#if 919852291 
MenuListener
//#endif 

  { 

//#if 897757606 
private JMenu menu;
//#endif 


//#if -564886631 
private static final long serialVersionUID = 1364283215100616618L;
//#endif 


//#if 751929158 
public JMenu getMenu()
    { 

//#if -744283640 
return menu;
//#endif 

} 

//#endif 


//#if -1303858798 
public ActionNotation()
    { 

//#if -15417104 
super(Translator.localize("menu.notation"),
              null);
//#endif 


//#if 563743327 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("menu.notation"));
//#endif 


//#if 1623848091 
menu = new JMenu(Translator.localize("menu.notation"));
//#endif 


//#if 906525919 
menu.add(this);
//#endif 


//#if 1212777388 
menu.addMenuListener(this);
//#endif 

} 

//#endif 


//#if 1479547724 
public void actionPerformed(ActionEvent ae)
    { 

//#if 618766202 
super.actionPerformed(ae);
//#endif 


//#if -1605428749 
String key = ae.getActionCommand();
//#endif 


//#if -1101179818 
for (NotationName nn : Notation.getAvailableNotations()) //1
{ 

//#if -482430998 
if(key.equals(nn.getTitle()))//1
{ 

//#if -1033413851 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1726303834 
p.getProjectSettings().setNotationLanguage(nn);
//#endif 


//#if -1734348643 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1911014710 
public void menuDeselected(MenuEvent me) { 
} 

//#endif 


//#if 628352729 
public void menuCanceled(MenuEvent me) { 
} 

//#endif 


//#if -426456041 
public void menuSelected(MenuEvent me)
    { 

//#if 1540779309 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -304082346 
NotationName current = p.getProjectSettings().getNotationName();
//#endif 


//#if 887583187 
menu.removeAll();
//#endif 


//#if 2078380766 
ButtonGroup b = new ButtonGroup();
//#endif 


//#if 340510320 
for (NotationName nn : Notation.getAvailableNotations()) //1
{ 

//#if -2106180606 
JRadioButtonMenuItem mi =
                new JRadioButtonMenuItem(nn.getTitle());
//#endif 


//#if 376005018 
if(nn.getIcon() != null)//1
{ 

//#if -851357306 
mi.setIcon(nn.getIcon());
//#endif 

} 

//#endif 


//#if 1574317057 
mi.addActionListener(this);
//#endif 


//#if 1149227999 
b.add(mi);
//#endif 


//#if -786380543 
mi.setSelected(current.sameNotationAs(nn));
//#endif 


//#if -52984058 
menu.add(mi);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

