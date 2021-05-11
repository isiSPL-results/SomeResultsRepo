package org.argouml.notation.providers.uml;
import java.util.Map;
import java.util.StringTokenizer;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.providers.ExtensionPointNotation;
public class ExtensionPointNotationUml extends ExtensionPointNotation
  { 
public String getParsingHelp()
    { 
return "parsing.help.fig-extensionpoint";
} 
public void parseExtensionPointFig(Object ep, String text)
    { 
} 
private String toString(final Object modelElement)
    { 
if(modelElement == null)//1
{ 
return "";
} 
String s = "";
String epName = Model.getFacade().getName(modelElement);
String epLocation = Model.getFacade().getLocation(modelElement);
if((epName != null) && (epName.length() > 0))//1
{ 
s += epName + ": ";
} 
if((epLocation != null) && (epLocation.length() > 0))//1
{ 
s += epLocation;
} 
return s;
} 
public void parse(Object modelElement, String text)
    { 
parseExtensionPointFig(modelElement, text);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public String toString(Object modelElement, Map args)
    { 
return toString(modelElement);
} 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 
return toString(modelElement);
} 
public ExtensionPointNotationUml(Object ep)
    { 
super(ep);
} 

 } 
