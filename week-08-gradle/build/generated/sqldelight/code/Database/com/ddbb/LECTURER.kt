package com.ddbb

import kotlin.Long
import kotlin.String

public data class LECTURER(
  public val id: Long,
  public val NAME: String,
  public val AGE: Long,
  public val STATUS: String?,
  public val GENDER: String?
) {
  public override fun toString(): String = """
  |LECTURER [
  |  id: $id
  |  NAME: $NAME
  |  AGE: $AGE
  |  STATUS: $STATUS
  |  GENDER: $GENDER
  |]
  """.trimMargin()
}
