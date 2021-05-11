// Compilation Unit of /ActionCopy.java 
 
package org.argouml.uml.ui;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.JTextComponent;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.tigris.gef.base.CmdCopy;
import org.tigris.gef.base.Globals;
public class ActionCopy extends AbstractAction
 implements CaretListener
  { 
private static ActionCopy instance = new ActionCopy();
private static final String LOCALIZE_KEY = "action.copy";
private JTextComponent textSource;
public static ActionCopy getInstance()
    { 
return instance;
} 

public void caretUpdate(CaretEvent e)
    { 
if(e.getMark() != e.getDot())//1
{ 
setEnabled(true);
textSource = (JTextComponent) e.getSource();
} 
else
{ 
setEnabled(false);
textSource = null;
} 

} 

public ActionCopy()
    { 
super(Translator.localize(LOCALIZE_KEY));
Icon icon = ResourceLoaderWrapper.lookupIcon(LOCALIZE_KEY);
if(icon != null)//1
{ 
putValue(Action.SMALL_ICON, icon);
} 

putValue(
            Action.SHORT_DESCRIPTION,
            Translator.localize(LOCALIZE_KEY) + " ");
} 

private boolean isSystemClipBoardEmpty()
    { 
try //1
{ 
Object text =
                Toolkit.getDefaultToolkit().getSystemClipboard()
                .getContents(null).getTransferData(DataFlavor.stringFlavor);
return text == null;
} 
catch (IOException ignorable) //1
{ 
} 

catch (UnsupportedFlavorException ignorable) //1
{ 
} 


return true;
} 

public void actionPerformed(ActionEvent ae)
    { 
if(textSource != null)//1
{ 
textSource.copy();
Globals.clipBoard = null;
} 
else
{ 
CmdCopy cmd = new CmdCopy();
cmd.doIt();
} 

if(isSystemClipBoardEmpty()
                && (Globals.clipBoard == null
                    || Globals.clipBoard.isEmpty()))//1
{ 
ActionPaste.getInstance().setEnabled(false);
} 
else
{ 
ActionPaste.getInstance().setEnabled(true);
} 

} 

 } 


