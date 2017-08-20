object PolymorphicMethods extends App {
  def repeat[A](x: A, length: Int): List[A] =
    if (length < 1) Nil else x :: repeat(x, length - 1)

  println(repeat[Int](3, 4))
  println(repeat("La", 8))
}
