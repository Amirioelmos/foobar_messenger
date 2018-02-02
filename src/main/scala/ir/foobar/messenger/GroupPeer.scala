package ir.foobar.messenger

import scala.collection.mutable.ListBuffer

/**
  * Created by Amirio on 2/2/2018.
  */
class GroupPeer(iid: Int, peeerType : Int) extends Peer[GroupPeer] {

  override var id : Int = iid
  override var peerType: Int = peeerType
  var PeerList = new ListBuffer[Int]()

  var name : String = _
  var avatar : Int = _
  var memberts : List[Peer[UserPeer]] = List.empty
  var admins : List[Peer[UserPeer]] = List.empty
  override def createInstance() : GroupPeer= {
    PeerList += id
    val gp = new GroupPeer(id,peerType)
    gp
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
    println("message received from [" + sender_id + "] to Group ["+ id + "]")
//    for (i <- memberts) {
      println("[" + sender_id + "]" + "to" + "Group [" + iid + "] : => " + new String(ApiMessage.getContent()))
//    }
  }


}
