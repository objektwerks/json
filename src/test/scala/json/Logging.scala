package json

import org.slf4j.LoggerFactory

trait Logging {
  val logger = LoggerFactory.getLogger(this.getClass)

  def log(name: Entity, json: String): Unit = {
    logger.info(s"name: $name")
    logger.info(s"json: $json")
  }
}