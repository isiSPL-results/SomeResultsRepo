//    URLModelLoader.java 41 2010-04-03 20:04:12Z marcusvnac $
// Copyright (c) 2007-2008 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies. This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason. IN NO EVENT SHALL THE
// UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
// SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
// ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
// THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE. THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY
// WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
// PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
// CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT,
// UPDATES, ENHANCEMENTS, OR MODIFICATIONS.

package org.argouml.profile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.argouml.model.Model;
import org.argouml.model.UmlException;
import org.argouml.model.XmiReader;
import org.xml.sax.InputSource;

/*
 * Abstract ProfileModelLoader which loads models from a URL.
 *
 * @author Tom Morris, Thomas Neustupny
 */
public class URLModelLoader implements ProfileModelLoader
{

    /*
     * @param url the url/system id to load
     * @param publicId the publicId for which the model will be known - must be
     *                equal in different machines in order to be possible to
     *                load the model.
     * @return a collection of top level elements in the profile (usually a
     *         single package stereotyped <<profile>>
     * @throws ProfileException if the XMIReader couldn't read the profile
     */
    public Collection loadModel(URL url, URL publicId)
    throws ProfileException
    {
        if (url == null) {
            throw new ProfileException("Null profile URL");
        }
        ZipInputStream zis = null;
        try {
            Collection elements = null;
            XmiReader xmiReader = Model.getXmiReader();
            if (url.getPath().toLowerCase().endsWith(".zip")) {
                zis = new ZipInputStream(url.openStream());
                ZipEntry entry = zis.getNextEntry();
                // TODO: check if it's OK to just get the first zip entry
                // since the zip file should contain only one xmi file - thn
                if (entry != null) {
                    url = makeZipEntryUrl(url, entry.getName());
                }
                zis.close();
            }
            InputSource inputSource = new InputSource(url.toExternalForm());
            inputSource.setPublicId(publicId.toString());
            elements = xmiReader.parse(inputSource, true);
            return elements;
        } catch (UmlException e) {
            throw new ProfileException("Error loading profile XMI file ", e);
        } catch (IOException e) {
            throw new ProfileException("I/O error loading profile XMI ", e);
        }
    }

    /*
     * Load a profile from a ProfileReference.
     *
     * @param reference ProfileReference for desired profile
     * @return a collection of top level elements in the profile (usually a
     *         single package stereotyped <<profile>>
     * @throws ProfileException if the XMIReader couldn't read the profile
     */
    public Collection loadModel(final ProfileReference reference)
    throws ProfileException
    {
        return loadModel(reference.getPublicReference(), reference
                         .getPublicReference());
    }

    private URL makeZipEntryUrl(URL url, String entryName)
    throws MalformedURLException
    {
        String entryURL = "jar:" + url + "!/" + entryName;
        return new URL(entryURL);
    }
}
