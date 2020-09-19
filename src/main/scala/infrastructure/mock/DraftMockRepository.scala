package infrastructure.mock

import cats.data.EitherT
import domain.entity.{Corporation, CorporationId, Draft, DraftId}
import domain.repository._
import domain.repository.DraftRepository.{DraftRepositoryError, _}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class DraftMockRepository extends DraftRepository {
  override def findBy(id: DraftId): Future[Either[DraftRepositoryError, Draft]] = {
    retrieve(id).map { d: Option[Draft] =>
      val result: Either[DraftRepositoryError, Draft] = d match {
        case Some(value) => Right(value)
        case None => Left(DraftRepository.NotFound)
      }
      result
    }
  }

  private def retrieve(id: DraftId): Future[Option[Draft]] = Future {
    if (id.value == "not_found_id") {
      None
    } else {
      Some(Draft(id, Corporation.One, s"draft_name_${id.value}"))
    }
  }
}
