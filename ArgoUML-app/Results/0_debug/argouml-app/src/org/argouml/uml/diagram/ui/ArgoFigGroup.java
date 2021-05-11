
//#if -1668246591 
// Compilation Unit of /ArgoFigGroup.java 
 

//#if -1649235652 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -84442165 
import java.util.List;
//#endif 


//#if 378857811 
import org.apache.log4j.Logger;
//#endif 


//#if 652256388 
import org.argouml.kernel.Project;
//#endif 


//#if 2008709801 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1327245501 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1639292538 
import org.tigris.gef.presentation.FigGroup;
//#endif 


//#if -1155030796 
public abstract class ArgoFigGroup extends 
//#if 1238352271 
FigGroup
//#endif 

 implements 
//#if 1403133239 
ArgoFig
//#endif 

  { 

//#if 1457945678 
private static final Logger LOG = Logger.getLogger(ArgoFigGroup.class);
//#endif 


//#if 1232895153 
private DiagramSettings settings;
//#endif 


//#if 1487544336 
@Deprecated
    public void setOwner(Object owner)
    { 

//#if 380137612 
super.setOwner(owner);
//#endif 

} 

//#endif 


//#if 724644001 
public DiagramSettings getSettings()
    { 

//#if 867690838 
if(settings == null)//1
{ 

//#if 21041754 
Project p = getProject();
//#endif 


//#if 220025657 
if(p != null)//1
{ 

//#if 1825897739 
return p.getProjectSettings().getDefaultDiagramSettings();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1975412705 
return settings;
//#endif 

} 

//#endif 


//#if 1794493641 
public ArgoFigGroup(Object owner, DiagramSettings renderSettings)
    { 

//#if -2023899699 
super();
//#endif 


//#if -1921839665 
super.setOwner(owner);
//#endif 


//#if 1904258966 
settings = renderSettings;
//#endif 

} 

//#endif 


//#if -570350731 

//#if 1904765885 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public Project getProject()
    { 

//#if -2026405623 
return ArgoFigUtil.getProject(this);
//#endif 

} 

//#endif 


//#if -1643520492 

//#if -39794048 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public void setProject(Project project)
    { 

//#if -1788431166 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 670506781 
@Deprecated
    public ArgoFigGroup()
    { 

//#if -904060067 
super();
//#endif 

} 

//#endif 


//#if -1839782034 
public void setSettings(DiagramSettings renderSettings)
    { 

//#if -1569210140 
settings = renderSettings;
//#endif 


//#if -963686090 
renderingChanged();
//#endif 

} 

//#endif 


//#if 1940258410 
@Deprecated
    public ArgoFigGroup(List<ArgoFig> arg0)
    { 

//#if 2079724199 
super(arg0);
//#endif 

} 

//#endif 


//#if 1429926490 
public void renderingChanged()
    { 

//#if -2042741821 
for (Fig fig : (List<Fig>) getFigs()) //1
{ 

//#if -1102020887 
if(fig instanceof ArgoFig)//1
{ 

//#if 420229277 
((ArgoFig) fig).renderingChanged();
//#endif 

} 
else
{ 

//#if 2055303187 
LOG.debug("Found non-Argo fig nested");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

