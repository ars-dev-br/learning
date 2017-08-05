object LowerTypeBounds extends App {
  trait Node[+B] {
    def prepend[U >: B](elem: U)
  }

  case class ListNode[+B](h: B, t: Node[B]) extends Node[B] {
    def prepend[U >: B](elem: U) = ListNode[U](elem, this)
    def head: B = h
    def tail = t
  }

  case class Nil[+B]() extends Node[B] {
    def prepend[U >: B](elem: U) = ListNode[U](elem, this)
  }

  trait Bird
  case class AfricanSwallow() extends Bird
  case class EuropeanSwallow() extends Bird

  val africanSwallowList = ListNode[AfricanSwallow](AfricanSwallow(), Nil())
  val birdList: ListNode[Bird] = africanSwallowList
  birdList.prepend(new EuropeanSwallow)
}
