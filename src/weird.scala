

/**
  * Created by com on 2016-01-14.
  */
object Main {

  def ld(n:Int): Int ={
    ldf(2, n)
  }

  def ldf(x1: Int , x2 : Int) : Int ={
    if((x2 % x1) == 0) x1
    else if (x1*x1 > x2) x2
    else ldf(x1+1, x2)
  }

  def factors(n: Int) : List[Int] = n match {
    case 1 => Nil
    case _ =>  {
      val p = ld(n)
      p :: factors(n/p)
    }
  }

  def getValue(x1: Int , x2: List[Int]): List[Int] ={
    x2.map(x => if(x%x1 !=0 )x1*x else x)
  }

  def getDivisions(factor:List[Int]) : List[Int] = factor.size match {
    case 1 => factor
    case _ => {
      val values = getValue(factor.head, factor.tail)
      factor ::: values ::: getDivisions(factor.tail)
    }
  }

  //
  //    def solve(result : Int) = {
  //      var resultVector = Vector()
  //      getDivisor(result, resultVector)
  //      }
  def checkSum(division: List[Int]): List[Int] =   division.size match {
    case 1 => {
      division(0) :: Nil
    }
    case _ => {
      var result: List[Int] =List()
      for (i <- 0 until division.size) {
        val res = division.filter(s => s != division(i))
        val reSum = res.foldLeft(0)(_ + _)

        result = reSum:: result
        checkSum(res)
//        result = checkSum(res) :: result
//        checkSum(res) ::result
//        println("result2 : " + result)
      }
      result.distinct.sortBy(s => s)
    }
  }

  def isWeird(division: List[Int], sum: Int): Boolean = {
    val result = division.foldLeft(0)(_ + _) :: checkSum(division)
    result.sortBy(s => s)
    if(result.contains( sum))
      false
    else {
      true
    }
  }

  def newFactors(factor: List[Int]) = {
    var newFactor = List[Int]()
    val in = factor.distinct
    for( i <- 0 until in.size ){
      var count = 1;
      for(j <- 0 until factor.size){
        if(factor(j) == in(i)) {
          newFactor = scala.math.pow(factor(j), (count)).toInt :: newFactor.reverse
          count +=1
        }
      }
    }
    newFactor
  }

  def main(args: Array[String]): Unit = {
    val num = scala.io.StdIn.readLine.toInt
    for ( i <- 0 until num){
      val value = scala.io.StdIn.readLine.toInt
      val factor = factors(value)
      val newFactor = newFactors(factor).sortBy(x =>x)
      val fullDivision = 1 :: getDivisions(newFactor).distinct.filter(x => x< value).sortBy(s => s)

//      println("fulDivision : " + fullDivision)
      val sum = fullDivision.foldLeft(0)(_ + _)
//      println("sum : " + sum)

      if(sum < value)
        println("weird")
      else {
        val result = value - sum

        val division = fullDivision.filter(n => result + n <= 0)
        if (division.contains(-result))
          println("not weird")
        else {
          //        println("weird")
          //          println("weird")
          if (isWeird(division, result))
            println("weird")
          else
            println("not weird")
        }
      }
    }
  }
}
