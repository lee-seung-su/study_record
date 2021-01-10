package com.example.test
import java.util.Scanner
import java.util.function.DoubleToIntFunction

fun main() {
    //print("enter value : ")
    //println()
    //val value :Int? = readLine()!!.toInt()
    /*
    var arr = mutableListOf<Int>(4)
    arr.add(6)
    arr.add(32)
    for(value in arr){
        print("$value  ")
    }
    func(arr)
    println()
    for(value in arr){
        print("$value  ")
    }
    println()
    func2(1,2,3)
    func2(2,4)
    func2(4)
    func2()
    func2(a=33,c = 99, b = 44)

     */
    /*
    var du1 = DataUser(1,2)
    var du2 = du1.copy()
    du2.val2 = 333
    du2.val1= 111
    println(du2.toString())
    var c1 = Child()
    c1.func1()
    c1.func2()
    c1.func4()
    c1.func3()
    c1.sleep()

    var str = "hello"
    str = str.plus("bye")
    println(str)
    */
    /*
    var c = cat()
    c.move()
    c.sound()
    c.walk()
    var d = dog()
    println("${d.name}")
    println("${d.name} ${d.act()}, ${d.owner()}")  //이렇게 함수도 호출가능하다.
                        // 근데 변수보다 함수가 먼저실행되고 나중에 타입이 찍힌다
    var test = object : animal_object{
        override var name = "바보"


        override fun owner() {
            println("owner호출")
        }

        override fun act() {
            println("act호출")
        }

    }

    //test.age=3
    println(test.name)
    var test2 = object : aaa{}  //인터페이스안에는 구현된 함수넣어도된다!!
                        //인터페이스는
    test2.func()
    test2.func2()
    */
    var str:String?=null
    null_func(str)
    null_func(null)
    null_func("223")

}
fun null_func(str:String?){
    //if(str !=null){    println(str.length)}
    println(str?.length)  //?.는 null이 아닐때만 뒷부분 진행. ?.안쓰면 null일경우 프로그램 다운
    println(str?.length?:333)  //?:는 null이면 오른쪽값 적용하라는것
}
interface aaa{
    fun func(){
        println("dfd")
    }
    fun func2(){
        println("dfdf")
    }
}
class dog:animal_object{
    override var name= "멍멍이"
    override fun owner(){
        println("내가 주인이다")
    }
    override fun act(){
        println("몰라 산책하겠지뭐")
    }
}
interface animal_object{
    public var name:String  //interface는 이름 초기화하려면 setter로 해야한다. 바로 초기화못함
    public fun owner()
    public fun act()
}
class cat : animal(){
    override fun move(){
        println("살금살금")
    }
    override fun sound(){  //추상화되어있는 메서드 모두 구현해야된다.
        println("야옹야옹")
    }
}

abstract class animal{
    fun walk(){
        println("걷는다")
    }
    abstract fun move()
    abstract fun sound()
}
fun Parent.sleep(){  //메서드 extension. 실제코드 변경x
    println("parent is sleeping")
}
open class Parent{
    open fun func1(){
        println("parent_func1")
    }
    fun func2(){
        println("parent_func2")
    }

}
class Child:Parent(){
    override fun func1(){
        println("child_func1")
    }
    fun func3(){
        println("child_func3")
    }
    fun func4(){
        println("only parent have!!")
    }
}
data class DataUser(var val1 : Int=3, var val2 : Int =4)
fun func2(a:Int=3, b:Int=4, c:Int=5){
    println("$a  $b  $c")
}
fun func(array: MutableList<Int>){
    for(i in 0 until array.size){
        array[i] *=-1
    }

}
fun test(value :Int){
    when {
        value == 3 -> {
            print("this is 3")
        }
        value == 4 -> {
            print("this is 4")
        }
        value == 99 -> {
            print("this is 99")
        }
        value > 100 -> {
            print("bigger than 100")
        }
        else -> {
            print("else..")
        }

    }

}