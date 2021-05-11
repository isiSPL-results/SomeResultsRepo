
//#if 478633071 
// Compilation Unit of /PerspectiveManager.java 
 

//#if 1471228956 
package org.argouml.ui.explorer;
//#endif 


//#if 294944946 
import java.util.ArrayList;
//#endif 


//#if 185269459 
import java.util.Arrays;
//#endif 


//#if 1892956911 
import java.util.Collection;
//#endif 


//#if 139693679 
import java.util.List;
//#endif 


//#if 1229974691 
import java.util.StringTokenizer;
//#endif 


//#if 1805205733 
import org.argouml.application.api.Argo;
//#endif 


//#if -2101212664 
import org.argouml.configuration.Configuration;
//#endif 


//#if 834962408 
import org.argouml.ui.explorer.rules.GoAssocRoleToMessages;
//#endif 


//#if -52098384 
import org.argouml.ui.explorer.rules.GoBehavioralFeatureToStateMachine;
//#endif 


//#if 348598109 
import org.argouml.ui.explorer.rules.GoClassToAssociatedClass;
//#endif 


//#if 71316618 
import org.argouml.ui.explorer.rules.GoClassToNavigableClass;
//#endif 


//#if -1539586487 
import org.argouml.ui.explorer.rules.GoClassToSummary;
//#endif 


//#if 589309661 
import org.argouml.ui.explorer.rules.GoClassifierToBehavioralFeature;
//#endif 


//#if 1827886635 
import org.argouml.ui.explorer.rules.GoClassifierToInstance;
//#endif 


//#if 1777358269 
import org.argouml.ui.explorer.rules.GoClassifierToStructuralFeature;
//#endif 


//#if 167444095 
import org.argouml.ui.explorer.rules.GoComponentToResidentModelElement;
//#endif 


//#if 214427183 
import org.argouml.ui.explorer.rules.GoDiagramToEdge;
//#endif 


//#if 223063690 
import org.argouml.ui.explorer.rules.GoDiagramToNode;
//#endif 


//#if -304172532 
import org.argouml.ui.explorer.rules.GoElementToMachine;
//#endif 


//#if -2099824332 
import org.argouml.ui.explorer.rules.GoEnumerationToLiterals;
//#endif 


//#if -1304533707 
import org.argouml.ui.explorer.rules.GoGeneralizableElementToSpecialized;
//#endif 


//#if -2113003039 
import org.argouml.ui.explorer.rules.GoInteractionToMessages;
//#endif 


//#if 1448637410 
import org.argouml.ui.explorer.rules.GoLinkToStimuli;
//#endif 


//#if 344420322 
import org.argouml.ui.explorer.rules.GoMessageToAction;
//#endif 


//#if 30164764 
import org.argouml.ui.explorer.rules.GoModelElementToBehavior;
//#endif 


//#if -2112355223 
import org.argouml.ui.explorer.rules.GoModelElementToComment;
//#endif 


//#if -96195211 
import org.argouml.ui.explorer.rules.GoModelElementToContainedDiagrams;
//#endif 


//#if -224269926 
import org.argouml.ui.explorer.rules.GoModelElementToContainedLostElements;
//#endif 


//#if 29407060 
import org.argouml.ui.explorer.rules.GoModelElementToContents;
//#endif 


//#if 1347651598 
import org.argouml.ui.explorer.rules.GoModelToBaseElements;
//#endif 


//#if 308584822 
import org.argouml.ui.explorer.rules.GoModelToDiagrams;
//#endif 


//#if -1150195361 
import org.argouml.ui.explorer.rules.GoModelToElements;
//#endif 


//#if 557904692 
import org.argouml.ui.explorer.rules.GoModelToNode;
//#endif 


//#if 2081184660 
import org.argouml.ui.explorer.rules.GoNamespaceToClassifierAndPackage;
//#endif 


//#if 726517343 
import org.argouml.ui.explorer.rules.GoNamespaceToDiagram;
//#endif 


//#if -588856234 
import org.argouml.ui.explorer.rules.GoNamespaceToOwnedElements;
//#endif 


//#if -1394467158 
import org.argouml.ui.explorer.rules.GoNodeToResidentComponent;
//#endif 


//#if -523891643 
import org.argouml.ui.explorer.rules.GoPackageToClass;
//#endif 


//#if 1631439644 
import org.argouml.ui.explorer.rules.GoPackageToElementImport;
//#endif 


//#if -1111323367 
import org.argouml.ui.explorer.rules.GoProfileConfigurationToProfile;
//#endif 


//#if 1711092503 
import org.argouml.ui.explorer.rules.GoProfileToModel;
//#endif 


