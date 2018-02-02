package ir.foobar.messenger

/**
  * Created by Amirio on 2/2/2018.
  */
class GroupOperation(id : Int, peerType : Int) extends GroupPeer(id, peerType){

  def setName(pname : String) = {
    name = pname
  }
  def getName() : String = {
    name
  }
  def addMember(peer : Peer[UserPeer]) = {
    memberts ::= peer
    println("Peer by name [" + peer.id + "] added to group by [" + id + "]")
  }
  def addAdmin(peer : Peer[UserPeer]) = {
    admins ::= peer
    println("Peer by name [" + peer.id + "] added to admin's for group by [" + id + "]")
  }
  def getMembers(id : Int) : List[Peer[UserPeer]] = {
    memberts
  }
  def getAdmins(id : Int) : List[Peer[UserPeer]] = {
    admins
  }
  def removeMember(peer : Peer[UserPeer]) = {
      memberts.filterNot(p => p == peer)
      admins.filterNot(p => p == peer)
    println("Peer by name [" + peer.id + "] removed from group by [" + id + "]")
  }
  def removeAdmin(peer : Peer[UserPeer]) = {
    admins.filterNot(p => p == peer)
    println("Peer by name [" + peer.id + "] removed from admin's group by [" + id + "]")
  }


}
