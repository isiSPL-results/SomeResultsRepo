
//#if -2100176743 
// Compilation Unit of /TabSrc.java 
 

//#if 1851949116 
package org.argouml.uml.ui;
//#endif 


//#if 107273069 
import java.awt.event.ItemEvent;
//#endif 


//#if -932955141 
import java.awt.event.ItemListener;
//#endif 


//#if -648190917 
import java.util.ArrayList;
//#endif 


//#if -1574451066 
import java.util.Collection;
//#endif 


//#if -328541882 
import java.util.List;
//#endif 


//#if 821842643 
import javax.swing.JComboBox;
//#endif 


//#if -665153992 
import org.apache.log4j.Logger;
//#endif 


//#if -1033924566 
import org.argouml.application.api.Predicate;
//#endif 


//#if -1202431122 
import org.argouml.language.ui.LanguageComboBox;
//#endif 


//#if 1182382507 
import org.argouml.model.Model;
//#endif 


//#if -2081375009 
import org.argouml.ui.TabText;
//#endif 


//#if 1581890339 
import org.argouml.uml.generator.GeneratorHelper;
//#endif 


//#if -964753190 
import org.argouml.uml.generator.Language;
//#endif 


//#if 1666950931 
import org.argouml.uml.generator.SourceUnit;
//#endif 


//#if -197846878 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 764405477 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 773041984 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 322584716 
public class TabSrc extends 
//#if -1247122428 
TabText
//#endif 

 implements 
