package com.github.samtebbs33.csgo.gen

import scala.util.Random

import com.github.samtebbs33.csgo.gen.params.GeneratorParams

class WeightedRandomGenerator[T, P <: GeneratorParams] extends Generator[T, P] {

  var dataSet: List[(T, Int)] = List()

  def search(dataSet: List[(T, Int)], rand: Int): (T, Int) = dataSet match {
    case item :: tail => {
      val newRand = rand - item._2
      if(newRand > 0) search(tail, newRand)
      else item
    }
  }

  def weightedSelection(): (T, Int) = {
    val weightSum = dataSet.map(_._2).sum
    val rand = Random.nextInt(weightSum + 1)
    search(dataSet, rand)
  }

  override def generate(params: P): T = {
    weightedSelection()._1
  }

  def generate(params: P, dataSet: List[(T, Int)]): T = {
    this.dataSet = dataSet
    generate(params)
  }

}
