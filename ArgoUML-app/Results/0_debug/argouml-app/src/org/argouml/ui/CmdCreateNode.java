
//#if 274883802 
// Compilation Unit of /CmdCreateNode.java 
 

//#if -1411836678 
package org.argouml.ui;
//#endif 


//#if 1892435938 
import javax.swing.Action;
//#endif 


//#if 1553557768 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 884057993 
import org.argouml.i18n.Translator;
//#endif 


//#if 1891475151 
import org.argouml.model.Model;
//#endif 


//#if 1371612687 
import org.tigris.gef.base.CreateNodeAction;
//#endif 


//#if 1932123391 
public class CmdCreateNode extends 
//#if 1731062132 
CreateNodeAction
//#endif 

  { 

//#if -1031612961 
private static final long serialVersionUID = 4813526025971574818L;
//#endif 


//#if 1457357328 
private void putToolTip(String name)
    { 

//#if 1386812294 
putValue(Action.SHORT_DESCRIPTION, Translator.localize(name));
//#endif 

} 

//#endif 


//#if 1393911061 
public CmdCreateNode(Object nodeType, String name)
    { 

//#if -970989658 
super(nodeType,
              name,
              ResourceLoaderWrapper.lookupIconResource(
                  ResourceLoaderWrapper.getImageBinding(name)));
//#endif 


//#if -223422583 
putToolTip(name);
//#endif 

} 

//#endif 


//#if 1354272229 
@Override
    public Object makeNode()
    { 

//#if 1720734586 
Object newNode = Model.getUmlFactory().buildNode(getArg("className"));
//#endif 


//#if -2083518663 
return newNode;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

