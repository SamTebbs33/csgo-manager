package com.github.samtebbs33.csgo.gen

import com.github.samtebbs33.csgo.gen.params.GeneratorParams

abstract class Generator[T, P <: GeneratorParams] {

  def generate(params: P): T

}
