package projeto

case class MyRandom(seed: Long) extends Randoms {
  def nextInt: (Int, Randoms) = {
    val newSeed = (seed * 0x5DEECE66DL + 0xBL) &
      0xFFFFFFFFFFFFL
    val nextRandom = MyRandom(newSeed)
    val n = (newSeed >>> 16).toInt
    (n, nextRandom)
  }



}
