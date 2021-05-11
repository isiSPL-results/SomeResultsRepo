// Compilation Unit of /ModelAccessModelInterpreter.java 
 
package org.argouml.profile.internal.ocl.uml14;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import org.argouml.model.Model;
import org.argouml.profile.internal.ocl.DefaultOclEvaluator;
import org.argouml.profile.internal.ocl.InvalidOclException;
import org.argouml.profile.internal.ocl.ModelInterpreter;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public class ModelAccessModelInterpreter implements ModelInterpreter
  { 
private static Uml14ModelInterpreter uml14mi = new Uml14ModelInterpreter();

//#if LOGGING 
private static final Logger LOG = Logger
                                      .getLogger(ModelAccessModelInterpreter.class);
//#endif 

@SuppressWarnings("unchecked")

    public Object invokeFeature(Map<String, Object> vt, Object subject,
                                String feature, String type, Object[] parameters)
    { 
if(subject == null)//1
{ 
subject = vt.get("self");
} 

if(Model.getFacade().isAAssociation(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("connection"))//1
{ 
return new ArrayList<Object>(Model.getFacade()
                                                 .getConnections(subject));
} 

if(feature.equals("allConnections"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getConnections(subject));
} 

} 

} 

if(Model.getFacade().isAAssociationEnd(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("aggregation"))//1
{ 
return Model.getFacade().getAggregation(subject);
} 

if(feature.equals("changeability"))//1
{ 
return Model.getFacade().getChangeability(subject);
} 

if(feature.equals("ordering"))//1
{ 
return Model.getFacade().getOrdering(subject);
} 

if(feature.equals("isNavigable"))//1
{ 
return Model.getFacade().isNavigable(subject);
} 

if(feature.equals("multiplicity"))//1
{ 
return Model.getFacade().getMultiplicity(subject);
} 

if(feature.equals("targetScope"))//1
{ 
return Model.getFacade().getTargetScope(subject);
} 

if(feature.equals("visibility"))//1
{ 
return Model.getFacade().getVisibility(subject);
} 

if(feature.equals("qualifier"))//1
{ 
return Model.getFacade().getQualifiers(subject);
} 

if(feature.equals("specification"))//1
{ 
return Model.getFacade().getSpecification(subject);
} 

if(feature.equals("participant"))//1
{ 
return Model.getFacade().getClassifier(subject);
} 

if(feature.equals("upperbound"))//1
{ 
return Model.getFacade().getUpper(subject);
} 

} 

} 

if(Model.getFacade().isAAttribute(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("initialValue"))//1
{ 
return Model.getFacade().getInitialValue(subject);
} 

if(feature.equals("associationEnd"))//1
{ 
return new ArrayList<Object>(Model.getFacade()
                                                 .getAssociationEnds(subject));
} 

} 

} 

if(Model.getFacade().isABehavioralFeature(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("isQuery"))//1
{ 
return Model.getFacade().isQuery(subject);
} 

if(feature.equals("parameter"))//1
{ 
return new ArrayList<Object>(Model.getFacade()
                                                 .getParameters(subject));
} 

} 

} 

if(Model.getFacade().isABinding(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("argument"))//1
{ 
return Model.getFacade().getArguments(subject);
} 

} 

} 

if(Model.getFacade().isAClass(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("isActive"))//1
{ 
return Model.getFacade().isActive(subject);
} 

} 

} 

