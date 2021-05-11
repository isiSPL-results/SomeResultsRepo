package org.argouml.language.ui;
import java.awt.Dimension;
import java.util.Iterator;
import javax.swing.JComboBox;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoGeneratorEvent;
import org.argouml.application.events.ArgoGeneratorEventListener;
import org.argouml.uml.generator.GeneratorManager;
import org.argouml.uml.generator.Language;
public class LanguageComboBox extends JComboBox
 implements ArgoGeneratorEventListener
  { 
public void refresh()
    { 
removeAllItems();
Iterator iterator =
            GeneratorManager.getInstance().getLanguages().iterator();
while (iterator.hasNext()) //1
{ 
try//1
{ 
Language ll = (Language) iterator.next();
addItem(ll);
} 
catch (Exception e) //1
{ 
} 
} 
setVisible(true);
invalidate();
} 
public LanguageComboBox()
    { 
super();
setEditable(false);
setMaximumRowCount(6);
Dimension d = getPreferredSize();
d.width = 200;
setMaximumSize(d);
ArgoEventPump.addListener(ArgoEventTypes.ANY_GENERATOR_EVENT, this);
refresh();
} 
public void generatorRemoved(ArgoGeneratorEvent e)
    { 
refresh();
} 
public void generatorChanged(ArgoGeneratorEvent e)
    { 
refresh();
} 
public void generatorAdded(ArgoGeneratorEvent e)
    { 
refresh();
} 
protected void finalize()
    { 
ArgoEventPump.removeListener(this);
} 

 } 
