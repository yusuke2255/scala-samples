package domain.repository

import domain.entity.{Draft, DraftId}
import DraftRepository.DraftRepositoryError

import scala.concurrent.Future

trait DraftRepository {
  def findBy(id: DraftId): Future[Either[DraftRepositoryError, Draft]]
}

object DraftRepository {
  trait DraftRepositoryError
  case object NotFound extends DraftRepositoryError
}
