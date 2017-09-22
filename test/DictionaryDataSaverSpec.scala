import init._
import org.junit.runner._

@RunWith(classOf[JUnitRunner])
class DictionaryDataSaverSpec extends Specification {

  val testFilePath = "C:\\Users\\istvan.szabo\\Downloads\\cedict_1_0_ts_utf-8_mdbg\\test_insert.txt"
  val filePath = "C:\\Users\\istvan.szabo\\Downloads\\cedict_1_0_ts_utf-8_mdbg\\cedict_ts.u8"

  "DictionaryDataSaver" should {

    "save dictionary entries into the persistence layer" in new WithApplication{
      DictionaryDataSaver.saveDictionaryData(filePath)
    }

  }

}
