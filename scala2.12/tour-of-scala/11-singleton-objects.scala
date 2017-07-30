object SingletonObjects {
  def singletonObjects(): Unit = {
    object Blah {
      def sum(l: List[Int]): Int = l.sum
    }
  }

  def companions(): Unit = {
    class IntPair(val x: Int, val y: Int)

    object IntPair {
      import math.Ordering

      implicit def ipord: Ordering[IntPair] =
        Ordering.by(ip => (ip.x, ip.y))
    }
  }

  def main(args: Array[String]): Unit = {
    singletonObjects()
    companions()
  }
}
