
//#if 653781875 
// Compilation Unit of /TabResults.java 
 

//#if -1561395074 
package org.argouml.ui;
//#endif 


//#if -1100395640 
import java.awt.BorderLayout;
//#endif 


//#if -1867985038 
import java.awt.Dimension;
//#endif 


//#if -1008564120 
import java.awt.event.ActionEvent;
//#endif 


//#if 208218400 
import java.awt.event.ActionListener;
//#endif 


//#if 153022479 
import java.awt.event.KeyEvent;
//#endif 


//#if 483085337 
import java.awt.event.KeyListener;
//#endif 


//#if -1850408427 
import java.awt.event.MouseEvent;
//#endif 


//#if -861490093 
import java.awt.event.MouseListener;
//#endif 


//#if 251004131 
import java.util.ArrayList;
//#endif 


//#if 1942361971 
import java.util.Enumeration;
//#endif 


//#if 2069498190 
import java.util.Iterator;
//#endif 


//#if 927625118 
import java.util.List;
//#endif 


//#if 546466180 
import javax.swing.BorderFactory;
//#endif 


//#if -999290390 
import javax.swing.JLabel;
//#endif 


//#if -884416294 
import javax.swing.JPanel;
//#endif 


//#if 311729859 
import javax.swing.JScrollPane;
//#endif 


//#if -410337412 
import javax.swing.JSplitPane;
//#endif 


//#if -770250672 
import javax.swing.JTable;
//#endif 


//#if 976469497 
import javax.swing.ListSelectionModel;
//#endif 


//#if -518296428 
import javax.swing.event.ListSelectionEvent;
//#endif 


//#if -1410742924 
import javax.swing.event.ListSelectionListener;
//#endif 


//#if 437460344 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if 1993239821 
import org.argouml.i18n.Translator;
//#endif 


//#if 1185907759 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 411694522 
import org.argouml.uml.ChildGenRelated;
//#endif 


//#if 494465394 
import org.argouml.uml.PredicateSearch;
//#endif 


//#if 1598420116 
import org.argouml.uml.TMResults;
//#endif 


//#if -1025637486 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 1943845268 
import org.argouml.util.ChildGenerator;
//#endif 


//#if 1508023008 
import org.apache.log4j.Logger;
//#endif 


//#if 1957806326 
public class TabResults extends 
//#if -1233801960 
AbstractArgoJPanel
//#endif 

 implements 
//#if 860161088 
Runnable
//#endif 

, 
//#if 887487798 
MouseListener
//#endif 

, 
//#if 809409517 
ActionListener
//#endif 

, 
//#if 1740729631 
ListSelectionListener
//#endif 

