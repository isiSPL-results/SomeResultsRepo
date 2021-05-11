package org.argouml.uml.diagram.static_structure.layout;
import org.tigris.gef.presentation.FigNode;
public class ClassdiagramNote extends ClassdiagramNode
  { 
@Override
    public float getWeight()
    { 
return first() == null ? 0 : first().getWeight() * 0.9999999f;
} 
public int getTypeOrderNumer()
    { 
return first() == null
               ? super.getTypeOrderNumer()
               : first().getTypeOrderNumer();
} 
@Override
    public float calculateWeight()
    { 
setWeight(getWeight());
return getWeight();
} 
@Override
    public boolean isStandalone()
    { 
return first() == null ? true : first().isStandalone();
} 
@Override
    public int getRank()
    { 
return first() == null ? 0 : first().getRank();
} 
private ClassdiagramNode first()
    { 
return getUpNodes().isEmpty() ? null : getUpNodes().get(0);
} 
public ClassdiagramNote(FigNode f)
    { 
super(f);
} 

 } 
