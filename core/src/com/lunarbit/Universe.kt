package com.lunarbit

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.VertexAttributes
import com.badlogic.gdx.graphics.g3d.*
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder
import com.badlogic.gdx.graphics.g3d.Environment
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight


class Universe(val gameScreen: GameScreen) {
    val renderablesInUniverse = mutableListOf<Pair<ModelInstance, Environment>>()

    init {
        var environment = Environment()
        environment.set(ColorAttribute.createDiffuse(1f, 1f, 1f, 1f))

        val semiBox = BoxMaker(5f, 5f, 5f)
        semiBox.setMaterial(Material(ColorAttribute.createDiffuse(Color.MAGENTA)))
        val box = semiBox.getModel()

        val semiSphere = SphereMaker(5f, 5f, 5f)
        semiSphere.setMaterial(Material(ColorAttribute.createDiffuse(Color.LIME)))
        val sphere = semiSphere.getModel()
        sphere.transform.translate(9f, 3f, 3f)


        renderablesInUniverse.add(Pair(box, environment))
        renderablesInUniverse.add(Pair(sphere, environment))
    }
}