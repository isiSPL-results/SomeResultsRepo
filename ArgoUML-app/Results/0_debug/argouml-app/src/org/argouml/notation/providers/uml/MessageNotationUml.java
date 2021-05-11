
//#if -1538362187 
// Compilation Unit of /MessageNotationUml.java 
 

//#if -1347611437 
package org.argouml.notation.providers.uml;
//#endif 


//#if 1744599195 
import java.util.Map;
//#endif 


//#if -1524521021 
import org.argouml.notation.NotationSettings;
//#endif 


//#if 1962100029 
import org.apache.log4j.Logger;
//#endif 


//#if -134420925 
public class MessageNotationUml extends 
//#if -311642404 
AbstractMessageNotationUml
//#endif 

  { 

//#if -1923191995 
static final Logger LOG =
        Logger.getLogger(MessageNotationUml.class);
//#endif 


//#if -455516180 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if 2116435769 
return toString(modelElement, true);
//#endif 

} 

//#endif 


//#if 1369285670 
public MessageNotationUml(Object message)
    { 

//#if 1114149031 
super(message);
//#endif 

} 

//#endif 


//#if -1988070940 

//#if 1033201622 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public String toString(final Object modelElement, final Map args)
    { 

//#if 551245899 
return toString(modelElement, true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

