package org.argouml.notation.providers.uml;
import java.text.ParseException;
import java.util.ArrayList;
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
import org.argouml.notation.providers.AttributeNotation;
import org.argouml.uml.StereotypeUtility;
import org.argouml.util.MyTokenizer;
public class AttributeNotationUml extends AttributeNotation
  { 
private static final AttributeNotationUml INSTANCE =
        new AttributeNotationUml();
public void parse(Object modelElement, String text)
    { 
try//1
{ 
parseAttributeFig(Model.getFacade().getOwner(modelElement),
                              modelElement, text);
} 
catch (ParseException pe) //1
{ 
String msg = "statusmsg.bar.error.parsing.attribute";
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
} 
} 
private void dealWithValue(Object attribute, StringBuilder value)
    { 
if(value != null)//1
{ 
Project project =
                ProjectManager.getManager().getCurrentProject();
ProjectSettings ps = project.getProjectSettings();
Object initExpr = Model.getDataTypesFactory().createExpression(
                                  ps.getNotationLanguage(), value.toString().trim());
Model.getCoreHelper().setInitialValue(attribute, initExpr);
} 
} 
private void dealWithVisibility(Object attribute, String visibility)
    { 
if(visibility != null)//1
{ 
Model.getCoreHelper().setVisibility(attribute,
                                                NotationUtilityUml.getVisibility(visibility.trim()));
} 
} 
private void dealWithMultiplicity(Object attribute,
                                      StringBuilder multiplicity, int multindex) throws ParseException
    { 
if(multiplicity != null)//1
{ 
try//1
{ 
Model.getCoreHelper().setMultiplicity(attribute,
                                                      Model.getDataTypesFactory().createMultiplicity(
                                                              multiplicity.toString().trim()));
} 
catch (IllegalArgumentException iae) //1
{ 
String msg = "parsing.error.attribute.bad-multiplicity";
Object[] args = {iae};
throw new ParseException(Translator.localize(msg, args),
                                         multindex);
} 
} 
} 
private void dealWithName(Object attribute, String name)
    { 
if(name != null)//1
{ 
Model.getCoreHelper().setName(attribute, name.trim());
} 
else
if(Model.getFacade().getName(attribute) == null
                   || "".equals(Model.getFacade().getName(attribute)))//1
{ 
Model.getCoreHelper().setName(attribute, "anonymous");
} 
} 
public void parseAttributeFig(
        Object classifier,
        Object attribute,
        String text) throws ParseException
    { 
if(classifier == null || attribute == null)//1
{ 
return;
} 
Project project = ProjectManager.getManager().getCurrentProject();
ParseException pex = null;
int start = 0;
int end = NotationUtilityUml.indexOfNextCheckedSemicolon(text, start);
if(end == -1)//1
{ 
project.moveToTrash(attribute);
return;
} 
String s = text.substring(start, end).trim();
if(s.length() == 0)//1
{ 
project.moveToTrash(attribute);
return;
} 
parseAttribute(s, attribute);
int i = Model.getFacade().getFeatures(classifier).indexOf(attribute);
start = end + 1;
end = NotationUtilityUml.indexOfNextCheckedSemicolon(text, start);
while (end > start && end <= text.length()) //1
{ 
s = text.substring(start, end).trim();
if(s.length() > 0)//1
{ 
Object attrType = project.getDefaultAttributeType();
Object newAttribute = Model.getUmlFactory().buildNode(
                                          Model.getMetaTypes().getAttribute());
Model.getCoreHelper().setType(newAttribute, attrType);
if(newAttribute != null)//1
{ 
if(i != -1)//1
{ 
Model.getCoreHelper().addFeature(
                            classifier, ++i, newAttribute);
} 
else
{ 
Model.getCoreHelper().addFeature(
                            classifier, newAttribute);
} 
try//1
{ 
parseAttribute(s, newAttribute);
Model.getCoreHelper().setStatic(
                            newAttribute,
                            Model.getFacade().isStatic(attribute));
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
public static final AttributeNotationUml getInstance()
    { 
return INSTANCE;
} 
public String getParsingHelp()
    { 
return "parsing.help.attribute";
} 
private void dealWithType(Object attribute, String type)
    { 
if(type != null)//1
{ 
Object ow = Model.getFacade().getOwner(attribute);
Object ns = null;
if(ow != null && Model.getFacade().getNamespace(ow) != null)//1
{ 
ns = Model.getFacade().getNamespace(ow);
} 
else
{ 
ns = Model.getFacade().getModel(attribute);
} 
Model.getCoreHelper().setType(attribute,
                                          NotationUtilityUml.getType(type.trim(), ns));
} 
} 
protected AttributeNotationUml()
    { 
super();
} 
private static String generateMultiplicity(Object m)
    { 
if(m == null || "1".equals(Model.getFacade().toString(m)))//1
{ 
return "";
} 
return Model.getFacade().toString(m);
} 
private String toString(Object modelElement, boolean useGuillemets,
                            boolean showVisibility, boolean showMultiplicity, boolean showTypes,
                            boolean showInitialValues, boolean showProperties)
    { 
try//1
{ 
String stereo = NotationUtilityUml.generateStereotype(modelElement,
                            useGuillemets);
String name = Model.getFacade().getName(modelElement);
String multiplicity = generateMultiplicity(
                                      Model.getFacade().getMultiplicity(modelElement));
String type = "";
if(Model.getFacade().getType(modelElement) != null)//1
{ 
type = Model.getFacade().getName(
                           Model.getFacade().getType(modelElement));
} 
StringBuilder sb = new StringBuilder(20);
if((stereo != null) && (stereo.length() > 0))//1
{ 
sb.append(stereo).append(" ");
} 
if(showVisibility)//1
{ 
String visibility = NotationUtilityUml
                                    .generateVisibility2(modelElement);
if(visibility != null && visibility.length() > 0)//1
{ 
sb.append(visibility);
} 
} 
if((name != null) && (name.length() > 0))//1
{ 
sb.append(name).append(" ");
} 
if((multiplicity != null)
                    && (multiplicity.length() > 0)
                    && showMultiplicity)//1
{ 
sb.append("[").append(multiplicity).append("]").append(" ");
} 
if((type != null) && (type.length() > 0)
                    /*
                     * The "show types" defaults to TRUE, to stay compatible
                     * with older ArgoUML versions that did not have this
                     * setting:
                     */
                    && showTypes)//1
{ 
sb.append(": ").append(type).append(" ");
} 
if(showInitialValues)//1
{ 
Object iv = Model.getFacade().getInitialValue(modelElement);
if(iv != null)//1
{ 
String initialValue =
                        (String) Model.getFacade().getBody(iv);
if(initialValue != null && initialValue.length() > 0)//1
{ 
sb.append(" = ").append(initialValue).append(" ");
} 
} 
} 
if(showProperties)//1
{ 
String changeableKind = "";
if(Model.getFacade().isReadOnly(modelElement))//1
{ 
changeableKind = "frozen";
} 
if(Model.getFacade().getChangeability(modelElement) != null)//1
{ 
if(Model.getChangeableKind().getAddOnly().equals(
                                Model.getFacade().getChangeability(modelElement)))//1
{ 
changeableKind = "addOnly";
} 
} 
StringBuilder properties = new StringBuilder();
if(changeableKind.length() > 0)//1
{ 
properties.append("{ ").append(changeableKind).append(" }");
} 
if(properties.length() > 0)//1
{ 
sb.append(properties);
} 
} 
return sb.toString().trim();
} 
catch (InvalidElementException e) //1
{ 
return "";
} 
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public String toString(Object modelElement, Map args)
    { 
Project p = ProjectManager.getManager().getCurrentProject();
ProjectSettings ps = p.getProjectSettings();
return toString(modelElement, ps.getUseGuillemotsValue(),
                        ps.getShowVisibilityValue(), ps.getShowMultiplicityValue(),
                        ps.getShowTypesValue(), ps.getShowInitialValueValue(),
                        ps.getShowPropertiesValue());
} 
private void dealWithProperties(Object attribute, List<String> properties)
    { 
if(properties != null)//1
{ 
NotationUtilityUml.setProperties(attribute, properties,
                                             NotationUtilityUml.attributeSpecialStrings);
} 
} 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 
return toString(modelElement, settings.isUseGuillemets(), settings
                        .isShowVisibilities(), settings.isShowMultiplicities(), settings
                        .isShowTypes(), settings.isShowInitialValues(),
                        settings.isShowProperties());
} 
protected void parseAttribute(
        String text,
        Object attribute) throws ParseException
    { 
StringBuilder multiplicity = null;
String name = null;
List<String> properties = null;
StringBuilder stereotype = null;
String token;
String type = null;
StringBuilder value = null;
String visibility = null;
boolean hasColon = false;
boolean hasEq = false;
int multindex = -1;
MyTokenizer st;
text = text.trim();
if(text.length() > 0
                && NotationUtilityUml.VISIBILITYCHARS.indexOf(text.charAt(0))
                >= 0)//1
{ 
visibility = text.substring(0, 1);
text = text.substring(1);
} 
try//1
{ 
st = new MyTokenizer(text,
                                 " ,\t,<<,\u00AB,\u00BB,>>,[,],:,=,{,},\\,",
                                 NotationUtilityUml.attributeCustomSep);
while (st.hasMoreTokens()) //1
{ 
token = st.nextToken();
if(" ".equals(token) || "\t".equals(token)
                        || ",".equals(token))//1
{ 
if(hasEq)//1
{ 
value.append(token);
} 
} 
else
if("<<".equals(token) || "\u00AB".equals(token))//1
{ 
if(hasEq)//1
{ 
value.append(token);
} 
else
{ 
if(stereotype != null)//1
{ 
String msg =
                                "parsing.error.attribute.two-sets-stereotypes";
throw new ParseException(Translator.localize(msg),
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
} 
else
if("[".equals(token))//1
{ 
if(hasEq)//1
{ 
value.append(token);
} 
else
{ 
if(multiplicity != null)//1
{ 
String msg =
                                "parsing.error.attribute.two-multiplicities";
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
} 
multiplicity = new StringBuilder();
multindex = st.getTokenIndex() + 1;
while (true) //1
{ 
token = st.nextToken();
if("]".equals(token))//1
{ 
break;

} 
multiplicity.append(token);
} 
} 
} 
else
if("{".equals(token))//1
{ 
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
                                    "parsing.error.attribute.prop-two-values";
Object[] args = {propvalue};
throw new ParseException(Translator.localize(
                                                             msg, args), st.getTokenIndex());
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
} 
else
if(":".equals(token))//1
{ 
hasColon = true;
hasEq = false;
} 
else
if("=".equals(token))//1
{ 
if(value != null)//1
{ 
String msg =
                            "parsing.error.attribute.two-default-values";
throw new ParseException(Translator.localize(msg), st
                                                 .getTokenIndex());
} 
value = new StringBuilder();
hasColon = false;
hasEq = true;
} 
else
{ 
if(hasColon)//1
{ 
if(type != null)//1
{ 
String msg = "parsing.error.attribute.two-types";
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
} 
if(token.length() > 0
                                && (token.charAt(0) == '\"'
                                    || token.charAt(0) == '\''))//1
{ 
String msg = "parsing.error.attribute.quoted";
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
} 
if(token.length() > 0 && token.charAt(0) == '(')//1
{ 
String msg = "parsing.error.attribute.is-expr";
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
} 
type = token;
} 
else
if(hasEq)//1
{ 
value.append(token);
} 
else
{ 
if(name != null && visibility != null)//1
{ 
String msg = "parsing.error.attribute.extra-text";
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
} 
if(token.length() > 0
                                && (token.charAt(0) == '\"'
                                    || token.charAt(0) == '\''))//1
{ 
String msg = "parsing.error.attribute.name-quoted";
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
} 
if(token.length() > 0 && token.charAt(0) == '(')//1
{ 
String msg = "parsing.error.attribute.name-expr";
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
} 
if(name == null
                                && visibility == null
                                && token.length() > 1
                                && NotationUtilityUml.VISIBILITYCHARS
                                .indexOf(token.charAt(0)) >= 0)//1
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
String msg = "parsing.error.attribute.unexpected-end-attribute";
throw new ParseException(Translator.localize(msg), text.length());
} 
dealWithVisibility(attribute, visibility);
dealWithName(attribute, name);
dealWithType(attribute, type);
dealWithValue(attribute, value);
dealWithMultiplicity(attribute, multiplicity, multindex);
dealWithProperties(attribute, properties);
StereotypeUtility.dealWithStereotypes(attribute, stereotype, true);
} 

 } 
