

/**
  * Created by com on 2016-01-14.
  */
object Main {

  def solve(index : Int, str : String): String ={
    var result =""
    for(i <- 0 until str.length){
      if(i != index-1)
        result+=str(i)
    }
    result
  }

  def main(args: Array[String]): Unit = {

    val num = scala.io.StdIn.readLine.toInt

    var question : Array[String] = new Array[String](num)
    var results: Array[String] = new Array[String](num)

    for( i <- 0 until num) {
      question(i) = scala.io.StdIn.readLine.toString
    }

    for( i <- 0 until num){
      val q = question(i).split(" ")
      results(i)= solve(q(0).toInt, q(1).toString).toString
    }
    for( i <- 1 to num){
      println(i + " " +results(i-1))
    }

  }
}
