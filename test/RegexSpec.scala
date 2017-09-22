import init.DictionaryParser
import org.junit.runner._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.junit.JUnitRunner
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.test.WithApplication

@RunWith(classOf[JUnitRunner])
class RegexSpec extends PlaySpec with GuiceOneAppPerSuite with ScalaFutures {

  "RegexMatcher" should {
    "decompose line into chinese, prononciation and english" in new WithApplication{
      val entry = DictionaryParser.decomposeLine("一溜煙 一溜烟 [yi1 liu4 yan1] /like a wisp of smoke/(to disappear etc) in an instant/")
      entry.chinese must equal("一溜煙 一溜烟")
      entry.prononciation must equal("yi1 liu4 yan1")
      entry.english must equal(List("like a wisp of smoke", "(to disappear etc) in an instant"))
    }

    "decompose english into its parts" in new WithApplication{
      val english = DictionaryParser.decomposeEnglish("/like a wisp of smoke/(to disappear etc) in an instant/").toList
      english must equal(List("like a wisp of smoke", "(to disappear etc) in an instant"))
    }

  }

}
