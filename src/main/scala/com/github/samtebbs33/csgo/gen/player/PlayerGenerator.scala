package com.github.samtebbs33.csgo.gen.player

import java.util.Date

import com.github.samtebbs33.csgo.data.{Country, Database}
import com.github.samtebbs33.csgo.gen.params.{GeneratorParams, NameGeneratorParams, PlayerGeneratorParams}
import com.github.samtebbs33.csgo.gen.{Generator, WeightedRandomGenerator}
import com.github.samtebbs33.csgo.player.{Player, PlayerAttributes}

class PlayerGenerator extends Generator[Player, PlayerGeneratorParams] {

  var nicknameGenParams = new NameGeneratorParams(3, 10)
  var nicknameGen = new NameGenerator("src/main/res/player_names.txt")
  var countryGen = new WeightedRandomGenerator[Country, GeneratorParams]()


  override def generate(params: PlayerGeneratorParams): Player = {
    val nickname = nicknameGen.generate(nicknameGenParams)
    val country = countryGen.generate(null, Database.countries.toList.map(c => (c, c.rating)))
    val nameGen = new RandomGenerator[String, GeneratorParams]()
    val firstName = nameGen.generate(null, Database.firstNames(country).toList)
    val surName = nameGen.generate(null, Database.surNames(country).toList)
    new Player(nickname, firstName, surName, country, new Date(), new PlayerAttributes)
  }

}
