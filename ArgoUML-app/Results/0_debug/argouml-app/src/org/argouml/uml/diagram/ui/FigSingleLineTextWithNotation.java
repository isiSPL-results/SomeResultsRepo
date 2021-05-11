
//#if 1152151053 
// Compilation Unit of /FigSingleLineTextWithNotation.java 
 

//#if -944338067 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 153909477 
import java.awt.Rectangle;
//#endif 


//#if 2008644410 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -902127408 
import java.util.HashMap;
//#endif 


//#if -810643767 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if 758138284 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if -959403534 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if 1848060403 
import org.argouml.application.events.ArgoNotationEvent;
//#endif 


//#if 216785823 
import org.argouml.application.events.ArgoNotationEventListener;
//#endif 


//#if 100805681 
import org.argouml.i18n.Translator;
//#endif 


//#if 324904960 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if -1938935763 
import org.argouml.notation.Notation;
//#endif 


//#if 1300876770 
import org.argouml.notation.NotationName;
//#endif 


//#if 1313797692 
import org.argouml.notation.NotationProvider;
//#endif 


//#if -1617780300 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if -909703606 
import org.argouml.notation.NotationSettings;
//#endif 


//#if 135240538 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 252254212 
public class FigSingleLineTextWithNotation extends 
//#if -1322978340 
FigSingleLineText
//#endif 

 implements 
//#if -1627456190 
ArgoNotationEventListener
//#endif 

  { 

//#if -741576317 
private NotationProvider notationProvider;
//#endif 


//#if -1088879627 
private HashMap<String, Object> npArguments = new HashMap<String, Object>();
//#endif 


//#if 423331995 
public FigSingleLineTextWithNotation(Object owner, Rectangle bounds,
                                         DiagramSettings settings, boolean expandOnly)
    { 

//#if 989393478 
super(owner, bounds, settings, expandOnly);
//#endif 


//#if 1476203168 
initNotationProviders();
//#endif 

} 

//#endif 


//#if -1094518438 
protected void textEditStarted()
    { 

//#if -95284186 
String s = getNotationProvider().getParsingHelp();
//#endif 


//#if -884732491 
showHelp(s);
//#endif 


//#if 743154661 
setText();
//#endif 

} 

//#endif 


//#if -1844541618 
@Override
    public void removeFromDiagram()
    { 

//#if -1076254291 
ArgoEventPump.removeListener(ArgoEventTypes.ANY_NOTATION_EVENT, this);
//#endif 


//#if -963304052 
notationProvider.cleanListener(this, getOwner());
//#endif 


//#if -422807780 
super.removeFromDiagram();
//#endif 

} 

//#endif 


//#if -1531549623 
@Deprecated
    public void notationProviderAdded(ArgoNotationEvent e)
    { 
} 

//#endif 


//#if 1745128261 
@Deprecated
    protected void initNotationArguments()
    { 

//#if -222704984 
npArguments.put("useGuillemets",
                        getNotationSettings().isUseGuillemets());
//#endif 

} 

//#endif 


//#if -1135624230 
@Deprecated
    public void notationRemoved(ArgoNotationEvent e)
    { 
} 

//#endif 


//#if -1685294424 
protected void textEdited()
    { 

//#if 1991752017 
notationProvider.parse(getOwner(), getText());
//#endif 


//#if 464322514 
setText();
//#endif 

} 

//#endif 


//#if -2000221914 
public FigSingleLineTextWithNotation(Object owner, Rectangle bounds,
                                         DiagramSettings settings, boolean expandOnly,
                                         String[] allProperties)
    { 

//#if 107622843 
super(owner, bounds, settings, expandOnly, allProperties);
//#endif 


//#if 95354573 
initNotationProviders();
//#endif 

} 

//#endif 


//#if -1319832825 

//#if -1852427600 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigSingleLineTextWithNotation(int x, int y, int w, int h,
                                         boolean expandOnly)
    { 

//#if -1229284602 
super(x, y, w, h, expandOnly);
//#endif 

} 

//#endif 


//#if -1132116951 
@Deprecated
    public void notationProviderRemoved(ArgoNotationEvent e)
    { 
} 

//#endif 


//#if -1080157126 
@Deprecated
    public void notationAdded(ArgoNotationEvent e)
    { 
} 

//#endif 


//#if -293496174 

//#if 1128641809 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigSingleLineTextWithNotation(int x, int y, int w, int h,
                                         boolean expandOnly,
                                         String[] allProperties)
    { 

//#if -94740500 
super(x, y, w, h, expandOnly, allProperties);
//#endif 

} 

