/**
 * Copyright 2026 Hoo-dles
 * https://github.com/hoo-dles/morphe-patches
 */

package hoodles.morphe.patches.soundcloud.download

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import hoodles.morphe.patches.shared.misc.extension.activityOnCreateExtensionHook
import hoodles.morphe.patches.shared.misc.extension.sharedExtensionPatch
import hoodles.morphe.patches.soundcloud.shared.Constants

private val extensionPatch = sharedExtensionPatch(
    "soundcloud",
    activityOnCreateExtensionHook("/RootActivity;")
)

val soundcloudDownloadHookPatch = bytecodePatch(
    name = "SoundCloud custom download routing",
    description = "Routes track and playlist download actions to an external downloader package."
) {
    compatibleWith(Constants.COMPATIBILITY)

    dependsOn(extensionPatch)

    execute {
        // Intercept track page download click
        TrackDownloadClickFingerprint.method.addInstructions(0, """
            check-cast p1, Lcom/soundcloud/android/trackpage/TrackPageView${'$'}DownloadClick;
            iget-object v0, p1, Lcom/soundcloud/android/trackpage/TrackPageView${'$'}DownloadClick;->a:Lcom/soundcloud/android/foundation/domain/TrackUrn;
            iget-object v1, p0, Lcom/soundcloud/android/trackpage/TrackDetailsPagePresenter${'$'}subscribeForDownloadClick${'$'}1;->a:Lcom/soundcloud/android/trackpage/TrackPageFragment;
            invoke-virtual {v1}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;
            move-result-object v1
            invoke-static {v1, v0}, Lhoodles/morphe/extension/soundcloud/download/DownloadButtonHook;->tryShareRemembered(Landroid/content/Context;Ljava/lang/Object;)Z
            move-result v0
            if-eqz v0, :cond_skip_dl
            return-void
            :cond_skip_dl
        """.trimIndent())

        // Hide downloads in library links
        LibraryDownloadsViewHolderFingerprint.method.addInstructions(0, """
            iget-object v0, p0, Lcom/soundcloud/android/features/library/LibraryLinksViewHolder;->a:Lcom/soundcloud/android/ui/components/actionlists/ActionListItem;
            invoke-static {v0}, Lhoodles/morphe/extension/soundcloud/download/DownloadButtonHook;->applyLibraryDownloadsVisibility(Landroid/view/View;)V
        """.trimIndent())
    }
}