//#if 868254429 
import org.argouml.ui.explorer.rules.GoProjectToDiagram;
//#endif 


//#if 1251902599 
import org.argouml.ui.explorer.rules.GoProjectToModel;
//#endif 


//#if 1837774105 
import org.argouml.ui.explorer.rules.GoProjectToProfileConfiguration;
//#endif 


//#if 1395390687 
import org.argouml.ui.explorer.rules.GoProjectToRoots;
//#endif 


//#if -1807251058 
import org.argouml.ui.explorer.rules.GoSignalToReception;
//#endif 


//#if -1238870316 
import org.argouml.ui.explorer.rules.GoStateToDoActivity;
//#endif 


//#if 1357466092 
import org.argouml.ui.explorer.rules.GoStateToDownstream;
//#endif 


//#if 952507926 
import org.argouml.ui.explorer.rules.GoStateToEntry;
//#endif 


//#if 862297392 
import org.argouml.ui.explorer.rules.GoStateToExit;
//#endif 


//#if -329118019 
import org.argouml.ui.explorer.rules.GoStateToInternalTrans;
//#endif 


//#if -1853335654 
import org.argouml.ui.explorer.rules.GoStereotypeToTagDefinition;
//#endif 


//#if 1515055153 
import org.argouml.ui.explorer.rules.GoStimulusToAction;
//#endif 


//#if 796367295 
import org.argouml.ui.explorer.rules.GoSubmachineStateToStateMachine;
//#endif 


//#if -702882756 
import org.argouml.ui.explorer.rules.GoSummaryToAssociation;
//#endif 


//#if -347569663 
import org.argouml.ui.explorer.rules.GoSummaryToAttribute;
//#endif 


//#if 703518632 
import org.argouml.ui.explorer.rules.GoSummaryToIncomingDependency;
//#endif 


//#if 384853267 
import org.argouml.ui.explorer.rules.GoSummaryToInheritance;
//#endif 


//#if -749031274 
import org.argouml.ui.explorer.rules.GoSummaryToOperation;
//#endif 


//#if 1582953634 
import org.argouml.ui.explorer.rules.GoSummaryToOutgoingDependency;
//#endif 


//#if 199806885 
import org.argouml.ui.explorer.rules.GoTransitionToGuard;
//#endif 


//#if -489115663 
import org.argouml.ui.explorer.rules.GoTransitionToSource;
//#endif 


//#if -5515973 
import org.argouml.ui.explorer.rules.GoTransitionToTarget;
//#endif 


//#if 1989832027 
import org.argouml.ui.explorer.rules.GoTransitiontoEffect;
//#endif 


//#if 31712407 
import org.argouml.ui.explorer.rules.GoUseCaseToExtensionPoint;
//#endif 


//#if -1334664454 
import org.argouml.ui.explorer.rules.PerspectiveRule;
//#endif 


//#if -1372547281 
import org.apache.log4j.Logger;
//#endif 


//#if -105353308 
import org.argouml.ui.explorer.rules.GoBehavioralFeatureToStateDiagram;
//#endif 


//#if 1708662225 
import org.argouml.ui.explorer.rules.GoClassifierToCollaboration;
//#endif 


//#if -1193533148 
import org.argouml.ui.explorer.rules.GoClassifierToSequenceDiagram;
//#endif 


//#if 57289194 
import org.argouml.ui.explorer.rules.GoClassifierToStateMachine;
//#endif 


//#if 485246537 
import org.argouml.ui.explorer.rules.GoCollaborationToDiagram;
//#endif 


//#if -1619236758 
import org.argouml.ui.explorer.rules.GoCollaborationToInteraction;
//#endif 


//#if -2114123589 
import org.argouml.ui.explorer.rules.GoCompositeStateToSubvertex;
//#endif 


//#if -1180701204 
import org.argouml.ui.explorer.rules.GoCriticsToCritic;
//#endif 


//#if -2119299013 
import org.argouml.ui.explorer.rules.GoModelToCollaboration;
//#endif 


//#if -1723578887 
import org.argouml.ui.explorer.rules.GoOperationToCollaboration;
//#endif 


//#if -233277846 
import org.argouml.ui.explorer.rules.GoOperationToCollaborationDiagram;
//#endif 


//#if -1042358452 
import org.argouml.ui.explorer.rules.GoOperationToSequenceDiagram;
//#endif 


//#if 1958649153 
import org.argouml.ui.explorer.rules.GoProfileToCritics;
//#endif 


//#if 530400235 
import org.argouml.ui.explorer.rules.GoProjectToCollaboration;
//#endif 


//#if 1404754064 
import org.argouml.ui.explorer.rules.GoProjectToStateMachine;
//#endif 


