
//#if 1231585441 
// Compilation Unit of /MultiplicityNotationUml.java 
 

//#if 76518522 
package org.argouml.notation.providers.uml;
//#endif 


//#if 1573986055 
import java.text.ParseException;
//#endif 


//#if 652881794 
import java.util.Map;
//#endif 


//#if -434098327 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if -453854964 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if -582858094 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if -1723025519 
import org.argouml.i18n.Translator;
//#endif 


//#if -1892551977 
import org.argouml.model.Model;
//#endif 


//#if 1264769450 
import org.argouml.notation.NotationSettings;
//#endif 


//#if -986941054 
import org.argouml.notation.providers.MultiplicityNotation;
//#endif 


//#if -1789041470 
public class MultiplicityNotationUml extends 
//#if 763390805 
MultiplicityNotation
//#endif 

  { 

//#if 239030200 
@Override
    public void parse(final Object multiplicityOwner, final String text)
    { 

//#if -1636832467 
try //1
{ 

//#if 1272089323 
parseMultiplicity(multiplicityOwner, text);
//#endif 

} 

//#if -1517695815 
catch (ParseException pe) //1
{ 

//#if 35802799 
final String msg = "statusmsg.bar.error.parsing.multiplicity";
//#endif 


//#if -1355422554 
final Object[] args = {pe.getLocalizedMessage(),
                                   Integer.valueOf(pe.getErrorOffset()),
                                  };
//#endif 


//#if 690013295 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 2099120910 
@Override
    public String getParsingHelp()
    { 

//#if -1824077973 
return "parsing.help.fig-multiplicity";
//#endif 

} 

//#endif 


//#if -181455610 
public MultiplicityNotationUml(Object multiplicityOwner)
    { 

//#if 228706193 
super(multiplicityOwner);
//#endif 

} 

//#endif 


//#if 1463804604 

//#if -1224474349 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    public String toString(Object multiplicityOwner, Map args)
    { 

//#if 1685859311 
return NotationUtilityUml.generateMultiplicity(
                   multiplicityOwner, args);
//#endif 

} 

//#endif 


//#if -2108138453 
protected Object parseMultiplicity(final Object multiplicityOwner,
                                       final String s1) throws ParseException
    { 

//#if 1581244048 
String s = s1.trim();
//#endif 


//#if -1296067708 
Object multi = null;
//#endif 


//#if 868513859 
try //1
{ 

//#if -614165804 
multi = Model.getDataTypesFactory().createMultiplicity(s);
//#endif 

} 

//#if -266471539 
catch (IllegalArgumentException iae) //1
{ 

//#if 427557380 
throw new ParseException(iae.getLocalizedMessage(), 0);
//#endif 

} 

//#endif 


//#endif 


//#if -709521680 
Model.getCoreHelper().setMultiplicity(multiplicityOwner, multi);
//#endif 


//#if -964595937 
return multi;
//#endif 

} 

//#endif 


//#if -2052257935 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if 1226045293 
return NotationUtilityUml.generateMultiplicity(modelElement,
                settings.isShowSingularMultiplicities());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

