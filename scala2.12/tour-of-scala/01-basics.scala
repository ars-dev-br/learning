object Basics {
  def expressions(): Unit = {
    1 + 1

    println(1)
    println(1 + 1)
    println("Hello!")
    println("Hello," + " world!")
  }

  def values(): Unit = {
    val x = 1 + 1
    println(x)

    // x = 3 (does not compile, val cannot be reassigned)
    val y: Int = 1 + 2
  }

  def variables(): Unit = {
    var x = 1 + 1
    x = 3 // (var can be reassigned)
    println(x * x)

    var y: Int = 1 + 2
  }

  def blocks(): Unit = {
    println({
      val x = 1 + 1
      x + 1
    })
  }

  def functions(): Unit = {
    (x: Int) => x + 1

    val addOne = (x: Int) => x + 1
    println(addOne(1))

    val add = (x: Int, y: Int) => x + y
    println(add(1, 2))

    val getTheAnswer = () => 42
    println(getTheAnswer())
  }

  def methods(): Unit = {
    def add(x: Int, y: Int): Int = x + y
    println(add(1, 2))

    def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int =
      (x + y) * multiplier
    println(addThenMultiply(1, 2)(3))

    def name: String = System.getProperty("name")
    println("Hello, " + name + "!")

    def getSquareString(input: Double): String = {
      val square = input * input
      square.toString
    }
    println(getSquareString(5.0))
  }

  def classes(): Unit = {
    class Greeter(prefix: String, suffix: String) {
      def greet(name: String): Unit =
        println(prefix + name + suffix)
    }

    val greeter = new Greeter("Hello, ", "!")
    greeter.greet("Scala developer")
  }

  def caseClasses(): Unit = {
    case class Point(x: Int, y: Int)

    val point = Point(1, 2)
    val anotherPoint = Point(1, 2)
    val yetAnotherPoint = Point(2, 2)

    if (point == anotherPoint) {
      println(point + " and " + anotherPoint + " are the same.")
    } else {
      println(point + " and " + anotherPoint + " are different.")
    }

    if (point == yetAnotherPoint) {
      println(point + " and " + yetAnotherPoint + " are the same.")
    } else {
      println(point + " and " + yetAnotherPoint + " are different.")
    }
  }

  def objects(): Unit = {
    object IdFactory {
      private var counter = 0

      def create(): Int = {
        counter += 1
        counter
      }
    }

    val newId: Int = IdFactory.create()
    println(newId)
    val newerId: Int = IdFactory.create()
    println(newerId)
  }

  def traits(): Unit = {
    trait Greeter {
      def greet(name: String): Unit =
        println("Hello, " + name + "!")
    }

    class DefaultGreeter extends Greeter

    class CustomizableGreeter(prefix: String, postfix: String)
        extends Greeter {
      override def greet(name: String): Unit =
        println(prefix + name + postfix)
    }

    val customGreeter = new CustomizableGreeter("How are you, ", "?")
    customGreeter.greet("Scala developer")
  }

  def main(args: Array[String]): Unit = {
    expressions()
    values()
    variables()
    blocks()
    functions()
    methods()
    classes()
    caseClasses()
    objects()
    traits()
  }
}
