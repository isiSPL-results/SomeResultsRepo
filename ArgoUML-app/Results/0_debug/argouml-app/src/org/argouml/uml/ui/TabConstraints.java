
//#if -1182115564 
// Compilation Unit of /TabConstraints.java 
 

//#if 688052783 
package org.argouml.uml.ui;
//#endif 


//#if 543677971 
import java.awt.BorderLayout;
//#endif 


//#if 2062772344 
import java.awt.event.ComponentEvent;
//#endif 


//#if -1590456560 
import java.awt.event.ComponentListener;
//#endif 


//#if 459172728 
import java.io.IOException;
//#endif 


//#if -1812087250 
import java.util.ArrayList;
//#endif 


//#if 1864399523 
import java.util.Iterator;
//#endif 


//#if -1757359245 
import java.util.List;
//#endif 


//#if 1589567974 
import javax.swing.JOptionPane;
//#endif 


//#if -1096518216 
import javax.swing.JToolBar;
//#endif 


//#if -931826251 
import javax.swing.event.EventListenerList;
//#endif 


//#if 914798251 
import org.apache.log4j.Logger;
//#endif 


//#if 1144843597 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if -1532632546 
import org.argouml.model.Model;
//#endif 


//#if -468419317 
import org.argouml.ocl.ArgoFacade;
//#endif 


//#if 271408094 
import org.argouml.ocl.OCLUtil;
//#endif 


//#if 1613167000 
import org.argouml.swingext.UpArrowIcon;
//#endif 


//#if -1862619581 
import org.argouml.ui.TabModelTarget;
//#endif 


//#if 35888823 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -1300816363 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -2036005338 
import org.tigris.toolbar.ToolBarManager;
//#endif 


//#if -549645274 
import tudresden.ocl.OclException;
//#endif 


//#if 589862339 
import tudresden.ocl.OclTree;
//#endif 


//#if 29728026 
import tudresden.ocl.check.OclTypeException;
//#endif 


//#if -537418336 
import tudresden.ocl.gui.ConstraintRepresentation;
//#endif 


//#if -548547240 
import tudresden.ocl.gui.EditingUtilities;
//#endif 


//#if -1216331801 
import tudresden.ocl.gui.OCLEditor;
//#endif 


//#if 687931942 
import tudresden.ocl.gui.OCLEditorModel;
//#endif 


//#if -835304302 
import tudresden.ocl.gui.events.ConstraintChangeEvent;
//#endif 


//#if -759233354 
import tudresden.ocl.gui.events.ConstraintChangeListener;
//#endif 


//#if -2132887534 
import tudresden.ocl.parser.OclParserException;
//#endif 


//#if -1369721670 
import tudresden.ocl.parser.analysis.DepthFirstAdapter;
//#endif 


//#if -488905002 
import tudresden.ocl.parser.node.AConstraintBody;
//#endif 


//#if 1178592055 
import tudresden.ocl.parser.node.TName;
//#endif 


//#if 108928139 
public class TabConstraints extends 
//#if 599503494 
AbstractArgoJPanel
//#endif 

 implements 
//#if 1045616278 
TabModelTarget
//#endif 

