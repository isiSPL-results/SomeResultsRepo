
//#if 1613411302 
// Compilation Unit of /FigPackage.java 
 

//#if -1079855861 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -964697369 
import java.awt.Color;
//#endif 


//#if -1166346812 
import java.awt.Dimension;
//#endif 


//#if -592608678 
import java.awt.Point;
//#endif 


//#if -1180125477 
import java.awt.Rectangle;
//#endif 


//#if -1575338822 
import java.awt.event.ActionEvent;
//#endif 


//#if -898860157 
import java.awt.event.MouseEvent;
//#endif 


//#if -1196787664 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1569702251 
import java.beans.PropertyVetoException;
//#endif 


//#if 1388351216 
import java.util.List;
//#endif 


//#if -1373447637 
import java.util.Vector;
//#endif 


//#if 261997321 
import javax.swing.JOptionPane;
//#endif 


//#if -412772402 
import org.apache.log4j.Logger;
//#endif 


//#if -151864838 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1603093243 
import org.argouml.i18n.Translator;
//#endif 


//#if 862003241 
import org.argouml.kernel.Project;
//#endif 


//#if 1434764097 
import org.argouml.model.Model;
//#endif 


//#if -1841992849 
import org.argouml.model.RemoveAssociationEvent;
//#endif 


//#if 1062892827 
import org.argouml.ui.ArgoJMenu;
//#endif 


//#if 1043261650 
import org.argouml.ui.explorer.ExplorerEventAdaptor;
//#endif 


//#if 493376641 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -711521408 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 721477701 
import org.argouml.uml.diagram.DiagramFactory;
//#endif 


//#if -552807644 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -77554837 
import org.argouml.uml.diagram.StereotypeContainer;
//#endif 


//#if -811517109 
import org.argouml.uml.diagram.VisibilityContainer;
//#endif 


//#if -569433210 
import org.argouml.uml.diagram.DiagramFactory.DiagramType;
//#endif 


//#if -1874877973 
import org.argouml.uml.diagram.ui.ArgoFig;
//#endif 


//#if 1141291582 
import org.argouml.uml.diagram.ui.ArgoFigText;
//#endif 


//#if 964801725 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if 1922366724 
import org.tigris.gef.base.Editor;
//#endif 


//#if -493082337 
import org.tigris.gef.base.Geometry;
//#endif 


//#if 1614272309 
import org.tigris.gef.base.Globals;
//#endif 


