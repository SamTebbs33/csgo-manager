package com.github.samtebbs33.csgo.player

class PlayerAttribute(val name: String) {

  PlayerAttribute.add(this)

}

object PlayerAttribute {

  var attributes: List[PlayerAttribute] = List()

  val AGGRESSION: PlayerAttribute = new PlayerAttribute("Aggression")
  val POSITIONING: PlayerAttribute = new PlayerAttribute("Positioning")
  val REACTIONS: PlayerAttribute = new PlayerAttribute("Reactions")
  val TACTICS: PlayerAttribute = new PlayerAttribute("Tactics")
  val PATIENCE: PlayerAttribute = new PlayerAttribute("Patience")
  val AIM: PlayerAttribute = new PlayerAttribute("Aim")
  val TEAMPLAY: PlayerAttribute = new PlayerAttribute("Teamplay")

  def add(attribute: PlayerAttribute) = attributes = attributes :+ attribute

}
