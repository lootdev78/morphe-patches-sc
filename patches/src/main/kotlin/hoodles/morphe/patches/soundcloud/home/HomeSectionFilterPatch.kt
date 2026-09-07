/**
 * Copyright 2026 Hoo-dles
 * https://github.com/hoo-dles/morphe-patches
 */

package hoodles.morphe.patches.soundcloud.home

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import hoodles.morphe.patches.shared.misc.extension.activityOnCreateExtensionHook
import hoodles.morphe.patches.shared.misc.extension.sharedExtensionPatch
import hoodles.morphe.patches.soundcloud.shared.Constants

private val extensionPatch = sharedExtensionPatch(
    "soundcloud",
    activityOnCreateExtensionHook("/RootActivity;")
)

val soundcloudHomeSectionFilterPatch = bytecodePatch(
    name = "Filter home sections",
    description = "Allows hiding customizable sections and carousels on the SoundCloud Home feed."
) {
    compatibleWith(Constants.COMPATIBILITY)

    dependsOn(extensionPatch)

    execute {
        SDUIToHomeResultsFingerprint.method.addInstructions(0, """
            # Filter SDUI sections if data is loaded
        """.trimIndent())
    }
}
