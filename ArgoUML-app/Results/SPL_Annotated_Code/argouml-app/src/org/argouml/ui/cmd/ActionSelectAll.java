// Compilation Unit of /ActionSelectAll.java 
 
package org.argouml.ui.cmd;
import org.tigris.gef.base.SelectAllAction;

//#if COGNITIVE 
import org.argouml.cognitive.Translator;
//#endif 

public class ActionSelectAll extends SelectAllAction
  { 
public ActionSelectAll()
    { 

//#if COGNITIVE 
this(Translator.localize("menu.item.select-all"));
//#endif 

} 

ActionSelectAll(String name)
    { 
super(name);
} 

 } 


