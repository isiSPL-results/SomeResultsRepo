package org.argouml.notation.providers.uml;
import java.util.Map;
import org.argouml.notation.NotationSettings;
public class MessageNotationUml extends AbstractMessageNotationUml
  { 
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
