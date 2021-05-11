// Compilation Unit of /ArgoDialog.java 
 
package org.argouml.util;
import java.awt.Frame;
import javax.swing.AbstractButton;
import org.argouml.i18n.Translator;
import org.tigris.swidgets.Dialog;
public class ArgoDialog extends Dialog
  { 
private static Frame frame;
private static final String MNEMONIC_KEY_SUFFIX = ".mnemonic";
protected void nameButton(AbstractButton button, String key)
    { 
if(button != null)//1
{ 
button.setText(Translator.localize(key));
String mnemonic =
                Translator.localize(key + MNEMONIC_KEY_SUFFIX);
if(mnemonic != null && mnemonic.length() > 0)//1
{ 
button.setMnemonic(mnemonic.charAt(0));
} 

} 

} 

public ArgoDialog(String title, int optionType, boolean modal)
    { 
super(frame, title, optionType, modal);
init();
} 

public ArgoDialog(String title, boolean modal)
    { 
super(frame, title, modal);
init();
} 

protected void nameButtons()
    { 
nameButton(getOkButton(), "button.ok");
nameButton(getCancelButton(), "button.cancel");
nameButton(getCloseButton(), "button.close");
nameButton(getYesButton(), "button.yes");
nameButton(getNoButton(), "button.no");
nameButton(getHelpButton(), "button.help");
} 

private void init()
    { 
UIUtils.loadCommonKeyMap(this);
} 

public static void setFrame(Frame f)
    { 
ArgoDialog.frame = f;
} 

 } 


