import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by com on 2016-01-14.
  */
object Main {



  def main(args: Array[String]): Unit = {
//    Console.setIn(new FileInputStream("test.in"))
//    val num = scala.io.StdIn.readLine.toInt
    val num = StdIn.readLine().toInt
    for (i <- 0 until num) {
      val value = scala.io.StdIn.readLine
      println(solve(value))
    }
  }

  def solve(value : String): String = {

    val stack = mutable.Stack[Char]()
    value.foreach( s => s match{
      case '(' => {
        stack.push(s)
      }
      case '{' => {
        stack.push(s)
      }
      case '[' => {
        stack.push(s)
      }
      case ')' => {
        if(stack.top == '(') stack.pop() else stack.push(s)
      }
      case '}' => {
        if(stack.top == '{') stack.pop() else stack.push(s)
      }
      case ']' => {
        if(stack.top == '[') stack.pop() else stack.push(s)
      }
    })

    if(stack.size == 0)
      "YES"
    else
      "NO"
  }
}
