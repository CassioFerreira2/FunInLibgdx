package com.lunarbit

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.VertexAttributes
import com.badlogic.gdx.graphics.g3d.Material
import com.badlogic.gdx.graphics.g3d.ModelInstance
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder

class SphereMaker(val width: Float, val height: Float, val depth: Float) {
    private val sphere: ModelInstance

    init {
        val model = ModelBuilder().createSphere(width, height, depth, 55, 55, Material(),
                VertexAttributes.Usage.Position * 1L)
        sphere = ModelInstance(model)
    }

    fun setMaterial(material: Material) {
        sphere.materials[0].set(material)
    }

    fun getModel(): ModelInstance {
        return sphere
    }
}