package jp._5000164.libgdx_fizzbuzz_sin

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.{GL20, OrthographicCamera}
import com.badlogic.gdx.{Game, Gdx, Screen}
import scala.math.sin

class FizzbuzzSinGame extends Game {
  val windowWidth: Float = 800
  val windowHeight: Float = 480
  val centerX: Float = 400
  val centerY: Float = 240

  override def create() {
    setScreen(new TitleScreen(this))
  }
}

class TitleScreen(game: FizzbuzzSinGame) extends Screen {
  lazy val camera = new OrthographicCamera()
  camera.setToOrtho(false, game.windowWidth, game.windowHeight)
  lazy val shapeRenderer = new ShapeRenderer()
  var renderCount = 0

  override def render(delta: Float) {
    Gdx.gl.glClearColor(0, 0, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    camera.position.set(game.centerX + (renderCount * 5), game.centerY, 0)
    camera.update()

    shapeRenderer.setProjectionMatrix(camera.combined)
    shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)

    var base_y = 0.0
    for (i <- 1 to 1024) {
      val x = i * 50
      val y = ((sin(base_y) * 200) + game.centerY).toInt
      i match {
        case j if j % 15 == 0 => shapeRenderer.rect(x.toFloat - 15f, y.toFloat - 15f, 30f, 30f)
        case j if j % 3 == 0 => shapeRenderer.rect(x.toFloat - 3f, y.toFloat - 3f, 6f, 6f)
        case j if j % 5 == 0 => shapeRenderer.rect(x.toFloat - 5f, y.toFloat - 5f, 10f, 10f)
        case _ => shapeRenderer.rect(x.toFloat, y.toFloat, 1f, 1f)
      }
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
