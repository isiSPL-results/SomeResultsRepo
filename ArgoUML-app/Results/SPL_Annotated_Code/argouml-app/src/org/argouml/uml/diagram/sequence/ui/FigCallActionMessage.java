// Compilation Unit of /FigCallActionMessage.java 
 
package org.argouml.uml.diagram.sequence.ui;
import org.tigris.gef.presentation.ArrowHeadTriangle;
public class FigCallActionMessage extends FigMessage
  { 
private static final long serialVersionUID = 6483648469519347377L;
public FigCallActionMessage(Object owner)
    { 
super(owner);
setDestArrowHead(new ArrowHeadTriangle());
setDashed(false);
} 

public FigCallActionMessage()
    { 
this(null);
} 

 } 


