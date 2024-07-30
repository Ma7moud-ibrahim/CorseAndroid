fun main() {
   /*
    var num = 0
    var count = 0

    while (num <= 15) {
        if (num % 2 == 0) {
            println(num)
            count++
        }
        num++
    }
    println("Count of even numbers: $count")


    var count2 = 0

    for (num2 in 0..15) {
        if (num2 % 2 == 0) {
            println(num2)
            count2++
        }
    }
    println("Count of even numbers: $count2")*/


//    1) Finding the First Even Number
//    from 1 -> 10
//    1) (Using break)
   /* var num = 1

    while (num <= 10) {
        if (num % 2 == 0) {
            println("The Result = $num")
            break
        }
        num++
    }*/
//    2) Finding only odd numbers
//    from O -> IO
//    (Using continue)
    /*var num2 = 0

    while (num2 <= 10) {
        if (num2 % 2 == 1) {
            println(num2)
            num2++
            continue
        }
        num2++
    }
    var name = "medo"
    println(name)

     */
    //predict
//    var numbers = listOf(1,4,7,8)
//    val evenNumber  = numbers.filter { it%2 == 0 }
//    val mapNumber  = numbers.map { it*2 }

    val mutableSet = mutableSetOf(1,2,4,5,3)
    println(mutableSet)
    mutableSet.add(6)
    mutableSet.remove(4)
    println(mutableSet)

    val mutableMap:MutableMap<String,Int> = mutableMapOf("one" to 1 , "two" to 2,"three" to 3)
    println(mutableMap)
    mutableMap["four"]=4
    mutableMap.remove("one")
    println(mutableMap)



}