
//#if 1165159846 
// Compilation Unit of /ClassdiagramNote.java 
 

//#if 1816608633 
package org.argouml.uml.diagram.static_structure.layout;
//#endif 


//#if 1617638162 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -1406474344 
public class ClassdiagramNote extends 
//#if 1006813173 
ClassdiagramNode
//#endif 

  { 

//#if -157986608 
@Override
    public float getWeight()
    { 

//#if -327739705 
return first() == null ? 0 : first().getWeight() * 0.9999999f;
//#endif 

} 

//#endif 


//#if -357222456 
public int getTypeOrderNumer()
    { 

//#if 255739650 
return first() == null
               ? super.getTypeOrderNumer()
               : first().getTypeOrderNumer();
//#endif 

} 

//#endif 


//#if 1437796384 
@Override
    public float calculateWeight()
    { 

//#if 1146909939 
setWeight(getWeight());
//#endif 


//#if 2080114844 
return getWeight();
//#endif 

} 

//#endif 


//#if -1608224549 
@Override
    public boolean isStandalone()
    { 

//#if -1517538149 
return first() == null ? true : first().isStandalone();
//#endif 

} 

//#endif 


//#if 695984721 
@Override
    public int getRank()
    { 

//#if -1430126389 
return first() == null ? 0 : first().getRank();
//#endif 

} 

//#endif 


//#if -1169277975 
private ClassdiagramNode first()
    { 

//#if -300256600 
return getUpNodes().isEmpty() ? null : getUpNodes().get(0);
//#endif 

} 

//#endif 


//#if -1940329809 
public ClassdiagramNote(FigNode f)
    { 

//#if -1223641558 
super(f);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

