// Compilation Unit of /FigReturnActionMessage.java 
 
package org.argouml.uml.diagram.sequence.ui;
import org.tigris.gef.presentation.ArrowHeadGreater;
import org.tigris.gef.presentation.Fig;
public class FigReturnActionMessage extends FigMessage
  { 
private static final long serialVersionUID = -6620833059472736152L;
public void setFig(Fig f)
    { 
super.setFig(f);
setDashed(true);
} 

public FigReturnActionMessage()
    { 
this(null);
} 

public FigReturnActionMessage(Object owner)
    { 
super(owner);
setDestArrowHead(new ArrowHeadGreater());
setDashed(true);
} 

 } 


