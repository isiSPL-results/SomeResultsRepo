package org.argouml.uml.diagram.ui;
import org.argouml.model.Model;
import org.argouml.uml.diagram.sequence.ui.ModeCreateMessage;
public class ActionSetAddMessageMode extends ActionSetMode
  { 
public ActionSetAddMessageMode(Object action, String name)
    { 
super(ModeCreateMessage.class, "edgeClass",
              Model.getMetaTypes().getMessage(), name);
modeArgs.put("action", action);
} 

 } 
