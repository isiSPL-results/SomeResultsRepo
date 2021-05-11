
//#if -1627943766 
// Compilation Unit of /SPFigEdgeModelElement.java 
 

//#if -31119707 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -1108865281 
import java.awt.event.ItemListener;
//#endif 


//#if -2143209246 
import javax.swing.text.Document;
//#endif 


//#if -2028133908 
import org.argouml.ui.StylePanelFig;
//#endif 


//#if 166955242 
import org.tigris.gef.ui.ColorRenderer;
//#endif 


//#if -1281889154 
public class SPFigEdgeModelElement extends 
//#if 2061000915 
StylePanelFig
//#endif 

 implements 
//#if 264585221 
ItemListener
//#endif 

  { 

//#if -626967567 
public SPFigEdgeModelElement()
    { 

//#if -436954567 
super("Edge Appearance");
//#endif 


//#if 1538593363 
initChoices();
//#endif 


//#if -1429035881 
Document bboxDoc = getBBoxField().getDocument();
//#endif 


//#if -1046098878 
bboxDoc.addDocumentListener(this);
//#endif 


//#if 226544594 
getLineField().addItemListener(this);
//#endif 


//#if -828203906 
getLineField().setRenderer(new ColorRenderer());
//#endif 


//#if 1385436892 
getBBoxLabel().setLabelFor(getBBoxField());
//#endif 


//#if -220112246 
add(getBBoxLabel());
//#endif 


//#if 1652820368 
add(getBBoxField());
//#endif 


//#if 1223964092 
getLineLabel().setLabelFor(getLineField());
//#endif 


//#if -1179142913 
add(getLineLabel());
//#endif 


//#if 693789701 
add(getLineField());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

