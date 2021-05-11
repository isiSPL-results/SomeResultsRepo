
//#if 1423236692 
// Compilation Unit of /DesignIssuesDialog.java 
 

//#if 591229294 
package org.argouml.cognitive.ui;
//#endif 


//#if 980882350 
import java.awt.Dimension;
//#endif 


//#if -367569714 
import java.awt.GridBagConstraints;
//#endif 


//#if 160830632 
import java.awt.GridBagLayout;
//#endif 


//#if 1194341470 
import java.util.Hashtable;
//#endif 


//#if 813445594 
import java.util.List;
//#endif 


//#if -1682560568 
import javax.swing.BorderFactory;
//#endif 


//#if 1849576998 
import javax.swing.JLabel;
//#endif 


//#if 1964451094 
import javax.swing.JPanel;
//#endif 


//#if -915169273 
import javax.swing.JScrollPane;
//#endif 


//#if -553746181 
import javax.swing.JSlider;
//#endif 


//#if 1865671359 
import javax.swing.SwingConstants;
//#endif 


//#if 1986332432 
import javax.swing.event.ChangeEvent;
//#endif 


//#if 1815759224 
import javax.swing.event.ChangeListener;
//#endif 


//#if 1436920139 
import org.argouml.cognitive.Decision;
//#endif 


//#if 1903810370 
import org.argouml.cognitive.DecisionModel;
//#endif 


//#if -1553832932 
import org.argouml.cognitive.Designer;
//#endif 


//#if 471874509 
import org.argouml.cognitive.Translator;
//#endif 


//#if 1187995566 
import org.argouml.util.ArgoDialog;
//#endif 


//#if 610558225 
public class DesignIssuesDialog extends 
//#if 67629971 
ArgoDialog
//#endif 

 implements 
