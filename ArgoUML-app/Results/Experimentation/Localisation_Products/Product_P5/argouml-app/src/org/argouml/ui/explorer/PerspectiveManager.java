package org.argouml.ui.explorer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;
import org.argouml.application.api.Argo;
import org.argouml.configuration.Configuration;
import org.argouml.ui.explorer.rules.GoAssocRoleToMessages;
import org.argouml.ui.explorer.rules.GoBehavioralFeatureToStateMachine;
import org.argouml.ui.explorer.rules.GoClassToAssociatedClass;
import org.argouml.ui.explorer.rules.GoClassToNavigableClass;
import org.argouml.ui.explorer.rules.GoClassToSummary;
import org.argouml.ui.explorer.rules.GoClassifierToBehavioralFeature;
import org.argouml.ui.explorer.rules.GoClassifierToInstance;
import org.argouml.ui.explorer.rules.GoClassifierToStructuralFeature;
import org.argouml.ui.explorer.rules.GoComponentToResidentModelElement;
import org.argouml.ui.explorer.rules.GoDiagramToEdge;
import org.argouml.ui.explorer.rules.GoDiagramToNode;
import org.argouml.ui.explorer.rules.GoElementToMachine;
import org.argouml.ui.explorer.rules.GoEnumerationToLiterals;
import org.argouml.ui.explorer.rules.GoGeneralizableElementToSpecialized;
import org.argouml.ui.explorer.rules.GoInteractionToMessages;
import org.argouml.ui.explorer.rules.GoLinkToStimuli;
import org.argouml.ui.explorer.rules.GoMessageToAction;
import org.argouml.ui.explorer.rules.GoModelElementToBehavior;
import org.argouml.ui.explorer.rules.GoModelElementToComment;
import org.argouml.ui.explorer.rules.GoModelElementToContainedDiagrams;
import org.argouml.ui.explorer.rules.GoModelElementToContainedLostElements;
import org.argouml.ui.explorer.rules.GoModelElementToContents;
import org.argouml.ui.explorer.rules.GoModelToBaseElements;
import org.argouml.ui.explorer.rules.GoModelToDiagrams;
import org.argouml.ui.explorer.rules.GoModelToElements;
import org.argouml.ui.explorer.rules.GoModelToNode;
import org.argouml.ui.explorer.rules.GoNamespaceToClassifierAndPackage;
import org.argouml.ui.explorer.rules.GoNamespaceToDiagram;
import org.argouml.ui.explorer.rules.GoNamespaceToOwnedElements;
import org.argouml.ui.explorer.rules.GoNodeToResidentComponent;
import org.argouml.ui.explorer.rules.GoPackageToClass;
import org.argouml.ui.explorer.rules.GoPackageToElementImport;
import org.argouml.ui.explorer.rules.GoProfileConfigurationToProfile;
import org.argouml.ui.explorer.rules.GoProfileToModel;
import org.argouml.ui.explorer.rules.GoProjectToDiagram;
import org.argouml.ui.explorer.rules.GoProjectToModel;
import org.argouml.ui.explorer.rules.GoProjectToProfileConfiguration;
import org.argouml.ui.explorer.rules.GoProjectToRoots;
import org.argouml.ui.explorer.rules.GoSignalToReception;
import org.argouml.ui.explorer.rules.GoStateToDoActivity;
import org.argouml.ui.explorer.rules.GoStateToDownstream;
import org.argouml.ui.explorer.rules.GoStateToEntry;
import org.argouml.ui.explorer.rules.GoStateToExit;
import org.argouml.ui.explorer.rules.GoStateToInternalTrans;
import org.argouml.ui.explorer.rules.GoStereotypeToTagDefinition;
import org.argouml.ui.explorer.rules.GoStimulusToAction;
import org.argouml.ui.explorer.rules.GoSubmachineStateToStateMachine;
import org.argouml.ui.explorer.rules.GoSummaryToAssociation;
import org.argouml.ui.explorer.rules.GoSummaryToAttribute;
import org.argouml.ui.explorer.rules.GoSummaryToIncomingDependency;
import org.argouml.ui.explorer.rules.GoSummaryToInheritance;
import org.argouml.ui.explorer.rules.GoSummaryToOperation;
import org.argouml.ui.explorer.rules.GoSummaryToOutgoingDependency;
import org.argouml.ui.explorer.rules.GoTransitionToGuard;
import org.argouml.ui.explorer.rules.GoTransitionToSource;
import org.argouml.ui.explorer.rules.GoTransitionToTarget;
import org.argouml.ui.explorer.rules.GoTransitiontoEffect;
import org.argouml.ui.explorer.rules.GoUseCaseToExtensionPoint;
import org.argouml.ui.explorer.rules.PerspectiveRule;
import org.apache.log4j.Logger;
import org.argouml.ui.explorer.rules.GoBehavioralFeatureToStateDiagram;
import org.argouml.ui.explorer.rules.GoClassifierToCollaboration;
import org.argouml.ui.explorer.rules.GoClassifierToStateMachine;
import org.argouml.ui.explorer.rules.GoCollaborationToDiagram;
import org.argouml.ui.explorer.rules.GoCollaborationToInteraction;
import org.argouml.ui.explorer.rules.GoCompositeStateToSubvertex;
import org.argouml.ui.explorer.rules.GoCriticsToCritic;
import org.argouml.ui.explorer.rules.GoModelToCollaboration;
import org.argouml.ui.explorer.rules.GoOperationToCollaboration;
import org.argouml.ui.explorer.rules.GoOperationToCollaborationDiagram;
import org.argouml.ui.explorer.rules.GoProfileToCritics;
import org.argouml.ui.explorer.rules.GoProjectToCollaboration;
import org.argouml.ui.explorer.rules.GoProjectToStateMachine;
import org.argouml.ui.explorer.rules.GoStateMachineToState;
import org.argouml.ui.explorer.rules.GoStateMachineToTop;
import org.argouml.ui.explorer.rules.GoStateMachineToTransition;
import org.argouml.ui.explorer.rules.GoStateToIncomingTrans;
import org.argouml.ui.explorer.rules.GoStateToOutgoingTrans;
import org.argouml.ui.explorer.rules.GoStatemachineToDiagram;
public final class PerspectiveManager  { 
private static PerspectiveManager instance;
private List<PerspectiveManagerListener> perspectiveListeners;
private List<ExplorerPerspective> perspectives;
private List<PerspectiveRule> rules;
private static final Logger LOG =
        Logger.getLogger(PerspectiveManager.class);
public void addListener(PerspectiveManagerListener listener)
    { 
perspectiveListeners.add(listener);
} 
public void addAllPerspectives(
        Collection<ExplorerPerspective> newPerspectives)
    { 
for (ExplorerPerspective newPerspective : newPerspectives) //1
{ 
addPerspective(newPerspective);
} 
} 
public void removeListener(PerspectiveManagerListener listener)
    { 
perspectiveListeners.remove(listener);
} 
public Collection<ExplorerPerspective> getDefaultPerspectives()
    { 
ExplorerPerspective classPerspective =
            new ExplorerPerspective(
            "combobox.item.class-centric");
classPerspective.addRule(new GoProjectToModel());
classPerspective.addRule(new GoProjectToProfileConfiguration());
classPerspective.addRule(new GoProfileConfigurationToProfile());
classPerspective.addRule(new GoProfileToModel());
classPerspective.addRule(new GoProfileToCritics());
classPerspective.addRule(new GoCriticsToCritic());
classPerspective.addRule(new GoProjectToRoots());
classPerspective.addRule(new GoNamespaceToClassifierAndPackage());
classPerspective.addRule(new GoNamespaceToDiagram());
classPerspective.addRule(new GoClassToSummary());
classPerspective.addRule(new GoSummaryToAssociation());
classPerspective.addRule(new GoSummaryToAttribute());
classPerspective.addRule(new GoSummaryToOperation());
classPerspective.addRule(new GoSummaryToInheritance());
classPerspective.addRule(new GoSummaryToIncomingDependency());
classPerspective.addRule(new GoSummaryToOutgoingDependency());
ExplorerPerspective packagePerspective =
            new ExplorerPerspective(
            "combobox.item.package-centric");
packagePerspective.addRule(new GoProjectToModel());
packagePerspective.addRule(new GoProjectToProfileConfiguration());
packagePerspective.addRule(new GoProfileConfigurationToProfile());
packagePerspective.addRule(new GoProfileToModel());
packagePerspective.addRule(new GoProfileToCritics());
packagePerspective.addRule(new GoCriticsToCritic());
packagePerspective.addRule(new GoProjectToRoots());
packagePerspective.addRule(new GoNamespaceToOwnedElements());
packagePerspective.addRule(new GoPackageToElementImport());
packagePerspective.addRule(new GoNamespaceToDiagram());
packagePerspective.addRule(new GoUseCaseToExtensionPoint());
packagePerspective.addRule(new GoClassifierToStructuralFeature());
packagePerspective.addRule(new GoClassifierToBehavioralFeature());
packagePerspective.addRule(new GoEnumerationToLiterals());
packagePerspective.addRule(new GoCollaborationToInteraction());
packagePerspective.addRule(new GoInteractionToMessages());
packagePerspective.addRule(new GoMessageToAction());
packagePerspective.addRule(new GoSignalToReception());
packagePerspective.addRule(new GoLinkToStimuli());
packagePerspective.addRule(new GoStimulusToAction());
packagePerspective.addRule(new GoClassifierToCollaboration());
packagePerspective.addRule(new GoOperationToCollaboration());
packagePerspective.addRule(new GoModelElementToComment());
packagePerspective.addRule(new GoCollaborationToDiagram());
packagePerspective.addRule(new GoBehavioralFeatureToStateMachine());
packagePerspective.addRule(new GoStatemachineToDiagram());
packagePerspective.addRule(new GoStateMachineToState());
packagePerspective.addRule(new GoCompositeStateToSubvertex());
packagePerspective.addRule(new GoStateToInternalTrans());
packagePerspective.addRule(new GoStateToDoActivity());
packagePerspective.addRule(new GoStateToEntry());
packagePerspective.addRule(new GoStateToExit());
packagePerspective.addRule(new GoClassifierToInstance());
packagePerspective.addRule(new GoStateToIncomingTrans());
packagePerspective.addRule(new GoStateToOutgoingTrans());
packagePerspective.addRule(new GoSubmachineStateToStateMachine());
packagePerspective.addRule(new GoStereotypeToTagDefinition());
packagePerspective.addRule(new GoModelElementToBehavior());
packagePerspective.addRule(new GoModelElementToContainedLostElements());
ExplorerPerspective diagramPerspective =
            new ExplorerPerspective(
            "combobox.item.diagram-centric");
diagramPerspective.addRule(new GoProjectToModel());
diagramPerspective.addRule(new GoProjectToProfileConfiguration());
diagramPerspective.addRule(new GoProfileConfigurationToProfile());
diagramPerspective.addRule(new GoProfileToModel());
diagramPerspective.addRule(new GoProfileToCritics());
diagramPerspective.addRule(new GoCriticsToCritic());
diagramPerspective.addRule(new GoModelToDiagrams());
diagramPerspective.addRule(new GoDiagramToNode());
diagramPerspective.addRule(new GoDiagramToEdge());
diagramPerspective.addRule(new GoUseCaseToExtensionPoint());
diagramPerspective.addRule(new GoClassifierToStructuralFeature());
diagramPerspective.addRule(new GoClassifierToBehavioralFeature());
ExplorerPerspective inheritancePerspective =
            new ExplorerPerspective(
            "combobox.item.inheritance-centric");
inheritancePerspective.addRule(new GoProjectToModel());
inheritancePerspective.addRule(new GoProjectToProfileConfiguration());
classPerspective.addRule(new GoProfileConfigurationToProfile());
classPerspective.addRule(new GoProfileToModel());
classPerspective.addRule(new GoProfileToCritics());
classPerspective.addRule(new GoCriticsToCritic());
inheritancePerspective.addRule(new GoModelToBaseElements());
inheritancePerspective
        .addRule(new GoGeneralizableElementToSpecialized());
ExplorerPerspective associationsPerspective =
            new ExplorerPerspective(
            "combobox.item.class-associations");
associationsPerspective.addRule(new GoProjectToModel());
associationsPerspective.addRule(new GoProjectToProfileConfiguration());
associationsPerspective.addRule(new GoProfileConfigurationToProfile());
associationsPerspective.addRule(new GoProfileToModel());
associationsPerspective.addRule(new GoProfileToCritics());
associationsPerspective.addRule(new GoCriticsToCritic());
associationsPerspective.addRule(new GoNamespaceToDiagram());
associationsPerspective.addRule(new GoPackageToClass());
associationsPerspective.addRule(new GoClassToAssociatedClass());
ExplorerPerspective residencePerspective =
            new ExplorerPerspective(
            "combobox.item.residence-centric");
residencePerspective.addRule(new GoProjectToModel());
residencePerspective.addRule(new GoProjectToProfileConfiguration());
residencePerspective.addRule(new GoProfileConfigurationToProfile());
residencePerspective.addRule(new GoProfileToModel());
residencePerspective.addRule(new GoProfileToCritics());
residencePerspective.addRule(new GoCriticsToCritic());
residencePerspective.addRule(new GoModelToNode());
residencePerspective.addRule(new GoNodeToResidentComponent());
residencePerspective.addRule(new GoComponentToResidentModelElement());
ExplorerPerspective statePerspective =
            new ExplorerPerspective(
            "combobox.item.state-centric");
statePerspective.addRule(new GoProjectToStateMachine());
statePerspective.addRule(new GoStatemachineToDiagram());
statePerspective.addRule(new GoStateMachineToState());
statePerspective.addRule(new GoCompositeStateToSubvertex());
statePerspective.addRule(new GoStateToIncomingTrans());
statePerspective.addRule(new GoStateToOutgoingTrans());
statePerspective.addRule(new GoTransitiontoEffect());
statePerspective.addRule(new GoTransitionToGuard());
ExplorerPerspective transitionsPerspective =
            new ExplorerPerspective(
            "combobox.item.transitions-centric");
transitionsPerspective.addRule(new GoProjectToStateMachine());
transitionsPerspective.addRule(new GoStatemachineToDiagram());
transitionsPerspective.addRule(new GoStateMachineToTransition());
transitionsPerspective.addRule(new GoTransitionToSource());
transitionsPerspective.addRule(new GoTransitionToTarget());
transitionsPerspective.addRule(new GoTransitiontoEffect());
transitionsPerspective.addRule(new GoTransitionToGuard());
ExplorerPerspective compositionPerspective =
            new ExplorerPerspective(
            "combobox.item.composite-centric");
compositionPerspective.addRule(new GoProjectToModel());
compositionPerspective.addRule(new GoProjectToProfileConfiguration());
compositionPerspective.addRule(new GoProfileConfigurationToProfile());
compositionPerspective.addRule(new GoProfileToModel());
compositionPerspective.addRule(new GoProfileToCritics());
compositionPerspective.addRule(new GoCriticsToCritic());
compositionPerspective.addRule(new GoProjectToRoots());
compositionPerspective.addRule(new GoModelElementToContents());
compositionPerspective.addRule(new GoModelElementToContainedDiagrams());
Collection<ExplorerPerspective> c =
            new ArrayList<ExplorerPerspective>();
c.add(packagePerspective);
c.add(classPerspective);
c.add(diagramPerspective);
c.add(inheritancePerspective);
c.add(associationsPerspective);
c.add(residencePerspective);
c.add(statePerspective);
c.add(transitionsPerspective);
c.add(compositionPerspective);
return c;
} 
@Override
    public String toString()
    { 
StringBuffer p = new StringBuffer();
for (ExplorerPerspective perspective : getPerspectives()) //1
{ 
String name = perspective.toString();
p.append(name).append(",");
for (PerspectiveRule rule : perspective.getList()) //1
{ 
p.append(rule.getClass().getName()).append(",");
} 
p.deleteCharAt(p.length() - 1);
p.append(";");
} 
p.deleteCharAt(p.length() - 1);
return p.toString();
} 
public void addPerspective(ExplorerPerspective perspective)
    { 
perspectives.add(perspective);
for (PerspectiveManagerListener listener : perspectiveListeners) //1
{ 
listener.addPerspective(perspective);
} 
} 
public void removePerspective(ExplorerPerspective perspective)
    { 
perspectives.remove(perspective);
for (PerspectiveManagerListener listener : perspectiveListeners) //1
{ 
listener.removePerspective(perspective);
} 
} 
public void removeAllPerspectives()
    { 
List<ExplorerPerspective> pers = new ArrayList<ExplorerPerspective>();
pers.addAll(getPerspectives());
for (ExplorerPerspective perspective : pers) //1
{ 
removePerspective(perspective);
} 
} 
public List<ExplorerPerspective> getPerspectives()
    { 
return perspectives;
} 
private PerspectiveManager()
    { 
perspectiveListeners = new ArrayList<PerspectiveManagerListener>();
perspectives = new ArrayList<ExplorerPerspective>();
rules = new ArrayList<PerspectiveRule>();
loadRules();
} 
public void addRule(PerspectiveRule rule)
    { 
rules.add(rule);
} 
public Collection<PerspectiveRule> getRules()
    { 
return rules;
} 
public void saveUserPerspectives()
    { 
Configuration.setString(Argo.KEY_USER_EXPLORER_PERSPECTIVES, this
                                .toString());
} 
public void loadUserPerspectives()
    { 
String userPerspectives =
            Configuration.getString(
                Argo.KEY_USER_EXPLORER_PERSPECTIVES, "");
StringTokenizer pst = new StringTokenizer(userPerspectives, ";");
if(pst.hasMoreTokens())//1
{ 
while (pst.hasMoreTokens()) //1
{ 
String perspective = pst.nextToken();
StringTokenizer perspectiveDetails =
                    new StringTokenizer(perspective, ",");
String perspectiveName = perspectiveDetails.nextToken();
ExplorerPerspective userDefinedPerspective =
                    new ExplorerPerspective(perspectiveName);
if(perspectiveDetails.hasMoreTokens())//1
{ 
while (perspectiveDetails.hasMoreTokens()) //1
{ 
String ruleName = perspectiveDetails.nextToken();
try//1
{ 
Class ruleClass = Class.forName(ruleName);
PerspectiveRule rule =
                                (PerspectiveRule) ruleClass.newInstance();
userDefinedPerspective.addRule(rule);
} 
catch (ClassNotFoundException e) //1
{ 
LOG.error(
                                "could not create rule " + ruleName
                                + " you can try to "
                                + "refresh the perspectives to the "
                                + "default settings.",
                                e);
} 
catch (InstantiationException e) //1
{ 
LOG.error(
                                "could not create rule " + ruleName
                                + " you can try to "
                                + "refresh the perspectives to the "
                                + "default settings.",
                                e);
} 
catch (IllegalAccessException e) //1
{ 
LOG.error(
                                "could not create rule " + ruleName
                                + " you can try to "
                                + "refresh the perspectives to the "
                                + "default settings.",
                                e);
} 
} 
} 
else
{ 
continue;
} 
addPerspective(userDefinedPerspective);
} 
} 
else
{ 
loadDefaultPerspectives();
} 
if(getPerspectives().size() == 0)//1
{ 
loadDefaultPerspectives();
} 
} 
public void loadRules()
    { 
PerspectiveRule[] ruleNamesArray = {new GoAssocRoleToMessages(),


                            new GoBehavioralFeatureToStateDiagram(),

                            new GoBehavioralFeatureToStateMachine(),
                            new GoClassifierToBehavioralFeature(),


                            new GoClassifierToCollaboration(),

                            new GoClassifierToInstance(),






                            new GoClassifierToStateMachine(),

                            new GoClassifierToStructuralFeature(),
                            new GoClassToAssociatedClass(), new GoClassToNavigableClass(),
                            new GoClassToSummary(),


                            new GoCollaborationToDiagram(),
                            new GoCollaborationToInteraction(),

                            new GoComponentToResidentModelElement(),


                            new GoCompositeStateToSubvertex(), new GoDiagramToEdge(),

                            new GoDiagramToNode(), new GoElementToMachine(),
                            new GoEnumerationToLiterals(),
                            new GoGeneralizableElementToSpecialized(),
                            new GoInteractionToMessages(), new GoLinkToStimuli(),
                            new GoMessageToAction(), new GoModelElementToComment(),
                            new GoModelElementToBehavior(),
                            new GoModelElementToContents(),
                            new GoModelElementToContainedDiagrams(),
                            new GoModelElementToContainedLostElements(),
                            new GoModelToBaseElements(),


                            new GoModelToCollaboration(),

                            new GoModelToDiagrams(), new GoModelToElements(),
                            new GoModelToNode(), new GoNamespaceToClassifierAndPackage(),
                            new GoNamespaceToDiagram(), new GoNamespaceToOwnedElements(),
                            new GoNodeToResidentComponent(),


                            new GoOperationToCollaborationDiagram(),
                            new GoOperationToCollaboration(),





                            new GoPackageToElementImport(),


                            new GoProjectToCollaboration(),

                            new GoProjectToDiagram(),


                            new GoProjectToModel(), new GoProjectToStateMachine(),

                            new GoProjectToProfileConfiguration(),
                            new GoProfileConfigurationToProfile(),
                            new GoProfileToModel(),


                            new GoProfileToCritics(),
                            new GoCriticsToCritic(),

                            new GoProjectToRoots(),


                            new GoSignalToReception(), new GoStateMachineToTop(),
                            new GoStatemachineToDiagram(), new GoStateMachineToState(),
                            new GoStateMachineToTransition(), new GoStateToDoActivity(),

                            new GoStateToDownstream(), new GoStateToEntry(),


                            new GoStateToExit(), new GoStateToIncomingTrans(),
                            new GoStateToInternalTrans(), new GoStateToOutgoingTrans(),

                            new GoStereotypeToTagDefinition(),
                            new GoStimulusToAction(), new GoSummaryToAssociation(),
                            new GoSummaryToAttribute(),
                            new GoSummaryToIncomingDependency(),
                            new GoSummaryToInheritance(), new GoSummaryToOperation(),
                            new GoSummaryToOutgoingDependency(),
                            new GoTransitionToSource(), new GoTransitionToTarget(),
                            new GoTransitiontoEffect(), new GoTransitionToGuard(),
                            new GoUseCaseToExtensionPoint(),
                            new GoSubmachineStateToStateMachine(),
        };
rules = Arrays.asList(ruleNamesArray);
} 
public static PerspectiveManager getInstance()
    { 
if(instance == null)//1
{ 
instance = new PerspectiveManager();
} 
return instance;
} 
public void loadDefaultPerspectives()
    { 
Collection<ExplorerPerspective> c = getDefaultPerspectives();
addAllPerspectives(c);
} 
public void removeRule(PerspectiveRule rule)
    { 
rules.remove(rule);
} 

 } 
