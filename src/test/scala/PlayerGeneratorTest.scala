import com.github.samtebbs33.csgo.data.Database
import com.github.samtebbs33.csgo.gen.params.PlayerGeneratorParams
import com.github.samtebbs33.csgo.gen.player.PlayerGenerator

object PlayerGeneratorTest extends App {

  Database.init()

  val gen = new PlayerGenerator()

  for(_ <- 0.to(15)) println(gen.generate(new PlayerGeneratorParams))

}
