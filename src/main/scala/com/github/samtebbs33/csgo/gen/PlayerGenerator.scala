package com.github.samtebbs33.csgo.gen

import com.github.samtebbs33.csgo.player.Player

class PlayerGenerator extends Generator[Player, PlayerGeneratorParams] {

  override def generate(params: PlayerGeneratorParams): Player = {
    val nameGen = new NameGenerator("src/main/res/player_names.txt")
  }

}
