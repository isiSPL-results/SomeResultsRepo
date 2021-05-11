
//#if -213137320 
// Compilation Unit of /AssociationRoleNotationUml.java 
 

//#if -1550589121 
package org.argouml.notation.providers.uml;
//#endif 


//#if -724936350 
import java.text.ParseException;
//#endif 


//#if -2093703499 
import java.util.Collection;
//#endif 


//#if 1052243173 
import java.util.Iterator;
//#endif 


//#if -1391599609 
import java.util.Map;
//#endif 


//#if 1217900100 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if -781511279 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 1069140333 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if -1371890858 
import org.argouml.i18n.Translator;
//#endif 


//#if -1689616100 
import org.argouml.model.Model;
//#endif 


//#if 982420271 
import org.argouml.notation.NotationSettings;
//#endif 


//#if 368295413 
import org.argouml.notation.providers.AssociationRoleNotation;
//#endif 


//#if -961353705 
import org.argouml.util.MyTokenizer;
//#endif 


//#if -1502852665 
public class AssociationRoleNotationUml extends 
//#if 626629926 
AssociationRoleNotation
//#endif 

  { 

//#if 946167736 
@Override
    public String toString(final Object modelElement,
                           final NotationSettings settings)
    { 

//#if -1656211610 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if 807708892 
private String toString(final Object modelElement)
    { 

//#if 1380792654 
String name = Model.getFacade().getName(modelElement);
//#endif 


//#if 340130788 
if(name == null)//1
{ 

//#if -892127250 
name = "";
//#endif 

} 

//#endif 


//#if 2059033978 
if(name.length() > 0)//1
{ 

//#if 462018318 
name = "/" + name;
//#endif 

} 

//#endif 


//#if 82199056 
Object assoc = Model.getFacade().getBase(modelElement);
//#endif 


//#if -1285679370 
if(assoc != null)//1
{ 

//#if 2136786137 
String baseName = Model.getFacade().getName(assoc);
//#endif 


//#if 1635655828 
if(baseName != null && baseName.length() > 0)//1
{ 

//#if 1676015987 
name = name + ":" + baseName;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1557800033 
return name;
//#endif 

} 

//#endif 


//#if -1337943165 
public AssociationRoleNotationUml(Object role)
    { 

//#if 1913747301 
super(role);
//#endif 

} 

//#endif 


//#if 1524495883 
protected void parseRole(Object role, String text)
    throws ParseException
    { 

//#if -1132391574 
String token;
//#endif 


//#if -1365366241 
boolean hasColon = false;
//#endif 


//#if -844285375 
boolean hasSlash = false;
//#endif 


//#if -718611414 
String rolestr = null;
//#endif 


//#if -1820046289 
String basestr = null;
//#endif 


//#if -1548832649 
MyTokenizer st = new MyTokenizer(text, " ,\t,/,:");
//#endif 


//#if -1701015501 
while (st.hasMoreTokens()) //1
{ 

//#if 1447671028 
token = st.nextToken();
//#endif 


//#if 520003016 
if(" ".equals(token) || "\t".equals(token))//1
{ 
} 
else

//#if -1805956846 
if("/".equals(token))//1
{ 

//#if -1289993100 
hasSlash = true;
//#endif 


//#if 2022044719 
hasColon = false;
//#endif 

} 
else

//#if -1738969045 
if(":".equals(token))//1
{ 

//#if -1351356034 
hasColon = true;
//#endif 


//#if 1161955497 
hasSlash = false;
//#endif 

} 
else

//#if -1292303541 
if(hasColon)//1
{ 

//#if -32643544 
if(basestr != null)//1
{ 

//#if -1720479368 
String msg =
                        "parsing.error.association-role.association-extra-text";
//#endif 


//#if 1207396690 
throw new ParseException(Translator.localize(msg), st
                                             .getTokenIndex());
//#endif 

} 

//#endif 


//#if 859970567 
basestr = token;
//#endif 

} 
else

//#if -278330061 
if(hasSlash)//1
{ 

//#if 985658380 
if(rolestr != null)//1
{ 

//#if -1817787788 
String msg =
                        "parsing.error.association-role.association-extra-text";
//#endif 


//#if -2111681714 
throw new ParseException(Translator.localize(msg), st
                                             .getTokenIndex());
//#endif 

} 

//#endif 


//#if -2127003243 
rolestr = token;
//#endif 

} 
else
{ 

//#if -617017626 
String msg =
                    "parsing.error.association-role.association-extra-text";
//#endif 


//#if 777208640 
throw new ParseException(Translator.localize(msg),
                                         st.getTokenIndex());
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if -815149765 
if(basestr == null)//1
{ 

//#if -1792694753 
if(rolestr != null)//1
{ 

//#if -885340276 
Model.getCoreHelper().setName(role, rolestr.trim());
//#endif 

} 

//#endif 


//#if 2102490407 
return;
//#endif 

} 

//#endif 


//#if -1377031692 
Object currentBase = Model.getFacade().getBase(role);
//#endif 


//#if 1994528129 
if(currentBase != null)//1
{ 

//#if 572155168 
String currentBaseStr = Model.getFacade().getName(currentBase);
//#endif 


//#if -705832561 
if(currentBaseStr == null)//1
{ 

//#if -1679867011 
currentBaseStr = "";
//#endif 

} 

//#endif 


//#if 547948972 
if(currentBaseStr.equals(basestr))//1
{ 

//#if -1532249832 
if(rolestr != null)//1
{ 

//#if 1705415444 
Model.getCoreHelper().setName(role, rolestr.trim());
//#endif 

} 

//#endif 


//#if -118816370 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1958416327 
Collection c =
            Model.getCollaborationsHelper().getAllPossibleBases(role);
//#endif 


//#if 1739191656 
Iterator i = c.iterator();
//#endif 


//#if 1535608707 
while (i.hasNext()) //1
{ 

//#if -726300842 
Object candidate = i.next();
//#endif 


//#if 7846303 
if(basestr.equals(Model.getFacade().getName(candidate)))//1
{ 

//#if -745256671 
if(Model.getFacade().getBase(role) != candidate)//1
{ 

//#if -503421649 
Model.getCollaborationsHelper().setBase(role, candidate);
//#endif 

} 

//#endif 


//#if 43829348 
if(rolestr != null)//1
{ 

//#if 116160191 
Model.getCoreHelper().setName(role, rolestr.trim());
//#endif 

} 

//#endif 


//#if -193526078 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -345058193 
String msg = "parsing.error.association-role.base-not-found";
//#endif 


//#if -948716796 
throw new ParseException(Translator.localize(msg), 0);
//#endif 

} 

//#endif 


//#if 1650250934 
public void parse(Object modelElement, String text)
    { 

//#if 1434602243 
try //1
{ 

//#if 867387350 
parseRole(modelElement, text);
//#endif 

} 

//#if -16272317 
catch (ParseException pe) //1
{ 

//#if 1889156760 
String msg = "statusmsg.bar.error.parsing.association-role";
//#endif 


//#if 779862272 
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
//#endif 


//#if -1504568749 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 645490569 
public String getParsingHelp()
    { 

//#if 1166721983 
return "parsing.help.fig-association-role";
//#endif 

} 

//#endif 


//#if -693994904 

//#if -20143967 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public String toString(Object modelElement, Map args)
    { 

//#if -68148598 
return toString(modelElement);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

