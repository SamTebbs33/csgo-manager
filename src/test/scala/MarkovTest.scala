import com.github.samtebbs33.csgo.gen.params.NameGeneratorParams
import com.github.samtebbs33.csgo.gen.player.NameGenerator
import org.conbere.markov.MarkovChain

import scala.io.Source

object MarkovTest extends App {

  val teamNameGenerator = new NameGenerator("src/main/res/team_names.txt")
  val playerNameGenerator = new NameGenerator("src/main/res/player_names.txt")

  println(playerNameGenerator.generate(new NameGeneratorParams(3, 7)))
  println(teamNameGenerator.generate(new NameGeneratorParams(4, 10)))

}
