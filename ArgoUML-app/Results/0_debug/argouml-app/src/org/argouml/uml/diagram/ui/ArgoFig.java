
//#if -1277943166 
// Compilation Unit of /ArgoFig.java 
 

//#if 405438518 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 2066428552 
import java.awt.Color;
//#endif 


//#if -1359673782 
import org.argouml.kernel.Project;
//#endif 


//#if 1796582051 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1384405314 
public interface ArgoFig  { 

//#if 1144316345 
static final int X0 = 10;
//#endif 


//#if 1172945496 
static final int Y0 = 10;
//#endif 


//#if 1762886670 
public static final int ROWHEIGHT = 17;
//#endif 


//#if 1618533729 
public static final int STEREOHEIGHT = 18;
//#endif 


//#if 37359402 
static final int LINE_WIDTH = 1;
//#endif 


//#if 234921622 
static final Color LINE_COLOR = Color.black;
//#endif 


//#if -1217723337 
static final Color SOLID_FILL_COLOR = LINE_COLOR;
//#endif 


//#if -1330429507 
static final Color FILL_COLOR = Color.white;
//#endif 


//#if -613101129 
static final Color INVISIBLE_LINE_COLOR = FILL_COLOR;
//#endif 


//#if 1441506493 
static final Color TEXT_COLOR = Color.black;
//#endif 


//#if 1317547857 
static final Color DEBUG_COLOR = Color.cyan;
//#endif 


//#if -1148508521 
@Deprecated
    public void setOwner(Object owner);
//#endif 


//#if -1515234500 
@Deprecated
    public Project getProject();
//#endif 


//#if -1786453727 
public void renderingChanged();
//#endif 


//#if 2059972136 
public DiagramSettings getSettings();
//#endif 


//#if 54186989 
@Deprecated
    public void setProject(Project project);
//#endif 


//#if 2011472363 
public void setSettings(DiagramSettings settings);
//#endif 

 } 

//#endif 


//#endif 

