// Compilation Unit of /ProfileUML.java 
 
package org.argouml.profile.internal;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.argouml.model.Model;
import org.argouml.profile.CoreProfileReference;
import org.argouml.profile.DefaultTypeStrategy;
import org.argouml.profile.FormatingStrategy;
import org.argouml.profile.Profile;
import org.argouml.profile.ProfileException;
import org.argouml.profile.ProfileModelLoader;
import org.argouml.profile.ProfileReference;
import org.argouml.profile.ResourceModelLoader;
import org.argouml.profile.internal.ocl.InvalidOclException;

//#if COGNITIVE 
import org.argouml.cognitive.Critic;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.profile.internal.ocl.CrOCL;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrAssocNameConflict;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrAttrNameConflict;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrCircularAssocClass;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrCircularInheritance;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrClassMustBeAbstract;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrCrossNamespaceAssoc;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrDupParamName;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrDupRoleNames;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrFinalSubclassed;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrForkOutgoingTransition;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrIllegalGeneralization;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrInterfaceAllPublic;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrInterfaceOperOnly;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrInvalidBranch;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrInvalidFork;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrInvalidHistory;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrInvalidInitial;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrInvalidJoin;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrInvalidJoinTriggerOrGuard;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrInvalidPseudoStateTrigger;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrInvalidSynch;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrJoinIncomingTransition;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrMultiComposite;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrMultipleAgg;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrMultipleDeepHistoryStates;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrMultipleShallowHistoryStates;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrNWayAgg;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrNameConflict;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrNameConflictAC;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrNameConfusion;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrOppEndConflict;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrOppEndVsAttr;
//#endif 

