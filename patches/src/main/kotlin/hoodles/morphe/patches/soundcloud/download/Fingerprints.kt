/**
 * Copyright 2026 Hoo-dles
 * https://github.com/hoo-dles/morphe-patches
 */

package hoodles.morphe.patches.soundcloud.download

import app.morphe.patcher.Fingerprint
import com.android.tools.smali.dexlib2.AccessFlags

object TrackFetchDataFingerprint : Fingerprint(
    definingClass = "Lcom/soundcloud/android/trackpage/TrackDetailsPagePresenter\$fetchData\$2;",
    name = "apply",
    parameters = listOf("Ljava/lang/Object;", "Ljava/lang/Object;"),
    returnType = "Ljava/lang/Object;"
)

object TrackDownloadClickFingerprint : Fingerprint(
    definingClass = "Lcom/soundcloud/android/trackpage/TrackDetailsPagePresenter\$subscribeForDownloadClick\$1;",
    name = "accept",
    parameters = listOf("Ljava/lang/Object;")
)

object TrackDownloadStateFingerprint : Fingerprint(
    definingClass = "Lcom/soundcloud/android/trackpage/TrackDetailsPagePresenter\$toPageResultObservable\$1\$7\$1;",
    name = "apply"
)

object PlaylistLoaderFingerprint : Fingerprint(
    definingClass = "Lcom/soundcloud/android/features/bottomsheet/playlist/PlaylistBottomSheetViewModel\$playlistLoader\$1\$3;",
    name = "a",
    parameters = listOf("Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/Object;")
)

object PlaylistEngagementsRendererFingerprint : Fingerprint(
    definingClass = "Lcom/soundcloud/android/playlist/view/renderers/PlaylistEngagementsPlayableRenderer;",
    name = "a"
)

object LibraryDownloadsViewHolderFingerprint : Fingerprint(
    definingClass = "Lcom/soundcloud/android/features/library/LibraryLinksViewHolder;",
    name = "bindItem"
)
