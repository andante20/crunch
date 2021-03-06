/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.crunch.io.text;

import org.apache.crunch.io.FileNamingScheme;
import org.apache.crunch.io.SequentialFileNamingScheme;
import org.apache.crunch.io.impl.ReadableSourcePathTargetImpl;
import org.apache.crunch.types.PType;
import org.apache.hadoop.fs.Path;

public class TextFileSourceTarget<T> extends ReadableSourcePathTargetImpl<T> {

  public TextFileSourceTarget(String path, PType<T> ptype) {
    this(new Path(path), ptype);
  }

  public TextFileSourceTarget(Path path, PType<T> ptype) {
    this(path, ptype, SequentialFileNamingScheme.getInstance());
  }

  public TextFileSourceTarget(Path path, PType<T> ptype, FileNamingScheme fileNamingScheme) {
    super(new TextFileSource<T>(path, ptype), new TextFileTarget(path), fileNamingScheme);
  }

  @Override
  public String toString() {
    return target.toString();
  }
}
