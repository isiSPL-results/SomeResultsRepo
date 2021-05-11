// Compilation Unit of /ArgoFigGroup.java 
 
package org.argouml.uml.diagram.ui;
import java.util.List;
import org.apache.log4j.Logger;
import org.argouml.kernel.Project;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigGroup;
public abstract class ArgoFigGroup extends FigGroup
 implements ArgoFig
  { 
private static final Logger LOG = Logger.getLogger(ArgoFigGroup.class);
private DiagramSettings settings;
@Deprecated
    public void setOwner(Object owner)
    { 
super.setOwner(owner);
} 

public DiagramSettings getSettings()
    { 
if(settings == null)//1
{ 
Project p = getProject();
if(p != null)//1
{ 
return p.getProjectSettings().getDefaultDiagramSettings();
} 

} 

return settings;
} 

public ArgoFigGroup(Object owner, DiagramSettings renderSettings)
    { 
super();
super.setOwner(owner);
settings = renderSettings;
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public Project getProject()
    { 
return ArgoFigUtil.getProject(this);
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public void setProject(Project project)
    { 
throw new UnsupportedOperationException();
} 

@Deprecated
    public ArgoFigGroup()
    { 
super();
} 

public void setSettings(DiagramSettings renderSettings)
    { 
settings = renderSettings;
renderingChanged();
} 

@Deprecated
    public ArgoFigGroup(List<ArgoFig> arg0)
    { 
super(arg0);
} 

public void renderingChanged()
    { 
for (Fig fig : (List<Fig>) getFigs()) //1
{ 
if(fig instanceof ArgoFig)//1
{ 
((ArgoFig) fig).renderingChanged();
} 
else
{ 
LOG.debug("Found non-Argo fig nested");
} 

} 

} 

 } 


