
//#if 1689575977 
// Compilation Unit of /AttributeNotationUml.java 
 

//#if -11496184 
package org.argouml.notation.providers.uml;
//#endif 


//#if 434826041 
import java.text.ParseException;
//#endif 


//#if 1926819829 
import java.util.ArrayList;
//#endif 


//#if -33463988 
import java.util.List;
//#endif 


//#if 414584464 
import java.util.Map;
//#endif 


//#if 432139087 
import java.util.NoSuchElementException;
//#endif 


//#if -180621669 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if -1186013158 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if -329381436 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if 392570399 
import org.argouml.i18n.Translator;
//#endif 


//#if 822954117 
import org.argouml.kernel.Project;
//#endif 


//#if 1564211908 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1051441502 
import org.argouml.kernel.ProjectSettings;
//#endif 


//#if 570600484 
import org.argouml.model.InvalidElementException;
//#endif 


//#if 1534384229 
import org.argouml.model.Model;
//#endif 


//#if -1712984392 
import org.argouml.notation.NotationSettings;
//#endif 


//#if -1727731545 
import org.argouml.notation.providers.AttributeNotation;
//#endif 


//#if -1780977847 
import org.argouml.uml.StereotypeUtility;
//#endif 


//#if -2097629586 
import org.argouml.util.MyTokenizer;
//#endif 


//#if -313152270 
import org.apache.log4j.Logger;
//#endif 


