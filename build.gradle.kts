@file:Suppress("PropertyName", "UnstableApiUsage")

import dev.mayaqq.multijarfixer.FixMultiRelease
import net.msrandom.stubs.GenerateStubApi
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.cloche)
    kotlin("jvm") version libs.versions.kotlin
    kotlin("plugin.serialization") version libs.versions.kotlin
}



repositories {
    cloche.librariesMinecraft()
    maven(url = "https://maven.parchmentmc.org") { name = "Parchment" }
    maven(url = "https://maven.fabricmc.net") { name = "FabricMC" }
    maven(url = "https://maven.terraformersmc.com/releases/") { name = "TerraformersMC" }
    maven(url = "https://thedarkcolour.github.io/KotlinForForge/") { name = "KotlinForForge" }
    maven(url = "https://maven.minecraftforge.net/") { name = "Forge" }
    maven(url = "https://maven.teamresourceful.com/repository/maven-public/") { name = "Team Resourceful" }
    maven(url = "https://maven.shedaniel.me") { name = "Shedaniel" }
    maven(url = "https://maven.blamejared.com/") { name = "Blamejared" }
    maven(url = "https://maven.createmod.net/") { name = "Create" }
    maven(url = "https://maven.tterrag.com") { name = "Tterrag" }
    maven(url = "https://maven.theillusivec4.top/") { name = "TheIllusivec4" }
    maven(url = "https://mvn.devos.one/snapshots/") { name = "Devos Maven"; description = "Create Fabric, Porting Lib, Forge Tags, Milk Lib & Fabric Registrate" }
    maven(url = "https://cursemaven.com") { name = "Curseforge Maven"; description = "Forge Config API Port" }
    maven(url = "https://maven.is-immensely.gay/nightly") { name = "Sappho Company"; description = "Critter, Cynosure" }
    maven(url = "https://maven.is-immensely.gay/releases") { name = "Sappho Company"; description = "Kittyconfig" }
    maven(url = "https://maven.cafeteria.dev/releases") { name = "Cafeteria Maven"; description = "Fake Player API" }
    maven(url = "https://maven.jamieswhiteshirt.com/libs-release") { name = "JamiesWhiteShirt Maven"; description = "Reach Entity Attributes" }
    maven(url = "https://maven.ladysnake.org/releases") { name = "Ladysnake Maven"; description = "Trinkets" }
    maven(url = "https://repo.unascribed.com") { name = "Unascribed Maven"; description = "Ears" }
    maven(url = "https://api.modrinth.com/maven") { name = "Modrinth Maven"; description = "Jukeboxfix, Ad Astra" }
    maven(url = "https://pkgs.dev.azure.com/djtheredstoner/DevAuth/_packaging/public/maven/v1") { name = "DevAuth maven"; description = "DevAuth" }
    maven(url = "https://maven.isxander.dev/releases") { name = "Xander maven"; description = "YACL" }
    maven(url = "https://maven.impactdev.net/repository/development/") { name = "ImpactDev Maven"; description = "Cobblemon" }
    maven(url = "https://maven.squiddev.cc") { name = "Squid Maven"; description = "Create needs CC: Tweaked for some reason" }
    maven(url = "https://maven.msrandom.net/repository/root") { name = "Ashley"}
    maven(url = "https://maven.figuramc.org/releases") { name = "Figura Maven"; description = "Figura" } // Second last cs figura misconfigured their maven
    maven(url = "https://jitpack.io/") { name = "Jitpack maven"; description = "Mixin Extras & Fabric ASM" } //NOTE: LEAVE THIS AS LAST
    mavenLocal()
    mavenCentral()
}

val item_viewer: String by project

val devauth_enabled: String by project


dependencies {
//    ksp(libs.kittyconfig.ksp)
}
cloche {
    metadata {
        modId = "createestrogen"
        name = "Create: Estrogen"
        description = "Create module for Estrogen"
        license = "LGPL-3.0"
        icon = "assets/createestrogen/icon.png"
        url = "https://github.com/MayaqqDev/Create-Estrogen"
        sources = "https://github.com/MayaqqDev/Create-Estrogen"
        author("Mayaqq")
        contributor("https://github.com/MayaqqDev/Estrogen/wiki/Credits")
    }

    mappings {
        official()
        parchment(libs.versions.parchment)
    }

    common {
        data {

        }
        test {

        }
        kotlin {
            sourceSets.main {
                kotlin.srcDir("build/generated/ksp/main/kotlin")
                kotlin.srcDir("build/generated/ksp/main/stubs")
            }
        }
//        mixins.from(file("src/main/createestrogen.mixins.json"))

        accessWideners.from(file("src/main/createestrogen.accessWidener"))
        dependencies {
            compileOnly(libs.mixin)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlinx.coroutines.core)
            api(libs.flywheel.api)
//            modImplementation(libs.baubly)
            modCompileOnly(libs.createNewAge)
//            modImplementation(libs.kittyconfig)
            implementation(libs.mixinExtras)
            annotationProcessor(libs.mixinExtras)
            modCompileOnly(libs.kritter)
            modCompileOnly(libs.cynosure)
            modCompileOnly(libs.ponder)
            implementation(libs.mixinConstrains)
            modCompileOnly(libs.forge.create) {
                artifact {
                    classifier = "slim"
                }
                isTransitive = false
            }
            modCompileOnly(libs.forge.registrate)


        }
    }

