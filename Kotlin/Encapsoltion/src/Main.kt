import kotlin.math.log

class Person {
    private var firstName: String = ""
    private var lastName: String = ""

    fun setFirstName(firstName: String) {
        this.firstName = firstName
    }

    fun getFirstName(): String {
        return firstName
    }

    fun setLastName(lastName: String) {
        this.lastName = lastName
    }

    fun getLastName(): String {
        return lastName
    }
}

class Logger constructor(){
    companion object{
        fun log(n:Int){
            println("The Num = $n")
        }
    }

}
data class Book(val title :String,val author:String,val number:Int ,val  ISBN:Int ,val Intpublicationofyear: Int)
//task3
abstract  class Animal{
    abstract fun makeSound()
}
class Cat : Animal() {
    override fun makeSound() {
        println("Meow")
    }
}
class Dog : Animal() {
    override fun makeSound() {
        println("Woof")
    }
}
//task4
interface Pet{
    fun play()
}
class CatInterface :Pet{
    override fun play() {
        println("Cat run!")
    }

}
class DogInterface :Pet  {
    override fun play() {
        println("Dog run!")
    }

}
fun main() {

    val cat2 = CatInterface()
    val dog2 = DogInterface()

    cat2.play()
    dog2.play()
//    val cat = Cat()
//    val dog = Dog()
//
//    cat.makeSound()
//    dog.makeSound()


//    val book = Book("Death", "medo", 14, 54, 2005)
//    val book2 = Book("Death2", "medo2", 14, 54, 2005)
//    println(book.toString())
//    println(book == book2)
//    val book3 =book.copy()
//    println(book3)
//    println(book.component1())
    /*val person = Person()
    person.setFirstName("Mahmoud")
    person.setLastName("Ebrahim")

    println("First Name = ${person.getFirstName()}")
    println("Last Name = ${person.getLastName()}")

    Logger.log(4)*/
}
