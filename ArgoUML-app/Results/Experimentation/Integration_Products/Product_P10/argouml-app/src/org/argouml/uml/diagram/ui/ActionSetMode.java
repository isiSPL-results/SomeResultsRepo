package org.argouml.uml.diagram.ui;
import java.util.Hashtable;
import java.util.Properties;
import javax.swing.Action;
import javax.swing.ImageIcon;
import org.apache.log4j.Logger;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.tigris.gef.base.SetModeAction;
public class ActionSetMode extends SetModeAction
  { 
private static final Logger LOG = Logger.getLogger(ActionSetMode.class);
public ActionSetMode(Class modeClass, Hashtable modeArgs)
    { 
super(modeClass, modeArgs);
} 
public ActionSetMode(Class modeClass)
    { 
super(modeClass);
} 
private void putToolTip(String key)
    { 
putValue(Action.SHORT_DESCRIPTION, Translator.localize(key));
} 
public ActionSetMode(Class modeClass, Hashtable modeArgs, String name)
    { 
super(modeClass);
this.modeArgs = modeArgs;
putToolTip(name);
putIcon(name);
} 
private void putIcon(String key)
    { 
ImageIcon icon = ResourceLoaderWrapper.lookupIcon(key);
if(icon != null)//1
{ 
putValue(Action.SMALL_ICON, icon);
} 
else
{ 
LOG.debug("Failed to find icon for key " + key);
} 
} 
public ActionSetMode(Class modeClass, boolean sticky)
    { 
super(modeClass, sticky);
} 
public ActionSetMode(Class modeClass, String name, String tooltipkey)
    { 
super(modeClass, name);
putToolTip(tooltipkey);
putIcon(name);
} 
public ActionSetMode(Class modeClass, String arg, Object value,
                         String name)
    { 
super(modeClass, arg, value);
putToolTip(name);
putIcon(name);
} 
public ActionSetMode(Properties args)
    { 
super(args);
} 
public ActionSetMode(Class modeClass, String arg, Object value)
    { 
super(modeClass, arg, value);
} 
public ActionSetMode(Class modeClass, String name)
    { 
super(modeClass);
putToolTip(name);
putIcon(name);
} 
public ActionSetMode(
        Class modeClass,
        String arg,
        Object value,
        String name,
        ImageIcon icon)
    { 
super(modeClass, arg, value, name, icon);
putToolTip(name);
} 

 } 
