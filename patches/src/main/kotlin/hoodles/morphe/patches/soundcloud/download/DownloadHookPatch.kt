package hoodles.morphe.patches.soundcloud.download

import app.morphe.patcher.patch.bytecodePatch
import hoodles.morphe.patches.soundcloud.shared.Constants

/**
 * Restores the custom SoundCloud download routing extension.
 *
 * The APK analysis identified the custom extension classes:
 * app.morphe.extension.soundcloud.DownloadButtonHook
 * app.morphe.extension.soundcloud.DownloadHookSettings
 *
 * The actual application-specific hook injection is kept fingerprint based.
 */
val soundcloudDownloadHookPatch = bytecodePatch(
    name = "SoundCloud custom download routing",
    description = "Routes track/set/playlist actions to the configured downloader package."
) {
    compatibleWith(Constants.COMPATIBILITY)
}
