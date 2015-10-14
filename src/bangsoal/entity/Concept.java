/*
 * The MIT License
 *
 * Copyright 2015 radityopw.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package bangsoal.entity;

import java.io.Serializable;

/**
 *
 * @author radityopw
 */
public class Concept implements Serializable{
    
    private long id;
    private String name = "";
    private long subjectId;
    
    public Concept(long subjectId){
        this.subjectId = subjectId;
        this.id = System.currentTimeMillis();
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

  
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the subjectId
     */
    public long getSubjectId() {
        return subjectId;
    }

   

    @Override
    public boolean equals(Object obj) {
        
        if(obj != null){
            if(obj instanceof Concept){
                Concept c = (Concept) obj;
                
                if(id == c.getId() && subjectId == c.getSubjectId()){
                    return true;
                }
            }
        }
        
        return false;
    }

    @Override
    public String toString() {
        return getName();
    }
    
    
    
}
