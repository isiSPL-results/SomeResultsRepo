
//#if 1844959799 
// Compilation Unit of /TableCritics.java 
 

//#if -328847166 
package org.argouml.cognitive.critics.ui;
//#endif 


//#if -1069635637 
import java.awt.Dimension;
//#endif 


//#if 28098729 
import javax.swing.JTable;
//#endif 


//#if 726849746 
import javax.swing.ListSelectionModel;
//#endif 


//#if 359190203 
import javax.swing.event.ListSelectionListener;
//#endif 


//#if -890366498 
import javax.swing.event.TableModelEvent;
//#endif 


//#if -439607318 
import javax.swing.event.TableModelListener;
//#endif 


//#if -263860891 
import javax.swing.table.TableColumn;
//#endif 


//#if 1940094066 
import javax.swing.table.TableModel;
//#endif 


//#if -48336240 
import org.argouml.cognitive.Critic;
//#endif 


//#if -1953456888 
class TableCritics extends 
//#if -868311398 
JTable
//#endif 

  { 

//#if -1956216567 
private boolean initialised;
//#endif 


//#if -959124106 
private static final String DESC_WIDTH_TEXT =
        "This is Sample Text for determining Column Width";
//#endif 


//#if -1279002569 
public Dimension getInitialSize()
    { 

//#if 123074744 
return new Dimension(getColumnModel().getTotalColumnWidth() + 20, 0);
//#endif 

} 

//#endif 


//#if -1018542760 
public TableCritics(TableModel model,
                        ListSelectionListener lsl, TableModelListener tml)
    { 

//#if -1816821500 
super(model);
//#endif 


//#if -1913163287 
setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//#endif 


//#if -3163903 
setShowVerticalLines(false);
//#endif 


//#if 171129908 
getSelectionModel().addListSelectionListener(lsl);
//#endif 


//#if 1316953757 
getModel().addTableModelListener(tml);
//#endif 


//#if 1376455126 
setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//#endif 


//#if 1950625203 
initialised = true;
//#endif 


//#if -1029487745 
setColumnWidths();
//#endif 

} 

//#endif 


//#if 223181734 
public Critic getCriticAtRow(int row)
    { 

//#if 630903919 
TableModelCritics model = (TableModelCritics) getModel();
//#endif 


//#if -1719404967 
return model.getCriticAtRow(row);
//#endif 

} 

//#endif 


//#if 702225253 
private void setColumnWidths()
    { 

//#if -1273808246 
if(!initialised)//1
{ 

//#if 1133673273 
return;
//#endif 

} 

//#endif 


//#if 596178604 
TableColumn checkCol = getColumnModel().getColumn(0);
//#endif 


//#if 1641252276 
TableColumn descCol = getColumnModel().getColumn(1);
//#endif 


//#if -1836599432 
TableColumn actCol = getColumnModel().getColumn(2);
//#endif 


//#if 2016901127 
checkCol.setMinWidth(35);
//#endif 


//#if 194594969 
checkCol.setMaxWidth(35);
//#endif 


//#if -1965914126 
checkCol.setWidth(30);
//#endif 


//#if 1855799440 
int descWidth = getFontMetrics(getFont())
                        .stringWidth(DESC_WIDTH_TEXT);
//#endif 


//#if -1987981087 
descCol.setMinWidth(descWidth);
//#endif 


//#if 1383468087 
descCol.setWidth(descWidth);
//#endif 


//#if -968798390 
actCol.setMinWidth(50);
//#endif 


//#if 1503867553 
actCol.setMaxWidth(55);
//#endif 


//#if -1049029013 
actCol.setWidth(55);
//#endif 


//#if -1772454373 
if(getColumnModel().getColumnCount() > 3)//1
{ 

//#if 303593114 
descCol.setMinWidth(descWidth / 2);
//#endif 


//#if -356074525 
TableColumn prioCol = getColumnModel().getColumn(3);
//#endif 


//#if -94492934 
prioCol.setMinWidth(45);
//#endif 


//#if -1916774106 
prioCol.setMaxWidth(50);
//#endif 


//#if 1295343260 
prioCol.setWidth(50);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1631358348 
@Override
    public void tableChanged(TableModelEvent e)
    { 

//#if -921911543 
super.tableChanged(e);
//#endif 


//#if 1481993110 
setColumnWidths();
//#endif 

} 

//#endif 


//#if -626370507 
public void setAdvanced(boolean mode)
    { 

//#if -2019692841 
TableModelCritics model = (TableModelCritics) getModel();
//#endif 


//#if 1049336857 
model.setAdvanced(mode);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

