package io.github.darkflamemasterdev

/**
 *
 * @property row Int
 * @property column Int
 * @property values Array<FloatArray>
 * @constructor
 */
class Matrix(private val row: Int, private val column: Int) {
  private var values = Array(row) { FloatArray(column) { 0f } }

  /**
   * Set the value of the matrix
   * @param value Array<FloatArray>
   */
  fun setMatrixValue(value: Array<FloatArray>) {
    if (value.size != row || value[0].size != column) {
      throw IllegalArgumentException("Matrix size not match")
    }
    this.values = value
  }

  /**
   * pre multiply the {@param matrix}
   * 将当前矩阵放在左侧，也就是当前矩阵左乘 {@param matrix}
   * @param matrix Matrix
   * The row of matrix should be same as the column of current matrix
   * @return Matrix
   */
  fun preMultiply(matrix: Matrix): Matrix {
    if (column != matrix.row) {
      throw IllegalArgumentException("Matrix multiplication not possible")
    }
    val product = Matrix(row, matrix.column)
    val productValues = Array(row) { FloatArray(matrix.column) { 0f } }
    for (i in 0..<row) {
      for (j in 0..<column) {
        for (k in 0..<column) {
          productValues[i][j] += this.values[i][k] * matrix.values[k][j]
        }
      }
    }
    product.values = productValues
    return product
  }

  /**
   * Post multiply the {@param matrix}
   * 将当前矩阵放在右侧，也就是当前矩阵右乘 {@param matrix}
   * @param matrix Matrix
   * The column of matrix should be same as the row of current matrix
   * @return Matrix
   */
  fun postMultiply(matrix: Matrix): Matrix {
    if (row != matrix.column) {
      throw IllegalArgumentException("Matrix multiplication not possible")
    }
    val product = Matrix(matrix.row, column)
    val productValues = Array(matrix.row) { FloatArray(column) { 0f } }
    for (i in 0..<matrix.row) {
      for (j in 0..<matrix.column) {
        for (k in 0..<matrix.column) {
          productValues[i][k] += matrix.values[i][j] * values[j][k]
        }
      }
    }
    product.values = productValues
    return product
  }

  /**
   * Plus two matrix
   * Need to be same row and column
   * @param other Matrix
   * @return Matrix
   */
  operator fun plus(other: Matrix): Matrix {
    if (row != other.row || column != other.column) {
      throw IllegalArgumentException("Matrix addition not possible")
    }
    val sum = Matrix(row, column)
    for (i in 0..<row) {
      for (j in 0..<column) {
        sum.values[i][j] = this.values[i][j] + other.values[i][j]
      }
    }
    return sum
  }

  /**
   * Minus two matrix
   * @param other Matrix
   * Should be same row and column
   * @return Matrix
   */
  operator fun minus(other: Matrix): Matrix {
    if (row != other.row || column != other.column) {
      throw IllegalArgumentException("Matrix subtraction not possible")
    }
    val difference = Matrix(row, column)
    for (i in 0..<row) {
      for (j in 0..<column) {
        difference.values[i][j] = this.values[i][j] - other.values[i][j]
      }
    }
    return difference
  }

  /**
   * Times two matrix
   * Same as preMultiply
   * @see preMultiply
   * @param other Matrix
   * @return Matrix
   */
  operator fun times(other: Matrix): Matrix {
    val matrix = preMultiply(other)
    return matrix
  }

  /**
   * Get the inverse matrix of the current matrix
   * @return Matrix
   */
  fun invert(): Matrix {
    if (row != column) {
      throw IllegalArgumentException("Row is not equal to column , Matrix inversion not possible")
    }
    if (calculateDeterminant() == 0.0) {
      throw IllegalArgumentException("Determinant is zero , Matrix inversion not possible")
    }
    val augmentedMatrix = Matrix(row, column * 2)
    val augmentedMatrixValues = Array(row) { i ->
      FloatArray(column * 2) { j ->
        if (j < column) this.values[i][j] else if (i == j - row) 1f else 0f
      }
    }
    augmentedMatrix.setMatrixValue(augmentedMatrixValues)

    for (i in 0..<augmentedMatrix.row) {
      val factor = augmentedMatrix.values[i][i]
      for (j in 0..<augmentedMatrix.column) {
        augmentedMatrix.values[i][j] /= factor
      }

      for (k in 0..<augmentedMatrix.row) {
        if (k != i) {
          val multiplier = augmentedMatrix.values[k][i]
          for (j in 0..<augmentedMatrix.column) {
            augmentedMatrix.values[k][j] -= augmentedMatrix.values[i][j] * multiplier
          }
        }
      }
    }

    val inverseMatrix = Matrix(row, column)
    val inverseMatrixValues = Array(row) { i ->
      FloatArray(column) { j ->
        augmentedMatrix.values[i][j + row]
      }
    }
    inverseMatrix.setMatrixValue(inverseMatrixValues)

    return inverseMatrix
  }

  /**
   * calculate the determinant of the current matrix
   * @return Double
   */
  fun calculateDeterminant(): Double {
    if (row != column) {
      throw IllegalArgumentException("row is not equal to column , Matrix inversion not possible")
    }
    if (row == 1) {
      return this.values[0][0].toDouble()
    }
    if (row == 2) {
      return this.values[0][0].toDouble() * this.values[1][1] - this.values[0][1] * this.values[1][0]
    }
    var determinant = 0.0
    for (i in 0..<row) {
      val childMatrix = getSubMatrix(this, i, 0)
      val childMatrixDeterminant = childMatrix.calculateDeterminant()
      determinant += this.values[i][0] * childMatrixDeterminant
    }
    return determinant
  }

  /**
   * Get the sub-matrix excluding a certain row and column
   * Mainly calculated using determinants
   * @param matrix Matrix
   * @param excludedRow Int
   * @param excludedColumn Int
   * @return Matrix
   */
  private fun getSubMatrix(matrix: Matrix, excludedRow: Int, excludedColumn: Int): Matrix {
    val childMatrix = Matrix(matrix.row - 1, matrix.column - 1)
    var childMatrixRowIndex = 0
    var childMatrixColumnIndex = 0
    for (i in 0..<matrix.row) {
      if (excludedRow == i) {
        continue
      }
      for (j in 0..<matrix.column) {
        if (excludedColumn == j) {
          continue
        }
        childMatrix.values[childMatrixRowIndex][childMatrixColumnIndex++] = matrix.values[i][j]
      }
      childMatrixColumnIndex = 0
      childMatrixRowIndex++
    }
    return childMatrix
  }

  /**
   * Print the matrix values
   * @return String
   */
  override fun toString(): String {
    val sb = StringBuilder()
    sb.append("{")
    for (i in 0..<row) {
      sb.append("[")
      for (j in 0..<column) {
        sb.append(values[i][j])
        if (j != column - 1) {
          sb.append(", ")
        }
      }
      sb.append("]")
      if (i != row - 1) {
        sb.append(",")
      }
    }
    sb.append("}")
    return sb.toString()
  }
}