package org.argouml.uml.diagram.sequence.ui;
import org.tigris.gef.presentation.ArrowHeadGreater;
public class FigDestroyActionMessage extends FigMessage
  { 
private static final long serialVersionUID = 8246653379767368449L;
public FigDestroyActionMessage(Object owner)
    { 
super(owner);
setDestArrowHead(new ArrowHeadGreater());
setDashed(false);
} 
public FigDestroyActionMessage()
    { 
this(null);
} 

 } 
