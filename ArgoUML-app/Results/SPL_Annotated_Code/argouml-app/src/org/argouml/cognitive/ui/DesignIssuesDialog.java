// Compilation Unit of /DesignIssuesDialog.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import java.awt.Dimension;
//#endif 


//#if COGNITIVE 
import java.awt.GridBagConstraints;
//#endif 


//#if COGNITIVE 
import java.awt.GridBagLayout;
//#endif 


//#if COGNITIVE 
import java.util.Hashtable;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if COGNITIVE 
import javax.swing.BorderFactory;
//#endif 


//#if COGNITIVE 
import javax.swing.JLabel;
//#endif 


//#if COGNITIVE 
import javax.swing.JPanel;
//#endif 


//#if COGNITIVE 
import javax.swing.JScrollPane;
//#endif 


//#if COGNITIVE 
import javax.swing.JSlider;
//#endif 


//#if COGNITIVE 
import javax.swing.SwingConstants;
//#endif 


//#if COGNITIVE 
import javax.swing.event.ChangeEvent;
//#endif 


//#if COGNITIVE 
import javax.swing.event.ChangeListener;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Decision;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.DecisionModel;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Designer;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Translator;
//#endif 


//#if COGNITIVE 
import org.argouml.util.ArgoDialog;
//#endif 


//#if COGNITIVE 
public class DesignIssuesDialog extends ArgoDialog
 implements ChangeListener
  { 
private JPanel  mainPanel = new JPanel();
private Hashtable<JSlider, Decision> slidersToDecisions =
        new Hashtable<JSlider, Decision>();
private Hashtable<JSlider, JLabel> slidersToDigits =
        new Hashtable<JSlider, JLabel>();
private String getValueText(int priority)
    { 
String label = "";
switch(priority) //1
{ 
case 1://1


//#if COGNITIVE 
label = "    1";
//#endif 


//#if COGNITIVE 
break;

//#endif 


case 2://1


//#if COGNITIVE 
label = "    2";
//#endif 


//#if COGNITIVE 
break;

//#endif 


case 3://1


//#if COGNITIVE 
label = "    3";
//#endif 


//#if COGNITIVE 
break;

//#endif 


case 0://1

case 4://1


//#if COGNITIVE 
label = Translator.localize("label.off");
//#endif 


//#if COGNITIVE 
break;

//#endif 


} 

return label;
} 

public void stateChanged(ChangeEvent ce)
    { 
JSlider srcSlider = (JSlider) ce.getSource();
Decision d = slidersToDecisions.get(srcSlider);
JLabel valLab = slidersToDigits.get(srcSlider);
int pri = srcSlider.getValue();
d.setPriority((pri == 4) ? 0 : pri);
valLab.setText(getValueText(pri));
} 

public DesignIssuesDialog()
    { 
super(Translator.localize("dialog.title.design-issues"), false);
final int width = 320;
final int height = 400;
initMainPanel();
JScrollPane scroll = new JScrollPane(mainPanel);
scroll.setPreferredSize(new Dimension(width, height));
setContent(scroll);
} 

private void initMainPanel()
    { 
DecisionModel dm = Designer.theDesigner().getDecisionModel();
List<Decision> decs = dm.getDecisionList();
GridBagLayout gb = new GridBagLayout();
mainPanel.setLayout(gb);
mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
GridBagConstraints c = new GridBagConstraints();
c.fill = GridBagConstraints.BOTH;
c.weightx = 1.0;
c.weighty = 0.0;
c.ipadx = 3;
c.ipady = 3;
c.gridy = 0;
c.gridx = 0;
c.gridwidth = 1;
JLabel decTitleLabel = new JLabel(
            Translator.localize("label.decision"));
gb.setConstraints(decTitleLabel, c);
mainPanel.add(decTitleLabel);
c.gridy = 0;
c.gridx = 2;
c.gridwidth = 8;
JLabel priLabel = new JLabel(
            Translator.localize("label.decision-priority"));
gb.setConstraints(priLabel, c);
mainPanel.add(priLabel);
c.gridy = 1;
c.gridx = 2;
c.gridwidth = 2;
JLabel offLabel = new JLabel(Translator.localize("label.off"));
gb.setConstraints(offLabel, c);
mainPanel.add(offLabel);
c.gridy = 1;
c.gridx = 4;
c.gridwidth = 2;
JLabel lowLabel = new JLabel(Translator.localize("label.low"));
gb.setConstraints(lowLabel, c);
mainPanel.add(lowLabel);
c.gridy = 1;
c.gridx = 6;
c.gridwidth = 2;
JLabel mediumLabel = new JLabel(Translator.localize("label.medium"));
gb.setConstraints(mediumLabel, c);
mainPanel.add(mediumLabel);
c.gridy = 1;
c.gridx = 8;
c.gridwidth = 2;
JLabel highLabel = new JLabel(Translator.localize("label.high"));
gb.setConstraints(highLabel, c);
mainPanel.add(highLabel);
c.gridy = 2;
for (Decision d : decs) //1
{ 
JLabel decLabel = new JLabel(d.getName());
JLabel valueLabel = new JLabel(getValueText(d.getPriority()));
JSlider decSlide =
                new JSlider(SwingConstants.HORIZONTAL,
                            1, 4, (d.getPriority() == 0 ? 4 : d.getPriority()));
decSlide.setInverted(true);
decSlide.setMajorTickSpacing(1);
decSlide.setPaintTicks(true);
decSlide.setSnapToTicks(true);
decSlide.addChangeListener(this);
Dimension origSize = decSlide.getPreferredSize();
Dimension smallSize =
                new Dimension(origSize.width / 2, origSize.height);
decSlide.setSize(smallSize);
decSlide.setPreferredSize(smallSize);
slidersToDecisions.put(decSlide, d);
slidersToDigits.put(decSlide, valueLabel);
c.gridx = 0;
c.gridwidth = 1;
c.weightx = 0.0;
c.ipadx = 3;
gb.setConstraints(decLabel, c);
mainPanel.add(decLabel);
c.gridx = 1;
c.gridwidth = 1;
c.weightx = 0.0;
c.ipadx = 0;
gb.setConstraints(valueLabel, c);
mainPanel.add(valueLabel);
c.gridx = 2;
c.gridwidth = 8;
c.weightx = 1.0;
gb.setConstraints(decSlide, c);
mainPanel.add(decSlide);
c.gridy++;
} 

} 

 } 

//#endif 


