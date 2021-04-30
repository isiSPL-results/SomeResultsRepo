
//#if -1667742228 
// Compilation Unit of /GuiBoard.java 
 

//#if 1000333659 
package p;
//#endif 


//#if 1040330009 
import java.awt.Color;
//#endif 


//#if -1837584150 
import java.awt.GridLayout;
//#endif 


//#if -363851410 
import javax.swing.JLabel;
//#endif 


//#if -248977314 
import javax.swing.JPanel;
//#endif 


//#if -863439740 
public class GuiBoard extends 
//#if 2013085659 
JPanel
//#endif 

  { 

//#if -768881158 
ListenerFactory listenerFactory;
//#endif 


//#if 467160449 
protected GuiBox[] boxes;
//#endif 


//#if -1199671146 
public GuiBoard(ListenerFactory listenerFactory)
    { 

//#if -936426446 
super();
//#endif 


//#if -2090761079 
this.listenerFactory = listenerFactory;
//#endif 


//#if -1744788231 
boxes = new GuiBox[Field.POSSIBILITIES];
//#endif 


//#if -1833676194 
this.setLayout(new GridLayout((int) Math.round(Math
                                      .sqrt(Field.POSSIBILITIES)), (int) Math.round(Math
                                              .sqrt(Field.POSSIBILITIES))));
//#endif 


//#if 643197188 
for (int i = 0; i < Field.POSSIBILITIES; i++) //1
{ 

//#if 1244856407 
boxes[i] = new GuiBox(i, listenerFactory);
//#endif 


//#if 1736299598 
this.add(boxes[i]);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 683935340 
public void update(Board b)
    { 

//#if 2040059302 
for (int boxNr = 0; boxNr < Field.POSSIBILITIES; boxNr++) //1
{ 

//#if -25672715 
for (int fieldNr = 0; fieldNr < Field.POSSIBILITIES; fieldNr++) //1
{ 

//#if -1612387065 
Field field = b.getField(Structure.BOX, boxNr, fieldNr);
//#endif 


//#if -206894884 
JLabel label = boxes[boxNr].getLabel(fieldNr);
//#endif 


//#if 98775348 
label.setOpaque(true);
//#endif 


//#if 248523515 
if(field.isInitialSet())//1
{ 

//#if -2088359429 
label.setText(String.valueOf(field.getValue()));
//#endif 


//#if -1505551243 
label.setBackground(Color.LIGHT_GRAY);
//#endif 


//#if 1864364610 
if(p.R4Feature.COLOR)//1
{ 

//#if -1205065577 
label.setBackground(Color.BLACK);
//#endif 


//#if -597439323 
label.setForeground(Color.ORANGE);
//#endif 

} 

//#endif 

} 
else

//#if 1570394107 
if(field.isSet())//1
{ 

//#if -1148790407 
label.setText(String.valueOf(field.getValue()));
//#endif 


//#if 452196006 
label.setBackground(Color.WHITE);
//#endif 


//#if 1776663488 
if(p.R4Feature.COLOR)//1
{ 

//#if -1764211325 
label.setForeground(Color.BLACK);
//#endif 


//#if -1107161437 
label.setBackground(Color.ORANGE);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -2051467860 
label.setText("");
//#endif 


//#if -1329020457 
label.setBackground(Color.WHITE);
//#endif 


//#if -2137823889 
if(p.R4Feature.COLOR)//1
{ 

//#if -1297271220 
label.setBackground(Color.WHITE);
//#endif 

} 

//#endif 

} 

//#endif 


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

