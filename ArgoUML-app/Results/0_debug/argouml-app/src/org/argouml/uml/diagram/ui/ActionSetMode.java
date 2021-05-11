
//#if -1812938056 
// Compilation Unit of /ActionSetMode.java 
 

//#if 568856311 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -2132295224 
import java.util.Hashtable;
//#endif 


//#if 1854895611 
import java.util.Properties;
//#endif 


//#if 2051071856 
import javax.swing.Action;
//#endif 


//#if -37699652 
import javax.swing.ImageIcon;
//#endif 


//#if 1606444174 
import org.apache.log4j.Logger;
//#endif 


//#if 66500282 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1614000059 
import org.argouml.i18n.Translator;
//#endif 


//#if -1657402550 
import org.tigris.gef.base.SetModeAction;
//#endif 


//#if 1545130952 
public class ActionSetMode extends 
//#if -1462422194 
SetModeAction
//#endif 

  { 

//#if 421696870 
private static final Logger LOG = Logger.getLogger(ActionSetMode.class);
//#endif 


//#if -1312798039 
public ActionSetMode(Class modeClass, Hashtable modeArgs)
    { 

//#if 389931991 
super(modeClass, modeArgs);
//#endif 

} 

//#endif 


//#if 323068669 
public ActionSetMode(Class modeClass)
    { 

//#if -1431410497 
super(modeClass);
//#endif 

} 

//#endif 


//#if 318592869 
private void putToolTip(String key)
    { 

//#if 585450326 
putValue(Action.SHORT_DESCRIPTION, Translator.localize(key));
//#endif 

} 

//#endif 


//#if 1167528769 
public ActionSetMode(Class modeClass, Hashtable modeArgs, String name)
    { 

//#if -438379624 
super(modeClass);
//#endif 


//#if 952422316 
this.modeArgs = modeArgs;
//#endif 


//#if 617499407 
putToolTip(name);
//#endif 


//#if -1878184321 
putIcon(name);
//#endif 

} 

//#endif 


//#if 389086181 
private void putIcon(String key)
    { 

//#if -758948271 
ImageIcon icon = ResourceLoaderWrapper.lookupIcon(key);
//#endif 


//#if 1126480966 
if(icon != null)//1
{ 

//#if -1905040043 
putValue(Action.SMALL_ICON, icon);
//#endif 

} 
else
{ 

//#if 2130089590 
LOG.debug("Failed to find icon for key " + key);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1264551224 
public ActionSetMode(Class modeClass, boolean sticky)
    { 

//#if 340487077 
super(modeClass, sticky);
//#endif 

} 

//#endif 


//#if -1674260756 
public ActionSetMode(Class modeClass, String name, String tooltipkey)
    { 

//#if 1742650984 
super(modeClass, name);
//#endif 


//#if -1613791749 
putToolTip(tooltipkey);
//#endif 


//#if -881905564 
putIcon(name);
//#endif 

} 

//#endif 


//#if -197240564 
public ActionSetMode(Class modeClass, String arg, Object value,
                         String name)
    { 

//#if 1552311504 
super(modeClass, arg, value);
//#endif 


//#if 1114350296 
putToolTip(name);
//#endif 


//#if -1713958058 
putIcon(name);
//#endif 

} 

//#endif 


//#if -1045639190 
public ActionSetMode(Properties args)
    { 

//#if -555675097 
super(args);
//#endif 

} 

//#endif 


//#if 1653257662 
public ActionSetMode(Class modeClass, String arg, Object value)
    { 

//#if -247268724 
super(modeClass, arg, value);
//#endif 

} 

//#endif 


//#if 815332973 
public ActionSetMode(Class modeClass, String name)
    { 

//#if 1829248486 
super(modeClass);
//#endif 


//#if -1409839779 
putToolTip(name);
//#endif 


//#if 982367985 
putIcon(name);
//#endif 

} 

//#endif 


//#if -1980340789 
public ActionSetMode(
        Class modeClass,
        String arg,
        Object value,
        String name,
        ImageIcon icon)
    { 

//#if 280864094 
super(modeClass, arg, value, name, icon);
//#endif 


//#if -944689128 
putToolTip(name);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

