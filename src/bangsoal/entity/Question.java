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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author radityopw
 */
public class Question {
    
    long id;
    
    private String question;
    List<QuestionOption> options = new ArrayList<>();

    public Question(){
        id = System.currentTimeMillis();
    }
    
    public long getId(){
        return id;
    }
    
    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }
    
    public void addOption(QuestionOption a){
        options.add(a);
    }
    
    public void removeOption(QuestionOption a){
        options.remove(a);
    }
    
    public List<QuestionOption> getOptions(){
        return options;
    }
    
    public int getTotalOption(){
        return options.size();
    }
    
}
