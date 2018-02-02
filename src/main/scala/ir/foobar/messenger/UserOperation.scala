package ir.foobar.messenger

/**
  * Created by Amirio on 2/2/2018.
  */
class UserOperation(id : Int, peerType: Int) extends UserPeer(id, peerType){

  def setName(pname : String) = {
    name = pname
  }
  def getName() : String = {
    name
  }

  var contact : List[Peer[UserPeer]] = _
  def setContact(peers : List[Peer[UserPeer]]) = {
    contact = peers
    println("here is my Conctact : " +contact)
  }

  def getContact() : List[Peer[UserPeer]] = contact
}
