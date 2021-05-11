package org.argouml.uml.ui;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.JTextComponent;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.tigris.gef.base.Globals;
public class ActionPaste extends AbstractAction
 implements CaretListener
,FocusListener
  { 
private static ActionPaste instance = new ActionPaste();
private static final String LOCALIZE_KEY = "action.paste";
private JTextComponent textSource;
public void actionPerformed(ActionEvent ae)
    { 
if(Globals.clipBoard != null && !Globals.clipBoard.isEmpty())//1
{ 
} 
else
{ 
if(!isSystemClipBoardEmpty() && textSource != null)//1
{ 
textSource.paste();
} 
} 
} 
public static ActionPaste getInstance()
    { 
return instance;
} 
private boolean isSystemClipBoardEmpty()
    { 
try//1
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
public ActionPaste()
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
setEnabled(false);
} 
public void focusLost(FocusEvent e)
    { 
if(e.getSource() == textSource)//1
{ 
textSource = null;
} 
} 
public void caretUpdate(CaretEvent e)
    { 
textSource = (JTextComponent) e.getSource();
} 
public void focusGained(FocusEvent e)
    { 
textSource = (JTextComponent) e.getSource();
} 

 } 
