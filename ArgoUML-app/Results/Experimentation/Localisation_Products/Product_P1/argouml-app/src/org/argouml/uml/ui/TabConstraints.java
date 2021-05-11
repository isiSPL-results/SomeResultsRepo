package org.argouml.uml.ui;
import java.awt.BorderLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.event.EventListenerList;
import org.apache.log4j.Logger;
import org.argouml.application.api.AbstractArgoJPanel;
import org.argouml.model.Model;
import org.argouml.ocl.ArgoFacade;
import org.argouml.ocl.OCLUtil;
import org.argouml.swingext.UpArrowIcon;
import org.argouml.ui.TabModelTarget;
import org.argouml.ui.targetmanager.TargetEvent;
import org.tigris.gef.presentation.Fig;
import org.tigris.toolbar.ToolBarManager;
import tudresden.ocl.OclException;
import tudresden.ocl.OclTree;
import tudresden.ocl.check.OclTypeException;
import tudresden.ocl.gui.ConstraintRepresentation;
import tudresden.ocl.gui.EditingUtilities;
import tudresden.ocl.gui.OCLEditor;
import tudresden.ocl.gui.OCLEditorModel;
import tudresden.ocl.gui.events.ConstraintChangeEvent;
import tudresden.ocl.gui.events.ConstraintChangeListener;
import tudresden.ocl.parser.OclParserException;
import tudresden.ocl.parser.analysis.DepthFirstAdapter;
import tudresden.ocl.parser.node.AConstraintBody;
import tudresden.ocl.parser.node.TName;
public class TabConstraints extends AbstractArgoJPanel
 implements TabModelTarget
