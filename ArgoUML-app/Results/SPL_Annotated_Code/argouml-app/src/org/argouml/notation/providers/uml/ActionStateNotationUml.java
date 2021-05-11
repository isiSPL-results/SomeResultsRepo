// Compilation Unit of /ActionStateNotationUml.java 
 
package org.argouml.notation.providers.uml;
import java.util.Map;
import org.argouml.model.Model;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.providers.ActionStateNotation;
public class ActionStateNotationUml extends ActionStateNotation
  { 
public String getParsingHelp()
    { 
return "parsing.help.fig-actionstate";
} 

public ActionStateNotationUml(Object actionState)
    { 
super(actionState);
} 

@Deprecated
    @Override
    public String toString(Object modelElement, Map args)
    { 
return toString(modelElement);
} 

private String toString(Object modelElement)
    { 
String ret = "";
Object action = Model.getFacade().getEntry(modelElement);
if(action != null)//1
{ 
Object expression = Model.getFacade().getScript(action);
if(expression != null)//1
{ 
ret = (String) Model.getFacade().getBody(expression);
} 

} 

return (ret == null) ? "" : ret;
} 

public void parse(Object modelElement, String text)
    { 
Object entry = Model.getFacade().getEntry(modelElement);
String language = "";
if(entry == null)//1
{ 
entry =
                Model.getCommonBehaviorFactory()
                .buildUninterpretedAction(modelElement);
} 
else
{ 
Object script = Model.getFacade().getScript(entry);
if(script != null)//1
{ 
language = Model.getDataTypesHelper().getLanguage(script);
} 

} 

Object actionExpression =
            Model.getDataTypesFactory().createActionExpression(language, text);
Model.getCommonBehaviorHelper().setScript(entry, actionExpression);
} 

@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 
return toString(modelElement);
} 

 } 


