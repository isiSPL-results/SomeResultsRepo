
//#if -292635671 
// Compilation Unit of /FigLink.java 
 

//#if -1502012099 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -1802149937 
import org.argouml.model.Model;
//#endif 


//#if 1067357106 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1253294228 
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
//#endif 


//#if -509351680 
import org.argouml.uml.diagram.ui.FigTextGroup;
//#endif 


//#if 1905666075 
import org.argouml.uml.diagram.ui.PathItemPlacement;
//#endif 


//#if 820665030 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 608779109 
public class FigLink extends 
//#if -2130615467 
FigEdgeModelElement
//#endif 

  { 

//#if -559647549 
private FigTextGroup middleGroup;
//#endif 


//#if -656309182 

//#if 4615278 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigLink()
    { 

//#if 1789297466 
middleGroup = new FigTextGroup();
//#endif 


//#if -430221521 
initialize();
//#endif 

} 

//#endif 


//#if -221106105 
protected Object getDestination()
    { 

//#if 1217733961 
if(getOwner() != null)//1
{ 

//#if -150671346 
return Model.getCommonBehaviorHelper().getDestination(getOwner());
//#endif 

} 

//#endif 


//#if -1783976711 
return null;
//#endif 

} 

//#endif 


//#if 833134729 
private void initialize()
    { 

//#if -938292469 
middleGroup.addFig(getNameFig());
//#endif 


//#if 564150649 
addPathItem(middleGroup,
                    new PathItemPlacement(this, middleGroup, 50, 25));
//#endif 


//#if -1490733696 
getNameFig().setUnderline(true);
//#endif 


//#if -1908657262 
getFig().setLineColor(LINE_COLOR);
//#endif 


//#if 1755250713 
setBetweenNearestPoints(true);
//#endif 

} 

//#endif 


//#if -115127132 
protected Object getSource()
    { 

//#if 186953264 
if(getOwner() != null)//1
{ 

//#if 1050076160 
return Model.getCommonBehaviorHelper().getSource(getOwner());
//#endif 

} 

//#endif 


//#if -842327968 
return null;
//#endif 

} 

//#endif 


//#if -599860891 
protected void updateNameText()
    { 

//#if 283407811 
if(getOwner() == null)//1
{ 

//#if -1532714652 
return;
//#endif 

} 

//#endif 


//#if -926424256 
String nameString = "";
//#endif 


//#if -289130565 
Object association = Model.getFacade().getAssociation(getOwner());
//#endif 


//#if -272033674 
if(association != null)//1
{ 

//#if 153221218 
nameString = Model.getFacade().getName(association);
//#endif 


//#if -3334915 
if(nameString == null)//1
{ 

//#if 1451763708 
nameString = "";
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2005000420 
getNameFig().setText(nameString);
//#endif 


//#if 10438043 
calcBounds();
//#endif 


//#if -1110174056 
setBounds(getBounds());
//#endif 

} 

//#endif 


//#if -2118617370 
@Deprecated
    public FigLink(Object edge)
    { 

//#if 351655805 
this();
//#endif 


//#if -1347593273 
setOwner(edge);
//#endif 

} 

//#endif 


//#if 877017184 
protected boolean canEdit(Fig f)
    { 

//#if 1159995537 
return false;
//#endif 

} 

//#endif 


//#if -243649109 
protected void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if 1526019592 
if(oldOwner != null)//1
{ 

//#if -955084950 
removeElementListener(oldOwner);
//#endif 


//#if -1395481019 
Object oldAssociation = Model.getFacade().getAssociation(oldOwner);
//#endif 


//#if 1607527008 
if(oldAssociation != null)//1
{ 

//#if -504263260 
removeElementListener(oldAssociation);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 529643887 
if(newOwner != null)//1
{ 

//#if 1579547504 
addElementListener(newOwner,
                               new String[] {"remove", "name", "association"});
//#endif 


//#if 2033949464 
Object newAssociation = Model.getFacade().getAssociation(newOwner);
//#endif 


//#if -1861224606 
if(newAssociation != null)//1
{ 

//#if -347333387 
addElementListener(newAssociation, "name");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1366445841 
public FigLink(Object element, DiagramSettings settings)
    { 

//#if -1817326323 
super(element, settings);
//#endif 


//#if -952600883 
middleGroup = new FigTextGroup(element, settings);
//#endif 


//#if 1118586799 
initialize();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

