package com.github.samtebbs33.csgo.data

import com.github.samtebbs33.csgo.data.Country.CountryRating
import com.github.samtebbs33.csgo.data.Language.Language
import play.api.libs.json._

case class Country(name: String, code: String, nationality: String, languages: List[Language], rating: CountryRating) {

}

object Country {
  type CountryRating = Int

  implicit object CountryFormat extends Format[Country] {
    override def writes(o: Country): JsValue = ???

    override def reads(json: JsValue): JsResult[Country] = {
      json.ensur
      val name = (json \ "name").as[String]
      val code = (json \ "code").as[String]
      val nationality = (json \ "nationality").as[String]
      //val languages =
      val rating = (json \ "rating").as[CountryRating]
      JsSuccess(new Country(name, code, nationality, List(), rating))
    }
  }

}
