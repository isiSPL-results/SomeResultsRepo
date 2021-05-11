
//#if -1346651927 
// Compilation Unit of /DiagramSettings.java 
 

//#if 381842440 
package org.argouml.uml.diagram;
//#endif 


//#if -1022040302 
import java.awt.Font;
//#endif 


//#if 538655337 
import org.argouml.notation.NotationSettings;
//#endif 


//#if -1331192658 
import org.tigris.gef.undo.Memento;
//#endif 


//#if -1543717404 
public class DiagramSettings  { 

//#if 1704878707 
private DiagramSettings parent;
//#endif 


//#if -1760164999 
private NotationSettings notationSettings;
//#endif 


//#if 887104920 
private String fontName;
//#endif 


//#if -840006587 
private Integer fontSize;
//#endif 


//#if 81604197 
private Boolean showBoldNames;
//#endif 


//#if -2046224665 
private Font fontPlain;
//#endif 


//#if -696894571 
private Font fontItalic;
//#endif 


//#if 1168089184 
private Font fontBold;
//#endif 


//#if -1110387632 
private Font fontBoldItalic;
//#endif 


//#if 807811707 
private Boolean showBidirectionalArrows;
//#endif 


//#if -1810333744 
private Integer defaultShadowWidth;
//#endif 


//#if -930709878 
private StereotypeStyle defaultStereotypeView;
//#endif 


//#if -547151082 
public void setNotationSettings(NotationSettings notationSettings)
    { 

//#if -1017405561 
this.notationSettings = notationSettings;
//#endif 

} 

//#endif 


//#if 970752908 
public DiagramSettings(DiagramSettings parentSettings)
    { 

//#if -641786943 
super();
//#endif 


//#if -299729923 
parent = parentSettings;
//#endif 


//#if 1730558597 
if(parentSettings == null)//1
{ 

//#if 120019309 
notationSettings = new NotationSettings();
//#endif 

} 
else
{ 

//#if -1156703652 
notationSettings =
                new NotationSettings(parent.getNotationSettings());
//#endif 

} 

//#endif 


//#if 579096088 
recomputeFonts();
//#endif 

} 

//#endif 


//#if -1322258137 
public void setDefaultStereotypeView(final int newView)
    { 

//#if 1845549423 
StereotypeStyle sv = StereotypeStyle.getEnum(newView);
//#endif 


//#if -1002609488 
if(sv == null)//1
{ 

//#if -756205152 
throw new IllegalArgumentException("Bad argument " + newView);
//#endif 

} 

//#endif 


//#if 2022215130 
setDefaultStereotypeView(sv);
//#endif 

} 

//#endif 


//#if -1203769324 
public void setFontName(String newFontName)
    { 

//#if 1540488055 
if(fontName != null && fontName.equals(newFontName))//1
{ 

//#if 1306927088 
return;
//#endif 

} 

//#endif 


//#if -1890721145 
fontName = newFontName;
//#endif 


//#if 1841385437 
recomputeFonts();
//#endif 

} 

//#endif 


//#if 1447420648 
public Font getFontBold()
    { 

//#if 1047976638 
if(fontBold == null)//1
{ 

//#if -1237198864 
return parent.getFontBold();
//#endif 

} 

//#endif 


//#if -1668152505 
return fontBold;
//#endif 

} 

//#endif 


//#if -696824311 
public boolean isShowBoldNames()
    { 

//#if 573884534 
if(showBoldNames == null)//1
{ 

//#if -1251224303 
if(parent != null)//1
{ 

//#if 855723451 
return parent.isShowBoldNames();
//#endif 

} 
else
{ 

//#if 1587710795 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -787710863 
return showBoldNames;
//#endif 

} 

//#endif 


//#if -1446378669 
public Font getFontItalic()
    { 

//#if -870404912 
if(fontItalic == null)//1
{ 

//#if 562580515 
return parent.getFontItalic();
//#endif 

} 

//#endif 


//#if -974118749 
return fontItalic;
//#endif 

} 

//#endif 


//#if -1020283312 
public Font getFont(int fontStyle)
    { 

//#if -1112326398 
if((fontStyle & Font.ITALIC) != 0)//1
{ 

//#if -473833324 
if((fontStyle & Font.BOLD) != 0)//1
{ 

//#if -65417676 
return getFontBoldItalic();
//#endif 

} 
else
{ 

//#if 473386805 
return getFontItalic();
//#endif 

} 

//#endif 

} 
else
{ 

//#if 548398128 
if((fontStyle & Font.BOLD) != 0)//1
{ 

//#if -1132159103 
return getFontBold();
//#endif 

} 
else
{ 

//#if -1819793419 
return getFontPlain();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1099343647 
public int getDefaultShadowWidth()
    { 

//#if 1043889622 
if(defaultShadowWidth == null)//1
{ 

//#if -330899463 
if(parent != null)//1
{ 

//#if -1033501590 
return parent.getDefaultShadowWidth();
//#endif 

} 
else
{ 

//#if 178132755 
return 0;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1823565981 
return defaultShadowWidth;
//#endif 

} 

//#endif 


//#if 1364686825 
public Font getFontPlain()
    { 

//#if 1524848414 
if(fontPlain == null)//1
{ 

//#if 346575280 
return parent.getFontPlain();
//#endif 

} 

//#endif 


//#if 1229927631 
return fontPlain;
//#endif 

} 

//#endif 


//#if -1902285832 
public Font getFontBoldItalic()
    { 

//#if 573011232 
if(fontBoldItalic == null)//1
{ 

//#if 484671103 
return parent.getFontBoldItalic();
//#endif 

} 

//#endif 


//#if -1721642295 
return fontBoldItalic;
//#endif 

} 

//#endif 


//#if 716853654 
public void setShowBoldNames(final boolean showem)
    { 

//#if -1193733661 
if(showBoldNames != null && showBoldNames == showem)//1
{ 

//#if -261788197 
return;
//#endif 

} 

//#endif 


//#if -1847116259 
Memento memento = new Memento() {
            public void redo() {
                showBoldNames = showem;
            }

            public void undo() {
                showBoldNames = !showem;
            }
        };
//#endif 


//#if 335335902 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if -1998883264 
public void setShowBidirectionalArrows(final boolean showem)
    { 

//#if -230353277 
if(showBidirectionalArrows != null
                && showBidirectionalArrows == showem)//1
{ 

//#if 1768712699 
return;
//#endif 

} 

//#endif 


//#if 1490825149 
Memento memento = new Memento() {
            public void redo() {
                showBidirectionalArrows = showem;
            }

            public void undo() {
                showBidirectionalArrows = !showem;
            }
        };
//#endif 


//#if 828210366 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if -1064603389 
public DiagramSettings()
    { 

//#if 599976303 
this(null);
//#endif 

} 

//#endif 


//#if 1021966668 
public int getFontSize()
    { 

//#if 270217322 
if(fontSize == null)//1
{ 

//#if -387285580 
if(parent != null)//1
{ 

//#if -358762700 
return parent.getFontSize();
//#endif 

} 
else
{ 

//#if -1389204492 
return 10;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2135919739 
return fontSize;
//#endif 

} 

//#endif 


//#if -365495635 
private void recomputeFonts()
    { 

//#if -732665070 
if((fontName != null && !"".equals(fontName) && fontSize != null)
                || parent == null)//1
{ 

//#if -555452508 
String name = getFontName();
//#endif 


//#if -39272088 
int size = getFontSize();
//#endif 


//#if -675277451 
fontPlain = new Font(name, Font.PLAIN, size);
//#endif 


//#if -1846259071 
fontItalic = new Font(name, Font.ITALIC, size);
//#endif 


//#if 955239457 
fontBold = new Font(name, Font.BOLD, size);
//#endif 


//#if -1413202626 
fontBoldItalic = new Font(name, Font.BOLD | Font.ITALIC, size);
//#endif 

} 
else
{ 

//#if -1829320731 
fontPlain = null;
//#endif 


//#if 2026143747 
fontItalic = null;
//#endif 


//#if -22309992 
fontBold = null;
//#endif 


//#if -305536728 
fontBoldItalic = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1234644906 
public void setFontSize(int newFontSize)
    { 

//#if -732037431 
if(fontSize != null && fontSize == newFontSize)//1
{ 

//#if 1658768372 
return;
//#endif 

} 

//#endif 


//#if 153960313 
fontSize = newFontSize;
//#endif 


//#if -884402117 
recomputeFonts();
//#endif 

} 

//#endif 


//#if -81308489 
public void setDefaultStereotypeView(final StereotypeStyle newView)
    { 

//#if -1208624278 
if(defaultStereotypeView != null && defaultStereotypeView == newView)//1
{ 

//#if -915414055 
return;
//#endif 

} 

//#endif 


//#if -1980251160 
final StereotypeStyle oldValue = defaultStereotypeView;
//#endif 


//#if 1342491292 
Memento memento = new Memento() {
            public void redo() {
                defaultStereotypeView = newView;
            }

            public void undo() {
                defaultStereotypeView = oldValue;
            }
        };
//#endif 


//#if 1923065617 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if -1255760031 
public void setDefaultShadowWidth(final int newWidth)
    { 

//#if -597338074 
if(defaultShadowWidth != null && defaultShadowWidth == newWidth)//1
{ 

//#if -71639718 
return;
//#endif 

} 

//#endif 


//#if -981609109 
final Integer oldValue = defaultShadowWidth;
//#endif 


//#if 2091558062 
Memento memento = new Memento() {
            public void redo() {
                defaultShadowWidth = newWidth;
            }

            public void undo() {
                defaultShadowWidth = oldValue;
            }
        };
//#endif 


//#if -694606676 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if -456584125 
public NotationSettings getNotationSettings()
    { 

//#if -1615964066 
return notationSettings;
//#endif 

} 

//#endif 


//#if 1215456748 
public String getFontName()
    { 

//#if 1630162267 
if(fontName == null)//1
{ 

//#if -177860010 
if(parent != null)//1
{ 

//#if 1820510036 
return parent.getFontName();
//#endif 

} 
else
{ 

//#if 862668176 
return "Dialog";
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1642849112 
return fontName;
//#endif 

} 

//#endif 


//#if 896717998 
public StereotypeStyle getDefaultStereotypeView()
    { 

//#if 1243435619 
if(defaultStereotypeView == null)//1
{ 

//#if -2072962356 
if(parent != null)//1
{ 

//#if -2030221360 
return parent.getDefaultStereotypeView();
//#endif 

} 
else
{ 

//#if -2136229903 
return StereotypeStyle.TEXTUAL;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1379169350 
return defaultStereotypeView;
//#endif 

} 

//#endif 


//#if -1298694605 
public boolean isShowBidirectionalArrows()
    { 

//#if -1529947592 
if(showBidirectionalArrows == null)//1
{ 

//#if 615694339 
if(parent != null)//1
{ 

//#if -378643752 
return parent.isShowBidirectionalArrows();
//#endif 

} 
else
{ 

//#if -1176148175 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1930869215 
return showBidirectionalArrows;
//#endif 

} 

//#endif 


//#if 1935775699 
public int getDefaultStereotypeViewInt()
    { 

//#if -2105632429 
return getDefaultStereotypeView().ordinal();
//#endif 

} 

//#endif 


//#if -1278884394 
private void doUndoable(Memento memento)
    { 

//#if -94455053 
memento.redo();
//#endif 

} 

//#endif 


//#if 2140369617 
public enum StereotypeStyle {

//#if 901931248 
TEXTUAL(DiagramAppearance.STEREOTYPE_VIEW_TEXTUAL),

//#endif 


//#if 1173143806 
BIG_ICON(DiagramAppearance.STEREOTYPE_VIEW_BIG_ICON),

//#endif 


//#if 1326646494 
SMALL_ICON(DiagramAppearance.STEREOTYPE_VIEW_SMALL_ICON),

//#endif 

;
//#if 729008285 
StereotypeStyle(int value)
        { 

//#if -1221718925 
assert value == this.ordinal();
//#endif 

} 

//#endif 


//#if 720951215 
public static StereotypeStyle getEnum(int value)
        { 

//#if 579481704 
int counter = 0;
//#endif 


//#if 1063313604 
for (StereotypeStyle sv : StereotypeStyle.values()) //1
{ 

//#if -737115078 
if(counter == value)//1
{ 

//#if 230585232 
return sv;
//#endif 

} 

//#endif 


//#if -1365103699 
counter++;
//#endif 

} 

//#endif 


//#if 1927735121 
return null;
//#endif 

} 

//#endif 


 } 

//#endif 

 } 

//#endif 


//#endif 

