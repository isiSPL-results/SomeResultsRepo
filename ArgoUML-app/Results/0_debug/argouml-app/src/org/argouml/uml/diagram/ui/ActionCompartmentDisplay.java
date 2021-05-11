
//#if 319357776 
// Compilation Unit of /ActionCompartmentDisplay.java 
 

//#if -1701798837 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 2092544038 
import java.awt.event.ActionEvent;
//#endif 


//#if -1920141595 
import java.util.ArrayList;
//#endif 


//#if 1944750876 
import java.util.Collection;
//#endif 


//#if -1325674740 
import java.util.Iterator;
//#endif 


//#if -306133924 
import java.util.List;
//#endif 


//#if 1179141020 
import javax.swing.Action;
//#endif 


//#if -656655089 
import org.argouml.i18n.Translator;
//#endif 


//#if 628482562 
import org.argouml.uml.diagram.AttributesCompartmentContainer;
//#endif 


//#if -56285339 
import org.argouml.uml.diagram.ExtensionsCompartmentContainer;
//#endif 


//#if -1342041459 
import org.argouml.uml.diagram.OperationsCompartmentContainer;
//#endif 


//#if 1218668449 
import org.argouml.uml.diagram.use_case.ui.FigUseCase;
//#endif 


//#if 1295282288 
import org.tigris.gef.base.Editor;
//#endif 


//#if -645476023 
import org.tigris.gef.base.Globals;
//#endif 


//#if 1670366445 
import org.tigris.gef.base.Selection;
//#endif 


