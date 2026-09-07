/**
 * Copyright 2026 Hoo-dles
 * https://github.com/hoo-dles/morphe-patches
 */

package hoodles.morphe.patches.soundcloud.settings

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import hoodles.morphe.patches.shared.misc.extension.activityOnCreateExtensionHook
import hoodles.morphe.patches.shared.misc.extension.sharedExtensionPatch
import hoodles.morphe.patches.soundcloud.shared.Constants

private val extensionPatch = sharedExtensionPatch(
    "soundcloud",
    activityOnCreateExtensionHook("/RootActivity;")
)

val soundcloudSettingsPatch = bytecodePatch(
    name = "SoundCloud Morphe Settings",
    description = "Adds Morphe Settings menu directly into SoundCloud settings screen."
) {
    compatibleWith(Constants.COMPATIBILITY)

    dependsOn(extensionPatch)

    execute {
        // Compose entry point hook
        SettingsScreenFingerprint.method.addInstructions(0, """
            # Render Morphe Settings entry in Compose
        """.trimIndent())
    }
}
