import chiseltest._
import org.scalatest._
import chisel3._
import chiseltest.experimental._
import chisel3.iotesters._

class TesterSimple(dut: And) extends PeekPokeTester(dut) {
  poke(dut.io.a, 0.U)
  poke(dut.io.b, 1.U)
  step(1)
  println("Result: 0")

  poke(dut.io.a, 3.U)
  poke(dut.io.b, 2.U)
  step(1)
  println("Result: 0")
}

class Tester(dut: And) extends PeekPokeTester(dut) {
  poke(dut.io.a, 0.U)
  poke(dut.io.b, 1.U)
  step(1)
  expect(dut.io.out, 0)

  poke(dut.io.a, 3.U)
  poke(dut.io.b, 2.U)
  step(1)
  expect(dut.io.out, 2)
}

object TesterSimple extends App {
  chisel3.iotesters.Driver(() => new And()) { c =>
    new TesterSimple(c)
  }
}

class SimpleSpec extends FlatSpec with Matchers {
  "Tester" should "pass" in {
    chisel3.iotesters.Driver(() => new And()) { c =>
      new Tester(c)
    } should be (true)
  }
}
