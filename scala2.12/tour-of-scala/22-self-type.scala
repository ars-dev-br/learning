object SelfType extends App {
  trait User {
    def username: String
  }
  trait Tweeter {
    this: User =>
    def tweet(tweetText: String) = println(s"$username: $tweetText")
  }

  class VerifiedTweeter(val username_ : String) extends Tweeter with User {
    def username = s"real $username_"
  }

  val realBeyoncé = new VerifiedTweeter("Beyoncé")
  realBeyoncé.tweet("Just spilled my glass of lemonade")
}
