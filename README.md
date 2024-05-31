# MatrixKotlin

## implementation

```kotlin
repositories {
  mavenCentral()
}
```

```kotlin
implementation("io.github.darkflamemasterdev:MatrixKotlin:1.1.2")
```    

## usage

### 初始化

```kotlin
// 1 默认初始化为单位矩阵
val scaleMatrix = Matrix(3, 3)

// 2
val scaleMatrix = Matrix(3, 3).apply {
  setMatrixValue(
    arrayOf(
      floatArrayOf(3f, 0f, 0f),
      floatArrayOf(0f, 7f, 0f),
      floatArrayOf(0f, 0f, 8f)
    )
  )
}

// 3
val scaleMatrix = Matrix(
  3, 3,
  3f, 0f, 0f,
  0f, 7f, 0f,
  0f, 0f, 8f
)

// 4
val scaleMatrix = Matrix(
  arrayOf(
    floatArrayOf(
      3f, 0f, 0f,
      0f, 7f, 0f,
      0f, 0f, 8f
    )
  )
)
```

### calculate 计算

#### reset to the unit matrix (identityMatrix) 重置为单位矩阵

```kotlin
matrix.reset()
```

#### plus and minus 加减

```kotlin
val sumMatrix = matrix_A + matrix_B

val diffMatrix = matrix_A - matrix_B
```

#### times 相乘

```kotlin
// 左乘，将当前矩阵放在左侧，也就是当前矩阵左乘 {@param matrix}
matrix_A.preMultiply(matrix_B)

// 右乘，将当前矩阵放在右侧，也就是当前矩阵右乘 {@param matrix}
matrix_A.postMultiply(matrix_B)

// 相乘
matrix_A * matrix_B
```

#### Get the inverse matrix of the current matrix 逆矩阵

```kotlin
matrix.invert()
```

#### calculate the value of determinant 计算行列式的值

```kotlin
matrix.calculateDeterminant()
```

#### Get the sub-matrix excluding a certain row and column 获得子矩阵

```kotlin
matrix.getSubMatrix(1, 0)
```

#### toString

```kotlin
matrix.toString()
```