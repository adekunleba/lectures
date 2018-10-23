package exercise1

/** Write your solution as stand-alone function. 
  * 
  * Syntax:
  *   val a: Int = ???
  * 
  *   a match {
  *     case 0 => true
  *     case _ => false
  *   }
  */
object PatternMatching {

  sealed trait Hand
  case object Rock    extends Hand
  case object Paper   extends Hand
  case object Scissor extends Hand

  sealed trait Result
  case object Win  extends Result
  case object Lose extends Result
  case object Draw extends Result

  sealed trait Food
  case object Meat       extends Food
  case object Vegetables extends Food
  case object Plants     extends Food

  sealed trait Animal {

    val name: String
    val food: Food
  }
  case class Mammal(name: String, food: Food, weight: Int) extends Animal
  case class Fish(name: String, food: Food)                extends Animal
  case class Bird(name: String, food: Food)                extends Animal



  /* a) If value is:
   *     1 => "it is one"
   *     2 => "it is two"
   *     3 => "it is three"
   *     otherwise => "what's that"
   */
  def getStringCase(value: Int) :String = value match {
    case 1 => "it is one"
    case 2 => "it is two"
    case 3 => "it is three"
    case _ => "What is that"
  }



  // apply your solution-function from (a) here, DO NOT change the signature
  def testIntToString(value: Int): String = getStringCase(value)

  /* b) `value` is true if it is:
   *     "max" or "Max
   *     "moritz" or "Moritz"
   */

  def checkMax(value: String) :Boolean =
    value.toLowerCase match {
      case "max" => true
      case "moritz" => false
    }



  // apply your solution-function from (b) here, DO NOT change the signature
  def testIsMaxAndMoritz(value: String): Boolean = checkMax(value)

  // c) Is `value` even (use guards)

  def isEven(value: Int) :Boolean =
    value % 2 match {
      case 0 => true
      case _ => false
    }

  //Actual IsEven Solution
  def isEvenOrNot(value: Int):Boolean = value match {
    case _ if value % 2 == 0 => true
    case _ => false
  }



  // apply your solution-function from (c) here, DO NOT change the signature
  def testIsEven(value: Int): Boolean = isEven(value)


  
  /* d) Rock paper scissors (see classes below):
   *     1. rock beats scissor
   *     2. scissor beats paper
   *     3. paper beats rock
   *    Does player `a` win?
   */
  def whoWins(a: Hand, b: Hand) :Result = (a, b)  match {
    case (Rock, Scissor) => Win
    case (Scissor, Paper) => Win
    case (Paper, Rock) => Win
    case (ha, hb) if ha == hb => Draw
    case _ => Lose
  }



  // apply your solution-function from (d) here, DO NOT change the signature
  def testWinsA(a: Hand, b: Hand): Result = whoWins(a, b)

  // REMARK: Use the definition of Animals below

  // e) Extract the weight of a Mammal else return -1.
  def extractWeights(animal: Animal) : Int = animal match  {
    case x: Mammal => x.weight
    case _ => -1
  }

  //This approach seems awesome though
  //Other Approach
  def extractMammalWeights(animal: Animal) :Int = animal match {
    case Mammal(_, _, weight) => weight
    case _ => -1
  }

  // apply your solution-function from (e) here, DO NOT change the signature
  def testExtractMammalWeight(animal: Animal): Int = extractWeights(animal)

  // f) Update the food of Fishes and Birds to Plants, keep Mammels unchanged.
  def updateFood(animal: Animal) :Animal = animal match {
    case Fish(name, _) => Fish(name, Plants)
    case Bird(name, _) => Bird(name, Plants)
    case _ => animal
  }



  // apply your solution-function from (f) here, DO NOT change the signature
  def testUpdateFood(animal: Animal): Animal = updateFood(animal)

}
