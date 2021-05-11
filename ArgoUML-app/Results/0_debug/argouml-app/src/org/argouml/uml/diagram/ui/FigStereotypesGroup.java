
//#if 1544341684 
// Compilation Unit of /FigStereotypesGroup.java 
 

//#if -1923633227 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 215884422 
import java.awt.Dimension;
//#endif 


//#if 1535608241 
import java.awt.Image;
//#endif 


//#if 202105757 
import java.awt.Rectangle;
//#endif 


//#if -755592718 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 426447951 
import java.util.ArrayList;
//#endif 


//#if 1674582770 
import java.util.Collection;
//#endif 


//#if -575902542 
import java.util.List;
//#endif 


//#if -81128372 
import org.apache.log4j.Logger;
//#endif 


//#if -1850447125 
import org.argouml.kernel.Project;
//#endif 


//#if 1245977838 
import org.argouml.model.AddAssociationEvent;
//#endif 


//#if 1766408127 
import org.argouml.model.Model;
//#endif 


//#if 1749400241 
import org.argouml.model.RemoveAssociationEvent;
//#endif 


//#if -436956254 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1064782518 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -902133838 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if -900266615 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 863352409 
public class FigStereotypesGroup extends 
//#if -643592106 
ArgoFigGroup
//#endif 

  { 

//#if 710768413 
private Fig bigPort;
//#endif 


//#if 1355212206 
private static final Logger LOG =
        Logger.getLogger(FigStereotypesGroup.class);
//#endif 


//#if -422180412 
private String keyword;
//#endif 


//#if -422417191 
private int stereotypeCount = 0;
//#endif 


//#if -277377541 
private boolean hidingStereotypesWithIcon = false;
//#endif 


//#if 394136172 
public void setKeyword(String word)
    { 

//#if 1368196661 
keyword = word;
//#endif 


//#if -200875288 
populate();
//#endif 

} 

//#endif 


//#if 1761950699 

//#if 1490288984 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigStereotypesGroup(int x, int y, int w, int h)
    { 

//#if -108464574 
super();
//#endif 


//#if -1606683431 
constructFigs(x, y, w, h);
//#endif 

} 

//#endif 


//#if 1785731464 
private void reorderStereotypeFigs()
    { 

//#if 1704338724 
List<Fig> allFigs = getFigs();
//#endif 


//#if -1177920344 
List<Fig> figsWithIcon = new ArrayList<Fig>();
//#endif 


//#if 2072854920 
List<Fig> figsWithOutIcon = new ArrayList<Fig>();
//#endif 


//#if -1948097709 
List<Fig> others = new ArrayList<Fig>();
//#endif 


//#if 1095799957 
for (Fig f : allFigs) //1
{ 

//#if -1839241261 
if(f instanceof FigStereotype)//1
{ 

//#if -486818015 
FigStereotype s = (FigStereotype) f;
//#endif 


//#if 1874967907 
if(getIconForStereotype(s) != null)//1
{ 

//#if -2008225050 
figsWithIcon.add(s);
//#endif 

} 
else
{ 

//#if -1368593056 
figsWithOutIcon.add(s);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1008732770 
others.add(f);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1399726828 
List<Fig> n = new ArrayList<Fig>();
//#endif 


//#if 1642231847 
n.addAll(others);
//#endif 


//#if -1973963406 
n.addAll(figsWithOutIcon);
//#endif 


//#if -2032369422 
n.addAll(figsWithIcon);
//#endif 


//#if 1535401811 
setFigs(n);
//#endif 

} 

//#endif 


//#if -80703704 
@Override
    public void propertyChange(PropertyChangeEvent event)
    { 

//#if 1941519037 
if(event instanceof AddAssociationEvent)//1
{ 

//#if -1358771469 
AddAssociationEvent aae = (AddAssociationEvent) event;
//#endif 


//#if -625308125 
if(event.getPropertyName().equals("stereotype"))//1
{ 

//#if -919550606 
Object stereotype = aae.getChangedValue();
//#endif 


//#if 1561187080 
if(findFig(stereotype) == null)//1
{ 

//#if -1585037193 
FigText stereotypeTextFig =
                        new FigStereotype(stereotype,
                                          getBoundsForNextStereotype(),
                                          getSettings());
//#endif 


//#if -581254692 
stereotypeCount++;
//#endif 


//#if -690641392 
addFig(stereotypeTextFig);
//#endif 


//#if -1275666596 
reorderStereotypeFigs();
//#endif 


//#if 727322285 
damage();
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1784060554 
LOG.warn("Unexpected property " + event.getPropertyName());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1403973750 
if(event instanceof RemoveAssociationEvent)//1
{ 

//#if 102704849 
if(event.getPropertyName().equals("stereotype"))//1
{ 

//#if -2060944467 
RemoveAssociationEvent rae = (RemoveAssociationEvent) event;
//#endif 


//#if 1407951111 
Object stereotype = rae.getChangedValue();
//#endif 


//#if 1269107992 
Fig f = findFig(stereotype);
//#endif 


//#if -950758422 
if(f != null)//1
{ 

//#if -786039043 
removeFig(f);
//#endif 


//#if 151856784 
f.removeFromDiagram();
//#endif 


//#if 163976561 
--stereotypeCount;
//#endif 

} 

//#endif 

} 
else
{ 

//#if 836968851 
LOG.warn("Unexpected property " + event.getPropertyName());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1829393114 
private void updateHiddenStereotypes()
    { 

//#if 1442165023 
List<Fig> figs = getFigs();
//#endif 


//#if 531314972 
for (Fig f : figs) //1
{ 

//#if 861068432 
if(f instanceof FigStereotype)//1
{ 

//#if -575002704 
FigStereotype fs = (FigStereotype) f;
//#endif 


//#if 1090258509 
fs.setVisible(getIconForStereotype(fs) == null
                              || !isHidingStereotypesWithIcon());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1467723817 
public void setHidingStereotypesWithIcon(boolean hideStereotypesWithIcon)
    { 

//#if 1930904760 
this.hidingStereotypesWithIcon = hideStereotypesWithIcon;
//#endif 


//#if 752504861 
updateHiddenStereotypes();
//#endif 

} 

//#endif 


//#if -1813404059 
private FigKeyword findFigKeyword()
    { 

//#if -213447994 
for (Object f : getFigs()) //1
{ 

//#if 1465560215 
if(f instanceof FigKeyword)//1
{ 

//#if -676949857 
return (FigKeyword) f;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1546660206 
return null;
//#endif 

} 

//#endif 


//#if -1681315724 
@Override
    protected void setBoundsImpl(int x, int y, int w, int h)
    { 

//#if -190267343 
Rectangle oldBounds = getBounds();
//#endif 


//#if -1941137762 
int yy = y;
//#endif 


//#if 1799718242 
for  (Fig fig : (Collection<Fig>) getFigs()) //1
{ 

//#if 986685323 
if(fig != bigPort)//1
{ 

//#if -1429387972 
fig.setBounds(x + 1, yy + 1, w - 2,
                              fig.getMinimumSize().height);
//#endif 


//#if 2083998722 
yy += fig.getMinimumSize().height;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1250424942 
bigPort.setBounds(x, y, w, h);
//#endif 


//#if -1617086974 
calcBounds();
//#endif 


//#if 1677384830 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if 1470066886 
private FigStereotype findFig(Object stereotype)
    { 

//#if 684237917 
for (Object f : getFigs()) //1
{ 

//#if 356307973 
if(f instanceof FigStereotype)//1
{ 

//#if 317592692 
FigStereotype fs = (FigStereotype) f;
//#endif 


//#if -1623102032 
if(fs.getOwner() == stereotype)//1
{ 

//#if -1214048410 
return fs;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -555595963 
return null;
//#endif 

} 

//#endif 


//#if 308765587 
@Deprecated
    protected Fig getBigPort()
    { 

//#if 141957932 
return bigPort;
//#endif 

} 

//#endif 


//#if 22056045 
@Override
    public Dimension getMinimumSize()
    { 

//#if 1854997062 
Dimension dim = null;
//#endif 


//#if -2135358561 
Object modelElement = getOwner();
//#endif 


//#if -191797604 
if(modelElement != null)//1
{ 

//#if 1203133574 
List<FigStereotype> stereos = getStereotypeFigs();
//#endif 


//#if 957656711 
if(stereos.size() > 0 || keyword != null)//1
{ 

//#if 748115757 
int minWidth = 0;
//#endif 


//#if 154513974 
int minHeight = 0;
//#endif 


//#if 1697364104 
for (Fig fig : (Collection<Fig>) getFigs()) //1
{ 

//#if 1411385442 
if(fig.isVisible() && fig != bigPort)//1
{ 

//#if -1005720124 
int fw = fig.getMinimumSize().width;
//#endif 


//#if 1119796284 
if(fw > minWidth)//1
{ 

//#if -1707615826 
minWidth = fw;
//#endif 

} 

//#endif 


//#if -873447721 
minHeight += fig.getMinimumSize().height;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 555367756 
minHeight += 2;
//#endif 


//#if -1895660392 
dim = new Dimension(minWidth, minHeight);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -652278535 
if(dim == null)//1
{ 

//#if -883155538 
dim = new Dimension(0, 0);
//#endif 

} 

//#endif 


//#if 1620297648 
return dim;
//#endif 

} 

//#endif 


//#if -2122764991 
public FigStereotypesGroup(Object owner, Rectangle bounds,
                               DiagramSettings settings)
    { 

//#if 1812134603 
super(owner, settings);
//#endif 


//#if 634073892 
constructFigs(bounds.x, bounds.y, bounds.width, bounds.height);
//#endif 


//#if -1669219647 
Model.getPump().addModelEventListener(this, owner, "stereotype");
//#endif 


//#if 1471407264 
populate();
//#endif 

} 

//#endif 


//#if -1283213548 
List<FigStereotype> getStereotypeFigs()
    { 

//#if 224035414 
final List<FigStereotype> stereotypeFigs =
            new ArrayList<FigStereotype>();
//#endif 


//#if -231841959 
for (Object f : getFigs()) //1
{ 

//#if -1299432629 
if(f instanceof FigStereotype)//1
{ 

//#if 2104990098 
FigStereotype fs = (FigStereotype) f;
//#endif 


//#if 1636538031 
stereotypeFigs.add(fs);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1323743097 
return stereotypeFigs;
//#endif 

} 

//#endif 


//#if -2054571813 
public boolean isHidingStereotypesWithIcon()
    { 

//#if -1484570944 
return hidingStereotypesWithIcon;
//#endif 

} 

//#endif 


//#if -1878844406 
public void populate()
    { 

//#if 550900285 
stereotypeCount = 0;
//#endif 


//#if -571493212 
Object modelElement = getOwner();
//#endif 


//#if 1073726939 
if(modelElement == null)//1
{ 

//#if -1673967350 
LOG.debug("Cannot populate the stereotype compartment "
                      + "unless the parent has an owner.");
//#endif 


//#if 2008732212 
return;
//#endif 

} 

//#endif 


//#if 1172751588 
if(LOG.isDebugEnabled())//1
{ 

//#if -1896516945 
LOG.debug("Populating stereotypes compartment for "
                      + Model.getFacade().getName(modelElement));
//#endif 

} 

//#endif 


//#if 1002759674 
Collection<Fig> removeCollection = new ArrayList<Fig>(getFigs());
//#endif 


//#if 1728809979 
if(keyword != null)//1
{ 

//#if -1494375342 
FigKeyword keywordFig = findFigKeyword();
//#endif 


//#if 1025630882 
if(keywordFig == null)//1
{ 

//#if 538507519 
keywordFig =
                    new FigKeyword(keyword,
                                   getBoundsForNextStereotype(),
                                   getSettings());
//#endif 


//#if 1092308517 
addFig(keywordFig);
//#endif 

} 
else
{ 

//#if -1047969588 
removeCollection.remove(keywordFig);
//#endif 

} 

//#endif 


//#if 1384345457 
++stereotypeCount;
//#endif 

} 

//#endif 


//#if -1299472075 
for (Object stereo : Model.getFacade().getStereotypes(modelElement)) //1
{ 

//#if 1728354655 
FigStereotype stereotypeTextFig = findFig(stereo);
//#endif 


//#if -240266625 
if(stereotypeTextFig == null)//1
{ 

//#if -1204397149 
stereotypeTextFig =
                    new FigStereotype(stereo,
                                      getBoundsForNextStereotype(),
                                      getSettings());
//#endif 


//#if 1467108023 
addFig(stereotypeTextFig);
//#endif 

} 
else
{ 

//#if 1426341323 
removeCollection.remove(stereotypeTextFig);
//#endif 

} 

//#endif 


//#if 1440731220 
++stereotypeCount;
//#endif 

} 

//#endif 


//#if -1497587183 
for (Fig f : removeCollection) //1
{ 

//#if 322511639 
if(f instanceof FigStereotype || f instanceof FigKeyword)//1
{ 

//#if -1594286421 
removeFig(f);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1195576176 
reorderStereotypeFigs();
//#endif 


//#if 1717969470 
updateHiddenStereotypes();
//#endif 

} 

//#endif 


//#if 170672930 
private void constructFigs(int x, int y, int w, int h)
    { 

//#if -725959906 
bigPort = new FigRect(x, y, w, h, LINE_COLOR, FILL_COLOR);
//#endif 


//#if -1462621437 
addFig(bigPort);
//#endif 


//#if 451182559 
setLineWidth(0);
//#endif 


//#if 714228668 
setFilled(false);
//#endif 

} 

//#endif 


//#if -1672551425 
@Override
    public void removeFromDiagram()
    { 

//#if -1601604904 
for (Object f : getFigs()) //1
{ 

//#if 1089755873 
((Fig) f).removeFromDiagram();
//#endif 

} 

//#endif 


//#if 1294936844 
super.removeFromDiagram();
//#endif 


//#if -35621977 
Model.getPump()
        .removeModelEventListener(this, getOwner(), "stereotype");
//#endif 

} 

//#endif 


//#if 665629900 
public int getStereotypeCount()
    { 

//#if 1974668858 
return stereotypeCount;
//#endif 

} 

//#endif 


//#if 1240529299 

//#if -586522456 
@SuppressWarnings("deprecation")
//#endif 


    @Override
    @Deprecated
    public void setOwner(Object own)
    { 

//#if 1836299009 
if(own != null)//1
{ 

//#if 121230445 
super.setOwner(own);
//#endif 


//#if 836920933 
Model.getPump().addModelEventListener(this, own, "stereotype");
//#endif 


//#if 1566127927 
populate();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2096560072 
private Image getIconForStereotype(FigStereotype fs)
    { 

//#if 743118365 
Project project = getProject();
//#endif 


//#if -193451424 
if(project == null)//1
{ 

//#if -343525191 
LOG.warn("getProject() returned null");
//#endif 


//#if -1147901171 
return null;
//#endif 

} 

//#endif 


//#if 1569730120 
Object owner = fs.getOwner();
//#endif 


//#if -1451061382 
if(owner == null)//1
{ 

//#if 124326157 
return null;
//#endif 

} 
else
{ 

//#if -947114906 
return project.getProfileConfiguration().getFigNodeStrategy()
                   .getIconForStereotype(owner);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -267234798 
private Rectangle getBoundsForNextStereotype()
    { 

//#if -1280840884 
return new Rectangle(
                   bigPort.getX() + 1,
                   bigPort.getY() + 1
                   + (stereotypeCount
                      * ROWHEIGHT),
                   0,
                   ROWHEIGHT - 2);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

