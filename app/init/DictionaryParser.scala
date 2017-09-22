package init

import scala.util.matching.Regex

object DictionaryParser {

  val Entry: Regex = "((?:(?!\\[).)*)\\[((?<=\\[).*(?=\\]))\\]((?<=\\]).*)".r
  val English: Regex = "((.*?)\\/)".r

  def decomposeLine(line:String) = {
    line match {
      case Entry(chinese, prononciation, english) =>
        DictionaryEntry(chinese.trim, prononciation.trim, decomposeEnglish(english.trim).toList)
      case _ => DictionaryEntry("", "", List())
    }
  }

  def decomposeEnglish(english:String) = {
    def unwrapSlashes(component:String) = {
      component.dropRight(1)
    }

    for(m <- English.findAllIn(english) if m != "/") yield unwrapSlashes(m)
  }

}
