
//#if -226946063 
// Compilation Unit of /OperationNotationUml.java 
 

//#if 163948855 
package org.argouml.notation.providers.uml;
//#endif 


//#if 1157144170 
import java.text.ParseException;
//#endif 


//#if -1224588764 
import java.util.ArrayList;
//#endif 


//#if 2032052157 
import java.util.Collection;
//#endif 


//#if -333406227 
import java.util.Iterator;
//#endif 


//#if 15412669 
import java.util.List;
//#endif 


//#if 1108897791 
import java.util.Map;
//#endif 


//#if 579198336 
import java.util.NoSuchElementException;
//#endif 


//#if 1958289228 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if 695715209 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 1809529461 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if 1185798478 
import org.argouml.i18n.Translator;
//#endif 


//#if -814025866 
import org.argouml.kernel.Project;
//#endif 


//#if 1828081331 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1461423981 
import org.argouml.kernel.ProjectSettings;
//#endif 


//#if 1939710227 
import org.argouml.model.InvalidElementException;
//#endif 


//#if -381977836 
import org.argouml.model.Model;
//#endif 


//#if -614026457 
import org.argouml.notation.NotationSettings;
//#endif 


//#if 234955373 
import org.argouml.notation.providers.OperationNotation;
//#endif 


//#if -1517108424 
import org.argouml.uml.StereotypeUtility;
//#endif 


//#if 1017604383 
import org.argouml.util.MyTokenizer;
//#endif 


