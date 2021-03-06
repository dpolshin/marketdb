package com.ergodicity.marketdb.loader

import org.scalatest.{WordSpec, Spec}
import org.joda.time.DateTime
import org.scala_tools.time.Implicits._
import org.slf4j.LoggerFactory
import com.ergodicity.marketdb.loader.util.Implicits._

class DateTest extends WordSpec {
  val log = LoggerFactory.getLogger(classOf[DateTest])

  "Joda Time" must {
    "split valid interval to days" in {

      val now = new DateTime
      val previousWeek = now - 7.days

      log.info("Now: " + now)
      log.info("PrevWeek: " + previousWeek)

      val interval = (previousWeek to now)
      log.info("Interval: " + interval)

      val days = interval.toDays
      log.info("Start to end: " + days)

      assert(days.size == 8)

      val oneDay = (now to now).toDays
      log.info("One day: " + oneDay)
      assert(oneDay.size == 1)
    }
  }
}