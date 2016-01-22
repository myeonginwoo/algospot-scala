

/**
  * Created by com on 2016-01-14.
  */
object Main {

  val numString = Vector("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")

  def convert(str:String) :String ={
    str.sortBy( x => x)
  }

  def calc(x1 : Int , x2 :Int , op :String, y : String): String ={
    val result = op match {
      case "*" => x1*x2
      case "+" => x1+x2
      case "-" => x1-x2
    }

    if (result<0 || result>10)
      "No"
    else if(convert(numString(result)).equals(convert(y)))
      "Yes"
    else
      "No"
  }

  def solve(lineIn: Iterator[String])(lineOut: String => Unit) =
    for (i <- 1 to lineIn.next().toInt) {
      val Array(x1, op, x2, eq, y) = lineIn.next().split(' ')

     println(calc(numString.indexOf(x1), numString.indexOf(x2), op ,y))
//      lineOut(s"Case #$i: ${numberOfLines(totalMonths, dayPerMonth.toInt, dayPerWeek.toInt)}")
//      lineOut(result)
    }

  def main(args: Array[String]): Unit = {
    val num = scala.io.StdIn.readLine.toInt
    for ( i <- 0 until num){
      val Array(x1, op, x2, eq, y) = scala.io.StdIn.readLine.split(' ')
      println(calc(numString.indexOf(x1), numString.indexOf(x2), op ,y))
    }

//    val filename = "test"
//    val writer = new java.io.PrintWriter(filename + ".out")
//    try {
//      solve(io.Source.fromFile(filename + ".in").getLines) { s =>
//        writer.println(s); writer.flush()
//      }
//    } finally {
//      writer.flush(); writer.close()
//    }

  }
}
