import cats.data.EitherT

import scala.concurrent.Future

object EitherTSample extends App {

}

class DraftRepository {
  def()
}

class UserRepository {
  def execute(): Future[Either[UserRepositoryError, String]] = {

  }
}


