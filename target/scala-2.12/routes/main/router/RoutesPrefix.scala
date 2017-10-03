
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/istvan.szabo/dictionary/chinese-english-dictionary/conf/routes
// @DATE:Mon Oct 02 16:04:04 CEST 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
