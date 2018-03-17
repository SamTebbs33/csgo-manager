package com.github.samtebbs33.csgo.gen

abstract class Generator[T, P <: GeneratorParams] {

  def generate(params: P): T

}
