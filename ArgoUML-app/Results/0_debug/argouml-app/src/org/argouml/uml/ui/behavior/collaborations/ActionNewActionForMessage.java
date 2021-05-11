
//#if -1880525726 
// Compilation Unit of /ActionNewActionForMessage.java 
 

//#if -1924224835 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -744826253 
import java.awt.event.ActionEvent;
//#endif 


//#if 955426856 
import org.argouml.model.Model;
//#endif 


//#if -32650193 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if -1020350306 
public class ActionNewActionForMessage extends 
//#if 1442343366 
AbstractActionNewModelElement
//#endif 

  { 

//#if 2079898470 
private static final ActionNewActionForMessage SINGLETON =
        new ActionNewActionForMessage();
//#endif 


//#if 21151930 
public static ActionNewActionForMessage getInstance()
    { 

//#if -1375056705 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -1278967295 
public ActionNewActionForMessage()
    { 

//#if 1063305319 
super();
//#endif 

} 

//#endif 


//#if -1062941842 
public boolean isEnabled()
    { 

//#if -675668331 
if(getTarget() != null)//1
{ 

//#if -1619412125 
return Model.getFacade().getAction(getTarget()) == null;
//#endif 

} 

//#endif 


//#if -1543735563 
return false;
//#endif 

} 

//#endif 


//#if -375985320 
public void actionPerformed(ActionEvent e)
    { 

//#if 281242971 
super.actionPerformed(e);
//#endif 


//#if 406539152 
Model.getCommonBehaviorFactory().buildAction(getTarget());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

