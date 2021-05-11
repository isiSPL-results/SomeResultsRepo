
//#if -1513234745 
// Compilation Unit of /Notation.java 
 

//#if 1038660430 
package org.argouml.notation;
//#endif 


//#if -1234378016 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1094771800 
import java.beans.PropertyChangeListener;
//#endif 


//#if 210655648 
import java.util.List;
//#endif 


//#if 567962557 
import javax.swing.Icon;
//#endif 


//#if 1697160175 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if 1190649158 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 1877619737 
import org.argouml.application.events.ArgoNotationEvent;
//#endif 


//#if -2060760758 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -2092267529 
import org.argouml.configuration.Configuration;
//#endif 


//#if 2118987936 
import org.argouml.configuration.ConfigurationKey;
//#endif 


//#if -906439906 
import org.apache.log4j.Logger;
//#endif 


//#if 865192645 
public final class Notation implements 
//#if 642201725 
PropertyChangeListener
//#endif 

  { 

//#if -1477835048 
private static final String DEFAULT_NOTATION_NAME = "UML";
//#endif 


//#if -2047448520 
private static final String DEFAULT_NOTATION_VERSION = "1.4";
//#endif 


//#if 241746793 
public static final String DEFAULT_NOTATION = DEFAULT_NOTATION_NAME + " "
            + DEFAULT_NOTATION_VERSION;
//#endif 


//#if 1828661399 
private static NotationName notationArgo =
        makeNotation(
            DEFAULT_NOTATION_NAME,
            DEFAULT_NOTATION_VERSION,
            ResourceLoaderWrapper.lookupIconResource("UmlNotation"));
//#endif 


//#if -631440753 
public static final ConfigurationKey KEY_DEFAULT_NOTATION =
        Configuration.makeKey("notation", "default");
//#endif 


//#if 587978151 
public static final ConfigurationKey KEY_SHOW_STEREOTYPES =
        Configuration.makeKey("notation", "navigation", "show", "stereotypes");
//#endif 


//#if 1858448222 
public static final ConfigurationKey KEY_SHOW_SINGULAR_MULTIPLICITIES =
        Configuration.makeKey("notation", "show", "singularmultiplicities");
//#endif 


//#if 1779528760 
public static final ConfigurationKey KEY_SHOW_BOLD_NAMES =
        Configuration.makeKey("notation", "show", "bold", "names");
//#endif 


//#if 1014740048 
public static final ConfigurationKey KEY_USE_GUILLEMOTS =
        Configuration.makeKey("notation", "guillemots");
//#endif 


//#if -285411802 
public static final ConfigurationKey KEY_SHOW_ASSOCIATION_NAMES =
        Configuration.makeKey("notation", "show", "associationnames");
//#endif 


//#if -1532719529 
public static final ConfigurationKey KEY_SHOW_VISIBILITY =
        Configuration.makeKey("notation", "show", "visibility");
//#endif 


//#if -1845626563 
public static final ConfigurationKey KEY_SHOW_MULTIPLICITY =
        Configuration.makeKey("notation", "show", "multiplicity");
//#endif 


//#if -150231692 
public static final ConfigurationKey KEY_SHOW_INITIAL_VALUE =
        Configuration.makeKey("notation", "show", "initialvalue");
//#endif 


//#if 1173776725 
public static final ConfigurationKey KEY_SHOW_PROPERTIES =
        Configuration.makeKey("notation", "show", "properties");
//#endif 


//#if 2132880657 
public static final ConfigurationKey KEY_SHOW_TYPES =
        Configuration.makeKey("notation", "show", "types");
//#endif 


//#if 971960173 
public static final ConfigurationKey KEY_DEFAULT_SHADOW_WIDTH =
        Configuration.makeKey("notation", "default", "shadow-width");
//#endif 


//#if -958180341 
public static final ConfigurationKey KEY_HIDE_BIDIRECTIONAL_ARROWS =
        Configuration.makeKey("notation", "hide", "bidirectional-arrows");
//#endif 


//#if -1687072331 
private static final Notation SINGLETON = new Notation();
//#endif 


//#if -1368072852 
private static final Logger LOG = Logger.getLogger(Notation.class);
//#endif 


//#if 1480744258 
private Notation()
    { 

//#if -1551561501 
Configuration.addListener(KEY_SHOW_BOLD_NAMES, this);
//#endif 


//#if 220203042 
Configuration.addListener(KEY_USE_GUILLEMOTS, this);
//#endif 


//#if 188132133 
Configuration.addListener(KEY_DEFAULT_NOTATION, this);
//#endif 


//#if 469833166 
Configuration.addListener(KEY_SHOW_TYPES, this);
//#endif 


//#if -1163393550 
Configuration.addListener(KEY_SHOW_MULTIPLICITY, this);
//#endif 


//#if 1992812798 
Configuration.addListener(KEY_SHOW_PROPERTIES, this);
//#endif 


//#if 1311155901 
Configuration.addListener(KEY_SHOW_ASSOCIATION_NAMES, this);
//#endif 


//#if 240880191 
Configuration.addListener(KEY_SHOW_VISIBILITY, this);
//#endif 


//#if -1708385263 
Configuration.addListener(KEY_SHOW_INITIAL_VALUE, this);
//#endif 


//#if 487494960 
Configuration.addListener(KEY_HIDE_BIDIRECTIONAL_ARROWS, this);
//#endif 

} 

//#endif 


//#if 2015334272 
public static void setDefaultNotation(NotationName n)
    { 

//#if 588813320 
LOG.info("default notation set to " + n.getConfigurationValue());
//#endif 


//#if -547098548 
Configuration.setString(
            KEY_DEFAULT_NOTATION,
            n.getConfigurationValue());
//#endif 

} 

//#endif 


//#if -2070866481 
public static NotationName getConfiguredNotation()
    { 

//#if -930431979 
NotationName n =
            NotationNameImpl.findNotation(
                Configuration.getString(
                    KEY_DEFAULT_NOTATION,
                    notationArgo.getConfigurationValue()));
//#endif 


//#if -1601771946 
if(n == null)//1
{ 

//#if 1686406958 
n = NotationNameImpl.findNotation(DEFAULT_NOTATION);
//#endif 

} 

//#endif 


//#if 598051277 
LOG.debug("default notation is " + n.getConfigurationValue());
//#endif 


//#if 1319333249 
return n;
//#endif 

} 

//#endif 


//#if -2099101553 
public static Notation getInstance()
    { 

//#if 158476652 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 645760970 
public void propertyChange(PropertyChangeEvent pce)
    { 

//#if -1160131146 
LOG.info(
            "Notation change:"
            + pce.getOldValue()
            + " to "
            + pce.getNewValue());
//#endif 


//#if -1998256607 
ArgoEventPump.fireEvent(
            new ArgoNotationEvent(ArgoEventTypes.NOTATION_CHANGED, pce));
//#endif 

} 

//#endif 


//#if -537816872 
public static boolean removeNotation(NotationName theNotation)
    { 

//#if -548675651 
return NotationNameImpl.removeNotation(theNotation);
//#endif 

} 

//#endif 


//#if 1022108945 
public static List<NotationName> getAvailableNotations()
    { 

//#if 1076409571 
return NotationNameImpl.getAvailableNotations();
//#endif 

} 

//#endif 


//#if 1756070632 
public static NotationName makeNotation(String k1, String k2, Icon icon)
    { 

//#if -1957934825 
NotationName nn = NotationNameImpl.makeNotation(k1, k2, icon);
//#endif 


//#if -1964300463 
return nn;
//#endif 

} 

//#endif 


//#if 1378922924 
public static NotationName findNotation(String s)
    { 

//#if -632719206 
return NotationNameImpl.findNotation(s);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

