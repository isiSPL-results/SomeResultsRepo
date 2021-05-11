package org.argouml.ui.cmd;
import org.tigris.gef.base.SelectInvertAction;
import org.argouml.cognitive.Translator;
public class ActionSelectInvert extends SelectInvertAction
  { 
ActionSelectInvert(String name)
    { 
super(name);
} 
public ActionSelectInvert()
    { 
this(Translator.localize("menu.item.invert-selection"));
} 

 } 
