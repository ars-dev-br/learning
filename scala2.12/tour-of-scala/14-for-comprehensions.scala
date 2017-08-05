object ForComprehensions extends App {
  case class User(val name: String, val age: Int)

  val userBase = List(User("Travies", 28),
    User("Kelly", 33),
    User("Jennifer", 44),
    User("Dennis", 23))

  val twentySomethings = for (user <- userBase
      if (user.age >=20 && user.age <30))
    yield user.name

  twentySomethings.foreach(name => println(name))
}
