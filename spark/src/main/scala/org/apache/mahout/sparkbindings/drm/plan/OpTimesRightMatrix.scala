/*
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

package org.apache.mahout.sparkbindings.drm.plan

import scala.reflect.ClassTag
import org.apache.mahout.math.Matrix
import org.apache.mahout.math.scalabindings._
import RLikeOps._
import org.apache.mahout.sparkbindings.drm.DrmLike

/** Logical times-right over in-core matrix operand. */
case class OpTimesRightMatrix[K: ClassTag](
    override var A: DrmLike[K],
    val right: Matrix
    ) extends AbstractUnaryOp[K, K] {

  override private[sparkbindings] lazy val partitioningTag: Long = A.partitioningTag

  assert(A.ncol == right.nrow, "Incompatible operand geometry")

  /** R-like syntax for number of rows. */
  def nrow: Long = A.nrow

  /** R-like syntax for number of columns */
  def ncol: Int = right.ncol

  /** Non-zero element count */
  // TODO
  def nNonZero: Long = throw new UnsupportedOperationException

}
