circuit And :
  module And :
    input clock : Clock
    input reset : UInt<1>
    output io : { out : UInt<2>, flip a : UInt<2>, flip b : UInt<2>}

    node _io_out_T = and(io.a, io.b) @[And.scala 10:18]
    io.out <= _io_out_T @[And.scala 10:10]
    node _T = bits(reset, 0, 0) @[And.scala 11:9]
    node _T_1 = eq(_T, UInt<1>("h0")) @[And.scala 11:9]
    when _T_1 : @[And.scala 11:9]
      printf(clock, UInt<1>("h1"), "dut: %d %d %d\n", io.a, io.b, io.out) : printf @[And.scala 11:9]


