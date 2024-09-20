import chisel3._

class And extends Module {
  val io = IO(new Bundle {
    val out = Output(UInt(2.W))
    val a = Input(UInt(2.W))
    val b = Input(UInt(2.W))
  })

  io.out := io.a & io.b
  printf("dut: %d %d %d\n", io.a, io.b, io.out)
}

/**
 * An object extending App to generate the Verilog code.
 */
object And extends App {
  (new chisel3.stage.ChiselStage).emitVerilog(new And())
}