//#if -157549492 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1617006404 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 604509881 
public class ActionCompartmentDisplay extends 
//#if 1804114465 
UndoableAction
//#endif 

  { 

//#if 1485758117 
private boolean display = false;
//#endif 


//#if -1889396009 
private int cType;
//#endif 


//#if -1395448843 
private static final int COMPARTMENT_ATTRIBUTE = 1;
//#endif 


//#if -653000343 
private static final int COMPARTMENT_OPERATION = 2;
//#endif 


//#if -1307799895 
private static final int COMPARTMENT_EXTENSIONPOINT = 4;
//#endif 


//#if 1409911580 
private static final int COMPARTMENT_ENUMLITERAL = 8;
//#endif 


//#if -1762024303 
private static final UndoableAction SHOW_ATTR_COMPARTMENT =
        new ActionCompartmentDisplay(true,
                                     "action.show-attribute-compartment", COMPARTMENT_ATTRIBUTE);
//#endif 


//#if -648747778 
private static final UndoableAction HIDE_ATTR_COMPARTMENT =
        new ActionCompartmentDisplay(false,
                                     "action.hide-attribute-compartment", COMPARTMENT_ATTRIBUTE);
//#endif 


//#if -2008123148 
private static final UndoableAction SHOW_OPER_COMPARTMENT =
        new ActionCompartmentDisplay(true,
                                     "action.show-operation-compartment", COMPARTMENT_OPERATION);
//#endif 


//#if -941166277 
private static final UndoableAction HIDE_OPER_COMPARTMENT =
        new ActionCompartmentDisplay(false,
                                     "action.hide-operation-compartment", COMPARTMENT_OPERATION);
//#endif 


//#if -1798688412 
private static final UndoableAction SHOW_EXTPOINT_COMPARTMENT =
        new ActionCompartmentDisplay(true,
                                     "action.show-extension-point-compartment",
                                     COMPARTMENT_EXTENSIONPOINT);
//#endif 


//#if 1043171803 
private static final UndoableAction HIDE_EXTPOINT_COMPARTMENT =
        new ActionCompartmentDisplay(false,
                                     "action.hide-extension-point-compartment",
                                     COMPARTMENT_EXTENSIONPOINT);
//#endif 


//#if 999988205 
private static final UndoableAction SHOW_ALL_COMPARTMENTS =
        new ActionCompartmentDisplay(true, "action.show-all-compartments",
                                     COMPARTMENT_ATTRIBUTE
                                     | COMPARTMENT_OPERATION
                                     | COMPARTMENT_ENUMLITERAL);
//#endif 


//#if 909903626 
private static final UndoableAction HIDE_ALL_COMPARTMENTS =
        new ActionCompartmentDisplay(false, "action.hide-all-compartments",
                                     COMPARTMENT_ATTRIBUTE
                                     | COMPARTMENT_OPERATION
                                     | COMPARTMENT_ENUMLITERAL);
//#endif 


//#if 1729491185 
private static final UndoableAction SHOW_ENUMLITERAL_COMPARTMENT =
        new ActionCompartmentDisplay(true,
                                     "action.show-enumeration-literal-compartment",
                                     COMPARTMENT_ENUMLITERAL);
//#endif 


//#if 399995506 
private static final UndoableAction HIDE_ENUMLITERAL_COMPARTMENT =
        new ActionCompartmentDisplay(false,
                                     "action.hide-enumeration-literal-compartment",
                                     COMPARTMENT_ENUMLITERAL);
//#endif 


//#if 1376144361 
protected ActionCompartmentDisplay(boolean d, String c, int type)
    { 

//#if 1295957254 
super(Translator.localize(c));
//#endif 


//#if -1376930456 
display = d;
//#endif 


//#if 982746443 
cType = type;
//#endif 

} 

//#endif 


//#if -965576517 
@Override
    public void actionPerformed(ActionEvent ae)
    { 

//#if 1561408613 
Iterator i =
            Globals.curEditor().getSelectionManager().selections().iterator();
//#endif 


//#if 1187924049 
while (i.hasNext()) //1
{ 

//#if -1231286760 
Selection sel = (Selection) i.next();
//#endif 


//#if -1247765444 
Fig       f   = sel.getContent();
//#endif 


//#if 2015106888 
if((cType & COMPARTMENT_ATTRIBUTE) != 0)//1
{ 

//#if 798395593 
if(f instanceof AttributesCompartmentContainer)//1
{ 

//#if -1042149147 
((AttributesCompartmentContainer) f)
                    .setAttributesVisible(display);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1544993005 
if((cType & COMPARTMENT_OPERATION) != 0)//1
{ 

//#if 601787715 
if(f instanceof OperationsCompartmentContainer)//1
{ 

//#if 1193461127 
((OperationsCompartmentContainer) f)
                    .setOperationsVisible(display);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1688182805 
if((cType & COMPARTMENT_EXTENSIONPOINT) != 0)//1
{ 

//#if 257845413 
if(f instanceof FigUseCase)//1
{ 

//#if -1113556347 
((FigUseCase) f).setExtensionPointVisible(display);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2024876806 
if((cType & COMPARTMENT_ENUMLITERAL) != 0)//1
{ 

//#if -2079380306 
if(f instanceof EnumLiteralsCompartmentContainer)//1
{ 

//#if -492195394 
((EnumLiteralsCompartmentContainer) f)
                    .setEnumLiteralsVisible(display);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1232266506 
public static Collection<Action> getActions()
    { 

//#if 1383091433 
Collection<Action> actions = new ArrayList<Action>();
//#endif 


//#if 2092120053 
Editor ce = Globals.curEditor();
//#endif 


//#if -1373336424 
int present = 0;
//#endif 


//#if -913971839 
int visible = 0;
//#endif 


//#if -151600660 
boolean operPresent = false;
//#endif 


//#if 1589608021 
boolean operVisible = false;
//#endif 


//#if -1322263473 
boolean attrPresent = false;
//#endif 


//#if 418945208 
boolean attrVisible = false;
//#endif 


//#if 1198078601 
boolean epPresent = false;
//#endif 


//#if -1355680014 
boolean epVisible = false;
//#endif 


//#if -3867809 
boolean enumPresent = false;
//#endif 


//#if 1737340872 
boolean enumVisible = false;
//#endif 


//#if -867608963 
List<Fig> figs = ce.getSelectionManager().getFigs();
//#endif 


//#if 889846092 
for (Fig f : figs) //1
{ 

//#if 763049758 
if(f instanceof AttributesCompartmentContainer)//1
{ 

//#if -1222526884 
present++;
//#endif 


//#if 62963902 
attrPresent = true;
//#endif 


//#if 851674249 
attrVisible =
                    ((AttributesCompartmentContainer) f).isAttributesVisible();
//#endif 


//#if 1034168410 
if(attrVisible)//1
{ 

//#if -724143457 
visible++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 494941875 
if(f instanceof OperationsCompartmentContainer)//1
{ 

//#if 1020305492 
present++;
//#endif 


//#if -820321143 
operPresent = true;
//#endif 


//#if 1746752456 
operVisible =
                    ((OperationsCompartmentContainer) f).isOperationsVisible();
//#endif 


//#if 10674133 
if(operVisible)//1
{ 

//#if 847698618 
visible++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1937167067 
if(f instanceof ExtensionsCompartmentContainer)//1
{ 

//#if -760699757 
present++;
//#endif 


//#if -1738525843 
epPresent = true;
//#endif 


//#if -1930402831 
epVisible =
                    ((ExtensionsCompartmentContainer) f)
                    .isExtensionPointVisible();
//#endif 


//#if 1566233751 
if(epVisible)//1
{ 

//#if 1234241921 
visible++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1650184820 
if(f instanceof EnumLiteralsCompartmentContainer)//1
{ 

//#if -2033072432 
present++;
//#endif 


//#if 2052064954 
enumPresent = true;
//#endif 


//#if 1191783657 
enumVisible =
                    ((EnumLiteralsCompartmentContainer) f)
                    .isEnumLiteralsVisible();
//#endif 


//#if 783171006 
if(enumVisible)//1
{ 

//#if 308170013 
visible++;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1414354671 
if(present > 1)//1
{ 

//#if 1898011452 
if(visible > 0)//1
{ 

//#if 2085226691 
actions.add(HIDE_ALL_COMPARTMENTS);
//#endif 

} 

//#endif 


//#if -1653550678 
if(present - visible > 0)//1
{ 

//#if 1083454835 
actions.add(SHOW_ALL_COMPARTMENTS);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1938139509 
if(attrPresent)//1
{ 

//#if 227298831 
if(attrVisible)//1
{ 

//#if 8122038 
actions.add(HIDE_ATTR_COMPARTMENT);
//#endif 

} 
else
{ 

//#if -1094207752 
actions.add(SHOW_ATTR_COMPARTMENT);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1891635579 
if(enumPresent)//1
{ 

//#if -759314535 
if(enumVisible)//1
{ 

//#if -1356381497 
actions.add(HIDE_ENUMLITERAL_COMPARTMENT);
//#endif 

} 
else
{ 

//#if 1403251057 
actions.add(SHOW_ENUMLITERAL_COMPARTMENT);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -178938354 
if(operPresent)//1
{ 

//#if 1108639807 
if(operVisible)//1
{ 

//#if -1801289719 
actions.add(HIDE_OPER_COMPARTMENT);
//#endif 

} 
else
{ 

//#if 1978176147 
actions.add(SHOW_OPER_COMPARTMENT);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 498980305 
if(epPresent)//1
{ 

//#if 550126024 
if(epVisible)//1
{ 

//#if 558198252 
actions.add(HIDE_EXTPOINT_COMPARTMENT);
//#endif 

} 
else
{ 

//#if 1617314274 
actions.add(SHOW_EXTPOINT_COMPARTMENT);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 362112146 
return actions;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