//#if 1829851269 
ItemListener
//#endif 

  { 

//#if -1795299707 
private static final long serialVersionUID = -4958164807996827484L;
//#endif 


//#if -2117950753 
private static final Logger LOG = Logger.getLogger(TabSrc.class);
//#endif 


//#if 1704325965 
private Language langName = null;
//#endif 


//#if 1636661140 
private String fileName = null;
//#endif 


//#if 1740162856 
private SourceUnit[] files = null;
//#endif 


//#if -783475813 
private LanguageComboBox cbLang = new LanguageComboBox();
//#endif 


//#if -1510640916 
private JComboBox cbFiles = new JComboBox();
//#endif 


//#if -985501203 
private static List<Predicate> predicates;
//#endif 


//#if -1004965673 
public TabSrc()
    { 

//#if -360548158 
super("tab.source", true);
//#endif 


//#if 354666085 
if(predicates == null)//1
{ 

//#if -729641756 
predicates = new ArrayList<Predicate>();
//#endif 


//#if 65660731 
predicates.add(new DefaultPredicate());
//#endif 

} 

//#endif 


//#if -412596158 
setEditable(false);
//#endif 


//#if 841107451 
langName = (Language) cbLang.getSelectedItem();
//#endif 


//#if 314417167 
fileName = null;
//#endif 


//#if 886698269 
getToolbar().add(cbLang);
//#endif 


//#if -1463216481 
getToolbar().addSeparator();
//#endif 


//#if -1444386912 
cbLang.addItemListener(this);
//#endif 


//#if 914984972 
getToolbar().add(cbFiles);
//#endif 


//#if -1059051693 
getToolbar().addSeparator();
//#endif 


//#if -238923177 
cbFiles.addItemListener(this);
//#endif 

} 

//#endif 


//#if -690852964 
@Override
    protected String genText(Object modelObject)
    { 

//#if -1460848090 
if(files == null)//1
{ 

//#if -1783864007 
generateSource(modelObject);
//#endif 

} 

//#endif 


//#if 58651399 
if(files != null && files.length > cbFiles.getSelectedIndex())//1
{ 

//#if -1060740318 
return files[cbFiles.getSelectedIndex()].getContent();
//#endif 

} 

//#endif 


//#if 1798019961 
return null;
//#endif 

} 

//#endif 


//#if 795187392 
public static void addPredicate(Predicate predicate)
    { 

//#if -391286326 
predicates.add(predicate);
//#endif 

} 

//#endif 


//#if 516625500 
private void generateSource(Object elem)
    { 

//#if 1435045742 
LOG.debug("TabSrc.genText(): getting src for "
                  + Model.getFacade().getName(elem));
//#endif 


//#if 1236876626 
Collection code =
            GeneratorHelper.generate(langName, elem, false);
//#endif 


//#if 692261628 
cbFiles.removeAllItems();
//#endif 


//#if -250801626 
if(!code.isEmpty())//1
{ 

//#if 1108949360 
files = new SourceUnit[code.size()];
//#endif 


//#if -1863438189 
files = (SourceUnit[]) code.toArray(files);
//#endif 


//#if 1755671142 
for (int i = 0; i < files.length; i++) //1
{ 

//#if -1137325095 
StringBuilder title = new StringBuilder(files[i].getName());
//#endif 


//#if 456524985 
if(files[i].getBasePath().length() > 0)//1
{ 

//#if -1252105410 
title.append(" ( " + files[i].getFullName() + ")");
//#endif 

} 

//#endif 


//#if -554313813 
cbFiles.addItem(title.toString());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 642782667 
@Override
    public boolean shouldBeEnabled(Object target)
    { 

//#if 1791420528 
target = (target instanceof Fig) ? ((Fig) target).getOwner() : target;
//#endif 


//#if 1443003632 
setShouldBeEnabled(false);
//#endif 


//#if -66151956 
for (Predicate p : predicates) //1
{ 

//#if 116798684 
if(p.evaluate(target))//1
{ 

//#if 1208558797 
setShouldBeEnabled(true);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1763321689 
return shouldBeEnabled();
//#endif 

} 

//#endif 


//#if -291157089 
public void itemStateChanged(ItemEvent event)
    { 

//#if -982764005 
if(event.getSource() == cbLang)//1
{ 

//#if 1249804370 
if(event.getStateChange() == ItemEvent.SELECTED)//1
{ 

//#if -236260382 
Language newLang = (Language) cbLang.getSelectedItem();
//#endif 


//#if -1463355190 
if(!newLang.equals(langName))//1
{ 

//#if 707852878 
langName = newLang;
//#endif 


//#if 610312962 
refresh();
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if -676219481 
if(event.getSource() == cbFiles)//1
{ 

//#if 373099372 
if(event.getStateChange() == ItemEvent.SELECTED)//1
{ 

//#if 503671399 
String newFile = (String) cbFiles.getSelectedItem();
//#endif 


//#if 510302434 
if(!newFile.equals(fileName))//1
{ 

//#if 1446055911 
fileName = newFile;
//#endif 


//#if -225028828 
super.setTarget(getTarget());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 975354385 
@Override
    public void refresh()
    { 

//#if 39304091 
setTarget(getTarget());
//#endif 

} 

//#endif 


//#if 1647434803 
@Override
    protected void finalize()
    { 

//#if -1522505801 
cbLang.removeItemListener(this);
//#endif 

} 

//#endif 


//#if 138980931 
@Override
    protected void parseText(String s)
    { 

//#if 1477804278 
LOG.debug("TabSrc   setting src for "
                  + Model.getFacade().getName(getTarget()));
//#endif 


//#if 414399509 
Object modelObject = getTarget();
//#endif 


//#if 2043641911 
if(getTarget() instanceof FigNode)//1
{ 

//#if -1044784028 
modelObject = ((FigNode) getTarget()).getOwner();
//#endif 

} 

//#endif 


//#if -1843467662 
if(getTarget() instanceof FigEdge)//1
{ 

//#if -112780883 
modelObject = ((FigEdge) getTarget()).getOwner();
//#endif 

} 

//#endif 


//#if 223070202 
if(modelObject == null)//1
{ 

//#if 104888447 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -162783884 
@Override
    public void setTarget(Object t)
    { 

//#if 1963262540 
Object modelTarget = (t instanceof Fig) ? ((Fig) t).getOwner() : t;
//#endif 


//#if -2117907537 
setShouldBeEnabled(Model.getFacade().isAClassifier(modelTarget));
//#endif 


//#if 155119230 
cbFiles.removeAllItems();
//#endif 


//#if -1440179765 
files = null;
//#endif 


//#if -39419013 
super.setTarget(t);
//#endif 

} 

//#endif 


//#if 204692560 
class DefaultPredicate implements 
//#if 522018721 
Predicate
//#endif 

  { 

//#if 504150053 
public boolean evaluate(Object object)
        { 

//#if 2018594521 
return (Model.getFacade().isAClassifier(object));
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

