package com.github.samtebbs33.csgo

class Region(name: String, code: String, nationality: String, countries: List[Country], subRegions: List[Region]) {

  def hasCountries(c: List[Country]): Boolean = countries.containsSlice(c) || subRegions.exists(_.hasCountries(c))

}

object Region {

  var regions: List[Region] = List()

  def addRegion(region: Region) = regions = regions :+ region

}
