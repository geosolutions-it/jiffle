/* 
 *  Copyright (c) 2011-2013, Michael Bedward. All rights reserved. 
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

package org.jaitools.jiffle.parser;

/**
 * Represents a symbol in a Jiffle script.
 * <p>
 * Jiffle does not (yet) support user-defined functions in scripts,
 * so all symbols are variables.
 * <p>
 * Adapted from "Language Implementation Patterns" by Terence Parr,
 * published by The Pragmatic Bookshelf, 2010.
 * 
 * @author michael
 */
public class Symbol {
    
    public static enum Type {
        /** General scalar user variable. */
        SCALAR,
        
        /** A foreach loop variable. */
        LOOP_VAR,
        
        /** A list variable. */
        LIST,
        
        /** Source image. */
        SOURCE_IMAGE,
        
        /** Destination image. */
        DEST_IMAGE;
    }

    private final String name;
    private final Type type;

    /**
     * Creates a new symbol.
     * 
     * @param name name in script
     * @param type symbol type
     */
    public Symbol(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Gets the name.
     * 
     * @return symbol name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the type.
     * 
     * @return symbol type
     */
    public Type getType() {
        return type;
    }

}
