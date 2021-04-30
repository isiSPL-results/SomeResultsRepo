
//#if 660933232 
// Compilation Unit of /Fonts.java 
 

//#if 542681920 
import java.awt.*;
//#endif 


//#if 1443706836 
import java.awt.event.*;
//#endif 


//#if -1446511098 
import javax.swing.*;
//#endif 


//#if 632773405 
public class Fonts extends 
//#if -644415113 
JDialog
//#endif 

  { 

//#if -1333409301 
private static final long serialVersionUID = 1L;
//#endif 


//#if 571305266 
public Center center = new Center(this);
//#endif 


//#if 1515459061 
private JPanel jp = new JPanel();
//#endif 


//#if -908163071 
private JLabel fjl = new JLabel("Fonts: ");
//#endif 


//#if -1961661800 
private JComboBox fjcb = new JComboBox();
//#endif 


//#if -863155992 
private String fonts[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
//#endif 


//#if 257389794 
private JLabel sjl = new JLabel("Sizes: ");
//#endif 


//#if 1313557867 
private JComboBox sjcb = new JComboBox();
//#endif 


//#if 388767360 
private String sizes[] = {"8","10","12","14","16","18","20","24","28","32","48","72"};
//#endif 


//#if 212987944 
private JLabel tjl = new JLabel("Types: ");
//#endif 


//#if 904733642 
private JComboBox tjcb = new JComboBox();
//#endif 


//#if -371477288 
private String types[] = {"Regular", "Bold", "Italic", "Bold Italic"};
//#endif 


//#if 1476320129 
private JLabel jjl = new JLabel("Preview:");
//#endif 


//#if 2048345370 
private JLabel jl = new JLabel("AaBaCcDdeEfFgGhHjJ");
//#endif 


//#if 429355661 
private JButton okjb = new JButton("OK");
//#endif 


//#if -1741207791 
private JButton cajb = new JButton("Cancel");
//#endif 


//#if 891545843 
public JButton getOkjb()
    { 

//#if -1879212931 
return okjb;
//#endif 

} 

//#endif 


//#if 538760821 
public JButton getCajb()
    { 

//#if 551283125 
return cajb;
//#endif 

} 

//#endif 


//#if 764923617 
public Fonts()
    { 

//#if 651382792 
setTitle("Font Dialog");
//#endif 


//#if 1031405563 
setResizable(false);
//#endif 


//#if 1543503917 
jp.setLayout(new GridLayout(5,2,1,1));
//#endif 


//#if -2060963184 
jp.add(fjl);
//#endif 


//#if -649939256 
jp.add(fjcb = new JComboBox(fonts));
//#endif 


//#if -2048957411 
jp.add(sjl);
//#endif 


//#if 234658317 
jp.add(sjcb = new JComboBox(sizes));
//#endif 


//#if -2048033890 
jp.add(tjl);
//#endif 


//#if -1257613339 
jp.add(tjcb = new JComboBox(types));
//#endif 


//#if -2057269100 
jp.add(jjl);
//#endif 


//#if -421355201 
jl.setBorder(BorderFactory.createEtchedBorder());
//#endif 


//#if 210731006 
jp.add(jl);
//#endif 


//#if 793231312 
jp.add(okjb);
//#endif 


//#if 440446290 
jp.add(cajb);
//#endif 


//#if 1102509782 
this.getContentPane().add(jp);
//#endif 


//#if 593418835 
center.fCenter();
//#endif 


//#if 330257871 
fjcb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                jl.setFont(new Font(String.valueOf(fjcb.getSelectedItem()),tjcb.getSelectedIndex(),14));
            }
        });
//#endif 


//#if 467045725 
tjcb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                jl.setFont(new Font(String.valueOf(fjcb.getSelectedItem()),tjcb.getSelectedIndex(),14));
            }
        });
//#endif 

} 

//#endif 


//#if -1561439165 
public Font font()
    { 

//#if 1259091706 
Font font = new Font(String.valueOf(fjcb.getSelectedItem()), tjcb.getSelectedIndex(),
                             Integer.parseInt(String.valueOf(sjcb.getSelectedItem())));
//#endif 


//#if 2006408757 
return font;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

