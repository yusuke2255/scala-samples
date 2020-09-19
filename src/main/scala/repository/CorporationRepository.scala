package repository

import entity.{Corporation, CorporationId}
import repository.CorporationRepository.CorporationRepositoryError

import scala.concurrent.Future

trait CorporationRepository {
  def findBy(id: CorporationId): Future[Either[CorporationRepositoryError, Corporation]]
}

object CorporationRepository {
  trait CorporationRepositoryError
  case object NotFound extends CorporationRepositoryError
}
