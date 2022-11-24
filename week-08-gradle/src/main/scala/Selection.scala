// Imperative style.

import com.ddbb.LECTURER

import scala.jdk.CollectionConverters._

object Selection {
  def sort(array2: java.util.List[LECTURER]) = {
    var ticks = 0
    val array = array2.asScala
    for (i <- 0 until array.length - 1) {
      var min_idx = i
      for (j <- i + 1 until array.length) {
        ticks += 1
        if (array(j).getAGE < array(min_idx).getAGE) min_idx = j
      }
      if (min_idx != i) {
        val tmp = array(min_idx)
        array(min_idx) = array(i)
        array(i) = tmp
      }
    }
    ticks
  }
}
