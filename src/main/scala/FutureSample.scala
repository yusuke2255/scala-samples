import scala.concurrent.{Await, Future}
import scala.util.{Failure, Random, Success}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps

object FutureSample extends App {
  val userRepository = new UserRepository
  val corporationRepository = new CorporationRepository

  val fUser= userRepository.exec(10)
  val fCorporation = corporationRepository.exec(5)
  Await.ready(fUser, 11 seconds)
  Await.ready(fCorporation, 6 seconds)

  val f = for {
    u <- fUser
    c <- fCorporation
  } yield (u, c)

  Await.ready(f, 11 seconds)
  val result = f.value.get match {
    case Success(value) => value
    case Failure(exception) => throw exception
  }

  println(result._1)
  println(result._2)
}

class UserRepository {
  def exec(wait: Int): Future[String] = Future {
    println(s"[Waiting] $wait sec in user repository")
    Thread.sleep(wait * 1000)
    println(s"[Complete] user repository $wait sec")
    "user"
  }
}

class CorporationRepository {
  def exec(wait: Int): Future[String] = Future {
    println(s"[Waiting] $wait sec in corporation repository")
    Thread.sleep(wait * 1000)
    println(s"[Complete] corporation repository $wait sec")
    "corporation"
  }
}
