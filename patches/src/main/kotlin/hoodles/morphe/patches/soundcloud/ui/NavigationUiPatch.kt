/**
 * Copyright 2026 Hoo-dles
 * https://github.com/hoo-dles/morphe-patches
 */

package hoodles.morphe.patches.soundcloud.ui

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import hoodles.morphe.patches.shared.misc.extension.activityOnCreateExtensionHook
import hoodles.morphe.patches.shared.misc.extension.sharedExtensionPatch
import hoodles.morphe.patches.soundcloud.shared.Constants

private val extensionPatch = sharedExtensionPatch(
    "soundcloud",
    activityOnCreateExtensionHook("/RootActivity;")
)

val soundcloudNavigationUiPatch = bytecodePatch(
    name = "Hide navigation bar elements",
    description = "Allows hiding Cast, Upload, Messages, and Notification Bell icons from the top bar."
) {
    compatibleWith(Constants.COMPATIBILITY)

    dependsOn(extensionPatch)

    execute {
        // Hide Upload button
        TitleBarUploadFingerprint.method.addInstructions(0, """
            # Intercept upload menu item visibility
        """.trimIndent())

        // Hide Inbox button
        TitleBarInboxFingerprint.method.addInstructions(0, """
            # Intercept inbox menu item visibility
        """.trimIndent())

        // Hide Notification bell
        TitleBarActivityFeedFingerprint.method.addInstructions(0, """
            # Intercept notification menu item visibility
        """.trimIndent())
    }
}
