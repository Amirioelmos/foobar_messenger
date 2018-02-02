package ir.foobar.messenger

import scala.collection.mutable.ListBuffer

/**
  * Created by Amirio on 2/2/2018.
  */
class ApiTextMessage extends ApiMessage {
  override val key: Int = 1
  override var content: Array[Byte] = _

  var mention = new ListBuffer[Int]()

  def setMentions(id : Int) = {
    mention += id
  }

  def getMentions() : ListBuffer[Int] = {
    mention
  }
  def setContent(text : Array[Byte]) = {
    content = text
  }
  def getContent() : Array[Byte] = {
    content

  }
}
