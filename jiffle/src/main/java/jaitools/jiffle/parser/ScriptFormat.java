/*
 * Copyright 2009-2011 Michael Bedward
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

package jaitools.jiffle.parser;

/**
 * Constants to indicate the script format. Options are
 * {@link #JIFFLE} (default) and {@link #MAPCALC}.
 *
 * @author Michael Bedward
 * @since 1.1
 * @source $URL: $
 * @version $Id: $
 */
public enum ScriptFormat {

    /** 
     * Jiffle format. Statements must be delimited by
     * semicolons. No continuation character is required for statements
     * spanning multiple lines.
     */
    JIFFLE,

    /**
     * Extended r.mapcalc format. Statements may be delimited by
     * newlines or semicolons. Continuation character ('\') is required
     * for statements spanning multiple lines.
     */
    MAPCALC;
}