,ComponentListener
  { 
private static final Logger LOG = Logger.getLogger(TabConstraints.class);
private OCLEditor mOcleEditor;
private Object mMmeiTarget;
public Object getTarget()
    { 
return mMmeiTarget;
} 
public void targetAdded(TargetEvent e)
    { 
} 
public void setTarget(Object oTarget)
    { 
oTarget =
            (oTarget instanceof Fig) ? ((Fig) oTarget).getOwner() : oTarget;
if(!(Model.getFacade().isAModelElement(oTarget)))//1
{ 
mMmeiTarget = null;
return;
} 
mMmeiTarget = oTarget;
if(isVisible())//1
{ 
setTargetInternal(mMmeiTarget);
} 
} 
private JToolBar getOclToolbar()
    { 
return (JToolBar) mOcleEditor.getComponent(0);
} 
public void targetRemoved(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public void componentHidden(ComponentEvent e)
    { 
} 
public boolean shouldBeEnabled(Object target)
    { 
target = (target instanceof Fig) ? ((Fig) target).getOwner() : target;
return (Model.getFacade().isAClass(target)
                || Model.getFacade().isAFeature(target));
} 
public void refresh()
    { 
setTarget(mMmeiTarget);
} 
private void setToolbarFloatable(boolean enable)
    { 
getOclToolbar().setFloatable(false);
} 
private void setTargetInternal(Object oTarget)
    { 
if(oTarget != null)//1
{ 
mOcleEditor.setModel(new ConstraintModel(oTarget));
} 
} 
public void componentShown(ComponentEvent e)
    { 
setTargetInternal(mMmeiTarget);
} 
public void componentMoved(ComponentEvent e)
    { 
} 
private void setToolbarRollover(boolean enable)
    { 
if(!ToolBarManager.alwaysUseStandardRollover())//1
{ 
getOclToolbar().putClientProperty(
                "JToolBar.isRollover", Boolean.TRUE);
} 
} 
public TabConstraints()
    { 
super("tab.constraints");
setIcon(new UpArrowIcon());
setLayout(new BorderLayout(0, 0));
mOcleEditor = new OCLEditor();
mOcleEditor.setOptionMask(OCLEditor.OPTIONMASK_TYPECHECK
                                  /*|  //removed to workaround problems with autosplit
                                    OCLEditor.OPTIONMASK_AUTOSPLIT*/);
mOcleEditor.setDoAutoSplit(false);
setToolbarRollover(true);
setToolbarFloatable(false);
getOclToolbar().setName("misc.toolbar.constraints");
add(mOcleEditor);
addComponentListener(this);
} 
public void targetSet(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public void componentResized(ComponentEvent e)
    { 
} 
private static class ConstraintModel implements OCLEditorModel
  { 
private Object theMMmeiTarget;
private ArrayList theMAlConstraints;
private EventListenerList theMEllListeners = new EventListenerList();
protected void fireConstraintRemoved(
            Object mc, int nIdx)
        { 
Object[] listeners = theMEllListeners.getListenerList();
ConstraintChangeEvent cce = null;
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 
if(listeners[i] == ConstraintChangeListener.class)//1
{ 
if(cce == null)//1
{ 
cce = new ConstraintChangeEvent(
                            this,
                            nIdx,
                            new CR(mc, nIdx),
                            null);
} 
((ConstraintChangeListener) listeners[i + 1])
                    .constraintRemoved(cce);
} 
} 
} 
protected void fireConstraintAdded()
        { 
Object[] listeners = theMEllListeners.getListenerList();
ConstraintChangeEvent cce = null;
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 
if(listeners[i] == ConstraintChangeListener.class)//1
{ 
if(cce == null)//1
{ 
int nIdx = theMAlConstraints.size() - 1;
cce =
                            new ConstraintChangeEvent(
                            this,
                            nIdx,
                            null,
                            representationFor(nIdx));
} 
((ConstraintChangeListener) listeners[i + 1])
                    .constraintAdded(cce);
} 
} 
} 
public void addConstraintChangeListener(ConstraintChangeListener ccl)
        { 
theMEllListeners.add(ConstraintChangeListener.class, ccl);
} 
public int getConstraintCount()
        { 
return theMAlConstraints.size();
} 
protected void fireConstraintDataChanged(
            int nIdx,
            Object mcOld,
            Object mcNew)
        { 
Object[] listeners = theMEllListeners.getListenerList();
ConstraintChangeEvent cce = null;
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 
if(listeners[i] == ConstraintChangeListener.class)//1
{ 
if(cce == null)//1
{ 
cce = new ConstraintChangeEvent(
                            this,
                            nIdx,
                            new CR(mcOld, nIdx),
                            new CR(mcNew, nIdx));
} 
((ConstraintChangeListener) listeners[i + 1])
                    .constraintDataChanged(cce);
} 
} 
} 
public void removeConstraintChangeListener(
            ConstraintChangeListener ccl)
        { 
theMEllListeners.remove(ConstraintChangeListener.class, ccl);
} 
public ConstraintRepresentation getConstraintAt(int nIdx)
        { 
return representationFor(nIdx);
} 
private CR representationFor(int nIdx)
        { 
if((nIdx < 0) || (nIdx >= theMAlConstraints.size()))//1
{ 
return null;
} 
Object mc = theMAlConstraints.get(nIdx);
if(mc != null)//1
{ 
return new CR(mc, nIdx);
} 
return new CR(nIdx);
} 
public ConstraintModel(Object mmeiTarget)
        { 
super();
theMMmeiTarget = mmeiTarget;
theMAlConstraints =
                new ArrayList(Model.getFacade().getConstraints(theMMmeiTarget));
} 
protected void fireConstraintNameChanged(
            int nIdx,
            Object mcOld,
            Object mcNew)
        { 
Object[] listeners = theMEllListeners.getListenerList();
ConstraintChangeEvent cce = null;
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 
if(listeners[i] == ConstraintChangeListener.class)//1
{ 
if(cce == null)//1
{ 
cce = new ConstraintChangeEvent(
                            this,
                            nIdx,
                            new CR(mcOld, nIdx),
                            new CR(mcNew, nIdx));
} 
((ConstraintChangeListener) listeners[i + 1])
                    .constraintNameChanged(cce);
} 
} 
} 
public void removeConstraintAt(int nIdx)
        { 
if((nIdx < 0) || (nIdx > theMAlConstraints.size()))//1
{ 
return;
} 
Object mc = theMAlConstraints.remove(nIdx);
if(mc != null)//1
{ 
Model.getCoreHelper().removeConstraint(theMMmeiTarget, mc);
} 
fireConstraintRemoved(mc, nIdx);
} 
public void addConstraint()
        { 
Object mmeContext = OCLUtil
                                .getInnerMostEnclosingNamespace(theMMmeiTarget);
String contextName = Model.getFacade().getName(mmeContext);
String targetName = Model.getFacade().getName(theMMmeiTarget);
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
JOptionPane.showMessageDialog(
                    null,
                    "The OCL Toolkit requires that:\n\n"
                    + "Class names have a capital first letter and\n"
                    + "Attribute or Operation names have "
                    + "a lower case first letter.",
                    "Require Correct name convention:",
                    JOptionPane.ERROR_MESSAGE);
return;
} 
theMAlConstraints.add(null);
fireConstraintAdded();
} 
private class CR implements ConstraintRepresentation
  { 
private Object theMMcConstraint;
private int theMNIdx = -1;
public String getData()
            { 
if(theMMcConstraint == null)//1
{ 
return OCLUtil.getContextString(theMMmeiTarget);
} 
return (String) Model.getFacade().getBody(
                           Model.getFacade().getBody(theMMcConstraint));
} 
public void setData(String sData, EditingUtilities euHelper)
            throws OclParserException, OclTypeException
            { 
OclTree tree = null;
try//1
{ 
Object mmeContext = OCLUtil
                                        .getInnerMostEnclosingNamespace(theMMmeiTarget);
try//1
{ 
tree =
                            euHelper.parseAndCheckConstraint(
                                sData,
                                new ArgoFacade(mmeContext));
} 
catch (IOException ioe) //1
{ 
LOG.error("problem parsing And Checking Constraints",
                                  ioe);
return;
} 
if(euHelper.getDoAutoSplit())//1
{ 
List lConstraints = euHelper.splitConstraint(tree);
if(lConstraints.size() > 0)//1
{ 
removeConstraintAt(theMNIdx);
for (Iterator i = lConstraints.iterator();
                                    i.hasNext();) //1
{ 
OclTree ocltCurrent = (OclTree) i.next();
Object mc =
                                    Model.getCoreFactory()
                                    .createConstraint();
Model.getCoreHelper().setName(mc, ocltCurrent
                                                              .getConstraintName());
Model.getCoreHelper().setBody(mc,
                                                              Model.getDataTypesFactory()
                                                              .createBooleanExpression(
                                                                  "OCL",
                                                                  ocltCurrent
                                                                  .getExpression()));
Model.getCoreHelper().addConstraint(
                                    theMMmeiTarget,
                                    mc);
if(Model.getFacade().getNamespace(
                                            theMMmeiTarget)
                                        != null)//1
{ 
Model.getCoreHelper().addOwnedElement(
                                        Model.getFacade().getNamespace(
                                            theMMmeiTarget),
                                        mc);
} 
else
if(Model.getFacade().getNamespace(
                                               mmeContext) != null)//1
{ 
Model.getCoreHelper().addOwnedElement(
                                        Model.getFacade().getNamespace(
                                            mmeContext),
                                        theMMcConstraint);
} 
theMAlConstraints.add(mc);
fireConstraintAdded();
} 
return;
} 
} 
Object mcOld = null;
if(theMMcConstraint == null)//1
{ 
theMMcConstraint =
                            Model.getCoreFactory().createConstraint();
Model.getCoreHelper().setName(
                            theMMcConstraint,
                            "newConstraint");
Model.getCoreHelper().setBody(
                            theMMcConstraint,
                            Model.getDataTypesFactory()
                            .createBooleanExpression("OCL", sData));
Model.getCoreHelper().addConstraint(theMMmeiTarget,
                                                            theMMcConstraint);
Object targetNamespace =
                            Model.getFacade().getNamespace(theMMmeiTarget);
Object contextNamespace =
                            Model.getFacade().getNamespace(mmeContext);
if(targetNamespace != null)//1
{ 
Model.getCoreHelper().addOwnedElement(
                                targetNamespace,
                                theMMcConstraint);
} 
else
if(contextNamespace != null)//1
{ 
Model.getCoreHelper().addOwnedElement(
                                contextNamespace,
                                theMMcConstraint);
} 
theMAlConstraints.set(theMNIdx, theMMcConstraint);
} 
else
{ 
mcOld = Model.getCoreFactory().createConstraint();
Model.getCoreHelper().setName(
                            mcOld,
                            Model.getFacade().getName(theMMcConstraint));
Model.getCoreHelper().setBody(
                            mcOld,
                            Model.getDataTypesFactory()
                            .createBooleanExpression("OCL",
                                                     (String) Model.getFacade()
                                                     .getBody(
                                                         Model.getFacade().getBody(
                                                             theMMcConstraint))));
Model.getCoreHelper().setBody(theMMcConstraint,
                                                      Model.getDataTypesFactory()
                                                      .createBooleanExpression("OCL", sData));
} 
fireConstraintDataChanged(theMNIdx, mcOld,
                                              theMMcConstraint);
} 
catch (OclTypeException pe) //1
{ 
LOG.warn("There was some sort of OCL Type problem", pe);
throw pe;
} 
catch (OclParserException pe1) //1
{ 
LOG.warn("Could not parse the constraint", pe1);
throw pe1;
} 
catch (OclException oclExc) //1
{ 
LOG.warn("There was some unidentified problem");
throw oclExc;
} 
} 
public void setName(
                final String sName,
                final EditingUtilities euHelper)
            { 
if(theMMcConstraint != null)//1
{ 
if(!euHelper.isValidConstraintName(sName))//1
{ 
throw new IllegalArgumentException(
                            "Please specify a valid name.");
} 
Object mcOld =
                        Model.getCoreFactory().createConstraint();
Model.getCoreHelper().setName(mcOld,
                                                  Model.getFacade().getName(theMMcConstraint));
Object constraintBody =
                        Model.getFacade().getBody(theMMcConstraint);
Model.getCoreHelper().setBody(mcOld,
                                                  Model.getDataTypesFactory()
                                                  .createBooleanExpression(
                                                      "OCL",
                                                      (String) Model.getFacade().getBody(
                                                          constraintBody)));
Model.getCoreHelper().setName(theMMcConstraint, sName);
fireConstraintNameChanged(theMNIdx, mcOld,
                                              theMMcConstraint);
try//1
{ 
OclTree tree = null;
Object mmeContext = OCLUtil
                                            .getInnerMostEnclosingNamespace(theMMmeiTarget);
constraintBody =
                            Model.getFacade().getBody(theMMcConstraint);
tree =
                            euHelper.parseAndCheckConstraint(
                                (String) Model.getFacade().getBody(
                                    constraintBody),
                                new ArgoFacade(mmeContext));
if(tree != null)//1
{ 
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
setData(tree.getExpression(), euHelper);
} 
} 
catch (Throwable t) //1
{ 
LOG.error("some unidentified problem", t);
} 
} 
else
{ 
throw new IllegalStateException(
                        "Please define and submit a constraint body first.");
} 
} 
public CR(Object mcConstraint, int nIdx)
            { 
super();
theMMcConstraint = mcConstraint;
theMNIdx = nIdx;
} 
public CR(int nIdx)
            { 
this(null, nIdx);
} 
public String getName()
            { 
if(theMMcConstraint == null)//1
{ 
return "newConstraint";
} 
return Model.getFacade().getName(theMMcConstraint);
} 

 } 

 } 

 } 
