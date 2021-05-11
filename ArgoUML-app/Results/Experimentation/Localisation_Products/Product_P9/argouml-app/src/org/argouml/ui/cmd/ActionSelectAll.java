package org.argouml.ui.cmd;
import org.tigris.gef.base.SelectAllAction;
import org.argouml.cognitive.Translator;
public class ActionSelectAll extends SelectAllAction
  { 
public ActionSelectAll()
    { 
this(Translator.localize("menu.item.select-all"));
} 
ActionSelectAll(String name)
    { 
super(name);
} 

 } 
