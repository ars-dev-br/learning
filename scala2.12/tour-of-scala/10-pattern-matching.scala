object PatternMatching {
  abstract class Notification
  case class Email(sender: String, title: String, body: String)
      extends Notification
  case class SMS(caller: String, message: String) extends Notification
  case class VoiceRecording(contactName: String, link: String)
      extends Notification

  def showNotification(notification: Notification): String = {
    notification match {
      case Email(email, title, _) =>
        s"You got an email from $email with title: $title"
      case SMS(number, message) =>
        s"You got an SMS from $number! Message: $message"
      case VoiceRecording(name, link) =>
        s"You received a voice recording from $name! Click the link to hear it: $link"
    }
  }

  def syntax(): Unit = {
    import scala.util.Random

    val x: Int = Random.nextInt(10)

    println(x match {
      case 0 => "zero"
      case 1 => "one"
      case 2 => "two"
      case _ => "many"
    })

    def matchTest(x: Int): String = x match {
      case 1 => "one"
      case 2 => "two"
      case _ => "many"
    }
  }

  def matchingOnCaseClasses(): Unit = {
    val sms = SMS("12345", "Are you there?")
    val voice = VoiceRecording("Tom", "voicerecording.org/id/123")

    println(showNotification(sms))
    println(showNotification(voice))
  }

  def patternGuards(): Unit = {
    def showImportantNotification(notification: Notification,
      importantPeople: Seq[String]): String = {
      notification match {
        case Email(email, _, _) if importantPeople.contains(email) =>
          "You got an email from special someone!"
        case SMS(number, _) if importantPeople.contains(number) =>
          "You got an SMS from special someone!"
        case other => showNotification(other)
      }
    }

    val importantPeople = Seq("867-5309", "jenny@gmail.com")

    val sms = SMS("867-5309", "Are you there?")
    val voice = VoiceRecording("Tom", "voicerecording.org/id/123")
    val importantEmail = Email("jenny@gmail.com", "Drinks tonight?",
      "I'm free after 5!")
    val importantSms = SMS("867-5309", "I'm here! Where are you?")

    println(showImportantNotification(sms, importantPeople))
    println(showImportantNotification(voice, importantPeople))
    println(showImportantNotification(importantEmail, importantPeople))
    println(showImportantNotification(importantSms, importantPeople))
  }

  def matchingOnTypeOnly(): Unit = {
    abstract class Device
    case class Phone(model: String) extends Device {
      def screenOff = "Turning screen off"
    }
    case class Computer(model: String) extends Device {
      def screenSaverOn = "Turning screen saver on"
    }

    def goIdle(device: Device) = device match {
      case p: Phone => p.screenOff
      case c: Computer => c.screenSaverOn
    }
  }

  def sealedClasses(): Unit = {
    sealed abstract class Furniture
    case class Couch() extends Furniture
    case class Chair() extends Furniture

    def findPlaceToSit(piece: Furniture): String = piece match {
      case a: Couch => "Lie on the couch"
      case b: Chair => "Sit on the chair"
    }
  }

  def main(args: Array[String]): Unit = {
    syntax()
    matchingOnCaseClasses()
    patternGuards()
    matchingOnTypeOnly()
    sealedClasses()
  }
}
