import init.{DictionaryEntry, DictionaryFileProcessor}
import org.junit.runner._

@RunWith(classOf[JUnitRunner])
class DictionaryFileProcessorSpec extends Specification {

  "DatabaseLoader" should {

    "return ready made dictionary entries" in new WithApplication{
      val entries: List[DictionaryEntry] = DictionaryFileProcessor.getDictionaryEntries("C:\\Users\\istvan.szabo\\Downloads\\cedict_1_0_ts_utf-8_mdbg\\test_entries.txt")
      val firstEntry = DictionaryEntry("手臂 手臂", "shou3 bi4", List("arm", "helper"))
      val secondEntry = DictionaryEntry("手舉 手举", "shou3 ju3", List("a salute", "hands raised"))
      entries must equalTo(List(firstEntry, secondEntry))
    }

  }

}
