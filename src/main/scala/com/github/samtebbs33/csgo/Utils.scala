package com.github.samtebbs33.csgo

import scala.collection.immutable.Map.Map2

object Utils {

  implicit class MapUtils[A, B](val map: Map[A, B]) {

    def merge(map2: Map[A, B]): Map[A, List[B]] = {
      val merged = map.toSeq ++ map2.toSeq
      val grouped = merged.groupBy(_._1)
      grouped.mapValues(_.map(_._2).toList)
    }

    def update(key: A, updater: Option[B] => B): Map[A, B] = map.updated(key, updater(map.get(key)))

    def updateWithDefault(key: A, default: B, updater: B => B) = update(key, {
      case Some(value) => updater(value)
      case None => default
    })

  }

  implicit class IterableMapUtils[A, B](val map: Map[A, Iterable[B]]) {

    def flatMerge(map2: Map[A, _ <: Iterable[B]]): Map[A, Iterable[B]] = {
      map.merge(map2).transform((_, vals) => vals.flatten)
    }

    def flatMerge[C](map2: Map[A, _ <: Iterable[B]], convert: Iterable[B] => C): Map[A, C] = {
      flatMerge(map2).transform((_, iter) => convert(iter))
    }

  }

}
