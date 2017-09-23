package init

import javax.inject.Inject

import anorm._
import play.api.db._

import scala.language.postfixOps

import scala.concurrent.Future

case class DictionaryEntry (chinese:String, prononciation:String, english:List[String]) {

}

@javax.inject.Singleton
class DictionaryRepository @Inject()(dbapi: DBApi)(implicit ec: DatabaseExecutionContext) {

  private val db = dbapi.database("default")

  def insert(entry: DictionaryEntry) = Future {

    val insertChineseQuery = SQL("""
                                    insert into DICT values (
                                    (nextval('dict_seq')),
                                      {chinese}, {prononciation}, {english}
                                    )
                                  """)

    db.withConnection { implicit connection =>
      insertChineseQuery.on(
        'chinese -> entry.chinese,
        'prononciation -> entry.prononciation,
        'english -> entry.english.mkString(", ")
      ).executeInsert()
    }
  }(ec)

}