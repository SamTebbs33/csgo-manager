package com.github.samtebbs33.csgo.data

import java.io.{File, FileInputStream}

import com.github.samtebbs33.csgo.player.PlayerRole
import com.github.samtebbs33.csgo.Utils._
import play.api.libs.json._

class Database(name: String, val countries: Set[Country], val firstNames: Map[Country, Set[String]], val surNames: Map[Country, Seq[String]], val playerRoles: Set[PlayerRole], val regions: Set[Region]) {

}

object Database {

  var databases: List[Database] = List[Database]()
  var countries = Set[Country]()
  var firstNames = Map[Country, Set[String]]()
  var surNames = Map[Country, Set[String]]()
  var playerRoles = Set[PlayerRole]()
  var regions = Set[Region]()

  def add(db: Database) = {
    databases = databases :+ db
    db.countries.foreach(c => countries = countries + c)
    firstNames = firstNames.flatMerge(db.firstNames, _.toSet)
    surNames = surNames.flatMerge(db.surNames, _.toSet)
    playerRoles = playerRoles.union(db.playerRoles)
    regions = regions.union(db.regions)
  }

  def init(): Unit = {
    val dbRoot = new File("src/main/res/databases")
    dbRoot.listFiles(_.isDirectory).foreach(dir => {
      val db = load(dir)
      //add(db)
    })
  }

  def load(root: File): Database = {

    val countriesSource = new FileInputStream(new File(root, "countries.json"))
    val countriesJson = Json.parse(countriesSource)
    val countriesJsonList = (countriesJson \ "countries").as[List[JsValue]]
    var countries = Set[Country]()
    countriesJsonList.foreach(json => {
      Json.fromJson[Country](json) match {
        case JsSuccess(country, _) => countries = countries + country
      }
    })
    null
  }

}
