
//#if -207643597 
// Compilation Unit of /TabDocumentation.java 
 

//#if 995073812 
package org.argouml.uml.ui;
//#endif 


//#if -1089788059 
import java.awt.Color;
//#endif 


//#if -311552834 
import javax.swing.ImageIcon;
//#endif 


//#if -769751821 
import javax.swing.JScrollPane;
//#endif 


//#if -1559891634 
import javax.swing.JTextArea;
//#endif 


//#if 1022517049 
import javax.swing.UIManager;
//#endif 


//#if -12590044 
import org.argouml.application.api.Argo;
//#endif 


//#if -1739058711 
import org.argouml.configuration.Configuration;
//#endif 


//#if -174474435 
import org.argouml.i18n.Translator;
//#endif 


//#if -2020889469 
import org.argouml.model.Model;
//#endif 


//#if 1126043859 
import org.argouml.swingext.UpArrowIcon;
//#endif 


//#if 1592963962 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -336871344 
import org.tigris.swidgets.Horizontal;
//#endif 


//#if 877717886 
import org.tigris.swidgets.Vertical;
//#endif 


//#if 1969745802 
public class TabDocumentation extends 
//#if -1963036684 
PropPanel
//#endif 

  { 

//#if -1108334220 
private static String orientation = Configuration.getString(Configuration
                                        .makeKey("layout", "tabdocumentation"));
//#endif 


//#if 324006684 
public TabDocumentation()
    { 

//#if 995125065 
super(Translator.localize("tab.documentation"), (ImageIcon) null);
//#endif 


//#if -897392787 
setOrientation((
                           orientation.equals("West") || orientation.equals("East"))
                       ? Vertical.getInstance() : Horizontal.getInstance());
//#endif 


//#if -356812696 
setIcon(new UpArrowIcon());
//#endif 


//#if 1131981094 
addField(Translator.localize("label.author"), new UMLTextField2(
                     new UMLModelElementTaggedValueDocument(Argo.AUTHOR_TAG)));
//#endif 


//#if -1209431330 
addField(Translator.localize("label.version"), new UMLTextField2(
                     new UMLModelElementTaggedValueDocument(Argo.VERSION_TAG)));
//#endif 


//#if 525308962 
addField(Translator.localize("label.since"), new UMLTextField2(
                     new UMLModelElementTaggedValueDocument(Argo.SINCE_TAG)));
//#endif 


//#if 1165765676 
addField(Translator.localize("label.deprecated"),
                 new UMLDeprecatedCheckBox());
//#endif 


//#if 168519904 
UMLTextArea2 see = new UMLTextArea2(
            new UMLModelElementTaggedValueDocument(Argo.SEE_TAG));
//#endif 


//#if 386395003 
see.setRows(2);
//#endif 


//#if 355009572 
see.setLineWrap(true);
//#endif 


//#if 1091064445 
see.setWrapStyleWord(true);
//#endif 


//#if -408965258 
JScrollPane spSee = new JScrollPane();
//#endif 


//#if -193060236 
spSee.getViewport().add(see);
//#endif 


//#if -1447051917 
addField(Translator.localize("label.see"), spSee);
//#endif 


//#if 944633639 
add(LabelledLayout.getSeparator());
//#endif 


//#if 1926012862 
UMLTextArea2 doc = new UMLTextArea2(
            new UMLModelElementTaggedValueDocument(Argo.DOCUMENTATION_TAG));
//#endif 


//#if -925858592 
doc.setRows(2);
//#endif 


//#if -502726881 
doc.setLineWrap(true);
//#endif 


//#if -278594462 
doc.setWrapStyleWord(true);
//#endif 


//#if 1936404660 
JScrollPane spDocs = new JScrollPane();
//#endif 


//#if 1060256765 
spDocs.getViewport().add(doc);
//#endif 


//#if 696557880 
addField(Translator.localize("label.documentation"), spDocs);
//#endif 


//#if -865834956 
UMLTextArea2 comment = new UMLTextArea2(
            new UMLModelElementCommentDocument(false));
//#endif 


//#if 979413706 
disableTextArea(comment);
//#endif 


//#if 1611242498 
JScrollPane spComment = new JScrollPane();
//#endif 


//#if -292546292 
spComment.getViewport().add(comment);
//#endif 


//#if -683569780 
addField(Translator.localize("label.comment.name"), spComment);
//#endif 


//#if 431875187 
UMLTextArea2 commentBody = new UMLTextArea2(
            new UMLModelElementCommentDocument(true));
//#endif 


//#if -1630575604 
disableTextArea(commentBody);
//#endif 


//#if 2017434436 
JScrollPane spCommentBody = new JScrollPane();
//#endif 


//#if 61693584 
spCommentBody.getViewport().add(commentBody);
//#endif 


//#if -1781211867 
addField(Translator.localize("label.comment.body"), spCommentBody);
//#endif 


//#if 1131589135 
setButtonPanelSize(18);
//#endif 

} 

//#endif 


//#if 1454523953 
private void disableTextArea(final JTextArea textArea)
    { 

//#if 592890020 
textArea.setRows(2);
//#endif 


//#if 1005041371 
textArea.setLineWrap(true);
//#endif 


//#if -1745896922 
textArea.setWrapStyleWord(true);
//#endif 


//#if 123967 
textArea.setEnabled(false);
//#endif 


//#if 107840501 
textArea.setDisabledTextColor(textArea.getForeground());
//#endif 


//#if -1918822677 
final Color inactiveColor =
            UIManager.getColor("TextField.inactiveBackground");
//#endif 


//#if -1083084455 
if(inactiveColor != null)//1
{ 

//#if -1951842020 
textArea.setBackground(new Color(inactiveColor.getRGB()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1122361786 
public boolean shouldBeEnabled()
    { 

//#if -1899916056 
Object target = getTarget();
//#endif 


//#if -1667867192 
return shouldBeEnabled(target);
//#endif 

} 

//#endif 


//#if 1566500604 
@Override
    public boolean shouldBeEnabled(Object target)
    { 

//#if -944536441 
target = (target instanceof Fig) ? ((Fig) target).getOwner() : target;
//#endif 


//#if -772187050 
return Model.getFacade().isAModelElement(target);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