if(Model.getFacade().isAClassifier(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("feature"))//1
{ 
return new ArrayList<Object>(Model.getFacade()
                                                 .getFeatures(subject));
} 

if(feature.equals("feature"))//2
{ 
return new ArrayList<Object>(Model.getFacade()
                                                 .getFeatures(subject));
} 

if(feature.equals("association"))//1
{ 
return new ArrayList<Object>(Model.getFacade()
                                                 .getAssociatedClasses(subject));
} 

if(feature.equals("powertypeRange"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getPowertypeRanges(subject));
} 

if(feature.equals("feature"))//3
{ 
return new ArrayList<Object>(Model.getFacade()
                                                 .getFeatures(subject));
} 

if(feature.equals("allFeatures"))//1
{ 
return internalOcl(subject, vt, "self.feature->union("
                                       + "self.parent.oclAsType(Classifier).allFeatures)");
} 

if(feature.equals("allOperations"))//1
{ 
return internalOcl(subject, vt, "self.allFeatures->"
                                       + "select(f | f.oclIsKindOf(Operation))");
} 

if(feature.equals("allMethods"))//1
{ 
return internalOcl(subject, vt, "self.allFeatures->"
                                       + "select(f | f.oclIsKindOf(Method))");
} 

if(feature.equals("allAttributes"))//1
{ 
return internalOcl(subject, vt, "self.allFeatures->"
                                       + "select(f | f.oclIsKindOf(Attribute))");
} 

if(feature.equals("associations"))//1
{ 
return internalOcl(subject, vt,
                                       "self.association.association->asSet()");
} 

if(feature.equals("allAssociations"))//1
{ 
return internalOcl(
                               subject,
                               vt,
                               "self.associations->union("
                               + "self.parent.oclAsType(Classifier).allAssociations)");
} 

if(feature.equals("oppositeAssociationEnds"))//1
{ 
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
} 

if(feature.equals("allOppositeAssociationEnds"))//1
{ 
return internalOcl(
                               subject,
                               vt,
                               "self.oppositeAssociationEnds->"
                               + "union(self.parent.allOppositeAssociationEnds )");
} 

if(feature.equals("specification"))//1
{ 
return internalOcl(
                               subject,
                               vt,
                               "self.clientDependency->"
                               + "select(d |"
                               + "d.oclIsKindOf(Abstraction)"
                               + "and d.stereotype.name = \"realization\" "
                               + "and d.supplier.oclIsKindOf(Classifier))"
                               + ".supplier.oclAsType(Classifier)");
} 

if(feature.equals("allContents"))//1
{ 
return internalOcl(
                               subject,
                               vt,
                               "self.contents->union("
                               + "self.parent.allContents->select(e |"
                               + "e.elementOwnership.visibility = #public or true or "
                               + " e.elementOwnership.visibility = #protected))");
} 

if(feature.equals("allDiscriminators"))//1
{ 
return internalOcl(
                               subject,
                               vt,
                               "self.generalization.discriminator->"
                               + "union(self.parent.oclAsType(Classifier).allDiscriminators)");
} 

} 

} 

if(Model.getFacade().isAComment(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("body"))//1
{ 
return Model.getFacade().getBody(subject);
} 

if(feature.equals("annotatedElement"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getAnnotatedElements(subject));
} 

} 

} 

if(Model.getFacade().isAComponent(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("deploymentLocation"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getDeploymentLocations(subject));
} 

if(feature.equals("resident"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getResidents(subject));
} 

if(feature.equals("allResidentElements"))//1
{ 
return internalOcl(
                               subject,
                               vt,
                               "self.resident->union("
                               + "self.parent.oclAsType(Component).allResidentElements->select( re |"
                               + "re.elementResidence.visibility = #public or "
                               + "re.elementResidence.visibility = #protected))");
} 

} 

} 

if(Model.getFacade().isAConstraint(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("body"))//1
{ 
return Model.getFacade().getBody(subject);
} 

if(feature.equals("constrainedElement"))//1
{ 
return Model.getFacade().getConstrainedElements(subject);
} 

} 

} 

if(Model.getFacade().isADependency(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("client"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getClients(subject));
} 

if(feature.equals("supplier"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getSuppliers(subject));
} 

} 

} 

if(Model.getFacade().isAElementResidence(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("visibility"))//1
{ 
return Model.getFacade().getVisibility(subject);
} 

} 

} 

if(Model.getFacade().isAEnumeration(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("literal"))//1
{ 
return Model.getFacade().getEnumerationLiterals(subject);
} 

} 

} 

if(Model.getFacade().isAEnumerationLiteral(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("enumeration"))//1
{ 
return Model.getFacade().getEnumeration(subject);
} 

} 

} 

if(Model.getFacade().isAFeature(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("ownerScope"))//1
{ 
return Model.getFacade().isStatic(subject);
} 

if(feature.equals("visibility"))//1
{ 
return Model.getFacade().getVisibility(subject);
} 

if(feature.equals("owner"))//1
{ 
return Model.getFacade().getOwner(subject);
} 

} 

} 

