package com.github.samtebbs33.csgo.gen.player

import com.github.samtebbs33.csgo.data.Region
import com.github.samtebbs33.csgo.gen.WeightedRandomGenerator
import com.github.samtebbs33.csgo.gen.params.GeneratorParams

class RegionGenerator(regions: List[Region]) extends WeightedRandomGenerator[Region, GeneratorParams] {

  override def generate(params: GeneratorParams): Region = super.generate(params, regions.map(r => (r, r.rating)))

}
