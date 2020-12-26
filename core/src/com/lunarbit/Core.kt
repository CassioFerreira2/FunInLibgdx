package com.lunarbit

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture

class Core : Game() {
    lateinit var gameScreen: GameScreen

    override fun create() {
        gameScreen = GameScreen(this)
        setScreen(gameScreen)
    }

    override fun render() {
        gameScreen.render(Gdx.graphics.deltaTime)

        super.render()
    }

    override fun dispose() {
        gameScreen.dispose()
    }
}