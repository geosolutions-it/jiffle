/* 
 *  Copyright (c) 2011, Michael Bedward. All rights reserved. 
 *   
 *  Redistribution and use in source and binary forms, with or without modification, 
 *  are permitted provided that the following conditions are met: 
 *   
 *  - Redistributions of source code must retain the above copyright notice, this  
 *    list of conditions and the following disclaimer. 
 *   
 *  - Redistributions in binary form must reproduce the above copyright notice, this 
 *    list of conditions and the following disclaimer in the documentation and/or 
 *    other materials provided with the distribution.   
 *   
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE 
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR 
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES 
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; 
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON 
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT 
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS 
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */   
package org.jaitools.demo.jiffle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.URISyntaxException;

import org.jaitools.demo.ImageChoice;
import org.jaitools.jiffle.JiffleException;

/**
 * Helper class with for Jiffle demo applications.
 *
 * @author Michael Bedward
 * @since 1.1
 * @version $Id$
 */
public class JiffleDemoHelper {
    
    /**
     * Gets an example script.
     * 
     * @param choice specifies the example script
     * @throws JiffleException on errors getting the script file
     */
    public static String getScript(ImageChoice choice) throws JiffleException {
        File scriptFile = getScriptFile(null, choice);
        return readScriptFile(scriptFile);
    }

    /**
     * Gets a file specified in the command line args, or the default
     * example image if no name is supplied.
     *
     * @param args command lines args passed from an application
     * @param defaultScript default example script
     * @return the script file
     * @throws JiffleException on problems getting the file
     */
    public static File getScriptFile(String[] args, ImageChoice defaultScript) 
            throws JiffleException {
                
        String fileName = null;
        File file = null;
        
        if (args == null || args.length < 1) {
            try {
                fileName = defaultScript.toString() + ".jfl";
                URL url = JiffleDemoHelper.class.getResource("/scripts/" + fileName);
                file = new File(url.toURI());
                
            } catch (URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
        
        } else {
            fileName = args[0];
            file = new File(fileName);
        }
        
        if (file.exists()) {
            return file;
        }
        
        throw new JiffleException("Can't find script file:" + fileName);
    }

    /**
     * Reads the contents of a script file.
     *
     * @param scriptFile the file
     * @return the script as a String
     * @throws JiffleException on problems reading the file
     */
    public static String readScriptFile(File scriptFile) throws JiffleException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(scriptFile));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }

            return sb.toString();

        } catch (IOException ex) {
            throw new JiffleException("Could not read the script file", ex);

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignored) {}
            }
        }
    }
}
