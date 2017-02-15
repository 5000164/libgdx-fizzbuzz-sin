package jp._5000164.libgdx_fizzbuzz_sin

import com.badlogic.gdx.backends.lwjgl.{LwjglApplication, LwjglApplicationConfiguration}

object Main extends App {
  val cfg = new LwjglApplicationConfiguration
  cfg.title = "libgdx-fizzbuzz-sin"
  cfg.height = 480
  cfg.width = 800
  cfg.forceExit = false
  new LwjglApplication(new FizzbuzzSinGame, cfg)
}