if(Model.getFacade().isAGeneralizableElement(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("isAbstract"))//1
{ 
return Model.getFacade().isAbstract(subject);
} 

if(feature.equals("isLeaf"))//1
{ 
return Model.getFacade().isLeaf(subject);
} 

if(feature.equals("isRoot"))//1
{ 
return Model.getFacade().isRoot(subject);
} 

if(feature.equals("generalization"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getGeneralizations(subject));
} 

if(feature.equals("specialization"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getSpecializations(subject));
} 

if(feature.equals("parent"))//1
{ 
return internalOcl(subject, vt,
                                       "self.generalization.parent");
} 

if(feature.equals("allParents"))//1
{ 
return internalOcl(subject, vt,
                                       "self.parent->union(self.parent.allParents)");
} 

} 

} 

if(Model.getFacade().isAGeneralization(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("discriminator"))//1
{ 
return Model.getFacade().getDiscriminator(subject);
} 

if(feature.equals("child"))//1
{ 
return Model.getFacade().getSpecific(subject);
} 

if(feature.equals("parent"))//1
{ 
return Model.getFacade().getGeneral(subject);
} 

if(feature.equals("powertype"))//1
{ 
return Model.getFacade().getPowertype(subject);
} 

if(feature.equals("specialization"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getSpecializations(subject));
} 

} 

} 

if(Model.getFacade().isAMethod(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("body"))//1
{ 
return Model.getFacade().getBody(subject);
} 

if(feature.equals("specification"))//1
{ 
return Model.getFacade().getSpecification(subject);
} 

} 

} 

if(Model.getFacade().isAModelElement(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("name"))//1
{ 
String name = Model.getFacade().getName(subject);
if(name == null)//1
{ 
name = "";
} 

return name;
} 

if(feature.equals("clientDependency"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getClientDependencies(subject));
} 

if(feature.equals("constraint"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getConstraints(subject));
} 

if(feature.equals("namespace"))//1
{ 
return Model.getFacade().getNamespace(subject);
} 

if(feature.equals("supplierDependency"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getSupplierDependencies(subject));
} 

if(feature.equals("templateParameter"))//1
{ 
return Model.getFacade().getTemplateParameters(subject);
} 

if(feature.equals("stereotype"))//1
{ 
return Model.getFacade().getStereotypes(subject);
} 

if(feature.equals("taggedValue"))//1
{ 
return Model.getFacade().getTaggedValuesCollection(subject);
} 

if(feature.equals("constraint"))//2
{ 
return Model.getFacade().getConstraints(subject);
} 

if(feature.equals("supplier"))//1
{ 
return internalOcl(subject, vt,
                                       "self.clientDependency.supplier");
} 

if(feature.equals("allSuppliers"))//1
{ 
return internalOcl(subject, vt,
                                       "self.supplier->union(self.supplier.allSuppliers)");
} 

if(feature.equals("model"))//1
{ 
return internalOcl(subject, vt,
                                       "self.namespace->"
                                       + "union(self.namespace.allSurroundingNamespaces)->"
                                       + "select( ns| ns.oclIsKindOf (Model))");
} 

if(feature.equals("isTemplate"))//1
{ 
return !Model.getFacade().getTemplateParameters(subject)
                           .isEmpty();
} 

if(feature.equals("isInstantiated"))//1
{ 
return internalOcl(subject, vt, "self.clientDependency->"
                                       + "select(oclIsKindOf(Binding))->notEmpty");
} 

if(feature.equals("templateArgument"))//1
{ 
return internalOcl(subject, vt, "self.clientDependency->"
                                       + "select(oclIsKindOf(Binding))."
                                       + "oclAsType(Binding).argument");
} 

} 

} 

if(Model.getFacade().isANamespace(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("ownedElement"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getOwnedElements(subject));
} 

if(feature.equals("contents"))//1
{ 
return internalOcl(subject, vt, "self.ownedElement->"
                                       + "union(self.ownedElement->"
                                       + "select(x|x.oclIsKindOf(Namespace)).contents)");
} 

if(feature.equals("allContents"))//1
{ 
return internalOcl(subject, vt, "self.contents");
} 

if(feature.equals("allVisibleElements"))//1
{ 
return internalOcl(
                               subject,
                               vt,
                               "self.allContents ->"
                               + "select(e |e.elementOwnership.visibility = #public)");
} 

if(feature.equals("allSurroundingNamespaces"))//1
{ 
return internalOcl(subject, vt, "self.namespace->"
                                       + "union(self.namespace.allSurroundingNamespaces)");
} 

} 

} 

