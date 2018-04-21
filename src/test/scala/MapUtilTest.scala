import com.github.samtebbs33.csgo.Utils._

object MapUtilTest extends App {

  val map1 = Map(1 -> Set("1"), 3 -> Set("3"), 5 -> Set("5"))
  val map2 = Map(2 -> Set("2"), 3 -> Set("3b"), 4 -> Set("4"), 6 -> Set("6"))

  println(map1.flatMerge(map2, iter => iter.toSet))

}
