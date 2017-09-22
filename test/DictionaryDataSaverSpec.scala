import init._
import org.junit.runner._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.junit.JUnitRunner
import play.test.WithApplication

import org.scalatest.concurrent.ScalaFutures
import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneAppPerSuite

@RunWith(classOf[JUnitRunner])
class DictionaryDataSaverSpec extends PlaySpec with GuiceOneAppPerSuite with ScalaFutures {

  val testFilePath = "C:\\Users\\istvan.szabo\\Downloads\\cedict_1_0_ts_utf-8_mdbg\\test_insert.txt"
  val filePath = "C:\\Users\\istvan.szabo\\Downloads\\cedict_1_0_ts_utf-8_mdbg\\cedict_ts.u8"

  def dictionaryDataSaver: DictionaryDataSaver = app.injector.instanceOf(classOf[DictionaryDataSaver])

  "DictionaryDataSaver" should {

    "save dictionary entries into the persistence layer" in new WithApplication{
      dictionaryDataSaver.saveDictionaryData(filePath)
    }

  }

}
