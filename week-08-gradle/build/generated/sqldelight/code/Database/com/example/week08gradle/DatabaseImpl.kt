package com.example.week08gradle

import com.ddbb.LECTURER
import com.ddbb.LecturerQueries
import com.example.Database
import com.squareup.sqldelight.Query
import com.squareup.sqldelight.TransacterImpl
import com.squareup.sqldelight.`internal`.copyOnWriteList
import com.squareup.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.collections.MutableList
import kotlin.reflect.KClass

internal val KClass<Database>.schema: SqlDriver.Schema
  get() = DatabaseImpl.Schema

internal fun KClass<Database>.newInstance(driver: SqlDriver): Database = DatabaseImpl(driver)

private class DatabaseImpl(
  driver: SqlDriver
) : TransacterImpl(driver), Database {
  public override val lecturerQueries: LecturerQueriesImpl = LecturerQueriesImpl(this, driver)

  public object Schema : SqlDriver.Schema {
    public override val version: Int
      get() = 1

    public override fun create(driver: SqlDriver): Unit {
      driver.execute(null, """
          |CREATE TABLE LECTURER (
          | id INTEGER PRIMARY KEY AUTOINCREMENT,
          |NAME TEXT NOT NULL,
          |AGE INTEGER NOT NULL,
          |STATUS TEXT,
          |GENDER TEXT
          |)
          """.trimMargin(), 0)
    }

    public override fun migrate(
      driver: SqlDriver,
      oldVersion: Int,
      newVersion: Int
    ): Unit {
    }
  }
}

private class LecturerQueriesImpl(
  private val database: DatabaseImpl,
  private val driver: SqlDriver
) : TransacterImpl(driver), LecturerQueries {
  internal val allLecturers: MutableList<Query<*>> = copyOnWriteList()

  public override fun <T : Any> allLecturers(mapper: (
    id: Long,
    NAME: String,
    AGE: Long,
    STATUS: String?,
    GENDER: String?
  ) -> T): Query<T> = Query(-158801427, allLecturers, driver, "Lecturer.sq", "allLecturers", """
  |SELECT *
  |FROM LECTURER
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!,
      cursor.getString(3),
      cursor.getString(4)
    )
  }

  public override fun allLecturers(): Query<LECTURER> = allLecturers { id, NAME, AGE, STATUS,
      GENDER ->
    LECTURER(
      id,
      NAME,
      AGE,
      STATUS,
      GENDER
    )
  }
}
