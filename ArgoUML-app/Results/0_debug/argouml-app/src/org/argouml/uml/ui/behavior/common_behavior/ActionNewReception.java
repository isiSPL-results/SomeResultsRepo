
//#if -1347665682 
// Compilation Unit of /ActionNewReception.java 
 

//#if 63779495 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 747854421 
import java.awt.event.ActionEvent;
//#endif 


//#if -68514613 
import javax.swing.Action;
//#endif 


//#if 607639744 
import org.argouml.i18n.Translator;
//#endif 


//#if -1081932922 
import org.argouml.model.Model;
//#endif 


//#if -1428104164 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -405383535 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 1160950823 
public class ActionNewReception extends 
//#if -277329732 
AbstractActionNewModelElement
//#endif 

  { 

//#if 2071981614 
public ActionNewReception()
    { 

//#if 449915866 
super("button.new-reception");
//#endif 


//#if 2021106632 
putValue(Action.NAME, Translator.localize("button.new-reception"));
//#endif 

} 

//#endif 


//#if 1461522126 
public void actionPerformed(ActionEvent e)
    { 

//#if 320598259 
super.actionPerformed(e);
//#endif 


//#if 92993496 
Object classifier =
            TargetManager.getInstance().getModelTarget();
//#endif 


//#if 668440277 
if(!Model.getFacade().isAClassifier(classifier))//1
{ 

//#if 929542840 
throw new IllegalArgumentException(
                "Argument classifier is null or not a classifier. Got: "
                + classifier);
//#endif 

} 

//#endif 


//#if -1496676183 
Object reception =
            Model.getCommonBehaviorFactory().buildReception(classifier);
//#endif 


//#if 1510030181 
TargetManager.getInstance().setTarget(reception);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

