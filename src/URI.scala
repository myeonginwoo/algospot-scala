

/**
  * Created by com on 2016-01-14.
  */
object Main {
  def solve(str : String): String =  {
    var result = str
    if(result.contains("%20"))
      result = result.replaceAll("[%]20", " ")
    if(result.contains("%21"))
      result = result.replaceAll("[%]21", "!")
    if(result.contains("%28"))
      result = result.replaceAll("[%]28", "(")
    if(result.contains("%29"))
      result = result.replaceAll("[%]29", ")")
    if(result.contains("%2a"))
      result = result.replaceAll("[%]2a", "*")
    if(result.contains("%24"))
      result = result.replaceAll("[%]24", "\\$")
    if(result.contains("%25"))
      result = result.replaceAll("[%]25", "%")

    return result

//    .replaceAll("[%]21", "!").replaceAll("[%]24", "$").replaceAll("[%]25", "%").replaceAll("[%]28", "(").replaceAll("[%]29", ")").replaceAll("[%]2a", "*")
  }

  def main(args: Array[String]): Unit = {

    val num = scala.io.StdIn.readLine.toInt
    val question: Array[String] = new Array[String](num)

    for( i <- 0 until num) {
      question(i) = scala.io.StdIn.readLine.toString
    }

    for( i <- 0 until num){
      println(solve(question(i)))
    }
  }
}
