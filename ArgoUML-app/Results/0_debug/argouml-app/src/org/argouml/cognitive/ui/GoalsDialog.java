
//#if 1451642312 
// Compilation Unit of /GoalsDialog.java 
 

//#if 1090673103 
package org.argouml.cognitive.ui;
//#endif 


//#if -1246599571 
import java.awt.Dimension;
//#endif 


//#if -1438406417 
import java.awt.GridBagConstraints;
//#endif 


//#if -44306457 
import java.awt.GridBagLayout;
//#endif 


//#if 861878655 
import java.util.Hashtable;
//#endif 


//#if 1536474137 
import java.util.List;
//#endif 


//#if -1183116759 
import javax.swing.BorderFactory;
//#endif 


//#if -377904923 
import javax.swing.JLabel;
//#endif 


//#if -263030827 
import javax.swing.JPanel;
//#endif 


//#if 1315515560 
import javax.swing.JScrollPane;
//#endif 


//#if -886208996 
import javax.swing.JSlider;
//#endif 


//#if 168560254 
import javax.swing.SwingConstants;
//#endif 


//#if -590555407 
import javax.swing.event.ChangeEvent;
//#endif 


//#if 1995596279 
import javax.swing.event.ChangeListener;
//#endif 


//#if 167022683 
import org.argouml.cognitive.Designer;
//#endif 


//#if 168753843 
import org.argouml.cognitive.Goal;
//#endif 


//#if 11740890 
import org.argouml.cognitive.GoalModel;
//#endif 


//#if 651711564 
import org.argouml.cognitive.Translator;
//#endif 


//#if 117158863 
import org.argouml.util.ArgoDialog;
//#endif 


//#if -549708712 
public class GoalsDialog extends 
//#if -175587257 
ArgoDialog
//#endif 

 implements 
//#if 791119434 
ChangeListener
//#endif 

  { 

//#if 993636692 
private static final int DIALOG_WIDTH = 320;
//#endif 


//#if 1747216394 
private static final int DIALOG_HEIGHT = 400;
//#endif 


//#if 697194473 
private JPanel mainPanel = new JPanel();
//#endif 


//#if 1072028947 
private Hashtable<JSlider, Goal> slidersToGoals =
        new Hashtable<JSlider, Goal>();
//#endif 


//#if -1982186337 
private Hashtable<JSlider, JLabel> slidersToDigits =
        new Hashtable<JSlider, JLabel>();
//#endif 


//#if 2118142674 
private static final long serialVersionUID = -1871200638199122363L;
//#endif 


//#if -4848641 
public void stateChanged(ChangeEvent ce)
    { 

//#if 1561912314 
JSlider srcSlider = (JSlider) ce.getSource();
//#endif 


//#if -1961439511 
Goal goal = slidersToGoals.get(srcSlider);
//#endif 


//#if -1374621349 
JLabel valLab = slidersToDigits.get(srcSlider);
//#endif 


//#if 1793917577 
int pri = srcSlider.getValue();
//#endif 


//#if -20414060 
goal.setPriority(pri);
//#endif 


//#if -340542876 
if(pri == 0)//1
{ 

//#if -130254521 
valLab.setText(Translator.localize("label.off"));
//#endif 

} 
else
{ 

//#if 582213703 
valLab.setText("    " + pri);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1716428043 
private void initMainPanel()
    { 

//#if 1675676279 
GoalModel gm = Designer.theDesigner().getGoalModel();
//#endif 


//#if 1787200097 
List<Goal> goals = gm.getGoalList();
//#endif 


//#if 739591432 
GridBagLayout gb = new GridBagLayout();
//#endif 


//#if -1383900996 
mainPanel.setLayout(gb);
//#endif 


//#if -1589637037 
mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//#endif 


//#if 89298404 
GridBagConstraints c = new GridBagConstraints();
//#endif 


//#if -1109201953 
c.fill = GridBagConstraints.BOTH;
//#endif 


//#if 612509888 
c.weightx = 1.0;
//#endif 


//#if 641109248 
c.weighty = 0.0;
//#endif 


//#if -1439279342 
c.ipadx = 3;
//#endif 


//#if -1439249551 
c.ipady = 3;
//#endif 


//#if 1374137583 
c.gridy = 1;
//#endif 


//#if 128702915 
for (Goal goal : goals) //1
{ 

//#if -1449923607 
JLabel decLabel = new JLabel(goal.getName());
//#endif 


//#if -1720472258 
JLabel valueLabel = new JLabel("    " + goal.getPriority());
//#endif 


//#if 474787899 
JSlider decSlide =
                new JSlider(SwingConstants.HORIZONTAL,
                            0, 5, goal.getPriority());
//#endif 


//#if 1708332510 
decSlide.setPaintTicks(true);
//#endif 


//#if 72614493 
decSlide.setPaintLabels(true);
//#endif 


//#if -1228296253 
decSlide.addChangeListener(this);
//#endif 


//#if -903941677 
Dimension origSize = decSlide.getPreferredSize();
//#endif 


//#if 296342348 
Dimension smallSize =
                new Dimension(origSize.width / 2, origSize.height);
//#endif 


//#if 1595015237 
decSlide.setSize(smallSize);
//#endif 


//#if -1469092094 
decSlide.setPreferredSize(smallSize);
//#endif 


//#if -1250012067 
slidersToGoals.put(decSlide, goal);
//#endif 


//#if 71498479 
slidersToDigits.put(decSlide, valueLabel);
//#endif 


//#if -687646224 
c.gridx = 0;
//#endif 


//#if -1666887167 
c.gridwidth = 1;
//#endif 


//#if -1818034592 
c.weightx = 0.0;
//#endif 


//#if 793933969 
c.ipadx = 3;
//#endif 


//#if 525607243 
gb.setConstraints(decLabel, c);
//#endif 


//#if -2052632867 
mainPanel.add(decLabel);
//#endif 


//#if -687646193 
c.gridx = 1;
//#endif 


//#if 176330929 
c.gridwidth = 1;
//#endif 


//#if -1530881038 
c.weightx = 0.0;
//#endif 


//#if 793933876 
c.ipadx = 0;
//#endif 


//#if -1530741572 
gb.setConstraints(valueLabel, c);
//#endif 


//#if 1375466574 
mainPanel.add(valueLabel);
//#endif 


//#if -687646162 
c.gridx = 2;
//#endif 


//#if -1666887012 
c.gridwidth = 6;
//#endif 


//#if -1818004801 
c.weightx = 1.0;
//#endif 


//#if 336869768 
gb.setConstraints(decSlide, c);
//#endif 


//#if 186274394 
mainPanel.add(decSlide);
//#endif 


//#if -687633886 
c.gridy++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 830714458 
public GoalsDialog()
    { 

//#if 14526251 
super(Translator.localize("dialog.title.design-goals"), false);
//#endif 


//#if 1319180087 
initMainPanel();
//#endif 


//#if 584606269 
JScrollPane scroll = new JScrollPane(mainPanel);
//#endif 


//#if 1650345079 
scroll.setPreferredSize(new Dimension(DIALOG_WIDTH, DIALOG_HEIGHT));
//#endif 


//#if 1442419640 
setContent(scroll);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

