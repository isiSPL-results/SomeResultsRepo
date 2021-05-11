
//#if -1390293235 
// Compilation Unit of /StylePanelFigRRect.java 
 

//#if -1696172238 
package org.argouml.ui;
//#endif 


//#if -351361354 
import javax.swing.JLabel;
//#endif 


//#if -1654353539 
import javax.swing.JTextField;
//#endif 


//#if -698171925 
import javax.swing.event.DocumentEvent;
//#endif 


//#if 1052613946 
import javax.swing.text.Document;
//#endif 


//#if 1298494913 
import org.argouml.i18n.Translator;
//#endif 


//#if 646622146 
import org.tigris.gef.presentation.FigRRect;
//#endif 


//#if 1250758630 
public class StylePanelFigRRect extends 
//#if -507051780 
StylePanelFig
//#endif 

  { 

//#if 2144855391 
private JLabel roundingLabel = new JLabel(Translator
            .localize("label.stylepane.rounding")
            + ": ");
//#endif 


//#if 889356671 
private JTextField roundingField = new JTextField();
//#endif 


//#if -240922492 
public StylePanelFigRRect()
    { 

//#if -82436820 
super();
//#endif 


//#if -1348893454 
Document roundingDoc = roundingField.getDocument();
//#endif 


//#if 1685803103 
roundingDoc.addDocumentListener(this);
//#endif 


//#if 609836876 
roundingLabel.setLabelFor(roundingField);
//#endif 


//#if -104728290 
add(roundingLabel);
//#endif 


//#if -902778460 
add(roundingField);
//#endif 

} 

//#endif 


//#if -116974870 
public void refresh()
    { 

//#if 1537663848 
super.refresh();
//#endif 


//#if 643065369 
String roundingStr =
            ((FigRRect) getPanelTarget()).getCornerRadius() + "";
//#endif 


//#if 1460747480 
roundingField.setText(roundingStr);
//#endif 

} 

//#endif 


//#if 862007355 
protected void setTargetRounding()
    { 

//#if 1183426774 
if(getPanelTarget() == null)//1
{ 

//#if 194580415 
return;
//#endif 

} 

//#endif 


//#if 302993684 
String roundingStr = roundingField.getText();
//#endif 


//#if -997394471 
if(roundingStr.length() == 0)//1
{ 

//#if -1120929268 
return;
//#endif 

} 

//#endif 


//#if -1914736503 
int r = Integer.parseInt(roundingStr);
//#endif 


//#if 1782221741 
((FigRRect) getPanelTarget()).setCornerRadius(r);
//#endif 


//#if -1104567293 
getPanelTarget().endTrans();
//#endif 

} 

//#endif 


//#if -1580544529 
public void insertUpdate(DocumentEvent e)
    { 

//#if -1772198850 
Document roundingDoc = roundingField.getDocument();
//#endif 


//#if 1016318741 
if(e.getDocument() == roundingDoc)//1
{ 

//#if -474293602 
setTargetRounding();
//#endif 

} 

//#endif 


//#if -1016079395 
super.insertUpdate(e);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

