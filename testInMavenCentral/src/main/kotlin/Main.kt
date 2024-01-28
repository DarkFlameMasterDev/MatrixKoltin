import io.github.darkflamemasterdev.Matrix

fun main() {
//  canvasMatrixTest()
//  contactMatrixTest()
  contactMatrixTest()
}

private fun contactMatrixTest() {
  val matrix = Matrix(3, 3).apply {
    setMatrixValue(
      arrayOf(
        floatArrayOf(42f, 37f, -1f),
        floatArrayOf(51f, 73f, 20f),
        floatArrayOf(75f, 55f, 8f)
      )
    )
  }

  val canvasMatrix = Matrix(3, 3).apply {
    setMatrixValue(
      arrayOf(
        floatArrayOf(2f, 4f, 3f),
        floatArrayOf(8f, 5f, 9f),
        floatArrayOf(2f, 5f, 7f)
      )
    )
  }

  val cameraMatrix = Matrix(3, 3).apply {
    setMatrixValue(
      arrayOf(
        floatArrayOf(-6f, 2f, 1f),
        floatArrayOf(9f, 6f, -3f),
        floatArrayOf(6f, 3f, 3f)
      )
    )
  }

  val x = canvasMatrix * cameraMatrix

  println(x)
}

private fun canvasMatrixTest() {
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

  println(a.invert() * b)
  println(a * x)
}