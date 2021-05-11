// Compilation Unit of /StartCritics.java 
 

//#if COGNITIVE 
package org.argouml.application;
//#endif 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.application.api.Argo;
//#endif 


//#if COGNITIVE 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Designer;
//#endif 


//#if COGNITIVE 
import org.argouml.configuration.Configuration;
//#endif 


//#if COGNITIVE 
import org.argouml.kernel.Project;
//#endif 


//#if COGNITIVE 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if COGNITIVE 
import org.argouml.model.Model;
//#endif 


//#if COGNITIVE 
import org.argouml.pattern.cognitive.critics.InitPatternCritics;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.ChildGenUML;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.InitCognitiveCritics;
//#endif 


//#if COGNITIVE 
public class StartCritics implements Runnable
  { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
private static final Logger LOG = Logger.getLogger(StartCritics.class);
//#endif 

public void run()
    { 
Designer dsgr = Designer.theDesigner();
SubsystemUtility.initSubsystem(new InitCognitiveCritics());
SubsystemUtility.initSubsystem(new InitPatternCritics());
org.argouml.uml.cognitive.checklist.Init.init();
dsgr.setClarifier(ResourceLoaderWrapper.lookupIconResource("PostItD0"));
dsgr.setDesignerName(Configuration.getString(Argo.KEY_USER_FULLNAME));
Configuration.addListener(Argo.KEY_USER_FULLNAME, dsgr);
Project p = ProjectManager.getManager().getCurrentProject();
dsgr.spawnCritiquer(p);
dsgr.setChildGenerator(new ChildGenUML());
for (Object model : p.getUserDefinedModelList()) //1
{ 
Model.getPump().addModelEventListener(dsgr, model);
} 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.info("spawned critiquing thread");
//#endif 

dsgr.getDecisionModel().startConsidering(UMLDecision.CLASS_SELECTION);
dsgr.getDecisionModel().startConsidering(UMLDecision.BEHAVIOR);
dsgr.getDecisionModel().startConsidering(UMLDecision.NAMING);
dsgr.getDecisionModel().startConsidering(UMLDecision.STORAGE);
dsgr.getDecisionModel().startConsidering(UMLDecision.INHERITANCE);
dsgr.getDecisionModel().startConsidering(UMLDecision.CONTAINMENT);
dsgr.getDecisionModel()
        .startConsidering(UMLDecision.PLANNED_EXTENSIONS);
dsgr.getDecisionModel().startConsidering(UMLDecision.STATE_MACHINES);
dsgr.getDecisionModel().startConsidering(UMLDecision.PATTERNS);
dsgr.getDecisionModel().startConsidering(UMLDecision.RELATIONSHIPS);
dsgr.getDecisionModel().startConsidering(UMLDecision.INSTANCIATION);
dsgr.getDecisionModel().startConsidering(UMLDecision.MODULARITY);
dsgr.getDecisionModel().startConsidering(UMLDecision.EXPECTED_USAGE);
dsgr.getDecisionModel().startConsidering(UMLDecision.METHODS);
dsgr.getDecisionModel().startConsidering(UMLDecision.CODE_GEN);
dsgr.getDecisionModel().startConsidering(UMLDecision.STEREOTYPES);
Designer.setUserWorking(true);
} 

 } 

//#endif 


