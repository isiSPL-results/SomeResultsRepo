package org.argouml.notation.providers.uml;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoHelpEvent;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.kernel.ProjectSettings;
import org.argouml.model.InvalidElementException;
import org.argouml.model.Model;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.providers.OperationNotation;
import org.argouml.uml.StereotypeUtility;
import org.argouml.util.MyTokenizer;
public class OperationNotationUml extends OperationNotation
  { 
private static final String RECEPTION_KEYWORD = "signal";
private void setReturnParameter(Object op, Object type)
    { 
Object param = null;
Iterator it = Model.getFacade().getParameters(op).iterator();
while (it.hasNext()) //1
{ 
Object p = it.next();
if(Model.getFacade().isReturn(p))//1
{ 
param = p;
break;

} 
} 
while (it.hasNext()) //2
{ 
Object p = it.next();
if(Model.getFacade().isReturn(p))//1
{ 
ProjectManager.getManager().getCurrentProject().moveToTrash(p);
} 
} 
if(param == null)//1
{ 
Object returnType =
                ProjectManager.getManager()
                .getCurrentProject().getDefaultReturnType();
param = Model.getCoreFactory().buildParameter(op, returnType);
} 
Model.getCoreHelper().setType(param, type);
} 
public OperationNotationUml(Object operation)
    { 
super(operation);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public String toString(Object modelElement, Map args)
    { 
Project p = ProjectManager.getManager().getCurrentProject();
ProjectSettings ps = p.getProjectSettings();
return toString(modelElement, ps.getUseGuillemotsValue(),
                        ps.getShowVisibilityValue(), ps
                        .getShowTypesValue(), ps.getShowPropertiesValue());
} 
private StringBuffer getReturnParameters(Object modelElement,
            boolean isReception)
    { 
StringBuffer returnParasSb = new StringBuffer();
if(!isReception)//1
{ 
Collection coll =
                Model.getCoreHelper().getReturnParameters(modelElement);
if(coll != null && coll.size() > 0)//1
{ 
returnParasSb.append(": ");
Iterator it2 = coll.iterator();
while (it2.hasNext()) //1
{ 
Object type = Model.getFacade().getType(it2.next());
if(type != null)//1
{ 
returnParasSb.append(Model.getFacade()
                                             .getName(type));
} 
returnParasSb.append(",");
} 
if(returnParasSb.length() == 3)//1
{ 
returnParasSb.delete(0, returnParasSb.length());
} 
else
{ 
returnParasSb.delete(
                        returnParasSb.length() - 1,
                        returnParasSb.length());
} 
} 
} 
return returnParasSb;
} 
private String toString(Object modelElement, boolean useGuillemets,
                            boolean showVisibility,
                            boolean showTypes, boolean showProperties)
    { 
try//1
{ 
String stereoStr = NotationUtilityUml.generateStereotype(
                                   Model.getFacade().getStereotypes(modelElement),
                                   useGuillemets);
boolean isReception = Model.getFacade().isAReception(modelElement);
if(isReception)//1
{ 
stereoStr =
                    NotationUtilityUml
                    .generateStereotype(RECEPTION_KEYWORD,
                                        useGuillemets)
                    + " " + stereoStr;
} 
StringBuffer genStr = new StringBuffer(30);
if((stereoStr != null) && (stereoStr.length() > 0))//1
{ 
genStr.append(stereoStr).append(" ");
} 
if(showVisibility)//1
{ 
String visStr = NotationUtilityUml
                                .generateVisibility2(modelElement);
if(visStr != null)//1
{ 
genStr.append(visStr);
} 
} 
String nameStr = Model.getFacade().getName(modelElement);
if((nameStr != null) && (nameStr.length() > 0))//1
{ 
genStr.append(nameStr);
} 
if(showTypes)//1
{ 
StringBuffer parameterStr = new StringBuffer();
parameterStr.append("(").append(getParameterList(modelElement))
                .append(")");
StringBuffer returnParasSb = getReturnParameters(modelElement,
                                             isReception);
genStr.append(parameterStr).append(" ");
if((returnParasSb != null) && (returnParasSb.length() > 0))//1
{ 
genStr.append(returnParasSb).append(" ");
} 
} 
else
{ 
genStr.append("()");
} 
if(showProperties)//1
{ 
StringBuffer propertySb = getProperties(modelElement,
                                                        isReception);
if(propertySb.length() > 0)//1
{ 
genStr.append(propertySb);
} 
} 
return genStr.toString().trim();
} 
catch (InvalidElementException e) //1
{ 
return "";
} 
} 
public String getParsingHelp()
    { 
return "parsing.help.operation";
} 
private List<String> tokenOpenBrace(MyTokenizer st, List<String> properties)
    throws ParseException
    { 
String token;
StringBuilder propname = new StringBuilder();
String propvalue = null;
if(properties == null)//1
{ 
properties = new ArrayList<String>();
} 
while (true) //1
{ 
token = st.nextToken();
if(",".equals(token) || "}".equals(token))//1
{ 
if(propname.length() > 0)//1
{ 
properties.add(propname.toString());
properties.add(propvalue);
} 
propname = new StringBuilder();
propvalue = null;
if("}".equals(token))//1
{ 
break;

} 
} 
else
if("=".equals(token))//1
{ 
if(propvalue != null)//1
{ 
String msg =
                        "parsing.error.operation.prop-stereotypes";
Object[] args = {propname};
throw new ParseException(
                        Translator.localize(msg,
                                            args),
                        st.getTokenIndex());
} 
propvalue = "";
} 
else
if(propvalue == null)//1
{ 
propname.append(token);
} 
else
{ 
propvalue += token;
} 
} 
if(propname.length() > 0)//1
{ 
properties.add(propname.toString());
properties.add(propvalue);
} 
return properties;
} 
public void parse(Object modelElement, String text)
    { 
try//1
{ 
parseOperationFig(Model.getFacade().getOwner(modelElement),
                              modelElement, text);
} 
catch (ParseException pe) //1
{ 
String msg = "statusmsg.bar.error.parsing.operation";
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
} 
} 
private StringBuffer getProperties(Object modelElement,
                                       boolean isReception)
    { 
StringBuffer propertySb = new StringBuffer().append("{");
if(Model.getFacade().isQuery(modelElement))//1
{ 
propertySb.append("query,");
} 
if(Model.getFacade().isRoot(modelElement))//1
{ 
propertySb.append("root,");
} 
if(Model.getFacade().isLeaf(modelElement))//1
{ 
propertySb.append("leaf,");
} 
if(!isReception)//1
{ 
if(Model.getFacade().getConcurrency(modelElement) != null)//1
{ 
propertySb.append(Model.getFacade().getName(
                                      Model.getFacade().getConcurrency(modelElement)));
propertySb.append(',');
} 
} 
if(propertySb.length() > 1)//1
{ 
propertySb.delete(propertySb.length() - 1, propertySb.length());
propertySb.append("}");
} 
else
{ 
propertySb = new StringBuffer();
} 
return propertySb;
} 
private StringBuffer getParameterList(Object modelElement)
    { 
StringBuffer parameterListBuffer = new StringBuffer();
Collection coll = Model.getFacade().getParameters(modelElement);
Iterator it = coll.iterator();
int counter = 0;
while (it.hasNext()) //1
{ 
Object parameter = it.next();
if(!Model.getFacade().hasReturnParameterDirectionKind(
                        parameter))//1
{ 
counter++;
parameterListBuffer.append(
                    NotationUtilityUml.generateParameter(parameter));
parameterListBuffer.append(",");
} 
} 
if(counter > 0)//1
{ 
parameterListBuffer.delete(
                parameterListBuffer.length() - 1,
                parameterListBuffer.length());
} 
return parameterListBuffer;
} 
public String toString(Object modelElement, NotationSettings settings)
    { 
return toString(modelElement, settings.isUseGuillemets(),
                        settings.isShowVisibilities(), settings.isShowTypes(),
                        settings.isShowProperties());
} 
public void parseOperation(String s, Object op) throws ParseException
    { 
MyTokenizer st;
boolean hasColon = false;
String name = null;
String parameterlist = null;
StringBuilder stereotype = null;
String token;
String type = null;
String visibility = null;
List<String> properties = null;
int paramOffset = 0;
s = s.trim();
if(s.length() > 0
                && NotationUtilityUml.VISIBILITYCHARS.indexOf(s.charAt(0))
                >= 0)//1
{ 
visibility = s.substring(0, 1);
s = s.substring(1);
} 
try//1
{ 
st = new MyTokenizer(s, " ,\t,<<,\u00AB,\u00BB,>>,:,=,{,},\\,",
                                 NotationUtilityUml.operationCustomSep);
while (st.hasMoreTokens()) //1
{ 
token = st.nextToken();
if(" ".equals(token) || "\t".equals(token)
                        || ",".equals(token))//1
{ 
continue;
} 
else
if("<<".equals(token) || "\u00AB".equals(token))//1
{ 
if(stereotype != null)//1
{ 
parseError("operation.stereotypes",
                                   st.getTokenIndex());
} 
stereotype = new StringBuilder();
while (true) //1
{ 
token = st.nextToken();
if(">>".equals(token) || "\u00BB".equals(token))//1
{ 
break;

} 
stereotype.append(token);
} 
} 
else
if("{".equals(token))//1
{ 
properties = tokenOpenBrace(st, properties);
} 
else
if(":".equals(token))//1
{ 
hasColon = true;
} 
else
if("=".equals(token))//1
{ 
parseError("operation.default-values", st.getTokenIndex());
} 
else
if(token.charAt(0) == '(' && !hasColon)//1
{ 
if(parameterlist != null)//1
{ 
parseError("operation.two-parameter-lists",
                                   st.getTokenIndex());
} 
parameterlist = token;
} 
else
{ 
if(hasColon)//1
{ 
if(type != null)//1
{ 
parseError("operation.two-types",
                                       st.getTokenIndex());
} 
if(token.length() > 0
                                && (token.charAt(0) == '\"'
                                    || token.charAt(0) == '\''))//1
{ 
parseError("operation.type-quoted",
                                       st.getTokenIndex());
} 
if(token.length() > 0 && token.charAt(0) == '(')//1
{ 
parseError("operation.type-expr",
                                       st.getTokenIndex());
} 
type = token;
} 
else
{ 
if(name != null && visibility != null)//1
{ 
parseError("operation.extra-text",
                                       st.getTokenIndex());
} 
if(token.length() > 0
                                && (token.charAt(0) == '\"'
                                    || token.charAt(0) == '\''))//1
{ 
parseError("operation.name-quoted",
                                       st.getTokenIndex());
} 
if(token.length() > 0 && token.charAt(0) == '(')//1
{ 
parseError("operation.name-expr",
                                       st.getTokenIndex());
} 
if(name == null
                                && visibility == null
                                && token.length() > 1
                                && NotationUtilityUml.VISIBILITYCHARS.indexOf(
                                    token.charAt(0))
                                >= 0)//1
{ 
visibility = token.substring(0, 1);
token = token.substring(1);
} 
if(name != null)//1
{ 
visibility = name;
name = token;
} 
else
{ 
name = token;
} 
} 
} 
} 
} 
catch (NoSuchElementException nsee) //1
{ 
parseError("operation.unexpected-end-operation",
                       s.length());
} 
catch (ParseException pre) //1
{ 
throw pre;
} 
if(parameterlist != null)//1
{ 
if(parameterlist.charAt(parameterlist.length() - 1) != ')')//1
{ 
parseError("operation.parameter-list-incomplete",
                           paramOffset + parameterlist.length() - 1);
} 
paramOffset++;
parameterlist = parameterlist.substring(1,
                                                    parameterlist.length() - 1);
NotationUtilityUml.parseParamList(op, parameterlist, paramOffset);
} 
if(visibility != null)//1
{ 
Model.getCoreHelper().setVisibility(op,
                                                NotationUtilityUml.getVisibility(visibility.trim()));
} 
if(name != null)//1
{ 
Model.getCoreHelper().setName(op, name.trim());
} 
else
if(Model.getFacade().getName(op) == null
                   || "".equals(Model.getFacade().getName(op)))//1
{ 
Model.getCoreHelper().setName(op, "anonymous");
} 
if(type != null)//1
{ 
Object ow = Model.getFacade().getOwner(op);
Object ns = null;
if(ow != null && Model.getFacade().getNamespace(ow) != null)//1
{ 
ns = Model.getFacade().getNamespace(ow);
} 
else
{ 
ns = Model.getFacade().getModel(op);
} 
Object mtype = NotationUtilityUml.getType(type.trim(), ns);
setReturnParameter(op, mtype);
} 
if(properties != null)//1
{ 
NotationUtilityUml.setProperties(op, properties,
                                             NotationUtilityUml.operationSpecialStrings);
} 
if(!Model.getFacade().isAReception(op)
                || !RECEPTION_KEYWORD.equals(stereotype.toString()))//1
{ 
StereotypeUtility.dealWithStereotypes(op, stereotype, true);
} 
} 
private StringBuffer getTaggedValues(Object modelElement)
    { 
StringBuffer taggedValuesSb = new StringBuffer();
Iterator it3 = Model.getFacade().getTaggedValues(modelElement);
if(it3 != null && it3.hasNext())//1
{ 
while (it3.hasNext()) //1
{ 
taggedValuesSb.append(
                    NotationUtilityUml.generateTaggedValue(it3.next()));
taggedValuesSb.append(",");
} 
taggedValuesSb.delete(
                taggedValuesSb.length() - 1,
                taggedValuesSb.length());
} 
return taggedValuesSb;
} 
public void parseOperationFig(
        Object classifier,
        Object operation,
        String text) throws ParseException
    { 
if(classifier == null || operation == null)//1
{ 
return;
} 
ParseException pex = null;
int start = 0;
int end = NotationUtilityUml.indexOfNextCheckedSemicolon(text, start);
Project currentProject =
            ProjectManager.getManager().getCurrentProject();
if(end == -1)//1
{ 
currentProject.moveToTrash(operation);
return;
} 
String s = text.substring(start, end).trim();
if(s.length() == 0)//1
{ 
currentProject.moveToTrash(operation);
return;
} 
parseOperation(s, operation);
int i = Model.getFacade().getFeatures(classifier).indexOf(operation);
start = end + 1;
end = NotationUtilityUml.indexOfNextCheckedSemicolon(text, start);
while (end > start && end <= text.length()) //1
{ 
s = text.substring(start, end).trim();
if(s.length() > 0)//1
{ 
Object returnType = currentProject.getDefaultReturnType();
Object newOp =
                    Model.getCoreFactory()
                    .buildOperation(classifier, returnType);
if(newOp != null)//1
{ 
try//1
{ 
parseOperation(s, newOp);
if(i != -1)//1
{ 
Model.getCoreHelper().addFeature(
                                classifier, ++i, newOp);
} 
else
{ 
Model.getCoreHelper().addFeature(
                                classifier, newOp);
} 
} 
catch (ParseException ex) //1
{ 
if(pex == null)//1
{ 
pex = ex;
} 
} 
} 
} 
start = end + 1;
end = NotationUtilityUml.indexOfNextCheckedSemicolon(text, start);
} 
if(pex != null)//1
{ 
throw pex;
} 
} 
private void parseError(String message, int offset)
    throws ParseException
    { 
throw new ParseException(
            Translator.localize("parsing.error." + message),
            offset);
} 

 } 
