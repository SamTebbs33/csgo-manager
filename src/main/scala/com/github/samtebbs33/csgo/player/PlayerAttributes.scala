package com.github.samtebbs33.csgo.player

class PlayerAttributes {

  type PlayerAttributeVal = Double

  var values: Map[PlayerAttribute, PlayerAttributeVal] = Map()

  def set(attribute: PlayerAttribute, value: PlayerAttributeVal) = values = values.updated(attribute, value)
  def add(attribute: PlayerAttribute, value: PlayerAttributeVal) = set(attribute, get(attribute) + value)
  def get(attribute: PlayerAttribute) = values(attribute)

}
