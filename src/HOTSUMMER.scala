object Main {
  def main(args: Array[String]): Unit = {

    val num = scala.io.StdIn.readLine.toInt

    val sum1: Array[Int] = new Array[Int](num)
    val sum2: Array[Int] = new Array[Int](num)

    for( i <- 0 until num*2) {
      if(i%2 == 0)
        sum1(i/2) = scala.io.StdIn.readLine.toInt
      else {
        sum2(i/2) = scala.io.StdIn.readLine.toString.split(" ").toList.map(s => s.toInt).sum
      }
    }
    for( i <- 0 until num){
      if(sum1(i) >= sum2(i))
        println("YES")
      else
        println("NO")
    }

  }
}
