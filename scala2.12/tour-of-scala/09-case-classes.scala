object CaseClasses {
  case class Message(sender: String, recipient: String, body: String)

  def definingACaseClass(): Unit = {
    case class Book(isbn: String)
    val frankenstein = Book("978-0486282114")

    val message = Message("guillaume@quebec.ca", "jorge@catalonia.es",
      "Ça va ?")

    println(message.sender)
    // message.sender = "travis@washington.us" // does not compile
  }

  def comparison(): Unit = {
    val message1 = Message("jorge@catalonia.es", "guillaume@quebec.ca",
      "Com va?")
    val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca",
      "Com va?")
    val areTheSame = message1 == message2

    println(areTheSame)
  }

  def copying(): Unit = {
    val message4 = Message("julien@bretagne.fr", "travis@washington.us",
      "Me zo o komz gant ma amezeg")
    val message5 = message4.copy(sender = message4.recipient,
      recipient = "claire@bourgogne.fr")

    println(message5.sender)
    println(message5.recipient)
    println(message5.body)
  }

  def main(args: Array[String]): Unit = {
    definingACaseClass()
    comparison()
    copying()
  }
}
