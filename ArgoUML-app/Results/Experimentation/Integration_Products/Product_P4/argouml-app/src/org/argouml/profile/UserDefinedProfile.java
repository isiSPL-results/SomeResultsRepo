package org.argouml.profile;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import org.argouml.model.Model;
import org.argouml.profile.internal.ocl.InvalidOclException;
import org.apache.log4j.Logger;
public class UserDefinedProfile extends Profile
  { 
private String displayName;
private File modelFile;
private Collection profilePackages;
private UserDefinedFigNodeStrategy figNodeStrategy
        = new UserDefinedFigNodeStrategy();
private static final Logger LOG = Logger
                                      .getLogger(UserDefinedProfile.class);
@SuppressWarnings("unchecked")

    private Collection<Object> getAllCommentsInModel(Collection objs)
    { 
Collection<Object> col = new ArrayList<Object>();
for (Object obj : objs) //1
{ 
if(Model.getFacade().isAComment(obj))//1
{ 
col.add(obj);
} 
else
if(Model.getFacade().isANamespace(obj))//1
{ 
Collection contents = Model
                                      .getModelManagementHelper().getAllContents(obj);
if(contents != null)//1
{ 
col.addAll(contents);
} 
} 
} 
return col;
} 
public File getModelFile()
    { 
return modelFile;
} 
@Override
    public Collection getProfilePackages()
    { 
return profilePackages;
} 
@Override
    public String toString()
    { 
File str = getModelFile();
return super.toString() + (str != null ? " [" + str + "]" : "");
} 
public UserDefinedProfile(URL url) throws ProfileException
    { 
LOG.info("load " + url);
ProfileReference reference = null;
reference = new UserProfileReference(url.getPath(), url);
profilePackages = new URLModelLoader().loadModel(reference);
finishLoading();
} 
private FigNodeDescriptor loadImage(String stereotype, File f)
    throws IOException
    { 
FigNodeDescriptor descriptor = new FigNodeDescriptor();
descriptor.length = (int) f.length();
descriptor.src = f.getPath();
descriptor.stereotype = stereotype;
BufferedInputStream bis = new BufferedInputStream(
            new FileInputStream(f));
byte[] buf = new byte[descriptor.length];
try//1
{ 
bis.read(buf);
} 
catch (IOException e) //1
{ 
e.printStackTrace();
} 
descriptor.img = new ImageIcon(buf).getImage();
return descriptor;
} 
public UserDefinedProfile(String dn, URL url,




                              Set<String> dependencies) throws ProfileException
    { 
LOG.info("load " + url);
this.displayName = dn;
if(url != null)//1
{ 
ProfileReference reference = null;
reference = new UserProfileReference(url.getPath(), url);
profilePackages = new URLModelLoader().loadModel(reference);
} 
else
{ 
profilePackages = new ArrayList(0);
} 
for (String profileID : dependencies) //1
{ 
addProfileDependency(profileID);
} 
finishLoading();
} 
public UserDefinedProfile(File file) throws ProfileException
    { 
LOG.info("load " + file);
displayName = file.getName();
modelFile = file;
ProfileReference reference = null;
try//1
{ 
reference = new UserProfileReference(file.getPath());
} 
catch (MalformedURLException e) //1
{ 
throw new ProfileException(
                "Failed to create the ProfileReference.", e);
} 
profilePackages = new FileModelLoader().loadModel(reference);
finishLoading();
} 
@Override
    public FormatingStrategy getFormatingStrategy()
    { 
return null;
} 
@Override
    public FigNodeStrategy getFigureStrategy()
    { 
return figNodeStrategy;
} 
private Collection filterPackages()
    { 
Collection ret = new ArrayList();
for (Object object : profilePackages) //1
{ 
if(Model.getFacade().isAPackage(object))//1
{ 
ret.add(object);
} 
} 
return ret;
} 
public String getDisplayName()
    { 
return displayName;
} 
private void finishLoading()
    { 
Collection packagesInProfile = filterPackages();
for (Object obj : packagesInProfile) //1
{ 
if(Model.getFacade().isAModelElement(obj)
                    && (Model.getExtensionMechanismsHelper().hasStereotype(obj,
                            "profile") || (packagesInProfile.size() == 1)))//1
{ 
String name = Model.getFacade().getName(obj);
if(name != null)//1
{ 
displayName = name;
} 
LOG.info("profile " + displayName);
String dependencyListStr = Model.getFacade()
                                           .getTaggedValueValue(obj, "Dependency");
StringTokenizer st = new StringTokenizer(dependencyListStr,
                        " ,;:");
String profile = null;
while (st.hasMoreTokens()) //1
{ 
profile = st.nextToken();
if(profile != null)//1
{ 
LOG.debug("AddingDependency " + profile);
this.addProfileDependency(ProfileFacade.getManager()
                                                  .lookForRegisteredProfile(profile));
} 
} 
} 
} 
Collection allStereotypes = Model.getExtensionMechanismsHelper()
                                    .getStereotypes(packagesInProfile);
for (Object stereotype : allStereotypes) //1
{ 
Collection tags = Model.getFacade().getTaggedValuesCollection(
                                  stereotype);
for (Object tag : tags) //1
{ 
String tagName = Model.getFacade().getTag(tag);
if(tagName == null)//1
{ 
LOG.debug("profile package with stereotype "
                              + Model.getFacade().getName(stereotype)
                              + " contains a null tag definition");
} 
else
if(tagName.toLowerCase().equals("figure"))//1
{ 
LOG.debug("AddFigNode "
                              + Model.getFacade().getName(stereotype));
String value = Model.getFacade().getValueOfTag(tag);
File f = new File(value);
FigNodeDescriptor fnd = null;
try//1
{ 
fnd = loadImage(Model.getFacade().getName(stereotype)
                                        .toString(), f);
figNodeStrategy.addDesrciptor(fnd);
} 
catch (IOException e) //1
{ 
LOG.error("Error loading FigNode", e);
} 
} 
} 
} 
} 
private class FigNodeDescriptor  { 
private String stereotype;
private Image img;
private String src;
private int length;
public boolean isValid()
        { 
return stereotype != null && src != null && length > 0;
} 

 } 
private class UserDefinedFigNodeStrategy implements FigNodeStrategy
  { 
private Map<String, Image> images = new HashMap<String, Image>();
public Image getIconForStereotype(Object stereotype)
        { 
return images.get(Model.getFacade().getName(stereotype));
} 
public void addDesrciptor(FigNodeDescriptor fnd)
        { 
images.put(fnd.stereotype, fnd.img);
} 

 } 

 } 
