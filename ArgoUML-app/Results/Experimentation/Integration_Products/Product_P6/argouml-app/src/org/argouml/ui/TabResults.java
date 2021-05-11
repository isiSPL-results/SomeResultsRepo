package org.argouml.ui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.argouml.application.api.AbstractArgoJPanel;
import org.argouml.i18n.Translator;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ChildGenRelated;
import org.argouml.uml.PredicateSearch;
import org.argouml.uml.TMResults;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.util.ChildGenerator;
import org.apache.log4j.Logger;
public class TabResults extends AbstractArgoJPanel
 implements Runnable
,MouseListener
,ActionListener
,ListSelectionListener
,KeyListener
  { 
private static int numJumpToRelated;
private static final int INSET_PX = 3;
private PredicateSearch pred;
private ChildGenerator cg;
private Object root;
private JSplitPane mainPane;
private List results = new ArrayList();
private List related = new ArrayList();
private List<ArgoDiagram> diagrams = new ArrayList<ArgoDiagram>();
private boolean relatedShown;
private JLabel resultsLabel = new JLabel();
private JTable resultsTable;
private TMResults resultsModel;
private JLabel relatedLabel = new JLabel();
private JTable relatedTable = new JTable(4, 4);
private TMResults relatedModel = new TMResults();
private static final long serialVersionUID = 4980167466628873068L;
private static final Logger LOG = Logger.getLogger(TabResults.class);
public TabResults()
    { 
this(true);
} 
public void setPredicate(PredicateSearch p)
    { 
pred = p;
} 
public void run()
    { 
resultsLabel.setText(Translator.localize("dialog.find.searching"));
results.clear();
depthFirst(root, null);
setResults(results, diagrams);
} 
public void mouseExited(MouseEvent me)
    { 
} 
public void keyReleased(KeyEvent e)
    { 
} 
public void setResults(List res, List dia)
    { 
results = res;
diagrams = dia;
Object[] msgArgs = {Integer.valueOf(results.size()) };
resultsLabel.setText(Translator.messageFormat(
                                 "dialog.tabresults.results-items", msgArgs));
resultsModel.setTarget(results, diagrams);
relatedModel.setTarget((List) null, (List) null);
relatedLabel.setText(
            Translator.localize("dialog.tabresults.related-items"));
} 
public void mousePressed(MouseEvent me)
    { 
} 
public void keyPressed(KeyEvent e)
    { 
if(!e.isConsumed() && e.getKeyChar() == KeyEvent.VK_ENTER)//1
{ 
e.consume();
myDoubleClick(e.getSource());
} 
} 
private void depthFirst(Object node, ArgoDiagram lastDiagram)
    { 
if(node instanceof ArgoDiagram)//1
{ 
lastDiagram = (ArgoDiagram) node;
if(!pred.matchDiagram(lastDiagram))//1
{ 
return;
} 
} 
Iterator iterator = cg.childIterator(node);
while (iterator.hasNext()) //1
{ 
Object child = iterator.next();
if(pred.evaluate(child)
                    && (lastDiagram != null || pred.matchDiagram("")))//1
{ 
results.add(child);
diagrams.add(lastDiagram);
} 
depthFirst(child, lastDiagram);
} 
} 
public void mouseEntered(MouseEvent me)
    { 
} 
public void setRoot(Object r)
    { 
root = r;
} 
private void myDoubleClick(Object src)
    { 
Object sel = null;
ArgoDiagram d = null;
if(src == resultsTable)//1
{ 
int row = resultsTable.getSelectionModel().getMinSelectionIndex();
if(row < 0)//1
{ 
return;
} 
sel = results.get(row);
d = diagrams.get(row);
} 
else
if(src == relatedTable)//1
{ 
int row = relatedTable.getSelectionModel().getMinSelectionIndex();
if(row < 0)//1
{ 
return;
} 
numJumpToRelated++;
sel = related.get(row);
} 
if(d != null)//1
{ 
LOG.debug("go " + sel + " in " + d.getName());
TargetManager.getInstance().setTarget(d);
} 
TargetManager.getInstance().setTarget(sel);
} 
public AbstractArgoJPanel spawn()
    { 
TabResults newPanel = (TabResults) super.spawn();
if(newPanel != null)//1
{ 
newPanel.setResults(results, diagrams);
} 
return newPanel;
} 
public void selectResult(int index)
    { 
if(index < resultsTable.getRowCount())//1
{ 
resultsTable.getSelectionModel().setSelectionInterval(index,
                    index);
} 
} 
public void mouseClicked(MouseEvent me)
    { 
if(me.getClickCount() >= 2)//1
{ 
myDoubleClick(me.getSource());
} 
} 
public void setGenerator(ChildGenerator gen)
    { 
cg = gen;
} 
public void actionPerformed(ActionEvent ae)
    { 
} 
public void keyTyped(KeyEvent e)
    { 
} 
public void valueChanged(ListSelectionEvent lse)
    { 
if(lse.getValueIsAdjusting())//1
{ 
return;
} 
if(relatedShown)//1
{ 
int row = lse.getFirstIndex();
Object sel = results.get(row);
LOG.debug("selected " + sel);
related.clear();
Enumeration elems =
                ChildGenRelated.getSingleton().gen(sel);
if(elems != null)//1
{ 
while (elems.hasMoreElements()) //1
{ 
related.add(elems.nextElement());
} 
} 
relatedModel.setTarget(related, null);
Object[] msgArgs = {Integer.valueOf(related.size()) };
relatedLabel.setText(Translator.messageFormat(
                                     "dialog.find.related-elements", msgArgs));
} 
} 
public TabResults(boolean showRelated)
    { 
super("Results", true);
relatedShown = showRelated;
setLayout(new BorderLayout());
resultsTable = new JTable(10, showRelated ? 4 : 3);
resultsModel = new TMResults(showRelated);
JPanel resultsW = new JPanel();
JScrollPane resultsSP = new JScrollPane(resultsTable);
resultsW.setLayout(new BorderLayout());
resultsLabel.setBorder(BorderFactory.createEmptyBorder(
                                   INSET_PX, INSET_PX, INSET_PX, INSET_PX));
resultsW.add(resultsLabel, BorderLayout.NORTH);
resultsW.add(resultsSP, BorderLayout.CENTER);
resultsTable.setModel(resultsModel);
resultsTable.addMouseListener(this);
resultsTable.addKeyListener(this);
resultsTable.getSelectionModel().addListSelectionListener(
            this);
resultsTable.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION);
resultsW.setMinimumSize(new Dimension(100, 100));
JPanel relatedW = new JPanel();
if(relatedShown)//1
{ 
JScrollPane relatedSP = new JScrollPane(relatedTable);
relatedW.setLayout(new BorderLayout());
relatedLabel.setBorder(BorderFactory.createEmptyBorder(
                                       INSET_PX, INSET_PX, INSET_PX, INSET_PX));
relatedW.add(relatedLabel, BorderLayout.NORTH);
relatedW.add(relatedSP, BorderLayout.CENTER);
relatedTable.setModel(relatedModel);
relatedTable.addMouseListener(this);
relatedTable.addKeyListener(this);
relatedW.setMinimumSize(new Dimension(100, 100));
} 
if(relatedShown)//2
{ 
mainPane =
                new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                               resultsW,
                               relatedW);
add(mainPane, BorderLayout.CENTER);
} 
else
{ 
add(resultsW, BorderLayout.CENTER);
} 
} 
public void mouseReleased(MouseEvent me)
    { 
} 
public void doDoubleClick()
    { 
myDoubleClick(resultsTable);
} 

 } 
