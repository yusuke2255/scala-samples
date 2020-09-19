package entity

case class CorporationId(value: String)
case class Corporation(id: Corporation, name: String)
case class DraftId(value: String)
case class Draft(id: DraftId, corporation: Corporation)
