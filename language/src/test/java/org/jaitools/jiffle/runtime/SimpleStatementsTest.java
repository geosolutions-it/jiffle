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
package org.jaitools.jiffle.runtime;

import org.junit.Test;

/**
 * Unit tests for the evaluation of simple arithmetic statements with a 
 * single source and destination image.
 * 
 * @author Michael Bedward
 * @since 0.1
 * @version $Id$
 */
public class SimpleStatementsTest extends RuntimeTestBase {
    
    @Test
    public void srcValue() throws Exception {
        String src = "dest = src;";
        System.out.println("   " + src);
        
        testScript(src,
                new Evaluator() {

                    public double eval(double val) {
                        return val;
                    }
                });
    }

    @Test
    public void minusSrcValue() throws Exception {
        String src = "dest = -src;";
        System.out.println("   " + src);
        
        testScript(src,
                new Evaluator() {

                    public double eval(double val) {
                        return -val;
                    }
                });
    }

    @Test
    public void add() throws Exception {
        String src = "dest = src + 1;";
        System.out.println("   " + src);
        
        testScript(src,
                new Evaluator() {

                    public double eval(double val) {
                        return val + 1;
                    }
                });
    }
    
    @Test
    public void subtract() throws Exception {
        String src = "dest = src - 1;";
        System.out.println("   " + src);
        
        testScript(src,
                new Evaluator() {

                    public double eval(double val) {
                        return val - 1;
                    }
                });
    }

    @Test
    public void subtract2() throws Exception {
        String src = "dest = 1 - src;";
        System.out.println("   " + src);
        
        testScript(src,
                new Evaluator() {

                    public double eval(double val) {
                        return 1 - val;
                    }
                });
    }

    @Test
    public void multiply() throws Exception {
        String src = "dest = src * 2;";
        System.out.println("   " + src);
        
        testScript(src,
                new Evaluator() {

                    public double eval(double val) {
                        return val * 2;
                    }
                });
    }

    @Test
    public void divide() throws Exception {
        String src = "dest = src / 2;";
        System.out.println("   " + src);
        
        testScript(src,
                new Evaluator() {

                    public double eval(double val) {
                        return val / 2;
                    }
                });
    }

    /**
     * This will also test handling division by 0
     */
    @Test
    public void inverseDivide() throws Exception {
        String src = "dest = 1 / src;";
        System.out.println("   " + src);
        
        testScript(src,
                new Evaluator() {

                    public double eval(double val) {
                        return 1 / val;
                    }
                });
    }

    @Test
    public void modulo() throws Exception {
        String src = "dest = src % 11;";
        System.out.println("   " + src);
        
        testScript(src,
                new Evaluator() {

                    public double eval(double val) {
                        return val % 11;
                    }
                });
    }
    
    @Test
    public void power() throws Exception {
        String src = "dest = src^2;";
        System.out.println("   " + src);
        
        testScript(src,
                new Evaluator() {

                    public double eval(double val) {
                        return val * val;
                    }
                });
    }

    @Test
    public void precedence1() throws Exception {
        String src = "dest = 1 + src * 2;";
        System.out.println("   " + src);
        
        testScript(src,
                new Evaluator() {

                    public double eval(double val) {
                        return 1 + val * 2;
                    }
                });
    }
    
    @Test
    public void precedence2() throws Exception {
        String src = "dest = (1 + src) * 2;";
        System.out.println("   " + src);
        
        testScript(src,
                new Evaluator() {

                    public double eval(double val) {
                        return (1 + val) * 2;
                    }
                });
    }
    
    @Test
    public void precedence3() throws Exception {
        String src = "dest = 1 - src * 2;";
        System.out.println("   " + src);
        
        testScript(src,
                new Evaluator() {

                    public double eval(double val) {
                        return 1 - val * 2;
                    }
                });
    }
    
    @Test
    public void precedence4() throws Exception {
        String src = "dest = (1 - src) * 2;";
        System.out.println("   " + src);
        
        testScript(src,
                new Evaluator() {

                    public double eval(double val) {
                        return (1 - val) * 2;
                    }
                });
    }
    
    @Test
    public void precedence5() throws Exception {
        String src = "dest = src + 2 * 3 / 4 + 5;";
        System.out.println("   " + src);
        
        testScript(src,
                new Evaluator() {

                    public double eval(double val) {
                        return val + 2 * 3.0 / 4.0 + 5;
                    }
                });
    }
    
    /**
     * Repeated assignment to a pixel-scope variable in a script.
     * Previously, Jiffle was generating runtime source where
     * the variable would be incorrectly re-declared on second
     * and later assignment.
     */
    @Test
    public void repeatedSimpleAssign() throws Exception {
        System.out.println("   repreated assignment to pixel-scope var");
        String script = 
                  "n = x(); \n"
                + "n = n + 1; \n"
                + "dest = n;" ;
        
        Evaluator e = new Evaluator() {
            public double eval(double val) {
                double value = x + 1;
                move();
                return value;
            }
        };
        
        testScript(script, e);
    }
    
}
