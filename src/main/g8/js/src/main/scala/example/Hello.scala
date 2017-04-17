package example

import scala.scalajs.js

object Hello extends Greeting with js.JSApp {
  def main(): Unit = {
    println(greeting)
  }
}
