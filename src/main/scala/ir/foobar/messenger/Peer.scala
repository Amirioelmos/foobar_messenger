package ir.foobar.messenger

/**
  * Created by Amirio on 2/2/2018.
  */
trait Peer[A] {
  var id : Int
  var peerType : Int

  def createInstance() : A
  def fromBytes(id : Int)
  def getPeerType() : Int
  def getPeerID() : Int
  def getUpdate(ApiMessage : ApiMessage, sender_id : Int)
}
