

/**
  * Created by com on 2016-01-14.
  */
object Main {
  def solve(value : Float, unit : String): String = unit match {
    case "kg" => "%.4f".format(value * 2.2046) + " lb"
    case "l" => "%.4f".format(value * 0.2642) + " g"
    case "lb" => "%.4f".format(value * 0.4536) + " kg"
    case "g" => "%.4f".format(value * 3.7854) + " l"
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
      results(i)= solve(q(0).toFloat, q(1).toString).toString
    }
    for( i <- 1 to num){
      println(i + " " +results(i-1))
    }

  }
}
