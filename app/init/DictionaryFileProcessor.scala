package init

import scala.io.Source

object DictionaryFileProcessor {

  def getDictionaryEntries(filePath:String): List[DictionaryEntry] = {
    val entries = for (line <- Source.fromFile(filePath).getLines)
      yield DictionaryParser.decomposeLine(line)
    entries.toList
  }

}
