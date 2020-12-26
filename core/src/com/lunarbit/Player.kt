package com.lunarbit

import com.badlogic.gdx.Input
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.graphics.g3d.ModelBatch
import com.badlogic.gdx.math.Vector3

class Player: InputProcessor {
    companion object {
        const val SPECTATOR = "spectator"
        const val NORMAL = "normal"
    }
    private val WIDTH = 5f
    private val HEIGHT = 5f
    private val DEPTH = 5f

    private val velocity = .32f
    private val rotate_vel = .44f

    private val body = BoxMaker(WIDTH, HEIGHT, DEPTH).getModel()

    var mode = NORMAL

    fun translate(x: Float, y: Float, z: Float) {
        body.transform.translate(x, y, z)
    }

    fun getPosition(): Vector3 {
        val vec = Vector3()
        body.transform.getTranslation(vec)
        return vec
    }

    fun rotateX(vel: Float) {
        body.transform.rotate(Vector3(1f, 0f, 0f), vel)
    }
    fun rotateY(vel: Float) {
        body.transform.rotate(Vector3(0f, 1f, 0f), vel)
    }
    fun rotateZ(vel: Float) {
        body.transform.rotate(Vector3(0f, 0f, 1f), vel)
    }


    fun getEyesPosition(): Vector3 {
        val x = getPosition().x
        val y = getPosition().y
        val z = getPosition().z

        return Vector3(x + WIDTH * 0.5f, y + HEIGHT * 0.9f, z + DEPTH)
    }

    fun changeMode(newMode: String) {
        mode = newMode
    }

    fun render(batch: ModelBatch) {
        batch.render(body)

        when {
            Events.ACT_SPECTOR -> changeMode(SPECTATOR)
            Events.ACT_NORMAL -> changeMode(NORMAL)
            Events.ACT_FRONT -> translate(0f, 0f, -velocity)
            Events.ACT_BACK -> translate(0f, 0f, velocity)
            Events.ACT_RIGHT -> translate(velocity, 0f, 0f)
            Events.ACT_LEFT -> translate(-velocity, 0f, 0f)
            Events.ACT_ROTATE_RIGHT -> rotateY(rotate_vel)
            Events.ACT_ROTATE_LEFT -> rotateY(-rotate_vel)
        }


    }

    override fun keyDown(keycode: Int): Boolean {


        return true
    }

    override fun keyUp(keycode: Int): Boolean {
        return true
    }

    override fun keyTyped(character: Char): Boolean {
        return true
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return true
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return true
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        return true
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
        return true
    }

    override fun scrolled(amountX: Float, amountY: Float): Boolean {
        return true
    }


}