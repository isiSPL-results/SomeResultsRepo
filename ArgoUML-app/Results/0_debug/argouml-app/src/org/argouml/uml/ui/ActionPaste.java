
//#if 2076279720 
// Compilation Unit of /ActionPaste.java 
 

//#if 781670760 
package org.argouml.uml.ui;
//#endif 


//#if 297480918 
import java.awt.Toolkit;
//#endif 


//#if 748844627 
import java.awt.datatransfer.DataFlavor;
//#endif 


//#if 1657800543 
import java.awt.datatransfer.UnsupportedFlavorException;
//#endif 


//#if 598897508 
import java.awt.event.ActionEvent;
//#endif 


//#if -1874416244 
import java.awt.event.FocusEvent;
//#endif 


//#if 1181172092 
import java.awt.event.FocusListener;
//#endif 


//#if 552790705 
import java.io.IOException;
//#endif 


//#if -1645683368 
import javax.swing.AbstractAction;
//#endif 


//#if 354362586 
import javax.swing.Action;
//#endif 


//#if -1525206985 
import javax.swing.Icon;
//#endif 


//#if 329369285 
import javax.swing.event.CaretEvent;
//#endif 


//#if 1285779875 
import javax.swing.event.CaretListener;
//#endif 


//#if -182290945 
import javax.swing.text.JTextComponent;
//#endif 


//#if 951560464 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 284942737 
import org.argouml.i18n.Translator;
//#endif 


//#if 296121803 
import org.tigris.gef.base.Globals;
//#endif 


//#if -1660446516 
public class ActionPaste extends 
//#if 508072200 
AbstractAction
//#endif 

 implements 
//#if -1037548729 
CaretListener
//#endif 

, 
//#if -262894692 
FocusListener
//#endif 

  { 

//#if 125078833 
private static ActionPaste instance = new ActionPaste();
//#endif 


//#if -1511651320 
private static final String LOCALIZE_KEY = "action.paste";
//#endif 


//#if -102957190 
private JTextComponent textSource;
//#endif 


//#if -1342967412 
public void actionPerformed(ActionEvent ae)
    { 

//#if -1009824810 
if(Globals.clipBoard != null && !Globals.clipBoard.isEmpty())//1
{ 
} 
else
{ 

//#if -470465445 
if(!isSystemClipBoardEmpty() && textSource != null)//1
{ 

//#if 1406340234 
textSource.paste();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 52991638 
public static ActionPaste getInstance()
    { 

//#if -1430362908 
return instance;
//#endif 

} 

//#endif 


//#if 374723846 
private boolean isSystemClipBoardEmpty()
    { 

//#if -1556948226 
try //1
{ 

//#if 586789286 
Object text =
                Toolkit.getDefaultToolkit().getSystemClipboard()
                .getContents(null).getTransferData(DataFlavor.stringFlavor);
//#endif 


//#if 311292920 
return text == null;
//#endif 

} 

//#if -1882416764 
catch (IOException ignorable) //1
{ 
} 

//#endif 


//#if 1843558657 
catch (UnsupportedFlavorException ignorable) //1
{ 
} 

//#endif 


//#endif 


//#if 1973265909 
return true;
//#endif 

} 

//#endif 


//#if 1962571237 
public ActionPaste()
    { 

//#if 2059976973 
super(Translator.localize(LOCALIZE_KEY));
//#endif 


//#if 145044694 
Icon icon = ResourceLoaderWrapper.lookupIcon(LOCALIZE_KEY);
//#endif 


//#if 2075382306 
if(icon != null)//1
{ 

//#if -533133606 
putValue(Action.SMALL_ICON, icon);
//#endif 

} 

//#endif 


//#if -2083561926 
putValue(
            Action.SHORT_DESCRIPTION,
            Translator.localize(LOCALIZE_KEY) + " ");
//#endif 


//#if 1845772953 
setEnabled(false);
//#endif 

} 

//#endif 


//#if -723317281 
public void focusLost(FocusEvent e)
    { 

//#if -1065164304 
if(e.getSource() == textSource)//1
{ 

//#if -2044481285 
textSource = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 712318340 
public void caretUpdate(CaretEvent e)
    { 

//#if -1341362360 
textSource = (JTextComponent) e.getSource();
//#endif 

} 

//#endif 


//#if 320443813 
public void focusGained(FocusEvent e)
    { 

//#if 1233573961 
textSource = (JTextComponent) e.getSource();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

