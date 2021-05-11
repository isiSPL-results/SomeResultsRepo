
//#if -1761172427 
// Compilation Unit of /FigStereotype.java 
 

//#if 1356828106 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 638511592 
import java.awt.Rectangle;
//#endif 


//#if -701140908 
import org.argouml.model.Model;
//#endif 


//#if -466053181 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if 853549692 
import org.argouml.notation.providers.uml.NotationUtilityUml;
//#endif 


//#if -950076873 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 554178123 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1732378978 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if -1073048926 
public class FigStereotype extends 
//#if 1274062556 
FigSingleLineText
//#endif 

  { 

//#if -751497559 
protected void updateLayout(UmlChangeEvent event)
    { 

//#if -293000993 
assert event != null;
//#endif 


//#if 834149028 
Rectangle oldBounds = getBounds();
//#endif 


//#if -590285594 
setText();
//#endif 


//#if -192706068 
if(oldBounds != getBounds())//1
{ 

//#if 1339370579 
setBounds(getBounds());
//#endif 

} 

//#endif 


//#if 1390027077 
if(getGroup() != null)//1
{ 

//#if 1711874407 
getGroup().calcBounds();
//#endif 


//#if 1830157748 
getGroup().setBounds(getGroup().getBounds());
//#endif 


//#if 1795722284 
if(oldBounds != getBounds())//1
{ 

//#if 864846902 
Fig sg = getGroup().getGroup();
//#endif 


//#if -1917047194 
if(sg != null)//1
{ 

//#if -193361140 
sg.calcBounds();
//#endif 


//#if -782724231 
sg.setBounds(sg.getBounds());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1096358512 
damage();
//#endif 

} 

//#endif 


//#if 218535204 
public void setText(String text)
    { 

//#if 1715670705 
super.setText(NotationUtilityUml.formatStereotype(text,
                      getSettings().getNotationSettings().isUseGuillemets()));
//#endif 


//#if 1872657154 
damage();
//#endif 

} 

//#endif 


//#if 1519965847 
private void initialize()
    { 

//#if -911539002 
setEditable(false);
//#endif 


//#if 645678730 
setTextColor(TEXT_COLOR);
//#endif 


//#if 1835875089 
setTextFilled(false);
//#endif 


//#if 1564106750 
setJustification(FigText.JUSTIFY_CENTER);
//#endif 


//#if 1759261906 
setRightMargin(3);
//#endif 


//#if -1465933625 
setLeftMargin(3);
//#endif 

} 

//#endif 


//#if -235496484 
public FigStereotype(Object owner, Rectangle bounds,
                         DiagramSettings settings)
    { 

//#if -53605353 
super(owner, bounds, settings, true,
              new String[] {"name"});
//#endif 


//#if -2012026730 
assert owner != null;
//#endif 


//#if -1799993505 
initialize();
//#endif 


//#if 1427096278 
setText();
//#endif 

} 

//#endif 


//#if -1402383199 
@Override
    public void setLineWidth(int w)
    { 

//#if 901374742 
super.setLineWidth(0);
//#endif 

} 

//#endif 


//#if 1022577929 
@Override
    protected void setText()
    { 

//#if 128206617 
setText(Model.getFacade().getName(getOwner()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

