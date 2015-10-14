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
package bangsoal.dao;

import bangsoal.dao.specs.ConceptDao;
import bangsoal.entity.Concept;
import bangsoal.shared.Common;
import bangsoal.shared.Configuration;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author radityopw
 */
public class ConceptDaoFile implements ConceptDao {

    private Map<String, Concept> list;

    private Configuration conf = Configuration.getInstance();

    private long subjectId;

    public ConceptDaoFile(long subjectId) {
        this.subjectId = subjectId;

        list = new TreeMap<>();
    }

    @Override
    public void save(Concept a) {
        File dir = new File(conf.getWorkingDir(), "concepts");
        File dir2 = new File(dir, subjectId + "");
        if (!dir2.exists()) {
            dir2.mkdir();
        }
        File file = new File(dir2, a.getId() + ".data");
        try {
            Common.objectToFile(file.getAbsolutePath(), a);
            list.put(a.getId() + "", a);
        } catch (IOException ex) {
            Logger.getLogger(SubjectDaoFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Collection<Concept> getAll() {
        if (list.size() == 0) {
            File dir = new File(conf.getWorkingDir(), "concepts");
            File dir2 = new File(dir, "" + subjectId);

            if (!dir2.exists()) {
                dir2.mkdir();
            }
            List<String> subDir = Arrays.asList(dir2.list());

            for (String d : subDir) {
                File ds = new File(dir2, d);
                Concept c = (Concept) Common.fileToObject(ds.getAbsolutePath());
                list.put(c.getId() + "", c);
            }
        }
        return list.values();
    }

    @Override
    public Concept get(int a) {

        Concept c = null;

        if (list == null) {
            getAll();
        }

        Iterator<Concept> iterator = list.values().iterator();
        int index = -1;

        while (index < a) {
            c = iterator.next();
            index++;
        }

        return c;

    }

    @Override
    public void delete(Concept a) {
        File dir = new File(conf.getWorkingDir(), "concepts");
        File dir2 = new File(dir, "" + subjectId);
        File file = new File(dir2, a.getId() + ".data");
        if (file.exists()) {
            file.delete();
            list.remove(a.getId() + "");
            a = null;
        }
    }

}
