package com.github.samtebbs33.csgo.gen.player

import com.github.samtebbs33.csgo.gen.Generator
import com.github.samtebbs33.csgo.gen.params.NameGeneratorParams
import org.conbere.markov.MarkovChain

import scala.io.Source

class NameGenerator(val sourceFile: String) extends Generator[String, NameGeneratorParams] {

  val stop = '\2'
  val start = '\3'
  val markovChain: MarkovChain[Char] = Source.fromFile(sourceFile).getLines()
    .foldLeft(new MarkovChain[Char](start, stop))((chain, name) => chain.insert(name.toLowerCase().toList))

  override def generate(params: NameGeneratorParams): String = {
      var s = markovChain.generate(params.maxLen)
      while(s.lengthCompare(params.minLen) < 0) s = markovChain.generate(params.maxLen)
      s.mkString
  }
}