//#if 725381766 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if 1210526061 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 272641080 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1624430644 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if 1626297867 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if -1992087216 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1991286447 
class PackagePortFigRect extends 
//#if 1606911284 
FigRect
//#endif 

  { 

//#if 1067571023 
private int indentX;
//#endif 


//#if -126791329 
private int tabHeight;
//#endif 


//#if 1897609593 
private static final long serialVersionUID = -7083102131363598065L;
//#endif 


//#if -201453816 
@Override
    public Point getClosestPoint(Point anotherPt)
    { 

//#if -133728554 
Rectangle r = getBounds();
//#endif 


//#if 2103350475 
int[] xs = {
            r.x, r.x + r.width - indentX, r.x + r.width - indentX,
            r.x + r.width,   r.x + r.width,  r.x,            r.x,
        };
//#endif 


//#if 1481839965 
int[] ys = {
            r.y, r.y,                     r.y + tabHeight,
            r.y + tabHeight, r.y + r.height, r.y + r.height, r.y,
        };
//#endif 


//#if -1796062311 
Point p =
            Geometry.ptClosestTo(
                xs,
                ys,
                7,
                anotherPt);
//#endif 


//#if 1475241518 
return p;
//#endif 

} 

//#endif 


//#if -952274388 
public PackagePortFigRect(int x, int y, int w, int h, int ix, int th)
    { 

//#if 303053235 
super(x, y, w, h, null, null);
//#endif 


//#if -1707788311 
this.indentX = ix;
//#endif 


//#if 820927048 
tabHeight = th;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1814495561 
public class FigPackage extends 
//#if 219725327 
FigNodeModelElement
//#endif 

 implements 
//#if 476468389 
StereotypeContainer
//#endif 

, 
//#if -1348323131 
VisibilityContainer
//#endif 

  { 

//#if 942486022 
private static final Logger LOG = Logger.getLogger(FigPackage.class);
//#endif 


//#if -1892756589 
private static final int MIN_HEIGHT = 21;
//#endif 


//#if -576070852 
private static final int MIN_WIDTH = 50;
//#endif 


//#if 1209491227 
private int width = 140;
//#endif 


//#if 766603306 
private int height = 100;
//#endif 


//#if -486933095 
private int indentX = 50;
//#endif 


//#if -1107756827 
private int textH = 20;
//#endif 


//#if -885505082 
private int tabHeight = 20;
//#endif 


//#if -646634847 
private FigText body;
//#endif 


//#if 2097259041 
private boolean stereotypeVisible = true;
//#endif 


//#if 1133343701 
private static final long serialVersionUID = 3617092272529451041L;
//#endif 


//#if 1758526216 
@Override
    protected void textEditStarted(FigText ft)
    { 

//#if 1676452406 
if(ft == getNameFig())//1
{ 

//#if -1340329497 
showHelp("parsing.help.fig-package");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1993313402 
public void setStereotypeVisible(boolean isVisible)
    { 

//#if 385475216 
stereotypeVisible = isVisible;
//#endif 


//#if 1555536306 
renderingChanged();
//#endif 


//#if 5130091 
damage();
//#endif 

} 

//#endif 


//#if 1151391506 
@Override
    public Point getClosestPoint(Point anotherPt)
    { 

//#if 1791587090 
Rectangle r = getBounds();
//#endif 


//#if 455127303 
int[] xs = {
            r.x, r.x + r.width - indentX, r.x + r.width - indentX,
            r.x + r.width,   r.x + r.width,  r.x,            r.x,
        };
//#endif 


//#if 1141116057 
int[] ys = {
            r.y, r.y,                     r.y + tabHeight,
            r.y + tabHeight, r.y + r.height, r.y + r.height, r.y,
        };
//#endif 


//#if -1680716843 
Point p =
            Geometry.ptClosestTo(
                xs,
                ys,
                7,
                anotherPt);
//#endif 


//#if -1915553422 
return p;
//#endif 

} 

//#endif 


//#if -1520429146 
public void setVisibilityVisible(boolean isVisible)
    { 

//#if 214476073 
getNotationSettings().setShowVisibilities(isVisible);
//#endif 


//#if -1290448212 
renderingChanged();
//#endif 


//#if 504762597 
damage();
//#endif 

} 

//#endif 


//#if -141599532 
@Override
    public Object clone()
    { 

//#if 1589787366 
FigPackage figClone = (FigPackage) super.clone();
//#endif 


//#if 938622819 
for (Fig thisFig : (List<Fig>) getFigs()) //1
{ 

//#if -737252158 
if(thisFig == body)//1
{ 

//#if 1463490105 
figClone.body = (FigText) thisFig;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1804264633 
return figClone;
//#endif 

} 

//#endif 


//#if 1131330740 
@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 

//#if 1309250727 
if(mee instanceof RemoveAssociationEvent
                && "ownedElement".equals(mee.getPropertyName())
                && mee.getSource() == getOwner())//1
{ 

//#if -1750703780 
if(LOG.isInfoEnabled() && mee.getNewValue() == null)//1
{ 

//#if 1040934717 
LOG.info(Model.getFacade().getName(mee.getOldValue())
                         + " has been removed from the namespace of "
                         + Model.getFacade().getName(getOwner())
                         + " by notice of " + mee.toString());
//#endif 

} 

//#endif 


//#if -1879498643 
LayerPerspective layer = (LayerPerspective) getLayer();
//#endif 


//#if 366937414 
Fig f = layer.presentationFor(mee.getOldValue());
//#endif 


//#if -1102924886 
if(f != null && f.getEnclosingFig() == this)//1
{ 

//#if 573208566 
removeEnclosedFig(f);
//#endif 


//#if -1678547116 
f.setEnclosingFig(null);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1922402397 
super.modelChanged(mee);
//#endif 

} 

//#endif 


//#if 70181906 
@Override
    public Color getLineColor()
    { 

//#if 356010250 
return body.getLineColor();
//#endif 

} 

//#endif 


//#if -744160339 
@Override
    public Vector getPopUpActions(MouseEvent me)
    { 

//#if -1009322443 
Vector popUpActions = super.getPopUpActions(me);
//#endif 


//#if 237045953 
popUpActions.add(
            popUpActions.size() - getPopupAddOffset(),
            buildModifierPopUp(ABSTRACT | LEAF | ROOT));
//#endif 


//#if -379495604 
popUpActions.add(
            popUpActions.size() - getPopupAddOffset(),
            buildVisibilityPopUp());
//#endif 


//#if 373695848 
return popUpActions;
//#endif 

} 

//#endif 


//#if -1330807179 
@Override
    public Dimension getMinimumSize()
    { 

//#if 28805596 
Dimension aSize = new Dimension(getNameFig().getMinimumSize());
//#endif 


//#if -1346152186 
aSize.height = Math.max(aSize.height, MIN_HEIGHT);
//#endif 


//#if -1604056853 
aSize.width = Math.max(aSize.width, MIN_WIDTH);
//#endif 


//#if 1248803181 
if(isStereotypeVisible())//1
{ 

//#if 1928410228 
Dimension st = getStereotypeFig().getMinimumSize();
//#endif 


//#if -683012010 
aSize.width =
                Math.max(aSize.width, st.width);
//#endif 

} 

//#endif 


//#if 732464316 
aSize.width += indentX + 1;
//#endif 


//#if 730333280 
aSize.height += 30;
//#endif 


//#if -1007792382 
return aSize;
//#endif 

} 

//#endif 


//#if -1328964959 
@Override
    public int getLineWidth()
    { 

//#if 1362129602 
return body.getLineWidth();
//#endif 

} 

//#endif 


//#if -1082074804 
@Deprecated
    public FigPackage(@SuppressWarnings("unused") GraphModel gm, Object node)
    { 

//#if -394246390 
this(node, 0, 0);
//#endif 

} 

//#endif 


//#if 9073606 
@Override
    protected ArgoJMenu buildShowPopUp()
    { 

//#if -1821180227 
ArgoJMenu showMenu = super.buildShowPopUp();
//#endif 


//#if 4081697 
Editor ce = Globals.curEditor();
//#endif 


//#if -705259351 
List<Fig> figs = ce.getSelectionManager().getFigs();
//#endif 


//#if 1231573331 
boolean sOn = false;
//#endif 


//#if 1939429161 
boolean sOff = false;
//#endif 


//#if 642032816 
boolean vOn = false;
//#endif 


//#if 843542380 
boolean vOff = false;
//#endif 


//#if 770370424 
for (Fig f : figs) //1
{ 

//#if 2109089402 
if(f instanceof StereotypeContainer)//1
{ 

//#if -890997537 
boolean v = ((StereotypeContainer) f).isStereotypeVisible();
//#endif 


//#if 2097002124 
if(v)//1
{ 

//#if 1176941453 
sOn = true;
//#endif 

} 
else
{ 

//#if -1677045272 
sOff = true;
//#endif 

} 

//#endif 


//#if -1952186507 
v = ((VisibilityContainer) f).isVisibilityVisible();
//#endif 


//#if 1491032229 
if(v)//2
{ 

//#if -1437582126 
vOn = true;
//#endif 

} 
else
{ 

//#if 1315350595 
vOff = true;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 612554503 
if(sOn)//1
{ 

//#if 1352019992 
showMenu.add(new HideStereotypeAction());
//#endif 

} 

//#endif 


//#if 1636443223 
if(sOff)//1
{ 

//#if 1840544178 
showMenu.add(new ShowStereotypeAction());
//#endif 

} 

//#endif 


//#if -1019901750 
if(vOn)//1
{ 

//#if -633331425 
showMenu.add(new HideVisibilityAction());
//#endif 

} 

//#endif 


//#if -1725060364 
if(vOff)//1
{ 

//#if -321027800 
showMenu.add(new ShowVisibilityAction());
//#endif 

} 

//#endif 


//#if 2103302071 
return showMenu;
//#endif 

} 

//#endif 


//#if 278476322 
public boolean isVisibilityVisible()
    { 

//#if 1152613127 
return getNotationSettings().isShowVisibilities();
//#endif 

} 

//#endif 


//#if 1740469704 
@Override
    public void setLineWidth(int w)
    { 

//#if -1296045964 
getNameFig().setLineWidth(w);
//#endif 


//#if 1718410518 
body.setLineWidth(w);
//#endif 

} 

//#endif 


//#if 1220347594 
@Override
    public boolean isFilled()
    { 

//#if -33890114 
return body.isFilled();
//#endif 

} 

//#endif 


//#if -1213630551 
@Override
    protected void setStandardBounds(int xa, int ya, int w, int h)
    { 

//#if -596896214 
Rectangle oldBounds = getBounds();
//#endif 


//#if -349506078 
Dimension minimumSize = getMinimumSize();
//#endif 


//#if -1740693914 
int newW = Math.max(w, minimumSize.width);
//#endif 


//#if 1278365195 
int newH = Math.max(h, minimumSize.height);
//#endif 


//#if 589876798 
Dimension nameMin = getNameFig().getMinimumSize();
//#endif 


//#if 1439744429 
int minNameHeight = Math.max(nameMin.height, MIN_HEIGHT);
//#endif 


//#if -150743024 
int currentY = ya;
//#endif 


//#if 1814447091 
int tabWidth = newW - indentX;
//#endif 


//#if 354397225 
if(isStereotypeVisible())//1
{ 

//#if 1075897833 
Dimension stereoMin = getStereotypeFig().getMinimumSize();
//#endif 


//#if 1556324410 
getNameFig().setTopMargin(stereoMin.height);
//#endif 


//#if -272957547 
getNameFig().setBounds(xa, currentY, tabWidth + 1, minNameHeight);
//#endif 


//#if -1066805413 
getStereotypeFig().setBounds(xa, ya,
                                         tabWidth, stereoMin.height + 1);
//#endif 


//#if -2140154576 
if(tabWidth < stereoMin.width + 1)//1
{ 

//#if -929392993 
tabWidth = stereoMin.width + 2;
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1491639637 
getNameFig().setBounds(xa, currentY, tabWidth + 1, minNameHeight);
//#endif 

} 

//#endif 


//#if 1602375642 
currentY += minNameHeight - 1;
//#endif 


//#if -1200253096 
body.setBounds(xa, currentY, newW, newH + ya - currentY);
//#endif 


//#if 968785884 
tabHeight = currentY - ya;
//#endif 


//#if -1323342576 
getBigPort().setBounds(xa, ya, newW, newH);
//#endif 


//#if 378619963 
calcBounds();
//#endif 


//#if -1804134398 
updateEdges();
//#endif 


//#if 1101865079 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if -710511488 
@Override
    public boolean getUseTrapRect()
    { 

//#if 1160585545 
return true;
//#endif 

} 

//#endif 


//#if -1906756639 
@Override
    public void setFillColor(Color col)
    { 

//#if 118348789 
super.setFillColor(col);
//#endif 


//#if 787770636 
getStereotypeFig().setFillColor(null);
//#endif 


//#if -404033128 
getNameFig().setFillColor(col);
//#endif 


//#if 563921594 
body.setFillColor(col);
//#endif 

} 

//#endif 


//#if -541455831 
@Override
    protected void updateStereotypeText()
    { 

//#if -425420176 
Object modelElement = getOwner();
//#endif 


//#if 2121101455 
if(modelElement == null)//1
{ 

//#if -683010489 
return;
//#endif 

} 

//#endif 


//#if -1978556201 
Rectangle rect = getBounds();
//#endif 


//#if -1087113850 
if(Model.getFacade().getStereotypes(modelElement).isEmpty())//1
{ 

//#if -1578682657 
if(getStereotypeFig().isVisible())//1
{ 

//#if -1235638042 
getNameFig().setTopMargin(0);
//#endif 


//#if -1043300913 
getStereotypeFig().setVisible(false);
//#endif 

} 

//#endif 

} 
else
{ 

//#if 1472846177 
super.updateStereotypeText();
//#endif 


//#if -1713055381 
if(!isStereotypeVisible())//1
{ 

//#if -1148284759 
getNameFig().setTopMargin(0);
//#endif 


//#if 55505554 
getStereotypeFig().setVisible(false);
//#endif 

} 
else

//#if 377165991 
if(!getStereotypeFig().isVisible())//1
{ 

//#if 1296573430 
getNameFig().setTopMargin(
                    getStereotypeFig().getMinimumSize().height);
//#endif 


//#if -1558586908 
getStereotypeFig().setVisible(true);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1022749796 
forceRepaintShadow();
//#endif 


//#if -1482121343 
setBounds(rect.x, rect.y, rect.width, rect.height);
//#endif 

} 

//#endif 


//#if -935841854 
private void doVisibility(boolean value)
    { 

//#if -64535968 
Editor ce = Globals.curEditor();
//#endif 


//#if 1195572584 
List<Fig> figs = ce.getSelectionManager().getFigs();
//#endif 


//#if -540931017 
for (Fig f : figs) //1
{ 

//#if 107337195 
if(f instanceof VisibilityContainer)//1
{ 

//#if -824517712 
((VisibilityContainer) f).setVisibilityVisible(value);
//#endif 

} 

//#endif 


//#if 568772254 
f.damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1191870434 
private void doStereotype(boolean value)
    { 

//#if -1238329140 
Editor ce = Globals.curEditor();
//#endif 


//#if 1439491540 
List<Fig> figs = ce.getSelectionManager().getFigs();
//#endif 


//#if -676813661 
for (Fig f : figs) //1
{ 

//#if 833860053 
if(f instanceof StereotypeContainer)//1
{ 

//#if -2005927625 
((StereotypeContainer) f).setStereotypeVisible(value);
//#endif 

} 

//#endif 


//#if 1189041727 
if(f instanceof FigNodeModelElement)//1
{ 

//#if -311128159 
((FigNodeModelElement) f).forceRepaintShadow();
//#endif 


//#if 952239335 
((ArgoFig) f).renderingChanged();
//#endif 

} 

//#endif 


//#if 2049994536 
f.damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 896667555 
@Override
    public Color getFillColor()
    { 

//#if 2080281051 
return body.getFillColor();
//#endif 

} 

//#endif 


//#if -34530522 
@Override
    public String classNameAndBounds()
    { 

//#if 690045962 
return super.classNameAndBounds()
               + "stereotypeVisible=" + isStereotypeVisible()
               + ";"
               + "visibilityVisible=" + isVisibilityVisible();
//#endif 

} 

//#endif 


//#if -1265999661 

//#if -923624390 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigPackage(Object node, int x, int y)
    { 

//#if 2103909129 
body = new FigPackageFigText(0, textH, width, height - textH);
//#endif 


//#if -682250150 
setOwner(node);
//#endif 


//#if 1170314649 
initialize();
//#endif 


//#if -228732331 
setLocation(x, y);
//#endif 

} 

//#endif 


//#if -876779201 
private void createClassDiagram(
        Object namespace,
        String defaultName,
        Project project) throws PropertyVetoException
    { 

//#if 1358692621 
String namespaceDescr;
//#endif 


//#if 487685676 
if(namespace != null
                && Model.getFacade().getName(namespace) != null)//1
{ 

//#if -1079419861 
namespaceDescr = Model.getFacade().getName(namespace);
//#endif 

} 
else
{ 

//#if -1214098696 
namespaceDescr = Translator.localize("misc.name.anon");
//#endif 

} 

//#endif 


//#if -1014295749 
String dialogText = "Add new class diagram to " + namespaceDescr + "?";
//#endif 


//#if 351866163 
int option =
            JOptionPane.showConfirmDialog(
                null,
                dialogText,
                "Add new class diagram?",
                JOptionPane.YES_NO_OPTION);
//#endif 


//#if 2075705253 
if(option == JOptionPane.YES_OPTION)//1
{ 

//#if -149057573 
ArgoDiagram classDiagram =
                DiagramFactory.getInstance().
                createDiagram(DiagramType.Class, namespace, null);
//#endif 


//#if -128922127 
String diagramName = defaultName + "_" + classDiagram.getName();
//#endif 


//#if -855408747 
project.addMember(classDiagram);
//#endif 


//#if 42063676 
TargetManager.getInstance().setTarget(classDiagram);
//#endif 


//#if 29291112 
classDiagram.setName(diagramName);
//#endif 


//#if 1878273017 
ExplorerEventAdaptor.getInstance().structureChanged();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -693229232 
@Override
    public void setLineColor(Color col)
    { 

//#if -246473729 
super.setLineColor(col);
//#endif 


//#if 446248408 
getStereotypeFig().setLineColor(null);
//#endif 


//#if -400615668 
getNameFig().setLineColor(col);
//#endif 


//#if 797457710 
body.setLineColor(col);
//#endif 

} 

//#endif 


//#if 1697810568 
@Override
    public void setFilled(boolean f)
    { 

//#if 1149164299 
getStereotypeFig().setFilled(false);
//#endif 


//#if -417391531 
getNameFig().setFilled(f);
//#endif 


//#if -69509389 
body.setFilled(f);
//#endif 

} 

//#endif 


//#if 2103267842 
public boolean isStereotypeVisible()
    { 

//#if -167353759 
return stereotypeVisible;
//#endif 

} 

//#endif 


//#if 728954878 
private void initialize()
    { 

//#if 863576918 
body.setEditable(false);
//#endif 


//#if -488867131 
setBigPort(
            new PackagePortFigRect(0, 0, width, height, indentX, tabHeight));
//#endif 


//#if 1413208073 
getNameFig().setBounds(0, 0, width - indentX, textH + 2);
//#endif 


//#if 1400491618 
getNameFig().setJustification(FigText.JUSTIFY_LEFT);
//#endif 


//#if -364341730 
getBigPort().setFilled(false);
//#endif 


//#if -137799363 
getBigPort().setLineWidth(0);
//#endif 


//#if -1512982529 
getStereotypeFig().setVisible(false);
//#endif 


//#if 1874097684 
addFig(getBigPort());
//#endif 


//#if 1044531692 
addFig(getNameFig());
//#endif 


//#if -874160283 
addFig(getStereotypeFig());
//#endif 


//#if -1533606774 
addFig(body);
//#endif 


//#if 1115504790 
setBlinkPorts(false);
//#endif 


//#if 2110730707 
setFilled(true);
//#endif 


//#if -1519223788 
setFillColor(FILL_COLOR);
//#endif 


//#if 84776374 
setLineColor(LINE_COLOR);
//#endif 


//#if 1977172438 
setLineWidth(LINE_WIDTH);
//#endif 


//#if -315452868 
updateEdges();
//#endif 

} 

//#endif 


//#if -901022973 
public FigPackage(Object owner, Rectangle bounds,
                      DiagramSettings settings)
    { 

//#if -871289909 
super(owner, bounds, settings);
//#endif 


//#if -1429539715 
body = new FigPackageFigText(getOwner(),
                                     new Rectangle(0, textH, width, height - textH), getSettings());
//#endif 


//#if -1562829553 
initialize();
//#endif 


//#if 1936077936 
if(bounds != null)//1
{ 

//#if 1374692485 
setLocation(bounds.x, bounds.y);
//#endif 

} 

//#endif 


//#if -1295826574 
setBounds(getBounds());
//#endif 

} 

//#endif 


//#if 1770197801 
private class HideVisibilityAction extends 
//#if 1947087741 
UndoableAction
//#endif 

  { 

//#if 2063085244 
private static final String ACTION_KEY =
            "menu.popup.show.hide-visibility";
//#endif 


//#if -450587573 
private static final long serialVersionUID =
            8574809709777267866L;
//#endif 


//#if -1758035489 
@Override
        public void actionPerformed(ActionEvent ae)
        { 

//#if -836211817 
super.actionPerformed(ae);
//#endif 


//#if 1733691354 
doVisibility(false);
//#endif 

} 

//#endif 


//#if 43026996 
HideVisibilityAction()
        { 

//#if 832840062 
super(Translator.localize(ACTION_KEY),
                  ResourceLoaderWrapper.lookupIcon(ACTION_KEY));
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 106538913 
class FigPackageFigText extends 
//#if -1700091936 
ArgoFigText
//#endif 

  { 

//#if 302392169 
private static final long serialVersionUID = -1355316218065323634L;
//#endif 


//#if -304336270 

//#if 554802580 
@SuppressWarnings("deprecation")
//#endif 


        @Deprecated
        public FigPackageFigText(int xa, int ya, int w, int h)
        { 

//#if -1746554569 
super(xa, ya, w, h);
//#endif 

} 

//#endif 


//#if -868960601 
@Override
        public void mouseClicked(MouseEvent me)
        { 

//#if 488274346 
String lsDefaultName = "main";
//#endif 


//#if -1390288151 
if(me.getClickCount() >= 2)//1
{ 

//#if -2095749968 
Object lPkg = FigPackage.this.getOwner();
//#endif 


//#if 431649409 
if(lPkg != null)//1
{ 

//#if -1732267767 
Object lNS = lPkg;
//#endif 


//#if -1640722032 
Project lP = getProject();
//#endif 


//#if 1423232965 
List<ArgoDiagram> diags = lP.getDiagramList();
//#endif 


//#if 551663726 
ArgoDiagram lFirst = null;
//#endif 


//#if -2051100559 
for (ArgoDiagram lDiagram : diags) //1
{ 

//#if 1014402114 
Object lDiagramNS = lDiagram.getNamespace();
//#endif 


//#if 1444573265 
if((lNS == null && lDiagramNS == null)
                                || (lNS.equals(lDiagramNS)))//1
{ 

//#if -1461932046 
if(lFirst == null)//1
{ 

//#if 223124156 
lFirst = lDiagram;
//#endif 

} 

//#endif 


//#if -1714365401 
if(lDiagram.getName() != null
                                    && lDiagram.getName().startsWith(
                                        lsDefaultName))//1
{ 

//#if -507036326 
me.consume();
//#endif 


//#if 2096691363 
super.mouseClicked(me);
//#endif 


//#if 1828469148 
TargetManager.getInstance().setTarget(lDiagram);
//#endif 


//#if 228178673 
return;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1884054701 
if(lFirst != null)//1
{ 

//#if -1126217691 
me.consume();
//#endif 


//#if 1516650926 
super.mouseClicked(me);
//#endif 


//#if -923435890 
TargetManager.getInstance().setTarget(lFirst);
//#endif 


//#if 1930983932 
return;
//#endif 

} 

//#endif 


//#if -1709181715 
me.consume();
//#endif 


//#if -1570007946 
super.mouseClicked(me);
//#endif 


//#if 1977845725 
try //1
{ 

//#if 1505441653 
createClassDiagram(lNS, lsDefaultName, lP);
//#endif 

} 

//#if -530029964 
catch (Exception ex) //1
{ 

//#if 319180803 
LOG.error(ex);
//#endif 

} 

//#endif 


//#endif 


//#if -965976892 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1575841916 
super.mouseClicked(me);
//#endif 

} 

//#endif 


//#if 1803597386 
public FigPackageFigText(Object owner, Rectangle bounds,
                                 DiagramSettings settings)
        { 

//#if -1299582005 
super(owner, bounds, settings, false);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1481135356 
private class ShowStereotypeAction extends 
//#if -1614502690 
UndoableAction
//#endif 

  { 

//#if 1260252800 
private static final String ACTION_KEY =
            "menu.popup.show.show-stereotype";
//#endif 


//#if 863402790 
private static final long serialVersionUID =
            -4327161642276705610L;
//#endif 


//#if -1818833698 
@Override
        public void actionPerformed(ActionEvent ae)
        { 

//#if 1162325482 
super.actionPerformed(ae);
//#endif 


//#if -650099384 
doStereotype(true);
//#endif 

} 

//#endif 


//#if -22931536 
ShowStereotypeAction()
        { 

//#if -1605733279 
super(Translator.localize(ACTION_KEY),
                  ResourceLoaderWrapper.lookupIcon(ACTION_KEY));
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1375520028 
private class ShowVisibilityAction extends 
//#if 410539268 
UndoableAction
//#endif 

  { 

//#if -1620898950 
private static final String ACTION_KEY =
            "menu.popup.show.show-visibility";
//#endif 


//#if -1549301438 
private static final long serialVersionUID =
            7722093402948975834L;
//#endif 


//#if -998942282 
ShowVisibilityAction()
        { 

//#if 1758155331 
super(Translator.localize(ACTION_KEY),
                  ResourceLoaderWrapper.lookupIcon(ACTION_KEY));
//#endif 

} 

//#endif 


//#if 1042774776 
@Override
        public void actionPerformed(ActionEvent ae)
        { 

//#if -416143047 
super.actionPerformed(ae);
//#endif 


//#if -343424775 
doVisibility(true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1664582473 
private class HideStereotypeAction extends 
//#if 1808445528 
UndoableAction
//#endif 

  { 

//#if -2046126175 
private static final String ACTION_KEY =
            "menu.popup.show.hide-stereotype";
//#endif 


//#if 742586952 
private static final long serialVersionUID =
            1999499813643610674L;
//#endif 


//#if -1218592988 
@Override
        public void actionPerformed(ActionEvent ae)
        { 

//#if 171464214 
super.actionPerformed(ae);
//#endif 


//#if 480535993 
doStereotype(false);
//#endif 

} 

//#endif 


//#if -655039441 
HideStereotypeAction()
        { 

//#if -2129609930 
super(Translator.localize(ACTION_KEY),
                  ResourceLoaderWrapper.lookupIcon(ACTION_KEY));
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

