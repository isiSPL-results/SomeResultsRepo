
//#if 127931465 
// Compilation Unit of /AssociationNameNotationJava.java 
 

//#if 89698610 
package org.argouml.notation.providers.java;
//#endif 


//#if -672880414 
import java.beans.PropertyChangeListener;
//#endif 


//#if 627725331 
import java.text.ParseException;
//#endif 


//#if 92252662 
import java.util.Map;
//#endif 


//#if 691562101 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if 81879936 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 542802334 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if 389076741 
import org.argouml.i18n.Translator;
//#endif 


//#if 1817701451 
import org.argouml.model.Model;
//#endif 


//#if -443729890 
import org.argouml.notation.NotationSettings;
//#endif 


//#if -34194831 
import org.argouml.notation.providers.AssociationNameNotation;
//#endif 


//#if -542043565 
public class AssociationNameNotationJava extends 
//#if 1882258435 
AssociationNameNotation
//#endif 

  { 

//#if 2074670027 
public AssociationNameNotationJava(Object modelElement)
    { 

//#if -384435115 
super(modelElement);
//#endif 

} 

//#endif 


//#if -1570062780 

//#if 1737703202 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    public String toString(final Object modelElement, final Map args)
    { 

//#if -394207558 
String name;
//#endif 


//#if 911646619 
name = Model.getFacade().getName(modelElement);
//#endif 


//#if -1218131872 
if(name == null)//1
{ 

//#if -1626487250 
return "";
//#endif 

} 

//#endif 


//#if 1726726952 
return NotationUtilityJava.generateLeaf(modelElement, args)
               + NotationUtilityJava.generateAbstract(modelElement, args)
               + NotationUtilityJava.generateVisibility(modelElement, args)
               + NotationUtilityJava.generatePath(modelElement, args)
               + name;
//#endif 

} 

//#endif 


//#if 2004188534 
public void parse(final Object modelElement, final String text)
    { 

//#if -1442790158 
try //1
{ 

//#if -1338792893 
ModelElementNameNotationJava.parseModelElement(modelElement, text);
//#endif 

} 

//#if -569075814 
catch (ParseException pe) //1
{ 

//#if -419217731 
final String msg = "statusmsg.bar.error.parsing.node-modelelement";
//#endif 


//#if -1004141917 
final Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
//#endif 


//#if 1458058476 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1842598153 
@Override
    public void initialiseListener(final PropertyChangeListener listener,
                                   final Object modelElement)
    { 

//#if -1079714106 
addElementListener(listener, modelElement,
                           new String[] {"isLeaf"});
//#endif 


//#if 2110791588 
super.initialiseListener(listener, modelElement);
//#endif 

} 

//#endif 


//#if 695335617 
public String getParsingHelp()
    { 

//#if -165707201 
return "parsing.help.java.fig-nodemodelelement";
//#endif 

} 

//#endif 


//#if 753593072 
@Override
    public String toString(final Object modelElement,
                           final NotationSettings settings)
    { 

//#if 1785747529 
String name;
//#endif 


//#if 1648031082 
name = Model.getFacade().getName(modelElement);
//#endif 


//#if 682662575 
if(name == null)//1
{ 

//#if 1518158627 
return "";
//#endif 

} 

//#endif 


//#if -1718773865 
String visibility = "";
//#endif 


//#if 316210038 
if(settings.isShowVisibilities())//1
{ 

//#if 1067035432 
visibility = NotationUtilityJava.generateVisibility(modelElement);
//#endif 

} 

//#endif 


//#if 1133629546 
String path = "";
//#endif 


//#if -607185702 
if(settings.isShowPaths())//1
{ 

//#if -1968849653 
path = NotationUtilityJava.generatePath(modelElement);
//#endif 

} 

//#endif 


//#if -451840095 
return NotationUtilityJava.generateLeaf(modelElement)
               + NotationUtilityJava.generateAbstract(modelElement)
               + visibility
               + path
               + name;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

