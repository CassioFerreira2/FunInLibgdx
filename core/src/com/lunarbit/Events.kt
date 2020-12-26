package com.lunarbit

import com.badlogic.gdx.Input
import com.badlogic.gdx.InputProcessor

object Events: InputProcessor {
    private val TO_SPECTOR = Input.Keys.O
    private val TO_NORMAL = Input.Keys.P
    private val TO_RIGHT = Input.Keys.RIGHT
    private val TO_LEFT = Input.Keys.LEFT
    private val TO_FRONT = Input.Keys.UP
    private val TO_BACK = Input.Keys.DOWN
    private val ROTATE_RIGHT = Input.Keys.X
    private val ROTATE_LEFT = Input.Keys.Z

    var ACT_SPECTOR = false
    var ACT_NORMAL = false
    var ACT_RIGHT = false
    var ACT_LEFT = false
    var ACT_FRONT = false
    var ACT_BACK = false
    var ACT_ROTATE_RIGHT = false
    var ACT_ROTATE_LEFT = false

    override fun keyDown(keycode: Int): Boolean {
        when (keycode) {
            TO_SPECTOR -> ACT_SPECTOR = true
            TO_NORMAL -> ACT_NORMAL = true
            TO_RIGHT -> ACT_RIGHT = true
            TO_LEFT -> ACT_LEFT = true
            TO_FRONT -> ACT_FRONT = true
            TO_BACK -> ACT_BACK = true
            ROTATE_RIGHT -> ACT_ROTATE_RIGHT = true
            ROTATE_LEFT -> ACT_ROTATE_LEFT = true
        }

        return false
    }

    override fun keyUp(keycode: Int): Boolean {
        when (keycode) {
            TO_SPECTOR -> ACT_SPECTOR = false
            TO_NORMAL -> ACT_NORMAL = false
            TO_RIGHT -> ACT_RIGHT = false
            TO_LEFT -> ACT_LEFT = false
            TO_FRONT -> ACT_FRONT = false
            TO_BACK -> ACT_BACK = false
            ROTATE_RIGHT -> ACT_ROTATE_RIGHT = false
            ROTATE_LEFT -> ACT_ROTATE_LEFT = false
        }
        return false
    }

    override fun keyTyped(character: Char): Boolean {
        return false
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        return false
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
        return false
    }

    override fun scrolled(amountX: Float, amountY: Float): Boolean {
        return false
    }


}