//#if -1190906986 
ChangeListener
//#endif 

  { 

//#if -268226019 
private JPanel  mainPanel = new JPanel();
//#endif 


//#if -1008326378 
private Hashtable<JSlider, Decision> slidersToDecisions =
        new Hashtable<JSlider, Decision>();
//#endif 


//#if -1063806765 
private Hashtable<JSlider, JLabel> slidersToDigits =
        new Hashtable<JSlider, JLabel>();
//#endif 


//#if -725765740 
private String getValueText(int priority)
    { 

//#if 1326034604 
String label = "";
//#endif 


//#if -1735482260 
switch(priority) //1
{ 
case 1://1


//#if 296329198 
label = "    1";
//#endif 


//#if -1696183975 
break;

//#endif 


case 2://1


//#if -1348777368 
label = "    2";
//#endif 


//#if 463615122 
break;

//#endif 


case 3://1


//#if 1941095773 
label = "    3";
//#endif 


//#if -1076009530 
break;

//#endif 


case 0://1

case 4://1


//#if 928056884 
label = Translator.localize("label.off");
//#endif 


//#if -245324523 
break;

//#endif 


} 

//#endif 


//#if 1859530924 
return label;
//#endif 

} 

//#endif 


//#if -61005517 
public void stateChanged(ChangeEvent ce)
    { 

//#if 546706673 
JSlider srcSlider = (JSlider) ce.getSource();
//#endif 


//#if -776525129 
Decision d = slidersToDecisions.get(srcSlider);
//#endif 


//#if -206173948 
JLabel valLab = slidersToDigits.get(srcSlider);
//#endif 


//#if 1319144498 
int pri = srcSlider.getValue();
//#endif 


//#if 943990737 
d.setPriority((pri == 4) ? 0 : pri);
//#endif 


//#if 1221251706 
valLab.setText(getValueText(pri));
//#endif 

} 

//#endif 


//#if 411668092 
public DesignIssuesDialog()
    { 

//#if 1369793520 
super(Translator.localize("dialog.title.design-issues"), false);
//#endif 


//#if -795481295 
final int width = 320;
//#endif 


//#if -1259700819 
final int height = 400;
//#endif 


//#if 476621302 
initMainPanel();
//#endif 


//#if 1930195068 
JScrollPane scroll = new JScrollPane(mainPanel);
//#endif 


//#if -812112854 
scroll.setPreferredSize(new Dimension(width, height));
//#endif 


//#if 562533529 
setContent(scroll);
//#endif 

} 

//#endif 


//#if 1618327639 
private void initMainPanel()
    { 

//#if 41586063 
DecisionModel dm = Designer.theDesigner().getDecisionModel();
//#endif 


//#if 38962272 
List<Decision> decs = dm.getDecisionList();
//#endif 


//#if -204401825 
GridBagLayout gb = new GridBagLayout();
//#endif 


//#if 389618373 
mainPanel.setLayout(gb);
//#endif 


//#if -409140324 
mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//#endif 


//#if -571213459 
GridBagConstraints c = new GridBagConstraints();
//#endif 


//#if 964263350 
c.fill = GridBagConstraints.BOTH;
//#endif 


//#if 976761353 
c.weightx = 1.0;
//#endif 


//#if 1005360713 
c.weighty = 0.0;
//#endif 


//#if -1460769573 
c.ipadx = 3;
//#endif 


//#if -1460739782 
c.ipady = 3;
//#endif 


//#if 1352647321 
c.gridy = 0;
//#endif 


//#if 1352617530 
c.gridx = 0;
//#endif 


//#if 1127878987 
c.gridwidth = 1;
//#endif 


//#if -961844506 
JLabel decTitleLabel = new JLabel(
            Translator.localize("label.decision"));
//#endif 


//#if 191437613 
gb.setConstraints(decTitleLabel, c);
//#endif 


//#if 804405197 
mainPanel.add(decTitleLabel);
//#endif 


//#if 1333215513 
c.gridy = 0;
//#endif 


//#if 1352617592 
c.gridx = 2;
//#endif 


//#if 1127879204 
c.gridwidth = 8;
//#endif 


//#if -910693944 
JLabel priLabel = new JLabel(
            Translator.localize("label.decision-priority"));
//#endif 


//#if -783382640 
gb.setConstraints(priLabel, c);
//#endif 


//#if 417789794 
mainPanel.add(priLabel);
//#endif 


//#if 1352647352 
c.gridy = 1;
//#endif 


//#if 447558874 
c.gridx = 2;
//#endif 


//#if 1127879018 
c.gridwidth = 2;
//#endif 


//#if 1637954570 
JLabel offLabel = new JLabel(Translator.localize("label.off"));
//#endif 


//#if -234345016 
gb.setConstraints(offLabel, c);
//#endif 


//#if -104543334 
mainPanel.add(offLabel);
//#endif 


//#if 1334139034 
c.gridy = 1;
//#endif 


//#if 1352617654 
c.gridx = 4;
//#endif 


//#if 1114715304 
c.gridwidth = 2;
//#endif 


//#if 1147404820 
JLabel lowLabel = new JLabel(Translator.localize("label.low"));
//#endif 


//#if 1339951491 
gb.setConstraints(lowLabel, c);
//#endif 


//#if 960780821 
mainPanel.add(lowLabel);
//#endif 


//#if 1334139035 
c.gridy = 1;
//#endif 


//#if 1352617716 
c.gridx = 6;
//#endif 


//#if 1114715305 
c.gridwidth = 2;
//#endif 


//#if -1315718432 
JLabel mediumLabel = new JLabel(Translator.localize("label.medium"));
//#endif 


//#if 1369160590 
gb.setConstraints(mediumLabel, c);
//#endif 


//#if 1276542510 
mainPanel.add(mediumLabel);
//#endif 


//#if 1334139036 
c.gridy = 1;
//#endif 


//#if 1352617778 
c.gridx = 8;
//#endif 


//#if 1114715306 
c.gridwidth = 2;
//#endif 


//#if 1488074496 
JLabel highLabel = new JLabel(Translator.localize("label.high"));
//#endif 


//#if -189451903 
gb.setConstraints(highLabel, c);
//#endif 


//#if -1584316767 
mainPanel.add(highLabel);
//#endif 


//#if 1352647383 
c.gridy = 2;
//#endif 


//#if -563159165 
for (Decision d : decs) //1
{ 

//#if -1774933573 
JLabel decLabel = new JLabel(d.getName());
//#endif 


//#if -1010172084 
JLabel valueLabel = new JLabel(getValueText(d.getPriority()));
//#endif 


//#if 1534877968 
JSlider decSlide =
                new JSlider(SwingConstants.HORIZONTAL,
                            1, 4, (d.getPriority() == 0 ? 4 : d.getPriority()));
//#endif 


//#if 174615424 
decSlide.setInverted(true);
//#endif 


//#if 1013694299 
decSlide.setMajorTickSpacing(1);
//#endif 


//#if -1818555107 
decSlide.setPaintTicks(true);
//#endif 


//#if 782082282 
decSlide.setSnapToTicks(true);
//#endif 


//#if 1161162626 
decSlide.addChangeListener(this);
//#endif 


//#if 608862324 
Dimension origSize = decSlide.getPreferredSize();
//#endif 


//#if 1823786861 
Dimension smallSize =
                new Dimension(origSize.width / 2, origSize.height);
//#endif 


//#if -1428249306 
decSlide.setSize(smallSize);
//#endif 


//#if -1557678271 
decSlide.setPreferredSize(smallSize);
//#endif 


//#if -2055151546 
slidersToDecisions.put(decSlide, d);
//#endif 


//#if -586216530 
slidersToDigits.put(decSlide, valueLabel);
//#endif 


//#if -1797905135 
c.gridx = 0;
//#endif 


//#if 1340843170 
c.gridwidth = 1;
//#endif 


//#if 1189695745 
c.weightx = 0.0;
//#endif 


//#if -316324942 
c.ipadx = 3;
//#endif 


//#if -1433726484 
gb.setConstraints(decLabel, c);
//#endif 


//#if 1048808510 
mainPanel.add(decLabel);
//#endif 


//#if -1797905104 
c.gridx = 1;
//#endif 


//#if 1863071344 
c.gridwidth = 1;
//#endif 


//#if 155859377 
c.weightx = 0.0;
//#endif 


//#if -316325035 
c.ipadx = 0;
//#endif 


//#if 1040189725 
gb.setConstraints(valueLabel, c);
//#endif 


//#if 1153326447 
mainPanel.add(valueLabel);
//#endif 


//#if -1797905073 
c.gridx = 2;
//#endif 


//#if 1340843387 
c.gridwidth = 8;
//#endif 


//#if 1189725536 
c.weightx = 1.0;
//#endif 


//#if -1622463959 
gb.setConstraints(decSlide, c);
//#endif 


//#if -1007251525 
mainPanel.add(decSlide);
//#endif 


//#if -1797892797 
c.gridy++;
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

