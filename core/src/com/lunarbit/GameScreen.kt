package com.lunarbit

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.PerspectiveCamera
import com.badlogic.gdx.graphics.g3d.ModelBatch
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController

class GameScreen(val core: Core): Screen {
    var FoV = 65f

    lateinit var universe: Universe
    lateinit var cam: CameraInputController
    lateinit var normal_cam: PerspectiveCamera
    lateinit var batch: ModelBatch
    lateinit var inputs: InputMultiplexer
    lateinit var player: Player

    override fun show() {
        inputs = InputMultiplexer()
        Gdx.input.inputProcessor = inputs

        val underCamera = PerspectiveCamera(FoV, Gdx.graphics.width * 1f, Gdx.graphics.height * 1f)
        underCamera.far = 300f
        underCamera.near = 1f
        underCamera.position.set(10f, 10f, 10f)
        underCamera.lookAt(0f, 0f, 0f)
        underCamera.update()
        cam = CameraInputController(underCamera)
        cam.translateUnits = 5f
        cam.rotateAngle = 90f

        normal_cam = PerspectiveCamera(FoV, Gdx.graphics.width * 1f, Gdx.graphics.height * 1f)
        normal_cam.far = 300f
        normal_cam.near = 1f
        normal_cam.position.set(5f, 5f, 5f)
        normal_cam.lookAt(1f, 1f, 1f)

        universe = Universe(this)
        batch = ModelBatch()
        player = Player()

        inputs.addProcessor(cam)
        inputs.addProcessor(Events)
    }

    override fun render(delta: Float) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)
        Gdx.gl.glClearColor(0.3f, 0.5f, 0.7f, 1f)

        if (player.mode == Player.SPECTATOR)
            drawUniverse(cam.camera)
        else
            drawUniverse(normal_cam)

        player.render(batch)
        cam.update()
        normal_cam.update()

        normal_cam.position.set(player.getEyesPosition())
    }
    fun drawUniverse(camera: Camera) {
        batch.begin(camera)
        for (renderable in universe.renderablesInUniverse) {
            batch.render(renderable.first, renderable.second)
        }
        batch.end()
    }
    override fun resize(width: Int, height: Int) {

    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun hide() {
    }

    override fun dispose() {
    }

}