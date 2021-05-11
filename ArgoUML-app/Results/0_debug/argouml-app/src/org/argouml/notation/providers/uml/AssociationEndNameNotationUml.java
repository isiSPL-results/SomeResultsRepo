
//#if -1269721170 
// Compilation Unit of /AssociationEndNameNotationUml.java 
 

//#if 161888289 
package org.argouml.notation.providers.uml;
//#endif 


//#if 480001472 
import java.text.ParseException;
//#endif 


//#if 331287145 
import java.util.Map;
//#endif 


//#if -149436714 
import java.util.NoSuchElementException;
//#endif 


//#if 1488566178 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if -980797453 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 1339806411 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if 1889071672 
import org.argouml.i18n.Translator;
//#endif 


//#if -1650747138 
import org.argouml.model.Model;
//#endif 


//#if 1700736913 
import org.argouml.notation.NotationSettings;
//#endif 


//#if -46298653 
import org.argouml.notation.providers.AssociationEndNameNotation;
//#endif 


//#if 1665008802 
import org.argouml.uml.StereotypeUtility;
//#endif 


//#if 1344236917 
import org.argouml.util.MyTokenizer;
//#endif 


//#if 674210403 
public class AssociationEndNameNotationUml extends 
//#if 304059744 
AssociationEndNameNotation
//#endif 

  { 

//#if 858389338 

//#if -1960965772 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    public String toString(Object modelElement, Map args)
    { 

//#if 1932556260 
return toString(modelElement,
                        NotationUtilityUml.isValue("visibilityVisible", args),
                        NotationUtilityUml.isValue("useGuillemets", args));
//#endif 

} 

//#endif 


//#if -1971070026 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if -1616094183 
return toString(modelElement, settings.isShowVisibilities(),
                        settings.isUseGuillemets());
//#endif 

} 

//#endif 


//#if 1025565756 
public void parse(Object modelElement, String text)
    { 

//#if -1296576199 
try //1
{ 

//#if -208417399 
parseAssociationEnd(modelElement, text);
//#endif 

} 

//#if -3145618 
catch (ParseException pe) //1
{ 

//#if -1497332717 
String msg = "statusmsg.bar.error.parsing.association-end-name";
//#endif 


//#if 1760273292 
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
//#endif 


//#if 776321351 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -382504391 
protected AssociationEndNameNotationUml()
    { 

//#if 1731738373 
super();
//#endif 

} 

//#endif 


//#if -594668965 
private String toString(Object modelElement, boolean showVisibility,
                            boolean useGuillemets)
    { 

//#if 1907742923 
String name = Model.getFacade().getName(modelElement);
//#endif 


//#if -1395881311 
if(name == null)//1
{ 

//#if 219954240 
name = "";
//#endif 

} 

//#endif 


//#if 1218792037 
String visibility = "";
//#endif 


//#if -1081706722 
if(showVisibility)//1
{ 

//#if 29498487 
visibility = NotationUtilityUml.generateVisibility2(modelElement);
//#endif 


//#if 402252760 
if(name.length() < 1)//1
{ 

//#if 900915803 
visibility = "";
//#endif 

} 

//#endif 

} 

//#endif 


//#if -387961187 
String stereoString =
            NotationUtilityUml.generateStereotype(modelElement, useGuillemets);
//#endif 


//#if 1412445311 
if(stereoString.length() > 0)//1
{ 

//#if -116045439 
stereoString += " ";
//#endif 

} 

//#endif 


//#if 1120108421 
return stereoString + visibility + name;
//#endif 

} 

//#endif 


//#if 1217817743 
public String getParsingHelp()
    { 

//#if 2145940137 
return "parsing.help.fig-association-end-name";
//#endif 

} 

//#endif 


//#if -2035088923 
public static final AssociationEndNameNotationUml getInstance()
    { 

//#if 1053999184 
return new AssociationEndNameNotationUml();
//#endif 

} 

//#endif 


//#if -1021111647 
protected void parseAssociationEnd(Object role, String text)
    throws ParseException
    { 

//#if -174769012 
MyTokenizer st;
//#endif 


//#if 1272669328 
String name = null;
//#endif 


//#if 2055045782 
StringBuilder stereotype = null;
//#endif 


//#if 1070846256 
String token;
//#endif 


//#if 2146027731 
try //1
{ 

//#if -129475863 
st = new MyTokenizer(text, "<<,\u00AB,\u00BB,>>");
//#endif 


//#if 713984346 
while (st.hasMoreTokens()) //1
{ 

//#if 1820602262 
token = st.nextToken();
//#endif 


//#if 1863115656 
if("<<".equals(token) || "\u00AB".equals(token))//1
{ 

//#if 358651452 
if(stereotype != null)//1
{ 

//#if -115946398 
String msg =
                            "parsing.error.association-name.twin-stereotypes";
//#endif 


//#if -822052949 
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 989449297 
stereotype = new StringBuilder();
//#endif 


//#if 1302303513 
while (true) //1
{ 

//#if -2096766420 
token = st.nextToken();
//#endif 


//#if 863159903 
if(">>".equals(token) || "\u00BB".equals(token))//1
{ 

//#if 2064091910 
break;

//#endif 

} 

//#endif 


//#if 2090547816 
stereotype.append(token);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -653876916 
if(name != null)//1
{ 

//#if -1550356979 
String msg =
                            "parsing.error.association-name.twin-names";
//#endif 


//#if -60019121 
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -15705985 
name = token;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#if -763734058 
catch (NoSuchElementException nsee) //1
{ 

//#if -1366572871 
String ms = "parsing.error.association-name.unexpected-end-element";
//#endif 


//#if -2006430855 
throw new ParseException(Translator.localize(ms),
                                     text.length());
//#endif 

} 

//#endif 


//#if 297170529 
catch (ParseException pre) //1
{ 

//#if 1131003263 
throw pre;
//#endif 

} 

//#endif 


//#endif 


//#if 1671376324 
if(name != null)//1
{ 

//#if 525097544 
name = name.trim();
//#endif 

} 

//#endif 


//#if -1584073406 
if(name != null && name.startsWith("+"))//1
{ 

//#if -1647663370 
name = name.substring(1).trim();
//#endif 


//#if -697635627 
Model.getCoreHelper().setVisibility(role,
                                                Model.getVisibilityKind().getPublic());
//#endif 

} 

//#endif 


//#if 190933956 
if(name != null && name.startsWith("-"))//1
{ 

//#if -1697639377 
name = name.substring(1).trim();
//#endif 


//#if 96248388 
Model.getCoreHelper().setVisibility(role,
                                                Model.getVisibilityKind().getPrivate());
//#endif 

} 

//#endif 


//#if -94168262 
if(name != null && name.startsWith("#"))//1
{ 

//#if -955817670 
name = name.substring(1).trim();
//#endif 


//#if -96124092 
Model.getCoreHelper().setVisibility(role,
                                                Model.getVisibilityKind().getProtected());
//#endif 

} 

//#endif 


//#if -935711915 
if(name != null && name.startsWith("~"))//1
{ 

//#if -184108694 
name = name.substring(1).trim();
//#endif 


//#if -388340116 
Model.getCoreHelper().setVisibility(role,
                                                Model.getVisibilityKind().getPackage());
//#endif 

} 

//#endif 


//#if 416282221 
if(name != null)//2
{ 

//#if 2136914114 
Model.getCoreHelper().setName(role, name);
//#endif 

} 

//#endif 


//#if -1357202738 
StereotypeUtility.dealWithStereotypes(role, stereotype, true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

