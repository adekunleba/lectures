package exercise2

import scala.annotation.tailrec

/** Implement stand-alone functions for your solutions.
  * REMARK: Try to make all functions tail recursive; use the annotation to proof it.
  * 
  * A function is tail recursive if if:
  *   1. it is single direct recursion
  *   2. the last expression is the recursive call
  */
object RecursiveFunctions {

  def length[A](as: List[A]): Int = {
    @tailrec
    def loop(rem: List[A], agg: Int): Int = rem match {
      case Cons(_, tail) => loop(tail, agg + 1)
      case Nil()         => agg
    }

    loop(as, 0)
  }

  /* a) Write a function that reverses a list:
   *        def reverse[A](list: List[A]): List[A]
   */

  def reverse[A](as: List[A]) :List[A] = {
    @tailrec
    def loop(rem: List[A], x: List[A]) :List[A] = rem match {
        //Append to the lat list
      case Nil() => x
      case Cons(h, tail) => loop(tail, Cons(h, x))
    }
    loop(as, Nil())
  }



  // apply your solution-function from (a) here, DO NOT change the signature
  def testReverse[A](list: List[A]): List[A] = reverse(list)

  /* b) Write a function that applies a function to every value of a list:
   *        def map[A, B](list: List[A])(f: A => B): List[B]
   */
  def map[A, B](list: List[A])(f: A => B) : List[B] = {
    @tailrec
    def loop(rem:List[A], value: List[B]) :List[B] = rem match {
      case Nil() => value
      case Cons(h, t) => loop(t, Cons(f(h), value))
    }

    reverse(loop(list, Nil()))
  }


  // apply your solution-function from (b) here, DO NOT change the signature
  def testMap[A, B](list: List[A], f: A => B): List[B] = map(list)(x => f(x))
  
  /* c) Write a function that appends one list to another:
   *        def append[A](l: List[A], r: List[A]): List[A]
   */
  def append[A](l: List[A], r: List[A]) :List[A] = {
    @tailrec
    def loop(rem :List[A], value:List[A]) :List[A] = rem match {
      case Nil() => value
      case Cons(h, t) => loop(t, Cons(h,value))
    }
    loop(reverse(l), r)
  }



  // apply your solution-function from (c) here, DO NOT change the signature
  def testAppend[A](l: List[A], r: List[A]): List[A] = l

  /* d) Write a function that applies a function to every value of a list:
   *        def flatMap[A, B](list: List[A])(f: A => List[B]): List[B]
   * 
   *    it gets a function which creates a new List[B] for every element of type A in 
   *    the list. Therefore, you generate a List[List[B]]. You have to flatten this 
   *    structure.
   */

  def flatMap[A, B](list: List[A])(f: A => List[B]): List[B] = {
    @tailrec
    def loop(rem: List[A], mid: List[B]) :List[B] = rem match {
      case Nil() => mid
      case Cons(h, t) => loop(t, append(f(h), mid))
    }
    reverse(loop(list, Nil()))
  }



  // apply your solution-function from (d) here, DO NOT change the signature
  def testFlatMap[A, B](list: List[A], f: A => List[B]): List[B] = Nil()

  /* e) Question: Is it possible to write a tail recursive map function for `Tree`s? If no, why and are you sure :) ? */
}
