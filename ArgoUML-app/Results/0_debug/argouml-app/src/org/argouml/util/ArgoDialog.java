
//#if 2027517653 
// Compilation Unit of /ArgoDialog.java 
 

//#if 1595346482 
package org.argouml.util;
//#endif 


//#if 153727721 
import java.awt.Frame;
//#endif 


//#if -319400962 
import javax.swing.AbstractButton;
//#endif 


//#if -2098141777 
import org.argouml.i18n.Translator;
//#endif 


//#if 643364730 
import org.tigris.swidgets.Dialog;
//#endif 


//#if 1362790900 
public class ArgoDialog extends 
//#if -864280527 
Dialog
//#endif 

  { 

//#if -508266445 
private static Frame frame;
//#endif 


//#if 1199866325 
private static final String MNEMONIC_KEY_SUFFIX = ".mnemonic";
//#endif 


//#if 487256335 
protected void nameButton(AbstractButton button, String key)
    { 

//#if 1166635970 
if(button != null)//1
{ 

//#if 1673556306 
button.setText(Translator.localize(key));
//#endif 


//#if -1302106167 
String mnemonic =
                Translator.localize(key + MNEMONIC_KEY_SUFFIX);
//#endif 


//#if -1339155129 
if(mnemonic != null && mnemonic.length() > 0)//1
{ 

//#if -1005559628 
button.setMnemonic(mnemonic.charAt(0));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2139413156 
public ArgoDialog(String title, int optionType, boolean modal)
    { 

//#if -2115480422 
super(frame, title, optionType, modal);
//#endif 


//#if -1055621006 
init();
//#endif 

} 

//#endif 


//#if -1958255990 
public ArgoDialog(String title, boolean modal)
    { 

//#if 2060682572 
super(frame, title, modal);
//#endif 


//#if 1787300023 
init();
//#endif 

} 

//#endif 


//#if 1968551742 
protected void nameButtons()
    { 

//#if 1750512629 
nameButton(getOkButton(), "button.ok");
//#endif 


//#if 582749493 
nameButton(getCancelButton(), "button.cancel");
//#endif 


//#if 1963926987 
nameButton(getCloseButton(), "button.close");
//#endif 


//#if 510949741 
nameButton(getYesButton(), "button.yes");
//#endif 


//#if -1794161643 
nameButton(getNoButton(), "button.no");
//#endif 


//#if 1500130965 
nameButton(getHelpButton(), "button.help");
//#endif 

} 

//#endif 


//#if -505710593 
private void init()
    { 

//#if 505690953 
UIUtils.loadCommonKeyMap(this);
//#endif 

} 

//#endif 


//#if -4875193 
public static void setFrame(Frame f)
    { 

//#if 205492885 
ArgoDialog.frame = f;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

