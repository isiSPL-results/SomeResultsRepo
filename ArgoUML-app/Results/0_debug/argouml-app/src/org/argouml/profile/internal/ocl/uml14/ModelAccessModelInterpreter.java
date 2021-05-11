
//#if 302371557 
// Compilation Unit of /ModelAccessModelInterpreter.java 
 

//#if -1262311614 
package org.argouml.profile.internal.ocl.uml14;
//#endif 


//#if 173789832 
import java.util.ArrayList;
//#endif 


//#if -315178677 
import java.util.HashSet;
//#endif 


//#if 980360035 
import java.util.Map;
//#endif 


//#if -624019080 
import org.argouml.model.Model;
//#endif 


//#if 252771716 
import org.argouml.profile.internal.ocl.DefaultOclEvaluator;
//#endif 


//#if 2118399342 
import org.argouml.profile.internal.ocl.InvalidOclException;
//#endif 


//#if 1228957001 
import org.argouml.profile.internal.ocl.ModelInterpreter;
//#endif 


//#if 1823411717 
import org.apache.log4j.Logger;
//#endif 


//#if -536016882 
public class ModelAccessModelInterpreter implements 
//#if 383091769 
ModelInterpreter
//#endif 

  { 

//#if -922271735 
private static Uml14ModelInterpreter uml14mi = new Uml14ModelInterpreter();
//#endif 


//#if -325115952 
private static final Logger LOG = Logger
                                      .getLogger(ModelAccessModelInterpreter.class);
//#endif 


//#if -445989133 

//#if 142750382 
@SuppressWarnings("unchecked")
//#endif 


    public Object invokeFeature(Map<String, Object> vt, Object subject,
                                String feature, String type, Object[] parameters)
    { 

//#if -1385888370 
if(subject == null)//1
{ 

//#if 1643085279 
subject = vt.get("self");
//#endif 

} 

//#endif 


//#if 2044422196 
if(Model.getFacade().isAAssociation(subject))//1
{ 

//#if 1823403709 
if(type.equals("."))//1
{ 

//#if 428313596 
if(feature.equals("connection"))//1
{ 

//#if -678620532 
return new ArrayList<Object>(Model.getFacade()
                                                 .getConnections(subject));
//#endif 

} 

//#endif 


//#if 1845842450 
if(feature.equals("allConnections"))//1
{ 

//#if 532688218 
return new HashSet<Object>(Model.getFacade()
                                               .getConnections(subject));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 90275051 
if(Model.getFacade().isAAssociationEnd(subject))//1
{ 

//#if 2065839004 
if(type.equals("."))//1
{ 

//#if -2132184054 
if(feature.equals("aggregation"))//1
{ 

//#if -1078743178 
return Model.getFacade().getAggregation(subject);
//#endif 

} 

//#endif 


//#if 1192584290 
if(feature.equals("changeability"))//1
{ 

//#if -1545128190 
return Model.getFacade().getChangeability(subject);
//#endif 

} 

//#endif 


//#if 116015978 
if(feature.equals("ordering"))//1
{ 

//#if -948614780 
return Model.getFacade().getOrdering(subject);
//#endif 

} 

//#endif 


//#if -213129671 
if(feature.equals("isNavigable"))//1
{ 

//#if 1907821444 
return Model.getFacade().isNavigable(subject);
//#endif 

} 

//#endif 


//#if 1528040277 
if(feature.equals("multiplicity"))//1
{ 

//#if -839269142 
return Model.getFacade().getMultiplicity(subject);
//#endif 

} 

//#endif 


//#if 1745252267 
if(feature.equals("targetScope"))//1
{ 

//#if -398626496 
return Model.getFacade().getTargetScope(subject);
//#endif 

} 

//#endif 


//#if 1952293992 
if(feature.equals("visibility"))//1
{ 

//#if -1029390995 
return Model.getFacade().getVisibility(subject);
//#endif 

} 

//#endif 


//#if 1207929362 
if(feature.equals("qualifier"))//1
{ 

//#if -2107242018 
return Model.getFacade().getQualifiers(subject);
//#endif 

} 

//#endif 


//#if -1763213525 
if(feature.equals("specification"))//1
{ 

//#if 2032034669 
return Model.getFacade().getSpecification(subject);
//#endif 

} 

//#endif 


//#if 910261147 
if(feature.equals("participant"))//1
{ 

//#if 1967123325 
return Model.getFacade().getClassifier(subject);
//#endif 

} 

//#endif 


//#if 451364850 
if(feature.equals("upperbound"))//1
{ 

//#if 618244156 
return Model.getFacade().getUpper(subject);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -130459655 
if(Model.getFacade().isAAttribute(subject))//1
{ 

//#if 433267354 
if(type.equals("."))//1
{ 

//#if 989326450 
if(feature.equals("initialValue"))//1
{ 

//#if -2101083475 
return Model.getFacade().getInitialValue(subject);
//#endif 

} 

//#endif 


//#if -1008495297 
if(feature.equals("associationEnd"))//1
{ 

//#if -1094790847 
return new ArrayList<Object>(Model.getFacade()
                                                 .getAssociationEnds(subject));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -182302852 
if(Model.getFacade().isABehavioralFeature(subject))//1
{ 

//#if 1651262959 
if(type.equals("."))//1
{ 

//#if -1585234885 
if(feature.equals("isQuery"))//1
{ 

//#if -701490381 
return Model.getFacade().isQuery(subject);
//#endif 

} 

//#endif 


//#if -1720657306 
if(feature.equals("parameter"))//1
{ 

//#if -465273351 
return new ArrayList<Object>(Model.getFacade()
                                                 .getParameters(subject));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -403836752 
if(Model.getFacade().isABinding(subject))//1
{ 

//#if -1697864448 
if(type.equals("."))//1
{ 

//#if -1566030572 
if(feature.equals("argument"))//1
{ 

//#if -77536633 
return Model.getFacade().getArguments(subject);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -232238435 
if(Model.getFacade().isAClass(subject))//1
{ 

//#if 219265877 
if(type.equals("."))//1
{ 

//#if 1215211134 
if(feature.equals("isActive"))//1
{ 

//#if -158782877 
return Model.getFacade().isActive(subject);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -609862972 
if(Model.getFacade().isAClassifier(subject))//1
{ 

//#if 1318378394 
if(type.equals("."))//1
{ 

//#if -16677472 
if(feature.equals("feature"))//1
{ 

//#if -1206275599 
return new ArrayList<Object>(Model.getFacade()
                                                 .getFeatures(subject));
//#endif 

} 

//#endif 


//#if 1377714449 
if(feature.equals("feature"))//2
{ 

//#if -871360048 
return new ArrayList<Object>(Model.getFacade()
                                                 .getFeatures(subject));
//#endif 

} 

//#endif 


//#if -460362389 
if(feature.equals("association"))//1
{ 

//#if -1818505968 
return new ArrayList<Object>(Model.getFacade()
                                                 .getAssociatedClasses(subject));
//#endif 

} 

//#endif 


//#if -1260584622 
if(feature.equals("powertypeRange"))//1
{ 

//#if 1309664907 
return new HashSet<Object>(Model.getFacade()
                                               .getPowertypeRanges(subject));
//#endif 

} 

//#endif 


//#if 1377744241 
if(feature.equals("feature"))//3
{ 

//#if 1903782173 
return new ArrayList<Object>(Model.getFacade()
                                                 .getFeatures(subject));
//#endif 

} 

//#endif 


//#if -387706840 
if(feature.equals("allFeatures"))//1
{ 

//#if 1942231196 
return internalOcl(subject, vt, "self.feature->union("
                                       + "self.parent.oclAsType(Classifier).allFeatures)");
//#endif 

} 

//#endif 


//#if -633741929 
if(feature.equals("allOperations"))//1
{ 

//#if 1296025962 
return internalOcl(subject, vt, "self.allFeatures->"
                                       + "select(f | f.oclIsKindOf(Operation))");
//#endif 

} 

//#endif 


//#if 115480997 
if(feature.equals("allMethods"))//1
{ 

//#if -2122616522 
return internalOcl(subject, vt, "self.allFeatures->"
                                       + "select(f | f.oclIsKindOf(Method))");
//#endif 

} 

//#endif 


//#if -1627278654 
if(feature.equals("allAttributes"))//1
{ 

//#if 637733361 
return internalOcl(subject, vt, "self.allFeatures->"
                                       + "select(f | f.oclIsKindOf(Attribute))");
//#endif 

} 

//#endif 


//#if 1581406438 
if(feature.equals("associations"))//1
{ 

//#if 1346436584 
return internalOcl(subject, vt,
                                       "self.association.association->asSet()");
//#endif 

} 

//#endif 


//#if -616243651 
if(feature.equals("allAssociations"))//1
{ 

//#if 2066685110 
return internalOcl(
                               subject,
                               vt,
                               "self.associations->union("
                               + "self.parent.oclAsType(Classifier).allAssociations)");
//#endif 

} 

//#endif 


//#if 683477212 
if(feature.equals("oppositeAssociationEnds"))//1
{ 

//#if 187510466 
return internalOcl(
                               subject,
                               vt,
                               "self.associations->select ( a | a.connection->select ( ae |"
                               + "ae.participant = self ).size = 1 )->collect ( a |"
                               + "a.connection->"
                               + "select ( ae | ae.participant <> self ) )->union ("
                               + "self.associations->select ( a | a.connection->select ( ae |"
                               + "ae.participant = self ).size > 1 )->collect ( a |"
                               + "a.connection) )");
//#endif 

} 

//#endif 


//#if -1094412507 
if(feature.equals("allOppositeAssociationEnds"))//1
{ 

//#if -1841640165 
return internalOcl(
                               subject,
                               vt,
                               "self.oppositeAssociationEnds->"
                               + "union(self.parent.allOppositeAssociationEnds )");
//#endif 

} 

//#endif 


//#if 1054375341 
if(feature.equals("specification"))//1
{ 

//#if -1315120950 
return internalOcl(
                               subject,
                               vt,
                               "self.clientDependency->"
                               + "select(d |"
                               + "d.oclIsKindOf(Abstraction)"
                               + "and d.stereotype.name = \"realization\" "
                               + "and d.supplier.oclIsKindOf(Classifier))"
                               + ".supplier.oclAsType(Classifier)");
//#endif 

} 

//#endif 


//#if 2029464901 
if(feature.equals("allContents"))//1
{ 

//#if -674741983 
return internalOcl(
                               subject,
                               vt,
                               "self.contents->union("
                               + "self.parent.allContents->select(e |"
                               + "e.elementOwnership.visibility = #public or true or "
                               + " e.elementOwnership.visibility = #protected))");
//#endif 

} 

//#endif 


//#if -1319302974 
if(feature.equals("allDiscriminators"))//1
{ 

//#if -1400886510 
return internalOcl(
                               subject,
                               vt,
                               "self.generalization.discriminator->"
                               + "union(self.parent.oclAsType(Classifier).allDiscriminators)");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1527725290 
if(Model.getFacade().isAComment(subject))//1
{ 

//#if -757679495 
if(type.equals("."))//1
{ 

//#if 736577046 
if(feature.equals("body"))//1
{ 

//#if -785404167 
return Model.getFacade().getBody(subject);
//#endif 

} 

//#endif 


//#if -1360355656 
if(feature.equals("annotatedElement"))//1
{ 

//#if 389079604 
return new HashSet<Object>(Model.getFacade()
                                               .getAnnotatedElements(subject));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1084525368 
if(Model.getFacade().isAComponent(subject))//1
{ 

//#if 75301931 
if(type.equals("."))//1
{ 

//#if 731190346 
if(feature.equals("deploymentLocation"))//1
{ 

//#if 1650818171 
return new HashSet<Object>(Model.getFacade()
                                               .getDeploymentLocations(subject));
//#endif 

} 

//#endif 


//#if -1523036992 
if(feature.equals("resident"))//1
{ 

//#if 660020272 
return new HashSet<Object>(Model.getFacade()
                                               .getResidents(subject));
//#endif 

} 

//#endif 


//#if -342918474 
if(feature.equals("allResidentElements"))//1
{ 

//#if 1893127328 
return internalOcl(
                               subject,
                               vt,
                               "self.resident->union("
                               + "self.parent.oclAsType(Component).allResidentElements->select( re |"
                               + "re.elementResidence.visibility = #public or "
                               + "re.elementResidence.visibility = #protected))");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 585642120 
if(Model.getFacade().isAConstraint(subject))//1
{ 

//#if -10723122 
if(type.equals("."))//1
{ 

//#if -1877202177 
if(feature.equals("body"))//1
{ 

//#if 644522704 
return Model.getFacade().getBody(subject);
//#endif 

} 

//#endif 


//#if 1574624163 
if(feature.equals("constrainedElement"))//1
{ 

//#if 612804298 
return Model.getFacade().getConstrainedElements(subject);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1067988442 
if(Model.getFacade().isADependency(subject))//1
{ 

//#if -622795715 
if(type.equals("."))//1
{ 

//#if 912658575 
if(feature.equals("client"))//1
{ 

//#if -788416702 
return new HashSet<Object>(Model.getFacade()
                                               .getClients(subject));
//#endif 

} 

//#endif 


//#if 1125382288 
if(feature.equals("supplier"))//1
{ 

//#if -1860770094 
return new HashSet<Object>(Model.getFacade()
                                               .getSuppliers(subject));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 19556891 
if(Model.getFacade().isAElementResidence(subject))//1
{ 

//#if -2036373734 
if(type.equals("."))//1
{ 

//#if 937690583 
if(feature.equals("visibility"))//1
{ 

//#if 1727982203 
return Model.getFacade().getVisibility(subject);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -184267730 
if(Model.getFacade().isAEnumeration(subject))//1
{ 

//#if -2129080491 
if(type.equals("."))//1
{ 

//#if 1036992552 
if(feature.equals("literal"))//1
{ 

//#if 192460151 
return Model.getFacade().getEnumerationLiterals(subject);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1148909603 
if(Model.getFacade().isAEnumerationLiteral(subject))//1
{ 

//#if -30053648 
if(type.equals("."))//1
{ 

//#if 1888141201 
if(feature.equals("enumeration"))//1
{ 

//#if 529243114 
return Model.getFacade().getEnumeration(subject);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1786141729 
if(Model.getFacade().isAFeature(subject))//1
{ 

//#if 1002812810 
if(type.equals("."))//1
{ 

//#if -784287436 
if(feature.equals("ownerScope"))//1
{ 

//#if 538261162 
return Model.getFacade().isStatic(subject);
//#endif 

} 

//#endif 


//#if 1688715301 
if(feature.equals("visibility"))//1
{ 

//#if -1346571788 
return Model.getFacade().getVisibility(subject);
//#endif 

} 

//#endif 


//#if 587077630 
if(feature.equals("owner"))//1
{ 

//#if -653017171 
return Model.getFacade().getOwner(subject);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 423898460 
if(Model.getFacade().isAGeneralizableElement(subject))//1
{ 

//#if 1210724173 
if(type.equals("."))//1
{ 

//#if -56901728 
if(feature.equals("isAbstract"))//1
{ 

//#if 201790332 
return Model.getFacade().isAbstract(subject);
//#endif 

} 

//#endif 


//#if -537673380 
if(feature.equals("isLeaf"))//1
{ 

//#if 112896857 
return Model.getFacade().isLeaf(subject);
//#endif 

} 

//#endif 


//#if -146772000 
if(feature.equals("isRoot"))//1
{ 

//#if -405685467 
return Model.getFacade().isRoot(subject);
//#endif 

} 

//#endif 


//#if 450365488 
if(feature.equals("generalization"))//1
{ 

//#if 313224966 
return new HashSet<Object>(Model.getFacade()
                                               .getGeneralizations(subject));
//#endif 

} 

//#endif 


//#if 1412090879 
if(feature.equals("specialization"))//1
{ 

//#if 490713956 
return new HashSet<Object>(Model.getFacade()
                                               .getSpecializations(subject));
//#endif 

} 

//#endif 


//#if 195560670 
if(feature.equals("parent"))//1
{ 

//#if -1363547856 
return internalOcl(subject, vt,
                                       "self.generalization.parent");
//#endif 

} 

//#endif 


//#if -1029902500 
if(feature.equals("allParents"))//1
{ 

//#if -1683318103 
return internalOcl(subject, vt,
                                       "self.parent->union(self.parent.allParents)");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1125551689 
if(Model.getFacade().isAGeneralization(subject))//1
{ 

//#if -2116262810 
if(type.equals("."))//1
{ 

//#if -267528700 
if(feature.equals("discriminator"))//1
{ 

//#if 797057535 
return Model.getFacade().getDiscriminator(subject);
//#endif 

} 

//#endif 


//#if -1101148796 
if(feature.equals("child"))//1
{ 

//#if 535932521 
return Model.getFacade().getSpecific(subject);
//#endif 

} 

//#endif 


//#if -596874368 
if(feature.equals("parent"))//1
{ 

//#if 1625682775 
return Model.getFacade().getGeneral(subject);
//#endif 

} 

//#endif 


//#if -983995545 
if(feature.equals("powertype"))//1
{ 

//#if 1953434455 
return Model.getFacade().getPowertype(subject);
//#endif 

} 

//#endif 


//#if 947351713 
if(feature.equals("specialization"))//1
{ 

//#if -337304958 
return new HashSet<Object>(Model.getFacade()
                                               .getSpecializations(subject));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -65009660 
if(Model.getFacade().isAMethod(subject))//1
{ 

//#if 1203262284 
if(type.equals("."))//1
{ 

//#if -1137920116 
if(feature.equals("body"))//1
{ 

//#if 980339742 
return Model.getFacade().getBody(subject);
//#endif 

} 

//#endif 


//#if 1825031767 
if(feature.equals("specification"))//1
{ 

//#if -1633883053 
return Model.getFacade().getSpecification(subject);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1200467090 
if(Model.getFacade().isAModelElement(subject))//1
{ 

//#if -1830520148 
if(type.equals("."))//1
{ 

//#if -472340965 
if(feature.equals("name"))//1
{ 

//#if 161357692 
String name = Model.getFacade().getName(subject);
//#endif 


//#if 205775741 
if(name == null)//1
{ 

//#if -1946985808 
name = "";
//#endif 

} 

//#endif 


//#if -886330888 
return name;
//#endif 

} 

//#endif 


//#if -1591380154 
if(feature.equals("clientDependency"))//1
{ 

//#if -1536633820 
return new HashSet<Object>(Model.getFacade()
                                               .getClientDependencies(subject));
//#endif 

} 

//#endif 


//#if 1057298221 
if(feature.equals("constraint"))//1
{ 

//#if -1144465418 
return new HashSet<Object>(Model.getFacade()
                                               .getConstraints(subject));
//#endif 

} 

//#endif 


//#if -1401998711 
if(feature.equals("namespace"))//1
{ 

//#if 933515084 
return Model.getFacade().getNamespace(subject);
//#endif 

} 

//#endif 


//#if 310599431 
if(feature.equals("supplierDependency"))//1
{ 

//#if 551658133 
return new HashSet<Object>(Model.getFacade()
                                               .getSupplierDependencies(subject));
//#endif 

} 

//#endif 


//#if -20269187 
if(feature.equals("templateParameter"))//1
{ 

//#if -1880664346 
return Model.getFacade().getTemplateParameters(subject);
//#endif 

} 

//#endif 


//#if 604330178 
if(feature.equals("stereotype"))//1
{ 

//#if -1715378279 
return Model.getFacade().getStereotypes(subject);
//#endif 

} 

//#endif 


//#if 967284051 
if(feature.equals("taggedValue"))//1
{ 

//#if -117216364 
return Model.getFacade().getTaggedValuesCollection(subject);
//#endif 

} 

//#endif 


//#if -1318770588 
if(feature.equals("constraint"))//2
{ 

//#if -1157263815 
return Model.getFacade().getConstraints(subject);
//#endif 

} 

//#endif 


//#if -1377941476 
if(feature.equals("supplier"))//1
{ 

//#if -797543253 
return internalOcl(subject, vt,
                                       "self.clientDependency.supplier");
//#endif 

} 

//#endif 


//#if -1903665706 
if(feature.equals("allSuppliers"))//1
{ 

//#if 350777552 
return internalOcl(subject, vt,
                                       "self.supplier->union(self.supplier.allSuppliers)");
//#endif 

} 

//#endif 


//#if 1720462679 
if(feature.equals("model"))//1
{ 

//#if -1194949504 
return internalOcl(subject, vt,
                                       "self.namespace->"
                                       + "union(self.namespace.allSurroundingNamespaces)->"
                                       + "select( ns| ns.oclIsKindOf (Model))");
//#endif 

} 

//#endif 


//#if -950653996 
if(feature.equals("isTemplate"))//1
{ 

//#if 1922574940 
return !Model.getFacade().getTemplateParameters(subject)
                           .isEmpty();
//#endif 

} 

//#endif 


//#if 708267156 
if(feature.equals("isInstantiated"))//1
{ 

//#if -1425331615 
return internalOcl(subject, vt, "self.clientDependency->"
                                       + "select(oclIsKindOf(Binding))->notEmpty");
//#endif 

} 

//#endif 


//#if -1633608089 
if(feature.equals("templateArgument"))//1
{ 

//#if -148966716 
return internalOcl(subject, vt, "self.clientDependency->"
                                       + "select(oclIsKindOf(Binding))."
                                       + "oclAsType(Binding).argument");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1768203366 
if(Model.getFacade().isANamespace(subject))//1
{ 

//#if 1049977480 
if(type.equals("."))//1
{ 

//#if -1267192489 
if(feature.equals("ownedElement"))//1
{ 

//#if 298354085 
return new HashSet<Object>(Model.getFacade()
                                               .getOwnedElements(subject));
//#endif 

} 

//#endif 


//#if -718509542 
if(feature.equals("contents"))//1
{ 

//#if 1883826741 
return internalOcl(subject, vt, "self.ownedElement->"
                                       + "union(self.ownedElement->"
                                       + "select(x|x.oclIsKindOf(Namespace)).contents)");
//#endif 

} 

//#endif 


//#if -1564133351 
if(feature.equals("allContents"))//1
{ 

//#if 1880549075 
return internalOcl(subject, vt, "self.contents");
//#endif 

} 

//#endif 


//#if 293424872 
if(feature.equals("allVisibleElements"))//1
{ 

//#if -328610262 
return internalOcl(
                               subject,
                               vt,
                               "self.allContents ->"
                               + "select(e |e.elementOwnership.visibility = #public)");
//#endif 

} 

//#endif 


//#if -1221061477 
if(feature.equals("allSurroundingNamespaces"))//1
{ 

//#if 1444728880 
return internalOcl(subject, vt, "self.namespace->"
                                       + "union(self.namespace.allSurroundingNamespaces)");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2116923773 
if(Model.getFacade().isANode(subject))//1
{ 

//#if -1746140227 
if(type.equals("."))//1
{ 

//#if -1084829664 
if(feature.equals("deployedComponent"))//1
{ 

//#if 404313284 
return new HashSet<Object>(Model.getFacade()
                                               .getDeployedComponents(subject));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1296478450 
if(Model.getFacade().isAOperation(subject))//1
{ 

//#if -1973451408 
if(type.equals("."))//1
{ 

//#if -993469833 
if(feature.equals("concurrency"))//1
{ 

//#if 887649673 
return Model.getFacade().getConcurrency(subject);
//#endif 

} 

//#endif 


//#if -1318607034 
if(feature.equals("isAbstract"))//1
{ 

//#if 2083597714 
return Model.getFacade().isAbstract(subject);
//#endif 

} 

//#endif 


//#if 1048669186 
if(feature.equals("isLeaf"))//1
{ 

//#if -685575129 
return Model.getFacade().isLeaf(subject);
//#endif 

} 

//#endif 


//#if 1439570566 
if(feature.equals("isRoot"))//1
{ 

//#if -567758696 
return Model.getFacade().isRoot(subject);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -902026228 
if(Model.getFacade().isAParameter(subject))//1
{ 

//#if -1907261242 
if(type.equals("."))//1
{ 

//#if -315112185 
if(feature.equals("defaultValue"))//1
{ 

//#if 2144635346 
return Model.getFacade().getDefaultValue(subject);
//#endif 

} 

//#endif 


//#if -185564693 
if(feature.equals("kind"))//1
{ 

//#if 1402669832 
return Model.getFacade().getKind(subject);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1044175268 
if(Model.getFacade().isAStructuralFeature(subject))//1
{ 

//#if 519622263 
if(type.equals("."))//1
{ 

//#if 570186880 
if(feature.equals("changeability"))//1
{ 

//#if 1554379907 
return Model.getFacade().getChangeability(subject);
//#endif 

} 

//#endif 


//#if -847341705 
if(feature.equals("multiplicity"))//1
{ 

//#if 199120525 
return Model.getFacade().getMultiplicity(subject);
//#endif 

} 

//#endif 


//#if 942944396 
if(feature.equals("ordering"))//1
{ 

//#if -1789207004 
return Model.getFacade().getOrdering(subject);
//#endif 

} 

//#endif 


//#if 837343049 
if(feature.equals("targetScope"))//1
{ 

//#if 734043663 
return Model.getFacade().getTargetScope(subject);
//#endif 

} 

//#endif 


//#if 247435762 
if(feature.equals("type"))//1
{ 

//#if 140944688 
return Model.getFacade().getType(subject);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -382585522 
if(Model.getFacade().isATemplateArgument(subject))//1
{ 

//#if -166019419 
if(type.equals("."))//1
{ 

//#if -139899837 
if(feature.equals("binding"))//1
{ 

//#if -2025913097 
return Model.getFacade().getBinding(subject);
//#endif 

} 

//#endif 


//#if 1555326419 
if(feature.equals("modelElement"))//1
{ 

//#if 83756853 
return Model.getFacade().getModelElement(subject);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1480473306 
if(Model.getFacade().isATemplateParameter(subject))//1
{ 

//#if -203880950 
if(type.equals("."))//1
{ 

//#if -1706343174 
if(feature.equals("defaultElement"))//1
{ 

//#if -1554243314 
return Model.getFacade().getDefaultElement(subject);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 2028362030 
if(Model.getFacade().isAAssociationClass(subject))//1
{ 

//#if -362388066 
if(type.equals("."))//1
{ 

//#if 1422981616 
if(feature.equals("allConnections"))//1
{ 

//#if -1202669464 
return internalOcl(
                               subject,
                               vt,
                               "self.connection->union(self.parent->select("
                               + "s | s.oclIsKindOf(Association))->collect("
                               + "a : Association | a.allConnections))->asSet()");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1079766355 
if(Model.getFacade().isAStereotype(subject))//1
{ 

//#if 1417340808 
if(type.equals("."))//1
{ 

//#if -679467412 
if(feature.equals("baseClass"))//1
{ 

//#if 1908967162 
return new HashSet<Object>(Model.getFacade()
                                               .getBaseClasses(subject));
//#endif 

} 

//#endif 


//#if 909364040 
if(feature.equals("extendedElement"))//1
{ 

//#if 1107962333 
return new HashSet<Object>(Model.getFacade()
                                               .getExtendedElements(subject));
//#endif 

} 

//#endif 


//#if -1907631894 
if(feature.equals("definedTag"))//1
{ 

//#if 1094315249 
return new HashSet<Object>(Model.getFacade()
                                               .getTagDefinitions(subject));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1004903000 
if(Model.getFacade().isATagDefinition(subject))//1
{ 

//#if 325678304 
if(type.equals("."))//1
{ 

//#if -345557557 
if(feature.equals("multiplicity"))//1
{ 

//#if 913074787 
return Model.getFacade().getMultiplicity(subject);
//#endif 

} 

//#endif 


//#if 354801126 
if(feature.equals("tagType"))//1
{ 

//#if 88620922 
return Model.getFacade().getType(subject);
//#endif 

} 

//#endif 


//#if -1574541133 
if(feature.equals("typedValue"))//1
{ 

//#if -629851361 
return new HashSet<Object>(Model.getFacade()
                                               .getTypedValues(subject));
//#endif 

} 

//#endif 


//#if 77423653 
if(feature.equals("owner"))//1
{ 

//#if 846397989 
return Model.getFacade().getOwner(subject);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1854759888 
if(Model.getFacade().isATaggedValue(subject))//1
{ 

//#if -147200513 
if(type.equals("."))//1
{ 

//#if -1664118089 
if(feature.equals("dataValue"))//1
{ 

//#if -748271574 
return Model.getFacade().getDataValue(subject);
//#endif 

} 

//#endif 


//#if 229424040 
if(feature.equals("type"))//1
{ 

//#if 1055724512 
return Model.getFacade().getType(subject);
//#endif 

} 

//#endif 


//#if -741918316 
if(feature.equals("referenceValue"))//1
{ 

//#if 405996108 
return new HashSet<Object>(Model.getFacade()
                                               .getReferenceValue(subject));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1380568870 
return null;
//#endif 

} 

//#endif 


//#if -409323162 
public Object getBuiltInSymbol(String sym)
    { 

//#if 1413404503 
for (String name : Model.getFacade().getMetatypeNames()) //1
{ 

//#if 1571265538 
if(name.equals(sym))//1
{ 

//#if -127945267 
return new OclType(sym);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -495197378 
return null;
//#endif 

} 

//#endif 


//#if -504968378 
private Object internalOcl(Object subject, Map<String, Object> vt,
                               String ocl)
    { 

//#if -1509832818 
try //1
{ 

//#if -1570041646 
Object oldSelf = vt.get("self");
//#endif 


//#if -3380734 
vt.put("self", subject);
//#endif 


//#if 302644242 
Object ret = DefaultOclEvaluator.getInstance().evaluate(vt,
                         uml14mi, ocl);
//#endif 


//#if 1247870249 
vt.put("self", oldSelf);
//#endif 


//#if 861318487 
return ret;
//#endif 

} 

//#if 1864562350 
catch (InvalidOclException e) //1
{ 

//#if -202388685 
LOG.error("Exception", e);
//#endif 


//#if 120998689 
return null;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

