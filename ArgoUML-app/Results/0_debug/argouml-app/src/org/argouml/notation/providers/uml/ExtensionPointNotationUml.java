
//#if -1985048348 
// Compilation Unit of /ExtensionPointNotationUml.java 
 

//#if 1188522577 
package org.argouml.notation.providers.uml;
//#endif 


//#if 1986003097 
import java.util.Map;
//#endif 


//#if -1167013329 
import java.util.StringTokenizer;
//#endif 


//#if 1440321101 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -421358802 
import org.argouml.model.Model;
//#endif 


//#if 453809601 
import org.argouml.notation.NotationSettings;
//#endif 


//#if -258496825 
import org.argouml.notation.providers.ExtensionPointNotation;
//#endif 


//#if 1564773831 
public class ExtensionPointNotationUml extends 
//#if -1545268520 
ExtensionPointNotation
//#endif 

  { 

//#if 566669883 
public String getParsingHelp()
    { 

//#if 342233141 
return "parsing.help.fig-extensionpoint";
//#endif 

} 

//#endif 


//#if -1816415665 
public void parseExtensionPointFig(Object ep, String text)
    { 

//#if 1919417434 
if(ep == null)//1
{ 

//#if -238090908 
return;
//#endif 

} 

//#endif 


//#if -878833518 
Object useCase = Model.getFacade().getUseCase(ep);
//#endif 


//#if -1992602234 
if(useCase == null)//1
{ 

//#if 777137710 
return;
//#endif 

} 

//#endif 


//#if -1835917569 
Object newEp = parseExtensionPoint(text);
//#endif 


//#if -1089493606 
if(newEp == null)//1
{ 

//#if 1881069982 
ProjectManager.getManager().getCurrentProject().moveToTrash(ep);
//#endif 

} 
else
{ 

//#if -709678748 
Model.getCoreHelper().setName(ep, Model.getFacade().getName(newEp));
//#endif 


//#if -819402687 
Model.getUseCasesHelper().setLocation(ep,
                                                  Model.getFacade().getLocation(newEp));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 317418254 
private String toString(final Object modelElement)
    { 

//#if -2015008154 
if(modelElement == null)//1
{ 

//#if -1894191309 
return "";
//#endif 

} 

//#endif 


//#if -2112861511 
String s = "";
//#endif 


//#if 1853528413 
String epName = Model.getFacade().getName(modelElement);
//#endif 


//#if -1349106167 
String epLocation = Model.getFacade().getLocation(modelElement);
//#endif 


//#if -2114210596 
if((epName != null) && (epName.length() > 0))//1
{ 

//#if -1116688272 
s += epName + ": ";
//#endif 

} 

//#endif 


//#if -200522960 
if((epLocation != null) && (epLocation.length() > 0))//1
{ 

//#if 1846901791 
s += epLocation;
//#endif 

} 

//#endif 


//#if 1550421823 
return s;
//#endif 

} 

//#endif 


//#if 1159960296 
public void parse(Object modelElement, String text)
    { 

//#if 915028618 
parseExtensionPointFig(modelElement, text);
//#endif 

} 

//#endif 


//#if 1438144886 

//#if -160751390 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public String toString(Object modelElement, Map args)
    { 

//#if -1950871903 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if 1786734698 
private Object parseExtensionPoint(String text)
    { 

//#if 1082637480 
if(text == null)//1
{ 

//#if -495101428 
return null;
//#endif 

} 

//#endif 


//#if 758919665 
Object ep =
            Model.getUseCasesFactory().createExtensionPoint();
//#endif 


//#if -1314428937 
StringTokenizer st = new StringTokenizer(text.trim(), ":", true);
//#endif 


//#if -208491599 
int numTokens = st.countTokens();
//#endif 


//#if 190129931 
String epLocation;
//#endif 


//#if 1706189173 
String epName;
//#endif 


//#if -4547248 
switch (numTokens) //1
{ 
case 0://1


//#if -1489977905 
ep = null;
//#endif 


//#if 1068659273 
break;

//#endif 


case 1://1


//#if 1628754617 
epLocation = st.nextToken().trim();
//#endif 


//#if -906766875 
if(epLocation.equals(":"))//1
{ 

//#if -1091230317 
Model.getCoreHelper().setName(ep, null);
//#endif 


//#if -1670047014 
Model.getUseCasesHelper().setLocation(ep, null);
//#endif 

} 
else
{ 

//#if 755212096 
Model.getCoreHelper().setName(ep, null);
//#endif 


//#if 2145209024 
Model.getUseCasesHelper().setLocation(ep, epLocation);
//#endif 

} 

//#endif 


//#if -1592150364 
break;

//#endif 


case 2://1


//#if 1071905570 
epName = st.nextToken().trim();
//#endif 


//#if 1010566230 
Model.getCoreHelper().setName(ep, epName);
//#endif 


//#if -204582770 
Model.getUseCasesHelper().setLocation(ep, null);
//#endif 


//#if 1950094341 
break;

//#endif 


case 3://1


//#if 1211222816 
epName = st.nextToken().trim();
//#endif 


//#if 1240575734 
st.nextToken();
//#endif 


//#if 1683866038 
epLocation = st.nextToken().trim();
//#endif 


//#if -783562924 
Model.getCoreHelper().setName(ep, epName);
//#endif 


//#if 1208752261 
Model.getUseCasesHelper().setLocation(ep, epLocation);
//#endif 


//#if 1492969927 
break;

//#endif 


} 

//#endif 


//#if 1373077473 
return ep;
//#endif 

} 

//#endif 


//#if -1441459102 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if -6333754 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if -1394906486 
public ExtensionPointNotationUml(Object ep)
    { 

//#if 634526859 
super(ep);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

