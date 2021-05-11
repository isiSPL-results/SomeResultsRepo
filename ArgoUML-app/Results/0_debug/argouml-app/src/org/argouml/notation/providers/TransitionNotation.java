
//#if 355772561 
// Compilation Unit of /TransitionNotation.java 
 

//#if -1170988717 
package org.argouml.notation.providers;
//#endif 


//#if 356185866 
import org.argouml.model.Model;
//#endif 


//#if -426575729 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 1151349203 
public abstract class TransitionNotation extends 
//#if 1881405100 
NotationProvider
//#endif 

  { 

//#if -855418490 
public TransitionNotation(Object transition)
    { 

//#if -1306829729 
if(!Model.getFacade().isATransition(transition))//1
{ 

//#if -1259334960 
throw new IllegalArgumentException("This is not a Transition.");
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

