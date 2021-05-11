
//#if 297349174 
// Compilation Unit of /SaveGraphicsManager.java 
 

//#if 720834192 
package org.argouml.uml.ui;
//#endif 


//#if 269499741 
import java.awt.Rectangle;
//#endif 


//#if -1101258436 
import java.awt.event.ActionEvent;
//#endif 


//#if -740019101 
import java.awt.image.BufferedImage;
//#endif 


//#if 492055481 
import java.awt.image.RenderedImage;
//#endif 


//#if 1619151794 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1875891818 
import java.beans.PropertyChangeListener;
//#endif 


//#if -1619377224 
import java.io.File;
//#endif 


//#if 491954137 
import java.io.IOException;
//#endif 


//#if -2121650957 
import java.io.OutputStream;
//#endif 


//#if -1779305841 
import java.util.ArrayList;
//#endif 


//#if -1938057071 
import java.util.Collections;
//#endif 


//#if -253284998 
import java.util.Comparator;
//#endif 


//#if -74205662 
import java.util.Iterator;
//#endif 


//#if 1734583922 
import java.util.List;
//#endif 


//#if 749571626 
import javax.imageio.ImageIO;
//#endif 


//#if -1008240205 
import javax.swing.JFileChooser;
//#endif 


//#if 124503292 
import javax.swing.SwingUtilities;
//#endif 


//#if 9949836 
import org.apache.log4j.Logger;
//#endif 


//#if -1693914267 
import org.argouml.configuration.Configuration;
//#endif 


//#if -1828589966 
import org.argouml.configuration.ConfigurationKey;
//#endif 


//#if 1801725259 
import org.argouml.gefext.DeferredBufferedImage;
//#endif 


//#if -880283975 
import org.argouml.i18n.Translator;
//#endif 


//#if -1202390144 
import org.argouml.util.FileFilters;
//#endif 


//#if -1322197650 
import org.argouml.util.SuffixFilter;
//#endif 


//#if -1898520186 
import org.tigris.gef.base.Editor;
//#endif 


//#if -869104909 
import org.tigris.gef.base.Globals;
//#endif 


//#if -874503230 
import org.tigris.gef.base.SaveEPSAction;
//#endif 


//#if 1613018534 
import org.tigris.gef.base.SaveGIFAction;
//#endif 


//#if 1515483541 
import org.tigris.gef.base.SaveGraphicsAction;
//#endif 


//#if 1139869601 
import org.tigris.gef.base.SavePNGAction;
//#endif 


//#if 950885245 
import org.tigris.gef.base.SavePSAction;
//#endif 


//#if -1024404730 
import org.tigris.gef.base.SaveSVGAction;
//#endif 


//#if -848023769 
import org.tigris.gef.persistence.export.PostscriptWriter;
//#endif 


