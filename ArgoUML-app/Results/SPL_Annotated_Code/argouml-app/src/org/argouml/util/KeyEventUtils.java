// Compilation Unit of /KeyEventUtils.java 
 
package org.argouml.util;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import javax.swing.KeyStroke;
public class KeyEventUtils  { 
public static final String MODIFIER_JOINER = " + ";
public static final String SHIFT_MODIFIER = "SHIFT";
public static final String CTRL_MODIFIER = "CTRL";
public static final String META_MODIFIER = "META";
public static final String ALT_MODIFIER = "ALT";
public static final String ALT_GRAPH_MODIFIER = "altGraph";
public static String getModifiersText(int modifiers)
    { 
StringBuffer buf = new StringBuffer();
if((modifiers & InputEvent.SHIFT_MASK) != 0)//1
{ 
buf.append(SHIFT_MODIFIER).append(MODIFIER_JOINER);
} 

if((modifiers & InputEvent.CTRL_MASK) != 0)//1
{ 
buf.append(CTRL_MODIFIER).append(MODIFIER_JOINER);
} 

if((modifiers & InputEvent.META_MASK) != 0)//1
{ 
buf.append(META_MODIFIER).append(MODIFIER_JOINER);
} 

if((modifiers & InputEvent.ALT_MASK) != 0)//1
{ 
buf.append(ALT_MODIFIER).append(MODIFIER_JOINER);
} 

if((modifiers & InputEvent.ALT_GRAPH_MASK) != 0)//1
{ 
buf.append(ALT_GRAPH_MODIFIER).append(MODIFIER_JOINER);
} 

return buf.toString();
} 

public static final boolean isActionEvent(KeyEvent evt)
    { 
int keyCode = evt.getKeyCode();
switch (keyCode) //1
{ 
case KeyEvent.VK_BACK_SPACE://1

case KeyEvent.VK_DELETE://1

case KeyEvent.VK_CANCEL://1

case KeyEvent.VK_HOME://1

case KeyEvent.VK_END://1

case KeyEvent.VK_PAGE_UP://1

case KeyEvent.VK_PAGE_DOWN://1

case KeyEvent.VK_UP://1

case KeyEvent.VK_DOWN://1

case KeyEvent.VK_LEFT://1

case KeyEvent.VK_RIGHT://1

case KeyEvent.VK_KP_LEFT://1

case KeyEvent.VK_KP_UP://1

case KeyEvent.VK_KP_RIGHT://1

case KeyEvent.VK_KP_DOWN://1

case KeyEvent.VK_F1://1

case KeyEvent.VK_F2://1

case KeyEvent.VK_F3://1

case KeyEvent.VK_F4://1

case KeyEvent.VK_F5://1

case KeyEvent.VK_F6://1

case KeyEvent.VK_F7://1

case KeyEvent.VK_F8://1

case KeyEvent.VK_F9://1

case KeyEvent.VK_F10://1

case KeyEvent.VK_F11://1

case KeyEvent.VK_F12://1

case KeyEvent.VK_F13://1

case KeyEvent.VK_F14://1

case KeyEvent.VK_F15://1

case KeyEvent.VK_F16://1

case KeyEvent.VK_F17://1

case KeyEvent.VK_F18://1

case KeyEvent.VK_F19://1

case KeyEvent.VK_F20://1

case KeyEvent.VK_F21://1

case KeyEvent.VK_F22://1

case KeyEvent.VK_F23://1

case KeyEvent.VK_F24://1

case KeyEvent.VK_PRINTSCREEN://1

case KeyEvent.VK_SCROLL_LOCK://1

case KeyEvent.VK_CAPS_LOCK://1

case KeyEvent.VK_NUM_LOCK://1

case KeyEvent.VK_PAUSE://1

case KeyEvent.VK_INSERT://1

case KeyEvent.VK_FINAL://1

case KeyEvent.VK_CONVERT://1

case KeyEvent.VK_NONCONVERT://1

case KeyEvent.VK_ACCEPT://1

case KeyEvent.VK_MODECHANGE://1

case KeyEvent.VK_KANA://1

case KeyEvent.VK_KANJI://1

case KeyEvent.VK_ALPHANUMERIC://1

case KeyEvent.VK_KATAKANA://1

case KeyEvent.VK_HIRAGANA://1

case KeyEvent.VK_FULL_WIDTH://1

case KeyEvent.VK_HALF_WIDTH://1

case KeyEvent.VK_ROMAN_CHARACTERS://1

case KeyEvent.VK_ALL_CANDIDATES://1

case KeyEvent.VK_PREVIOUS_CANDIDATE://1

case KeyEvent.VK_CODE_INPUT://1

case KeyEvent.VK_JAPANESE_KATAKANA://1

case KeyEvent.VK_JAPANESE_HIRAGANA://1

case KeyEvent.VK_JAPANESE_ROMAN://1

case KeyEvent.VK_KANA_LOCK://1

case KeyEvent.VK_INPUT_METHOD_ON_OFF://1

case KeyEvent.VK_AGAIN://1

case KeyEvent.VK_UNDO://1

case KeyEvent.VK_COPY://1

case KeyEvent.VK_PASTE://1

case KeyEvent.VK_CUT://1

case KeyEvent.VK_FIND://1

case KeyEvent.VK_PROPS://1

case KeyEvent.VK_STOP://1

case KeyEvent.VK_HELP://1

return true;

} 

return false;
} 

public static String getKeyText(int keyCode)
    { 
int expectedModifiers =
            (Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL);
Field[] fields = KeyEvent.class.getDeclaredFields();
for (int i = 0; i < fields.length; i++) //1
{ 
try //1
{ 
if(fields[i].getModifiers() == expectedModifiers
                        && fields[i].getType() == Integer.TYPE
                        && fields[i].getName().startsWith("VK_")
                        && fields[i].getInt(KeyEvent.class) == keyCode)//1
{ 
return fields[i].getName().substring(3);
} 

} 
catch (IllegalAccessException e) //1
{ 
} 


} 

return "UNKNOWN";
} 

public static String formatKeyStroke(KeyStroke keyStroke)
    { 
if(keyStroke != null)//1
{ 
return getModifiersText(keyStroke.getModifiers())
                   + KeyEventUtils.getKeyText(keyStroke.getKeyCode());
} 
else
{ 
return "";
} 

} 

 } 


