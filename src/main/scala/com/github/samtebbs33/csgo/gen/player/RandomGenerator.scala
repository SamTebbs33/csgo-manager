package com.github.samtebbs33.csgo.gen.player

import com.github.samtebbs33.csgo.gen.Generator
import com.github.samtebbs33.csgo.gen.params.GeneratorParams

import scala.util.Random

class RandomGenerator[T, P <: GeneratorParams] extends Generator[T, P] {

  var items = List[T]()

  override def generate(params: P): T = items(Random.nextInt(items.size + 1))

  def generate(params: P, items: List[T]): T ={
    this.items = items
    generate(params)
  }

}
