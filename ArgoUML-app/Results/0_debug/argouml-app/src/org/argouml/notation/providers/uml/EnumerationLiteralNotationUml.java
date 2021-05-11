
//#if 1127197427 
// Compilation Unit of /EnumerationLiteralNotationUml.java 
 

//#if -1484592021 
package org.argouml.notation.providers.uml;
//#endif 


//#if -1369091146 
import java.text.ParseException;
//#endif 


//#if 403182131 
import java.util.Map;
//#endif 


//#if -960592180 
import java.util.NoSuchElementException;
//#endif 


//#if -752732520 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if -1741580355 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if -901492287 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if -1473539966 
import org.argouml.i18n.Translator;
//#endif 


//#if -1869642302 
import org.argouml.kernel.Project;
//#endif 


//#if 1339215591 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1476193352 
import org.argouml.model.Model;
//#endif 


//#if -18876069 
import org.argouml.notation.NotationSettings;
//#endif 


//#if 1192709098 
import org.argouml.notation.providers.EnumerationLiteralNotation;
//#endif 


//#if -2005974164 
import org.argouml.uml.StereotypeUtility;
//#endif 


//#if 182491243 
import org.argouml.util.MyTokenizer;
//#endif 


//#if -1847900374 
public class EnumerationLiteralNotationUml extends 
//#if 396553784 
EnumerationLiteralNotation
//#endif 

  { 

//#if 390361963 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if 793126276 
return toString(modelElement, settings.isUseGuillemets());
//#endif 

} 

//#endif 