//#if -1381542535 
public class AttributeNotationUml extends 
//#if -112930606 
AttributeNotation
//#endif 

  { 

//#if 255766021 
private static final AttributeNotationUml INSTANCE =
        new AttributeNotationUml();
//#endif 


//#if -1586219784 
private static final Logger LOG =
        Logger.getLogger(AttributeNotationUml.class);
//#endif 


//#if -648609489 
public void parse(Object modelElement, String text)
    { 

//#if -2006717130 
try //1
{ 

//#if 238744657 
parseAttributeFig(Model.getFacade().getOwner(modelElement),
                              modelElement, text);
//#endif 

} 

//#if 1796770568 
catch (ParseException pe) //1
{ 

//#if 73392985 
String msg = "statusmsg.bar.error.parsing.attribute";
//#endif 


//#if 799908545 
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
//#endif 


//#if 1335047346 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -2089337185 
private void dealWithValue(Object attribute, StringBuilder value)
    { 

//#if 875312140 
if(value != null)//1
{ 

//#if 297347471 
Project project =
                ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 647950291 
ProjectSettings ps = project.getProjectSettings();
//#endif 


//#if -1746553573 
Object initExpr = Model.getDataTypesFactory().createExpression(
                                  ps.getNotationLanguage(), value.toString().trim());
//#endif 


//#if -2120413731 
Model.getCoreHelper().setInitialValue(attribute, initExpr);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2092738526 
private void dealWithVisibility(Object attribute, String visibility)
    { 

//#if -516371422 
if(visibility != null)//1
{ 

//#if -1626979988 
Model.getCoreHelper().setVisibility(attribute,
                                                NotationUtilityUml.getVisibility(visibility.trim()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 200830529 
private void dealWithMultiplicity(Object attribute,
                                      StringBuilder multiplicity, int multindex) throws ParseException
    { 

//#if -1543896957 
if(multiplicity != null)//1
{ 

//#if 935578154 
try //1
{ 

//#if -1170254899 
Model.getCoreHelper().setMultiplicity(attribute,
                                                      Model.getDataTypesFactory().createMultiplicity(
                                                              multiplicity.toString().trim()));
//#endif 

} 

//#if 872378903 
catch (IllegalArgumentException iae) //1
{ 

//#if 832412723 
String msg = "parsing.error.attribute.bad-multiplicity";
//#endif 


//#if -808335401 
Object[] args = {iae};
//#endif 


//#if -1952089180 
throw new ParseException(Translator.localize(msg, args),
                                         multindex);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -1253447042 
private void dealWithName(Object attribute, String name)
    { 

//#if -1215592576 
if(name != null)//1
{ 

//#if -485479537 
Model.getCoreHelper().setName(attribute, name.trim());
//#endif 

} 
else

//#if -1729563472 
if(Model.getFacade().getName(attribute) == null
                   || "".equals(Model.getFacade().getName(attribute)))//1
{ 

//#if 192305541 
Model.getCoreHelper().setName(attribute, "anonymous");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 570230927 
public void parseAttributeFig(
        Object classifier,
        Object attribute,
        String text) throws ParseException
    { 

//#if -1285268597 
if(classifier == null || attribute == null)//1
{ 

//#if -1606329685 
return;
//#endif 

} 

//#endif 


//#if 491622666 
Project project = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1660990741 
ParseException pex = null;
//#endif 


//#if -1904448030 
int start = 0;
//#endif 


//#if -2103222883 
int end = NotationUtilityUml.indexOfNextCheckedSemicolon(text, start);
//#endif 


//#if 1767428719 
if(end == -1)//1
{ 

//#if 1970979201 
project.moveToTrash(attribute);
//#endif 


//#if 1107936335 
return;
//#endif 

} 

//#endif 


//#if -1800690388 
String s = text.substring(start, end).trim();
//#endif 


//#if -707663842 
if(s.length() == 0)//1
{ 

//#if 602584752 
project.moveToTrash(attribute);
//#endif 


//#if 292656766 
return;
//#endif 

} 

//#endif 


//#if -213497495 
parseAttribute(s, attribute);
//#endif 


//#if 1199709186 
int i = Model.getFacade().getFeatures(classifier).indexOf(attribute);
//#endif 


//#if -824974136 
start = end + 1;
//#endif 


//#if -1137444698 
end = NotationUtilityUml.indexOfNextCheckedSemicolon(text, start);
//#endif 


//#if -1041472375 
while (end > start && end <= text.length()) //1
{ 

//#if -554796163 
s = text.substring(start, end).trim();
//#endif 


//#if 1409346612 
if(s.length() > 0)//1
{ 

//#if 1389283813 
Object attrType = project.getDefaultAttributeType();
//#endif 


//#if 732844533 
Object newAttribute = Model.getUmlFactory().buildNode(
                                          Model.getMetaTypes().getAttribute());
//#endif 


//#if -157669184 
Model.getCoreHelper().setType(newAttribute, attrType);
//#endif 


//#if 859443872 
if(newAttribute != null)//1
{ 

//#if -758986558 
if(i != -1)//1
{ 

//#if 2140616362 
Model.getCoreHelper().addFeature(
                            classifier, ++i, newAttribute);
//#endif 

} 
else
{ 

//#if -678285408 
Model.getCoreHelper().addFeature(
                            classifier, newAttribute);
//#endif 

} 

//#endif 


//#if 1050617586 
try //1
{ 

//#if -1177897914 
parseAttribute(s, newAttribute);
//#endif 


//#if 976338468 
Model.getCoreHelper().setStatic(
                            newAttribute,
                            Model.getFacade().isStatic(attribute));
//#endif 

} 

//#if -667231019 
catch (ParseException ex) //1
{ 

//#if 440998491 
if(pex == null)//1
{ 

//#if 1385917300 
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


//#if 1943832072 
start = end + 1;
//#endif 


//#if 2036879206 
end = NotationUtilityUml.indexOfNextCheckedSemicolon(text, start);
//#endif 

} 

//#endif 


//#if 1034400502 
if(pex != null)//1
{ 

//#if 1290368046 
throw pex;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1513805533 
public static final AttributeNotationUml getInstance()
    { 

//#if 286928043 
return INSTANCE;
//#endif 

} 

//#endif 


//#if -299569086 
public String getParsingHelp()
    { 

//#if 784562008 
return "parsing.help.attribute";
//#endif 

} 

//#endif 


//#if -559696930 
private void dealWithType(Object attribute, String type)
    { 

//#if -550805684 
if(type != null)//1
{ 

//#if 626071578 
Object ow = Model.getFacade().getOwner(attribute);
//#endif 


//#if -223815780 
Object ns = null;
//#endif 


//#if 549094848 
if(ow != null && Model.getFacade().getNamespace(ow) != null)//1
{ 

//#if 131126884 
ns = Model.getFacade().getNamespace(ow);
//#endif 

} 
else
{ 

//#if 2133489430 
ns = Model.getFacade().getModel(attribute);
//#endif 

} 

//#endif 


//#if -688469871 
Model.getCoreHelper().setType(attribute,
                                          NotationUtilityUml.getType(type.trim(), ns));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1375733049 
protected AttributeNotationUml()
    { 

//#if -1746359966 
super();
//#endif 


//#if -1146728624 
LOG.info("Creating AttributeNotationUml");
//#endif 

} 

//#endif 


//#if -1121812103 
private static String generateMultiplicity(Object m)
    { 

//#if -1788619429 
if(m == null || "1".equals(Model.getFacade().toString(m)))//1
{ 

//#if -427439755 
return "";
//#endif 

} 

//#endif 


//#if -1551946406 
return Model.getFacade().toString(m);
//#endif 

} 

//#endif 


//#if -1238983545 
private String toString(Object modelElement, boolean useGuillemets,
                            boolean showVisibility, boolean showMultiplicity, boolean showTypes,
                            boolean showInitialValues, boolean showProperties)
    { 

//#if 53722675 
try //1
{ 

//#if 601915050 
String stereo = NotationUtilityUml.generateStereotype(modelElement,
                            useGuillemets);
//#endif 


//#if 1792510663 
String name = Model.getFacade().getName(modelElement);
//#endif 


//#if 2131372708 
String multiplicity = generateMultiplicity(
                                      Model.getFacade().getMultiplicity(modelElement));
//#endif 


//#if 903929553 
String type = "";
//#endif 


//#if -906859900 
if(Model.getFacade().getType(modelElement) != null)//1
{ 

//#if 1971329141 
type = Model.getFacade().getName(
                           Model.getFacade().getType(modelElement));
//#endif 

} 

//#endif 


//#if -1122039006 
StringBuilder sb = new StringBuilder(20);
//#endif 


//#if -278061631 
if((stereo != null) && (stereo.length() > 0))//1
{ 

//#if -688130198 
sb.append(stereo).append(" ");
//#endif 

} 

//#endif 


//#if -1955689958 
if(showVisibility)//1
{ 

//#if -1035301231 
String visibility = NotationUtilityUml
                                    .generateVisibility2(modelElement);
//#endif 


//#if 773170658 
if(visibility != null && visibility.length() > 0)//1
{ 

//#if 1950469778 
sb.append(visibility);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1802001753 
if((name != null) && (name.length() > 0))//1
{ 

//#if 1938455021 
sb.append(name).append(" ");
//#endif 

} 

//#endif 


//#if 392824491 
if((multiplicity != null)
                    && (multiplicity.length() > 0)
                    && showMultiplicity)//1
{ 

//#if -185437820 
sb.append("[").append(multiplicity).append("]").append(" ");
//#endif 

} 

//#endif 


//#if -1675223090 
if((type != null) && (type.length() > 0)
                    /*
                     * The "show types" defaults to TRUE, to stay compatible
                     * with older ArgoUML versions that did not have this
                     * setting:
                     */
                    && showTypes)//1
{ 

//#if -1626659045 
sb.append(": ").append(type).append(" ");
//#endif 

} 

//#endif 


//#if 1226001806 
if(showInitialValues)//1
{ 

//#if -1092860258 
Object iv = Model.getFacade().getInitialValue(modelElement);
//#endif 


//#if -843090428 
if(iv != null)//1
{ 

//#if 1200747372 
String initialValue =
                        (String) Model.getFacade().getBody(iv);
//#endif 


//#if 769725371 
if(initialValue != null && initialValue.length() > 0)//1
{ 

//#if 882360787 
sb.append(" = ").append(initialValue).append(" ");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -827212869 
if(showProperties)//1
{ 

//#if -303701900 
String changeableKind = "";
//#endif 


//#if 2127648936 
if(Model.getFacade().isReadOnly(modelElement))//1
{ 

//#if -1217469457 
changeableKind = "frozen";
//#endif 

} 

//#endif 


//#if -1428622205 
if(Model.getFacade().getChangeability(modelElement) != null)//1
{ 

//#if 1787683638 
if(Model.getChangeableKind().getAddOnly().equals(
                                Model.getFacade().getChangeability(modelElement)))//1
{ 

//#if 1326874553 
changeableKind = "addOnly";
//#endif 

} 

//#endif 

} 

//#endif 


//#if -936851703 
StringBuilder properties = new StringBuilder();
//#endif 


//#if 1489805037 
if(changeableKind.length() > 0)//1
{ 

//#if 1691224271 
properties.append("{ ").append(changeableKind).append(" }");
//#endif 

} 

//#endif 


//#if -975056168 
if(properties.length() > 0)//1
{ 

//#if -1667510709 
sb.append(properties);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -732645250 
return sb.toString().trim();
//#endif 

} 

//#if 2129284907 
catch (InvalidElementException e) //1
{ 

//#if 1125416392 
return "";
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -429647217 

//#if -151458910 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public String toString(Object modelElement, Map args)
    { 

//#if -266721125 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1258134995 
ProjectSettings ps = p.getProjectSettings();
//#endif 


//#if 838365293 
return toString(modelElement, ps.getUseGuillemotsValue(),
                        ps.getShowVisibilityValue(), ps.getShowMultiplicityValue(),
                        ps.getShowTypesValue(), ps.getShowInitialValueValue(),
                        ps.getShowPropertiesValue());
//#endif 

} 

//#endif 


//#if 1927098688 
private void dealWithProperties(Object attribute, List<String> properties)
    { 

//#if 1244102889 
if(properties != null)//1
{ 

//#if -1531407111 
NotationUtilityUml.setProperties(attribute, properties,
                                             NotationUtilityUml.attributeSpecialStrings);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1301143081 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if -1961836093 
return toString(modelElement, settings.isUseGuillemets(), settings
                        .isShowVisibilities(), settings.isShowMultiplicities(), settings
                        .isShowTypes(), settings.isShowInitialValues(),
                        settings.isShowProperties());
//#endif 

} 

//#endif 


//#if -971151302 
protected void parseAttribute(
        String text,
        Object attribute) throws ParseException
    { 

//#if -681011895 
StringBuilder multiplicity = null;
//#endif 


//#if 607242218 
String name = null;
//#endif 


//#if 1506846288 
List<String> properties = null;
//#endif 


//#if -1965497988 
StringBuilder stereotype = null;
//#endif 


//#if 1497756042 
String token;
//#endif 


//#if -67609255 
String type = null;
//#endif 


//#if -133660683 
StringBuilder value = null;
//#endif 


//#if 211235121 
String visibility = null;
//#endif 


//#if 368828479 
boolean hasColon = false;
//#endif 


//#if 1171347936 
boolean hasEq = false;
//#endif 


//#if -616794108 
int multindex = -1;
//#endif 


//#if 2063642214 
MyTokenizer st;
//#endif 


//#if -206840176 
text = text.trim();
//#endif 


//#if 1879698759 
if(text.length() > 0
                && NotationUtilityUml.VISIBILITYCHARS.indexOf(text.charAt(0))
                >= 0)//1
{ 

//#if 1800465422 
visibility = text.substring(0, 1);
//#endif 


//#if -2094998961 
text = text.substring(1);
//#endif 

} 

//#endif 


//#if -1607879507 
try //1
{ 

//#if 564716525 
st = new MyTokenizer(text,
                                 " ,\t,<<,\u00AB,\u00BB,>>,[,],:,=,{,},\\,",
                                 NotationUtilityUml.attributeCustomSep);
//#endif 


//#if -921698292 
while (st.hasMoreTokens()) //1
{ 

//#if 683494770 
token = st.nextToken();
//#endif 


//#if 1948400141 
if(" ".equals(token) || "\t".equals(token)
                        || ",".equals(token))//1
{ 

//#if 1587976208 
if(hasEq)//1
{ 

//#if 1006355351 
value.append(token);
//#endif 

} 

//#endif 

} 
else

//#if -1980210903 
if("<<".equals(token) || "\u00AB".equals(token))//1
{ 

//#if -1776416501 
if(hasEq)//1
{ 

//#if 1637696868 
value.append(token);
//#endif 

} 
else
{ 

//#if -383770012 
if(stereotype != null)//1
{ 

//#if 645703638 
String msg =
                                "parsing.error.attribute.two-sets-stereotypes";
//#endif 


//#if -1557823344 
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -502021335 
stereotype = new StringBuilder();
//#endif 


//#if -1552795151 
while (true) //1
{ 

//#if -1190869185 
token = st.nextToken();
//#endif 


//#if 684073202 
if(">>".equals(token) || "\u00BB".equals(token))//1
{ 

//#if 440180837 
break;

//#endif 

} 

//#endif 


//#if 531324411 
stereotype.append(token);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if 562057673 
if("[".equals(token))//1
{ 

//#if -716748860 
if(hasEq)//1
{ 

//#if 1724513759 
value.append(token);
//#endif 

} 
else
{ 

//#if -1513040436 
if(multiplicity != null)//1
{ 

//#if -1571875504 
String msg =
                                "parsing.error.attribute.two-multiplicities";
//#endif 


//#if 864643246 
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 1752276091 
multiplicity = new StringBuilder();
//#endif 


//#if 1829331022 
multindex = st.getTokenIndex() + 1;
//#endif 


//#if -324961866 
while (true) //1
{ 

//#if -575146206 
token = st.nextToken();
//#endif 


//#if 890753290 
if("]".equals(token))//1
{ 

//#if 52092184 
break;

//#endif 

} 

//#endif 


//#if -1459390159 
multiplicity.append(token);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if 188383618 
if("{".equals(token))//1
{ 

//#if 480342304 
StringBuilder propname = new StringBuilder();
//#endif 


//#if -1000493975 
String propvalue = null;
//#endif 


//#if 338678882 
if(properties == null)//1
{ 

//#if -328211300 
properties = new ArrayList<String>();
//#endif 

} 

//#endif 


//#if -1034382344 
while (true) //1
{ 

//#if 1369831098 
token = st.nextToken();
//#endif 


//#if -690152321 
if(",".equals(token) || "}".equals(token))//1
{ 

//#if 154046851 
if(propname.length() > 0)//1
{ 

//#if 134693186 
properties.add(propname.toString());
//#endif 


//#if 1171964611 
properties.add(propvalue);
//#endif 

} 

//#endif 


//#if 1789111054 
propname = new StringBuilder();
//#endif 


//#if 1040952152 
propvalue = null;
//#endif 


//#if -1279854660 
if("}".equals(token))//1
{ 

//#if 16244357 
break;

//#endif 

} 

//#endif 

} 
else

//#if 742004211 
if("=".equals(token))//1
{ 

//#if 1197802437 
if(propvalue != null)//1
{ 

//#if 757967057 
String msg =
                                    "parsing.error.attribute.prop-two-values";
//#endif 


//#if 111127034 
Object[] args = {propvalue};
//#endif 


//#if -1714140953 
throw new ParseException(Translator.localize(
                                                             msg, args), st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 1851001749 
propvalue = "";
//#endif 

} 
else

//#if -998642395 
if(propvalue == null)//1
{ 

//#if -1256904076 
propname.append(token);
//#endif 

} 
else
{ 

//#if -1274314969 
propvalue += token;
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 148524833 
if(propname.length() > 0)//1
{ 

//#if -743252570 
properties.add(propname.toString());
//#endif 


//#if 438815783 
properties.add(propvalue);
//#endif 

} 

//#endif 

} 
else

//#if 371488210 
if(":".equals(token))//1
{ 

//#if -1144875150 
hasColon = true;
//#endif 


//#if 1370093964 
hasEq = false;
//#endif 

} 
else

//#if 1546050745 
if("=".equals(token))//1
{ 

//#if 1747043750 
if(value != null)//1
{ 

//#if 978875176 
String msg =
                            "parsing.error.attribute.two-default-values";
//#endif 


//#if 1260837319 
throw new ParseException(Translator.localize(msg), st
                                                 .getTokenIndex());
//#endif 

} 

//#endif 


//#if -1262959409 
value = new StringBuilder();
//#endif 


//#if -927297061 
hasColon = false;
//#endif 


//#if 2104975521 
hasEq = true;
//#endif 

} 
else
{ 

//#if 1920845118 
if(hasColon)//1
{ 

//#if -1556562238 
if(type != null)//1
{ 

//#if -2011600022 
String msg = "parsing.error.attribute.two-types";
//#endif 


//#if -1327407328 
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -1747547111 
if(token.length() > 0
                                && (token.charAt(0) == '\"'
                                    || token.charAt(0) == '\''))//1
{ 

//#if -429619509 
String msg = "parsing.error.attribute.quoted";
//#endif 


//#if -2022925123 
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -249420938 
if(token.length() > 0 && token.charAt(0) == '(')//1
{ 

//#if 1046885811 
String msg = "parsing.error.attribute.is-expr";
//#endif 


//#if 920545577 
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 565983671 
type = token;
//#endif 

} 
else

//#if -1980040632 
if(hasEq)//1
{ 

//#if -85831210 
value.append(token);
//#endif 

} 
else
{ 

//#if 559857267 
if(name != null && visibility != null)//1
{ 

//#if -1016600761 
String msg = "parsing.error.attribute.extra-text";
//#endif 


//#if -972020125 
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -717842076 
if(token.length() > 0
                                && (token.charAt(0) == '\"'
                                    || token.charAt(0) == '\''))//1
{ 

//#if 1715392400 
String msg = "parsing.error.attribute.name-quoted";
//#endif 


//#if -1274249516 
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 1850128513 
if(token.length() > 0 && token.charAt(0) == '(')//1
{ 

//#if -1759750978 
String msg = "parsing.error.attribute.name-expr";
//#endif 


//#if -986454987 
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -211558705 
if(name == null
                                && visibility == null
                                && token.length() > 1
                                && NotationUtilityUml.VISIBILITYCHARS
                                .indexOf(token.charAt(0)) >= 0)//1
{ 

//#if 2133821003 
visibility = token.substring(0, 1);
//#endif 


//#if 1319651416 
token = token.substring(1);
//#endif 

} 

//#endif 


//#if 1623096414 
if(name != null)//1
{ 

//#if -678836433 
visibility = name;
//#endif 


//#if -1357938678 
name = token;
//#endif 

} 
else
{ 

//#if -1321541558 
name = token;
//#endif 

} 

//#endif 

} 

//#endif 


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

//#if 111848400 
catch (NoSuchElementException nsee) //1
{ 

//#if -1521705381 
String msg = "parsing.error.attribute.unexpected-end-attribute";
//#endif 


//#if 263455932 
throw new ParseException(Translator.localize(msg), text.length());
//#endif 

} 

//#endif 


//#endif 


//#if 841286751 
if(LOG.isDebugEnabled())//1
{ 

//#if 256837926 
LOG.debug("ParseAttribute [name: " + name
                      + " visibility: " + visibility
                      + " type: " + type + " value: " + value
                      + " stereo: " + stereotype
                      + " mult: " + multiplicity);
//#endif 


//#if -871690626 
if(properties != null)//1
{ 

//#if -420078099 
for (int i = 0; i + 1 < properties.size(); i += 2) //1
{ 

//#if 1540491532 
LOG.debug("\tProperty [name: " + properties.get(i) + " = "
                              + properties.get(i + 1) + "]");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1833977121 
dealWithVisibility(attribute, visibility);
//#endif 


//#if -650335487 
dealWithName(attribute, name);
//#endif 


//#if 1351503649 
dealWithType(attribute, type);
//#endif 


//#if 2005562771 
dealWithValue(attribute, value);
//#endif 


//#if -1560618953 
dealWithMultiplicity(attribute, multiplicity, multindex);
//#endif 


//#if 2012376001 
dealWithProperties(attribute, properties);
//#endif 


//#if 563004038 
StereotypeUtility.dealWithStereotypes(attribute, stereotype, true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

