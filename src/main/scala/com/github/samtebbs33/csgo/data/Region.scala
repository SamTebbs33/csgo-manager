package com.github.samtebbs33.csgo.data

import com.github.samtebbs33.csgo.data.Region.RegionRating

class Region(name: String, code: String, nationality: String, countries: List[Country], subRegions: List[Region], val rating: RegionRating) {

  def hasCountries(c: List[Country]): Boolean = countries.containsSlice(c) || subRegions.exists(_.hasCountries(c))

  override def toString: String = name

}

object Region {

  var regions: List[Region] = List()
  type RegionRating = Int

  def addRegion(region: Region) = regions = regions :+ region

}
