// Compilation Unit of /MessageNotationUml.java 
 
package org.argouml.notation.providers.uml;
import java.util.Map;
import org.argouml.notation.NotationSettings;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public class MessageNotationUml extends AbstractMessageNotationUml
  { 

//#if LOGGING 
static final Logger LOG =
        Logger.getLogger(MessageNotationUml.class);
//#endif 

@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 
return toString(modelElement, true);
} 

public MessageNotationUml(Object message)
    { 
super(message);
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public String toString(final Object modelElement, final Map args)
    { 
return toString(modelElement, true);
} 

 } 


