import com.github.samtebbs33.csgo.gen.WeightedRandomGenerator
import com.github.samtebbs33.csgo.gen.params.GeneratorParams

import com.github.samtebbs33.csgo.Utils._

object WeightedRandomTest extends App {

  val gen = new WeightedRandomGenerator[String, GeneratorParams]()

  var resultMap = Map[String, Int]()

  for(i <- 0 to 1000) {
    val res = gen.generate(null, List("a" -> 1, "c" -> 2, "b" -> 3, "d" -> 5, "e" -> 10))
    resultMap = resultMap.updateWithDefault(res, 1, _ + 1)
  }

  println(resultMap)

}
