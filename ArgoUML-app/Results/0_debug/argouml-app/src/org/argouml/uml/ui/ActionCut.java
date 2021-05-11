
//#if -578635172 
// Compilation Unit of /ActionCut.java 
 

//#if -527855193 
package org.argouml.uml.ui;
//#endif 


//#if -983368969 
import java.awt.Toolkit;
//#endif 


//#if -845161356 
import java.awt.datatransfer.DataFlavor;
//#endif 


//#if 395485943 
import java.awt.datatransfer.Transferable;
//#endif 


//#if 2116488064 
import java.awt.datatransfer.UnsupportedFlavorException;
//#endif 


//#if -1883552187 
import java.awt.event.ActionEvent;
//#endif 


//#if -756735248 
import java.io.IOException;
//#endif 


//#if 1961026683 
import java.util.Collection;
//#endif 


//#if 166834233 
import javax.swing.AbstractAction;
//#endif 


//#if 2113235131 
import javax.swing.Action;
//#endif 


//#if 1488910424 
import javax.swing.Icon;
//#endif 


//#if -1597938330 
import javax.swing.event.CaretEvent;
//#endif 


//#if -12565662 
import javax.swing.event.CaretListener;
//#endif 


//#if -1480636482 
import javax.swing.text.JTextComponent;
//#endif 


//#if -1485631089 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 638413520 
import org.argouml.i18n.Translator;
//#endif 


//#if -142248350 
import org.tigris.gef.base.CutAction;
//#endif 


//#if 649592586 
import org.tigris.gef.base.Globals;
//#endif 


//#if 1335970362 
public class ActionCut extends 
//#if 1635176569 
AbstractAction
//#endif 

 implements 
//#if 661377462 
CaretListener
//#endif 

  { 

//#if 1369262594 
private static ActionCut instance = new ActionCut();
//#endif 


//#if 1195515368 
private static final String LOCALIZE_KEY = "action.cut";
//#endif 


//#if -1009867605 
private JTextComponent textSource;
//#endif 


//#if 53436280 
public static ActionCut getInstance()
    { 

//#if 2085497889 
return instance;
//#endif 

} 

//#endif 


//#if 740555011 
public ActionCut()
    { 

//#if -287952978 
super(Translator.localize(LOCALIZE_KEY));
//#endif 


//#if -485847019 
Icon icon = ResourceLoaderWrapper.lookupIcon(LOCALIZE_KEY);
//#endif 


//#if -1122774077 
if(icon != null)//1
{ 

//#if 1587270850 
putValue(Action.SMALL_ICON, icon);
//#endif 

} 

//#endif 


//#if 804019065 
putValue(
            Action.SHORT_DESCRIPTION,
            Translator.localize(LOCALIZE_KEY) + " ");
//#endif 

} 

//#endif 


//#if 1971967421 
public void actionPerformed(ActionEvent ae)
    { 

//#if -900944383 
if(textSource == null)//1
{ 

//#if 232985114 
if(removeFromDiagramAllowed())//1
{ 

//#if 794563458 
CutAction cmd =
                    new CutAction(Translator.localize("action.cut"));
//#endif 


//#if -342912885 
cmd.actionPerformed(ae);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -2079214639 
textSource.cut();
//#endif 

} 

//#endif 


//#if 748142546 
if(isSystemClipBoardEmpty()
                && Globals.clipBoard == null
                || Globals.clipBoard.isEmpty())//1
{ 

//#if -1258252332 
ActionPaste.getInstance().setEnabled(false);
//#endif 

} 
else
{ 

//#if 1947884957 
ActionPaste.getInstance().setEnabled(true);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1049770613 
public void caretUpdate(CaretEvent e)
    { 

//#if -747343206 
if(e.getMark() != e.getDot())//1
{ 

//#if -1354014329 
setEnabled(true);
//#endif 


//#if -700630464 
textSource = (JTextComponent) e.getSource();
//#endif 

} 
else
{ 

//#if -453539836 
Collection figSelection =
                Globals.curEditor().getSelectionManager().selections();
//#endif 


//#if 554921828 
if(figSelection == null || figSelection.isEmpty())//1
{ 

//#if 1338335337 
setEnabled(false);
//#endif 

} 
else
{ 

//#if -300887163 
setEnabled(true);
//#endif 

} 

//#endif 


//#if -1759405253 
textSource = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2048853846 
private boolean removeFromDiagramAllowed()
    { 

//#if 1390378772 
return false;
//#endif 

} 

//#endif 


//#if 1808339319 
private boolean isSystemClipBoardEmpty()
    { 

//#if 46923162 
boolean hasContents = false;
//#endif 


//#if -796615381 
Transferable content =
            Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
//#endif 


//#if -1762720166 
DataFlavor[] flavors = content.getTransferDataFlavors();
//#endif 


//#if -7971195 
try //1
{ 

//#if -1992438099 
for (int i = 0; i < flavors.length; i++) //1
{ 

//#if 517331706 
if(content.getTransferData(flavors[i]) != null)//1
{ 

//#if 417494906 
hasContents = true;
//#endif 


//#if 333671558 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#if -976091544 
catch (UnsupportedFlavorException ignorable) //1
{ 
} 

//#endif 


//#if 1174850301 
catch (IOException ignorable) //1
{ 
} 

//#endif 


//#endif 


//#if -226964759 
return !hasContents;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