public class ProfileUML extends Profile
  { 
private static final String PROFILE_FILE = "default-uml14.xmi";
static final String NAME = "UML 1.4";
private FormatingStrategy formatingStrategy;
private ProfileModelLoader profileModelLoader;
private Collection model;
@Override
    public DefaultTypeStrategy getDefaultTypeStrategy()
    { 
return new DefaultTypeStrategy() {
            public Object getDefaultAttributeType() {
                return ModelUtils.findTypeInModel("Integer", model.iterator()
                                                  .next());
            }

            public Object getDefaultParameterType() {
                return ModelUtils.findTypeInModel("Integer", model.iterator()
                                                  .next());
            }

            public Object getDefaultReturnType() {
                return null;
            }

        };
} 

@Override
    public FormatingStrategy getFormatingStrategy()
    { 
return formatingStrategy;
} 

@SuppressWarnings("unchecked")

    ProfileUML() throws ProfileException
    { 
formatingStrategy = new JavaFormatingStrategy();
profileModelLoader = new ResourceModelLoader();
ProfileReference profileReference = null;
try //1
{ 
profileReference = new CoreProfileReference(PROFILE_FILE);
} 
catch (MalformedURLException e) //1
{ 
throw new ProfileException(
                "Exception while creating profile reference.", e);
} 


model = profileModelLoader.loadModel(profileReference);
if(model == null)//1
{ 
model = new ArrayList();
model.add(Model.getModelManagementFactory().createModel());
} 


//#if COGNITIVE 
loadWellFormednessRules();
//#endif 

} 

@Override
    public String getDisplayName()
    { 
return NAME;
} 

@Override
    public Collection getProfilePackages()
    { 
return model;
} 


//#if COGNITIVE 
private void loadWellFormednessRules()
    { 
Set<Critic> critics = new HashSet<Critic>();
critics.add(new CrAssocNameConflict());
critics.add(new CrAttrNameConflict());
critics.add(new CrCircularAssocClass());
critics.add(new CrCircularInheritance());
critics.add(new CrClassMustBeAbstract());
critics.add(new CrCrossNamespaceAssoc());
critics.add(new CrDupParamName());
critics.add(new CrDupRoleNames());
critics.add(new CrNameConfusion());
critics.add(new CrInvalidHistory());
critics.add(new CrInvalidSynch());
critics.add(new CrInvalidJoinTriggerOrGuard());
critics.add(new CrInvalidPseudoStateTrigger());
critics.add(new CrInvalidInitial());
critics.add(new CrInvalidJoin());
critics.add(new CrInvalidFork());
critics.add(new CrInvalidBranch());
critics.add(new CrMultipleDeepHistoryStates());
critics.add(new CrMultipleShallowHistoryStates());
critics.add(new CrForkOutgoingTransition());
critics.add(new CrJoinIncomingTransition());
critics.add(new CrFinalSubclassed());
critics.add(new CrIllegalGeneralization());
critics.add(new CrInterfaceAllPublic());
critics.add(new CrInterfaceOperOnly());
critics.add(new CrMultipleAgg());
critics.add(new CrNWayAgg());
critics.add(new CrNameConflictAC());
critics.add(new CrOppEndConflict());
critics.add(new CrMultiComposite());
critics.add(new CrNameConflict());
critics.add(new CrOppEndVsAttr());
try //1
{ 
critics.add(new CrOCL("context AssociationClass inv:"
                                  + "self.allConnections->"
                                  + "forAll( ar | self.allFeatures->"
                                  + "forAll( f | f.oclIsKindOf(StructuralFeature) "
                                  + "implies ar.name <> f.name ))",
                                  "The names of the AssociationEnds and "
                                  + "the StructuralFeatures do not overlap.", null,
                                  ToDoItem.HIGH_PRIORITY, null, null, "http://www.uml.org/"));
} 

//#if COGNITIVE 
catch (InvalidOclException e) //1
{ 
e.printStackTrace();
} 

//#endif 


try //2
{ 
critics.add(new CrOCL("context AssociationClass inv:"
                                  + "self.allConnections->"
                                  + "forAll(ar | ar.participant <> self)",

                                  "An AssociationClass cannot be defined "
                                  + "between itself and something else.", null,
                                  ToDoItem.HIGH_PRIORITY, null, null, "http://www.uml.org/"));
} 

//#if COGNITIVE 
catch (InvalidOclException e) //1
{ 
e.printStackTrace();
} 

//#endif 


try //3
{ 
critics.add(new CrOCL("context Classifier inv:"
                                  + "self.oppositeAssociationEnds->"
                                  + "forAll( o | not self.allAttributes->"
                                  + "union (self.allContents)->"
                                  + "collect ( q | q.name )->includes (o.name) )",
                                  "The name of an opposite AssociationEnd may not be the same "
                                  + "as the name of an Attribute or a ModelElement contained "
                                  + "in the Classifier.", null,
                                  ToDoItem.HIGH_PRIORITY, null, null, "http://www.uml.org/"));
} 

//#if COGNITIVE 
catch (InvalidOclException e) //1
{ 
e.printStackTrace();
} 

//#endif 


try //4
{ 
critics.add(new CrOCL("context DataType inv:"
                                  + "self.allFeatures->forAll(f | f.oclIsKindOf(Operation)"
                                  + " and f.oclAsType(Operation).isQuery)",
                                  "A DataType can only contain Operations, "
                                  + "which all must be queries.", null,
                                  ToDoItem.HIGH_PRIORITY, null, null, "http://www.uml.org/"));
} 

//#if COGNITIVE 
catch (InvalidOclException e) //1
{ 
e.printStackTrace();
} 

//#endif 


try //5
{ 
critics.add(new CrOCL("context GeneralizableElement inv:"
                                  + "self.isRoot implies self.generalization->isEmpty",
                                  "A root cannot have any Generalizations.", null,
                                  ToDoItem.HIGH_PRIORITY, null, null, "http://www.uml.org/"));
} 

//#if COGNITIVE 
catch (InvalidOclException e) //1
{ 
e.printStackTrace();
} 

//#endif 


try //6
{ 
critics.add(new CrOCL("context GeneralizableElement inv:"
                                  + "self.generalization->"
                                  + "forAll(g |self.namespace.allContents->"
                                  + "includes(g.parent) )",
                                  "The parent must be included in the Namespace of"
                                  + " the GeneralizableElement.", null,
                                  ToDoItem.HIGH_PRIORITY, null, null, "http://www.uml.org/"));
} 

//#if COGNITIVE 
catch (InvalidOclException e) //1
{ 
e.printStackTrace();
} 

//#endif 


try //7
{ 
critics.add(new CrOCL("context Namespace inv:"
                                  + "self.allContents -> select(x|x.oclIsKindOf(Association))->"
                                  + "forAll(a1, a2 |a1.name = a2.name and "
                                  + "a1.connection.participant = a2.connection.participant"
                                  + " implies a1 = a2)",
                                  "All Associations must have a unique combination of name "
                                  + "and associated Classifiers in the Namespace.",
                                  null, ToDoItem.HIGH_PRIORITY, null, null,
                                  "http://www.uml.org/"));
} 

//#if COGNITIVE 
catch (InvalidOclException e) //1
{ 
e.printStackTrace();
} 

//#endif 


setCritics(critics);
} 

//#endif 

 } 


