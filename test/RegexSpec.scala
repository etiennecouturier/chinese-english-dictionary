import init.DictionaryParser
import org.junit.runner._

@RunWith(classOf[JUnitRunner])
class RegexSpec extends Specification {

  "RegexMatcher" should {
    "decompose line into chinese, prononciation and english" in new WithApplication{
      val entry = DictionaryParser.decomposeLine("一溜煙 一溜烟 [yi1 liu4 yan1] /like a wisp of smoke/(to disappear etc) in an instant/")
      entry.chinese must equalTo("一溜煙 一溜烟")
      entry.prononciation must equalTo("yi1 liu4 yan1")
      entry.english must equalTo(List("like a wisp of smoke", "(to disappear etc) in an instant"))
    }

    "decompose english into its parts" in new WithApplication{
      val english = DictionaryParser.decomposeEnglish("/like a wisp of smoke/(to disappear etc) in an instant/").toList
      english must equalTo(List("like a wisp of smoke", "(to disappear etc) in an instant"))
    }

  }

}
