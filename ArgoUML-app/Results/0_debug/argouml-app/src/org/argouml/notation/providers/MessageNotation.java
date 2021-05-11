
//#if 1762139367 
// Compilation Unit of /MessageNotation.java 
 

//#if 863285825 
package org.argouml.notation.providers;
//#endif 


//#if 839163471 
import java.beans.PropertyChangeListener;
//#endif 


//#if 137609817 
import java.util.List;
//#endif 


//#if -451258888 
import org.argouml.model.Model;
//#endif 


//#if 523411197 
import org.argouml.notation.NotationProvider;
//#endif 


//#if -1432570565 
public abstract class MessageNotation extends 
//#if 369575304 
NotationProvider
//#endif 

  { 

//#if -864953341 
public void initialiseListener(PropertyChangeListener listener,
                                   Object umlMessage)
    { 

//#if -411320923 
addElementListener(listener, umlMessage,
                           new String[] {"activator", "predecessor", "successor",
                                         "sender", "receiver", "action", "name"
                                        });
//#endif 


//#if -958685248 
Object action = Model.getFacade().getAction(umlMessage);
//#endif 


//#if 276695329 
if(action != null)//1
{ 

//#if -404728211 
addElementListener(listener, action,
                               new String[] {"remove", "recurrence", "script",
                                             "actualArgument", "signal", "operation"
                                            });
//#endif 


//#if -1640487252 
List args = Model.getFacade().getActualArguments(action);
//#endif 


//#if 2038845778 
for (Object argument : args) //1
{ 

//#if 427084358 
addElementListener(listener, argument,
                                   new String[] {"remove", "value"});
//#endif 

} 

//#endif 


//#if -763884989 
if(Model.getFacade().isACallAction(action))//1
{ 

//#if 934878808 
Object operation = Model.getFacade().getOperation(action);
//#endif 


//#if -1346664475 
if(Model.getFacade().isAOperation(operation))//1
{ 

//#if 1414085647 
addElementListener(listener, operation,
                                       new String[] {"name"});
//#endif 

} 

//#endif 

} 

//#endif 


//#if -819451667 
if(Model.getFacade().isASendAction(action))//1
{ 

//#if 1766209104 
Object signal = Model.getFacade().getSignal(action);
//#endif 


//#if 367874925 
if(Model.getFacade().isASignal(signal))//1
{ 

//#if -896161921 
addElementListener(listener, signal,
                                       new String[] {"name"});
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 599604446 
public MessageNotation(Object message)
    { 

//#if 76007905 
if(!Model.getFacade().isAMessage(message))//1
{ 

//#if -1300956194 
throw new IllegalArgumentException("This is not an Message.");
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

