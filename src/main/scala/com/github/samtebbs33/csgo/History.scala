package com.github.samtebbs33.csgo

class History[T<: Dated] {

  var history = List[T]()

  def add(t: T): Unit = {
    history = (history :+ t).sortWith((t1, t2) => t1.date.compareTo(t2.date) > 0)
  }

  def get(i: Int) = history(i)

  def latest(i: Int) = history.take(i)

}
