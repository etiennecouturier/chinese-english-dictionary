

class DictionaryQuerySpec {



  def withMyDatabase[T](block: Database => T) = {
    Databases.withDatabase(
      driver = "com.mysql.jdbc.Driver",
      url = "jdbc:mysql://localhost/test",
      name = "mydatabase",
      config = Map(
        "user" -> "test",
        "password" -> "secret"
      )
    )(block)
  }

}
