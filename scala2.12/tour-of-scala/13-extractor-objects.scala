import scala.util.Random

object ExtractorObject extends App {
  object CustomerID {
    def apply(name: String) = s"$name--${Random.nextLong}"

    def unapply(customerID: String): Option[String] = {
      val name = customerID.split("--").head
      if (name.nonEmpty) Some(name) else None
    }
  }

  val customer1ID = CustomerID("Sukyoung")
  customer1ID match {
    case CustomerID(name) => println(name)
    case _ => println("Coult not extract a CustomerID")
  }

  val customer2ID = CustomerID("Nico")
  val CustomerID(name) = customer2ID
  println(name)

  val CustomerID(name2) = "--asdfasdf"
}