//#if -1833733311 
@Override
    public void parse(Object modelElement, String text)
    { 

//#if 1987449552 
try //1
{ 

//#if 1092592113 
parseEnumerationLiteralFig(
                Model.getFacade().getEnumeration(modelElement),
                modelElement, text);
//#endif 

} 

//#if 668234342 
catch (ParseException pe) //1
{ 

//#if 415196370 
String msg = "statusmsg.bar.error.parsing.enumeration-literal";
//#endif 


//#if -1828757267 
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
//#endif 


//#if 1869016070 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -2036651537 
protected void parseEnumerationLiteral(String text, Object literal)
    throws ParseException
    { 

//#if 18898847 
text = text.trim();
//#endif 


//#if 1450906355 
if(text.length() == 0)//1
{ 

//#if 2123701151 
return;
//#endif 

} 

//#endif 


//#if -1767670883 
if(text.charAt(text.length() - 1) == ';')//1
{ 

//#if -338775333 
text = text.substring(0, text.length() - 2);
//#endif 

} 

//#endif 


//#if 2087149495 
MyTokenizer st;
//#endif 


//#if 1722902779 
String name = null;
//#endif 


//#if 172049419 
StringBuilder stereotype = null;
//#endif 


//#if -593837285 
String token;
//#endif 


//#if -1315223810 
try //1
{ 

//#if -1657314970 
st = new MyTokenizer(text, "<<,\u00AB,\u00BB,>>");
//#endif 


//#if -1832639209 
while (st.hasMoreTokens()) //1
{ 

//#if 1166721870 
token = st.nextToken();
//#endif 


//#if -1263193280 
if("<<".equals(token) || "\u00AB".equals(token))//1
{ 

//#if 214504807 
if(stereotype != null)//1
{ 

//#if 1597445508 
String msg =
                            "parsing.error.model-element-name.twin-stereotypes";
//#endif 


//#if 944836406 
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -962136378 
stereotype = new StringBuilder();
//#endif 


//#if -1349367922 
while (true) //1
{ 

//#if 1883745712 
token = st.nextToken();
//#endif 


//#if 1285022691 
if(">>".equals(token) || "\u00BB".equals(token))//1
{ 

//#if 1916707442 
break;

//#endif 

} 

//#endif 


//#if 356754412 
stereotype.append(token);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -347155366 
if(name != null)//1
{ 

//#if -1655726444 
String msg =
                            "parsing.error.model-element-name.twin-names";
//#endif 


//#if -2144250561 
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -1408799219 
name = token;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#if 1807544076 
catch (NoSuchElementException nsee) //1
{ 

//#if 1711076346 
String msg =
                "parsing.error.model-element-name.unexpected-name-element";
//#endif 


//#if 1602279859 
throw new ParseException(Translator.localize(msg),
                                     text.length());
//#endif 

} 

//#endif 


//#if -172963221 
catch (ParseException pre) //1
{ 

//#if 14526412 
throw pre;
//#endif 

} 

//#endif 


//#endif 


//#if -1551255879 
if(name != null)//1
{ 

//#if -80798221 
name = name.trim();
//#endif 

} 

//#endif 


//#if 384290136 
if(name != null)//2
{ 

//#if -1339475885 
Model.getCoreHelper().setName(literal, name);
//#endif 

} 

//#endif 


//#if -2098541011 
StereotypeUtility.dealWithStereotypes(literal, stereotype, false);
//#endif 


//#if 28082627 
return;
//#endif 

} 

//#endif 


//#if -890263387 
private String toString(Object modelElement, boolean useGuillemets)
    { 

//#if 1030987146 
String nameStr = "";
//#endif 


//#if -1164412010 
if(Model.getFacade().getName(modelElement) != null)//1
{ 

//#if 1483124470 
nameStr = NotationUtilityUml.generateStereotype(modelElement,
                      useGuillemets);
//#endif 


//#if 1894621971 
if(nameStr.length() > 0)//1
{ 

//#if -1411669497 
nameStr += " ";
//#endif 

} 

//#endif 


//#if 2089778272 
nameStr += Model.getFacade().getName(modelElement).trim();
//#endif 

} 

//#endif 


//#if 1248946894 
return nameStr;
//#endif 

} 

//#endif 


//#if -1555054897 

//#if -1877903667 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    public String toString(Object modelElement, Map args)
    { 

//#if -1492541329 
return toString(modelElement,
                        NotationUtilityUml.isValue("useGuillemets", args));
//#endif 

} 

//#endif 


//#if -639641233 
public EnumerationLiteralNotationUml(Object enumLiteral)
    { 

//#if -1267634028 
super(enumLiteral);
//#endif 

} 

//#endif 


//#if -646044972 
@Override
    public String getParsingHelp()
    { 

//#if 806596876 
return "parsing.help.fig-enumeration-literal";
//#endif 

} 

//#endif 


//#if -1512359671 
protected void  parseEnumerationLiteralFig(
        Object enumeration, Object literal, String text)
    throws ParseException
    { 

//#if 1677430788 
if(enumeration == null || literal == null)//1
{ 

//#if -1508540924 
return;
//#endif 

} 

//#endif 


//#if -790436058 
Project project = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -170267385 
ParseException pex = null;
//#endif 


//#if 1501846014 
int start = 0;
//#endif 


//#if -770506239 
int end = NotationUtilityUml.indexOfNextCheckedSemicolon(text, start);
//#endif 


//#if 1480990931 
if(end == -1)//1
{ 

//#if -1289341137 
project.moveToTrash(literal);
//#endif 


//#if 1804276266 
return;
//#endif 

} 

//#endif 


//#if 2072279112 
String s = text.substring(start, end).trim();
//#endif 


//#if -285484158 
if(s.length() == 0)//1
{ 

//#if -874260052 
project.moveToTrash(literal);
//#endif 


//#if -1637765017 
return;
//#endif 

} 

//#endif 


//#if -559432284 
parseEnumerationLiteral(s, literal);
//#endif 


//#if 589920571 
int i = Model.getFacade().getEnumerationLiterals(enumeration)
                .indexOf(literal);
//#endif 


//#if 1690926124 
start = end + 1;
//#endif 


//#if 1875463874 
end = NotationUtilityUml.indexOfNextCheckedSemicolon(text, start);
//#endif 


//#if 2010599077 
while (end > start && end <= text.length()) //1
{ 

//#if -400409652 
s = text.substring(start, end).trim();
//#endif 


//#if -586863997 
if(s.length() > 0)//1
{ 

//#if 1208509718 
Object newLiteral =
                    Model.getCoreFactory().createEnumerationLiteral();
//#endif 


//#if -885718167 
if(newLiteral != null)//1
{ 

//#if -1234131725 
try //1
{ 

//#if 344653451 
if(i != -1)//1
{ 

//#if -312617753 
Model.getCoreHelper().addLiteral(
                                enumeration, ++i, newLiteral);
//#endif 

} 
else
{ 

//#if 1191094970 
Model.getCoreHelper().addLiteral(
                                enumeration, 0, newLiteral);
//#endif 

} 

//#endif 


//#if -1755688436 
parseEnumerationLiteral(s, newLiteral);
//#endif 

} 

//#if -2000107202 
catch (ParseException ex) //1
{ 

//#if 958312736 
if(pex == null)//1
{ 

//#if -1875797470 
pex = ex;
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 34157209 
start = end + 1;
//#endif 


//#if 857969461 
end = NotationUtilityUml.indexOfNextCheckedSemicolon(text, start);
//#endif 

} 

//#endif 


//#if 645593178 
if(pex != null)//1
{ 

//#if -99250020 
throw pex;
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

