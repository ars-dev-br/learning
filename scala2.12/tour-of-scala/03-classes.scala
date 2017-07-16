object Classes {
  def definingAClass(): Unit = {
    class User
    val user = new User

    class Point(var x: Int, var y: Int) {
      def move(dx: Int, dy: Int): Unit = {
        x = x + dx
        y = y + dy
      }

      override def toString: String =
        s"($x, $y)"
    }

    val point = new Point(2, 3)
    println(point.x)
    println(point)
  }

  def constructors(): Unit = {
    class Point(var x: Int = 0, var y: Int = 0)

    val origin = new Point
    val point1 = new Point(1)
    println(point1.x)

    val point2 = new Point(y=2)
    println(point2.y)
  }

  def privateMembers(): Unit = {
    class Point {
      private var _x = 0
      private var _y = 0
      private val bound = 100

      def x = _x
      def x_= (newValue: Int): Unit = {
        if (newValue < bound) _x = newValue else printWarning
      }

      def y = _y
      def y_= (newValue: Int): Unit = {
        if (newValue < bound) _y = newValue else printWarning
      }

      private def printWarning = println("WARNING: Out of bounds")

    }

    val point = new Point
    point.x = 99
    point.y = 101

    // Constructor parameters with val and var are public.  However,
    // 'vals' keep the same semantics and cannot be changed after
    // creation.
    //
    // To create private values in a primary constructor, do not use
    // val or var:
    // class Point(x: Int, y: Int)
  }

  def main(args: Array[String]) {
    definingAClass()
    constructors()
    privateMembers()
  }
}
