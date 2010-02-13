/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.mahout.df.split;

/**
 * Contains enough information to identify each split
 */
public class Split {
  
  /** attribute to split for */
  public final int attr;
  
  /** Information Gain of the split */
  public final double ig;
  
  /** split value for NUMERICAL attributes */
  public final double split;
  
  public Split(int attr, double ig, double split) {
    this.attr = attr;
    this.ig = ig;
    this.split = split;
  }
  
  public Split(int attr, double ig) {
    this(attr, ig, Double.NaN);
  }
}
