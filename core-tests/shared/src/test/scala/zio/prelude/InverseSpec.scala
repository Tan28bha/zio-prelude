package zio.prelude

import zio.prelude.laws.InverseLaws
import zio.prelude.newtypes.Sum
import zio.test.laws._
import zio.test.{DefaultRunnableSpec, _}

object InverseSpec extends DefaultRunnableSpec {

  private implicit val DoubleEqual: Equal[Double] = Equal.DoubleEqualWithEpsilon()
  private implicit val FloatEqual: Equal[Float]   = Equal.FloatEqualWithEpsilon()

  def spec: ZSpec[Environment, Failure] =
    suite("InverseSpec")(
      suite("laws")(
        test("byte addition")(checkAllLaws(InverseLaws)(Gen.byte.map(Sum(_)))),
        test("char addition")(checkAllLaws(InverseLaws)(Gen.char.map(Sum(_)))),
        test("double addition")(checkAllLaws(InverseLaws)(Gen.double.map(Sum(_)))),
        test("float addition")(checkAllLaws(InverseLaws)(Gen.float.map(Sum(_)))),
        test("int addition")(checkAllLaws(InverseLaws)(Gen.int.map(Sum(_)))),
        test("long addition")(checkAllLaws(InverseLaws)(Gen.long.map(Sum(_)))),
        test("set")(checkAllLaws(InverseLaws)(Gen.setOf(Gen.int))),
        test("short addition")(checkAllLaws(InverseLaws)(Gen.short.map(Sum(_)))),
        test("tuple2")(checkAllLaws(InverseLaws)(Gen.int.map(Sum(_)).zip(Gen.int.map(Sum(_))))),
        test("tuple3")(
          checkAllLaws(InverseLaws)(Gen.int.map(Sum(_)).zip(Gen.int.map(Sum(_))).zip(Gen.int.map(Sum(_))))
        )
      )
    )
}
