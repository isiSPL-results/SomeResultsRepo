// Compilation Unit of /ExtensionPointNotationUml.java 
 
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

//#if USECASE 
if(ep == null)//1
{ 
return;
} 

//#endif 


//#if USECASE 
Object useCase = Model.getFacade().getUseCase(ep);
//#endif 


//#if USECASE 
if(useCase == null)//1
{ 
return;
} 

//#endif 


//#if USECASE 
Object newEp = parseExtensionPoint(text);
//#endif 


//#if USECASE 
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

//#endif 

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


//#if USECASE 
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


//#if USECASE 
ep = null;
//#endif 


//#if USECASE 
break;

//#endif 


case 1://1


//#if USECASE 
epLocation = st.nextToken().trim();
//#endif 


//#if USECASE 
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

//#endif 


//#if USECASE 
break;

//#endif 


case 2://1


//#if USECASE 
epName = st.nextToken().trim();
//#endif 


//#if USECASE 
Model.getCoreHelper().setName(ep, epName);
//#endif 


//#if USECASE 
Model.getUseCasesHelper().setLocation(ep, null);
//#endif 


//#if USECASE 
break;

//#endif 


case 3://1


//#if USECASE 
epName = st.nextToken().trim();
//#endif 


//#if USECASE 
st.nextToken();
//#endif 


//#if USECASE 
epLocation = st.nextToken().trim();
//#endif 


//#if USECASE 
Model.getCoreHelper().setName(ep, epName);
//#endif 


//#if USECASE 
Model.getUseCasesHelper().setLocation(ep, epLocation);
//#endif 


//#if USECASE 
break;

//#endif 


} 

return ep;
} 

//#endif 

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


