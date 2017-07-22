object NestedMethods {
  def factorial(x: Int): Int = {
    def fact(x: Int, acc: Int): Int = {
      if (x <= 1) acc
      else fact(x - 1, x * acc)
    }

    fact(x, 1)
  }

  def main(args: Array[String]): Unit = {
    println("Factorial of 2: " + factorial(2))
    println("Factorial of 3: " + factorial(3))
  }
}
