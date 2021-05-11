// Compilation Unit of /FigKeyword.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.Rectangle;
import org.argouml.notation.providers.uml.NotationUtilityUml;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.presentation.FigText;
public class FigKeyword extends FigSingleLineText
  { 
private final String keywordText;
@Override
    protected void setText()
    { 
setText(keywordText);
} 

private void initialize()
    { 
setEditable(false);
setTextColor(TEXT_COLOR);
setTextFilled(false);
setJustification(FigText.JUSTIFY_CENTER);
setRightMargin(3);
setLeftMargin(3);
super.setLineWidth(0);
} 

@Override
    public void setLineWidth(int w)
    { 
super.setLineWidth(0);
} 

public FigKeyword(String keyword, Rectangle bounds,
                      DiagramSettings settings)
    { 
super(bounds, settings, true);
initialize();
keywordText = keyword;
setText(keyword);
} 

@Override
    public void setText(String text)
    { 
assert keywordText.equals(text);
super.setText(NotationUtilityUml.formatStereotype(text,
                      getSettings().getNotationSettings().isUseGuillemets()));
} 

 } 


