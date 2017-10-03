package init

import javax.inject.Inject

class DictionaryDataSaver @Inject()(dictionaryRepository: DictionaryRepository) {

  def saveDictionaryData (filePath:String) = {
    for (
      entry <- DictionaryFileProcessor.getDictionaryEntries(filePath)
      if !entry.chinese.isEmpty
    ) {
      dictionaryRepository.insert(entry) /*onComplete {
        case Success(result) => println("success")
        case Failure(e) => println("failure")
      }*/

    }
  }

}
