

/**
  * Created by com on 2016-01-14.
  */
object Main {

  def xor1(x1 :Int, x2: Int, x3:Int, x4:Int) : Int = {
    val value = x1 ^ x2 ^ x3 ^ x4
    value.toInt
  }

  def xor2(x1 :Int, x2: Int, x3:Int) : Int = {
    val value = x1 ^ x2 ^ x3
    value.toInt
  }

  def x(value :Int): Int ={
    if(value == 0)
      1
    else
      0
  }

  def stringToInt(value : List[Int], acc:Int, sum: Int): Int = value.size match {
    case 1 =>  sum + value.head*acc
    case _ => stringToInt(value.init , acc*2, sum + value.last * acc)
  }

  def sovle(input: Array[Int]) : String = {
    val x1 = xor1(input(0), input(2), input(4), input(6)) ^ xor2(input(2), input(4), input(6))
    val x2 = xor1(input(1), input(2), input(5), input(6)) ^ xor2(input(2), input(5), input(6))
    val x3 = xor1(input(3), input(4), input(5), input(6)) ^ xor2(input(4), input(5), input(6))
    val result = List(x1 ,x2, x(input(2)), x3, input(4), input(5), input(6))

    val op = List(xor1(result(3), result(4), result(5), result(6)), xor1(result(1), result(2), result(5), result(6)), xor1(result(0), result(2), result(4), result(6)))
    val errorBit = stringToInt(op, 1, 0)
    if(errorBit != 0){
      val result2= result.patch(errorBit-1, Seq(x(result(errorBit-1))), 1)
      List(result2(2), result2(4), result2(5), result2(6)).mkString
    } else
      List(result(2), result(4), result(5), result(6)).mkString
  }

  def main(args: Array[String]): Unit = {
    val num = scala.io.StdIn.readLine.toInt
    for (i <- 0 until num) {
      val value = scala.io.StdIn.readLine
      println(sovle(value.map(s => s.toInt-48).toArray))
    }
  }
}
