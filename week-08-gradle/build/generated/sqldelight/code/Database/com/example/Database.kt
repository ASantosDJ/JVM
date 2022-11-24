package com.example

import com.ddbb.LecturerQueries
import com.example.week08gradle.newInstance
import com.example.week08gradle.schema
import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver

public interface Database : Transacter {
  public val lecturerQueries: LecturerQueries

  public companion object {
    public val Schema: SqlDriver.Schema
      get() = Database::class.schema

    public operator fun invoke(driver: SqlDriver): Database = Database::class.newInstance(driver)
  }
}