if(Model.getFacade().isANode(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("deployedComponent"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getDeployedComponents(subject));
} 

} 

} 

if(Model.getFacade().isAOperation(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("concurrency"))//1
{ 
return Model.getFacade().getConcurrency(subject);
} 

if(feature.equals("isAbstract"))//1
{ 
return Model.getFacade().isAbstract(subject);
} 

if(feature.equals("isLeaf"))//1
{ 
return Model.getFacade().isLeaf(subject);
} 

if(feature.equals("isRoot"))//1
{ 
return Model.getFacade().isRoot(subject);
} 

} 

} 

if(Model.getFacade().isAParameter(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("defaultValue"))//1
{ 
return Model.getFacade().getDefaultValue(subject);
} 

if(feature.equals("kind"))//1
{ 
return Model.getFacade().getKind(subject);
} 

} 

} 

if(Model.getFacade().isAStructuralFeature(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("changeability"))//1
{ 
return Model.getFacade().getChangeability(subject);
} 

if(feature.equals("multiplicity"))//1
{ 
return Model.getFacade().getMultiplicity(subject);
} 

if(feature.equals("ordering"))//1
{ 
return Model.getFacade().getOrdering(subject);
} 

if(feature.equals("targetScope"))//1
{ 
return Model.getFacade().getTargetScope(subject);
} 

if(feature.equals("type"))//1
{ 
return Model.getFacade().getType(subject);
} 

} 

} 

if(Model.getFacade().isATemplateArgument(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("binding"))//1
{ 
return Model.getFacade().getBinding(subject);
} 

if(feature.equals("modelElement"))//1
{ 
return Model.getFacade().getModelElement(subject);
} 

} 

} 

if(Model.getFacade().isATemplateParameter(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("defaultElement"))//1
{ 
return Model.getFacade().getDefaultElement(subject);
} 

} 

} 

if(Model.getFacade().isAAssociationClass(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("allConnections"))//1
{ 
return internalOcl(
                               subject,
                               vt,
                               "self.connection->union(self.parent->select("
                               + "s | s.oclIsKindOf(Association))->collect("
                               + "a : Association | a.allConnections))->asSet()");
} 

} 

} 

if(Model.getFacade().isAStereotype(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("baseClass"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getBaseClasses(subject));
} 

if(feature.equals("extendedElement"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getExtendedElements(subject));
} 

if(feature.equals("definedTag"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getTagDefinitions(subject));
} 

} 

} 

if(Model.getFacade().isATagDefinition(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("multiplicity"))//1
{ 
return Model.getFacade().getMultiplicity(subject);
} 

if(feature.equals("tagType"))//1
{ 
return Model.getFacade().getType(subject);
} 

if(feature.equals("typedValue"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getTypedValues(subject));
} 

if(feature.equals("owner"))//1
{ 
return Model.getFacade().getOwner(subject);
} 

} 

} 

if(Model.getFacade().isATaggedValue(subject))//1
{ 
if(type.equals("."))//1
{ 
if(feature.equals("dataValue"))//1
{ 
return Model.getFacade().getDataValue(subject);
} 

if(feature.equals("type"))//1
{ 
return Model.getFacade().getType(subject);
} 

if(feature.equals("referenceValue"))//1
{ 
return new HashSet<Object>(Model.getFacade()
                                               .getReferenceValue(subject));
} 

} 

} 

return null;
} 

public Object getBuiltInSymbol(String sym)
    { 
for (String name : Model.getFacade().getMetatypeNames()) //1
{ 
if(name.equals(sym))//1
{ 
return new OclType(sym);
} 

} 

return null;
} 

private Object internalOcl(Object subject, Map<String, Object> vt,
                               String ocl)
    { 
try //1
{ 
Object oldSelf = vt.get("self");
vt.put("self", subject);
Object ret = DefaultOclEvaluator.getInstance().evaluate(vt,
                         uml14mi, ocl);
vt.put("self", oldSelf);
return ret;
} 
catch (InvalidOclException e) //1
{ 

//#if LOGGING 
LOG.error("Exception", e);
//#endif 

return null;
} 


} 

 } 