//    fabric {
////        mixins.from(file("src/main/createestrogen.mixins.json"))
//        accessWideners.from(file("src/main/createestrogen.accessWidener"))
//
//        loaderVersion = libs.versions.fabric
//        minecraftVersion = libs.versions.minecraft
//
//        include(libs.fabric.baubly) { exclude(group = "me.shedaniel") }
//        include(libs.fabric.kritter)
//        include(libs.fabric.flywheel)
//        //include(libs.fabric.kittyconfig)
//
//        include(libs.mixinConstrains)
//
//        includedClient() // includedClient() is not a run
//        runs {
//            val paths = listOf(
//                "build/classes/java/fabric",
//                "build/classes/kotlin/fabric",
//                "build/generated/ksp/fabric/classes",
//                "build/resources/fabric"
//            ).joinToString(if (Os.isFamily(Os.FAMILY_WINDOWS)) ";" else ":") { project.file(it).absolutePath }
//            client {
//                jvmArgs("-Dfabric.classPathGroups=$paths")
//            }
//            server {
//                jvmArgs("-Dfabric.classPathGroups=$paths")
//            }
//        }
//
//        metadata {
//            metadata {
//                custom("modmenu", mapOf(
//                    "links" to mapOf(
//                        "estrogen.credits" to "https://github.com/MayaqqDev/Estrogen/wiki/Credits",
//                        "modmenu.discord" to "https://discord.gg/hue",
//                        "modmenu.kofi" to "https://ko-fi.com/mayaqq",
//                        "modmenu.curseforge" to "https://www.curseforge.com/minecraft/mc-mods/createestrogen",
//                        "modmenu.modrinth" to "https://modrinth.com/mod/createestrogen",
//                        "modmenu.wiki" to "https://github.com/MayaqqDev/Estrogen/wiki"
//                    )
//                ))
//                custom("cynosure", mapOf(
//                    "autosubscription" to true
//                ))
//                custom("catalogue", mapOf(
//                    "icon" to mapOf("item" to "estrogen:estrogen_pill"),
//                    "banner" to "icon.png",
//                    "background" to "estrogen_background.png",
//                    "configFactory" to "dev.mayaqq.createestrogen.fabric.integrations.catalogue.CatalogueCompat"
//                ))
//            }
//        }
//
//        dependencies {
//            fabricApi(libs.versions.fapi)
//            modApi(libs.fabric.kotlin)
//            modApi.bundle(libs.bundles.fabric.cardinalComponents)
//            modImplementation(libs.fabric.baubly) { exclude(group = "me.shedaniel") }
//            modImplementation(libs.fabric.trinkets)
//            modCompileOnly(libs.fabric.emi)
//            modCompileOnly(libs.fabric.rei)
//            modCompileOnly(libs.fabric.jei)
//            modImplementation(libs.fabric.modmenu)
//            modCompileOnly(libs.fabric.iris)
//            modCompileOnly(libs.ponder)
//            modCompileOnlyApi(libs.fabric.flywheel.api)
//            modImplementation(libs.fabric.flywheel)
//            modImplementation(libs.fabric.cynosure)
//            modImplementation(libs.fabric.kritter)
//            modApi(libs.fabric.botarium)
//            //modApi(libs.fabric.kittyconfig)
//
//            when(item_viewer) {
//                "REI" -> modRuntimeOnly(libs.fabric.rei) { exclude(group = "net.fabricmc") }
//                "EMI" -> modRuntimeOnly(libs.fabric.emi)
//                "JEI" -> modRuntimeOnly(libs.fabric.jei)
//                "disabled" -> {}
//                else -> error("Invalid item viewer for Fabric: $item_viewer")
//            }
//
//            if (devauth_enabled.toBoolean()) modRuntimeOnly(libs.fabric.devauth)
//        }
//
//        metadata {
//            entrypoint("main") {
//                adapter.set("kotlin")
//                value.set("dev.mayaqq.createestrogen.fabric.CreateEstrogenFabric::init")
//            }
//            entrypoint("client") {
//                adapter.set("kotlin")
//                value.set("dev.mayaqq.createestrogen.fabric.client.CreateEstrogenClientFabric::init")
//            }
//            entrypoint("emi") {
//                adapter.set("kotlin")
//                value.set("dev.mayaqq.createestrogen.compat.emi.EmiCreateEstrogenPlugin")
//            }
//            entrypoint("rei_client") {
//                adapter.set("kotlin")
//                value.set("dev.mayaqq.createestrogen.compat.rei.ReiCreateEstrogenPlugin")
//            }
//            entrypoint("jei_mod_plugin") {
//                adapter.set("kotlin")
//                value.set("dev.mayaqq.createestrogen.compat.jei.JeiCreateEstrogenPlugin")
//            }
//        }
//    }
    forge {
        datagenDirectory = file("src/main/generated")
        data()
        test {

        }
//        mixins.from(file("src/main/createestrogen.mixins.json"))
        accessWideners.from(file("src/main/createestrogen.accessWidener"))

        loaderVersion = libs.versions.forge.get()
        minecraftVersion = libs.versions.minecraft.get()
        include(libs.forge.baubly) { exclude(group = "me.shedaniel") }
        include(libs.forge.mixinExtras)
        include(libs.forge.kritter)
        include(libs.mixinConstrains)
        metadata {
            blurLogo = false
//            modProperty("catalogueItemIcon", "estrogen:estrogen_pill")
//            modProperty("catalogueBackground", "estrogen_background.png")
        }

        runs {
            data()
            client {
//                setProperty("mixin.env.remapRefMap",true)
//                setProperty("mixin.env.refMapRemappingFile", "${projectDir}/build/createSrgToMcp/output.srg")
            }
            test() {
                client {

                }
            }
            server()
        }

        dependencies {
            api(libs.forge.kotlin)
            modCompileOnlyApi(libs.forge.flywheel.api)
            modImplementation(libs.forge.flywheel)
            modImplementation(libs.forge.baubly) { exclude(group = "me.shedaniel") }
            modCompileOnly(libs.forge.rei)
            implementation(libs.forge.mixinExtras)
            compileOnlyApi(libs.forge.jei)
            modCompileOnly(libs.forge.emi)
            modImplementation(libs.forge.cynosure)
            modImplementation(libs.forge.kritter)
            modImplementation(libs.forge.create) {
                artifact {
                    classifier = "slim"
                }
                isTransitive = false
            }
            modApi(libs.forge.botarium)
            modImplementation(libs.forge.ponder)
            modImplementation(libs.forge.registrate)
            //modApi(libs.forge.kittyconfig)

            when(item_viewer) {
                "EMI" -> modRuntimeOnly(libs.forge.emi)
                "REI" -> modRuntimeOnly(libs.forge.rei)
                "JEI" -> modRuntimeOnly(libs.forge.jei)
                "disabled" -> {}
                else -> error("Invalid item viewer for Forge: $item_viewer")
            }

            if (devauth_enabled.toBoolean()) modRuntimeOnly(libs.forge.devauth)
        }
    }
}

