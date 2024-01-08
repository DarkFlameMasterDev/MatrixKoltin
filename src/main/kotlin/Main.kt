import io.github.darkflamemasterdev.Matrix

fun main() {
  val matrix = Matrix(3, 3)
  matrix.setMatrixValue(
    arrayOf(
      floatArrayOf(1f, 2f, 3f),
      floatArrayOf(1f, 2f, 3f),
      floatArrayOf(1f, 2f, 3f)
    )
  )
  println("matrix = $matrix")
}