package com.github.samtebbs33.csgo.player

import java.util.Date

import com.github.samtebbs33.csgo.Country

class Player(nickname: String, firstName: String, surName: String, country: Country, dob: Date, attributes: PlayerAttributes) {

  val fullName = s"$firstName '$nickname' $surName"

}
