package com.github.samtebbs33.csgo.player

import java.text.SimpleDateFormat
import java.util.Date

import com.github.samtebbs33.csgo.data.Country

class Player(nickname: String, firstName: String, surName: String, country: Country, dob: Date, attributes: PlayerAttributes) {

  val fullName = s"$firstName '$nickname' $surName"
  var dateFormat = new SimpleDateFormat("dd/mm/yy")

  override def toString: String = {
    s"$fullName <${country.name}> (${dateFormat.format(dob)})"
  }

}
