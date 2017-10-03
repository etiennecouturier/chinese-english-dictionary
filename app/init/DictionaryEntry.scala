package init

import javax.inject.Inject

import anorm._
import play.api.db._

import scala.language.postfixOps

case class DictionaryEntry (chinese:String, prononciation:String, english:List[String]) {

}

@javax.inject.Singleton
class DictionaryRepository @Inject()(dbapi: DBApi)(implicit ec: DatabaseExecutionContext) {

  private val db = dbapi.database("default")

  def search(searchCriteria : String): Unit = {

  }

  def insert(entry: DictionaryEntry) {

    db.withConnection { implicit connection =>
      SQL(
        """
          insert into dict(chinese, prononciation, english) values (
            {chinese}, {prononciation}, {english}
          )
        """
      ).on(
        'chinese -> entry.chinese,
        'prononciation -> entry.prononciation,
        'english -> entry.english.mkString(", ")
      ).executeInsert()
    }
  }

}