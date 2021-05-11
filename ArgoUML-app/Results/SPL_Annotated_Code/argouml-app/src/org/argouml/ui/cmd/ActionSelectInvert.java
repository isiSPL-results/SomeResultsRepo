// Compilation Unit of /ActionSelectInvert.java 
 
package org.argouml.ui.cmd;
import org.tigris.gef.base.SelectInvertAction;

//#if COGNITIVE 
import org.argouml.cognitive.Translator;
//#endif 

public class ActionSelectInvert extends SelectInvertAction
  { 
ActionSelectInvert(String name)
    { 
super(name);
} 

public ActionSelectInvert()
    { 

//#if COGNITIVE 
this(Translator.localize("menu.item.invert-selection"));
//#endif 

} 

 } 


