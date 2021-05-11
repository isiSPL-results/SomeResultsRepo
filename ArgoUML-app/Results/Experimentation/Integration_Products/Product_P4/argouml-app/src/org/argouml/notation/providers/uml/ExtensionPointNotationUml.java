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
if(ep == null)//1
{ 
return;
} 
Object useCase = Model.getFacade().getUseCase(ep);
if(useCase == null)//1
{ 
return;
} 
Object newEp = parseExtensionPoint(text);
if(newEp == null)//1
{ 
ProjectManager.getManager().getCurrentProject().moveToTrash(ep);
} 
else
{ 
Model.getCoreHelper().setName(ep, Model.getFacade().getName(newEp));
Model.getUseCasesHelper().setLocation(ep,
                                                  Model.getFacade().getLocation(newEp));
} 
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
private Object parseExtensionPoint(String text)
    { 
if(text == null)//1
{ 
return null;
} 
Object ep =
            Model.getUseCasesFactory().createExtensionPoint();
StringTokenizer st = new StringTokenizer(text.trim(), ":", true);
int numTokens = st.countTokens();
String epLocation;
String epName;
switch (numTokens) //1
{ 
case 0://1

ep = null;
break;


case 1://1

epLocation = st.nextToken().trim();
if(epLocation.equals(":"))//1
{ 
Model.getCoreHelper().setName(ep, null);
Model.getUseCasesHelper().setLocation(ep, null);
} 
else
{ 
Model.getCoreHelper().setName(ep, null);
Model.getUseCasesHelper().setLocation(ep, epLocation);
} 
break;


case 2://1

epName = st.nextToken().trim();
Model.getCoreHelper().setName(ep, epName);
Model.getUseCasesHelper().setLocation(ep, null);
break;


case 3://1

epName = st.nextToken().trim();
st.nextToken();
epLocation = st.nextToken().trim();
Model.getCoreHelper().setName(ep, epName);
Model.getUseCasesHelper().setLocation(ep, epLocation);
break;


} 
return ep;
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