//#if -1515354604 
public final class SaveGraphicsManager  { 

//#if -1702661566 
private static final int MIN_MARGIN = 15;
//#endif 


//#if 1499812625 
public static final ConfigurationKey KEY_DEFAULT_GRAPHICS_FILTER =
        Configuration.makeKey("graphics", "default", "filter");
//#endif 


//#if 1562176009 
public static final ConfigurationKey KEY_SAVE_GRAPHICS_PATH =
        Configuration.makeKey("graphics", "save", "path");
//#endif 


//#if -347345396 
public static final ConfigurationKey KEY_SAVEALL_GRAPHICS_PATH =
        Configuration.makeKey("graphics", "save-all", "path");
//#endif 


//#if 1521321254 
public static final ConfigurationKey KEY_GRAPHICS_RESOLUTION =
        Configuration.makeKey("graphics", "export", "resolution");
//#endif 


//#if -2055080559 
private SuffixFilter defaultFilter;
//#endif 


//#if -1735358987 
private List<SuffixFilter> otherFilters = new ArrayList<SuffixFilter>();
//#endif 


//#if -1242119979 
private static SaveGraphicsManager instance;
//#endif 


//#if 1192822363 
public static SaveGraphicsManager getInstance()
    { 

//#if 547780314 
if(instance == null)//1
{ 

//#if 1335817945 
instance  = new SaveGraphicsManager();
//#endif 

} 

//#endif 


//#if 414142145 
return instance;
//#endif 

} 

//#endif 


//#if -1716438900 
public SaveGraphicsAction getSaveActionBySuffix(String suffix)
    { 

//#if -1971940028 
SaveGraphicsAction cmd = null;
//#endif 


//#if 1483142306 
if(FileFilters.PS_FILTER.getSuffix().equals(suffix))//1
{ 

//#if 2140800492 
cmd = new SavePSAction(Translator.localize("action.save-ps"));
//#endif 

} 
else

//#if -196269494 
if(FileFilters.EPS_FILTER.getSuffix().equals(suffix))//1
{ 

//#if -1815276992 
cmd = new SaveScaledEPSAction(
                Translator.localize("action.save-eps"));
//#endif 

} 
else

//#if -1725801026 
if(FileFilters.PNG_FILTER.getSuffix().equals(suffix))//1
{ 

//#if 406392184 
cmd = new SavePNGAction2(Translator.localize("action.save-png"));
//#endif 

} 
else

//#if -144900593 
if(FileFilters.GIF_FILTER.getSuffix().equals(suffix))//1
{ 

//#if -569594218 
cmd = new SaveGIFAction(Translator.localize("action.save-gif"));
//#endif 

} 
else

//#if -52350568 
if(FileFilters.SVG_FILTER.getSuffix().equals(suffix))//1
{ 

//#if -1292850014 
cmd = new SaveSVGAction(Translator.localize("action.save-svg"));
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if -1640337568 
return cmd;
//#endif 

} 

//#endif 


//#if 153851416 
public void setDefaultFilterBySuffix(String suffix)
    { 

//#if -767087714 
for (SuffixFilter sf : otherFilters) //1
{ 

//#if 2143887675 
if(sf.getSuffix().equalsIgnoreCase(suffix))//1
{ 

//#if -1288248590 
setDefaultFilter(sf);
//#endif 


//#if -202529504 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -700758115 
static Rectangle adjustDrawingArea(Rectangle area)
    { 

//#if -295607261 
int xMargin = area.x;
//#endif 


//#if 238725116 
if(xMargin < 0)//1
{ 

//#if 1074511188 
xMargin = 0;
//#endif 

} 

//#endif 


//#if 1211944579 
int yMargin = area.y;
//#endif 


//#if -54677891 
if(yMargin < 0)//1
{ 

//#if -1917625675 
yMargin = 0;
//#endif 

} 

//#endif 


//#if 2045920014 
int margin = Math.max(xMargin, yMargin);
//#endif 


//#if -1236078741 
if(margin < MIN_MARGIN)//1
{ 

//#if -183398239 
margin = MIN_MARGIN;
//#endif 

} 

//#endif 


//#if -1693921897 
return new Rectangle(0, 0,
                             area.width + (2 * margin),
                             area.height + (2 * margin));
//#endif 

} 

//#endif 


//#if 62304652 
public String fixExtension(String in)
    { 

//#if 1404721756 
if(getFilterFromFileName(in) == null)//1
{ 

//#if 2146347288 
in += "." + getDefaultSuffix();
//#endif 

} 

//#endif 


//#if -615525271 
return in;
//#endif 

} 

//#endif 


//#if -1040951680 
private SaveGraphicsManager()
    { 

//#if 1870992510 
defaultFilter = FileFilters.PNG_FILTER;
//#endif 


//#if -515299070 
otherFilters.add(FileFilters.GIF_FILTER);
//#endif 


//#if -1048351134 
otherFilters.add(FileFilters.SVG_FILTER);
//#endif 


//#if 586194345 
otherFilters.add(FileFilters.PS_FILTER);
//#endif 


//#if 1273069598 
otherFilters.add(FileFilters.EPS_FILTER);
//#endif 


//#if 1598441324 
setDefaultFilterBySuffix(Configuration.getString(
                                     KEY_DEFAULT_GRAPHICS_FILTER,
                                     defaultFilter.getSuffix()));
//#endif 

} 

//#endif 


//#if 1043565659 
public List<SuffixFilter> getSettingsList()
    { 

//#if -941915510 
List<SuffixFilter> c = new ArrayList<SuffixFilter>();
//#endif 


//#if 1333258890 
c.add(defaultFilter);
//#endif 


//#if -177068629 
c.addAll(otherFilters);
//#endif 


//#if -1736761673 
return c;
//#endif 

} 

//#endif 


//#if -963735325 
public void setDefaultFilter(SuffixFilter f)
    { 

//#if -2025584040 
otherFilters.remove(f);
//#endif 


//#if -1611141549 
if(!otherFilters.contains(defaultFilter))//1
{ 

//#if -340706921 
otherFilters.add(defaultFilter);
//#endif 

} 

//#endif 


//#if -1077897448 
defaultFilter = f;
//#endif 


//#if 989861320 
Configuration.setString(
            KEY_DEFAULT_GRAPHICS_FILTER,
            f.getSuffix());
//#endif 


//#if 1120392313 
Collections.sort(otherFilters, new Comparator<SuffixFilter>() {
            public int compare(SuffixFilter arg0, SuffixFilter arg1) {
                return arg0.getSuffix().compareToIgnoreCase(
                           arg1.getSuffix());
            }
        });
//#endif 

} 

//#endif 


//#if 313815189 
public SuffixFilter getFilterFromFileName(String name)
    { 

//#if -1540087228 
if(name.toLowerCase()
                .endsWith("." + defaultFilter.getSuffix()))//1
{ 

//#if 935969726 
return defaultFilter;
//#endif 

} 

//#endif 


//#if 65968502 
Iterator iter = otherFilters.iterator();
//#endif 


//#if 1983568801 
while (iter.hasNext()) //1
{ 

//#if 1326393912 
SuffixFilter filter = (SuffixFilter) iter.next();
//#endif 


//#if -1321015780 
if(name.toLowerCase().endsWith("." + filter.getSuffix()))//1
{ 

//#if -2024779668 
return filter;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -12244870 
return null;
//#endif 

} 

//#endif 


//#if -1272614249 
public void register(SuffixFilter f)
    { 

//#if 1361821429 
otherFilters.add(f);
//#endif 

} 

//#endif 


//#if 923444632 
public void setFileChooserFilters(
        JFileChooser chooser, String defaultName)
    { 

//#if -61280369 
chooser.addChoosableFileFilter(defaultFilter);
//#endif 


//#if -14403902 
Iterator iter = otherFilters.iterator();
//#endif 


//#if 439587541 
while (iter.hasNext()) //1
{ 

//#if -1825330672 
chooser.addChoosableFileFilter((SuffixFilter) iter.next());
//#endif 

} 

//#endif 


//#if -718604952 
chooser.setFileFilter(defaultFilter);
//#endif 


//#if -118777533 
String fileName = defaultName + "." + defaultFilter.getSuffix();
//#endif 


//#if -860928664 
chooser.setSelectedFile(new File(fileName));
//#endif 


//#if 1549835270 
chooser.addPropertyChangeListener(
            JFileChooser.FILE_FILTER_CHANGED_PROPERTY,
            new FileFilterChangedListener(chooser, defaultName));
//#endif 

} 

//#endif 


//#if -443440524 
public String getDefaultSuffix()
    { 

//#if -1442823186 
return defaultFilter.getSuffix();
//#endif 

} 

//#endif 


//#if 1066550343 
static class FileFilterChangedListener implements 
//#if 1927688026 
PropertyChangeListener
//#endif 

  { 

//#if -1211531273 
private JFileChooser chooser;
//#endif 


//#if 1850221986 
private String defaultName;
//#endif 


//#if -269295439 
public FileFilterChangedListener(JFileChooser c, String name)
        { 

//#if -142038272 
chooser = c;
//#endif 


//#if 1974709433 
defaultName = name;
//#endif 

} 

//#endif 


//#if 715898230 
public void propertyChange(PropertyChangeEvent evt)
        { 

//#if -75349043 
SuffixFilter filter = (SuffixFilter) evt.getNewValue();
//#endif 


//#if -2096487723 
String fileName = defaultName + "." + filter.getSuffix();
//#endif 


//#if 1763292351 
SwingUtilities.invokeLater(new Anonymous1(fileName));
//#endif 

} 

//#endif 


//#if 1188709019 
class Anonymous1 implements 
//#if -342621643 
Runnable
//#endif 

  { 

//#if -914303240 
private String fileName;
//#endif 


//#if 210384247 
public void run()
            { 

//#if 2010260605 
chooser.setSelectedFile(new File(fileName));
//#endif 

} 

//#endif 


//#if 1946594020 
Anonymous1(String fn)
            { 

//#if 703466424 
fileName = fn;
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#if -712947435 
class SaveScaledEPSAction extends 
//#if 1776328668 
SaveEPSAction
//#endif 

  { 

//#if 580457389 
@Override
    protected void saveGraphics(OutputStream s, Editor ce,
                                Rectangle drawingArea)
    throws IOException
    { 

//#if -240253462 
double editorScale = ce.getScale();
//#endif 


//#if -1146047937 
int x = (int) (drawingArea.x * editorScale);
//#endif 


//#if 2086984769 
int y = (int) (drawingArea.y * editorScale);
//#endif 


//#if -127549382 
int h = (int) (drawingArea.height * editorScale);
//#endif 


//#if -1593719092 
int w = (int) (drawingArea.width * editorScale);
//#endif 


//#if 916584118 
drawingArea = new Rectangle(x, y, w, h);
//#endif 


//#if 1222391805 
PostscriptWriter ps = new PostscriptWriter(s, drawingArea);
//#endif 


//#if 1127455190 
ps.scale(editorScale, editorScale);
//#endif 


//#if -1885054499 
ce.print(ps);
//#endif 


//#if -497792409 
ps.dispose();
//#endif 

} 

//#endif 


//#if -1784161433 
SaveScaledEPSAction(String name)
    { 

//#if 1329572864 
super(name);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -388170009 
class SaveGIFAction2 extends 
//#if 1456343624 
SaveGIFAction
//#endif 

  { 

//#if 1970469085 
@Override
    protected void saveGraphics(OutputStream s, Editor ce,
                                Rectangle drawingArea) throws IOException
    { 

//#if -437854072 
Rectangle canvasArea =
            SaveGraphicsManager.adjustDrawingArea(drawingArea);
//#endif 


//#if -1624112754 
RenderedImage i = new DeferredBufferedImage(canvasArea,
                BufferedImage.TYPE_INT_ARGB, ce, scale);
//#endif 


//#if -1800415287 
ImageIO.write(i, "gif", s);
//#endif 

} 

//#endif 


//#if -1413838801 
SaveGIFAction2(String name)
    { 

//#if -696630929 
super(name);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -861318942 
class SavePNGAction2 extends 
//#if -1456061505 
SavePNGAction
//#endif 

  { 

//#if -2093424613 
private static final Logger LOG = Logger.getLogger(SavePNGAction2.class);
//#endif 


//#if 2124573899 
@Override
    protected void saveGraphics(OutputStream s, Editor ce,
                                Rectangle drawingArea)
    throws IOException
    { 

//#if 160232703 
Rectangle canvasArea =
            SaveGraphicsManager.adjustDrawingArea(drawingArea);
//#endif 


//#if 1328449093 
RenderedImage i = new DeferredBufferedImage(canvasArea,
                BufferedImage.TYPE_INT_ARGB, ce, scale);
//#endif 


//#if 80750112 
LOG.debug("Created DeferredBufferedImage - drawingArea = "
                  + canvasArea + " , scale = " + scale);
//#endif 


//#if 768354619 
ImageIO.write(i, "png", s);
//#endif 

} 

//#endif 


//#if -106639771 
@Override
    public void actionPerformed(ActionEvent ae)
    { 

//#if -2069808104 
Editor ce = Globals.curEditor();
//#endif 


//#if 1610569653 
Rectangle drawingArea =
            ce.getLayerManager().getActiveLayer().calcDrawingArea();
//#endif 


//#if 683672599 
if(drawingArea.width <= 0 || drawingArea.height <= 0)//1
{ 

//#if -1001095050 
Rectangle dummyArea = new Rectangle(0, 0, 50, 50);
//#endif 


//#if 2015200164 
try //1
{ 

//#if -762386233 
saveGraphics(outputStream, ce, dummyArea);
//#endif 

} 

//#if 1142616556 
catch (java.io.IOException e) //1
{ 

//#if 929648380 
LOG.error("Error while exporting Graphics:", e);
//#endif 

} 

//#endif 


//#endif 


//#if 192010717 
return;
//#endif 

} 

//#endif 


//#if -751015320 
super.actionPerformed(ae);
//#endif 

} 

//#endif 


//#if -498096104 
SavePNGAction2(String name)
    { 

//#if 2067231201 
super(name);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

