package ir.foobar.messenger

/**
  * Created by Amirio on 2/2/2018.
  */

object start extends App {
  val peer1 = new UserPeer(1,2)
  val peer2 = new UserPeer(2,2)
  val nn = peer1.createInstance()
  println("get peer id : " + nn.getPeerID())
  println("get peer type :  " +nn.getPeerType())



  val push = new PushMessage
  val pm1  : ApiMessage = new ApiTextMessage
  pm1.setContent("salam".getBytes)
  push.getPushMessage(peer1,peer2,pm1)
  push.getPushMessage(peer1,peer2,pm1)
  push.getPushMessage(peer2,peer1,pm1)
  push.getPushMessage(peer2,peer1,pm1)


  var up1 = new UserOperation(nn.getPeerID(),nn.getPeerType())
  up1.setContact(peer2 :: peer2 :: Nil)
  println("gettint conctact" + up1.getContact())
  up1.setName("Amirio")




  var gp = new GroupPeer(3,4)
  var gpp = gp.createInstance()

  push.getPushMessage(peer1,gpp,pm1)

  var go = new GroupOperation(3,4)
  go.addMember(peer1)
  go.addMember(peer2)
  go.addAdmin(peer1)
  go.removeMember(peer1)






}


import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer




import scala.io.StdIn


object WebServer extends  App{
  override def main(args: Array[String]) {

    implicit val system = ActorSystem("my-system")
    implicit val materializer = ActorMaterializer()
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.dispatcher

    val route =
      path("hello") {
        get {
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))
        }
      }

    val bindingFuture = Http().bindAndHandle(route, "172.18.225.230", 4567)

    println(s"Server online at http://localhost:4567/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
  }
}