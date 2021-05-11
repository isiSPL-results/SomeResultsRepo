// Compilation Unit of /DeferredBufferedImage.java 
 
package org.argouml.gefext;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.util.Vector;
import org.tigris.gef.base.Editor;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public class DeferredBufferedImage implements RenderedImage
  { 
public static final int TRANSPARENT_BG_COLOR = 0x00efefef;
public static final Color BACKGROUND_COLOR =
        new Color(TRANSPARENT_BG_COLOR, true);
private static final int BUFFER_HEIGHT = 32;
private int x, y;
private int width;
private int height;
private int scale;
private BufferedImage image;
private Editor editor;
private int scaledBufferHeight;
private int y1, y2;

//#if LOGGING 
private static final Logger LOG =
        Logger.getLogger(DeferredBufferedImage.class);
//#endif 

public DeferredBufferedImage(Rectangle drawingArea, int imageType,
                                 Editor ed, int scaleFactor)
    { 
editor = ed;
scale = scaleFactor;
x = drawingArea.x;
y = drawingArea.y;
width = drawingArea.width;
height = drawingArea.height;
x = x  * scale;
y = y  * scale;
width = width  * scale;
height = height  * scale;
scaledBufferHeight = BUFFER_HEIGHT * scale;
image = new BufferedImage(width, scaledBufferHeight, imageType);
y1 = y;
y2 = y1;
} 

public Raster getTile(int tileX, int tileY)
    { 

//#if LOGGING 
LOG.debug("getTile x=" + tileX + " y = " + tileY);
//#endif 

if(tileX < getMinTileX()
                || tileX >= getMinTileX() + getNumXTiles()
                || tileY < getMinTileY()
                || tileY >= getMinTileY() + getNumYTiles())//1
{ 
throw new IndexOutOfBoundsException();
} 

Rectangle tileBounds = new Rectangle(0, (tileY - getMinTileY()
                                             * scaledBufferHeight), width, scaledBufferHeight);
return getData(tileBounds);
} 

public SampleModel getSampleModel()
    { 
return image.getSampleModel();
} 

public int getNumYTiles()
    { 
int tiles = (getHeight() + scaledBufferHeight - 1) / scaledBufferHeight;

//#if LOGGING 
LOG.debug("getNumYTiles = " + tiles);
//#endif 

return tiles;
} 

public int getMinX()
    { 

//#if LOGGING 
LOG.debug("getMinX = 0");
//#endif 

return 0;
} 

public Object getProperty(String name)
    { 
return image.getProperty(name);
} 

public ColorModel getColorModel()
    { 
return image.getColorModel();
} 

public int getWidth()
    { 

//#if LOGGING 
LOG.debug("getWidth = " + width);
//#endif 

return width;
} 

public String[] getPropertyNames()
    { 
return image.getPropertyNames();
} 

public int getTileGridXOffset()
    { 

//#if LOGGING 
LOG.debug("getTileGridXOffset = 0");
//#endif 

return 0;
} 

public int getTileWidth()
    { 

//#if LOGGING 
LOG.debug("getTileWidth = " + width);
//#endif 

return width;
} 

private Rectangle offsetWindow(Rectangle clip)
    { 
int baseY = clip.y - y1;
return new Rectangle(clip.x, baseY, clip.width,
                             Math.min(clip.height, scaledBufferHeight - baseY));
} 

public int getMinY()
    { 

//#if LOGGING 
LOG.debug("getMinY = 0");
//#endif 

return 0;
} 

public int getTileGridYOffset()
    { 

//#if LOGGING 
LOG.debug("getTileGridYOffset = 0");
//#endif 

return 0;
} 

public Raster getData(Rectangle clip)
    { 
if(!isRasterValid(clip))//1
{ 

//#if LOGGING 
LOG.debug("Raster not valid, computing new raster");
//#endif 

computeRaster(clip);
} 

Rectangle oClip = offsetWindow(clip);
Raster ras = image.getData(oClip);
Raster translatedRaster = ras.createTranslatedChild(clip.x, clip.y);
return translatedRaster;
} 

public int getMinTileY()
    { 

//#if LOGGING 
LOG.debug("getMinTileY = 0");
//#endif 

return 0;
} 

public int getTileHeight()
    { 

//#if LOGGING 
LOG.debug("getTileHeight = " + scaledBufferHeight);
//#endif 

return scaledBufferHeight;
} 

public WritableRaster copyData(WritableRaster outRaster)
    { 
throw new UnsupportedOperationException();
} 

private boolean isRasterValid(Rectangle clip)
    { 
if(clip.height > scaledBufferHeight)//1
{ 
throw new IndexOutOfBoundsException(
                "clip rectangle must fit in band buffer");
} 

return (clip.y >= y1 && (clip.y + clip.height - 1) < y2);
} 

public int getHeight()
    { 

//#if LOGGING 
LOG.debug("getHeight = " + height);
//#endif 

return height;
} 

public Raster getData()
    { 

//#if LOGGING 
LOG.debug("getData with no params");
//#endif 

return getData(new Rectangle(x, y, width, height));
} 

private void computeRaster(Rectangle clip)
    { 

//#if LOGGING 
LOG.debug("Computing raster for rectangle " + clip);
//#endif 

Graphics2D graphics = image.createGraphics();
graphics.scale(1.0 * scale, 1.0 * scale);
graphics.setColor(BACKGROUND_COLOR);
Composite c = graphics.getComposite();
graphics.setComposite(AlphaComposite.Src);
graphics.fillRect(0, 0, width, scaledBufferHeight);
graphics.setComposite(c);
graphics.setClip(0, 0, width, scaledBufferHeight);
graphics.translate(0, -clip.y / scale);
y1 = clip.y;
y2 = y1 + scaledBufferHeight;
editor.print(graphics);
graphics.dispose();
} 

public int getNumXTiles()
    { 

//#if LOGGING 
LOG.debug("getNumXTiles = 1");
//#endif 

return 1;
} 

public int getMinTileX()
    { 

//#if LOGGING 
LOG.debug("getMinTileX = 0");
//#endif 

return 0;
} 

public Vector<RenderedImage> getSources()
    { 
return null;
} 

 } 


