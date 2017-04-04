object collection_t1 {

  def main(args: Array[String]): Unit = {
    val li = List(1, 2, 3)
    val res = li.map(x => x match {
      case 3 => List('a', 'b')
      case _ => x * 2
    })
    println(res)
    
  }
}