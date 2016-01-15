/**
  * Created by com on 2016-01-14.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val num = scala.io.StdIn.readLine.toInt
    var result :Array[String] = new Array[String](num)
    for( i <- 0 until num){
      val str = scala.io.StdIn.readLine
      val arr1 = str.toCharArray

      val size = arr1.size / 2
      val arr2: Array[String] = new Array[String](size)

      for(j <- 0 until (arr1.size/2)){
        arr2(j) = arr1(j*2).toString+arr1(j*2+1).toString
      }
      result(i) = arr2.sorted.mkString
    }

    for(value <-result)
      println(value)
  }
}
