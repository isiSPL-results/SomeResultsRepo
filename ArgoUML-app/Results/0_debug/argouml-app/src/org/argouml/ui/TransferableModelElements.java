
//#if 415436004 
// Compilation Unit of /TransferableModelElements.java 
 

//#if -1853761831 
package org.argouml.ui;
//#endif 


//#if 970392412 
import java.awt.datatransfer.DataFlavor;
//#endif 


//#if 1385934815 
import java.awt.datatransfer.Transferable;
//#endif 


//#if -314351000 
import java.awt.datatransfer.UnsupportedFlavorException;
//#endif 


//#if -1198464248 
import java.io.IOException;
//#endif 


//#if 1152329571 
import java.util.Collection;
//#endif 


//#if 282580897 
public class TransferableModelElements implements 
//#if -1445386662 
Transferable
//#endif 

  { 

//#if 1588154033 
public static final DataFlavor UML_COLLECTION_FLAVOR =
        new DataFlavor(Collection.class, "UML ModelElements Collection");
//#endif 


//#if -170097243 
private static DataFlavor[] flavors = {UML_COLLECTION_FLAVOR };
//#endif 


//#if 1687452192 
private Collection theModelElements;
//#endif 


//#if -334589149 
public boolean isDataFlavorSupported(DataFlavor dataFlavor)
    { 

//#if 1545430821 
return dataFlavor.match(UML_COLLECTION_FLAVOR);
//#endif 

} 

//#endif 


//#if 1898585878 
public TransferableModelElements(Collection data)
    { 

//#if 551394425 
theModelElements = data;
//#endif 

} 

//#endif 


//#if 934886643 
public DataFlavor[] getTransferDataFlavors()
    { 

//#if 1690461009 
return flavors;
//#endif 

} 

//#endif 


//#if -584590139 
public Object getTransferData(DataFlavor dataFlavor)
    throws UnsupportedFlavorException,
               IOException
    { 

//#if 1520331520 
if(dataFlavor.match(UML_COLLECTION_FLAVOR))//1
{ 

//#if -507269042 
return theModelElements;
//#endif 

} 

//#endif 


//#if -66766905 
throw new UnsupportedFlavorException(dataFlavor);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

