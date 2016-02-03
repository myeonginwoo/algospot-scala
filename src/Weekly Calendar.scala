

/**
  * Created by com on 2016-01-14.
  */
object Main {

  val days = Vector(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
  val weeks = Vector("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

  def main(args: Array[String]): Unit = {
    val num = scala.io.StdIn.readLine.toInt
    for (i <- 0 until num) {
      val value = scala.io.StdIn.readLine
      solve(value)
    }
  }

  def solve(value : String): Unit ={
    val values = value.split(" ")
    val m = values(0).toInt
    val d = values(1).toInt
    val w = values(2)
    println(parse(m, d, w))
  }

  def parse(month : Int, day : Int, week : String) : String = {
    val preMaxDay = days(if(month-2 < 0) 11 else  month-2)
    val maxDay = days(month-1)
    val pos = weeks.indexOf(week)
    val result1 = leftSolve(Vector(), day-1, pos-1, preMaxDay)
    val result2 = rightSolve(Vector(), day+1, pos+1, maxDay)

    val result = (result1.reverse :+ day) ++ result2

    result.mkString(" ")
  }

  def leftSolve(result : Vector[Int], curr : Int, pos : Int, preMax : Int) : Vector[Int]= {
    if(pos < 0 )
        result
    else {
      var value = curr
      if(value < 0) value = preMax
      value +:
      leftSolve(result , value -1, pos -1, preMax)
    }
  }

  def rightSolve(result : Vector[Int], currDay : Int, pos : Int, max : Int) : Vector[Int]= {
    if(pos > 6)
      result
    else {
      var value = currDay
      if(value > max) value = 1
      value +:
        rightSolve(result , value +1, pos +1, max)
    }
  }

}
