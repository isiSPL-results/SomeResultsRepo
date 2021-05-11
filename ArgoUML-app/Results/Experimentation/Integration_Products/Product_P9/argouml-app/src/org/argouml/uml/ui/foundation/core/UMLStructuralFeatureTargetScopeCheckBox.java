package org.argouml.uml.ui.foundation.core;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLCheckBox2;
@Deprecated
public class UMLStructuralFeatureTargetScopeCheckBox extends UMLCheckBox2
  { 
public void buildModel()
    { 
if(Model.getFacade().getTargetScope(getTarget()) == null)//1
{ 
Model.getCoreHelper().setTargetScope(getTarget(),
                                                 Model.getScopeKind().getInstance());
} 
setSelected(Model.getFacade().getTargetScope(getTarget()).equals(
                        Model.getScopeKind().getClassifier()));
} 
public UMLStructuralFeatureTargetScopeCheckBox()
    { 
super(Translator.localize("label.classifier"),
              ActionSetStructuralFeatureTargetScope.getInstance(),
              "targetScope");
} 

 } 
