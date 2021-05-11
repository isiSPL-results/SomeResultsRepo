
//#if 249888546 
// Compilation Unit of /ActionCopy.java 
 

//#if 912131104 
package org.argouml.uml.ui;
//#endif 


//#if -312786146 
import java.awt.Toolkit;
//#endif 


//#if 367589019 
import java.awt.datatransfer.DataFlavor;
//#endif 


//#if -1629685849 
import java.awt.datatransfer.UnsupportedFlavorException;
//#endif 


//#if 584108460 
import java.awt.event.ActionEvent;
//#endif 


//#if 683251049 
import java.io.IOException;
//#endif 


//#if -1660472416 
import javax.swing.AbstractAction;
//#endif 


//#if -1996733662 
import javax.swing.Action;
//#endif 


//#if -2135474049 
import javax.swing.Icon;
//#endif 


//#if -998003955 
import javax.swing.event.CaretEvent;
//#endif 


//#if 1273481307 
import javax.swing.event.CaretListener;
//#endif 


//#if -194589513 
import javax.swing.text.JTextComponent;
//#endif 


//#if -1440897592 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -173517751 
import org.argouml.i18n.Translator;
//#endif 


//#if 2000729540 
import org.tigris.gef.base.CmdCopy;
//#endif 


//#if -162338685 
import org.tigris.gef.base.Globals;
//#endif 


//#if -1636692892 
public class ActionCopy extends 
//#if 784076591 
AbstractAction
//#endif 

 implements 
//#if 633922624 
CaretListener
//#endif 

  { 

//#if 1650874802 
private static ActionCopy instance = new ActionCopy();
//#endif 


//#if 1563516779 
private static final String LOCALIZE_KEY = "action.copy";
//#endif 


//#if 614588897 
private JTextComponent textSource;
//#endif 


//#if -514775661 
public static ActionCopy getInstance()
    { 

//#if 2054343964 
return instance;
//#endif 

} 

//#endif 


//#if -1215626709 
public void caretUpdate(CaretEvent e)
    { 

//#if 1929586453 
if(e.getMark() != e.getDot())//1
{ 

//#if 368823102 
setEnabled(true);
//#endif 


//#if 2064232183 
textSource = (JTextComponent) e.getSource();
//#endif 

} 
else
{ 

//#if -1212635824 
setEnabled(false);
//#endif 


//#if 727454595 
textSource = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1853942956 
public ActionCopy()
    { 

//#if -883971412 
super(Translator.localize(LOCALIZE_KEY));
//#endif 


//#if -1209534121 
Icon icon = ResourceLoaderWrapper.lookupIcon(LOCALIZE_KEY);
//#endif 


//#if 1989994689 
if(icon != null)//1
{ 

//#if -2027868963 
putValue(Action.SMALL_ICON, icon);
//#endif 

} 

//#endif 


//#if 581107899 
putValue(
            Action.SHORT_DESCRIPTION,
            Translator.localize(LOCALIZE_KEY) + " ");
//#endif 

} 

//#endif 


//#if -1492447699 
private boolean isSystemClipBoardEmpty()
    { 

//#if 2040357751 
try //1
{ 

//#if -136131143 
Object text =
                Toolkit.getDefaultToolkit().getSystemClipboard()
                .getContents(null).getTransferData(DataFlavor.stringFlavor);
//#endif 


//#if 550010443 
return text == null;
//#endif 

} 

//#if 2146812177 
catch (IOException ignorable) //1
{ 
} 

//#endif 


//#if 2092803540 
catch (UnsupportedFlavorException ignorable) //1
{ 
} 

//#endif 


//#endif 


//#if -217939684 
return true;
//#endif 

} 

//#endif 


//#if -398492429 
public void actionPerformed(ActionEvent ae)
    { 

//#if -1823875211 
if(textSource != null)//1
{ 

//#if 1637981209 
textSource.copy();
//#endif 


//#if -342431435 
Globals.clipBoard = null;
//#endif 

} 
else
{ 

//#if 498366030 
CmdCopy cmd = new CmdCopy();
//#endif 


//#if -2068108005 
cmd.doIt();
//#endif 

} 

//#endif 


//#if 143684525 
if(isSystemClipBoardEmpty()
                && (Globals.clipBoard == null
                    || Globals.clipBoard.isEmpty()))//1
{ 

//#if 760676729 
ActionPaste.getInstance().setEnabled(false);
//#endif 

} 
else
{ 

//#if 1213348506 
ActionPaste.getInstance().setEnabled(true);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

