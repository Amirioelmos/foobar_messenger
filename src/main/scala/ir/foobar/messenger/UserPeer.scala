package ir.foobar.messenger

import scala.collection.mutable.ListBuffer

/**
  * Created by Amirio on 2/2/2018.
  */
class UserPeer(iid : Int, peeerType : Int) extends Peer[UserPeer] {


  override var id: Int = iid
  override var peerType: Int = peeerType
  var PeerList = new ListBuffer[Int]()


  var name : String = new String
  var phone : String = new String
  var nickName : String = new String




  override def createInstance()  = {
    PeerList += id
    val upeer : UserPeer = new UserPeer(id, peerType)
    upeer
  }
  override def fromBytes(id: Int) = {
    if (PeerList.contains(id)) {
      println("Peer with id" + id + "funded!")
    }
    else {
      println("Not Found  Peer with this id : " + id)
    }
  }

  override def getPeerType()  : Int = peerType
  override def getPeerID()  : Int = id

  override def getUpdate(ApiMessage: ApiMessage, sender_id : Int ) = {
    println("["+sender_id+"]"+"to" + "[" + iid + "] : => "+ new String(ApiMessage.getContent()))
  }


}