, 
//#if -734727200 
ComponentListener
//#endif 

  { 

//#if -856453922 
private static final Logger LOG = Logger.getLogger(TabConstraints.class);
//#endif 


//#if -1136410745 
private OCLEditor mOcleEditor;
//#endif 


//#if 934830858 
private Object mMmeiTarget;
//#endif 


//#if 969780143 
public Object getTarget()
    { 

//#if -19032375 
return mMmeiTarget;
//#endif 

} 

//#endif 


//#if -2142346586 
public void targetAdded(TargetEvent e)
    { 
} 

//#endif 


//#if 1076047883 
public void setTarget(Object oTarget)
    { 

//#if -813380133 
oTarget =
            (oTarget instanceof Fig) ? ((Fig) oTarget).getOwner() : oTarget;
//#endif 


//#if 1629714251 
if(!(Model.getFacade().isAModelElement(oTarget)))//1
{ 

//#if -832542908 
mMmeiTarget = null;
//#endif 


//#if -351732522 
return;
//#endif 

} 

//#endif 


//#if 1551330827 
mMmeiTarget = oTarget;
//#endif 


//#if -1875427429 
if(isVisible())//1
{ 

//#if -1946611795 
setTargetInternal(mMmeiTarget);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -834616713 
private JToolBar getOclToolbar()
    { 

//#if -1054776892 
return (JToolBar) mOcleEditor.getComponent(0);
//#endif 

} 

//#endif 


//#if 989685190 
public void targetRemoved(TargetEvent e)
    { 

//#if 1036071974 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 596540944 
public void componentHidden(ComponentEvent e)
    { 
} 

//#endif 


//#if 1897767310 
public boolean shouldBeEnabled(Object target)
    { 

//#if -1711996749 
target = (target instanceof Fig) ? ((Fig) target).getOwner() : target;
//#endif 


//#if -2121896873 
return (Model.getFacade().isAClass(target)
                || Model.getFacade().isAFeature(target));
//#endif 

} 

//#endif 


//#if -1466929746 
public void refresh()
    { 

//#if 843207604 
setTarget(mMmeiTarget);
//#endif 

} 

//#endif 


//#if -260795409 
private void setToolbarFloatable(boolean enable)
    { 

//#if -1498204709 
getOclToolbar().setFloatable(false);
//#endif 

} 

//#endif 


//#if 1773435238 
private void setTargetInternal(Object oTarget)
    { 

//#if -1411047472 
if(oTarget != null)//1
{ 

//#if 1847734903 
mOcleEditor.setModel(new ConstraintModel(oTarget));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1517589369 
public void componentShown(ComponentEvent e)
    { 

//#if 330724105 
setTargetInternal(mMmeiTarget);
//#endif 

} 

//#endif 


//#if 139914021 
public void componentMoved(ComponentEvent e)
    { 
} 

//#endif 


//#if 1784282326 
private void setToolbarRollover(boolean enable)
    { 

//#if 603413821 
if(!ToolBarManager.alwaysUseStandardRollover())//1
{ 

//#if -1756426412 
getOclToolbar().putClientProperty(
                "JToolBar.isRollover", Boolean.TRUE);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2099449564 
public TabConstraints()
    { 

//#if -640548493 
super("tab.constraints");
//#endif 


//#if -241707264 
setIcon(new UpArrowIcon());
//#endif 


//#if -1953558002 
setLayout(new BorderLayout(0, 0));
//#endif 


//#if -69241914 
mOcleEditor = new OCLEditor();
//#endif 


//#if 650077736 
mOcleEditor.setOptionMask(OCLEditor.OPTIONMASK_TYPECHECK
                                  /*|  //removed to workaround problems with autosplit
                                    OCLEditor.OPTIONMASK_AUTOSPLIT*/);
//#endif 


//#if -957412949 
mOcleEditor.setDoAutoSplit(false);
//#endif 


//#if 323884069 
setToolbarRollover(true);
//#endif 


//#if -736339119 
setToolbarFloatable(false);
//#endif 


//#if 1343304505 
getOclToolbar().setName("misc.toolbar.constraints");
//#endif 


//#if 920393017 
add(mOcleEditor);
//#endif 


//#if 968419631 
addComponentListener(this);
//#endif 

} 

//#endif 


//#if -189888824 
public void targetSet(TargetEvent e)
    { 

//#if -1231711619 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -305227384 
public void componentResized(ComponentEvent e)
    { 
} 

//#endif 


//#if 1930381076 
private static class ConstraintModel implements 
//#if -951700596 
OCLEditorModel
//#endif 

  { 

//#if 1043301200 
private Object theMMmeiTarget;
//#endif 


//#if 795777768 
private ArrayList theMAlConstraints;
//#endif 


//#if 1265580440 
private EventListenerList theMEllListeners = new EventListenerList();
//#endif 


//#if 1164665293 
protected void fireConstraintRemoved(
            Object mc, int nIdx)
        { 

//#if -1766340609 
Object[] listeners = theMEllListeners.getListenerList();
//#endif 


//#if 12299899 
ConstraintChangeEvent cce = null;
//#endif 


//#if -610029749 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if -1182063781 
if(listeners[i] == ConstraintChangeListener.class)//1
{ 

//#if -1541135917 
if(cce == null)//1
{ 

//#if -52866558 
cce = new ConstraintChangeEvent(
                            this,
                            nIdx,
                            new CR(mc, nIdx),
                            null);
//#endif 

} 

//#endif 


//#if -1434102043 
((ConstraintChangeListener) listeners[i + 1])
                    .constraintRemoved(cce);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -635476300 
protected void fireConstraintAdded()
        { 

//#if -1089895481 
Object[] listeners = theMEllListeners.getListenerList();
//#endif 


//#if 741315507 
ConstraintChangeEvent cce = null;
//#endif 


//#if -1306863853 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if 2022772538 
if(listeners[i] == ConstraintChangeListener.class)//1
{ 

//#if -1433752370 
if(cce == null)//1
{ 

//#if 1877615705 
int nIdx = theMAlConstraints.size() - 1;
//#endif 


//#if 1421023695 
cce =
                            new ConstraintChangeEvent(
                            this,
                            nIdx,
                            null,
                            representationFor(nIdx));
//#endif 

} 

//#endif 


//#if 963683840 
((ConstraintChangeListener) listeners[i + 1])
                    .constraintAdded(cce);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -847943351 
public void addConstraintChangeListener(ConstraintChangeListener ccl)
        { 

//#if -1439109283 
theMEllListeners.add(ConstraintChangeListener.class, ccl);
//#endif 

} 

//#endif 


//#if 1485805563 
public int getConstraintCount()
        { 

//#if -1260324540 
return theMAlConstraints.size();
//#endif 

} 

//#endif 


//#if -380415215 
protected void fireConstraintDataChanged(
            int nIdx,
            Object mcOld,
            Object mcNew)
        { 

//#if 367866860 
Object[] listeners = theMEllListeners.getListenerList();
//#endif 


//#if -923014866 
ConstraintChangeEvent cce = null;
//#endif 


//#if 202495672 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if -207260212 
if(listeners[i] == ConstraintChangeListener.class)//1
{ 

//#if 219397957 
if(cce == null)//1
{ 

//#if -1307791944 
cce = new ConstraintChangeEvent(
                            this,
                            nIdx,
                            new CR(mcOld, nIdx),
                            new CR(mcNew, nIdx));
//#endif 

} 

//#endif 


//#if -2141904991 
((ConstraintChangeListener) listeners[i + 1])
                    .constraintDataChanged(cce);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -330963364 
public void removeConstraintChangeListener(
            ConstraintChangeListener ccl)
        { 

//#if 859422093 
theMEllListeners.remove(ConstraintChangeListener.class, ccl);
//#endif 

} 

//#endif 


//#if -143670776 
public ConstraintRepresentation getConstraintAt(int nIdx)
        { 

//#if 1482996735 
return representationFor(nIdx);
//#endif 

} 

//#endif 


//#if -1124159295 
private CR representationFor(int nIdx)
        { 

//#if 1938688292 
if((nIdx < 0) || (nIdx >= theMAlConstraints.size()))//1
{ 

//#if -1127883384 
return null;
//#endif 

} 

//#endif 


//#if -1293696869 
Object mc = theMAlConstraints.get(nIdx);
//#endif 


//#if -1062584339 
if(mc != null)//1
{ 

//#if -471878070 
return new CR(mc, nIdx);
//#endif 

} 

//#endif 


//#if 235175881 
return new CR(nIdx);
//#endif 

} 

//#endif 


//#if 75768808 
public ConstraintModel(Object mmeiTarget)
        { 

//#if -2028779628 
super();
//#endif 


//#if 524585583 
theMMmeiTarget = mmeiTarget;
//#endif 


//#if -2126290350 
theMAlConstraints =
                new ArrayList(Model.getFacade().getConstraints(theMMmeiTarget));
//#endif 

} 

//#endif 


//#if -2058639118 
protected void fireConstraintNameChanged(
            int nIdx,
            Object mcOld,
            Object mcNew)
        { 

//#if -554261277 
Object[] listeners = theMEllListeners.getListenerList();
//#endif 


//#if -1519222249 
ConstraintChangeEvent cce = null;
//#endif 


//#if 1690026543 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if -799894572 
if(listeners[i] == ConstraintChangeListener.class)//1
{ 

//#if -1579152472 
if(cce == null)//1
{ 

//#if 321096516 
cce = new ConstraintChangeEvent(
                            this,
                            nIdx,
                            new CR(mcOld, nIdx),
                            new CR(mcNew, nIdx));
//#endif 

} 

//#endif 


//#if 1109872259 
((ConstraintChangeListener) listeners[i + 1])
                    .constraintNameChanged(cce);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1892424858 
public void removeConstraintAt(int nIdx)
        { 

//#if 1168742501 
if((nIdx < 0) || (nIdx > theMAlConstraints.size()))//1
{ 

//#if 321694356 
return;
//#endif 

} 

//#endif 


//#if -994541885 
Object mc = theMAlConstraints.remove(nIdx);
//#endif 


//#if -925301305 
if(mc != null)//1
{ 

//#if 1526622408 
Model.getCoreHelper().removeConstraint(theMMmeiTarget, mc);
//#endif 

} 

//#endif 


//#if -1517549001 
fireConstraintRemoved(mc, nIdx);
//#endif 

} 

//#endif 


//#if -9091366 
public void addConstraint()
        { 

//#if 1081781446 
Object mmeContext = OCLUtil
                                .getInnerMostEnclosingNamespace(theMMmeiTarget);
//#endif 


//#if 1842827054 
String contextName = Model.getFacade().getName(mmeContext);
//#endif 


//#if 335789351 
String targetName = Model.getFacade().getName(theMMmeiTarget);
//#endif 


//#if -2114856950 
if((contextName == null
                    || contextName.equals (""))
                    ||  // this is to fix issue #2056
                    (targetName == null
                     || targetName.equals (""))
                    ||   // this is to fix issue #2056
                    !Character.isUpperCase(contextName.charAt(0))
                    || (Model.getFacade().isAClass (theMMmeiTarget)
                        && !Character.isUpperCase(targetName.charAt(0)))
                    || (Model.getFacade().isAFeature(theMMmeiTarget)
                        && !Character.isLowerCase(targetName.charAt(0))))//1
{ 

//#if -457168515 
JOptionPane.showMessageDialog(
                    null,
                    "The OCL Toolkit requires that:\n\n"
                    + "Class names have a capital first letter and\n"
                    + "Attribute or Operation names have "
                    + "a lower case first letter.",
                    "Require Correct name convention:",
                    JOptionPane.ERROR_MESSAGE);
//#endif 


//#if 1614879371 
return;
//#endif 

} 

//#endif 


//#if 472139892 
theMAlConstraints.add(null);
//#endif 


//#if 821540386 
fireConstraintAdded();
//#endif 

} 

//#endif 


//#if -171432212 
private class CR implements 
//#if -820451704 
ConstraintRepresentation
//#endif 

  { 

//#if 174252904 
private Object theMMcConstraint;
//#endif 


//#if -478500049 
private int theMNIdx = -1;
//#endif 


//#if -672138007 
public String getData()
            { 

//#if -1525878997 
if(theMMcConstraint == null)//1
{ 

//#if -2071310291 
return OCLUtil.getContextString(theMMmeiTarget);
//#endif 

} 

//#endif 


//#if -1296907030 
return (String) Model.getFacade().getBody(
                           Model.getFacade().getBody(theMMcConstraint));
//#endif 

} 

//#endif 


//#if -1249117694 
public void setData(String sData, EditingUtilities euHelper)
            throws OclParserException, OclTypeException
            { 

//#if -1191460555 
OclTree tree = null;
//#endif 


//#if 1264261004 
try //1
{ 

//#if 1115441096 
Object mmeContext = OCLUtil
                                        .getInnerMostEnclosingNamespace(theMMmeiTarget);
//#endif 


//#if -670309843 
try //1
{ 

//#if 223819594 
tree =
                            euHelper.parseAndCheckConstraint(
                                sData,
                                new ArgoFacade(mmeContext));
//#endif 

} 

//#if -1844425944 
catch (IOException ioe) //1
{ 

//#if 1950457795 
LOG.error("problem parsing And Checking Constraints",
                                  ioe);
//#endif 


//#if 1171379393 
return;
//#endif 

} 

//#endif 


//#endif 


//#if -1256469233 
if(euHelper.getDoAutoSplit())//1
{ 

//#if -2141563531 
List lConstraints = euHelper.splitConstraint(tree);
//#endif 


//#if -1064900626 
if(lConstraints.size() > 0)//1
{ 

//#if 1956875383 
removeConstraintAt(theMNIdx);
//#endif 


//#if 112397373 
for (Iterator i = lConstraints.iterator();
                                    i.hasNext();) //1
{ 

//#if 817786675 
OclTree ocltCurrent = (OclTree) i.next();
//#endif 


//#if 812121164 
Object mc =
                                    Model.getCoreFactory()
                                    .createConstraint();
//#endif 


//#if 706645534 
Model.getCoreHelper().setName(mc, ocltCurrent
                                                              .getConstraintName());
//#endif 


//#if 1849635739 
Model.getCoreHelper().setBody(mc,
                                                              Model.getDataTypesFactory()
                                                              .createBooleanExpression(
                                                                  "OCL",
                                                                  ocltCurrent
                                                                  .getExpression()));
//#endif 


//#if 865805472 
Model.getCoreHelper().addConstraint(
                                    theMMmeiTarget,
                                    mc);
//#endif 


//#if 835863811 
if(Model.getFacade().getNamespace(
                                            theMMmeiTarget)
                                        != null)//1
{ 

//#if 1110214599 
Model.getCoreHelper().addOwnedElement(
                                        Model.getFacade().getNamespace(
                                            theMMmeiTarget),
                                        mc);
//#endif 

} 
else

//#if -9081033 
if(Model.getFacade().getNamespace(
                                               mmeContext) != null)//1
{ 

//#if -1355509755 
Model.getCoreHelper().addOwnedElement(
                                        Model.getFacade().getNamespace(
                                            mmeContext),
                                        theMMcConstraint);
//#endif 

} 

//#endif 


//#endif 


//#if 353894456 
theMAlConstraints.add(mc);
//#endif 


//#if 957934935 
fireConstraintAdded();
//#endif 

} 

//#endif 


//#if -1237857295 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 282762450 
Object mcOld = null;
//#endif 


//#if -1981217230 
if(theMMcConstraint == null)//1
{ 

//#if -261525898 
theMMcConstraint =
                            Model.getCoreFactory().createConstraint();
//#endif 


//#if -1701911924 
Model.getCoreHelper().setName(
                            theMMcConstraint,
                            "newConstraint");
//#endif 


//#if 792920199 
Model.getCoreHelper().setBody(
                            theMMcConstraint,
                            Model.getDataTypesFactory()
                            .createBooleanExpression("OCL", sData));
//#endif 


//#if 1104557405 
Model.getCoreHelper().addConstraint(theMMmeiTarget,
                                                            theMMcConstraint);
//#endif 


//#if 1817848204 
Object targetNamespace =
                            Model.getFacade().getNamespace(theMMmeiTarget);
//#endif 


//#if 1450656881 
Object contextNamespace =
                            Model.getFacade().getNamespace(mmeContext);
//#endif 


//#if 43517072 
if(targetNamespace != null)//1
{ 

//#if 450966989 
Model.getCoreHelper().addOwnedElement(
                                targetNamespace,
                                theMMcConstraint);
//#endif 

} 
else

//#if 834094899 
if(contextNamespace != null)//1
{ 

//#if -594375722 
Model.getCoreHelper().addOwnedElement(
                                contextNamespace,
                                theMMcConstraint);
//#endif 

} 

//#endif 


//#endif 


//#if 1152153879 
theMAlConstraints.set(theMNIdx, theMMcConstraint);
//#endif 

} 
else
{ 

//#if -274001935 
mcOld = Model.getCoreFactory().createConstraint();
//#endif 


//#if -478780921 
Model.getCoreHelper().setName(
                            mcOld,
                            Model.getFacade().getName(theMMcConstraint));
//#endif 


//#if 890359374 
Model.getCoreHelper().setBody(
                            mcOld,
                            Model.getDataTypesFactory()
                            .createBooleanExpression("OCL",
                                                     (String) Model.getFacade()
                                                     .getBody(
                                                         Model.getFacade().getBody(
                                                             theMMcConstraint))));
//#endif 


//#if 1251867318 
Model.getCoreHelper().setBody(theMMcConstraint,
                                                      Model.getDataTypesFactory()
                                                      .createBooleanExpression("OCL", sData));
//#endif 

} 

//#endif 


//#if 1564950133 
fireConstraintDataChanged(theMNIdx, mcOld,
                                              theMMcConstraint);
//#endif 

} 

//#if -96673427 
catch (OclTypeException pe) //1
{ 

//#if 2096167769 
LOG.warn("There was some sort of OCL Type problem", pe);
//#endif 


//#if 1759376835 
throw pe;
//#endif 

} 

//#endif 


//#if 621333401 
catch (OclParserException pe1) //1
{ 

//#if -846727603 
LOG.warn("Could not parse the constraint", pe1);
//#endif 


//#if 1502275269 
throw pe1;
//#endif 

} 

//#endif 


//#if 2024385258 
catch (OclException oclExc) //1
{ 

//#if 1789939860 
LOG.warn("There was some unidentified problem");
//#endif 


//#if -2039802331 
throw oclExc;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -615685086 
public void setName(
                final String sName,
                final EditingUtilities euHelper)
            { 

//#if -662641458 
if(theMMcConstraint != null)//1
{ 

//#if 320908399 
if(!euHelper.isValidConstraintName(sName))//1
{ 

//#if -1072265836 
throw new IllegalArgumentException(
                            "Please specify a valid name.");
//#endif 

} 

//#endif 


//#if 237949349 
Object mcOld =
                        Model.getCoreFactory().createConstraint();
//#endif 


//#if -893707438 
Model.getCoreHelper().setName(mcOld,
                                                  Model.getFacade().getName(theMMcConstraint));
//#endif 


//#if -2022733722 
Object constraintBody =
                        Model.getFacade().getBody(theMMcConstraint);
//#endif 


//#if -114044910 
Model.getCoreHelper().setBody(mcOld,
                                                  Model.getDataTypesFactory()
                                                  .createBooleanExpression(
                                                      "OCL",
                                                      (String) Model.getFacade().getBody(
                                                          constraintBody)));
//#endif 


//#if 540690985 
Model.getCoreHelper().setName(theMMcConstraint, sName);
//#endif 


//#if 1646369599 
fireConstraintNameChanged(theMNIdx, mcOld,
                                              theMMcConstraint);
//#endif 


//#if -1783488830 
try //1
{ 

//#if 253681340 
OclTree tree = null;
//#endif 


//#if -889380864 
Object mmeContext = OCLUtil
                                            .getInnerMostEnclosingNamespace(theMMmeiTarget);
//#endif 


//#if 1048353890 
constraintBody =
                            Model.getFacade().getBody(theMMcConstraint);
//#endif 


//#if -1981688047 
tree =
                            euHelper.parseAndCheckConstraint(
                                (String) Model.getFacade().getBody(
                                    constraintBody),
                                new ArgoFacade(mmeContext));
//#endif 


//#if -1580352443 
if(tree != null)//1
{ 

//#if -1386588558 
tree.apply(new DepthFirstAdapter() {
                                private int nameID = 0;
                                public void caseAConstraintBody(
                                    AConstraintBody node) {
                                    // replace name
                                    if (nameID == 0) {
                                        node.setName(new TName(sName));
                                    } else {
                                        node.setName(new TName(
                                                         sName + "_" + nameID));
                                    }
                                    nameID++;
                                }
                            });
//#endif 


//#if 44319548 
setData(tree.getExpression(), euHelper);
//#endif 

} 

//#endif 

} 

//#if -1959720936 
catch (Throwable t) //1
{ 

//#if 397209349 
LOG.error("some unidentified problem", t);
//#endif 

} 

//#endif 


//#endif 

} 
else
{ 

//#if -1806497242 
throw new IllegalStateException(
                        "Please define and submit a constraint body first.");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -630068141 
public CR(Object mcConstraint, int nIdx)
            { 

//#if 1262452808 
super();
//#endif 


//#if 200840419 
theMMcConstraint = mcConstraint;
//#endif 


//#if -703853725 
theMNIdx = nIdx;
//#endif 

} 

//#endif 


//#if -934424067 
public CR(int nIdx)
            { 

//#if -1597833733 
this(null, nIdx);
//#endif 

} 

//#endif 


//#if -386051190 
public String getName()
            { 

//#if 851903248 
if(theMMcConstraint == null)//1
{ 

//#if -1136102644 
return "newConstraint";
//#endif 

} 

//#endif 


//#if -1048376013 
return Model.getFacade().getName(theMMcConstraint);
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

