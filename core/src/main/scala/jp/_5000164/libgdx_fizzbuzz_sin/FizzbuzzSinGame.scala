package jp._5000164.libgdx_fizzbuzz_sin

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.{GL20, OrthographicCamera}
import com.badlogic.gdx.{Game, Gdx, Screen}
import scala.math.sin

class FizzbuzzSinGame extends Game {
  override def create() {
    setScreen(new TitleScreen(this))
  }
}

class TitleScreen(game: FizzbuzzSinGame) extends Screen {
  lazy val camera = new OrthographicCamera()
  camera.setToOrtho(false, 800, 480)
  lazy val shapeRenderer = new ShapeRenderer()
  var renderCount = 0

  override def render(delta: Float) {
    Gdx.gl.glClearColor(0, 0, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    camera.update()

    shapeRenderer.setProjectionMatrix(camera.combined)
    shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)

    val base_x = renderCount.toDouble * 5
    var base_y = 0.0

    for (i <- 1 to 1024) {
      val x = (i * 50) - base_x
      val y = ((sin(base_y) * 200) + 240).toInt
      shapeRenderer.rect(x.toFloat, y.toFloat, 1f, 1f)
      base_y += 0.25
    }

    shapeRenderer.end()

    renderCount += 1
  }


  override def resize(width: Int, height: Int) {}

  override def show() {}

  override def hide() {}

  override def pause() {}

  override def resume() {}

  override def dispose() {}
}