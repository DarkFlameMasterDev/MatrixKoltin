import io.github.darkflamemasterdev.Matrix

fun main() {
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