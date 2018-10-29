package exercise3

import scala.util.{Try, Failure, Success}

/** Implement stand-alone functions as solutions.
  * 
  * List(1, 2) match {
  *   case head :: tail => ???
  *   case Nil          => ???
  *   case l            => ???
  * }
  * 
  * Option(1) match {
  *   case Some(a) => ???
  *   case None    => ???
  * }
  * 
  * Either.cond(true, 1, "right") match {
  *   case Left(i)  => ???
  *   case Right(s) => ???
  * }
  * 
  * Try(impureExpression()) match {
  *   case Success(a)     => ???
  *   case Failure(error) => ???
  * }
  * 
  * Try(impureExpression()).toEither
  * 
  */
object Adts {

  // a) Given a List[Int] return the nth element
  def getNth(list: List[Int], n: Int) : Option[Int] = (list, n) match {
    case (v :: _, 0) => Some(v)
    case (_ :: tail, b) => getNth(tail, b-1)
    case (Nil, _) => None
  }



  // apply your solution-function from (a) here, DO NOT change the signature
  def testGetNth(list: List[Int], n: Int): Option[Int] = getNth(list, n)

  // b) Double the given number.
  //def double(n: Option[Int]) : Option[Int] = n.map(_ * 2) //Using map on a Option keeps the Option Intact and
  //won't throw any or do any calculation if the value is None, It's safe
  def double(n: Option[Int]) : Option[Int] = n match {
    case Some(b) => Some(b * 2)
    case None => None
  }
  


  // apply your solution-function from (b) here, DO NOT change the signature
  def testDouble(n: Option[Int]): Option[Int] = double(n)

  // c) Check if a given Int is even. If so, return it as a Right. Otherwise, return Left("Not an even number.").

  def isEven(n: Int) :Either[String, Int] = n match {
    case _ if n % 2 == 0 => Right(n)
    case _ => Left("Not an even number.")
  }



  // apply your solution-function from (c) here, DO NOT change the signature
  def testIsEven(n: Int): Either[String, Int] =isEven(n)

  // d) Safe division for Integers. Return Right with the result or Left("You cannot divide by zero.").

  def safeDivide(a: Int, b: Int) :Either[String, Int] = (a, b) match {
    case _ if b == 0 => Left("You cannot divide by zero.")
    case _ => Right(a / b)
  }



  // apply your solution-function from (d) here, DO NOT change the signature
  def testSafeDivide(a: Int, b: Int): Either[String, Int] = safeDivide(a, b)

  // e) Given an impure function handle its Exceptions and recover from them by returning 0.

  def impure(str: String) :Try[Int] = Try(str.length)



      // apply your solution-function from (e) here, DO NOT change the signature
      def testGoodOldJava(impure: String => Int, str: String): Try[Int] =
        Try(impure(str)).recover { case _ => 0}
}
