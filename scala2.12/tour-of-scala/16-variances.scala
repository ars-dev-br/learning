object Variances {
  class Foo[+A] // covariant
  class Bar[-A] // contravariant
  class Baz[A] // invariant

  abstract class Animal {
    def name: String
  }

  case class Cat(name: String) extends Animal
  case class Dog(name: String) extends Animal

  def covariance(): Unit = {
    // list is covariant
    def printAnimalNames(animals: List[Animal]): Unit = {
      animals.foreach { animal => println(animal.name) }
    }

    val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
    val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

    printAnimalNames(cats)
    printAnimalNames(dogs)
  }

  def contravariance(): Unit = {
    abstract class Printer[-A] {
      def print(value: A): Unit
    }

    class AnimalPrinter extends Printer[Animal] {
      def print(animal: Animal): Unit =
        println("The animal's name is: " + animal.name)
    }

    class CatPrinter extends Printer[Cat] {
      def print(cat: Cat): Unit =
        println("The cat's name is: " + cat.name)
    }

    val myCat: Cat = Cat("Boots")

    def printMyCat(printer: Printer[Cat]): Unit = {
      printer.print(myCat)
    }

    val catPrinter: Printer[Cat] = new CatPrinter
    val animalPrinter: Printer[Animal] = new AnimalPrinter

    printMyCat(catPrinter)
    printMyCat(animalPrinter)
  }

  def invariance(): Unit = {
    class Container[A](value: A) {
      private var _value: A = value
      def getValue: A = _value
      def setValue(value: A): Unit = {
        _value = value
      }
    }

    val catContainer: Container[Cat] = new Container(Cat("Felix"))

    // invariance protects us from doing this:
    // val animalContainer: Container[Animal] = catContainer
    // animalContainer.setValue(Dog("Spot"))
    // val cat: Cat = catContainer.getValue
  }

  def main(args: Array[String]): Unit = {
    covariance()
    contravariance()
    invariance()
  }
}
