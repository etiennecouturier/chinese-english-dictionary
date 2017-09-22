import init.{DictionaryEntry, DictionaryFileProcessor}
import org.junit.runner._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.junit.JUnitRunner
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.test.WithApplication

@RunWith(classOf[JUnitRunner])
class DictionaryFileProcessorSpec extends PlaySpec with GuiceOneAppPerSuite with ScalaFutures {

  "DatabaseLoader" should {

    "return ready made dictionary entries" in new WithApplication{
      val entries: List[DictionaryEntry] = DictionaryFileProcessor.getDictionaryEntries("C:\\Users\\istvan.szabo\\Downloads\\cedict_1_0_ts_utf-8_mdbg\\test_entries.txt")
      val firstEntry = DictionaryEntry("手臂 手臂", "shou3 bi4", List("arm", "helper"))
      val secondEntry = DictionaryEntry("手舉 手举", "shou3 ju3", List("a salute", "hands raised"))
      entries must equal(List(firstEntry, secondEntry))
    }

  }

}
