import com.ddbb.LECTURER
import com.example.Database
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.asJdbcDriver
import com.zaxxer.hikari.HikariDataSource
class DDBB {
    companion object {
        private fun getSqlDriver(path: String = "src/main/resources/lecturer.sqlite"): SqlDriver {
            val ds = HikariDataSource()
            ds.jdbcUrl = "jdbc:sqlite:" + path
            ds.driverClassName = "org.sqlite.JDBC"
            ds.username = ""
            ds.password = ""
            return ds.asJdbcDriver()
        }
        fun lectures_from_dbb(path: String = "src/main/resources/lecturer.sqlite"): List<LECTURER> {
            val database = Database(getSqlDriver(path))
            val lecturerQueries = database.lecturerQueries
            return lecturerQueries.allLecturers().executeAsList()
        }
    }
}
// this is for testing.
fun main() {
    val lectures = DDBB.lectures_from_dbb()
    for (lecture in lectures) {
        println(lecture)
    }
    println(lectures)
}