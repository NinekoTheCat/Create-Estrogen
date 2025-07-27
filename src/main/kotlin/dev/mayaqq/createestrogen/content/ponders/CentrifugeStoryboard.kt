package dev.mayaqq.createestrogen.content.ponders

import com.simibubi.create.foundation.ponder.CreateSceneBuilder
import net.createmod.ponder.api.scene.SceneBuilder
import net.createmod.ponder.api.scene.SceneBuildingUtil
import net.createmod.ponder.api.scene.Selection
import net.minecraft.core.Direction


object CentrifugeScenes {
    fun intro(builder: SceneBuilder, util: SceneBuildingUtil) {
        val scene = CreateSceneBuilder(builder)
        scene.title("intro", "The Centrifuge's Requirements")
        scene.configureBasePlate(0, 0, 5)
        scene.world().showSection(util.select().layer(0), Direction.UP)

        val centrifugePos = util.grid().at(2, 1, 2)
        val centrifuge: Selection = util.select().position(centrifugePos)
        scene.world().showSection(centrifuge, Direction.UP)
        scene.world().setKineticSpeed(centrifuge, 0f)
        scene.idle(5)
        scene.overlay().showText(300)
            .placeNearTarget()
            .text("The centrifuge needs the maximum speed (256 RPM) to work!")
            .pointAt(util.vector().of(2.0, 1.0, 2.0))
        scene.idle(100)

        val speedStuff: Selection = util.select().fromTo(1, 1, 2, 0, 2, 2)
        scene.world().showSection(speedStuff, Direction.DOWN)
        val controller: Selection = util.select().position(0, 1, 2)
        scene.world().setKineticSpeed(controller, 16f)
        scene.world().setKineticSpeed(centrifuge, 256f)

        scene.idle(100)

        scene.markAsFinished()
    }
    fun basic(builder: SceneBuilder, util: SceneBuildingUtil) {
        val scene = CreateSceneBuilder(builder)
        scene.title("basic", "How to use the Centrifuge")
        scene.configureBasePlate(0, 0, 5)
        scene.world().showSection(util.select().layer(0), Direction.UP)

        val centrifugePos = util.grid().at(2, 3, 2)
        val centrifuge = util.select().position(centrifugePos)
        scene.world().setKineticSpeed(centrifuge, 0f)
        scene.world().showSection(centrifuge, Direction.UP)
        scene.addKeyframe()
        scene.overlay().showText(100)
            .placeNearTarget()
            .text("The Centrifuge doesn't have any inventory, you will need to place fluid containers around it to make it work!")
            .pointAt(util.vector().of(2.0, 3.0, 2.0))
        scene.idle(120)
        val fluidInput = util.select().fromTo(2, 1, 2, 2, 2, 2)
        scene.addKeyframe()
        scene.overlay().showText(100)
            .placeNearTarget()
            .text("You can input fluids from the bottom")
            .pointAt(util.vector().of(2.0, 1.0, 2.0))
        scene.world().showSection(fluidInput, Direction.DOWN)
        scene.idle(100)
        val fluidOutput = util.select().fromTo(2, 4, 2, 2, 5, 2)
        scene.addKeyframe()
        scene.overlay().showText(100)
            .placeNearTarget()
            .text("And output fluids from the top")
            .pointAt(util.vector().of(2.0, 5.0, 2.0))
        scene.world().showSection(fluidOutput, Direction.UP)
        scene.idle(100)
        scene.world().setKineticSpeed(centrifuge, 256f)
        scene.idle(50)

        scene.markAsFinished()

    }
}