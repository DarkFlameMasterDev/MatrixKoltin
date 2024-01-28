import io.github.darkflamemasterdev.Matrix

fun main() {
//  testPreMultiply()
//  testPostMultiply()
//  sdada()

  testCanvasPostMultiply()
//  asdasdasda()
//  val vec3 = Matrix(3, 1, 1f, 1f, 1f)
//  println(transformMatrix * vec3)
}

private fun asdasdasda() {
  val matrix = Matrix(
    3, 3,
    1f, 0f, 0f,
    0f, 0.70710677f, 0f,
    0f, -0.0012276159f, 1f
  )
  val preTranslateMatrix = Matrix(
    3, 3,
    1f, 0f, -200f,
    0f, 1f, -200f,
    0f, 0f, 1f
  )
  val postTranslateMatrix = Matrix(
    3, 3,
    1f, 0f, 200f,
    0f, 1f, 200f,
    0f, 0f, 1f
  )
  val identityMatrix = Matrix(3, 3)
  println("identityMatrix = $identityMatrix")
  val transformMatrix1 = identityMatrix * preTranslateMatrix
  println(transformMatrix1)
  val transformMatrix2 = postTranslateMatrix * transformMatrix1
  println(transformMatrix2)
}

private fun testCanvasPostMultiply() {
  val a = Matrix(
    3, 1,
    1f,
    1f,
    1f
  )
  val matrixTranslate = Matrix(
    3, 3,
    1f, 0f, 7f,
    0f, 1f, 8f,
    0f, 0f, 1f
  )

  val matrixRotate = Matrix(
    3, 3,
    0.8660254f, -0.5f, 0f,
    0.5f, 0.8660254f, 0f,
    0f, 0f, 1f
  )
  val matrixScale = Matrix(
    3, 3,
    6f, 0f, 0f,
    0f, 2f, 0f,
    0f, 0f, 1f
  )

  println(matrixTranslate * a)
  println(matrixRotate * matrixTranslate * a)
  println(matrixScale * matrixRotate * matrixTranslate * a)
}

private fun sdada() {
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