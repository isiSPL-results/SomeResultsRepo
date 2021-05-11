// Compilation Unit of /FigCreateActionMessage.java 
 
package org.argouml.uml.diagram.sequence.ui;
import org.tigris.gef.presentation.ArrowHeadGreater;
public class FigCreateActionMessage extends FigMessage
  { 
private static final long serialVersionUID = -2607959442732866191L;
public FigCreateActionMessage(Object owner)
    { 
super(owner);
setDestArrowHead(new ArrowHeadGreater());
setDashed(false);
} 

public FigCreateActionMessage()
    { 
this(null);
} 

 } 


