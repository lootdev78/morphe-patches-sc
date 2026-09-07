/**
 * Copyright 2026 Hoo-dles
 * https://github.com/hoo-dles/morphe-patches
 */

package hoodles.morphe.patches.soundcloud.ui

import app.morphe.patcher.Fingerprint

object TitleBarUploadFingerprint : Fingerprint(
    definingClass = "Lcom/soundcloud/android/creators/uploadv2/pub/titlebar/TitleBarUploadController;",
    name = "a"
)

object TitleBarInboxFingerprint : Fingerprint(
    definingClass = "Lcom/soundcloud/android/messages/inbox/titlebar/TitleBarInboxController;",
    name = "a"
)

object TitleBarActivityFeedFingerprint : Fingerprint(
    definingClass = "Lcom/soundcloud/android/activity/feed/titlebar/TitleBarActivityFeedController;",
    name = "a"
)

object DefaultCastButtonInstallerFingerprint : Fingerprint(
    definingClass = "Lcom/soundcloud/android/cast/ui/DefaultCastButtonInstaller;",
    name = "a"
)
