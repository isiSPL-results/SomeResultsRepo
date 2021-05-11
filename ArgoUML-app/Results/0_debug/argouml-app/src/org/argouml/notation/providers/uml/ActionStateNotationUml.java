
//#if -832460390 
// Compilation Unit of /ActionStateNotationUml.java 
 

//#if 1822466722 
package org.argouml.notation.providers.uml;
//#endif 


//#if -1460122710 
import java.util.Map;
//#endif 


//#if -1626800897 
import org.argouml.model.Model;
//#endif 


//#if -211223086 
import org.argouml.notation.NotationSettings;
//#endif 


//#if -550830386 
import org.argouml.notation.providers.ActionStateNotation;
//#endif 


//#if 168611616 
public class ActionStateNotationUml extends 
//#if -1375615675 
ActionStateNotation
//#endif 

  { 

//#if 814762926 
public String getParsingHelp()
    { 

//#if -1598416181 
return "parsing.help.fig-actionstate";
//#endif 

} 

//#endif 


//#if 2011216541 
public ActionStateNotationUml(Object actionState)
    { 

//#if -1648795792 
super(actionState);
//#endif 

} 

//#endif 


//#if 2063470457 
@Deprecated
    @Override
    public String toString(Object modelElement, Map args)
    { 

//#if -1571751275 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if -377113353 
private String toString(Object modelElement)
    { 

//#if 1457542653 
String ret = "";
//#endif 


//#if 907331064 
Object action = Model.getFacade().getEntry(modelElement);
//#endif 


//#if 2087158907 
if(action != null)//1
{ 

//#if 1801973308 
Object expression = Model.getFacade().getScript(action);
//#endif 


//#if 1369835571 
if(expression != null)//1
{ 

//#if 1845208683 
ret = (String) Model.getFacade().getBody(expression);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -202023491 
return (ret == null) ? "" : ret;
//#endif 

} 

//#endif 


//#if -878519909 
public void parse(Object modelElement, String text)
    { 

//#if 1751917811 
Object entry = Model.getFacade().getEntry(modelElement);
//#endif 


//#if -475687751 
String language = "";
//#endif 


//#if 1107070760 
if(entry == null)//1
{ 

//#if 1693395034 
entry =
                Model.getCommonBehaviorFactory()
                .buildUninterpretedAction(modelElement);
//#endif 

} 
else
{ 

//#if -1035878371 
Object script = Model.getFacade().getScript(entry);
//#endif 


//#if -865963956 
if(script != null)//1
{ 

//#if -597442464 
language = Model.getDataTypesHelper().getLanguage(script);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -329015564 
Object actionExpression =
            Model.getDataTypesFactory().createActionExpression(language, text);
//#endif 


//#if -326005448 
Model.getCommonBehaviorHelper().setScript(entry, actionExpression);
//#endif 

} 

//#endif 


//#if 131734677 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if -421349538 
return toString(modelElement);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

