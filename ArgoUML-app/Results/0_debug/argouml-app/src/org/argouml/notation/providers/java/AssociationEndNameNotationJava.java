
//#if 559875046 
// Compilation Unit of /AssociationEndNameNotationJava.java 
 

//#if -804916081 
package org.argouml.notation.providers.java;
//#endif 


//#if -980833479 
import java.util.Map;
//#endif 


//#if -1127285550 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if -467822397 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if -1276045317 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if 74413518 
import org.argouml.model.Model;
//#endif 


//#if 1887985761 
import org.argouml.notation.NotationSettings;
//#endif 


//#if -1003081037 
import org.argouml.notation.providers.AssociationEndNameNotation;
//#endif 


//#if -1032661386 
import org.argouml.notation.providers.uml.NotationUtilityUml;
//#endif 


//#if -276791389 
public class AssociationEndNameNotationJava extends 
//#if -410263792 
AssociationEndNameNotation
//#endif 

  { 

//#if -1441161278 
private static final AssociationEndNameNotationJava INSTANCE =
        new AssociationEndNameNotationJava();
//#endif 


//#if -953734902 

//#if 334608354 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    public String toString(Object modelElement, Map args)
    { 

//#if -101188050 
return toString(modelElement,
                        NotationUtilityUml.isValue("useGuillemets", args));
//#endif 

} 

//#endif 


//#if 582789837 
public static final AssociationEndNameNotationJava getInstance()
    { 

//#if -236493462 
return INSTANCE;
//#endif 

} 

//#endif 


//#if 1447435040 
private String toString(Object modelElement, boolean useGuillemets)
    { 

//#if -805794127 
String name = Model.getFacade().getName(modelElement);
//#endif 


//#if -1477010937 
if(name == null)//1
{ 

//#if -1448491663 
name = "";
//#endif 

} 

//#endif 


//#if -1665944418 
Object visi = Model.getFacade().getVisibility(modelElement);
//#endif 


//#if -1942275777 
String visibility = "";
//#endif 


//#if -189700383 
if(visi != null)//1
{ 

//#if 2015350249 
visibility = NotationUtilityJava.generateVisibility(visi);
//#endif 

} 

//#endif 


//#if -1961196678 
if(name.length() < 1)//1
{ 

//#if -986112388 
visibility = "";
//#endif 

} 

//#endif 


//#if -588125437 
String stereoString =
            NotationUtilityUml.generateStereotype(modelElement, useGuillemets);
//#endif 


//#if 1963639147 
return stereoString + visibility + name;
//#endif 

} 

//#endif 


//#if 1131677030 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if 79151431 
return toString(modelElement, settings.isUseGuillemets());
//#endif 

} 

//#endif 


//#if -76354033 
protected AssociationEndNameNotationJava()
    { 

//#if 1304884300 
super();
//#endif 

} 

//#endif 


//#if 1947667007 
public String getParsingHelp()
    { 

//#if -996221476 
return "Parsing in Java not yet supported";
//#endif 

} 

//#endif 


//#if 1807185388 
public void parse(Object modelElement, String text)
    { 

//#if 879074714 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                    ArgoEventTypes.HELP_CHANGED, this,
                                    "Parsing in Java not yet supported"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

