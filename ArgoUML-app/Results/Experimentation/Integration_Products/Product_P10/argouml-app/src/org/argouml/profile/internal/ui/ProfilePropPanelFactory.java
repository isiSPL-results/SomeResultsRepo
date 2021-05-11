package org.argouml.profile.internal.ui;
import org.argouml.uml.cognitive.critics.CrUML;
import org.argouml.uml.ui.PropPanel;
import org.argouml.uml.ui.PropPanelFactory;
public class ProfilePropPanelFactory implements PropPanelFactory
  { 
public PropPanel createPropPanel(Object object)
    { 
if(object instanceof CrUML)//1
{ 
return new PropPanelCritic();
} 
else
{ 
return null;
} 
} 

 } 
