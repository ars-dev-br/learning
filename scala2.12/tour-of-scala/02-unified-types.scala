object UnifiedTypes {
  def scalaTypeHierarchy(): Unit = {
    val list: List[Any] = List(
      "a string",
      732,
      'c',
      true,
      () => "an anonymous function returning a string"
    )

    list.foreach(element => println(element))
  }

  def typeCasting(): Unit = {
    val x: Long = 987654321
    val y: Float = x

    val face: Char = '☺'
    val number: Int = face

    // this will not compile:
    // val a: Long = 987654321
    // val b: Float = a
    // val c: Long = b
  }

  def nothingAndNull(): Unit = {
    trait NonTerminating {
      def nonTerminating(): Nothing
    }

    val nullValue: Null = null
  }

  def main(args: Array[String]): Unit = {
    scalaTypeHierarchy()
    typeCasting()
    nothingAndNull()
  }
}
