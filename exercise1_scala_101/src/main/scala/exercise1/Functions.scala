package exercise1

/** Write your solutions as stand-alone functions. 
  * 
  * Syntax:
  *   // method
  *   def myFunction(param0: Int, param1: String): Double = // body expression
  * 
  *   // value
  *   val myFunction: (Int, String) => Double (param0, param1) => // body expression
  */
object Functions {

  /* a) Write a function which calculates the area of a
   *    circle r^2 * Math.PI
   */
  def circle(r: Double) :Double =  r * r * Math.PI



  // apply your solution-function from (a) here, DO NOT change the signature
  def testCircle(r: Double): Double = circle(r)
  
  /* b) Write a curried function which calculates the area of a
   *    rectangle a * b.
   */

  def rectangle(a:Double, b:Double) :Double =  a * b

  //Solution
  def rectangleCurried(a: Double)(b: Double) :Double = a * b



  // apply your solution-function from (b) here, DO NOT change the signature
  def testRectangleCurried(a: Double, b: Double): Double = rectangleCurried(a)(b)

  // c) Write a uncurried `rectangle` function.



  // apply your solution-function from (c) here, DO NOT change the signature
  def testRectangleUc(a: Double, b: Double): Double = a
}
