FIRRTL version 1.1.0
circuit And :
  module And :
    input clock : Clock
    input reset : UInt<1>
    output io_out : UInt<2>
    input io_a : UInt<2>
    input io_b : UInt<2>

    node _io_out_T = and(io_a, io_b) @[And.scala 10:18]
    node _T = bits(reset, 0, 0) @[And.scala 11:9]
    node _T_1 = eq(_T, UInt<1>("h0")) @[And.scala 11:9]
    io_out <= _io_out_T @[And.scala 10:10]
    printf(clock, and(and(UInt<1>("h1"), _T_1), UInt<1>("h1")), "dut: %d %d %d\n", io_a, io_b, io_out) : printf @[And.scala 11:9]
