package exercise2

/** An Option indicates if an operation returned a result or not. This is often used when
  * searching for values or when operations can fail and you don't care about the 
  * reason.
  * 
  * The composition functions `map` and `flatMap` are context sensitive. If the Option
  * is a None they ignore any function application since no value is available. On the 
  * other hand, if it is a Some the functions are applied to transform the value.
  */
sealed trait Option[A] {

  def map[B](f: A => B): Option[B]
  def flatMap[B](f: A => Option[B]): Option[B]
}
case class Some[A](a: A) extends Option[A] {

  def map[B](f: A => B): Option[B] = Some(f(a))
  def flatMap[B](f: A => Option[B]): Option[B] = f(a)
}
case class None[A]()     extends Option[A] {

  def map[B](f: A => B): Option[B] = None()
  def flatMap[B](f: A => Option[B]): Option[B] = None()
}

/** Implement your solutions within the test functions. */
object Compositions {

  // a) Compose the given functions. You can implement your solution directly in the test-function.
  //    DO NOT change the signature

  def testCompose[A, B, C, D](f: A => B)
                             (g: B => C)
                             (h: C => D): A => D = f andThen g andThen h// h.compose(g.compose(f))

  // b) Combose the functions using `map` and `flatMap`. You can implement your solution directly in the test-function.
  //    DO NOT change the signature

  def testMapFlatMap[A, B, C, D](f: A => Option[B])(g: B => Option[C])(h: C => D): Option[A] => Option[D] =
    opt => {
      val result = opt.flatMap(f).flatMap(g).map(h)
      result
    }

  //Since function h maps C => D hence this is why we use map because map takes function mapping C => D
  //Consider that we change function h to C => Option[D] then we will be using flatmap
  def testMapFlatMapTwo[A, B, C, D](f: A => Option[B])(g: B => Option[C])(h: C => Option[D]): Option[A] => Option[D] =
    opt => {
      val result = opt.flatMap(f).flatMap(g).flatMap(h)
      result
    }
  // c) Compose the functions using for-comprehension. You can implement your solution directly in the test-function.
  //    DO NOT change the signature
//Using a for loop in Optional
  def testForComprehension[A, B, C, D](f: A => Option[B])(g: B => Option[C])(h: C => D): Option[A] => Option[D] =
    opt =>
      for {
        x <- opt
        y <- f(x)
        z <- g(y)
        a <- h(z)
      } yield a
}
