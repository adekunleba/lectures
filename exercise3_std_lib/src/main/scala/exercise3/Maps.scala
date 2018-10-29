package exercise3

/** Write your solution into the test functions.
  * 
  * https://docs.scala-lang.org/overviews/collections/maps.html
  */
object Maps {

  case class User(name: String, age: Int)

  /* a) Given a Seq[User] group the users by name (`groupBy`) and calculate the average age: `name -> averageAge`
   *    You can implement your solution directly in the test-function. DO NOT change the signature.
   */
  def avg(sx: Seq[Int]) :Int = sx.sum / sx.length
  def testGroupUsers(users: Seq[User]): Map[String, Int] = users.groupBy(_.name).map{ kv =>
      (kv._1, avg(kv._2.map(_.age)))
    }

  /* b) Given a `Map[String, User]` from user name to `User`, how many Users with the substring "Baggins" are in the Map?
   *    You can implement your solution directly in the test-function. DO NOT change the signature.
   */
  def testNumberFrodos(map: Map[String, User]): Int = map.count(_._2.name.contains("Baggins"))


  /* c) Remove all users under age 1000 (Wizards only :).
   *    You can implement your solution directly in the test-function. DO NOT change the signature.
   */
  def testUnderaged(map: Map[String, User]): Map[String, User] = map.filter(_._2.age >= 1000)
}
