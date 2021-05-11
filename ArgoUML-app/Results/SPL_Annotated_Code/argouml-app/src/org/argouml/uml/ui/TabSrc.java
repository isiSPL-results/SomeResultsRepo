// Compilation Unit of /TabSrc.java 
 
package org.argouml.uml.ui;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JComboBox;
import org.apache.log4j.Logger;
import org.argouml.application.api.Predicate;
import org.argouml.language.ui.LanguageComboBox;
import org.argouml.model.Model;
import org.argouml.ui.TabText;
import org.argouml.uml.generator.GeneratorHelper;
import org.argouml.uml.generator.Language;
import org.argouml.uml.generator.SourceUnit;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigEdge;
import org.tigris.gef.presentation.FigNode;
public class TabSrc extends TabText
 implements ItemListener
  { 
private static final long serialVersionUID = -4958164807996827484L;
private static final Logger LOG = Logger.getLogger(TabSrc.class);
private Language langName = null;
private String fileName = null;
private SourceUnit[] files = null;
private LanguageComboBox cbLang = new LanguageComboBox();
private JComboBox cbFiles = new JComboBox();
private static List<Predicate> predicates;
public TabSrc()
    { 
super("tab.source", true);
if(predicates == null)//1
{ 
predicates = new ArrayList<Predicate>();
predicates.add(new DefaultPredicate());
} 

setEditable(false);
langName = (Language) cbLang.getSelectedItem();
fileName = null;
getToolbar().add(cbLang);
getToolbar().addSeparator();
cbLang.addItemListener(this);
getToolbar().add(cbFiles);
getToolbar().addSeparator();
cbFiles.addItemListener(this);
} 

@Override
    protected String genText(Object modelObject)
    { 
if(files == null)//1
{ 
generateSource(modelObject);
} 

if(files != null && files.length > cbFiles.getSelectedIndex())//1
{ 
return files[cbFiles.getSelectedIndex()].getContent();
} 

return null;
} 

public static void addPredicate(Predicate predicate)
    { 
predicates.add(predicate);
} 

private void generateSource(Object elem)
    { 
LOG.debug("TabSrc.genText(): getting src for "
                  + Model.getFacade().getName(elem));
Collection code =
            GeneratorHelper.generate(langName, elem, false);
cbFiles.removeAllItems();
if(!code.isEmpty())//1
{ 
files = new SourceUnit[code.size()];
files = (SourceUnit[]) code.toArray(files);
for (int i = 0; i < files.length; i++) //1
{ 
StringBuilder title = new StringBuilder(files[i].getName());
if(files[i].getBasePath().length() > 0)//1
{ 
title.append(" ( " + files[i].getFullName() + ")");
} 

cbFiles.addItem(title.toString());
} 

} 

} 

@Override
    public boolean shouldBeEnabled(Object target)
    { 
target = (target instanceof Fig) ? ((Fig) target).getOwner() : target;
setShouldBeEnabled(false);
for (Predicate p : predicates) //1
{ 
if(p.evaluate(target))//1
{ 
setShouldBeEnabled(true);
} 

} 

return shouldBeEnabled();
} 

public void itemStateChanged(ItemEvent event)
    { 
if(event.getSource() == cbLang)//1
{ 
if(event.getStateChange() == ItemEvent.SELECTED)//1
{ 
Language newLang = (Language) cbLang.getSelectedItem();
if(!newLang.equals(langName))//1
{ 
langName = newLang;
refresh();
} 

} 

} 
else
if(event.getSource() == cbFiles)//1
{ 
if(event.getStateChange() == ItemEvent.SELECTED)//1
{ 
String newFile = (String) cbFiles.getSelectedItem();
if(!newFile.equals(fileName))//1
{ 
fileName = newFile;
super.setTarget(getTarget());
} 

} 

} 


} 

@Override
    public void refresh()
    { 
setTarget(getTarget());
} 

@Override
    protected void finalize()
    { 
cbLang.removeItemListener(this);
} 

@Override
    protected void parseText(String s)
    { 
LOG.debug("TabSrc   setting src for "
                  + Model.getFacade().getName(getTarget()));
Object modelObject = getTarget();
if(getTarget() instanceof FigNode)//1
{ 
modelObject = ((FigNode) getTarget()).getOwner();
} 

if(getTarget() instanceof FigEdge)//1
{ 
modelObject = ((FigEdge) getTarget()).getOwner();
} 

if(modelObject == null)//1
{ 
return;
} 

} 

@Override
    public void setTarget(Object t)
    { 
Object modelTarget = (t instanceof Fig) ? ((Fig) t).getOwner() : t;
setShouldBeEnabled(Model.getFacade().isAClassifier(modelTarget));
cbFiles.removeAllItems();
files = null;
super.setTarget(t);
} 

class DefaultPredicate implements Predicate
  { 
public boolean evaluate(Object object)
        { 
return (Model.getFacade().isAClassifier(object));
} 

 } 

 } 


