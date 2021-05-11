// Compilation Unit of /ActionNotation.java 
 
package org.argouml.ui.cmd;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.notation.Notation;
import org.argouml.notation.NotationName;
import org.tigris.gef.undo.UndoableAction;
public class ActionNotation extends UndoableAction
 implements MenuListener
  { 
private JMenu menu;
private static final long serialVersionUID = 1364283215100616618L;
public JMenu getMenu()
    { 
return menu;
} 

public ActionNotation()
    { 
super(Translator.localize("menu.notation"),
              null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("menu.notation"));
menu = new JMenu(Translator.localize("menu.notation"));
menu.add(this);
menu.addMenuListener(this);
} 

public void actionPerformed(ActionEvent ae)
    { 
super.actionPerformed(ae);
String key = ae.getActionCommand();
for (NotationName nn : Notation.getAvailableNotations()) //1
{ 
if(key.equals(nn.getTitle()))//1
{ 
Project p = ProjectManager.getManager().getCurrentProject();
p.getProjectSettings().setNotationLanguage(nn);
break;

} 

} 

} 

public void menuDeselected(MenuEvent me) { 
} 

public void menuCanceled(MenuEvent me) { 
} 

public void menuSelected(MenuEvent me)
    { 
Project p = ProjectManager.getManager().getCurrentProject();
NotationName current = p.getProjectSettings().getNotationName();
menu.removeAll();
ButtonGroup b = new ButtonGroup();
for (NotationName nn : Notation.getAvailableNotations()) //1
{ 
JRadioButtonMenuItem mi =
                new JRadioButtonMenuItem(nn.getTitle());
if(nn.getIcon() != null)//1
{ 
mi.setIcon(nn.getIcon());
} 

mi.addActionListener(this);
b.add(mi);
mi.setSelected(current.sameNotationAs(nn));
menu.add(mi);
} 

} 

 } 


