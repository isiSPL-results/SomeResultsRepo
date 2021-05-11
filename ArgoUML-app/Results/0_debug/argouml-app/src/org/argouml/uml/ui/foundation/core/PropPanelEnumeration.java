
//#if -441468030 
// Compilation Unit of /PropPanelEnumeration.java 
 

//#if -1835201191 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 448441883 
import javax.swing.JList;
//#endif 


//#if 1368928068 
import javax.swing.JScrollPane;
//#endif 


//#if 1889785102 
import org.argouml.i18n.Translator;
//#endif 


//#if -1740091917 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if -658602278 
public class PropPanelEnumeration extends 
//#if -250993570 
PropPanelDataType
//#endif 

  { 

//#if -443485209 
private JScrollPane literalsScroll;
//#endif 


//#if -202321466 
private static UMLEnumerationLiteralsListModel literalsListModel =
        new UMLEnumerationLiteralsListModel();
//#endif 


//#if -1826705121 
@Override
    protected void addEnumerationButtons()
    { 

//#if 1140106624 
super.addEnumerationButtons();
//#endif 


//#if -1402441736 
addAction(new ActionAddLiteral());
//#endif 

} 

//#endif 


//#if 242652345 
public JScrollPane getLiteralsScroll()
    { 

//#if -837198980 
if(literalsScroll == null)//1
{ 

//#if -2030103074 
JList list = new UMLLinkedList(literalsListModel);
//#endif 


//#if -207693896 
literalsScroll = new JScrollPane(list);
//#endif 

} 

//#endif 


//#if -1928023893 
return literalsScroll;
//#endif 

} 

//#endif 


//#if 942677975 
public PropPanelEnumeration()
    { 

//#if 658936021 
super("label.enumeration-title", lookupIcon("Enumeration"));
//#endif 


//#if 1161347820 
addField(Translator.localize("label.literals"), getLiteralsScroll());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

