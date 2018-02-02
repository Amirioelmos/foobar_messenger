package ir.foobar.messenger

/**
  * Created by Amirio on 2/2/2018.
  */
class PushMessage {
  var message : String = new String
  var concouredMsg : String = new String
  def getPushMessage(fromPeer : Peer[UserPeer] ,toPeer : Peer[_], apiMessage: ApiMessage) = {
  toPeer.getUpdate(apiMessage,fromPeer.id)
  }

}
