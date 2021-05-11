package org.argouml.notation.providers.uml;
import java.text.ParseException;
import java.util.Map;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoHelpEvent;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.providers.MultiplicityNotation;
public class MultiplicityNotationUml extends MultiplicityNotation
  { 
@Override
    public void parse(final Object multiplicityOwner, final String text)
    { 
try//1
{ 
parseMultiplicity(multiplicityOwner, text);
} 
catch (ParseException pe) //1
{ 
final String msg = "statusmsg.bar.error.parsing.multiplicity";
final Object[] args = {pe.getLocalizedMessage(),
                                   Integer.valueOf(pe.getErrorOffset()),
                                  };
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
} 
} 
@Override
    public String getParsingHelp()
    { 
return "parsing.help.fig-multiplicity";
} 
public MultiplicityNotationUml(Object multiplicityOwner)
    { 
super(multiplicityOwner);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    @Override
    public String toString(Object multiplicityOwner, Map args)
    { 
return NotationUtilityUml.generateMultiplicity(
                   multiplicityOwner, args);
} 
protected Object parseMultiplicity(final Object multiplicityOwner,
                                       final String s1) throws ParseException
    { 
String s = s1.trim();
Object multi = null;
try//1
{ 
multi = Model.getDataTypesFactory().createMultiplicity(s);
} 
catch (IllegalArgumentException iae) //1
{ 
throw new ParseException(iae.getLocalizedMessage(), 0);
} 
Model.getCoreHelper().setMultiplicity(multiplicityOwner, multi);
return multi;
} 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 
return NotationUtilityUml.generateMultiplicity(modelElement,
                settings.isShowSingularMultiplicities());
} 

 } 
