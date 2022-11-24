package com.ddbb

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlin.Any
import kotlin.Long
import kotlin.String

public interface LecturerQueries : Transacter {
  public fun <T : Any> allLecturers(mapper: (
    id: Long,
    NAME: String,
    AGE: Long,
    STATUS: String?,
    GENDER: String?
  ) -> T): Query<T>

  public fun allLecturers(): Query<LECTURER>
}
