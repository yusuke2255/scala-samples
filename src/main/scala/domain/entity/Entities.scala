package domain.entity

case class CorporationId(value: String)
case class Corporation(id: CorporationId, name: String)
object Corporation {
  case object One extends Corporation(CorporationId("corporation_id_1"), s"corporation_name_1")
}
case class DraftId(value: String)
case class Draft(id: DraftId, corporation: Corporation, name: String)