val fixedAttribute = Attribute.of("fixed-jar", Boolean::class.javaObjectType)

dependencies {
    registerTransform(FixMultiRelease::class) {
        from.attribute(ArtifactTypeDefinition.ARTIFACT_TYPE_ATTRIBUTE, ArtifactTypeDefinition.JAR_TYPE).attribute(fixedAttribute, false)
        to.attribute(ArtifactTypeDefinition.ARTIFACT_TYPE_ATTRIBUTE, ArtifactTypeDefinition.JAR_TYPE).attribute(fixedAttribute, true)
    }

    artifactTypes {
        named(ArtifactTypeDefinition.JAR_TYPE) {
            attributes.attribute(fixedAttribute, false)
        }
    }
}
tasks.named { it == "kspFabricKotlin" || it == "kspForgeKotlin"}.configureEach { enabled = false }
configurations.named("forgeRuntimeClasspath") {
    attributes {
        attribute(fixedAttribute, true)
    }
}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
    withSourcesJar()
}
tasks.compileJava {
    options.compilerArgs.add("-AgenerateExpectStubs")
}

tasks.withType<KotlinCompile> {
//    explicitApiMode = org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode.Warning
    compilerOptions {
        languageVersion = KotlinVersion.KOTLIN_2_0
        freeCompilerArgs = listOf("-Xmulti-platform", "-Xno-check-actual", "-Xexpect-actual-classes")
    }
}
kotlin {
    compilerOptions {
        languageVersion = KotlinVersion.KOTLIN_2_0
        freeCompilerArgs = listOf("-Xmulti-platform", "-Xno-check-actual", "-Xexpect-actual-classes")
    }
    jvmToolchain(17)
}

tasks.named("createCommonApiStub", GenerateStubApi::class) {
    excludes.add(libs.kritter.get().group)
    excludes.add(libs.cynosure.get().group)
}