, 
//#if 1298206768 
KeyListener
//#endif 

  { 

//#if 954689662 
private static int numJumpToRelated;
//#endif 


//#if 627723508 
private static final int INSET_PX = 3;
//#endif 


//#if 513026971 
private PredicateSearch pred;
//#endif 


//#if 205252512 
private ChildGenerator cg;
//#endif 


//#if -728969350 
private Object root;
//#endif 


//#if -297845246 
private JSplitPane mainPane;
//#endif 


//#if 401596062 
private List results = new ArrayList();
//#endif 


//#if -705743661 
private List related = new ArrayList();
//#endif 


//#if -1989234676 
private List<ArgoDiagram> diagrams = new ArrayList<ArgoDiagram>();
//#endif 


//#if 397019725 
private boolean relatedShown;
//#endif 


//#if -487307291 
private JLabel resultsLabel = new JLabel();
//#endif 


//#if -84142465 
private JTable resultsTable;
//#endif 


//#if -1077526069 
private TMResults resultsModel;
//#endif 


//#if 511108314 
private JLabel relatedLabel = new JLabel();
//#endif 


//#if -1664091564 
private JTable relatedTable = new JTable(4, 4);
//#endif 


//#if 650313243 
private TMResults relatedModel = new TMResults();
//#endif 


//#if -2093661731 
private static final long serialVersionUID = 4980167466628873068L;
//#endif 


//#if -1410907316 
private static final Logger LOG = Logger.getLogger(TabResults.class);
//#endif 


//#if -1344632402 
public TabResults()
    { 

//#if -1462561904 
this(true);
//#endif 

} 

//#endif 


//#if -1643275035 
public void setPredicate(PredicateSearch p)
    { 

//#if 1188205535 
pred = p;
//#endif 

} 

//#endif 


//#if 616554764 
public void run()
    { 

//#if -1387544917 
resultsLabel.setText(Translator.localize("dialog.find.searching"));
//#endif 


//#if -845723888 
results.clear();
//#endif 


//#if -1059868685 
depthFirst(root, null);
//#endif 


//#if 2022697681 
setResults(results, diagrams);
//#endif 

} 

//#endif 


//#if 338574646 
public void mouseExited(MouseEvent me)
    { 
} 

//#endif 


//#if -276643605 
public void keyReleased(KeyEvent e)
    { 
} 

//#endif 


//#if -1807283735 
public void setResults(List res, List dia)
    { 

//#if 307217466 
results = res;
//#endif 


//#if 1457872100 
diagrams = dia;
//#endif 


//#if -1885653382 
Object[] msgArgs = {Integer.valueOf(results.size()) };
//#endif 


//#if 1152729268 
resultsLabel.setText(Translator.messageFormat(
                                 "dialog.tabresults.results-items", msgArgs));
//#endif 


//#if 1143123584 
resultsModel.setTarget(results, diagrams);
//#endif 


//#if 361682545 
relatedModel.setTarget((List) null, (List) null);
//#endif 


//#if -1188528897 
relatedLabel.setText(
            Translator.localize("dialog.tabresults.related-items"));
//#endif 

} 

//#endif 


//#if 212764145 
public void mousePressed(MouseEvent me)
    { 
} 

//#endif 


//#if 46526212 
public void keyPressed(KeyEvent e)
    { 

//#if -314780937 
if(!e.isConsumed() && e.getKeyChar() == KeyEvent.VK_ENTER)//1
{ 

//#if 713588308 
e.consume();
//#endif 


//#if 587874001 
myDoubleClick(e.getSource());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 230492770 
private void depthFirst(Object node, ArgoDiagram lastDiagram)
    { 

//#if -315328692 
if(node instanceof ArgoDiagram)//1
{ 

//#if -1895557337 
lastDiagram = (ArgoDiagram) node;
//#endif 


//#if -823709796 
if(!pred.matchDiagram(lastDiagram))//1
{ 

//#if 303477003 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 558579902 
Iterator iterator = cg.childIterator(node);
//#endif 


//#if 1065567024 
while (iterator.hasNext()) //1
{ 

//#if -772293303 
Object child = iterator.next();
//#endif 


//#if 1816145285 
if(pred.evaluate(child)
                    && (lastDiagram != null || pred.matchDiagram("")))//1
{ 

//#if -865000515 
results.add(child);
//#endif 


//#if 780111596 
diagrams.add(lastDiagram);
//#endif 

} 

//#endif 


//#if -191072570 
depthFirst(child, lastDiagram);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -538173818 
public void mouseEntered(MouseEvent me)
    { 
} 

//#endif 


//#if 2081347994 
public void setRoot(Object r)
    { 

//#if 1001715520 
root = r;
//#endif 

} 

//#endif 


//#if -1731056971 
private void myDoubleClick(Object src)
    { 

//#if 1083822884 
Object sel = null;
//#endif 


//#if 859987311 
ArgoDiagram d = null;
//#endif 


//#if -1361408857 
if(src == resultsTable)//1
{ 

//#if -1757671853 
int row = resultsTable.getSelectionModel().getMinSelectionIndex();
//#endif 


//#if -270289038 
if(row < 0)//1
{ 

//#if -729365734 
return;
//#endif 

} 

//#endif 


//#if 1738132216 
sel = results.get(row);
//#endif 


//#if -1784481972 
d = diagrams.get(row);
//#endif 

} 
else

//#if 100099532 
if(src == relatedTable)//1
{ 

//#if 1154493793 
int row = relatedTable.getSelectionModel().getMinSelectionIndex();
//#endif 


//#if 1296606639 
if(row < 0)//1
{ 

//#if 2034745406 
return;
//#endif 

} 

//#endif 


//#if -648608901 
numJumpToRelated++;
//#endif 


//#if -2074741936 
sel = related.get(row);
//#endif 

} 

//#endif 


//#endif 


//#if -1467113454 
if(d != null)//1
{ 

//#if -1780684463 
LOG.debug("go " + sel + " in " + d.getName());
//#endif 


//#if -46909281 
TargetManager.getInstance().setTarget(d);
//#endif 

} 

//#endif 


//#if 1234548021 
TargetManager.getInstance().setTarget(sel);
//#endif 

} 

//#endif 


//#if 443177371 
public AbstractArgoJPanel spawn()
    { 

//#if 302215862 
TabResults newPanel = (TabResults) super.spawn();
//#endif 


//#if -1183646874 
if(newPanel != null)//1
{ 

//#if -728360783 
newPanel.setResults(results, diagrams);
//#endif 

} 

//#endif 


//#if 1125092531 
return newPanel;
//#endif 

} 

//#endif 


//#if -1200603177 
public void selectResult(int index)
    { 

//#if -1733275366 
if(index < resultsTable.getRowCount())//1
{ 

//#if 791113129 
resultsTable.getSelectionModel().setSelectionInterval(index,
                    index);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1666940214 
public void mouseClicked(MouseEvent me)
    { 

//#if 1781594797 
if(me.getClickCount() >= 2)//1
{ 

//#if -623309280 
myDoubleClick(me.getSource());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1304582457 
public void setGenerator(ChildGenerator gen)
    { 

//#if -1688724836 
cg = gen;
//#endif 

} 

//#endif 


//#if -2082049377 
public void actionPerformed(ActionEvent ae)
    { 
} 

//#endif 


//#if 1280145788 
public void keyTyped(KeyEvent e)
    { 
} 

//#endif 


//#if -1307201028 
public void valueChanged(ListSelectionEvent lse)
    { 

//#if -775004619 
if(lse.getValueIsAdjusting())//1
{ 

//#if 85407274 
return;
//#endif 

} 

//#endif 


//#if -273289280 
if(relatedShown)//1
{ 

//#if -513256894 
int row = lse.getFirstIndex();
//#endif 


//#if -1922480610 
Object sel = results.get(row);
//#endif 


//#if 170301671 
LOG.debug("selected " + sel);
//#endif 


//#if 2014563954 
related.clear();
//#endif 


//#if -240818031 
Enumeration elems =
                ChildGenRelated.getSingleton().gen(sel);
//#endif 


//#if -1922106074 
if(elems != null)//1
{ 

//#if -1140217848 
while (elems.hasMoreElements()) //1
{ 

//#if -218607456 
related.add(elems.nextElement());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 598927389 
relatedModel.setTarget(related, null);
//#endif 


//#if 696906489 
Object[] msgArgs = {Integer.valueOf(related.size()) };
//#endif 


//#if -872995121 
relatedLabel.setText(Translator.messageFormat(
                                     "dialog.find.related-elements", msgArgs));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2146262504 
public TabResults(boolean showRelated)
    { 

//#if -2041784212 
super("Results", true);
//#endif 


//#if 47835619 
relatedShown = showRelated;
//#endif 


//#if 277136940 
setLayout(new BorderLayout());
//#endif 


//#if 1902360905 
resultsTable = new JTable(10, showRelated ? 4 : 3);
//#endif 


//#if 1971770974 
resultsModel = new TMResults(showRelated);
//#endif 


//#if 1034772225 
JPanel resultsW = new JPanel();
//#endif 


//#if -1787306485 
JScrollPane resultsSP = new JScrollPane(resultsTable);
//#endif 


//#if 1613115137 
resultsW.setLayout(new BorderLayout());
//#endif 


//#if -280331245 
resultsLabel.setBorder(BorderFactory.createEmptyBorder(
                                   INSET_PX, INSET_PX, INSET_PX, INSET_PX));
//#endif 


//#if 1135484890 
resultsW.add(resultsLabel, BorderLayout.NORTH);
//#endif 


//#if -1800489517 
resultsW.add(resultsSP, BorderLayout.CENTER);
//#endif 


//#if -710905519 
resultsTable.setModel(resultsModel);
//#endif 


//#if 1154909899 
resultsTable.addMouseListener(this);
//#endif 


//#if 2097677521 
resultsTable.addKeyListener(this);
//#endif 


//#if 318156424 
resultsTable.getSelectionModel().addListSelectionListener(
            this);
//#endif 


//#if 1264464564 
resultsTable.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION);
//#endif 


//#if 467587928 
resultsW.setMinimumSize(new Dimension(100, 100));
//#endif 


//#if 1283898998 
JPanel relatedW = new JPanel();
//#endif 


//#if 247061912 
if(relatedShown)//1
{ 

//#if -829431305 
JScrollPane relatedSP = new JScrollPane(relatedTable);
//#endif 


//#if -25311304 
relatedW.setLayout(new BorderLayout());
//#endif 


//#if -635625092 
relatedLabel.setBorder(BorderFactory.createEmptyBorder(
                                       INSET_PX, INSET_PX, INSET_PX, INSET_PX));
//#endif 


//#if 1820191110 
relatedW.add(relatedLabel, BorderLayout.NORTH);
//#endif 


//#if 1476196991 
relatedW.add(relatedSP, BorderLayout.CENTER);
//#endif 


//#if -402475533 
relatedTable.setModel(relatedModel);
//#endif 


//#if 1390076226 
relatedTable.addMouseListener(this);
//#endif 


//#if 243175688 
relatedTable.addKeyListener(this);
//#endif 


//#if -351135615 
relatedW.setMinimumSize(new Dimension(100, 100));
//#endif 

} 

//#endif 


//#if -1352448487 
if(relatedShown)//2
{ 

//#if -766508885 
mainPane =
                new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                               resultsW,
                               relatedW);
//#endif 


//#if 489349582 
add(mainPane, BorderLayout.CENTER);
//#endif 

} 
else
{ 

//#if 260298185 
add(resultsW, BorderLayout.CENTER);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1345596682 
public void mouseReleased(MouseEvent me)
    { 
} 

//#endif 


//#if 547441901 
public void doDoubleClick()
    { 

//#if -278025884 
myDoubleClick(resultsTable);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