//#if 327270655 
public class OperationNotationUml extends 
//#if -981983706 
OperationNotation
//#endif 

  { 

//#if -1632512922 
private static final String RECEPTION_KEYWORD = "signal";
//#endif 


//#if -711756447 
private void setReturnParameter(Object op, Object type)
    { 

//#if -1893902402 
Object param = null;
//#endif 


//#if 1857245023 
Iterator it = Model.getFacade().getParameters(op).iterator();
//#endif 


//#if 1629927921 
while (it.hasNext()) //1
{ 

//#if 1118126896 
Object p = it.next();
//#endif 


//#if 89520546 
if(Model.getFacade().isReturn(p))//1
{ 

//#if -1565574238 
param = p;
//#endif 


//#if 1887733091 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1717477600 
while (it.hasNext()) //2
{ 

//#if -1158019662 
Object p = it.next();
//#endif 


//#if 524541860 
if(Model.getFacade().isReturn(p))//1
{ 

//#if 1964812781 
ProjectManager.getManager().getCurrentProject().moveToTrash(p);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1295468456 
if(param == null)//1
{ 

//#if -432407397 
Object returnType =
                ProjectManager.getManager()
                .getCurrentProject().getDefaultReturnType();
//#endif 


//#if -106707616 
param = Model.getCoreFactory().buildParameter(op, returnType);
//#endif 

} 

//#endif 


//#if -471084083 
Model.getCoreHelper().setType(param, type);
//#endif 

} 

//#endif 


//#if -1024387374 
public OperationNotationUml(Object operation)
    { 

//#if 1589501561 
super(operation);
//#endif 

} 

//#endif 


//#if -1059439400 

//#if 1707366911 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public String toString(Object modelElement, Map args)
    { 

//#if 1686334840 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 801308938 
ProjectSettings ps = p.getProjectSettings();
//#endif 


//#if 1729518520 
return toString(modelElement, ps.getUseGuillemotsValue(),
                        ps.getShowVisibilityValue(), ps
                        .getShowTypesValue(), ps.getShowPropertiesValue());
//#endif 

} 

//#endif 


//#if -1969645701 
private StringBuffer getReturnParameters(Object modelElement,
            boolean isReception)
    { 

//#if 181601189 
StringBuffer returnParasSb = new StringBuffer();
//#endif 


//#if 673926519 
if(!isReception)//1
{ 

//#if -1971456970 
Collection coll =
                Model.getCoreHelper().getReturnParameters(modelElement);
//#endif 


//#if 575367533 
if(coll != null && coll.size() > 0)//1
{ 

//#if -649860686 
returnParasSb.append(": ");
//#endif 


//#if -398405962 
Iterator it2 = coll.iterator();
//#endif 


//#if 1171315760 
while (it2.hasNext()) //1
{ 

//#if -366803598 
Object type = Model.getFacade().getType(it2.next());
//#endif 


//#if -254156009 
if(type != null)//1
{ 

//#if -2137998642 
returnParasSb.append(Model.getFacade()
                                             .getName(type));
//#endif 

} 

//#endif 


//#if -1268381455 
returnParasSb.append(",");
//#endif 

} 

//#endif 


//#if -1123583275 
if(returnParasSb.length() == 3)//1
{ 

//#if -950266091 
returnParasSb.delete(0, returnParasSb.length());
//#endif 

} 
else
{ 

//#if 689522759 
returnParasSb.delete(
                        returnParasSb.length() - 1,
                        returnParasSb.length());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1335607943 
return returnParasSb;
//#endif 

} 

//#endif 


//#if -1422948265 
private String toString(Object modelElement, boolean useGuillemets,
                            boolean showVisibility,
                            boolean showTypes, boolean showProperties)
    { 

//#if -99558219 
try //1
{ 

//#if -291773151 
String stereoStr = NotationUtilityUml.generateStereotype(
                                   Model.getFacade().getStereotypes(modelElement),
                                   useGuillemets);
//#endif 


//#if -159857831 
boolean isReception = Model.getFacade().isAReception(modelElement);
//#endif 


//#if 1267795624 
if(isReception)//1
{ 

//#if 1041582056 
stereoStr =
                    NotationUtilityUml
                    .generateStereotype(RECEPTION_KEYWORD,
                                        useGuillemets)
                    + " " + stereoStr;
//#endif 

} 

//#endif 


//#if 242304939 
StringBuffer genStr = new StringBuffer(30);
//#endif 


//#if -553429749 
if((stereoStr != null) && (stereoStr.length() > 0))//1
{ 

//#if -164485215 
genStr.append(stereoStr).append(" ");
//#endif 

} 

//#endif 


//#if -2043174084 
if(showVisibility)//1
{ 

//#if -257587411 
String visStr = NotationUtilityUml
                                .generateVisibility2(modelElement);
//#endif 


//#if 1601166597 
if(visStr != null)//1
{ 

//#if 2009005321 
genStr.append(visStr);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1233326468 
String nameStr = Model.getFacade().getName(modelElement);
//#endif 


//#if 178954091 
if((nameStr != null) && (nameStr.length() > 0))//1
{ 

//#if 556398804 
genStr.append(nameStr);
//#endif 

} 

//#endif 


//#if 1597853855 
if(showTypes)//1
{ 

//#if -87423534 
StringBuffer parameterStr = new StringBuffer();
//#endif 


//#if -1845392461 
parameterStr.append("(").append(getParameterList(modelElement))
                .append(")");
//#endif 


//#if -681237683 
StringBuffer returnParasSb = getReturnParameters(modelElement,
                                             isReception);
//#endif 


//#if -925796233 
genStr.append(parameterStr).append(" ");
//#endif 


//#if -142346272 
if((returnParasSb != null) && (returnParasSb.length() > 0))//1
{ 

//#if -1604659068 
genStr.append(returnParasSb).append(" ");
//#endif 

} 

//#endif 

} 
else
{ 

//#if -820521831 
genStr.append("()");
//#endif 

} 

//#endif 


//#if -914696995 
if(showProperties)//1
{ 

//#if 1951057676 
StringBuffer propertySb = getProperties(modelElement,
                                                        isReception);
//#endif 


//#if 32132761 
if(propertySb.length() > 0)//1
{ 

//#if -1232528482 
genStr.append(propertySb);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 383753070 
return genStr.toString().trim();
//#endif 

} 

//#if -1128289249 
catch (InvalidElementException e) //1
{ 

//#if 2051303260 
return "";
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1875653401 
public String getParsingHelp()
    { 

//#if -245883341 
return "parsing.help.operation";
//#endif 

} 

//#endif 


//#if 2037108487 
private List<String> tokenOpenBrace(MyTokenizer st, List<String> properties)
    throws ParseException
    { 

//#if -388850159 
String token;
//#endif 


//#if -565388467 
StringBuilder propname = new StringBuilder();
//#endif 


//#if -83874026 
String propvalue = null;
//#endif 


//#if 742154191 
if(properties == null)//1
{ 

//#if -1708233331 
properties = new ArrayList<String>();
//#endif 

} 

//#endif 


//#if -1453979157 
while (true) //1
{ 

//#if 682249252 
token = st.nextToken();
//#endif 


//#if 55387753 
if(",".equals(token) || "}".equals(token))//1
{ 

//#if 269844186 
if(propname.length() > 0)//1
{ 

//#if -962923981 
properties.add(propname.toString());
//#endif 


//#if -430392076 
properties.add(propvalue);
//#endif 

} 

//#endif 


//#if 1401200293 
propname = new StringBuilder();
//#endif 


//#if 1414770273 
propvalue = null;
//#endif 


//#if -1588113709 
if("}".equals(token))//1
{ 

//#if -1477774616 
break;

//#endif 

} 

//#endif 

} 
else

//#if 1316806162 
if("=".equals(token))//1
{ 

//#if 2137100788 
if(propvalue != null)//1
{ 

//#if -212986470 
String msg =
                        "parsing.error.operation.prop-stereotypes";
//#endif 


//#if 1789282014 
Object[] args = {propname};
//#endif 


//#if -2060916121 
throw new ParseException(
                        Translator.localize(msg,
                                            args),
                        st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 873004166 
propvalue = "";
//#endif 

} 
else

//#if 1636863176 
if(propvalue == null)//1
{ 

//#if -920042938 
propname.append(token);
//#endif 

} 
else
{ 

//#if 1705498674 
propvalue += token;
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if -1532006252 
if(propname.length() > 0)//1
{ 

//#if -610291144 
properties.add(propname.toString());
//#endif 


//#if 736612153 
properties.add(propvalue);
//#endif 

} 

//#endif 


//#if 629858234 
return properties;
//#endif 

} 

//#endif 


//#if -2037785530 
public void parse(Object modelElement, String text)
    { 

//#if -1330940813 
try //1
{ 

//#if -1264838017 
parseOperationFig(Model.getFacade().getOwner(modelElement),
                              modelElement, text);
//#endif 

} 

//#if 630653047 
catch (ParseException pe) //1
{ 

//#if 1682594689 
String msg = "statusmsg.bar.error.parsing.operation";
//#endif 


//#if 1068194142 
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
//#endif 


//#if 85951925 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 339940258 
private StringBuffer getProperties(Object modelElement,
                                       boolean isReception)
    { 

//#if 383300568 
StringBuffer propertySb = new StringBuffer().append("{");
//#endif 


//#if -1237929888 
if(Model.getFacade().isQuery(modelElement))//1
{ 

//#if 981532131 
propertySb.append("query,");
//#endif 

} 

//#endif 


//#if 94304054 
if(Model.getFacade().isRoot(modelElement))//1
{ 

//#if -1191717784 
propertySb.append("root,");
//#endif 

} 

//#endif 


//#if 1985474226 
if(Model.getFacade().isLeaf(modelElement))//1
{ 

//#if -1544481057 
propertySb.append("leaf,");
//#endif 

} 

//#endif 


//#if -1096378306 
if(!isReception)//1
{ 

//#if -762576298 
if(Model.getFacade().getConcurrency(modelElement) != null)//1
{ 

//#if 1483559462 
propertySb.append(Model.getFacade().getName(
                                      Model.getFacade().getConcurrency(modelElement)));
//#endif 


//#if 1807967509 
propertySb.append(',');
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1866983066 
if(propertySb.length() > 1)//1
{ 

//#if -1157902826 
propertySb.delete(propertySb.length() - 1, propertySb.length());
//#endif 


//#if -1119309294 
propertySb.append("}");
//#endif 

} 
else
{ 

//#if 105878446 
propertySb = new StringBuffer();
//#endif 

} 

//#endif 


//#if 1590551118 
return propertySb;
//#endif 

} 

//#endif 


//#if 1973537617 
private StringBuffer getParameterList(Object modelElement)
    { 

//#if -994214755 
StringBuffer parameterListBuffer = new StringBuffer();
//#endif 


//#if -339214187 
Collection coll = Model.getFacade().getParameters(modelElement);
//#endif 


//#if -1693492415 
Iterator it = coll.iterator();
//#endif 


//#if -1136213010 
int counter = 0;
//#endif 


//#if -2079914825 
while (it.hasNext()) //1
{ 

//#if -401235832 
Object parameter = it.next();
//#endif 


//#if 1517146629 
if(!Model.getFacade().hasReturnParameterDirectionKind(
                        parameter))//1
{ 

//#if 324834733 
counter++;
//#endif 


//#if -488664079 
parameterListBuffer.append(
                    NotationUtilityUml.generateParameter(parameter));
//#endif 


//#if 1424888849 
parameterListBuffer.append(",");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 335855704 
if(counter > 0)//1
{ 

//#if 1035365551 
parameterListBuffer.delete(
                parameterListBuffer.length() - 1,
                parameterListBuffer.length());
//#endif 

} 

//#endif 


//#if 375330545 
return parameterListBuffer;
//#endif 

} 

//#endif 


//#if 1589942854 
public String toString(Object modelElement, NotationSettings settings)
    { 

//#if -1311456294 
return toString(modelElement, settings.isUseGuillemets(),
                        settings.isShowVisibilities(), settings.isShowTypes(),
                        settings.isShowProperties());
//#endif 

} 

//#endif 


//#if 163954964 
public void parseOperation(String s, Object op) throws ParseException
    { 

//#if -259056803 
MyTokenizer st;
//#endif 


//#if 174417462 
boolean hasColon = false;
//#endif 


//#if 1876480801 
String name = null;
//#endif 


//#if 1971779455 
String parameterlist = null;
//#endif 


//#if -1260255323 
StringBuilder stereotype = null;
//#endif 


//#if -1700188095 
String token;
//#endif 


//#if 1201629328 
String type = null;
//#endif 


//#if 16824104 
String visibility = null;
//#endif 


//#if 1113954055 
List<String> properties = null;
//#endif 


//#if -1251268983 
int paramOffset = 0;
//#endif 


//#if 1523162469 
s = s.trim();
//#endif 


//#if 1668456408 
if(s.length() > 0
                && NotationUtilityUml.VISIBILITYCHARS.indexOf(s.charAt(0))
                >= 0)//1
{ 

//#if -1201788566 
visibility = s.substring(0, 1);
//#endif 


//#if -1787518137 
s = s.substring(1);
//#endif 

} 

//#endif 


//#if 28575908 
try //1
{ 

//#if -2027853783 
st = new MyTokenizer(s, " ,\t,<<,\u00AB,\u00BB,>>,:,=,{,},\\,",
                                 NotationUtilityUml.operationCustomSep);
//#endif 


//#if -685454999 
while (st.hasMoreTokens()) //1
{ 

//#if -143699348 
token = st.nextToken();
//#endif 


//#if 593139283 
if(" ".equals(token) || "\t".equals(token)
                        || ",".equals(token))//1
{ 

//#if 2072354147 
continue;
//#endif 

} 
else

//#if -1039500886 
if("<<".equals(token) || "\u00AB".equals(token))//1
{ 

//#if 761211739 
if(stereotype != null)//1
{ 

//#if 366484778 
parseError("operation.stereotypes",
                                   st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 1822295634 
stereotype = new StringBuilder();
//#endif 


//#if -959320294 
while (true) //1
{ 

//#if 1633024055 
token = st.nextToken();
//#endif 


//#if 500477418 
if(">>".equals(token) || "\u00BB".equals(token))//1
{ 

//#if 233089003 
break;

//#endif 

} 

//#endif 


//#if -376745229 
stereotype.append(token);
//#endif 

} 

//#endif 

} 
else

//#if -148645340 
if("{".equals(token))//1
{ 

//#if -1351862683 
properties = tokenOpenBrace(st, properties);
//#endif 

} 
else

//#if 712494706 
if(":".equals(token))//1
{ 

//#if 205259912 
hasColon = true;
//#endif 

} 
else

//#if -751391883 
if("=".equals(token))//1
{ 

//#if -273127796 
parseError("operation.default-values", st.getTokenIndex());
//#endif 

} 
else

//#if -566425490 
if(token.charAt(0) == '(' && !hasColon)//1
{ 

//#if 845192855 
if(parameterlist != null)//1
{ 

//#if -16043990 
parseError("operation.two-parameter-lists",
                                   st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 1706719496 
parameterlist = token;
//#endif 

} 
else
{ 

//#if -1041233918 
if(hasColon)//1
{ 

//#if -2075406356 
if(type != null)//1
{ 

//#if 1306399912 
parseError("operation.two-types",
                                       st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 1848170947 
if(token.length() > 0
                                && (token.charAt(0) == '\"'
                                    || token.charAt(0) == '\''))//1
{ 

//#if 1667709486 
parseError("operation.type-quoted",
                                       st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 1560097184 
if(token.length() > 0 && token.charAt(0) == '(')//1
{ 

//#if 1276967219 
parseError("operation.type-expr",
                                       st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -837422495 
type = token;
//#endif 

} 
else
{ 

//#if -14690289 
if(name != null && visibility != null)//1
{ 

//#if 56415637 
parseError("operation.extra-text",
                                       st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 73667840 
if(token.length() > 0
                                && (token.charAt(0) == '\"'
                                    || token.charAt(0) == '\''))//1
{ 

//#if 48540963 
parseError("operation.name-quoted",
                                       st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -543588579 
if(token.length() > 0 && token.charAt(0) == '(')//1
{ 

//#if -1501205440 
parseError("operation.name-expr",
                                       st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -492738197 
if(name == null
                                && visibility == null
                                && token.length() > 1
                                && NotationUtilityUml.VISIBILITYCHARS.indexOf(
                                    token.charAt(0))
                                >= 0)//1
{ 

//#if 815015099 
visibility = token.substring(0, 1);
//#endif 


//#if -1551366168 
token = token.substring(1);
//#endif 

} 

//#endif 


//#if 947782906 
if(name != null)//1
{ 

//#if -418675341 
visibility = name;
//#endif 


//#if -1430722746 
name = token;
//#endif 

} 
else
{ 

//#if -1920709309 
name = token;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 

} 

//#if 1921343209 
catch (NoSuchElementException nsee) //1
{ 

//#if -1745896363 
parseError("operation.unexpected-end-operation",
                       s.length());
//#endif 

} 

//#endif 


//#if -1227186706 
catch (ParseException pre) //1
{ 

//#if -53933515 
throw pre;
//#endif 

} 

//#endif 


//#endif 


//#if 575024821 
if(parameterlist != null)//1
{ 

//#if 807174917 
if(parameterlist.charAt(parameterlist.length() - 1) != ')')//1
{ 

//#if 135803966 
parseError("operation.parameter-list-incomplete",
                           paramOffset + parameterlist.length() - 1);
//#endif 

} 

//#endif 


//#if -2063428775 
paramOffset++;
//#endif 


//#if -724591439 
parameterlist = parameterlist.substring(1,
                                                    parameterlist.length() - 1);
//#endif 


//#if -1456760020 
NotationUtilityUml.parseParamList(op, parameterlist, paramOffset);
//#endif 

} 

//#endif 


//#if 1192721242 
if(visibility != null)//1
{ 

//#if 1472987519 
Model.getCoreHelper().setVisibility(op,
                                                NotationUtilityUml.getVisibility(visibility.trim()));
//#endif 

} 

//#endif 


//#if -1085304493 
if(name != null)//1
{ 

//#if -324781149 
Model.getCoreHelper().setName(op, name.trim());
//#endif 

} 
else

//#if -2006565944 
if(Model.getFacade().getName(op) == null
                   || "".equals(Model.getFacade().getName(op)))//1
{ 

//#if -1807901198 
Model.getCoreHelper().setName(op, "anonymous");
//#endif 

} 

//#endif 


//#endif 


//#if 2111821634 
if(type != null)//1
{ 

//#if 1124325047 
Object ow = Model.getFacade().getOwner(op);
//#endif 


//#if -549221044 
Object ns = null;
//#endif 


//#if 1089020432 
if(ow != null && Model.getFacade().getNamespace(ow) != null)//1
{ 

//#if -1438146176 
ns = Model.getFacade().getNamespace(ow);
//#endif 

} 
else
{ 

//#if 828172317 
ns = Model.getFacade().getModel(op);
//#endif 

} 

//#endif 


//#if -617138878 
Object mtype = NotationUtilityUml.getType(type.trim(), ns);
//#endif 


//#if -648646546 
setReturnParameter(op, mtype);
//#endif 

} 

//#endif 


//#if 574435387 
if(properties != null)//1
{ 

//#if -1286059373 
NotationUtilityUml.setProperties(op, properties,
                                             NotationUtilityUml.operationSpecialStrings);
//#endif 

} 

//#endif 


//#if -1190819527 
if(!Model.getFacade().isAReception(op)
                || !RECEPTION_KEYWORD.equals(stereotype.toString()))//1
{ 

//#if 1939312424 
StereotypeUtility.dealWithStereotypes(op, stereotype, true);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 930205698 
private StringBuffer getTaggedValues(Object modelElement)
    { 

//#if 338015302 
StringBuffer taggedValuesSb = new StringBuffer();
//#endif 


//#if -1773239616 
Iterator it3 = Model.getFacade().getTaggedValues(modelElement);
//#endif 


//#if 493661246 
if(it3 != null && it3.hasNext())//1
{ 

//#if 1466035429 
while (it3.hasNext()) //1
{ 

//#if 963472270 
taggedValuesSb.append(
                    NotationUtilityUml.generateTaggedValue(it3.next()));
//#endif 


//#if -1968692895 
taggedValuesSb.append(",");
//#endif 

} 

//#endif 


//#if 300622202 
taggedValuesSb.delete(
                taggedValuesSb.length() - 1,
                taggedValuesSb.length());
//#endif 

} 

//#endif 


//#if -1712794500 
return taggedValuesSb;
//#endif 

} 

//#endif 


//#if -1079359620 
public void parseOperationFig(
        Object classifier,
        Object operation,
        String text) throws ParseException
    { 

//#if 1288214720 
if(classifier == null || operation == null)//1
{ 

//#if 379040941 
return;
//#endif 

} 

//#endif 


//#if -2115553919 
ParseException pex = null;
//#endif 


//#if 414124408 
int start = 0;
//#endif 


//#if -2110590649 
int end = NotationUtilityUml.indexOfNextCheckedSemicolon(text, start);
//#endif 


//#if -36242047 
Project currentProject =
            ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1600092391 
if(end == -1)//1
{ 

//#if 1614861826 
currentProject.moveToTrash(operation);
//#endif 


//#if 1337882360 
return;
//#endif 

} 

//#endif 


//#if -318613950 
String s = text.substring(start, end).trim();
//#endif 


//#if 1046869320 
if(s.length() == 0)//1
{ 

//#if 470316144 
currentProject.moveToTrash(operation);
//#endif 


//#if -1955828150 
return;
//#endif 

} 

//#endif 


//#if 74062889 
parseOperation(s, operation);
//#endif 


//#if 1631933367 
int i = Model.getFacade().getFeatures(classifier).indexOf(operation);
//#endif 


//#if -1963672590 
start = end + 1;
//#endif 


//#if 994252092 
end = NotationUtilityUml.indexOfNextCheckedSemicolon(text, start);
//#endif 


//#if -2125962465 
while (end > start && end <= text.length()) //1
{ 

//#if -1058487365 
s = text.substring(start, end).trim();
//#endif 


//#if -1839239054 
if(s.length() > 0)//1
{ 

//#if -1844152563 
Object returnType = currentProject.getDefaultReturnType();
//#endif 


//#if -1498333678 
Object newOp =
                    Model.getCoreFactory()
                    .buildOperation(classifier, returnType);
//#endif 


//#if 759685823 
if(newOp != null)//1
{ 

//#if -340327653 
try //1
{ 

//#if -1942223013 
parseOperation(s, newOp);
//#endif 


//#if 1484784699 
if(i != -1)//1
{ 

//#if 99804429 
Model.getCoreHelper().addFeature(
                                classifier, ++i, newOp);
//#endif 

} 
else
{ 

//#if 428822783 
Model.getCoreHelper().addFeature(
                                classifier, newOp);
//#endif 

} 

//#endif 

} 

//#if 636099394 
catch (ParseException ex) //1
{ 

//#if -1716675922 
if(pex == null)//1
{ 

//#if 432482645 
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


//#if 553855882 
start = end + 1;
//#endif 


//#if 2046815908 
end = NotationUtilityUml.indexOfNextCheckedSemicolon(text, start);
//#endif 

} 

//#endif 


//#if -1043012320 
if(pex != null)//1
{ 

//#if -1708388960 
throw pex;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -264700027 
private void parseError(String message, int offset)
    throws ParseException
    { 

//#if 118528917 
throw new ParseException(
            Translator.localize("parsing.error." + message),
            offset);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

