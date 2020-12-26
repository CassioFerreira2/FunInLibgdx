package com.lunarbit

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.VertexAttributes
import com.badlogic.gdx.graphics.g3d.Material
import com.badlogic.gdx.graphics.g3d.ModelInstance
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder

class BoxMaker(val width: Float, val height: Float, val depth: Float) {
    private val box: ModelInstance

    init {
        val model = ModelBuilder().createBox(width, height, depth, Material(),
                VertexAttributes.Usage.Position * 1L)
        box = ModelInstance(model)
    }

    fun setMaterial(material: Material) {
        box.materials[0].set(material)
    }

    fun getModel(): ModelInstance {
        return box
    }


}