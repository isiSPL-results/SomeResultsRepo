
//#if -150845706 
// Compilation Unit of /StartCritics.java 
 

//#if 1675274283 
package org.argouml.application;
//#endif 


//#if 759446089 
import org.apache.log4j.Logger;
//#endif 


//#if -1000178933 
import org.argouml.application.api.Argo;
//#endif 


//#if 2128745269 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -841121193 
import org.argouml.cognitive.Designer;
//#endif 


//#if -714065630 
import org.argouml.configuration.Configuration;
//#endif 


//#if 43984846 
import org.argouml.kernel.Project;
//#endif 


//#if -1680406693 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1687984708 
import org.argouml.model.Model;
//#endif 


//#if 1398303030 
import org.argouml.pattern.cognitive.critics.InitPatternCritics;
//#endif 


//#if 703566910 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 1939018621 
import org.argouml.uml.cognitive.critics.ChildGenUML;
//#endif 


//#if -135139004 
import org.argouml.uml.cognitive.critics.InitCognitiveCritics;
//#endif 


//#if -357959287 
public class StartCritics implements 
//#if -1751350023 
Runnable
//#endif 

  { 

//#if 2122818063 
private static final Logger LOG = Logger.getLogger(StartCritics.class);
//#endif 


//#if 682741299 
public void run()
    { 

//#if 106915702 
Designer dsgr = Designer.theDesigner();
//#endif 


//#if -1735343397 
SubsystemUtility.initSubsystem(new InitCognitiveCritics());
//#endif 


//#if 1223740325 
SubsystemUtility.initSubsystem(new InitPatternCritics());
//#endif 


//#if -1099488980 
org.argouml.uml.cognitive.checklist.Init.init();
//#endif 


//#if 1706623339 
dsgr.setClarifier(ResourceLoaderWrapper.lookupIconResource("PostItD0"));
//#endif 


//#if 473623058 
dsgr.setDesignerName(Configuration.getString(Argo.KEY_USER_FULLNAME));
//#endif 


//#if 1002369159 
Configuration.addListener(Argo.KEY_USER_FULLNAME, dsgr);
//#endif 


//#if -54802183 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 2004710662 
dsgr.spawnCritiquer(p);
//#endif 


//#if 1913214889 
dsgr.setChildGenerator(new ChildGenUML());
//#endif 


//#if 1593872334 
for (Object model : p.getUserDefinedModelList()) //1
{ 

//#if 1668682371 
Model.getPump().addModelEventListener(dsgr, model);
//#endif 

} 

//#endif 


//#if 11456032 
LOG.info("spawned critiquing thread");
//#endif 


//#if 72554311 
dsgr.getDecisionModel().startConsidering(UMLDecision.CLASS_SELECTION);
//#endif 


//#if 1186454772 
dsgr.getDecisionModel().startConsidering(UMLDecision.BEHAVIOR);
//#endif 


//#if 1524192682 
dsgr.getDecisionModel().startConsidering(UMLDecision.NAMING);
//#endif 


//#if 332343517 
dsgr.getDecisionModel().startConsidering(UMLDecision.STORAGE);
//#endif 


//#if -959681684 
dsgr.getDecisionModel().startConsidering(UMLDecision.INHERITANCE);
//#endif 


//#if 52790484 
dsgr.getDecisionModel().startConsidering(UMLDecision.CONTAINMENT);
//#endif 


//#if 453625073 
dsgr.getDecisionModel()
        .startConsidering(UMLDecision.PLANNED_EXTENSIONS);
//#endif 


//#if 1917943228 
dsgr.getDecisionModel().startConsidering(UMLDecision.STATE_MACHINES);
//#endif 


//#if 13291845 
dsgr.getDecisionModel().startConsidering(UMLDecision.PATTERNS);
//#endif 


//#if -1262237795 
dsgr.getDecisionModel().startConsidering(UMLDecision.RELATIONSHIPS);
//#endif 


//#if -1363023842 
dsgr.getDecisionModel().startConsidering(UMLDecision.INSTANCIATION);
//#endif 


//#if -1330738298 
dsgr.getDecisionModel().startConsidering(UMLDecision.MODULARITY);
//#endif 


//#if -2012405284 
dsgr.getDecisionModel().startConsidering(UMLDecision.EXPECTED_USAGE);
//#endif 


//#if 2083897428 
dsgr.getDecisionModel().startConsidering(UMLDecision.METHODS);
//#endif 


//#if 1224520064 
dsgr.getDecisionModel().startConsidering(UMLDecision.CODE_GEN);
//#endif 


//#if 14435 
dsgr.getDecisionModel().startConsidering(UMLDecision.STEREOTYPES);
//#endif 


//#if 873500750 
Designer.setUserWorking(true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

