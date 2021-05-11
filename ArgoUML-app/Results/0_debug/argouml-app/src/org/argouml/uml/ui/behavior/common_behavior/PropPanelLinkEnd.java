
//#if 1236483153 
// Compilation Unit of /PropPanelLinkEnd.java 
 

//#if -1184376208 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -1505123411 
import java.util.ArrayList;
//#endif 


//#if -1947387244 
import java.util.List;
//#endif 


//#if 1885265364 
import javax.swing.Action;
//#endif 


//#if -749077034 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 997519389 
import org.argouml.model.Model;
//#endif 


//#if -390010728 
import org.argouml.uml.ui.AbstractActionNavigate;
//#endif 


//#if 1884082463 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if 1430269461 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if -1543052161 
class ActionNavigateOppositeLinkEnd extends 
//#if 2031796088 
AbstractActionNavigate
//#endif 

  { 

//#if -44396687 
protected Object navigateTo(Object source)
    { 

//#if -1480684139 
Object link = Model.getFacade().getLink(source);
//#endif 


//#if 755351578 
List ends = new ArrayList(Model.getFacade().getConnections(link));
//#endif 


//#if 211325854 
int index = ends.indexOf(source);
//#endif 


//#if -1943004251 
if(ends.size() > index + 1)//1
{ 

//#if 1268227533 
return ends.get(index + 1);
//#endif 

} 

//#endif 


//#if 1276709056 
return ends.get(0);
//#endif 

} 

//#endif 


//#if -1652729668 
public ActionNavigateOppositeLinkEnd()
    { 

//#if 2106452952 
super("button.go-opposite", true);
//#endif 


//#if -759137359 
putValue(Action.SMALL_ICON,
                 ResourceLoaderWrapper.lookupIconResource("LinkEnd"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1284540437 
public class PropPanelLinkEnd extends 
//#if -755383933 
PropPanelModelElement
//#endif 

  { 

//#if -1128937550 
private static final long serialVersionUID = 666929091194719951L;
//#endif 


//#if -1644762949 
public PropPanelLinkEnd()
    { 

//#if -617381255 
super("label.association-link-end", lookupIcon("AssociationEnd"));
//#endif 


//#if 1591459317 
addField("label.name", getNameTextField());
//#endif 


//#if -1550437310 
addSeparator();
//#endif 


//#if -1278958000 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if -803179605 
addAction(new ActionNavigateOppositeLinkEnd());
//#endif 


//#if 1518155237 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

