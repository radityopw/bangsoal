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
package bangsoal.shared;

import java.io.File;

/**
 *
 * @author radityopw
 */
public final class Configuration {

    private File workingDir;
    private Version version;

    private static final Configuration instance = new Configuration();

    private Configuration() {
    }

    public static Configuration getInstance() {
        return instance;
    }

    /**
     * @return the workingDir
     */
    public File getWorkingDir() {
        return workingDir;
    }

    /**
     * @param workingDir the workingDir to set
     */
    public void setWorkingDir(File workingDir) {
        this.workingDir = workingDir;
    }

    /**
     * @return the version
     */
    public Version getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(Version version) {
        this.version = version;
    }

}