//#if -1613258854 
import org.argouml.ui.explorer.rules.GoStateMachineToState;
//#endif 


//#if -2111148202 
import org.argouml.ui.explorer.rules.GoStateMachineToTop;
//#endif 


//#if 2123566518 
import org.argouml.ui.explorer.rules.GoStateMachineToTransition;
//#endif 


//#if -844116634 
import org.argouml.ui.explorer.rules.GoStateToIncomingTrans;
//#endif 


//#if 1655766060 
import org.argouml.ui.explorer.rules.GoStateToOutgoingTrans;
//#endif 


//#if -1058863176 
import org.argouml.ui.explorer.rules.GoStatemachineToDiagram;
//#endif 


//#if 1641225317 
public final class PerspectiveManager  { 

//#if 777031306 
private static PerspectiveManager instance;
//#endif 


//#if 746695104 
private List<PerspectiveManagerListener> perspectiveListeners;
//#endif 


//#if 1299527586 
private List<ExplorerPerspective> perspectives;
//#endif 


//#if 741860075 
private List<PerspectiveRule> rules;
//#endif 


//#if 1085217977 
private static final Logger LOG =
        Logger.getLogger(PerspectiveManager.class);
//#endif 


//#if 304341722 
public void addListener(PerspectiveManagerListener listener)
    { 

//#if 919148938 
perspectiveListeners.add(listener);
//#endif 

} 

//#endif 


//#if -1250582557 
public void addAllPerspectives(
        Collection<ExplorerPerspective> newPerspectives)
    { 

//#if 1014518322 
for (ExplorerPerspective newPerspective : newPerspectives) //1
{ 

//#if 517074135 
addPerspective(newPerspective);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -737282909 
public void removeListener(PerspectiveManagerListener listener)
    { 

//#if -1579304762 
perspectiveListeners.remove(listener);
//#endif 

} 

//#endif 


//#if -1796601741 
public Collection<ExplorerPerspective> getDefaultPerspectives()
    { 

//#if -1683765425 
ExplorerPerspective classPerspective =
            new ExplorerPerspective(
            "combobox.item.class-centric");
//#endif 


//#if 31150568 
classPerspective.addRule(new GoProjectToModel());
//#endif 


//#if -124719500 
classPerspective.addRule(new GoProjectToProfileConfiguration());
//#endif 


//#if 1163499124 
classPerspective.addRule(new GoProfileConfigurationToProfile());
//#endif 


//#if 286742872 
classPerspective.addRule(new GoProfileToModel());
//#endif 


//#if -97985874 
classPerspective.addRule(new GoProfileToCritics());
//#endif 


//#if 2105324289 
classPerspective.addRule(new GoCriticsToCritic());
//#endif 


//#if 1192320656 
classPerspective.addRule(new GoProjectToRoots());
//#endif 


//#if -1006967207 
classPerspective.addRule(new GoNamespaceToClassifierAndPackage());
//#endif 


//#if 1466226832 
classPerspective.addRule(new GoNamespaceToDiagram());
//#endif 


//#if -2063425306 
classPerspective.addRule(new GoClassToSummary());
//#endif 


//#if 1894272339 
classPerspective.addRule(new GoSummaryToAssociation());
//#endif 


//#if 846586286 
classPerspective.addRule(new GoSummaryToAttribute());
//#endif 


//#if -1907314951 
classPerspective.addRule(new GoSummaryToOperation());
//#endif 


//#if 1109885212 
classPerspective.addRule(new GoSummaryToInheritance());
//#endif 


//#if -1133246139 
classPerspective.addRule(new GoSummaryToIncomingDependency());
//#endif 


//#if -1185607157 
classPerspective.addRule(new GoSummaryToOutgoingDependency());
//#endif 


//#if 927997199 
ExplorerPerspective packagePerspective =
            new ExplorerPerspective(
            "combobox.item.package-centric");
//#endif 


//#if -2124492006 
packagePerspective.addRule(new GoProjectToModel());
//#endif 


//#if -1309105406 
packagePerspective.addRule(new GoProjectToProfileConfiguration());
//#endif 


//#if -20886782 
packagePerspective.addRule(new GoProfileConfigurationToProfile());
//#endif 


//#if -1868899702 
packagePerspective.addRule(new GoProfileToModel());
//#endif 


//#if -1496262816 
packagePerspective.addRule(new GoProfileToCritics());
//#endif 


//#if -295086065 
packagePerspective.addRule(new GoCriticsToCritic());
//#endif 


//#if -963321918 
packagePerspective.addRule(new GoProjectToRoots());
//#endif 


//#if 860027179 
packagePerspective.addRule(new GoNamespaceToOwnedElements());
//#endif 


//#if 254731621 
packagePerspective.addRule(new GoPackageToElementImport());
//#endif 


//#if 2046849218 
packagePerspective.addRule(new GoNamespaceToDiagram());
//#endif 


//#if 635019396 
packagePerspective.addRule(new GoUseCaseToExtensionPoint());
//#endif 


//#if -1565978658 
packagePerspective.addRule(new GoClassifierToStructuralFeature());
//#endif 


//#if 103426750 
packagePerspective.addRule(new GoClassifierToBehavioralFeature());
//#endif 


//#if -1057660409 
packagePerspective.addRule(new GoEnumerationToLiterals());
//#endif 


//#if -813798441 
packagePerspective.addRule(new GoCollaborationToInteraction());
//#endif 


//#if 1472470586 
packagePerspective.addRule(new GoInteractionToMessages());
//#endif 


//#if -1858729383 
packagePerspective.addRule(new GoMessageToAction());
//#endif 


//#if 392092141 
packagePerspective.addRule(new GoSignalToReception());
//#endif 


//#if -1000735335 
packagePerspective.addRule(new GoLinkToStimuli());
//#endif 


//#if -990747024 
packagePerspective.addRule(new GoStimulusToAction());
//#endif 


//#if 639745482 
packagePerspective.addRule(new GoClassifierToCollaboration());
//#endif 


//#if 2025058472 
packagePerspective.addRule(new GoOperationToCollaboration());
//#endif 


//#if -703279438 
packagePerspective.addRule(new GoModelElementToComment());
//#endif 


//#if -994115816 
packagePerspective.addRule(new GoCollaborationToDiagram());
//#endif 


//#if -1039574325 
packagePerspective.addRule(new GoBehavioralFeatureToStateMachine());
//#endif 


//#if 552260867 
packagePerspective.addRule(new GoStatemachineToDiagram());
//#endif 


//#if 605987105 
packagePerspective.addRule(new GoStateMachineToState());
//#endif 


//#if 1380381344 
packagePerspective.addRule(new GoCompositeStateToSubvertex());
//#endif 


//#if -498281756 
packagePerspective.addRule(new GoStateToInternalTrans());
//#endif 


//#if -2033271065 
packagePerspective.addRule(new GoStateToDoActivity());
//#endif 


//#if -319407125 
packagePerspective.addRule(new GoStateToEntry());
//#endif 


//#if 1621881035 
packagePerspective.addRule(new GoStateToExit());
//#endif 


//#if 957742679 
packagePerspective.addRule(new GoClassifierToSequenceDiagram());
//#endif 


//#if 803664309 
packagePerspective.addRule(new GoOperationToSequenceDiagram());
//#endif 


//#if 1821650102 
packagePerspective.addRule(new GoClassifierToInstance());
//#endif 


//#if -1198839909 
packagePerspective.addRule(new GoStateToIncomingTrans());
//#endif 


//#if -1926415595 
packagePerspective.addRule(new GoStateToOutgoingTrans());
//#endif 


//#if 984364188 
packagePerspective.addRule(new GoSubmachineStateToStateMachine());
//#endif 


//#if 917914465 
packagePerspective.addRule(new GoStereotypeToTagDefinition());
//#endif 


//#if 876538213 
packagePerspective.addRule(new GoModelElementToBehavior());
//#endif 


//#if 309763361 
packagePerspective.addRule(new GoModelElementToContainedLostElements());
//#endif 


//#if 481868911 
ExplorerPerspective diagramPerspective =
            new ExplorerPerspective(
            "combobox.item.diagram-centric");
//#endif 


//#if -1463213971 
diagramPerspective.addRule(new GoProjectToModel());
//#endif 


//#if -1957321393 
diagramPerspective.addRule(new GoProjectToProfileConfiguration());
//#endif 


//#if -669102769 
diagramPerspective.addRule(new GoProfileConfigurationToProfile());
//#endif 


//#if -1207621667 
diagramPerspective.addRule(new GoProfileToModel());
//#endif 


//#if -1663230989 
diagramPerspective.addRule(new GoProfileToCritics());
//#endif 


//#if -1270303460 
diagramPerspective.addRule(new GoCriticsToCritic());
//#endif 


//#if -962470574 
diagramPerspective.addRule(new GoModelToDiagrams());
//#endif 


//#if -1083302338 
diagramPerspective.addRule(new GoDiagramToNode());
//#endif 


//#if -675444615 
diagramPerspective.addRule(new GoDiagramToEdge());
//#endif 


//#if 8757393 
diagramPerspective.addRule(new GoUseCaseToExtensionPoint());
//#endif 


//#if 2080772651 
diagramPerspective.addRule(new GoClassifierToStructuralFeature());
//#endif 


//#if -544789237 
diagramPerspective.addRule(new GoClassifierToBehavioralFeature());
//#endif 


//#if 1197464207 
ExplorerPerspective inheritancePerspective =
            new ExplorerPerspective(
            "combobox.item.inheritance-centric");
//#endif 


//#if -1845268074 
inheritancePerspective.addRule(new GoProjectToModel());
//#endif 


//#if 241941766 
inheritancePerspective.addRule(new GoProjectToProfileConfiguration());
//#endif 


//#if 1416371038 
classPerspective.addRule(new GoProfileConfigurationToProfile());
//#endif 


//#if -333005318 
classPerspective.addRule(new GoProfileToModel());
//#endif 


//#if 1480635620 
classPerspective.addRule(new GoProfileToCritics());
//#endif 


//#if 308516785 
classPerspective.addRule(new GoCriticsToCritic());
//#endif 


//#if -292191439 
inheritancePerspective.addRule(new GoModelToBaseElements());
//#endif 


//#if -1061648662 
inheritancePerspective
        .addRule(new GoGeneralizableElementToSpecialized());
//#endif 


//#if -1653370679 
ExplorerPerspective associationsPerspective =
            new ExplorerPerspective(
            "combobox.item.class-associations");
//#endif 


//#if -2128313132 
associationsPerspective.addRule(new GoProjectToModel());
//#endif 


//#if 1307969032 
associationsPerspective.addRule(new GoProjectToProfileConfiguration());
//#endif 


//#if -1698779640 
associationsPerspective.addRule(new GoProfileConfigurationToProfile());
//#endif 


//#if -1872720828 
associationsPerspective.addRule(new GoProfileToModel());
//#endif 


//#if -873397606 
associationsPerspective.addRule(new GoProfileToCritics());
//#endif 


//#if -413540971 
associationsPerspective.addRule(new GoCriticsToCritic());
//#endif 


//#if -675105412 
associationsPerspective.addRule(new GoNamespaceToDiagram());
//#endif 


//#if 592575574 
associationsPerspective.addRule(new GoPackageToClass());
//#endif 


//#if 1708516670 
associationsPerspective.addRule(new GoClassToAssociatedClass());
//#endif 


//#if -2131410161 
ExplorerPerspective residencePerspective =
            new ExplorerPerspective(
            "combobox.item.residence-centric");
//#endif 


//#if -2005383910 
residencePerspective.addRule(new GoProjectToModel());
//#endif 


//#if 1787621634 
residencePerspective.addRule(new GoProjectToProfileConfiguration());
//#endif 


//#if -1219127038 
residencePerspective.addRule(new GoProfileConfigurationToProfile());
//#endif 


//#if -1749791606 
residencePerspective.addRule(new GoProfileToModel());
//#endif 


//#if 1297467744 
residencePerspective.addRule(new GoProfileToCritics());
//#endif 


//#if -897702385 
residencePerspective.addRule(new GoCriticsToCritic());
//#endif 


//#if -625575353 
residencePerspective.addRule(new GoModelToNode());
//#endif 


//#if 1709741969 
residencePerspective.addRule(new GoNodeToResidentComponent());
//#endif 


//#if 1952542364 
residencePerspective.addRule(new GoComponentToResidentModelElement());
//#endif 


//#if -1744805009 
ExplorerPerspective statePerspective =
            new ExplorerPerspective(
            "combobox.item.state-centric");
//#endif 


//#if -213035658 
statePerspective.addRule(new GoProjectToStateMachine());
//#endif 


//#if -1433078450 
statePerspective.addRule(new GoStatemachineToDiagram());
//#endif 


//#if 769284140 
statePerspective.addRule(new GoStateMachineToState());
//#endif 


//#if -1107167893 
statePerspective.addRule(new GoCompositeStateToSubvertex());
//#endif 


//#if -431599120 
statePerspective.addRule(new GoStateToIncomingTrans());
//#endif 


//#if -1159174806 
statePerspective.addRule(new GoStateToOutgoingTrans());
//#endif 


//#if -724020261 
statePerspective.addRule(new GoTransitiontoEffect());
//#endif 


//#if 985548353 
statePerspective.addRule(new GoTransitionToGuard());
//#endif 


//#if 807249423 
ExplorerPerspective transitionsPerspective =
            new ExplorerPerspective(
            "combobox.item.transitions-centric");
//#endif 


//#if 726781731 
transitionsPerspective.addRule(new GoProjectToStateMachine());
//#endif 


//#if -493261061 
transitionsPerspective.addRule(new GoStatemachineToDiagram());
//#endif 


//#if 1090598611 
transitionsPerspective.addRule(new GoStateMachineToTransition());
//#endif 


//#if -1133269256 
transitionsPerspective.addRule(new GoTransitionToSource());
//#endif 


//#if 464784750 
transitionsPerspective.addRule(new GoTransitionToTarget());
//#endif 


//#if 1529676110 
transitionsPerspective.addRule(new GoTransitiontoEffect());
//#endif 


//#if -1019961746 
transitionsPerspective.addRule(new GoTransitionToGuard());
//#endif 


//#if 1654554770 
ExplorerPerspective compositionPerspective =
            new ExplorerPerspective(
            "combobox.item.composite-centric");
//#endif 


//#if 739276982 
compositionPerspective.addRule(new GoProjectToModel());
//#endif 


//#if -1475636762 
compositionPerspective.addRule(new GoProjectToProfileConfiguration());
//#endif 


//#if -187418138 
compositionPerspective.addRule(new GoProfileConfigurationToProfile());
//#endif 


//#if 994869286 
compositionPerspective.addRule(new GoProfileToModel());
//#endif 


//#if 1806665212 
compositionPerspective.addRule(new GoProfileToCritics());
//#endif 


//#if -1712560653 
compositionPerspective.addRule(new GoCriticsToCritic());
//#endif 


//#if 1900447070 
compositionPerspective.addRule(new GoProjectToRoots());
//#endif 


//#if -776063031 
compositionPerspective.addRule(new GoModelElementToContents());
//#endif 


//#if -1590998070 
compositionPerspective.addRule(new GoModelElementToContainedDiagrams());
//#endif 


//#if -422449824 
Collection<ExplorerPerspective> c =
            new ArrayList<ExplorerPerspective>();
//#endif 


//#if -1102127705 
c.add(packagePerspective);
//#endif 


//#if 1188713845 
c.add(classPerspective);
//#endif 


//#if 1924804154 
c.add(diagramPerspective);
//#endif 


//#if -1293114333 
c.add(inheritancePerspective);
//#endif 


//#if -1761526531 
c.add(associationsPerspective);
//#endif 


//#if 1737896743 
c.add(residencePerspective);
//#endif 


//#if 352439036 
c.add(statePerspective);
//#endif 


//#if -124915793 
c.add(transitionsPerspective);
//#endif 


//#if -610737341 
c.add(compositionPerspective);
//#endif 


//#if -542336715 
return c;
//#endif 

} 

//#endif 


//#if -1614917427 
@Override
    public String toString()
    { 

//#if 449241730 
StringBuffer p = new StringBuffer();
//#endif 


//#if 513041237 
for (ExplorerPerspective perspective : getPerspectives()) //1
{ 

//#if 882940084 
String name = perspective.toString();
//#endif 


//#if -1673299453 
p.append(name).append(",");
//#endif 


//#if -335368115 
for (PerspectiveRule rule : perspective.getList()) //1
{ 

//#if -2029109911 
p.append(rule.getClass().getName()).append(",");
//#endif 

} 

//#endif 


//#if 1733864120 
p.deleteCharAt(p.length() - 1);
//#endif 


//#if 1961061412 
p.append(";");
//#endif 

} 

//#endif 


//#if -2118558090 
p.deleteCharAt(p.length() - 1);
//#endif 


//#if -404313723 
return p.toString();
//#endif 

} 

//#endif 


//#if -689071072 
public void addPerspective(ExplorerPerspective perspective)
    { 

//#if 366311754 
perspectives.add(perspective);
//#endif 


//#if 767932435 
for (PerspectiveManagerListener listener : perspectiveListeners) //1
{ 

//#if 294759839 
listener.addPerspective(perspective);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 939896119 
public void removePerspective(ExplorerPerspective perspective)
    { 

//#if -956109777 
perspectives.remove(perspective);
//#endif 


//#if 1239064443 
for (PerspectiveManagerListener listener : perspectiveListeners) //1
{ 

//#if -1528856170 
listener.removePerspective(perspective);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1797984238 
public void removeAllPerspectives()
    { 

//#if 1964594409 
List<ExplorerPerspective> pers = new ArrayList<ExplorerPerspective>();
//#endif 


//#if 704022499 
pers.addAll(getPerspectives());
//#endif 


//#if -101384915 
for (ExplorerPerspective perspective : pers) //1
{ 

//#if 1470829988 
removePerspective(perspective);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 646133918 
public List<ExplorerPerspective> getPerspectives()
    { 

//#if 1116207021 
return perspectives;
//#endif 

} 

//#endif 


//#if -629471345 
private PerspectiveManager()
    { 

//#if 196593093 
perspectiveListeners = new ArrayList<PerspectiveManagerListener>();
//#endif 


//#if 364851649 
perspectives = new ArrayList<ExplorerPerspective>();
//#endif 


//#if 222956718 
rules = new ArrayList<PerspectiveRule>();
//#endif 


//#if 636641954 
loadRules();
//#endif 

} 

//#endif 


//#if 128826467 
public void addRule(PerspectiveRule rule)
    { 

//#if 21859218 
rules.add(rule);
//#endif 

} 

//#endif 


//#if -1804715433 
public Collection<PerspectiveRule> getRules()
    { 

//#if -750223582 
return rules;
//#endif 

} 

//#endif 


//#if -2052874461 
public void saveUserPerspectives()
    { 

//#if 606147158 
Configuration.setString(Argo.KEY_USER_EXPLORER_PERSPECTIVES, this
                                .toString());
//#endif 

} 

//#endif 


//#if -1167590836 
public void loadUserPerspectives()
    { 

//#if 1197085790 
String userPerspectives =
            Configuration.getString(
                Argo.KEY_USER_EXPLORER_PERSPECTIVES, "");
//#endif 


//#if 1738885036 
StringTokenizer pst = new StringTokenizer(userPerspectives, ";");
//#endif 


//#if 2112071125 
if(pst.hasMoreTokens())//1
{ 

//#if 2072923379 
while (pst.hasMoreTokens()) //1
{ 

//#if -1805022467 
String perspective = pst.nextToken();
//#endif 


//#if -1225651229 
StringTokenizer perspectiveDetails =
                    new StringTokenizer(perspective, ",");
//#endif 


//#if -1642145829 
String perspectiveName = perspectiveDetails.nextToken();
//#endif 


//#if 82050570 
ExplorerPerspective userDefinedPerspective =
                    new ExplorerPerspective(perspectiveName);
//#endif 


//#if -42921349 
if(perspectiveDetails.hasMoreTokens())//1
{ 

//#if 745144791 
while (perspectiveDetails.hasMoreTokens()) //1
{ 

//#if 1295812506 
String ruleName = perspectiveDetails.nextToken();
//#endif 


//#if -1587321095 
try //1
{ 

//#if -563083270 
Class ruleClass = Class.forName(ruleName);
//#endif 


//#if -2038002939 
PerspectiveRule rule =
                                (PerspectiveRule) ruleClass.newInstance();
//#endif 


//#if -1259928857 
userDefinedPerspective.addRule(rule);
//#endif 

} 

//#if -1460226962 
catch (ClassNotFoundException e) //1
{ 

//#if 1389576723 
LOG.error(
                                "could not create rule " + ruleName
                                + " you can try to "
                                + "refresh the perspectives to the "
                                + "default settings.",
                                e);
//#endif 

} 

//#endif 


//#if 1413034292 
catch (InstantiationException e) //1
{ 

//#if -123634166 
LOG.error(
                                "could not create rule " + ruleName
                                + " you can try to "
                                + "refresh the perspectives to the "
                                + "default settings.",
                                e);
//#endif 

} 

//#endif 


//#if -738667103 
catch (IllegalAccessException e) //1
{ 

//#if -1448358564 
LOG.error(
                                "could not create rule " + ruleName
                                + " you can try to "
                                + "refresh the perspectives to the "
                                + "default settings.",
                                e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 
else
{ 

//#if 391839908 
continue;
//#endif 

} 

//#endif 


//#if -1994950845 
addPerspective(userDefinedPerspective);
//#endif 

} 

//#endif 

} 
else
{ 

//#if 5963854 
loadDefaultPerspectives();
//#endif 

} 

//#endif 


//#if -13595466 
if(getPerspectives().size() == 0)//1
{ 

//#if -107509079 
loadDefaultPerspectives();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1561199825 
public void loadRules()
    { 

//#if 1820158028 
PerspectiveRule[] ruleNamesArray = {new GoAssocRoleToMessages(),




                            new GoBehavioralFeatureToStateMachine(),
                            new GoClassifierToBehavioralFeature(),




                            new GoClassifierToInstance(),








                            new GoClassifierToStructuralFeature(),
                            new GoClassToAssociatedClass(), new GoClassToNavigableClass(),
                            new GoClassToSummary(),





                            new GoComponentToResidentModelElement(),




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




                            new GoModelToDiagrams(), new GoModelToElements(),
                            new GoModelToNode(), new GoNamespaceToClassifierAndPackage(),
                            new GoNamespaceToDiagram(), new GoNamespaceToOwnedElements(),
                            new GoNodeToResidentComponent(),









                            new GoPackageToElementImport(),




                            new GoProjectToDiagram(),




                            new GoProjectToProfileConfiguration(),
                            new GoProfileConfigurationToProfile(),
                            new GoProfileToModel(),





                            new GoProjectToRoots(),






                            new GoStateToDownstream(), new GoStateToEntry(),





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
//#endif 


//#if 501178957 
PerspectiveRule[] ruleNamesArray = {new GoAssocRoleToMessages(),


                            new GoBehavioralFeatureToStateDiagram(),

                            new GoBehavioralFeatureToStateMachine(),
                            new GoClassifierToBehavioralFeature(),


                            new GoClassifierToCollaboration(),

                            new GoClassifierToInstance(),


                            new GoClassifierToSequenceDiagram(),



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



                            new GoOperationToSequenceDiagram(), new GoPackageToClass(),

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
//#endif 


//#if 1617790378 
PerspectiveRule[] ruleNamesArray = {new GoAssocRoleToMessages(),


                            new GoBehavioralFeatureToStateDiagram(),

                            new GoBehavioralFeatureToStateMachine(),
                            new GoClassifierToBehavioralFeature(),


                            new GoClassifierToCollaboration(),

                            new GoClassifierToInstance(),


                            new GoClassifierToSequenceDiagram(),



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



                            new GoOperationToSequenceDiagram(), new GoPackageToClass(),

                            new GoPackageToElementImport(),


                            new GoProjectToCollaboration(),

                            new GoProjectToDiagram(),


                            new GoProjectToModel(), new GoProjectToStateMachine(),

                            new GoProjectToProfileConfiguration(),
                            new GoProfileConfigurationToProfile(),
                            new GoProfileToModel(),





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
//#endif 


//#if 1653733219 
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
//#endif 


//#if -1541469001 
PerspectiveRule[] ruleNamesArray = {new GoAssocRoleToMessages(),


                            new GoBehavioralFeatureToStateDiagram(),

                            new GoBehavioralFeatureToStateMachine(),
                            new GoClassifierToBehavioralFeature(),




                            new GoClassifierToInstance(),


                            new GoClassifierToSequenceDiagram(),



                            new GoClassifierToStateMachine(),

                            new GoClassifierToStructuralFeature(),
                            new GoClassToAssociatedClass(), new GoClassToNavigableClass(),
                            new GoClassToSummary(),





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




                            new GoModelToDiagrams(), new GoModelToElements(),
                            new GoModelToNode(), new GoNamespaceToClassifierAndPackage(),
                            new GoNamespaceToDiagram(), new GoNamespaceToOwnedElements(),
                            new GoNodeToResidentComponent(),







                            new GoOperationToSequenceDiagram(), new GoPackageToClass(),

                            new GoPackageToElementImport(),




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
//#endif 


//#if -344108737 
PerspectiveRule[] ruleNamesArray = {new GoAssocRoleToMessages(),




                            new GoBehavioralFeatureToStateMachine(),
                            new GoClassifierToBehavioralFeature(),


                            new GoClassifierToCollaboration(),

                            new GoClassifierToInstance(),


                            new GoClassifierToSequenceDiagram(),





                            new GoClassifierToStructuralFeature(),
                            new GoClassToAssociatedClass(), new GoClassToNavigableClass(),
                            new GoClassToSummary(),


                            new GoCollaborationToDiagram(),
                            new GoCollaborationToInteraction(),

                            new GoComponentToResidentModelElement(),




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



                            new GoOperationToSequenceDiagram(), new GoPackageToClass(),

                            new GoPackageToElementImport(),


                            new GoProjectToCollaboration(),

                            new GoProjectToDiagram(),




                            new GoProjectToProfileConfiguration(),
                            new GoProfileConfigurationToProfile(),
                            new GoProfileToModel(),


                            new GoProfileToCritics(),
                            new GoCriticsToCritic(),

                            new GoProjectToRoots(),






                            new GoStateToDownstream(), new GoStateToEntry(),





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
//#endif 


//#if 1005035637 
rules = Arrays.asList(ruleNamesArray);
//#endif 

} 

//#endif 


//#if -549665826 
public static PerspectiveManager getInstance()
    { 

//#if -271783539 
if(instance == null)//1
{ 

//#if -1210516540 
instance = new PerspectiveManager();
//#endif 

} 

//#endif 


//#if -1753054284 
return instance;
//#endif 

} 

//#endif 


//#if -696405936 
public void loadDefaultPerspectives()
    { 

//#if 196397102 
Collection<ExplorerPerspective> c = getDefaultPerspectives();
//#endif 


//#if -315754925 
addAllPerspectives(c);
//#endif 

} 

//#endif 


//#if 154907962 
public void removeRule(PerspectiveRule rule)
    { 

//#if -1623458245 
rules.remove(rule);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

