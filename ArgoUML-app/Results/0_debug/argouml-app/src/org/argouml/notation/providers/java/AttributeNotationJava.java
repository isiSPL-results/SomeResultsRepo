
//#if 608234690 
// Compilation Unit of /AttributeNotationJava.java 
 

//#if 755347532 
package org.argouml.notation.providers.java;
//#endif 


//#if -70705124 
import java.util.Map;
//#endif 


//#if 510241679 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if -1244085850 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 361481912 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if 1605921521 
import org.argouml.model.Model;
//#endif 


//#if -1283449788 
import org.argouml.notation.NotationSettings;
//#endif 


//#if -899478629 
import org.argouml.notation.providers.AttributeNotation;
//#endif 


//#if 149376425 
public class AttributeNotationJava extends 
//#if -203388893 
AttributeNotation
//#endif 

  { 

//#if -2021882830 
private static final AttributeNotationJava INSTANCE =
        new AttributeNotationJava();
//#endif 


//#if 2042836276 
private String toString(Object modelElement)
    { 

//#if -511993765 
StringBuffer sb = new StringBuffer(80);
//#endif 


//#if -1145644165 
sb.append(NotationUtilityJava.generateVisibility(modelElement));
//#endif 


//#if 1411755851 
sb.append(NotationUtilityJava.generateScope(modelElement));
//#endif 


//#if 1146493297 
sb.append(NotationUtilityJava.generateChangeability(modelElement));
//#endif 


//#if -1332192064 
Object type = Model.getFacade().getType(modelElement);
//#endif 


//#if -859904384 
Object multi = Model.getFacade().getMultiplicity(modelElement);
//#endif 


//#if -1646064513 
if(type != null && multi != null)//1
{ 

//#if 2092089903 
if(Model.getFacade().getUpper(multi) == 1)//1
{ 

//#if 874377285 
sb.append(NotationUtilityJava.generateClassifierRef(type))
                .append(' ');
//#endif 

} 
else

//#if -1730862657 
if(Model.getFacade().isADataType(type))//1
{ 

//#if -1796193341 
sb.append(NotationUtilityJava.generateClassifierRef(type))
                .append("[] ");
//#endif 

} 
else
{ 

//#if -616928627 
sb.append("java.util.Vector ");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 290791917 
sb.append(Model.getFacade().getName(modelElement));
//#endif 


//#if -923905289 
Object init = Model.getFacade().getInitialValue(modelElement);
//#endif 


//#if -1330932605 
if(init != null)//1
{ 

//#if -444972030 
String initStr =
                NotationUtilityJava.generateExpression(init).trim();
//#endif 


//#if -1785744978 
if(initStr.length() > 0)//1
{ 

//#if -465312747 
sb.append(" = ").append(initStr);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1325458466 
return sb.toString();
//#endif 

} 

//#endif 


//#if -1088480096 

//#if 1811196322 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public String toString(Object modelElement, Map args)
    { 

//#if -1145116997 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if -145477456 
public static final AttributeNotationJava getInstance()
    { 

//#if 1783918076 
return INSTANCE;
//#endif 

} 

//#endif 


//#if -1688324274 
protected AttributeNotationJava()
    { 

//#if -1621563485 
super();
//#endif 

} 

//#endif 


//#if -1512155144 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if 2110302803 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if 1091972177 
public String getParsingHelp()
    { 

//#if -1759640761 
return "Parsing in Java not yet supported";
//#endif 

} 

//#endif 


//#if -1376979074 
public void parse(Object modelElement, String text)
    { 

//#if -316639928 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                    ArgoEventTypes.HELP_CHANGED, this,
                                    "Parsing in Java not yet supported"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

