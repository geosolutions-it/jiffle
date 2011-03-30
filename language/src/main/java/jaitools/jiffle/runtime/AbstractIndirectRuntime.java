/*
 * Copyright 2011 Michael Bedward
 * 
 * This file is part of jai-tools.
 *
 * jai-tools is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 * jai-tools is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public 
 * License along with jai-tools.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package jaitools.jiffle.runtime;

import java.awt.image.RenderedImage;

import java.util.ArrayList;
import java.util.List;

/**
 * The default abstract base class for runtime classes that implement
 * indirect evaluation.
 *
 * @author Michael Bedward
 * @since 0.1
 * @version $Id$
 */
public abstract class AbstractIndirectRuntime extends AbstractJiffleRuntime implements JiffleIndirectRuntime {
    
    /* 
     * Note: not using generics here because they are not
     * supported by the Janino compiler.
     */
    List sourceImageNames = new ArrayList();
    String destImageName;

    /**
     * Creates a new instance and initializes script-option variables.
     */
    public AbstractIndirectRuntime() {
        initOptionVars();
    }

    public void setDestinationImage(String imageName) {
        destImageName = imageName;
    }

    public void setSourceImage(String imageName, RenderedImage image) {
        sourceImageNames.add(imageName);
    }

    public double readFromImage(String srcImageName, int x, int y, int band) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}