package org.argouml.uml.diagram;
import java.awt.Font;
import org.argouml.notation.NotationSettings;
import org.tigris.gef.undo.Memento;
public class DiagramSettings  { 
private DiagramSettings parent;
private NotationSettings notationSettings;
private String fontName;
private Integer fontSize;
private Boolean showBoldNames;
private Font fontPlain;
private Font fontItalic;
private Font fontBold;
private Font fontBoldItalic;
private Boolean showBidirectionalArrows;
private Integer defaultShadowWidth;
private StereotypeStyle defaultStereotypeView;
public void setNotationSettings(NotationSettings notationSettings)
    { 
this.notationSettings = notationSettings;
} 
public DiagramSettings(DiagramSettings parentSettings)
    { 
super();
parent = parentSettings;
if(parentSettings == null)//1
{ 
notationSettings = new NotationSettings();
} 
else
{ 
notationSettings =
                new NotationSettings(parent.getNotationSettings());
} 
recomputeFonts();
} 
public void setDefaultStereotypeView(final int newView)
    { 
StereotypeStyle sv = StereotypeStyle.getEnum(newView);
if(sv == null)//1
{ 
throw new IllegalArgumentException("Bad argument " + newView);
} 
setDefaultStereotypeView(sv);
} 
public void setFontName(String newFontName)
    { 
if(fontName != null && fontName.equals(newFontName))//1
{ 
return;
} 
fontName = newFontName;
recomputeFonts();
} 
public Font getFontBold()
    { 
if(fontBold == null)//1
{ 
return parent.getFontBold();
} 
return fontBold;
} 
public boolean isShowBoldNames()
    { 
if(showBoldNames == null)//1
{ 
if(parent != null)//1
{ 
return parent.isShowBoldNames();
} 
else
{ 
return false;
} 
} 
return showBoldNames;
} 
public Font getFontItalic()
    { 
if(fontItalic == null)//1
{ 
return parent.getFontItalic();
} 
return fontItalic;
} 
public Font getFont(int fontStyle)
    { 
if((fontStyle & Font.ITALIC) != 0)//1
{ 
if((fontStyle & Font.BOLD) != 0)//1
{ 
return getFontBoldItalic();
} 
else
{ 
return getFontItalic();
} 
} 
else
{ 
if((fontStyle & Font.BOLD) != 0)//1
{ 
return getFontBold();
} 
else
{ 
return getFontPlain();
} 
} 
} 
public int getDefaultShadowWidth()
    { 
if(defaultShadowWidth == null)//1
{ 
if(parent != null)//1
{ 
return parent.getDefaultShadowWidth();
} 
else
{ 
return 0;
} 
} 
return defaultShadowWidth;
} 
public Font getFontPlain()
    { 
if(fontPlain == null)//1
{ 
return parent.getFontPlain();
} 
return fontPlain;
} 
public Font getFontBoldItalic()
    { 
if(fontBoldItalic == null)//1
{ 
return parent.getFontBoldItalic();
} 
return fontBoldItalic;
} 
public void setShowBoldNames(final boolean showem)
    { 
if(showBoldNames != null && showBoldNames == showem)//1
{ 
return;
} 
Memento memento = new Memento() {
            public void redo() {
                showBoldNames = showem;
            }

            public void undo() {
                showBoldNames = !showem;
            }
        };
doUndoable(memento);
} 
public void setShowBidirectionalArrows(final boolean showem)
    { 
if(showBidirectionalArrows != null
                && showBidirectionalArrows == showem)//1
{ 
return;
} 
Memento memento = new Memento() {
            public void redo() {
                showBidirectionalArrows = showem;
            }

            public void undo() {
                showBidirectionalArrows = !showem;
            }
        };
doUndoable(memento);
} 
public DiagramSettings()
    { 
this(null);
} 
public int getFontSize()
    { 
if(fontSize == null)//1
{ 
if(parent != null)//1
{ 
return parent.getFontSize();
} 
else
{ 
return 10;
} 
} 
return fontSize;
} 
private void recomputeFonts()
    { 
if((fontName != null && !"".equals(fontName) && fontSize != null)
                || parent == null)//1
{ 
String name = getFontName();
int size = getFontSize();
fontPlain = new Font(name, Font.PLAIN, size);
fontItalic = new Font(name, Font.ITALIC, size);
fontBold = new Font(name, Font.BOLD, size);
fontBoldItalic = new Font(name, Font.BOLD | Font.ITALIC, size);
} 
else
{ 
fontPlain = null;
fontItalic = null;
fontBold = null;
fontBoldItalic = null;
} 
} 
public void setFontSize(int newFontSize)
    { 
if(fontSize != null && fontSize == newFontSize)//1
{ 
return;
} 
fontSize = newFontSize;
recomputeFonts();
} 
public void setDefaultStereotypeView(final StereotypeStyle newView)
    { 
if(defaultStereotypeView != null && defaultStereotypeView == newView)//1
{ 
return;
} 
final StereotypeStyle oldValue = defaultStereotypeView;
Memento memento = new Memento() {
            public void redo() {
                defaultStereotypeView = newView;
            }

            public void undo() {
                defaultStereotypeView = oldValue;
            }
        };
doUndoable(memento);
} 
public void setDefaultShadowWidth(final int newWidth)
    { 
if(defaultShadowWidth != null && defaultShadowWidth == newWidth)//1
{ 
return;
} 
final Integer oldValue = defaultShadowWidth;
Memento memento = new Memento() {
            public void redo() {
                defaultShadowWidth = newWidth;
            }

            public void undo() {
                defaultShadowWidth = oldValue;
            }
        };
doUndoable(memento);
} 
public NotationSettings getNotationSettings()
    { 
return notationSettings;
} 
public String getFontName()
    { 
if(fontName == null)//1
{ 
if(parent != null)//1
{ 
return parent.getFontName();
} 
else
{ 
return "Dialog";
} 
} 
return fontName;
} 
public StereotypeStyle getDefaultStereotypeView()
    { 
if(defaultStereotypeView == null)//1
{ 
if(parent != null)//1
{ 
return parent.getDefaultStereotypeView();
} 
else
{ 
return StereotypeStyle.TEXTUAL;
} 
} 
return defaultStereotypeView;
} 
public boolean isShowBidirectionalArrows()
    { 
if(showBidirectionalArrows == null)//1
{ 
if(parent != null)//1
{ 
return parent.isShowBidirectionalArrows();
} 
else
{ 
return false;
} 
} 
return showBidirectionalArrows;
} 
public int getDefaultStereotypeViewInt()
    { 
return getDefaultStereotypeView().ordinal();
} 
private void doUndoable(Memento memento)
    { 
memento.redo();
} 
public enum StereotypeStyle {
TEXTUAL(DiagramAppearance.STEREOTYPE_VIEW_TEXTUAL),

BIG_ICON(DiagramAppearance.STEREOTYPE_VIEW_BIG_ICON),

SMALL_ICON(DiagramAppearance.STEREOTYPE_VIEW_SMALL_ICON),

;StereotypeStyle(int value)
        { 
assert value == this.ordinal();
} 
public static StereotypeStyle getEnum(int value)
        { 
int counter = 0;
for (StereotypeStyle sv : StereotypeStyle.values()) //1
{ 
if(counter == value)//1
{ 
return sv;
} 
counter++;
} 
return null;
} 

 } 

 } 