//#endif 


//#if 1981602313 
@Override
    protected void setText()
    { 

//#if 618792892 
assert getOwner() != null;
//#endif 


//#if -1365775545 
assert notationProvider != null;
//#endif 


//#if -1288165573 
setText(notationProvider.toString(getOwner(), getNotationSettings()));
//#endif 

} 

//#endif 


//#if -244415680 
protected void showHelp(String s)
    { 

//#if 1844387684 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                    ArgoEventTypes.HELP_CHANGED, this,
                                    Translator.localize(s)));
//#endif 

} 

//#endif 


//#if 149270724 
@Deprecated
    protected void putNotationArgument(String key, Object element)
    { 

//#if 1144232159 
npArguments.put(key, element);
//#endif 

} 

//#endif 


//#if 1636269697 
@Override
    public void propertyChange(PropertyChangeEvent pce)
    { 

//#if 1747983720 
if(notationProvider != null)//1
{ 

//#if 876819131 
notationProvider.updateListener(this, getOwner(), pce);
//#endif 

} 

//#endif 


//#if -2060232939 
super.propertyChange(pce);
//#endif 

} 

//#endif 


//#if -1042531017 
public void renderingChanged()
    { 

//#if -1740779015 
initNotationProviders();
//#endif 


//#if -1621319024 
super.renderingChanged();
//#endif 

} 

//#endif 


//#if 375846016 
protected void initNotationProviders()
    { 

//#if -1883615790 
if(notationProvider != null)//1
{ 

//#if -812057384 
notationProvider.cleanListener(this, getOwner());
//#endif 

} 

//#endif 


//#if -1353827907 
if(getOwner() != null)//1
{ 

//#if 743864902 
NotationName notation = Notation.findNotation(
                                        getNotationSettings().getNotationLanguage());
//#endif 


//#if -1621097814 
notationProvider =
                NotationProviderFactory2.getInstance().getNotationProvider(
                    getNotationProviderType(), getOwner(), this, notation);
//#endif 


//#if -623367110 
initNotationArguments();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -417329678 
protected int getNotationProviderType()
    { 

//#if -561060750 
return NotationProviderFactory2.TYPE_NAME;
//#endif 

} 

//#endif 


//#if 1159486172 
void setNotationProvider(NotationProvider np)
    { 

//#if 1528611305 
if(notationProvider != null)//1
{ 

//#if -1151521638 
notationProvider.cleanListener(this, getOwner());
//#endif 

} 

//#endif 


//#if -1018135521 
this.notationProvider = np;
//#endif 


//#if -1704888906 
initNotationArguments();
//#endif 

} 

//#endif 


//#if -163776099 
public NotationProvider getNotationProvider()
    { 

//#if 1088348257 
return notationProvider;
//#endif 

} 

//#endif 


//#if -554788818 
@Deprecated
    public void notationChanged(ArgoNotationEvent e)
    { 

//#if 1938961819 
renderingChanged();
//#endif 

} 

//#endif 


//#if -1686827270 
protected NotationSettings getNotationSettings()
    { 

//#if 730889001 
return getSettings().getNotationSettings();
//#endif 

} 

//#endif 


//#if -1864228987 
public FigSingleLineTextWithNotation(Object owner, Rectangle bounds,
                                         DiagramSettings settings, boolean expandOnly, String property)
    { 

//#if -929677876 
super(owner, bounds, settings, expandOnly, property);
//#endif 


//#if 556556435 
initNotationProviders();
//#endif 

} 

//#endif 


//#if -1031632484 
@Deprecated
    public HashMap<String, Object> getNpArguments()
    { 

//#if -252197325 
return npArguments;
//#endif 

} 

//#endif 


//#if 1512038825 
protected void updateLayout(UmlChangeEvent event)
    { 

//#if -234581566 
assert event != null;
//#endif 


//#if -32989262 
if(notationProvider != null
                && (!"remove".equals(event.getPropertyName())
                    || event.getSource() != getOwner()))//1
{ 

//#if 51034051 
this.setText(notationProvider.toString(getOwner(),
                                                   getNotationSettings()));
//#endif 


//#if 1933124043 
damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 169758149 

//#if -1774877499 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    public void setOwner(Object owner)
    { 

//#if -1703632960 
super.setOwner(owner);
//#endif 


//#if -1510851767 
initNotationProviders();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

