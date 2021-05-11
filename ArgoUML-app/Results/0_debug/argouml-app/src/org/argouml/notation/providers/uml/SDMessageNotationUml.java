
//#if -1949084047 
// Compilation Unit of /SDMessageNotationUml.java 
 

//#if -1187125731 
package org.argouml.notation.providers.uml;
//#endif 


//#if -840082075 
import java.util.Map;
//#endif 


//#if 306921087 
import org.argouml.notation.NotationProvider;
//#endif 


//#if -1916580211 
import org.argouml.notation.NotationSettings;
//#endif 


//#if -155621732 
import org.argouml.notation.SDNotationSettings;
//#endif 


//#if -1692366518 
public class SDMessageNotationUml extends 
//#if -1919539903 
AbstractMessageNotationUml
//#endif 

  { 

//#if -312434448 
public SDMessageNotationUml(Object message)
    { 

//#if 736647235 
super(message);
//#endif 

} 

//#endif 


//#if -373330065 
public String toString(final Object modelElement,
                           NotationSettings settings)
    { 

//#if -1911015468 
if(settings instanceof SDNotationSettings)//1
{ 

//#if -1650385476 
return toString(modelElement,
                            ((SDNotationSettings) settings).isShowSequenceNumbers());
//#endif 

} 
else
{ 

//#if 1384500038 
return toString(modelElement, true);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1182373748 

//#if 2010098651 
@SuppressWarnings("deprecation")
//#endif 


    public String toString(final Object modelElement, final Map args)
    { 

//#if -299697100 
return toString(modelElement,
                        !NotationProvider.isValue("hideSequenceNrs", args));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

