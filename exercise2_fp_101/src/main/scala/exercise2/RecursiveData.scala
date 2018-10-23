package exercise2

sealed trait List[A]
case class Cons[A](head: A, tail: List[A]) extends List[A]
case class Nil[A]() extends List[A]

/** Write your solutions as stand-alone functions. */
object RecursiveData {

  // a) Implement a function which determines if a `List[Int]` is empty or not.

  def isEmpty(list: List[Int]) :Boolean  = list match {
    case Nil() => true
    case _ => false
  }



  // apply your solution-function from (a) here, DO NOT change the signature
  def testListIntEmpty(list: List[Int]): Boolean = isEmpty(list)

  // b) Implement a function which gets the head of a `List[Int]` or returns -1 if empty.
  def head(list: List[Int]):Int  = list match {
    case Cons(h, _) => h
    case _ => -1
  }


  // apply your solution-function from (b) here, DO NOT change the signature
  def testListIntHead(list: List[Int]): Int = head(list)

  // c) Can we change `List[A]` to guarantee to be not-empty?


  /* d) Implement a generic Tree which has its values in the leafs and consists of:
   *      node - left and right Tree
   *      leaf - a value of type A
   */

  sealed trait Tree[A]
  case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]
  case class Leaf[A](a: A) extends Tree[A]
}
