import io.github.darkflamemasterdev.Matrix

fun main() {
  testPreMultiply()
  testPostMultiply()
  val a = Matrix(3, 3).apply {
    setMatrixValue(
      arrayOf(
        floatArrayOf(1f, 0f, 0f),
        floatArrayOf(0f, 0.8660254f, 0f),
        floatArrayOf(0f, -0.000860556f, 1f)
      )
    )
  }

  val b = Matrix(3, 3).apply {
    setMatrixValue(
      arrayOf(
        floatArrayOf(1f, 0f, 400f),
        floatArrayOf(0f, 0.8660254f, 346.41016f),
        floatArrayOf(0f, -0.00086805556f, 0.6527778f)
      )
    )
  }

  val x = Matrix(3, 3).apply {
    setMatrixValue(
      arrayOf(
        floatArrayOf(1f, 0f, 400f),
        floatArrayOf(0f, 1f, 400f),
        floatArrayOf(0f, 0f, 1f)
      )
    )
  }

  println(a.invert().preMultiply(b))
  println(a.preMultiply(x))
}

fun testPreMultiply() {
  val matrix1 = Matrix(3, 3)
  matrix1.setMatrixValue(
    arrayOf(
      floatArrayOf(1f, 5f, 4f),
      floatArrayOf(8f, 1f, 6f),
      floatArrayOf(2f, 3f, 7f)
    )
  )

  val matrix2 = Matrix(3, 3)
  matrix2.setMatrixValue(
    arrayOf(
      floatArrayOf(1f, 5f, 2f),
      floatArrayOf(5f, 3f, 7f),
      floatArrayOf(9f, 8f, 8f)
    )
  )
  println(matrix1.preMultiply(matrix2))
}

fun testPostMultiply() {
  val matrix1 = Matrix(3, 3)
  matrix1.setMatrixValue(
    arrayOf(
      floatArrayOf(1f, 5f, 4f),
      floatArrayOf(8f, 1f, 6f),
      floatArrayOf(2f, 3f, 7f)
    )
  )

  val matrix2 = Matrix(3, 3)
  matrix2.setMatrixValue(
    arrayOf(
      floatArrayOf(1f, 5f, 2f),
      floatArrayOf(5f, 3f, 7f),
      floatArrayOf(9f, 8f, 8f)
    )
  )
  println(matrix2.postMultiply(matrix1))
}