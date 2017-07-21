object Mixins {
  def firstExample(): Unit = {
    abstract class A {
      val message: String
    }

    class B extends A {
      val message = "I'm an instance of class B"
    }

    trait C extends A {
      def loudMessage = message.toUpperCase()
    }

    class D extends B with C

    val d = new D
    println(d.message)
    println(d.loudMessage)
  }

  def secondExample(): Unit = {
    abstract class AbsIterator {
      type T
      def hasNext: Boolean
      def next: T
    }

    class StringIterator(s: String) extends AbsIterator {
      type T = Char
      private var i = 0
      def hasNext = i < s.length
      def next = {
        val ch = s charAt i
        i += 1
        ch
      }
    }

    trait RichIterator extends AbsIterator {
      def foreach(f: T => Unit): Unit = while (hasNext) f(next)
    }

    class Iter extends StringIterator("really nice") with RichIterator
    val iter = new Iter
    iter foreach println
  }

  def main(args: Array[String]): Unit = {
    firstExample()
    secondExample()
  }
}
