package ir.foobar.messenger

/**
  * Created by Amirio on 2/2/2018.
  */
trait ApiMessage{
  val key : Int
  var content : Array[Byte]
  def setContent(con : Array[Byte])
  def getContent() : Array[Byte]
}
