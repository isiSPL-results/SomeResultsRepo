
//#if 2116514179 
// Compilation Unit of /CrWrongDepEnds.java 
 

//#if -646407538 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 359615833 
import java.util.Collection;
//#endif 


//#if -2046915429 
import org.argouml.cognitive.Designer;
//#endif 


//#if 117606028 
import org.argouml.cognitive.ListSet;
//#endif 


//#if 728066221 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 1983094776 
import org.argouml.model.Model;
//#endif 


//#if -1640024710 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1855796131 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if -1513700838 
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
//#endif 


//#if 81712208 
import org.argouml.uml.diagram.ui.FigDependency;
//#endif 


//#if 1356999257 
public class CrWrongDepEnds extends 
//#if 1622098919 
CrUML
//#endif 

  { 

//#if 62156241 
private static final long serialVersionUID = -6587198606342935144L;
//#endif 


//#if -334569348 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 683883225 
if(!(dm instanceof UMLDeploymentDiagram))//1
{ 

//#if 375832046 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -271610031 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if -1297089607 
ListSet offs = computeOffenders(dd);
//#endif 


//#if -779395243 
if(offs == null)//1
{ 

//#if 1665993075 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1950813230 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -1229487995 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if 953425340 
if(!isActive())//1
{ 

//#if -1192650226 
return false;
//#endif 

} 

//#endif 


//#if 373694351 
ListSet offs = i.getOffenders();
//#endif 


//#if -1715685149 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) offs.get(0);
//#endif 


//#if -2138143257 
ListSet newOffs = computeOffenders(dd);
//#endif 


//#if -1304732257 
boolean res = offs.equals(newOffs);
//#endif 


//#if 1521246296 
return res;
//#endif 

} 

//#endif 


//#if 1267506353 
public CrWrongDepEnds()
    { 

//#if -1194810453 
setupHeadAndDesc();
//#endif 


//#if -1355311154 
addSupportedDecision(UMLDecision.PATTERNS);
//#endif 

} 

//#endif 


//#if -1208697593 
public ListSet computeOffenders(UMLDeploymentDiagram dd)
    { 

//#if 36840773 
Collection figs = dd.getLayer().getContents();
//#endif 


//#if -1493880634 
ListSet offs = null;
//#endif 


//#if 1602390641 
for (Object obj : figs) //1
{ 

//#if 559328968 
if(!(obj instanceof FigDependency))//1
{ 

//#if 451098011 
continue;
//#endif 

} 

//#endif 


//#if 639223838 
FigDependency figDependency = (FigDependency) obj;
//#endif 


//#if -1474234198 
if(!(Model.getFacade().isADependency(figDependency.getOwner())))//1
{ 

//#if -189902029 
continue;
//#endif 

} 

//#endif 


//#if 706345088 
Object dependency = figDependency.getOwner();
//#endif 


//#if -745664567 
Collection suppliers = Model.getFacade().getSuppliers(dependency);
//#endif 


//#if 1647784115 
int count = 0;
//#endif 


//#if 1628274076 
if(suppliers != null)//1
{ 

//#if 318243970 
for (Object moe : suppliers) //1
{ 

//#if -321160703 
if(Model.getFacade().isAObject(moe))//1
{ 

//#if 667268202 
Object objSup = moe;
//#endif 


//#if -10142274 
if(Model.getFacade().getElementResidences(objSup)
                                != null
                                && (Model.getFacade().getElementResidences(objSup)
                                    .size() > 0))//1
{ 

//#if 2039407654 
count += 2;
//#endif 

} 

//#endif 


//#if -1542078327 
if(Model.getFacade().getComponentInstance(objSup)
                                != null)//1
{ 

//#if 1028128093 
count++;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -792378839 
Collection clients = Model.getFacade().getClients(dependency);
//#endif 


//#if 846596260 
if(clients != null && (clients.size() > 0))//1
{ 

//#if 364993904 
for (Object moe : clients) //1
{ 

//#if -1860067008 
if(Model.getFacade().isAObject(moe))//1
{ 

//#if 902785976 
Object objCli = moe;
//#endif 


//#if -1897541858 
if(Model.getFacade().getElementResidences(objCli)
                                != null
                                && (Model.getFacade().getElementResidences(objCli)
                                    .size() > 0))//1
{ 

//#if 419274737 
count += 2;
//#endif 

} 

//#endif 


//#if -1415424681 
if(Model.getFacade().getComponentInstance(objCli)
                                != null)//1
{ 

//#if 847097399 
count++;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1425473922 
if(count == 3)//1
{ 

//#if 864925970 
if(offs == null)//1
{ 

//#if -1336669645 
offs = new ListSet();
//#endif 


//#if -1779723219 
offs.add(dd);
//#endif 

} 

//#endif 


//#if 2094186556 
offs.add(figDependency);
//#endif 


//#if 1788112457 
offs.add(figDependency.getSourcePortFig());
//#endif 


//#if 730775778 
offs.add(figDependency.getDestPortFig());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1621405070 
return offs;
//#endif 

} 

//#endif 


//#if 327971711 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 1603770876 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if -453554066 
ListSet offs = computeOffenders(dd);
//#endif 


//#if -1289147779 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

