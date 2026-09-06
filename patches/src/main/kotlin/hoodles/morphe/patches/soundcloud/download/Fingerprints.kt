package hoodles.morphe.patches.soundcloud.download

import app.morphe.patcher.Fingerprint
import com.android.tools.smali.dexlib2.AccessFlags

object TrackDownloadClickFingerprint : Fingerprint(
    definingClass = "TrackDetailsPagePresenter$subscribeForDownloadClick$1",
    strings = listOf("DownloadActionButton")
)

object PlaylistDownloadClickFingerprint : Fingerprint(
    definingClass = "PlaylistBottomSheetViewModel$playlistLoader$1$3",
    strings = listOf("rememberUrl")
)

object ShareIntentFingerprint : Fingerprint(
    definingClass = "a50/b",
    strings = listOf("android.intent.action.VIEW")
)

object NativeDownloadStateFingerprint : Fingerprint(
    definingClass = "DownloadActionButton$State",
    strings = listOf("DOWNLOADED")
)
