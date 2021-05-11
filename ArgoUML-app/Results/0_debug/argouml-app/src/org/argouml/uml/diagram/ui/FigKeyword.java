
//#if -477904774 
// Compilation Unit of /FigKeyword.java 
 

//#if 42267917 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -204293307 
import java.awt.Rectangle;
//#endif 


//#if 238693375 
import org.argouml.notation.providers.uml.NotationUtilityUml;
//#endif 


//#if 1298961658 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 737506017 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 2140648534 
public class FigKeyword extends 
//#if 351274742 
FigSingleLineText
//#endif 

  { 

//#if -107219360 
private final String keywordText;
//#endif 


//#if 1137932195 
@Override
    protected void setText()
    { 

//#if -360316572 
setText(keywordText);
//#endif 

} 

//#endif 


//#if -571327695 
private void initialize()
    { 

//#if 1886768021 
setEditable(false);
//#endif 


//#if -440109543 
setTextColor(TEXT_COLOR);
//#endif 


//#if -1935570400 
setTextFilled(false);
//#endif 


//#if -886599283 
setJustification(FigText.JUSTIFY_CENTER);
//#endif 


//#if -1891248093 
setRightMargin(3);
//#endif 


//#if 633065302 
setLeftMargin(3);
//#endif 


//#if -1636638021 
super.setLineWidth(0);
//#endif 

} 

//#endif 


//#if -1551785029 
@Override
    public void setLineWidth(int w)
    { 

//#if 895644446 
super.setLineWidth(0);
//#endif 

} 

//#endif 


//#if -683760369 
public FigKeyword(String keyword, Rectangle bounds,
                      DiagramSettings settings)
    { 

//#if -2004250291 
super(bounds, settings, true);
//#endif 


//#if -2088446340 
initialize();
//#endif 


//#if -233322553 
keywordText = keyword;
//#endif 


//#if -174102700 
setText(keyword);
//#endif 

} 

//#endif 


//#if 11423264 
@Override
    public void setText(String text)
    { 

//#if 2053152948 
assert keywordText.equals(text);
//#endif 


//#if -196474812 
super.setText(NotationUtilityUml.formatStereotype(text,
                      getSettings().getNotationSettings().isUseGuillemets()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

